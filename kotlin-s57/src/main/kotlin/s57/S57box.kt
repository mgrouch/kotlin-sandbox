// License: GPL. For details, see LICENSE file.
package s57

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57box {
    fun getExt(map: S57map, lat: Double, lon: Double): Ext {
        if (lat >= map.bounds!!.maxlat && lon < map.bounds!!.maxlon) {
            return Ext.N
        } else if (lon <= map.bounds!!.minlon) {
            return Ext.W
        } else if (lat <= map.bounds!!.minlat) {
            return Ext.S
        } else if (lon >= map.bounds!!.maxlon) {
            return Ext.E
        }
        return Ext.I
    }

    fun bBox(map: S57map) {
        /* Truncations
         * Points: delete point features outside BB
         * Lines: Truncate edges at BB boundaries
         * Areas: Truncate edges of outers & inners and add new border edges. Merge inners to outer where necessary
         * Remove nodes outside BB
         * Remove edges that are completely outside BB
         */
        class Land(var land: S57map.Feature) {
            var first: Long
            var start: S57map.Snode?
            var sbound: Ext
            var last: Long = 0
            var end: S57map.Snode?
            var ebound: Ext

            init {
                first = last
                end = null
                start = end
                ebound = Ext.I
                sbound = ebound
            }
        }
        if (map.features!![S57obj.Obj.COALNE] != null) {
            val coasts = ArrayList<S57map.Feature>()
            val lands = ArrayList<Land>()
            if (map.features!![S57obj.Obj.LNDARE] == null) {
                map.features!![S57obj.Obj.LNDARE] = ArrayList()
            }
            for (feature in map.features!![S57obj.Obj.COALNE]!!) {
                val land = S57map.Feature()
                land.id = ++map.xref
                land.type = S57obj.Obj.LNDARE
                land.reln = S57map.Rflag.MASTER
                land.objs!![S57obj.Obj.LNDARE] = S57map.ObjTab()
                land.objs!![S57obj.Obj.LNDARE]!![0] = S57map.AttMap()
                if (feature!!.geom!!.prim == S57map.Pflag.AREA) {
                    land.geom = feature.geom
                    map.features!![S57obj.Obj.LNDARE]!!.add(land)
                } else if (feature.geom!!.prim == S57map.Pflag.LINE) {
                    land.geom!!.prim = S57map.Pflag.LINE
                    land.geom!!.elems!!.addAll(feature.geom!!.elems!!)
                    coasts.add(land)
                }
            }
            while (coasts.size > 0) {
                val land = coasts.removeAt(0)
                val fedge = map.edges!![land.geom!!.elems!![0]!!.id]
                var first = fedge!!.first
                var last = map.edges!![land.geom!!.elems!![land.geom!!.elems!!.size - 1]!!.id]!!.last
                if (coasts.size > 0) {
                    var added = true
                    while (added) {
                        added = false
                        var i = 0
                        while (i < coasts.size) {
                            val coast = coasts[i]
                            val edge = map.edges!![coast.geom!!.elems!![0]!!.id]
                            if (edge!!.first == last) {
                                land.geom!!.elems!!.add(coast.geom!!.elems!![0])
                                last = edge.last
                                coasts.removeAt(i--)
                                added = true
                            } else if (edge.last == first) {
                                land.geom!!.elems!!.add(0, coast.geom!!.elems!![0])
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
            var islands = ArrayList<Land>()
            for (land in lands) {
                map.sortGeom(land.land)
                if (land.land.geom!!.prim == S57map.Pflag.AREA) {
                    islands.add(land)
                    map.features!![S57obj.Obj.LNDARE]!!.add(land.land)
                }
            }
            for (island in islands) {
                lands.remove(island)
            }
            for (land in lands) {
                land.first = map.edges!![land.land.geom!!.elems!![0]!!.id]!!.first
                land.start = map.nodes!![land.first]
                land.sbound = getExt(map, land.start!!.lat, land.start!!.lon)
                land.last = map.edges!![land.land.geom!!.elems!![land.land.geom!!.comps!![0]!!.size - 1]!!.id]!!.last
                land.end = map.nodes!![land.last]
                land.ebound = getExt(map, land.end!!.lat, land.end!!.lon)
            }
            islands = ArrayList()
            for (land in lands) {
                if (land.sbound == Ext.I || land.ebound == Ext.I) {
                    islands.add(land)
                }
            }
            for (island in islands) {
                lands.remove(island)
            }
            for (land in lands) {
                val nedge = S57map.Edge()
                nedge.first = land.last
                nedge.last = land.first
                var bound = land.ebound
                while (bound != land.sbound) {
                    bound = when (bound) {
                        Ext.N -> {
                            nedge.nodes!!.add(1L)
                            Ext.W
                        }
                        Ext.W -> {
                            nedge.nodes!!.add(2L)
                            Ext.S
                        }
                        Ext.S -> {
                            nedge.nodes!!.add(3L)
                            Ext.E
                        }
                        Ext.E -> {
                            nedge.nodes!!.add(4L)
                            Ext.N
                        }
                        else -> continue
                    }
                }
                map.edges!![++map.xref] = nedge
                land.land.geom!!.elems!!.add(S57map.Prim(map.xref))
                land.land.geom!!.comps!![0]!!.size++
                land.land.geom!!.prim = S57map.Pflag.AREA
                map.features!![S57obj.Obj.LNDARE]!!.add(land.land)
            }
        }
        return
    }

    enum class Ext {
        I, N, W, S, E
    }
}