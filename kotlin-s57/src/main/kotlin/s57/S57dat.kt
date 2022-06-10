// License: GPL. For details, see LICENSE file.
package s57

import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets
import java.util.*

/**
 * @author Malcolm Herring
 */
object S57dat {
    private val convs = EnumMap<S57subf, S57conv>(
        S57subf::class.java
    )

    init {
        convs[S57subf.I8RN] = S57conv(5, 2)
        convs[S57subf.RCNM] = S57conv(2, 1)
        convs[S57subf.RCID] = S57conv(10, 4)
        convs[S57subf.EXPP] = S57conv(1, 1)
        convs[S57subf.INTU] = S57conv(1, 1)
        convs[S57subf.DSNM] = S57conv(0, 0)
        convs[S57subf.EDTN] = S57conv(0, 0)
        convs[S57subf.UPDN] = S57conv(0, 0)
        convs[S57subf.UADT] = S57conv(8, 0)
        convs[S57subf.ISDT] = S57conv(8, 0)
        convs[S57subf.STED] = S57conv(4, 0)
        convs[S57subf.PRSP] = S57conv(3, 1)
        convs[S57subf.PSDN] = S57conv(0, 0)
        convs[S57subf.PRED] = S57conv(0, 0)
        convs[S57subf.PROF] = S57conv(2, 1)
        convs[S57subf.AGEN] = S57conv(2, 2)
        convs[S57subf.COMT] = S57conv(0, 0)
        convs[S57subf.DSTR] = S57conv(2, 1)
        convs[S57subf.AALL] = S57conv(1, 1)
        convs[S57subf.NALL] = S57conv(1, 1)
        convs[S57subf.NOMR] = S57conv(0, 4)
        convs[S57subf.NOCR] = S57conv(0, 4)
        convs[S57subf.NOGR] = S57conv(0, 4)
        convs[S57subf.NOLR] = S57conv(0, 4)
        convs[S57subf.NOIN] = S57conv(0, 4)
        convs[S57subf.NOCN] = S57conv(0, 4)
        convs[S57subf.NOED] = S57conv(0, 4)
        convs[S57subf.NOFA] = S57conv(0, 4)
        convs[S57subf.HDAT] = S57conv(3, 1)
        convs[S57subf.VDAT] = S57conv(2, 1)
        convs[S57subf.SDAT] = S57conv(2, 1)
        convs[S57subf.CSCL] = S57conv(0, 4)
        convs[S57subf.DUNI] = S57conv(2, 1)
        convs[S57subf.HUNI] = S57conv(2, 1)
        convs[S57subf.PUNI] = S57conv(2, 1)
        convs[S57subf.COUN] = S57conv(2, 1)
        convs[S57subf.COMF] = S57conv(0, 4)
        convs[S57subf.SOMF] = S57conv(0, 4)
        convs[S57subf.PROJ] = S57conv(3, 1)
        convs[S57subf.PRP1] = S57conv(0, -4)
        convs[S57subf.PRP2] = S57conv(0, -4)
        convs[S57subf.PRP3] = S57conv(0, -4)
        convs[S57subf.PRP4] = S57conv(0, -4)
        convs[S57subf.FEAS] = S57conv(0, -4)
        convs[S57subf.FNOR] = S57conv(0, -4)
        convs[S57subf.FPMF] = S57conv(0, 4)
        convs[S57subf.RPID] = S57conv(1, 1)
        convs[S57subf.RYCO] = S57conv(0, -4)
        convs[S57subf.RXCO] = S57conv(0, -4)
        convs[S57subf.CURP] = S57conv(2, 1)
        convs[S57subf.RXVL] = S57conv(0, -4)
        convs[S57subf.RYVL] = S57conv(0, -4)
        convs[S57subf.PRCO] = S57conv(2, 2)
        convs[S57subf.ESDT] = S57conv(8, 0)
        convs[S57subf.LSDT] = S57conv(8, 0)
        convs[S57subf.DCRT] = S57conv(0, 0)
        convs[S57subf.CODT] = S57conv(8, 0)
        convs[S57subf.PACC] = S57conv(0, 4)
        convs[S57subf.HACC] = S57conv(0, 4)
        convs[S57subf.SACC] = S57conv(0, 4)
        convs[S57subf.FILE] = S57conv(0, 0)
        convs[S57subf.LFIL] = S57conv(0, 0)
        convs[S57subf.VOLM] = S57conv(0, 0)
        convs[S57subf.IMPL] = S57conv(3, 0)
        convs[S57subf.SLAT] = S57conv(0, 0)
        convs[S57subf.WLON] = S57conv(0, 0)
        convs[S57subf.NLAT] = S57conv(0, 0)
        convs[S57subf.ELON] = S57conv(0, 0)
        convs[S57subf.CRCS] = S57conv(0, 0)
        convs[S57subf.NAM1] = S57conv(12, 5)
        convs[S57subf.NAM2] = S57conv(12, 5)
        convs[S57subf.OORA] = S57conv(1, 1)
        convs[S57subf.OAAC] = S57conv(6, 0)
        convs[S57subf.OACO] = S57conv(5, 2)
        convs[S57subf.OALL] = S57conv(0, 0)
        convs[S57subf.OATY] = S57conv(1, 1)
        convs[S57subf.DEFN] = S57conv(0, 0)
        convs[S57subf.AUTH] = S57conv(2, 2)
        convs[S57subf.RFTP] = S57conv(2, 1)
        convs[S57subf.RFVL] = S57conv(0, 0)
        convs[S57subf.ATLB] = S57conv(5, 2)
        convs[S57subf.ATDO] = S57conv(1, 1)
        convs[S57subf.ADMU] = S57conv(0, 0)
        convs[S57subf.ADFT] = S57conv(0, 0)
        convs[S57subf.RAVA] = S57conv(1, 1)
        convs[S57subf.DVAL] = S57conv(0, 0)
        convs[S57subf.DVSD] = S57conv(0, 0)
        convs[S57subf.OBLB] = S57conv(5, 2)
        convs[S57subf.ASET] = S57conv(1, 1)
        convs[S57subf.PRIM] = S57conv(1, 1)
        convs[S57subf.GRUP] = S57conv(3, 1)
        convs[S57subf.OBJL] = S57conv(5, 2)
        convs[S57subf.RVER] = S57conv(3, 2)
        convs[S57subf.RUIN] = S57conv(1, 1)
        convs[S57subf.FIDN] = S57conv(10, 4)
        convs[S57subf.FIDS] = S57conv(5, 2)
        convs[S57subf.ATTL] = S57conv(5, 2)
        convs[S57subf.ATVL] = S57conv(0, 0)
        convs[S57subf.FFUI] = S57conv(1, 1)
        convs[S57subf.FFIX] = S57conv(0, 2)
        convs[S57subf.NFPT] = S57conv(0, 2)
        convs[S57subf.LNAM] = S57conv(17, 8)
        convs[S57subf.RIND] = S57conv(0, 1)
        convs[S57subf.FSUI] = S57conv(1, 1)
        convs[S57subf.FSIX] = S57conv(0, 2)
        convs[S57subf.NSPT] = S57conv(0, 2)
        convs[S57subf.NAME] = S57conv(12, 5)
        convs[S57subf.ORNT] = S57conv(1, 1)
        convs[S57subf.USAG] = S57conv(1, 1)
        convs[S57subf.MASK] = S57conv(1, 1)
        convs[S57subf.VPUI] = S57conv(1, 1)
        convs[S57subf.VPIX] = S57conv(0, 2)
        convs[S57subf.NVPT] = S57conv(0, 2)
        convs[S57subf.TOPI] = S57conv(1, 1)
        convs[S57subf.CCUI] = S57conv(1, 1)
        convs[S57subf.CCIX] = S57conv(0, 2)
        convs[S57subf.CCNC] = S57conv(0, 2)
        convs[S57subf.YCOO] = S57conv(0, -4)
        convs[S57subf.XCOO] = S57conv(0, -4)
        convs[S57subf.VE3D] = S57conv(0, -4)
        convs[S57subf.ATYP] = S57conv(1, 1)
        convs[S57subf.SURF] = S57conv(1, 1)
        convs[S57subf.ORDR] = S57conv(1, 1)
        convs[S57subf.RESO] = S57conv(0, 4)
        convs[S57subf.STPT] = S57conv(0, 0)
        convs[S57subf.CTPT] = S57conv(0, 0)
        convs[S57subf.ENPT] = S57conv(0, 0)
        convs[S57subf.CDPM] = S57conv(0, 0)
        convs[S57subf.CDPR] = S57conv(0, 0)
    }

    private val S57i8ri = ArrayList(Arrays.asList(S57subf.I8RN))
    private val S57dsid = ArrayList(
        Arrays.asList(
            S57subf.RCNM,
            S57subf.RCID,
            S57subf.EXPP,
            S57subf.INTU,
            S57subf.DSNM,
            S57subf.EDTN,
            S57subf.UPDN,
            S57subf.UADT,
            S57subf.ISDT,
            S57subf.STED,
            S57subf.PRSP,
            S57subf.PSDN,
            S57subf.PRED,
            S57subf.PROF,
            S57subf.AGEN,
            S57subf.COMT
        )
    )
    private val S57dssi = ArrayList(
        Arrays.asList(
            S57subf.DSTR, S57subf.AALL, S57subf.NALL, S57subf.NOMR, S57subf.NOCR, S57subf.NOGR, S57subf.NOLR,
            S57subf.NOIN, S57subf.NOCN, S57subf.NOED, S57subf.NOFA
        )
    )
    private val S57dspm = ArrayList(
        Arrays.asList(
            S57subf.RCNM, S57subf.RCID, S57subf.HDAT, S57subf.VDAT, S57subf.SDAT, S57subf.CSCL, S57subf.DUNI,
            S57subf.HUNI, S57subf.PUNI, S57subf.COUN, S57subf.COMF, S57subf.SOMF, S57subf.COMT
        )
    )
    private val S57dspr = ArrayList(
        Arrays.asList(
            S57subf.PROJ, S57subf.PRP1, S57subf.PRP2, S57subf.PRP3, S57subf.PRP4, S57subf.FEAS, S57subf.FNOR,
            S57subf.FPMF, S57subf.COMT
        )
    )
    private val S57dsrc = ArrayList(
        Arrays.asList(
            S57subf.RPID, S57subf.RYCO, S57subf.RXCO, S57subf.CURP, S57subf.FPMF, S57subf.RXVL, S57subf.RYVL,
            S57subf.COMT
        )
    )
    private val S57dsht = ArrayList(
        Arrays.asList(
            S57subf.RCNM,
            S57subf.RCID,
            S57subf.PRCO,
            S57subf.ESDT,
            S57subf.LSDT,
            S57subf.DCRT,
            S57subf.CODT,
            S57subf.COMT
        )
    )
    private val S57dsac = ArrayList(
        Arrays.asList(
            S57subf.RCNM,
            S57subf.RCID,
            S57subf.PACC,
            S57subf.HACC,
            S57subf.SACC,
            S57subf.FPMF,
            S57subf.COMT
        )
    )
    private val S57catd = ArrayList(
        Arrays.asList(
            S57subf.RCNM, S57subf.RCID, S57subf.FILE, S57subf.LFIL, S57subf.VOLM, S57subf.IMPL, S57subf.SLAT,
            S57subf.WLON, S57subf.NLAT, S57subf.ELON, S57subf.CRCS, S57subf.COMT
        )
    )
    private val S57catx = ArrayList(Arrays.asList(S57subf.RCNM, S57subf.RCID, S57subf.NAM1, S57subf.NAM2, S57subf.COMT))
    private val S57dddf = ArrayList(
        Arrays.asList(
            S57subf.RCNM, S57subf.RCID, S57subf.OORA, S57subf.OAAC, S57subf.OACO, S57subf.OALL, S57subf.OATY,
            S57subf.DEFN, S57subf.AUTH, S57subf.COMT
        )
    )
    private val S57dddr = ArrayList(Arrays.asList(S57subf.RFTP, S57subf.RFVL))
    private val S57dddi = ArrayList(
        Arrays.asList(
            S57subf.RCNM,
            S57subf.RCID,
            S57subf.ATLB,
            S57subf.ATDO,
            S57subf.ADMU,
            S57subf.ADFT,
            S57subf.AUTH,
            S57subf.COMT
        )
    )
    private val S57ddom = ArrayList(Arrays.asList(S57subf.RAVA, S57subf.DVAL, S57subf.DVSD, S57subf.DEFN, S57subf.AUTH))
    private val S57ddrf = ArrayList(Arrays.asList(S57subf.RFTP, S57subf.RFVL))
    private val S57ddsi = ArrayList(Arrays.asList(S57subf.RCNM, S57subf.RCID, S57subf.OBLB))
    private val S57ddsc = ArrayList(Arrays.asList(S57subf.ATLB, S57subf.ASET, S57subf.AUTH))
    private val S57frid = ArrayList(
        Arrays.asList(
            S57subf.RCNM,
            S57subf.RCID,
            S57subf.PRIM,
            S57subf.GRUP,
            S57subf.OBJL,
            S57subf.RVER,
            S57subf.RUIN
        )
    )
    private val S57foid = ArrayList(Arrays.asList(S57subf.AGEN, S57subf.FIDN, S57subf.FIDS))
    private val S57lnam = ArrayList(Arrays.asList(S57subf.LNAM))
    private val S57attf = ArrayList(Arrays.asList(S57subf.ATTL, S57subf.ATVL))
    private val S57natf = ArrayList(Arrays.asList(S57subf.ATTL, S57subf.ATVL))
    private val S57ffpc = ArrayList(Arrays.asList(S57subf.FFUI, S57subf.FFIX, S57subf.NFPT))
    private val S57ffpt = ArrayList(Arrays.asList(S57subf.LNAM, S57subf.RIND, S57subf.COMT))
    private val S57fspc = ArrayList(Arrays.asList(S57subf.FSUI, S57subf.FSIX, S57subf.NSPT))
    private val S57fspt = ArrayList(Arrays.asList(S57subf.NAME, S57subf.ORNT, S57subf.USAG, S57subf.MASK))
    private val S57vrid = ArrayList(Arrays.asList(S57subf.RCNM, S57subf.RCID, S57subf.RVER, S57subf.RUIN))
    private val S57attv = ArrayList(Arrays.asList(S57subf.ATTL, S57subf.ATVL))
    private val S57vrpc = ArrayList(Arrays.asList(S57subf.VPUI, S57subf.VPIX, S57subf.NVPT))
    private val S57vrpt = ArrayList(Arrays.asList(S57subf.NAME, S57subf.ORNT, S57subf.USAG, S57subf.TOPI, S57subf.MASK))
    private val S57sgcc = ArrayList(Arrays.asList(S57subf.CCUI, S57subf.CCIX, S57subf.CCNC))
    private val S57sg2d = ArrayList(Arrays.asList(S57subf.YCOO, S57subf.XCOO))
    private val S57sg3d = ArrayList(Arrays.asList(S57subf.YCOO, S57subf.XCOO, S57subf.VE3D))
    private val S57arcc = ArrayList(Arrays.asList(S57subf.ATYP, S57subf.SURF, S57subf.ORDR, S57subf.RESO, S57subf.FPMF))
    private val S57ar2d = ArrayList(Arrays.asList(S57subf.STPT, S57subf.CTPT, S57subf.ENPT, S57subf.YCOO, S57subf.XCOO))
    private val S57el2d = ArrayList(
        Arrays.asList(
            S57subf.STPT,
            S57subf.CTPT,
            S57subf.ENPT,
            S57subf.CDPM,
            S57subf.CDPR,
            S57subf.YCOO,
            S57subf.XCOO
        )
    )
    private val S57ct2d = ArrayList(Arrays.asList(S57subf.YCOO, S57subf.XCOO))
    private val fields = EnumMap<S57field?, ArrayList<S57subf>>(
        S57field::class.java
    )

    init {
        fields[S57field.I8RI] = S57i8ri
        fields[S57field.DSID] = S57dsid
        fields[S57field.DSSI] = S57dssi
        fields[S57field.DSPM] = S57dspm
        fields[S57field.DSPR] = S57dspr
        fields[S57field.DSRC] = S57dsrc
        fields[S57field.DSHT] = S57dsht
        fields[S57field.DSAC] = S57dsac
        fields[S57field.CATD] = S57catd
        fields[S57field.CATX] = S57catx
        fields[S57field.DDDF] = S57dddf
        fields[S57field.DDDR] = S57dddr
        fields[S57field.DDDI] = S57dddi
        fields[S57field.DDOM] = S57ddom
        fields[S57field.DDRF] = S57ddrf
        fields[S57field.DDSI] = S57ddsi
        fields[S57field.DDSC] = S57ddsc
        fields[S57field.FRID] = S57frid
        fields[S57field.FOID] = S57foid
        fields[S57field.LNAM] = S57lnam
        fields[S57field.ATTF] = S57attf
        fields[S57field.NATF] = S57natf
        fields[S57field.FFPC] = S57ffpc
        fields[S57field.FFPT] = S57ffpt
        fields[S57field.FFPC] = S57fspc
        fields[S57field.FSPT] = S57fspt
        fields[S57field.VRID] = S57vrid
        fields[S57field.ATTV] = S57attv
        fields[S57field.VRPC] = S57vrpc
        fields[S57field.VRPT] = S57vrpt
        fields[S57field.SGCC] = S57sgcc
        fields[S57field.SG2D] = S57sg2d
        fields[S57field.SG3D] = S57sg3d
        fields[S57field.ARCC] = S57arcc
        fields[S57field.AR2D] = S57ar2d
        fields[S57field.EL2D] = S57el2d
        fields[S57field.CT2D] = S57ct2d
    }

    private val leader = byteArrayOf(
        '0'.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        ' '.code.toByte(),
        'D'.code.toByte(),
        ' '.code.toByte(),
        ' '.code.toByte(),
        ' '.code.toByte(),
        ' '.code.toByte(),
        ' '.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        ' '.code.toByte(),
        ' '.code.toByte(),
        ' '.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        '0'.code.toByte(),
        '4'.code.toByte()
    )
    private var buffer: ByteArray
    private var offset = 0
    private var maxoff = 0
    private var index = 0
    private var field: S57field? = null
    private var aall = "US-ASCII"
    private var nall = "US-ASCII"
    var rnum = 0
    private fun findSubf(subf: S57subf): S57conv? {
        val subs = fields[field]!!
        var wrap = false
        while (true) {
            if (index == subs.size) {
                if (!wrap) {
                    index = 0
                    wrap = true
                } else {
                    println("ERROR: Subfield not found " + subf.name + " in " + field!!.name + " in record " + rnum)
                    System.exit(-1)
                }
            }
            val sub = subs[index++]
            val conv = convs[sub]
            if (sub == subf) {
                return conv
            } else {
                offset += if (conv!!.bin != 0) if (conv.bin < 8) Math.abs(conv.bin) else conv.bin / 8 else conv.asc
            }
        }
    }

    fun setField(buf: ByteArray, off: Int, fld: S57field?, len: Int) {
        buffer = buf
        offset = off
        maxoff = off + len - 1
        field = fld
        index = 0
    }

    fun more(): Boolean {
        return offset < maxoff
    }

    fun decSubf(buf: ByteArray, off: Int, fld: S57field?, subf: S57subf): Any {
        buffer = buf
        offset = off
        index = 0
        return decSubf(fld, subf)
    }

    fun decSubf(fld: S57field?, subf: S57subf): Any {
        field = fld
        index = 0
        return decSubf(subf)
    }

    fun decSubf(subf: S57subf): Any {
        val conv = findSubf(subf)
        return if (conv!!.bin == 0) {
            var str = ""
            var i = 0
            if (conv.asc == 0) {
                i = 0
                while (buffer[offset + i].toInt() != 0x1f) {
                    i++
                }
                try {
                    var charset = ""
                    charset = if (field == S57field.ATTF) aall else if (field == S57field.NATF) nall else "US-ASCII"
                    str = String(buffer, offset, i, charset)
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                }
                offset += i + 1
            } else {
                str = String(buffer, offset, conv.asc)
                offset += conv.asc
            }
            str
        } else {
            var f = Math.abs(conv.bin)
            if (f < 5) {
                var `val` = buffer[offset + --f].toLong()
                if (conv.bin > 0) `val` = `val` and 0xffL
                while (f > 0) {
                    `val` = (`val` shl 8) + (buffer[offset + --f].toInt() and 0xff)
                }
                offset += Math.abs(conv.bin)
                if (subf == S57subf.AALL || subf == S57subf.NALL) {
                    var charset = ""
                    when (`val`.toInt()) {
                        0 -> charset = "US-ASCII"
                        1 -> charset = "ISO-8859-1"
                        2 -> charset = "UTF-16LE"
                    }
                    if (subf == S57subf.NALL) {
                        nall = charset
                    } else {
                        aall = charset
                    }
                }
                `val`
            } else {
                if (f == 5) {
                    var `val` = (buffer[offset++].toInt() and 0xff).toLong()
                    f--
                    while (f > 0) {
                        `val` = (`val` shl 8) + (buffer[offset + --f].toInt() and 0xff)
                    }
                    offset += 4
                    `val`
                } else {
                    var `val` = (buffer[offset++].toInt() and 0xff).toLong()
                    `val` = (`val` shl 8) + (buffer[offset++].toInt() and 0xff)
                    f = 4
                    while (f > 0) {
                        `val` = (`val` shl 8) + (buffer[offset + --f].toInt() and 0xff)
                    }
                    offset += 4
                    f = 2
                    while (f > 0) {
                        `val` = (`val` shl 8) + (buffer[offset + --f].toInt() and 0xff)
                    }
                    offset += 2
                    `val`
                }
            }
        }
    }

    fun encSubf(subf: S57subf, `val`: Any): ByteArray {
        val conv = convs[subf]
        if (conv!!.bin == 0 || asc) {
            var sval = ""
            if (`val` is String) {
                sval = `val`
            } else if (`val` is Int) {
                sval = `val`.toString()
            } else if (`val` is Long) {
                sval = `val`.toString()
            } else if (`val` is Double) {
                sval = `val`.toString()
            }
            index = sval.length
            try {
                buffer = "$sval ".toByteArray(charset("ISO-8859-1"))
            } catch (e: Exception) {
                System.err.println(e.message)
                System.exit(-1)
            }
            if (conv.asc == 0) {
                buffer[index] = 0x01f
            } else {
                buffer = Arrays.copyOf(buffer, conv.asc)
                while (index < buffer.size) {
                    buffer[index++] = ' '.code.toByte()
                }
            }
        } else {
            val f = Math.abs(conv.bin)
            var lval: Long
            if (`val` is String) {
                lval = `val`.toLong()
            } else if (`val` is Double) {
                lval = `val`.toLong()
            } else if (`val` is Int) {
                lval = `val`.toLong()
            } else {
                lval = `val` as Long
            }
            buffer = ByteArray(f)
            for (i in 0 until f) {
                buffer[i] = (lval and 0xffL).toByte()
                lval = lval shr 8
            }
        }
        return buffer
    }

    var asc = false
    fun encRecord(i8rn: String, fparams: ArrayList<Fparams>): ByteArray {
        asc = true
        return encRecord(i8rn.toInt(), fparams)
    }

    fun encRecord(i8rn: Int, fparams: ArrayList<Fparams>): ByteArray {
        val index = ArrayList<Index>()
        var offset = 3
        var maxlen = 3
        var buf = encSubf(S57subf.I8RN, i8rn)
        buf = Arrays.copyOf(buf, 3)
        buf[2] = 0x1e
        index.add(Index("0001".toByteArray(), 3, 0))
        for (sfparams in fparams) {
            var ip = 0
            while (ip < sfparams.params.size) {
                for (subf in fields[sfparams.field]!!) {
                    val next = encSubf(subf, sfparams.params[ip++])
                    buf = Arrays.copyOf(buf, buf.size + next.size)
                    System.arraycopy(next, 0, buf, buf.size - next.size, next.size)
                }
            }
            buf = Arrays.copyOf(buf, buf.size + 1)
            buf[buf.size - 1] = 0x1e
            val flen = buf.size - offset
            index.add(Index(sfparams.field.toString().toByteArray(StandardCharsets.UTF_8), flen, offset))
            maxlen = if (flen > maxlen) flen else maxlen
            offset += flen
        }
        val mlen = maxlen.toString().length
        val ffmt = "%0" + mlen + "d"
        val olen = offset.toString().length
        val ofmt = "%0" + olen + "d"
        val ilen = 4 + mlen + olen
        val isiz = ilen * index.size + 1
        val ibuf = ByteArray(isiz)
        var i = 0
        for (item in index) {
            for (ch in item.field) {
                ibuf[i++] = ch
            }
            var digits = String.format(ffmt, item.length).toByteArray()
            for (ch in digits) {
                ibuf[i++] = ch
            }
            digits = String.format(ofmt, item.offset).toByteArray()
            for (ch in digits) {
                ibuf[i++] = ch
            }
        }
        ibuf[i] = 0x1e
        val fbuf = Arrays.copyOf(leader, leader.size + ibuf.size + buf.size)
        System.arraycopy(ibuf, 0, fbuf, leader.size, ibuf.size)
        System.arraycopy(buf, 0, fbuf, leader.size + ibuf.size, buf.size)
        fbuf[20] = (mlen + 0x30).toByte()
        fbuf[21] = (olen + 0x30).toByte()
        System.arraycopy(String.format("%05d", fbuf.size).toByteArray(), 0, fbuf, 0, 5)
        System.arraycopy(String.format("%05d", leader.size + ibuf.size).toByteArray(), 0, fbuf, 12, 5)
        asc = false
        return fbuf
    }

    private val S57prims = EnumMap<S57obj.Obj?, Prims>(
        S57obj.Obj::class.java
    )

    init {
        S57prims[S57obj.Obj.UNKOBJ] = Prims.PLA
        S57prims[S57obj.Obj.M_COVR] = Prims.A
        S57prims[S57obj.Obj.M_NSYS] = Prims.A
        S57prims[S57obj.Obj.AIRARE] = Prims.PA
        S57prims[S57obj.Obj.ACHBRT] = Prims.PA
        S57prims[S57obj.Obj.ACHARE] = Prims.PA
        S57prims[S57obj.Obj.BCNCAR] = Prims.P
        S57prims[S57obj.Obj.BCNISD] = Prims.P
        S57prims[S57obj.Obj.BCNLAT] = Prims.P
        S57prims[S57obj.Obj.BCNSAW] = Prims.P
        S57prims[S57obj.Obj.BCNSPP] = Prims.P
        S57prims[S57obj.Obj.BERTHS] = Prims.PLA
        S57prims[S57obj.Obj.BRIDGE] = Prims.PLA
        S57prims[S57obj.Obj.BUISGL] = Prims.PA
        S57prims[S57obj.Obj.BUAARE] = Prims.PA
        S57prims[S57obj.Obj.BOYCAR] = Prims.P
        S57prims[S57obj.Obj.BOYINB] = Prims.P
        S57prims[S57obj.Obj.BOYISD] = Prims.P
        S57prims[S57obj.Obj.BOYLAT] = Prims.P
        S57prims[S57obj.Obj.BOYSAW] = Prims.P
        S57prims[S57obj.Obj.BOYSPP] = Prims.P
        S57prims[S57obj.Obj.CBLARE] = Prims.A
        S57prims[S57obj.Obj.CBLOHD] = Prims.L
        S57prims[S57obj.Obj.CBLSUB] = Prims.L
        S57prims[S57obj.Obj.CANALS] = Prims.A
        S57prims[S57obj.Obj.CTSARE] = Prims.PA
        S57prims[S57obj.Obj.CAUSWY] = Prims.LA
        S57prims[S57obj.Obj.CTNARE] = Prims.PA
        S57prims[S57obj.Obj.CHKPNT] = Prims.PA
        S57prims[S57obj.Obj.CGUSTA] = Prims.P
        S57prims[S57obj.Obj.COALNE] = Prims.L
        S57prims[S57obj.Obj.CONZNE] = Prims.A
        S57prims[S57obj.Obj.COSARE] = Prims.A
        S57prims[S57obj.Obj.CTRPNT] = Prims.P
        S57prims[S57obj.Obj.CONVYR] = Prims.LA
        S57prims[S57obj.Obj.CRANES] = Prims.PA
        S57prims[S57obj.Obj.CURENT] = Prims.P
        S57prims[S57obj.Obj.CUSZNE] = Prims.A
        S57prims[S57obj.Obj.DAMCON] = Prims.LA
        S57prims[S57obj.Obj.DAYMAR] = Prims.P
        S57prims[S57obj.Obj.DWRTCL] = Prims.L
        S57prims[S57obj.Obj.DWRTPT] = Prims.A
        S57prims[S57obj.Obj.DEPARE] = Prims.A
        S57prims[S57obj.Obj.DEPCNT] = Prims.L
        S57prims[S57obj.Obj.DISMAR] = Prims.P
        S57prims[S57obj.Obj.DOCARE] = Prims.A
        S57prims[S57obj.Obj.DRGARE] = Prims.A
        S57prims[S57obj.Obj.DRYDOC] = Prims.A
        S57prims[S57obj.Obj.DMPGRD] = Prims.PA
        S57prims[S57obj.Obj.DYKCON] = Prims.L
        S57prims[S57obj.Obj.EXEZNE] = Prims.A
        S57prims[S57obj.Obj.FAIRWY] = Prims.A
        S57prims[S57obj.Obj.FNCLNE] = Prims.L
        S57prims[S57obj.Obj.FERYRT] = Prims.LA
        S57prims[S57obj.Obj.FSHZNE] = Prims.A
        S57prims[S57obj.Obj.FSHFAC] = Prims.PLA
        S57prims[S57obj.Obj.FSHGRD] = Prims.A
        S57prims[S57obj.Obj.FLODOC] = Prims.A
        S57prims[S57obj.Obj.FOGSIG] = Prims.P
        S57prims[S57obj.Obj.FORSTC] = Prims.PLA
        S57prims[S57obj.Obj.FRPARE] = Prims.A
        S57prims[S57obj.Obj.GATCON] = Prims.PLA
        S57prims[S57obj.Obj.GRIDRN] = Prims.PA
        S57prims[S57obj.Obj.HRBARE] = Prims.A
        S57prims[S57obj.Obj.HRBFAC] = Prims.PA
        S57prims[S57obj.Obj.HULKES] = Prims.PA
        S57prims[S57obj.Obj.ICEARE] = Prims.A
        S57prims[S57obj.Obj.ICNARE] = Prims.PA
        S57prims[S57obj.Obj.ISTZNE] = Prims.A
        S57prims[S57obj.Obj.LAKARE] = Prims.A
        S57prims[S57obj.Obj.LNDARE] = Prims.PLA
        S57prims[S57obj.Obj.LNDELV] = Prims.PL
        S57prims[S57obj.Obj.LNDRGN] = Prims.PA
        S57prims[S57obj.Obj.LNDMRK] = Prims.PLA
        S57prims[S57obj.Obj.LIGHTS] = Prims.P
        S57prims[S57obj.Obj.LITFLT] = Prims.P
        S57prims[S57obj.Obj.LITVES] = Prims.P
        S57prims[S57obj.Obj.LOCMAG] = Prims.PLA
        S57prims[S57obj.Obj.LOKBSN] = Prims.A
        S57prims[S57obj.Obj.LOGPON] = Prims.PA
        S57prims[S57obj.Obj.MAGVAR] = Prims.PLA
        S57prims[S57obj.Obj.MARCUL] = Prims.PLA
        S57prims[S57obj.Obj.MIPARE] = Prims.PA
        S57prims[S57obj.Obj.MORFAC] = Prims.PLA
        S57prims[S57obj.Obj.MPAARE] = Prims.PA
        S57prims[S57obj.Obj.NAVLNE] = Prims.L
        S57prims[S57obj.Obj.OBSTRN] = Prims.PLA
        S57prims[S57obj.Obj.OFSPLF] = Prims.PA
        S57prims[S57obj.Obj.OSPARE] = Prims.A
        S57prims[S57obj.Obj.OILBAR] = Prims.L
        S57prims[S57obj.Obj.PILPNT] = Prims.P
        S57prims[S57obj.Obj.PILBOP] = Prims.PA
        S57prims[S57obj.Obj.PIPARE] = Prims.PA
        S57prims[S57obj.Obj.PIPOHD] = Prims.L
        S57prims[S57obj.Obj.PIPSOL] = Prims.PL
        S57prims[S57obj.Obj.PONTON] = Prims.LA
        S57prims[S57obj.Obj.PRCARE] = Prims.PA
        S57prims[S57obj.Obj.PRDARE] = Prims.PA
        S57prims[S57obj.Obj.PYLONS] = Prims.PA
        S57prims[S57obj.Obj.RADLNE] = Prims.L
        S57prims[S57obj.Obj.RADRNG] = Prims.A
        S57prims[S57obj.Obj.RADRFL] = Prims.P
        S57prims[S57obj.Obj.RADSTA] = Prims.P
        S57prims[S57obj.Obj.RTPBCN] = Prims.P
        S57prims[S57obj.Obj.RDOCAL] = Prims.PL
        S57prims[S57obj.Obj.RDOSTA] = Prims.P
        S57prims[S57obj.Obj.RAILWY] = Prims.L
        S57prims[S57obj.Obj.RAPIDS] = Prims.PLA
        S57prims[S57obj.Obj.RCRTCL] = Prims.L
        S57prims[S57obj.Obj.RECTRC] = Prims.LA
        S57prims[S57obj.Obj.RCTLPT] = Prims.PA
        S57prims[S57obj.Obj.RSCSTA] = Prims.P
        S57prims[S57obj.Obj.RESARE] = Prims.A
        S57prims[S57obj.Obj.RETRFL] = Prims.P
        S57prims[S57obj.Obj.RIVERS] = Prims.LA
        S57prims[S57obj.Obj.ROADWY] = Prims.PLA
        S57prims[S57obj.Obj.RUNWAY] = Prims.PLA
        S57prims[S57obj.Obj.SNDWAV] = Prims.PLA
        S57prims[S57obj.Obj.SEAARE] = Prims.PA
        S57prims[S57obj.Obj.SPLARE] = Prims.PA
        S57prims[S57obj.Obj.SBDARE] = Prims.PLA
        S57prims[S57obj.Obj.SLCONS] = Prims.PLA
        S57prims[S57obj.Obj.SISTAT] = Prims.P
        S57prims[S57obj.Obj.SISTAW] = Prims.P
        S57prims[S57obj.Obj.SILTNK] = Prims.PA
        S57prims[S57obj.Obj.SLOTOP] = Prims.L
        S57prims[S57obj.Obj.SLOGRD] = Prims.PA
        S57prims[S57obj.Obj.SMCFAC] = Prims.PA
        S57prims[S57obj.Obj.SOUNDG] = Prims.P
        S57prims[S57obj.Obj.SPRING] = Prims.P
        S57prims[S57obj.Obj.STSLNE] = Prims.L
        S57prims[S57obj.Obj.SUBTLN] = Prims.A
        S57prims[S57obj.Obj.SWPARE] = Prims.A
        S57prims[S57obj.Obj.TESARE] = Prims.A
        S57prims[S57obj.Obj.TS_PRH] = Prims.PA
        S57prims[S57obj.Obj.TS_PNH] = Prims.PA
        S57prims[S57obj.Obj.TS_PAD] = Prims.PA
        S57prims[S57obj.Obj.TS_TIS] = Prims.PA
        S57prims[S57obj.Obj.T_HMON] = Prims.PA
        S57prims[S57obj.Obj.T_NHMN] = Prims.PA
        S57prims[S57obj.Obj.T_TIMS] = Prims.PA
        S57prims[S57obj.Obj.TIDEWY] = Prims.LA
        S57prims[S57obj.Obj.TOPMAR] = Prims.P
        S57prims[S57obj.Obj.TSELNE] = Prims.LA
        S57prims[S57obj.Obj.TSSBND] = Prims.L
        S57prims[S57obj.Obj.TSSCRS] = Prims.A
        S57prims[S57obj.Obj.TSSLPT] = Prims.A
        S57prims[S57obj.Obj.TSSRON] = Prims.A
        S57prims[S57obj.Obj.TSEZNE] = Prims.A
        S57prims[S57obj.Obj.TUNNEL] = Prims.LA
        S57prims[S57obj.Obj.TWRTPT] = Prims.A
        S57prims[S57obj.Obj.UWTROC] = Prims.P
        S57prims[S57obj.Obj.UNSARE] = Prims.A
        S57prims[S57obj.Obj.VEGATN] = Prims.PLA
        S57prims[S57obj.Obj.WATTUR] = Prims.PLA
        S57prims[S57obj.Obj.WATFAL] = Prims.PL
        S57prims[S57obj.Obj.WEDKLP] = Prims.PA
        S57prims[S57obj.Obj.WRECKS] = Prims.PA
        S57prims[S57obj.Obj.TS_FEB] = Prims.PA
        S57prims[S57obj.Obj.NOTMRK] = Prims.P
        S57prims[S57obj.Obj.WTWAXS] = Prims.L
        S57prims[S57obj.Obj.WTWPRF] = Prims.L
        S57prims[S57obj.Obj.BUNSTA] = Prims.PA
        S57prims[S57obj.Obj.COMARE] = Prims.A
        S57prims[S57obj.Obj.HRBBSN] = Prims.A
        S57prims[S57obj.Obj.LKBSPT] = Prims.A
        S57prims[S57obj.Obj.PRTARE] = Prims.A
        S57prims[S57obj.Obj.REFDMP] = Prims.P
        S57prims[S57obj.Obj.TERMNL] = Prims.PA
        S57prims[S57obj.Obj.TRNBSN] = Prims.PA
        S57prims[S57obj.Obj.WTWARE] = Prims.A
        S57prims[S57obj.Obj.WTWGAG] = Prims.PA
        S57prims[S57obj.Obj.TISDGE] = Prims.N
        S57prims[S57obj.Obj.VEHTRF] = Prims.PA
        S57prims[S57obj.Obj.EXCNST] = Prims.PA
        S57prims[S57obj.Obj.LG_SDM] = Prims.A
        S57prims[S57obj.Obj.LG_VSP] = Prims.A
        S57prims[S57obj.Obj.LITMAJ] = Prims.P
        S57prims[S57obj.Obj.LITMIN] = Prims.P
    }

    fun S57geoms(map: S57map) {
        for (list in map.features!!.values) {
            for (feature in list!!) {
                when (S57prims[feature!!.type]) {
                    Prims.N -> {}
                    Prims.P -> if (feature.geom!!.prim != S57map.Pflag.POINT) {
                        //                        Snode node = feature.geom.centre;
                        //                        node.flg = Nflag.ISOL;
                        //                        map.nodes.put(++map.xref, node);
                        //                        feature.geom = map.new Geom(Pflag.POINT);
                        //                        feature.geom.centre = node;
                        //                        feature.geom.elems.add(map.new Prim(map.xref));
                    }
                    Prims.L -> {}
                    Prims.A -> {}
                    Prims.PA -> {}
                    Prims.PL -> {}
                    Prims.LA -> if (feature.geom!!.prim == S57map.Pflag.POINT) {
                        //                        list.remove(feature);
                    }
                    Prims.PLA -> {}
                }
            }
        }
    }

    // CHECKSTYLE.OFF: LineLength
    class S57conv internal constructor(// 0=A(), 1+=A(n)
        var asc: Int, // 0=ASCII, +ve=b1n(unsigned LE), -ve=b2n(signed LE), n>8=b1(n/8)(unsigned BE)
        var bin: Int
    )

    enum class S57subf {
        I8RN, RCNM, RCID, EXPP, INTU, DSNM, EDTN, UPDN, UADT, ISDT, STED, PRSP, PSDN, PRED, PROF, AGEN, COMT, DSTR, AALL, NALL, NOMR, NOCR, NOGR, NOLR, NOIN, NOCN, NOED, NOFA, HDAT, VDAT, SDAT, CSCL, DUNI, HUNI, PUNI, COUN, COMF, SOMF, PROJ, PRP1, PRP2, PRP3, PRP4, FEAS, FNOR, FPMF, RPID, RYCO, RXCO, CURP, RXVL, RYVL, PRCO, ESDT, LSDT, DCRT, CODT, PACC, HACC, SACC, FILE, LFIL, VOLM, IMPL, SLAT, WLON, NLAT, ELON, CRCS, NAM1, NAM2, OORA, OAAC, OACO, OALL, OATY, DEFN, AUTH, RFTP, RFVL, ATLB, ATDO, ADMU, ADFT, RAVA, DVAL, DVSD, OBLB, ASET, PRIM, GRUP, OBJL, RVER, RUIN, FIDN, FIDS, ATTL, ATVL, FFUI, FFIX, NFPT, LNAM, RIND, FSUI, FSIX, NSPT, NAME, ORNT, USAG, MASK, VPUI, VPIX, NVPT, TOPI, CCUI, CCIX, CCNC, YCOO, XCOO, VE3D, ATYP, SURF, ORDR, RESO, STPT, CTPT, ENPT, CDPM, CDPR
    }

    enum class S57field {
        I8RI, DSID, DSSI, DSPM, DSPR, DSRC, DSHT, DSAC, CATD, CATX, DDDF, DDDR, DDDI, DDOM, DDRF, DDSI, DDSC, FRID, FOID, LNAM, ATTF, NATF, FFPC, FFPT, FSPC, FSPT, VRID, ATTV, VRPC, VRPT, SGCC, SG2D, SG3D, ARCC, AR2D, EL2D, CT2D
    }

    internal class Index(var field: ByteArray, var length: Int, var offset: Int)
    class Fparams(var field: S57field, var params: Array<Any>)
    internal enum class Prims {
        N, P, L, A, PA, PL, LA, PLA
    }
}