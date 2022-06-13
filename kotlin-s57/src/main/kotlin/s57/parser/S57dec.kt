// License: GPL. For details, see LICENSE file.
package s57.parser

import s57.parser.S57dat.S57field
import s57.parser.S57dat.S57subf
import s57.parser.S57map.Nflag
import s57.parser.S57map.Pflag.*

import java.io.InputStream

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57dec {

    fun decodeChart(inp: InputStream, map: S57map) {
        S57dat.rnum = 0
        val leader = ByteArray(24)
        var record: ByteArray
        var ddr: Boolean
        var length: Int
        var fields: Int
        var mapfl: Int
        var mapfp: Int
        var mapts: Int
        var entry: Int
        var tag: String
        var len: Int
        var pos: Int
        var inFeature = false
        var comf = 1.0
        var somf = 1.0
        var name: Long = 0
        var nflag = Nflag.ANON
        var pflag = NOSP
        var objl: Long = 0
        while (inp.read(leader) == 24) {
            try {
                length = String(leader, 0, 5).toInt() - 24
                record = ByteArray(length)
                ddr = leader[6] == 'L'.code.toByte()
                fields = String(leader, 12, 5).toInt() - 24
            } catch (e: Exception) {
                throw Exception("Invalid file format - Encrypted/compressed ENC file?")
            }
            mapfl = leader[20] - '0'.code.toByte()
            mapfp = leader[21] - '0'.code.toByte()
            mapts = leader[23] - '0'.code.toByte()
            entry = mapfl + mapfp + mapts
            if (inp.read(record) != length) break
            var idx = 0
            while (idx < fields - 1) {
                tag = String(record, idx, mapts)
                len = String(record, idx + mapts, mapfl).toInt()
                pos = String(record, idx + mapts + mapfl, mapfp).toInt()
                if (!ddr) {
                    when (tag) {
                        "0001" -> {
                            val i8rn: Int = (S57dat.decSubf(
                                record,
                                fields + pos,
                                S57field.I8RI,
                                S57subf.I8RN
                            ) as Long).toInt()
                        }
                        "DSSI" -> {
                            S57dat.decSubf(record, fields + pos, S57field.DSSI, S57subf.AALL)
                            S57dat.decSubf(S57subf.NALL)
                        }
                        "DSPM" -> {
                            comf = (S57dat.decSubf(
                                record,
                                fields + pos,
                                S57field.DSPM,
                                S57subf.COMF
                            ) as Long).toDouble()
                            somf = (S57dat.decSubf(S57subf.SOMF) as Long).toDouble()
                        }
                        "FRID" -> {
                            inFeature = true
                            pflag = when ((S57dat.decSubf(
                                record,
                                fields + pos,
                                S57field.FRID,
                                S57subf.PRIM
                            ) as Long).toInt()) {
                                1 -> POINT
                                2 -> LINE
                                3 -> AREA
                                else -> NOSP
                            }
                            objl = (S57dat.decSubf(S57subf.OBJL) as Long)
                        }
                        "FOID" -> {
                            name =
                                S57dat.decSubf(record, fields + pos, S57field.LNAM, S57subf.LNAM) as Long
                            map.newFeature(name, pflag, objl)
                        }
                        "ATTF" -> {
                            S57dat.setField(record, fields + pos, S57field.ATTF, len)
                            do {
                                val attl = S57dat.decSubf(S57subf.ATTL) as Long
                                val atvl = (S57dat.decSubf(S57subf.ATVL) as String).trim { it <= ' ' }
                                if (atvl.isNotEmpty()) {
                                    map.newAtt(attl, atvl)
                                }
                            } while (S57dat.more())
                        }
                        "FFPT" -> {
                            S57dat.setField(record, fields + pos, S57field.FFPT, len)
                            do {
                                name = S57dat.decSubf(S57subf.LNAM) as Long
                                val rind = (S57dat.decSubf(S57subf.RIND) as Long).toInt()
                                S57dat.decSubf(S57subf.COMT)
                                map.refObj(name, rind)
                            } while (S57dat.more())
                        }
                        "FSPT" -> {
                            S57dat.setField(record, fields + pos, S57field.FSPT, len)
                            do {
                                name = S57dat.decSubf(S57subf.NAME) as Long shl 16
                                map.newPrim(
                                    name,
                                    (S57dat.decSubf(S57subf.ORNT) as Long),
                                    (S57dat.decSubf(S57subf.USAG) as Long)
                                )
                                S57dat.decSubf(S57subf.MASK)
                            } while (S57dat.more())
                        }
                        "VRID" -> {
                            inFeature = false
                            name = (S57dat.decSubf(
                                record,
                                fields + pos,
                                S57field.VRID,
                                S57subf.RCNM
                            ) as Long)
                            nflag = when (name.toInt()) {
                                110 -> Nflag.ISOL
                                120 -> Nflag.CONN
                                else -> Nflag.ANON
                            }
                            name = name shl 32
                            name += S57dat.decSubf(S57subf.RCID) as Long
                            name = name shl 16
                            if (nflag == Nflag.ANON) {
                                map.newEdge(name)
                            }
                        }
                        "VRPT" -> {
                            S57dat.setField(record, fields + pos, S57field.VRPT, len)
                            do {
                                val conn = (S57dat.decSubf(S57subf.NAME) as Long) shl 16
                                val topi = (S57dat.decSubf(S57subf.TOPI) as Long).toInt()
                                map.addConn(conn, topi)
                                S57dat.decSubf(S57subf.MASK)
                            } while (S57dat.more())
                        }
                        "SG2D" -> {
                            S57dat.setField(record, fields + pos, S57field.SG2D, len)
                            do {
                                var lat = (S57dat.decSubf(S57subf.YCOO) as Long).toDouble() / comf
                                var lon = (S57dat.decSubf(S57subf.XCOO) as Long).toDouble() / comf
                                if (nflag == Nflag.ANON) {
                                    map.newNode(++name, lat, lon, nflag)
                                } else {
                                    map.newNode(name, lat, lon, nflag)
                                }
                                lat = deg2rad(lat)
                                lon = deg2rad(lon)
                                if (lat < map.bounds!!.minlat) map.bounds!!.minlat = lat
                                if (lat > map.bounds!!.maxlat) map.bounds!!.maxlat = lat
                                if (lon < map.bounds!!.minlon) map.bounds!!.minlon = lon
                                if (lon > map.bounds!!.maxlon) map.bounds!!.maxlon = lon
                            } while (S57dat.more())
                        }
                        "SG3D" -> {
                            S57dat.setField(record, fields + pos, S57field.SG3D, len)
                            do {
                                var lat = (S57dat.decSubf(S57subf.YCOO) as Long).toDouble() / comf
                                var lon = (S57dat.decSubf(S57subf.XCOO) as Long).toDouble() / comf
                                val depth = (S57dat.decSubf(S57subf.VE3D) as Long).toDouble() / somf
                                map.newNode(name++, lat, lon, depth)
                                lat = deg2rad(lat)
                                lon = deg2rad(lon)
                                if (lat < map.bounds!!.minlat) map.bounds!!.minlat = lat
                                if (lat > map.bounds!!.maxlat) map.bounds!!.maxlat = lat
                                if (lon < map.bounds!!.minlon) map.bounds!!.minlon = lon
                                if (lon > map.bounds!!.maxlon) map.bounds!!.maxlon = lon
                            } while (S57dat.more())
                        }
                        else -> {}
                    }
                }
                if (inFeature) {
                    map.endFeature()
                    inFeature = false
                }
                idx += entry
            }
        }
        map.endFile()
        inp.close()
        return
    }
}