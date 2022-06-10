// License: GPL. For details, see LICENSE file.
package s57

import s57.S57obj.Obj
import kotlin.math.abs
import kotlin.system.exitProcess

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
object S57dat {

    private val convs = mapOf(
        S57subf.I8RN to S57conv(5, 2),
        S57subf.RCNM to S57conv(2, 1),
        S57subf.RCID to S57conv(10, 4),
        S57subf.EXPP to S57conv(1, 1),
        S57subf.INTU to S57conv(1, 1),
        S57subf.DSNM to S57conv(0, 0),
        S57subf.EDTN to S57conv(0, 0),
        S57subf.UPDN to S57conv(0, 0),
        S57subf.UADT to S57conv(8, 0),
        S57subf.ISDT to S57conv(8, 0),
        S57subf.STED to S57conv(4, 0),
        S57subf.PRSP to S57conv(3, 1),
        S57subf.PSDN to S57conv(0, 0),
        S57subf.PRED to S57conv(0, 0),
        S57subf.PROF to S57conv(2, 1),
        S57subf.AGEN to S57conv(2, 2),
        S57subf.COMT to S57conv(0, 0),
        S57subf.DSTR to S57conv(2, 1),
        S57subf.AALL to S57conv(1, 1),
        S57subf.NALL to S57conv(1, 1),
        S57subf.NOMR to S57conv(0, 4),
        S57subf.NOCR to S57conv(0, 4),
        S57subf.NOGR to S57conv(0, 4),
        S57subf.NOLR to S57conv(0, 4),
        S57subf.NOIN to S57conv(0, 4),
        S57subf.NOCN to S57conv(0, 4),
        S57subf.NOED to S57conv(0, 4),
        S57subf.NOFA to S57conv(0, 4),
        S57subf.HDAT to S57conv(3, 1),
        S57subf.VDAT to S57conv(2, 1),
        S57subf.SDAT to S57conv(2, 1),
        S57subf.CSCL to S57conv(0, 4),
        S57subf.DUNI to S57conv(2, 1),
        S57subf.HUNI to S57conv(2, 1),
        S57subf.PUNI to S57conv(2, 1),
        S57subf.COUN to S57conv(2, 1),
        S57subf.COMF to S57conv(0, 4),
        S57subf.SOMF to S57conv(0, 4),
        S57subf.PROJ to S57conv(3, 1),
        S57subf.PRP1 to S57conv(0, -4),
        S57subf.PRP2 to S57conv(0, -4),
        S57subf.PRP3 to S57conv(0, -4),
        S57subf.PRP4 to S57conv(0, -4),
        S57subf.FEAS to S57conv(0, -4),
        S57subf.FNOR to S57conv(0, -4),
        S57subf.FPMF to S57conv(0, 4),
        S57subf.RPID to S57conv(1, 1),
        S57subf.RYCO to S57conv(0, -4),
        S57subf.RXCO to S57conv(0, -4),
        S57subf.CURP to S57conv(2, 1),
        S57subf.RXVL to S57conv(0, -4),
        S57subf.RYVL to S57conv(0, -4),
        S57subf.PRCO to S57conv(2, 2),
        S57subf.ESDT to S57conv(8, 0),
        S57subf.LSDT to S57conv(8, 0),
        S57subf.DCRT to S57conv(0, 0),
        S57subf.CODT to S57conv(8, 0),
        S57subf.PACC to S57conv(0, 4),
        S57subf.HACC to S57conv(0, 4),
        S57subf.SACC to S57conv(0, 4),
        S57subf.FILE to S57conv(0, 0),
        S57subf.LFIL to S57conv(0, 0),
        S57subf.VOLM to S57conv(0, 0),
        S57subf.IMPL to S57conv(3, 0),
        S57subf.SLAT to S57conv(0, 0),
        S57subf.WLON to S57conv(0, 0),
        S57subf.NLAT to S57conv(0, 0),
        S57subf.ELON to S57conv(0, 0),
        S57subf.CRCS to S57conv(0, 0),
        S57subf.NAM1 to S57conv(12, 5),
        S57subf.NAM2 to S57conv(12, 5),
        S57subf.OORA to S57conv(1, 1),
        S57subf.OAAC to S57conv(6, 0),
        S57subf.OACO to S57conv(5, 2),
        S57subf.OALL to S57conv(0, 0),
        S57subf.OATY to S57conv(1, 1),
        S57subf.DEFN to S57conv(0, 0),
        S57subf.AUTH to S57conv(2, 2),
        S57subf.RFTP to S57conv(2, 1),
        S57subf.RFVL to S57conv(0, 0),
        S57subf.ATLB to S57conv(5, 2),
        S57subf.ATDO to S57conv(1, 1),
        S57subf.ADMU to S57conv(0, 0),
        S57subf.ADFT to S57conv(0, 0),
        S57subf.RAVA to S57conv(1, 1),
        S57subf.DVAL to S57conv(0, 0),
        S57subf.DVSD to S57conv(0, 0),
        S57subf.OBLB to S57conv(5, 2),
        S57subf.ASET to S57conv(1, 1),
        S57subf.PRIM to S57conv(1, 1),
        S57subf.GRUP to S57conv(3, 1),
        S57subf.OBJL to S57conv(5, 2),
        S57subf.RVER to S57conv(3, 2),
        S57subf.RUIN to S57conv(1, 1),
        S57subf.FIDN to S57conv(10, 4),
        S57subf.FIDS to S57conv(5, 2),
        S57subf.ATTL to S57conv(5, 2),
        S57subf.ATVL to S57conv(0, 0),
        S57subf.FFUI to S57conv(1, 1),
        S57subf.FFIX to S57conv(0, 2),
        S57subf.NFPT to S57conv(0, 2),
        S57subf.LNAM to S57conv(17, 8),
        S57subf.RIND to S57conv(0, 1),
        S57subf.FSUI to S57conv(1, 1),
        S57subf.FSIX to S57conv(0, 2),
        S57subf.NSPT to S57conv(0, 2),
        S57subf.NAME to S57conv(12, 5),
        S57subf.ORNT to S57conv(1, 1),
        S57subf.USAG to S57conv(1, 1),
        S57subf.MASK to S57conv(1, 1),
        S57subf.VPUI to S57conv(1, 1),
        S57subf.VPIX to S57conv(0, 2),
        S57subf.NVPT to S57conv(0, 2),
        S57subf.TOPI to S57conv(1, 1),
        S57subf.CCUI to S57conv(1, 1),
        S57subf.CCIX to S57conv(0, 2),
        S57subf.CCNC to S57conv(0, 2),
        S57subf.YCOO to S57conv(0, -4),
        S57subf.XCOO to S57conv(0, -4),
        S57subf.VE3D to S57conv(0, -4),
        S57subf.ATYP to S57conv(1, 1),
        S57subf.SURF to S57conv(1, 1),
        S57subf.ORDR to S57conv(1, 1),
        S57subf.RESO to S57conv(0, 4),
        S57subf.STPT to S57conv(0, 0),
        S57subf.CTPT to S57conv(0, 0),
        S57subf.ENPT to S57conv(0, 0),
        S57subf.CDPM to S57conv(0, 0),
        S57subf.CDPR to S57conv(0, 0),
    )

    private val S57i8ri = listOf(S57subf.I8RN)

    private val S57dsid = listOf(
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

    private val S57dssi = listOf(
        S57subf.DSTR, S57subf.AALL, S57subf.NALL, S57subf.NOMR, S57subf.NOCR, S57subf.NOGR, S57subf.NOLR,
        S57subf.NOIN, S57subf.NOCN, S57subf.NOED, S57subf.NOFA
    )
    private val S57dspm = listOf(
        S57subf.RCNM, S57subf.RCID, S57subf.HDAT, S57subf.VDAT, S57subf.SDAT, S57subf.CSCL, S57subf.DUNI,
        S57subf.HUNI, S57subf.PUNI, S57subf.COUN, S57subf.COMF, S57subf.SOMF, S57subf.COMT
    )

    private val S57dspr = listOf(
        S57subf.PROJ, S57subf.PRP1, S57subf.PRP2, S57subf.PRP3, S57subf.PRP4, S57subf.FEAS, S57subf.FNOR,
        S57subf.FPMF, S57subf.COMT
    )
    private val S57dsrc = listOf(
        S57subf.RPID, S57subf.RYCO, S57subf.RXCO, S57subf.CURP, S57subf.FPMF, S57subf.RXVL, S57subf.RYVL,
        S57subf.COMT
    )
    private val S57dsht = listOf(
        S57subf.RCNM,
        S57subf.RCID,
        S57subf.PRCO,
        S57subf.ESDT,
        S57subf.LSDT,
        S57subf.DCRT,
        S57subf.CODT,
        S57subf.COMT
    )
    private val S57dsac = listOf(
        S57subf.RCNM,
        S57subf.RCID,
        S57subf.PACC,
        S57subf.HACC,
        S57subf.SACC,
        S57subf.FPMF,
        S57subf.COMT
    )
    private val S57catd = listOf(
        S57subf.RCNM, S57subf.RCID, S57subf.FILE, S57subf.LFIL, S57subf.VOLM, S57subf.IMPL, S57subf.SLAT,
        S57subf.WLON, S57subf.NLAT, S57subf.ELON, S57subf.CRCS, S57subf.COMT
    )
    private val S57catx = listOf(S57subf.RCNM, S57subf.RCID, S57subf.NAM1, S57subf.NAM2, S57subf.COMT)
    private val S57dddf = listOf(
        S57subf.RCNM, S57subf.RCID, S57subf.OORA, S57subf.OAAC, S57subf.OACO, S57subf.OALL, S57subf.OATY,
        S57subf.DEFN, S57subf.AUTH, S57subf.COMT
    )

    private val S57dddr = listOf(S57subf.RFTP, S57subf.RFVL)

    private val S57dddi = listOf(
        S57subf.RCNM,
        S57subf.RCID,
        S57subf.ATLB,
        S57subf.ATDO,
        S57subf.ADMU,
        S57subf.ADFT,
        S57subf.AUTH,
        S57subf.COMT
    )

    private val S57ddom = listOf(S57subf.RAVA, S57subf.DVAL, S57subf.DVSD, S57subf.DEFN, S57subf.AUTH)
    private val S57ddrf = listOf(S57subf.RFTP, S57subf.RFVL)
    private val S57ddsi = listOf(S57subf.RCNM, S57subf.RCID, S57subf.OBLB)
    private val S57ddsc = listOf(S57subf.ATLB, S57subf.ASET, S57subf.AUTH)
    private val S57frid = listOf(
        S57subf.RCNM,
        S57subf.RCID,
        S57subf.PRIM,
        S57subf.GRUP,
        S57subf.OBJL,
        S57subf.RVER,
        S57subf.RUIN
    )

    private val S57foid = listOf(S57subf.AGEN, S57subf.FIDN, S57subf.FIDS)
    private val S57lnam = listOf(S57subf.LNAM)
    private val S57attf = listOf(S57subf.ATTL, S57subf.ATVL)
    private val S57natf = listOf(S57subf.ATTL, S57subf.ATVL)
    private val S57ffpc = listOf(S57subf.FFUI, S57subf.FFIX, S57subf.NFPT)
    private val S57ffpt = listOf(S57subf.LNAM, S57subf.RIND, S57subf.COMT)
    private val S57fspc = listOf(S57subf.FSUI, S57subf.FSIX, S57subf.NSPT)
    private val S57fspt = listOf(S57subf.NAME, S57subf.ORNT, S57subf.USAG, S57subf.MASK)
    private val S57vrid = listOf(S57subf.RCNM, S57subf.RCID, S57subf.RVER, S57subf.RUIN)
    private val S57attv = listOf(S57subf.ATTL, S57subf.ATVL)
    private val S57vrpc = listOf(S57subf.VPUI, S57subf.VPIX, S57subf.NVPT)
    private val S57vrpt = listOf(S57subf.NAME, S57subf.ORNT, S57subf.USAG, S57subf.TOPI, S57subf.MASK)
    private val S57sgcc = listOf(S57subf.CCUI, S57subf.CCIX, S57subf.CCNC)
    private val S57sg2d = listOf(S57subf.YCOO, S57subf.XCOO)
    private val S57sg3d = listOf(S57subf.YCOO, S57subf.XCOO, S57subf.VE3D)
    private val S57arcc = listOf(S57subf.ATYP, S57subf.SURF, S57subf.ORDR, S57subf.RESO, S57subf.FPMF)
    private val S57ar2d = listOf(S57subf.STPT, S57subf.CTPT, S57subf.ENPT, S57subf.YCOO, S57subf.XCOO)
    private val S57el2d = listOf(
        S57subf.STPT,
        S57subf.CTPT,
        S57subf.ENPT,
        S57subf.CDPM,
        S57subf.CDPR,
        S57subf.YCOO,
        S57subf.XCOO
    )
    private val S57ct2d = listOf(S57subf.YCOO, S57subf.XCOO)
    private val fields = mapOf(
        S57field.I8RI to S57i8ri,
        S57field.DSID to S57dsid,
        S57field.DSSI to S57dssi,
        S57field.DSPM to S57dspm,
        S57field.DSPR to S57dspr,
        S57field.DSRC to S57dsrc,
        S57field.DSHT to S57dsht,
        S57field.DSAC to S57dsac,
        S57field.CATD to S57catd,
        S57field.CATX to S57catx,
        S57field.DDDF to S57dddf,
        S57field.DDDR to S57dddr,
        S57field.DDDI to S57dddi,
        S57field.DDOM to S57ddom,
        S57field.DDRF to S57ddrf,
        S57field.DDSI to S57ddsi,
        S57field.DDSC to S57ddsc,
        S57field.FRID to S57frid,
        S57field.FOID to S57foid,
        S57field.LNAM to S57lnam,
        S57field.ATTF to S57attf,
        S57field.NATF to S57natf,
        S57field.FFPC to S57ffpc,
        S57field.FFPT to S57ffpt,
        S57field.FFPC to S57fspc,
        S57field.FSPT to S57fspt,
        S57field.VRID to S57vrid,
        S57field.ATTV to S57attv,
        S57field.VRPC to S57vrpc,
        S57field.VRPT to S57vrpt,
        S57field.SGCC to S57sgcc,
        S57field.SG2D to S57sg2d,
        S57field.SG3D to S57sg3d,
        S57field.ARCC to S57arcc,
        S57field.AR2D to S57ar2d,
        S57field.EL2D to S57el2d,
        S57field.CT2D to S57ct2d,
    )

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
                    exitProcess(-1)
                }
            }
            val sub = subs[index++]
            val conv = convs[sub]
            if (sub == subf) {
                return conv
            } else {
                offset += if (conv!!.bin != 0) {
                    if (conv.bin < 8) abs(conv.bin) else conv.bin / 8
                } else {
                    conv.asc
                }
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
            if (conv.asc == 0) {
                var i = 0
                while (buffer[offset + i].toInt() != 0x1f) {
                    i++
                }
                try {
                    var charset = ""
                    charset = when (field) {
                        S57field.ATTF -> aall
                        S57field.NATF -> nall
                        else -> "US-ASCII"
                    }
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
            var f = abs(conv.bin)
            if (f < 5) {
                var `val` = buffer[offset + --f].toLong()
                if (conv.bin > 0) `val` = `val` and 0xffL
                while (f > 0) {
                    `val` = (`val` shl 8) + (buffer[offset + --f].toInt() and 0xff)
                }
                offset += abs(conv.bin)
                if (subf == S57subf.AALL || subf == S57subf.NALL) {
                    var charset = ""
                    when (`val`.toInt()) {
                        0 -> charset = "US-ASCII"
                        1 -> charset = "ISO-8859-1"
                        2 -> charset = "UTF-16LE"
                    }
                    if (subf == S57subf.NALL) nall = charset
                    else aall = charset
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
            when (`val`) {
                is String -> sval = `val`
                is Int -> sval = `val`.toString()
                is Long -> sval = `val`.toString()
                is Double -> sval = `val`.toString()
            }
            index = sval.length
            try {
                buffer = "$sval ".toByteArray(charset("ISO-8859-1"))
            } catch (e: Exception) {
                System.err.println(e.message)
                exitProcess(-1)
            }
            if (conv.asc == 0) {
                buffer[index] = 0x01f
            } else {
                buffer = buffer.copyOf(conv.asc)
                while (index < buffer.size) {
                    buffer[index++] = ' '.code.toByte()
                }
            }
        } else {
            val f = abs(conv.bin)
            var lval: Long
            when (`val`) {
                is String -> lval = `val`.toLong()
                is Double -> lval = `val`.toLong()
                is Int -> lval = `val`.toLong()
                else -> lval = `val` as Long
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
        buf = buf.copyOf(3)
        buf[2] = 0x1e
        index.add(Index("0001".toByteArray(), 3, 0))
        for (sfparams in fparams) {
            var ip = 0
            while (ip < sfparams.params.size) {
                for (subf in fields[sfparams.field]!!) {
                    val next = encSubf(subf, sfparams.params[ip++])
                    buf = buf.copyOf(buf.size + next.size)
                    arraycopy(next, 0, buf, buf.size - next.size, next.size)
                }
            }
            buf = buf.copyOf(buf.size + 1)
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
        val fbuf = leader.copyOf(leader.size + ibuf.size + buf.size)
        arraycopy(ibuf, 0, fbuf, leader.size, ibuf.size)
        arraycopy(buf, 0, fbuf, leader.size + ibuf.size, buf.size)
        fbuf[20] = (mlen + 0x30).toByte()
        fbuf[21] = (olen + 0x30).toByte()
        arraycopy(String.format("%05d", fbuf.size).toByteArray(), 0, fbuf, 0, 5)
        arraycopy(String.format("%05d", leader.size + ibuf.size).toByteArray(), 0, fbuf, 12, 5)
        asc = false
        return fbuf
    }

    private val S57prims = mapOf(
        Obj.UNKOBJ to Prims.PLA,
        Obj.M_COVR to Prims.A,
        Obj.M_NSYS to Prims.A,
        Obj.AIRARE to Prims.PA,
        Obj.ACHBRT to Prims.PA,
        Obj.ACHARE to Prims.PA,
        Obj.BCNCAR to Prims.P,
        Obj.BCNISD to Prims.P,
        Obj.BCNLAT to Prims.P,
        Obj.BCNSAW to Prims.P,
        Obj.BCNSPP to Prims.P,
        Obj.BERTHS to Prims.PLA,
        Obj.BRIDGE to Prims.PLA,
        Obj.BUISGL to Prims.PA,
        Obj.BUAARE to Prims.PA,
        Obj.BOYCAR to Prims.P,
        Obj.BOYINB to Prims.P,
        Obj.BOYISD to Prims.P,
        Obj.BOYLAT to Prims.P,
        Obj.BOYSAW to Prims.P,
        Obj.BOYSPP to Prims.P,
        Obj.CBLARE to Prims.A,
        Obj.CBLOHD to Prims.L,
        Obj.CBLSUB to Prims.L,
        Obj.CANALS to Prims.A,
        Obj.CTSARE to Prims.PA,
        Obj.CAUSWY to Prims.LA,
        Obj.CTNARE to Prims.PA,
        Obj.CHKPNT to Prims.PA,
        Obj.CGUSTA to Prims.P,
        Obj.COALNE to Prims.L,
        Obj.CONZNE to Prims.A,
        Obj.COSARE to Prims.A,
        Obj.CTRPNT to Prims.P,
        Obj.CONVYR to Prims.LA,
        Obj.CRANES to Prims.PA,
        Obj.CURENT to Prims.P,
        Obj.CUSZNE to Prims.A,
        Obj.DAMCON to Prims.LA,
        Obj.DAYMAR to Prims.P,
        Obj.DWRTCL to Prims.L,
        Obj.DWRTPT to Prims.A,
        Obj.DEPARE to Prims.A,
        Obj.DEPCNT to Prims.L,
        Obj.DISMAR to Prims.P,
        Obj.DOCARE to Prims.A,
        Obj.DRGARE to Prims.A,
        Obj.DRYDOC to Prims.A,
        Obj.DMPGRD to Prims.PA,
        Obj.DYKCON to Prims.L,
        Obj.EXEZNE to Prims.A,
        Obj.FAIRWY to Prims.A,
        Obj.FNCLNE to Prims.L,
        Obj.FERYRT to Prims.LA,
        Obj.FSHZNE to Prims.A,
        Obj.FSHFAC to Prims.PLA,
        Obj.FSHGRD to Prims.A,
        Obj.FLODOC to Prims.A,
        Obj.FOGSIG to Prims.P,
        Obj.FORSTC to Prims.PLA,
        Obj.FRPARE to Prims.A,
        Obj.GATCON to Prims.PLA,
        Obj.GRIDRN to Prims.PA,
        Obj.HRBARE to Prims.A,
        Obj.HRBFAC to Prims.PA,
        Obj.HULKES to Prims.PA,
        Obj.ICEARE to Prims.A,
        Obj.ICNARE to Prims.PA,
        Obj.ISTZNE to Prims.A,
        Obj.LAKARE to Prims.A,
        Obj.LNDARE to Prims.PLA,
        Obj.LNDELV to Prims.PL,
        Obj.LNDRGN to Prims.PA,
        Obj.LNDMRK to Prims.PLA,
        Obj.LIGHTS to Prims.P,
        Obj.LITFLT to Prims.P,
        Obj.LITVES to Prims.P,
        Obj.LOCMAG to Prims.PLA,
        Obj.LOKBSN to Prims.A,
        Obj.LOGPON to Prims.PA,
        Obj.MAGVAR to Prims.PLA,
        Obj.MARCUL to Prims.PLA,
        Obj.MIPARE to Prims.PA,
        Obj.MORFAC to Prims.PLA,
        Obj.MPAARE to Prims.PA,
        Obj.NAVLNE to Prims.L,
        Obj.OBSTRN to Prims.PLA,
        Obj.OFSPLF to Prims.PA,
        Obj.OSPARE to Prims.A,
        Obj.OILBAR to Prims.L,
        Obj.PILPNT to Prims.P,
        Obj.PILBOP to Prims.PA,
        Obj.PIPARE to Prims.PA,
        Obj.PIPOHD to Prims.L,
        Obj.PIPSOL to Prims.PL,
        Obj.PONTON to Prims.LA,
        Obj.PRCARE to Prims.PA,
        Obj.PRDARE to Prims.PA,
        Obj.PYLONS to Prims.PA,
        Obj.RADLNE to Prims.L,
        Obj.RADRNG to Prims.A,
        Obj.RADRFL to Prims.P,
        Obj.RADSTA to Prims.P,
        Obj.RTPBCN to Prims.P,
        Obj.RDOCAL to Prims.PL,
        Obj.RDOSTA to Prims.P,
        Obj.RAILWY to Prims.L,
        Obj.RAPIDS to Prims.PLA,
        Obj.RCRTCL to Prims.L,
        Obj.RECTRC to Prims.LA,
        Obj.RCTLPT to Prims.PA,
        Obj.RSCSTA to Prims.P,
        Obj.RESARE to Prims.A,
        Obj.RETRFL to Prims.P,
        Obj.RIVERS to Prims.LA,
        Obj.ROADWY to Prims.PLA,
        Obj.RUNWAY to Prims.PLA,
        Obj.SNDWAV to Prims.PLA,
        Obj.SEAARE to Prims.PA,
        Obj.SPLARE to Prims.PA,
        Obj.SBDARE to Prims.PLA,
        Obj.SLCONS to Prims.PLA,
        Obj.SISTAT to Prims.P,
        Obj.SISTAW to Prims.P,
        Obj.SILTNK to Prims.PA,
        Obj.SLOTOP to Prims.L,
        Obj.SLOGRD to Prims.PA,
        Obj.SMCFAC to Prims.PA,
        Obj.SOUNDG to Prims.P,
        Obj.SPRING to Prims.P,
        Obj.STSLNE to Prims.L,
        Obj.SUBTLN to Prims.A,
        Obj.SWPARE to Prims.A,
        Obj.TESARE to Prims.A,
        Obj.TS_PRH to Prims.PA,
        Obj.TS_PNH to Prims.PA,
        Obj.TS_PAD to Prims.PA,
        Obj.TS_TIS to Prims.PA,
        Obj.T_HMON to Prims.PA,
        Obj.T_NHMN to Prims.PA,
        Obj.T_TIMS to Prims.PA,
        Obj.TIDEWY to Prims.LA,
        Obj.TOPMAR to Prims.P,
        Obj.TSELNE to Prims.LA,
        Obj.TSSBND to Prims.L,
        Obj.TSSCRS to Prims.A,
        Obj.TSSLPT to Prims.A,
        Obj.TSSRON to Prims.A,
        Obj.TSEZNE to Prims.A,
        Obj.TUNNEL to Prims.LA,
        Obj.TWRTPT to Prims.A,
        Obj.UWTROC to Prims.P,
        Obj.UNSARE to Prims.A,
        Obj.VEGATN to Prims.PLA,
        Obj.WATTUR to Prims.PLA,
        Obj.WATFAL to Prims.PL,
        Obj.WEDKLP to Prims.PA,
        Obj.WRECKS to Prims.PA,
        Obj.TS_FEB to Prims.PA,
        Obj.NOTMRK to Prims.P,
        Obj.WTWAXS to Prims.L,
        Obj.WTWPRF to Prims.L,
        Obj.BUNSTA to Prims.PA,
        Obj.COMARE to Prims.A,
        Obj.HRBBSN to Prims.A,
        Obj.LKBSPT to Prims.A,
        Obj.PRTARE to Prims.A,
        Obj.REFDMP to Prims.P,
        Obj.TERMNL to Prims.PA,
        Obj.TRNBSN to Prims.PA,
        Obj.WTWARE to Prims.A,
        Obj.WTWGAG to Prims.PA,
        Obj.TISDGE to Prims.N,
        Obj.VEHTRF to Prims.PA,
        Obj.EXCNST to Prims.PA,
        Obj.LG_SDM to Prims.A,
        Obj.LG_VSP to Prims.A,
        Obj.LITMAJ to Prims.P,
        Obj.LITMIN to Prims.P,
    )

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