// License: GPL. For details, see LICENSE file.
package s57

import s57.S57att.Att
import s57.S57map.Snode
import s57.S57obj.Obj
import s57.S57val.CatROD
import s57.S57val.Conv

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57osm {

    private val OSMtags: Map<String?, KeyVal<*>?> = mapOf(
        "natural=coastline" to KeyVal<Any?>(Obj.COALNE, Att.UNKATT, null, null),
        "natural=water" to KeyVal<Any?>(Obj.LAKARE, Att.UNKATT, null, null),
        "water=river" to KeyVal<Any?>(Obj.RIVERS, Att.UNKATT, null, null),
        "water=canal" to KeyVal<Any?>(Obj.CANALS, Att.UNKATT, null, null),
        "waterway=riverbank" to KeyVal<Any?>(Obj.RIVERS, Att.UNKATT, null, null),
        "waterway=dock" to KeyVal<Any?>(Obj.HRBBSN, Att.UNKATT, null, null),
        "waterway=lock" to KeyVal<Any?>(Obj.HRBBSN, Att.UNKATT, null, null),
        "landuse=basin" to KeyVal<Any?>(Obj.LAKARE, Att.UNKATT, null, null),
        "wetland=tidalflat" to KeyVal<Double?>(Obj.DEPARE, Att.DRVAL2, Conv.F, 0.0),
        "tidal=yes" to KeyVal<Double?>(Obj.DEPARE, Att.DRVAL2, Conv.F, 0.0),
        "natural=mud" to KeyVal<Any?>(Obj.DEPARE, Att.UNKATT, null, null),
        "natural=sand" to KeyVal<Any?>(Obj.DEPARE, Att.UNKATT, null, null),
        "highway=motorway" to KeyVal<CatROD?>(Obj.ROADWY, Att.CATROD, Conv.E, CatROD.ROD_MWAY),
        "highway=trunk" to KeyVal<CatROD?>(Obj.ROADWY, Att.CATROD, Conv.E, CatROD.ROD_MAJR),
        "highway=primary" to KeyVal<CatROD?>(Obj.ROADWY, Att.CATROD, Conv.E, CatROD.ROD_MAJR),
        "highway=secondary" to KeyVal<CatROD?>(Obj.ROADWY, Att.CATROD, Conv.E, CatROD.ROD_MINR),
        "highway=tertiary" to KeyVal<CatROD?>(Obj.ROADWY, Att.CATROD, Conv.E, CatROD.ROD_MINR),
        "highway=residential" to KeyVal<Any?>(Obj.ROADWY, Att.UNKATT, null, null),
        "highway=unclassified" to KeyVal<Any?>(Obj.ROADWY, Att.UNKATT, null, null),
        "railway=rail" to KeyVal<Any?>(Obj.RAILWY, Att.UNKATT, null, null),
        "man_made=breakwater" to KeyVal<Any?>(Obj.SLCONS, Att.UNKATT, null, null),
        "man_made=groyne" to KeyVal<Any?>(Obj.SLCONS, Att.UNKATT, null, null),
        "man_made=pier" to KeyVal<Any?>(Obj.SLCONS, Att.UNKATT, null, null),
        "man_made=jetty" to KeyVal<Any?>(Obj.SLCONS, Att.UNKATT, null, null),
        "landuse=industrial" to KeyVal<Any?>(Obj.BUAARE, Att.UNKATT, null, null),
        "landuse=commercial" to KeyVal<Any?>(Obj.BUAARE, Att.UNKATT, null, null),
        "landuse=retail" to KeyVal<Any?>(Obj.BUAARE, Att.UNKATT, null, null),
        "landuse=residential" to KeyVal<Any?>(Obj.BUAARE, Att.UNKATT, null, null),
    )

    fun OSMtag(osm: ArrayList<KeyVal<*>?>?, key: String?, value: String?) {
        val kv = OSMtags["$key=$value"]
        if (kv != null) {
            if (kv.conv == Conv.E) {
                val list = ArrayList<Enum<*>?>()
                list.add(kv.`val` as Enum<*>?)
                osm!!.add(KeyVal<ArrayList<Enum<*>?>?>(kv.obj, kv.att, kv.conv, list))
            } else {
                osm!!.add(kv)
            }
        }
        var kvl: KeyVal<*>? = null
        var kvd: KeyVal<*>? = null
        var rc = false
        var rcl = false
        for (kvx in osm!!) {
            if (kvx!!.obj == Obj.LAKARE) {
                kvl = kvx
            } else if (kvx.obj == Obj.RIVERS || kvx.obj == Obj.CANALS) {
                rc = true
            }
            if (kvx.obj == Obj.DEPARE) {
                kvd = kvx
            } else if (kvx.obj == Obj.RIVERS || kvx.obj == Obj.CANALS || kvx.obj == Obj.LAKARE) {
                rcl = true
            }
        }
        if (rc && kvl != null) {
            osm.remove(kvl)
        }
        if (rcl && kvd != null) {
            osm.remove(kvd)
        }
        return
    }

    fun OSMmap(inp: BufferedReader?, map: S57map?, bb: Boolean) {
        var k: String?
        var v: String
        var lat = 0.0
        var lon = 0.0
        var id: Long = 0
        var inOsm = false
        var inNode = false
        var inWay = false
        var inRel = false

        map!!.nodes!![1L] = Snode()
        map.nodes!![2L] = Snode()
        map.nodes!![3L] = Snode()
        map.nodes!![4L] = Snode()

        var ln: String?
        while (inp!!.readLine().also { ln = it } != null) {
            if (inOsm) {
                if (ln!!.contains("<bounds") && !bb) {
                    for (token in ln!!.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                        if (token.matches("^minlat=.+".toRegex())) {
                            map.bounds!!.minlat =
                                deg2rad(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble())
                            map.nodes!![2L]!!.lat = map.bounds!!.minlat
                            map.nodes!![3L]!!.lat = map.bounds!!.minlat
                        } else if (token.matches("^minlon=.+".toRegex())) {
                            map.bounds!!.minlon =
                                deg2rad(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble())
                            map.nodes!![1L]!!.lon = map.bounds!!.minlon
                            map.nodes!![2L]!!.lon = map.bounds!!.minlon
                        } else if (token.matches("^maxlat=.+".toRegex())) {
                            map.bounds!!.maxlat =
                                deg2rad(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble())
                            map.nodes!![1L]!!.lat = map.bounds!!.maxlat
                            map.nodes!![4L]!!.lat = map.bounds!!.maxlat
                        } else if (token.matches("^maxlon=.+".toRegex())) {
                            map.bounds!!.maxlon =
                                deg2rad(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble())
                            map.nodes!![3L]!!.lon = map.bounds!!.maxlon
                            map.nodes!![4L]!!.lon = map.bounds!!.maxlon
                        }
                    }
                } else {
                    if ((inNode || inWay || inRel) && ln!!.contains("<tag")) {
                        var token: Array<String?> = ln!!.split("k=".toRegex()).dropLastWhile { it.isEmpty() }
                            .toTypedArray()
                        k = token[1]!!.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                        token = token[1]!!.split("v=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        v = token[1]!!.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                        if (k.isNotEmpty() && v.isNotEmpty()) {
                            map.addTag(k, v)
                        }
                    }
                    if (inNode) {
                        if (ln!!.contains("</node")) {
                            inNode = false
                            map.tagsDone(id)
                        }
                    } else if (ln!!.contains("<node")) {
                        for (token in ln!!.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                            if (token.matches("^id=.+".toRegex())) {
                                id = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toLong()
                            } else if (token.matches("^lat=.+".toRegex())) {
                                lat = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble()
                            } else if (token.matches("^lon=.+".toRegex())) {
                                lon = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble()
                            }
                        }
                        map.addNode(id, lat, lon)
                        if (ln!!.contains("/>")) {
                            map.tagsDone(id)
                        } else {
                            inNode = true
                        }
                    } else if (inWay) {
                        if (ln!!.contains("<nd")) {
                            var ref: Long = 0
                            for (token in ln!!.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                                if (token.matches("^ref=.+".toRegex())) {
                                    ref = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                        .toTypedArray()[1].toLong()
                                }
                            }
                            try {
                                map.addToEdge(ref)
                            } catch (e: Exception) {
                                inWay = false
                            }
                        }
                        if (ln!!.contains("</way")) {
                            inWay = false
                            map.tagsDone(id)
                        }
                    } else if (ln!!.contains("<way")) {
                        for (token in ln!!.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                            if (token.matches("^id=.+".toRegex())) {
                                id = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toLong()
                            }
                        }
                        map.addEdge(id)
                        if (ln!!.contains("/>")) {
                            map.tagsDone(0)
                        } else {
                            inWay = true
                        }
                    } else if (ln!!.contains("</osm")) {
                        map.mapDone()
                        break
                    } else if (inRel) {
                        if (ln!!.contains("<member")) {
                            var type = ""
                            var role = ""
                            var ref: Long = 0
                            for (token in ln!!.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                                if (token.matches("^ref=.+".toRegex())) {
                                    ref = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                        .toTypedArray()[1].toLong()
                                } else if (token.matches("^type=.+".toRegex())) {
                                    type = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                        .toTypedArray()[1]
                                } else if (token.matches("^role=.+".toRegex())) {
                                    val str: Array<String?> =
                                        token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                            .toTypedArray()
                                    if (str.size > 1) {
                                        role = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                            .toTypedArray()[1]
                                    }
                                }
                            }
                            if (role == "outer" || role == "inner" && type == "way") map.addToArea(ref, role == "outer")
                        }
                        if (ln!!.contains("</relation")) {
                            inRel = false
                            map.tagsDone(id)
                        }
                    } else if (ln!!.contains("<relation")) {
                        for (token in ln!!.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                            if (token.matches("^id=.+".toRegex())) {
                                id = token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toLong()
                            }
                        }
                        map.addArea(id)
                        if (ln!!.contains("/>")) {
                            map.tagsDone(id)
                        } else {
                            inRel = true
                        }
                    }
                }
            } else if (ln!!.contains("<osm")) {
                inOsm = true
            }
        }
        return
    }

    fun OSMmeta(map: S57map?) {
        map!!.addEdge(++map.xref)
        for (ref in 0..4) {
            map.addToEdge((if (ref == 0) 4 else ref).toLong())
        }
        map.addTag("seamark:type", "coverage")
        map.addTag("seamark:coverage:category", "coverage")
        map.tagsDone(map.xref)
    }

    class KeyVal<V>(var obj: Obj?, var att: Att?, var conv: Conv?, var `val`: V?)
}