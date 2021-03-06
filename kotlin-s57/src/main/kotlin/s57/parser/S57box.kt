// License: GPL. For details, see LICENSE file.
package s57.parser

import s57.parser.S57box.Ext.*
import s57.parser.S57map.*
import s57.parser.S57map.Pflag.AREA
import s57.parser.S57map.Pflag.LINE
import s57.parser.S57obj.Obj

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57box {

    private fun getExt(map: S57map, lat: Double, lon: Double): Ext {
        return when {
            lat >= map.bounds.maxlat && lon < map.bounds.maxlon -> N
            lon <= map.bounds.minlon -> W
            lat <= map.bounds.minlat -> S
            lon >= map.bounds.maxlon -> E
            else -> I
        }
    }

    fun bBox(map: S57map) {
        /* Truncations
         * Points: delete point features outside BB
         * Lines: Truncate edges at BB boundaries
         * Areas: Truncate edges of outers & inners and add new border edges. Merge inners to outer where necessary
         * Remove nodes outside BB
         * Remove edges that are completely outside BB
         */
        class Land(var land: Feature) {
            var first: Long
            var start: Snode?
            var sbound: Ext
            var last: Long = 0
            var end: Snode?
            var ebound: Ext

            init {
                first = last
                end = null
                start = end
                ebound = I
                sbound = ebound
            }
        }
        if (map.features[Obj.COALNE] != null) {
            val coasts = arrayListOf<Feature>()
            val lands = arrayListOf<Land>()
            if (map.features[Obj.LNDARE] == null) {
                map.features[Obj.LNDARE] = arrayListOf()
            }
            for (feature in map.features[Obj.COALNE]!!) {
                val land = Feature()
                land.id = ++map.xref
                land.type = Obj.LNDARE
                land.reln = Rflag.MASTER
                land.objs[Obj.LNDARE] = ObjTab()
                land.objs[Obj.LNDARE]!![0] = AttMap()
                if (feature!!.geom.prim == AREA) {
                    land.geom = feature.geom
                    map.features[Obj.LNDARE]!!.add(land)
                } else if (feature.geom.prim == LINE) {
                    land.geom.prim = LINE
                    land.geom.elems.addAll(feature.geom.elems)
                    coasts.add(land)
                }
            }
            while (coasts.size > 0) {
                val land = coasts.removeAt(0)
                val fedge = map.edges[land.geom.elems[0]!!.id]
                var first = fedge!!.first
                var last = map.edges[land.geom.elems[land.geom.elems.size - 1]!!.id]!!.last
                if (coasts.size > 0) {
                    var added = true
                    while (added) {
                        added = false
                        var i = 0
                        while (i < coasts.size) {
                            val coast = coasts[i]
                            val edge = map.edges[coast.geom.elems[0]!!.id]
                            if (edge!!.first == last) {
                                land.geom.elems.add(coast.geom.elems[0])
                                last = edge.last
                                coasts.removeAt(i--)
                                added = true
                            } else if (edge.last == first) {
                                land.geom.elems.add(0, coast.geom.elems[0])
                                first = edge.first
                                coasts.removeAt(i--)
                                added = true
                            }
                            i++
                        }
                    }
                }
                lands.add(Land(land))
            }
            var islands = arrayListOf<Land>()
            for (land in lands) {
                map.sortGeom(land.land)
                if (land.land.geom.prim == AREA) {
                    islands.add(land)
                    map.features[Obj.LNDARE]!!.add(land.land)
                }
            }
            for (island in islands) {
                lands.remove(island)
            }
            for (land in lands) {
                land.first = map.edges[land.land.geom.elems[0]!!.id]!!.first
                land.start = map.nodes[land.first]
                land.sbound = getExt(map, land.start!!.lat, land.start!!.lon)
                land.last = map.edges[land.land.geom.elems[land.land.geom.comps[0]!!.size - 1]!!.id]!!.last
                land.end = map.nodes[land.last]
                land.ebound = getExt(map, land.end!!.lat, land.end!!.lon)
            }
            islands = arrayListOf()
            for (land in lands) {
                if (land.sbound == I || land.ebound == I) {
                    islands.add(land)
                }
            }
            for (island in islands) {
                lands.remove(island)
            }
            for (land in lands) {
                val nedge = Edge()
                nedge.first = land.last
                nedge.last = land.first
                var bound = land.ebound
                while (bound != land.sbound) {
                    bound = when (bound) {
                        N -> {
                            nedge.nodes.add(1L)
                            W
                        }
                        W -> {
                            nedge.nodes.add(2L)
                            S
                        }
                        S -> {
                            nedge.nodes.add(3L)
                            E
                        }
                        E -> {
                            nedge.nodes.add(4L)
                            N
                        }
                        else -> continue
                    }
                }
                map.edges[++map.xref] = nedge
                land.land.geom.elems.add(Prim(map.xref))
                land.land.geom.comps[0]!!.size++
                land.land.geom.prim = AREA
                map.features[Obj.LNDARE]!!.add(land.land)
            }
        }
        return
    }

    enum class Ext {
        I, N, W, S, E
    }
}