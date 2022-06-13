// License: GPL. For details, see LICENSE file.
package s57.symbols

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Color.black
import java.awt.Font
import java.awt.Graphics2D
import java.awt.font.TextLayout
import java.awt.geom.*

/**
 * @author Malcolm Herring
 */
object Symbols {

    val Yland = Color(0xedbc0c)
    val Bwater = Color(0x9bc5e3)
    val Gdries = Color(0x689868)
    val Mline = Color(0x9a6078)
    val Msymb = Color(0xa30075)
    val Mtss = Color(-0x3f3b7f01, true)

    fun drawSymbol(g2: Graphics2D, symbol: Symbol?, scale: Double, x: Double, y: Double, cs: Scheme?, dd: Delta?) {
        var pn = 0
        var cn = 0
        var bpat = Patt.Z
        var bcol: Color? = null
        g2.paint = black
        if (cs != null) {
            if (cs.pat.size > 0 && cs.col!!.size > 0 && cs.pat[0] == Patt.B) {
                bpat = cs.pat.removeAt(0)
                bcol = cs.col!!.removeAt(0)
            }
            pn = cs.pat.size
            cn = cs.col!!.size - if (pn != 0) pn - 1 else 0
            if (pn == 0 && cs.col!!.size == 1) {
                g2.paint = cs.col!![0]
            }
        }
        val savetr = g2.transform
        g2.translate(x, y)
        g2.scale(scale, scale)
        if (symbol != null) {
            for (item in symbol) {
                when (item.type) {
                    Form.BBOX -> {
                        val bbox = item.params as Rectangle2D.Double?
                        var dx = 0.0
                        var dy = 0.0
                        if (dd != null) {
                            g2.transform(dd.t)
                            when (dd.h) {
                                Handle.CC -> {
                                    dx -= bbox!!.x + bbox.width / 2.0
                                    dy -= bbox.y + bbox.height / 2.0
                                }
                                Handle.TL -> {
                                    dx -= bbox!!.x
                                    dy -= bbox.y
                                }
                                Handle.TR -> {
                                    dx -= bbox!!.x + bbox.width
                                    dy -= bbox.y
                                }
                                Handle.TC -> {
                                    dx -= bbox!!.x + bbox.width / 2.0
                                    dy -= bbox.y
                                }
                                Handle.LC -> {
                                    dx -= bbox!!.x
                                    dy -= bbox.y + bbox.height / 2.0
                                }
                                Handle.RC -> {
                                    dx -= bbox!!.x + bbox.width
                                    dy -= bbox.y + bbox.height / 2.0
                                }
                                Handle.BL -> {
                                    dx -= bbox!!.x
                                    dy -= bbox.y + bbox.height
                                }
                                Handle.BR -> {
                                    dx -= bbox!!.x + bbox.width
                                    dy -= bbox.y + bbox.height
                                }
                                Handle.BC -> {
                                    dx -= bbox!!.x + bbox.width / 2.0
                                    dy -= bbox.y + bbox.height
                                }
                            }
                            g2.translate(dx, dy)
                        }
                    }
                    Form.COLR -> if (cs?.col != null) {
                        for (patch in (item.params as Symbol?)!!) {
                            when (patch.type) {
                                Form.N1 -> if (cn > 0) {
                                    val s = patch.params as Symbol?
                                    drawSymbol(g2, s, 1.0, 0.0, 0.0, Scheme(cs.col!![0]), null)
                                }
                                Form.N2 -> if (cn > 0) {
                                    val s = patch.params as Symbol?
                                    drawSymbol(
                                        g2,
                                        s,
                                        1.0,
                                        0.0,
                                        0.0,
                                        Scheme(if (cn > 1) cs.col!![1] else cs.col!![0]),
                                        null
                                    )
                                }
                                Form.P1 -> if (cn > 0) {
                                    g2.paint = cs.col!![0]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.P2 -> if (cn > 0) {
                                    if (cn > 1) {
                                        g2.paint = cs.col!![1]
                                    } else {
                                        g2.paint = cs.col!![0]
                                    }
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.H2 -> if (cn > 1 && pn > 0 && cs.pat[0] == Patt.H) {
                                    g2.paint = cs.col!![cs.col!!.size - pn]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.H3 -> if (cn == 3 && pn > 0 && cs.pat[0] == Patt.H) {
                                    g2.paint = cs.col!![1]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.H4 -> if (cn == 4 && pn > 0 && cs.pat[0] == Patt.H) {
                                    g2.paint = cs.col!![1]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.H5 -> if (cn == 4 && pn > 0 && cs.pat[0] == Patt.H) {
                                    g2.paint = cs.col!![2]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.V2 -> if (cn > 1 && pn > 0 && cs.pat[0] == Patt.V) {
                                    g2.paint = cs.col!![cs.col!!.size - pn]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.V3 -> if (cn == 3 && pn > 0 && cs.pat[0] == Patt.V) {
                                    g2.paint = cs.col!![1]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.B1 -> if (bpat == Patt.B) {
                                    g2.paint = bcol
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.S2 -> if (cn > 1 && pn > 0 && cs.pat[0] == Patt.S) {
                                    g2.paint = cs.col!![1]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.S3 -> if (cn > 2 && pn > 0 && cs.pat[0] == Patt.S) {
                                    g2.paint = cs.col!![2]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                Form.S4 -> if (cn == 4 && pn > 0 && cs.pat[0] == Patt.S) {
                                    g2.paint = cs.col!![3]
                                    g2.fill(patch.params as Path2D.Double?)
                                }
                                else -> {}
                            }
                        }
                    }
                    Form.STRK -> g2.stroke = item.params as BasicStroke?
                    Form.FILL -> g2.paint = item.params as Color?
                    Form.LINE -> g2.draw(item.params as Line2D.Double?)
                    Form.RECT -> g2.draw(item.params as Rectangle2D.Double?)
                    Form.RRCT -> g2.draw(item.params as RoundRectangle2D.Double?)
                    Form.ELPS -> g2.draw(item.params as Ellipse2D.Double?)
                    Form.EARC -> g2.draw(item.params as Arc2D.Double?)
                    Form.PLIN -> g2.draw(item.params as Path2D.Double?)
                    Form.PGON -> g2.fill(item.params as Path2D.Double?)
                    Form.RSHP -> g2.fill(item.params as RectangularShape?)
                    Form.SYMB -> {
                        val s = item.params as SubSymbol?
                        drawSymbol(g2, s!!.instr, s.scale, s.x, s.y, if (s.scheme != null) s.scheme else cs, s.delta)
                    }
                    Form.TEXT -> {
                        val c = item.params as Caption?
                        g2.paint = c!!.colour
                        val layout = TextLayout(c.string, c.font, g2.fontRenderContext)
                        val bb = layout.bounds
                        var dx = 0.0
                        var dy = 0.0
                        if (c.dd != null) {
                            if (c.dd!!.t != null) g2.transform(c.dd!!.t)
                            when (c.dd!!.h) {
                                Handle.CC -> {
                                    dx -= bb.x + bb.width / 2.0
                                    dy -= bb.y + bb.height / 2.0
                                }
                                Handle.TL -> {
                                    dx -= bb.x
                                    dy -= bb.y
                                }
                                Handle.TR -> {
                                    dx -= bb.x + bb.width
                                    dy -= bb.y
                                }
                                Handle.TC -> {
                                    dx -= bb.x + bb.width / 2.0
                                    dy -= bb.y
                                }
                                Handle.LC -> {
                                    dx -= bb.x
                                    dy -= bb.y + bb.height / 2.0
                                }
                                Handle.RC -> {
                                    dx -= bb.x + bb.width
                                    dy -= bb.y + bb.height / 2.0
                                }
                                Handle.BL -> {
                                    dx -= bb.x
                                    dy -= bb.y + bb.height
                                }
                                Handle.BR -> {
                                    dx -= bb.x + bb.width
                                    dy -= bb.y + bb.height
                                }
                                Handle.BC -> {
                                    dx -= bb.x + bb.width / 2.0
                                    dy -= bb.y + bb.height
                                }
                            }
                        }
                        layout.draw(g2, dx.toFloat(), dy.toFloat())
                    }
                    else -> {}
                }
            }
        }
        g2.transform = savetr
    }

    enum class Form {
        BBOX, STRK, COLR, FILL, LINE, RECT, RRCT, ELPS, EARC, PLIN, PGON, RSHP, TEXT, SYMB,
        N1, N2, P1, P2, H2, H3, H4, H5, V2, V3, D2, D3, D4, B1, S2, S3, S4, C2, X2
    }

    enum class Patt {
        Z, H, V, D, B, S, C, X
    }

    enum class Handle {
        CC, TL, TR, TC, LC, RC, BL, BR, BC
    }

    class Instr(var type: Form, var params: Any?)
    class Delta {
        var h: Handle
        var t: AffineTransform?

        constructor(ih: Handle, it: AffineTransform?) {
            h = ih
            t = it
        }

        constructor(ih: Handle) {
            h = ih
            t = AffineTransform()
        }
    }

    class Scheme {
        var pat: ArrayList<Patt>
        var col: ArrayList<Color?>?

        constructor(icol: ArrayList<Color?>?) {
            pat = ArrayList()
            col = icol
        }

        constructor(ipat: ArrayList<Patt>, icol: ArrayList<Color?>?) {
            pat = ipat
            col = icol
        }

        constructor(icol: Color?) {
            pat = ArrayList()
            col = ArrayList()
            col!!.add(icol)
        }

        constructor() {
            pat = ArrayList()
            col = ArrayList()
        }
    }

    class Caption(var string: String, var font: Font, var colour: Color?, var dd: Delta?)
    class LineStyle {

        var line: Color?

        var width: Float

        var dash: FloatArray?

        var fill: Color?

        constructor(ifill: Color?) {
            line = null
            width = 0f
            dash = null
            fill = ifill
        }

        constructor(iline: Color?, iwidth: Float) {
            line = iline
            width = iwidth
            dash = null
            fill = null
        }

        constructor(iline: Color?, iwidth: Float, idash: FloatArray?) {
            line = iline
            width = iwidth
            dash = idash
            fill = null
        }

        constructor(iline: Color?, iwidth: Float, ifill: Color?) {
            line = iline
            width = iwidth
            dash = null
            fill = ifill
        }

        constructor(iline: Color?, iwidth: Float, idash: FloatArray?, ifill: Color?) {
            line = iline
            width = iwidth
            dash = idash
            fill = ifill
        }
    }

    class Symbol : ArrayList<Instr>() {
        fun addInstr(type: Form, params: Any?) {
            add(Instr(type, params))
        }
    }

    class SubSymbol(
        var instr: Symbol?,
        var scale: Double,
        var x: Double,
        var y: Double,
        var scheme: Scheme?,
        var delta: Delta?
    )
}