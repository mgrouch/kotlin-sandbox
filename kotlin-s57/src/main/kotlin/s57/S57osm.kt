// License: GPL. For details, see LICENSE file.
package s57

import s57.S57obj.Obj
import java.io.BufferedReader

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57osm {
    private val OSMtags: HashMap<String?, KeyVal<*>?> = HashMap()

    init {
        OSMtags["natural=coastline"] = KeyVal<Any?>(Obj.COALNE, S57att.Att.UNKATT, null, null)
        OSMtags["natural=water"] = KeyVal<Any?>(Obj.LAKARE, S57att.Att.UNKATT, null, null)
        OSMtags["water=river"] =
            KeyVal<Any?>(Obj.RIVERS, S57att.Att.UNKATT, null, null)
        OSMtags["water=canal"] =
            KeyVal<Any?>(Obj.CANALS, S57att.Att.UNKATT, null, null)
        OSMtags["waterway=riverbank"] = KeyVal<Any?>(Obj.RIVERS, S57att.Att.UNKATT, null, null)
        OSMtags["waterway=dock"] = KeyVal<Any?>(Obj.HRBBSN, S57att.Att.UNKATT, null, null)
        OSMtags["waterway=lock"] =
            KeyVal<Any?>(Obj.HRBBSN, S57att.Att.UNKATT, null, null)
        OSMtags["landuse=basin"] = KeyVal<Any?>(Obj.LAKARE, S57att.Att.UNKATT, null, null)
        OSMtags["wetland=tidalflat"] =
            KeyVal<Double?>(Obj.DEPARE, S57att.Att.DRVAL2, S57val.Conv.F, 0.0)
        OSMtags["tidal=yes"] =
            KeyVal<Double?>(Obj.DEPARE, S57att.Att.DRVAL2, S57val.Conv.F, 0.0)
        OSMtags["natural=mud"] =
            KeyVal<Any?>(Obj.DEPARE, S57att.Att.UNKATT, null, null)
        OSMtags["natural=sand"] = KeyVal<Any?>(Obj.DEPARE, S57att.Att.UNKATT, null, null)
        OSMtags["highway=motorway"] = KeyVal<S57val.CatROD?>(
            Obj.ROADWY,
            S57att.Att.CATROD,
            S57val.Conv.E,
            S57val.CatROD.ROD_MWAY
        )
        OSMtags["highway=trunk"] = KeyVal<S57val.CatROD?>(
            Obj.ROADWY,
            S57att.Att.CATROD,
            S57val.Conv.E,
            S57val.CatROD.ROD_MAJR
        )
        OSMtags["highway=primary"] = KeyVal<S57val.CatROD?>(
            Obj.ROADWY,
            S57att.Att.CATROD,
            S57val.Conv.E,
            S57val.CatROD.ROD_MAJR
        )
        OSMtags["highway=secondary"] = KeyVal<S57val.CatROD?>(
            Obj.ROADWY,
            S57att.Att.CATROD,
            S57val.Conv.E,
            S57val.CatROD.ROD_MINR
        )
        OSMtags["highway=tertiary"] = KeyVal<S57val.CatROD?>(
            Obj.ROADWY,
            S57att.Att.CATROD,
            S57val.Conv.E,
            S57val.CatROD.ROD_MINR
        )
        OSMtags["highway=residential"] = KeyVal<Any?>(Obj.ROADWY, S57att.Att.UNKATT, null, null)
        OSMtags["highway=unclassified"] = KeyVal<Any?>(Obj.ROADWY, S57att.Att.UNKATT, null, null)
        OSMtags["railway=rail"] = KeyVal<Any?>(Obj.RAILWY, S57att.Att.UNKATT, null, null)
        OSMtags["man_made=breakwater"] = KeyVal<Any?>(Obj.SLCONS, S57att.Att.UNKATT, null, null)
        OSMtags["man_made=groyne"] = KeyVal<Any?>(Obj.SLCONS, S57att.Att.UNKATT, null, null)
        OSMtags["man_made=pier"] =
            KeyVal<Any?>(Obj.SLCONS, S57att.Att.UNKATT, null, null)
        OSMtags["man_made=jetty"] =
            KeyVal<Any?>(Obj.SLCONS, S57att.Att.UNKATT, null, null)
        OSMtags["landuse=industrial"] = KeyVal<Any?>(Obj.BUAARE, S57att.Att.UNKATT, null, null)
        OSMtags["landuse=commercial"] = KeyVal<Any?>(Obj.BUAARE, S57att.Att.UNKATT, null, null)
        OSMtags["landuse=retail"] =
            KeyVal<Any?>(Obj.BUAARE, S57att.Att.UNKATT, null, null)
        OSMtags["landuse=residential"] = KeyVal<Any?>(Obj.BUAARE, S57att.Att.UNKATT, null, null)
    }

    fun OSMtag(osm: ArrayList<KeyVal<*>?>?, key: String?, `val`: String?) {
        val kv = OSMtags["$key=$`val`"]
        if (kv != null) {
            if (kv.conv == S57val.Conv.E) {
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

    @Throws(Exception::class)
    fun OSMmap(`in`: BufferedReader?, map: S57map?, bb: Boolean) {
        var k: String?
        var v: String
        var lat = 0.0
        var lon = 0.0
        var id: Long = 0
        var inOsm = false
        var inNode = false
        var inWay = false
        var inRel = false
        map!!.nodes!![1L] = S57map.Snode()
        map.nodes!![2L] = S57map.Snode()
        map.nodes!![3L] = S57map.Snode()
        map.nodes!![4L] = S57map.Snode()
        var ln: String?
        while (`in`!!.readLine().also { ln = it } != null) {
            if (inOsm) {
                if (ln!!.contains("<bounds") && !bb) {
                    for (token in ln!!.split(" +".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                        if (token.matches("^minlat=.+".toRegex())) {
                            map.bounds!!.minlat =
                                Math.toRadians(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble())
                            map.nodes!![2L]!!.lat = map.bounds!!.minlat
                            map.nodes!![3L]!!.lat = map.bounds!!.minlat
                        } else if (token.matches("^minlon=.+".toRegex())) {
                            map.bounds!!.minlon =
                                Math.toRadians(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble())
                            map.nodes!![1L]!!.lon = map.bounds!!.minlon
                            map.nodes!![2L]!!.lon = map.bounds!!.minlon
                        } else if (token.matches("^maxlat=.+".toRegex())) {
                            map.bounds!!.maxlat =
                                Math.toRadians(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
                                    .toTypedArray()[1].toDouble())
                            map.nodes!![1L]!!.lat = map.bounds!!.maxlat
                            map.nodes!![4L]!!.lat = map.bounds!!.maxlat
                        } else if (token.matches("^maxlon=.+".toRegex())) {
                            map.bounds!!.maxlon =
                                Math.toRadians(token.split("[\"\']".toRegex()).dropLastWhile { it.isEmpty() }
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

    class KeyVal<V>(var obj: Obj?, var att: S57att.Att?, var conv: S57val.Conv?, var `val`: V?)
}