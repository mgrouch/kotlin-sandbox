// License: GPL. For details, see LICENSE file.
package s57.render

import s57.parser.S57map
import s57.parser.S57map.Pflag
import s57.parser.S57val.UniHLU
import s57.parser.deg2rad
import s57.symbols.Areas
import s57.symbols.Symbols
import s57.symbols.Symbols.Caption
import s57.symbols.Symbols.Delta
import s57.symbols.Symbols.Form
import s57.symbols.Symbols.Symbol
import s57.symbols.Symbols.drawSymbol

import java.awt.*
import java.awt.Color.black
import java.awt.geom.*
import java.awt.image.AffineTransformOp
import java.awt.image.BufferedImage

import kotlin.math.*

/**
 * @author Malcolm Herring
 */
object Renderer {
    val symbolScale = doubleArrayOf(
        256.0,
        128.0,
        64.0,
        32.0,
        16.0,
        8.0,
        4.0,
        2.0,
        1.0,
        0.61,
        0.372,
        0.227,
        0.138,
        0.0843,
        0.0514,
        0.0313,
        0.0191,
        0.0117,
        0.007
    )
    lateinit var context: ChartContext
    var map: S57map? = null
    var sScale = 0.0
    var g2: Graphics2D? = null
    var zoom = 0

    fun reRender(g: Graphics2D?, rect: Rectangle?, z: Int, factor: Double, m: S57map?, c: ChartContext) {
        g2 = g
        zoom = z
        context = c
        map = m
        sScale = symbolScale[zoom] * factor
        if (map != null) {
            if (context.clip()) {
                val tl = context.getPoint(S57map.Snode(map!!.bounds.maxlat, map!!.bounds.minlon))
                val br = context.getPoint(S57map.Snode(map!!.bounds.minlat, map!!.bounds.maxlon))
                g2!!.clip(Rectangle2D.Double(tl!!.x, tl.y, br!!.x - tl.x, br.y - tl.y))
            }
            g2!!.background = context.background(map!!)
            //XXX: commented out:
            //g2.clearRect(rect.x, rect.y, rect.width, rect.height);
            g2!!.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            g2!!.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP)
            g2!!.stroke =
                BasicStroke(0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            do {
            } while (!Rules.rules())
        }
    }

    fun symbol(symbol: Symbol?) {
        val point = context.getPoint(Rules.feature!!.geom.centre!!)
        drawSymbol(g2!!, symbol, sScale, point!!.x, point.y, null, null)
    }

    fun symbol(symbol: Symbol?, scheme: Symbols.Scheme?) {
        val point = context.getPoint(Rules.feature!!.geom.centre!!)
        drawSymbol(g2!!, symbol, sScale, point!!.x, point.y, scheme, null)
    }

    fun symbol(symbol: Symbol?, delta: Delta?) {
        val point = context.getPoint(Rules.feature!!.geom.centre!!)
        drawSymbol(g2!!, symbol, sScale, point!!.x, point.y, null, delta)
    }

    fun symbol(symbol: Symbol?, scheme: Symbols.Scheme?, delta: Delta?) {
        val point = context.getPoint(Rules.feature!!.geom.centre!!)
        drawSymbol(g2!!, symbol, sScale, point!!.x, point.y, scheme, delta)
    }

    fun cluster(symbols: ArrayList<Symbol>) {
        var bbox: Rectangle2D.Double? = null
        if (symbols.size > 4) {
            for (instr in symbols[0]) {
                if (instr.type === Form.BBOX) {
                    bbox = instr.params as Rectangle2D.Double?
                    break
                }
            }
            if (bbox == null) return
        }
        when (symbols.size) {
            1 -> symbol(symbols[0], Delta(Symbols.Handle.CC, AffineTransform()))
            2 -> {
                symbol(symbols[0], Delta(Symbols.Handle.RC, AffineTransform()))
                symbol(symbols[1], Delta(Symbols.Handle.LC, AffineTransform()))
            }
            3 -> {
                symbol(symbols[0], Delta(Symbols.Handle.BC, AffineTransform()))
                symbol(symbols[1], Delta(Symbols.Handle.TR, AffineTransform()))
                symbol(symbols[2], Delta(Symbols.Handle.TL, AffineTransform()))
            }
            4 -> {
                symbol(symbols[0], Delta(Symbols.Handle.BR, AffineTransform()))
                symbol(symbols[1], Delta(Symbols.Handle.BL, AffineTransform()))
                symbol(symbols[2], Delta(Symbols.Handle.TR, AffineTransform()))
                symbol(symbols[3], Delta(Symbols.Handle.TL, AffineTransform()))
            }
            5 -> {
                symbol(symbols[0], Delta(Symbols.Handle.BR, AffineTransform()))
                symbol(symbols[1], Delta(Symbols.Handle.BL, AffineTransform()))
                symbol(
                    symbols[2],
                    Delta(
                        Symbols.Handle.TR,
                        AffineTransform.getTranslateInstance(-bbox!!.width / 2, 0.0)
                    )
                )
                symbol(symbols[3], Delta(Symbols.Handle.TC, AffineTransform()))
                symbol(
                    symbols[4], Delta(
                        Symbols.Handle.TL, AffineTransform.getTranslateInstance(
                            bbox.width / 2, 0.0
                        )
                    )
                )
            }
            6 -> {
                symbol(
                    symbols[0],
                    Delta(
                        Symbols.Handle.BR,
                        AffineTransform.getTranslateInstance(-bbox!!.width / 2, 0.0)
                    )
                )
                symbol(symbols[1], Delta(Symbols.Handle.BC, AffineTransform()))
                symbol(
                    symbols[2], Delta(
                        Symbols.Handle.BL, AffineTransform.getTranslateInstance(
                            bbox.width / 2, 0.0
                        )
                    )
                )
                symbol(
                    symbols[3],
                    Delta(
                        Symbols.Handle.TR,
                        AffineTransform.getTranslateInstance(-bbox.width / 2, 0.0)
                    )
                )
                symbol(symbols[4], Delta(Symbols.Handle.TC, AffineTransform()))
                symbol(
                    symbols[5], Delta(
                        Symbols.Handle.TL, AffineTransform.getTranslateInstance(
                            bbox.width / 2, 0.0
                        )
                    )
                )
            }
            7 -> {
                symbol(
                    symbols[0],
                    Delta(
                        Symbols.Handle.BC,
                        AffineTransform.getTranslateInstance(0.0, -bbox!!.height / 2)
                    )
                )
                symbol(
                    symbols[1],
                    Delta(
                        Symbols.Handle.RC,
                        AffineTransform.getTranslateInstance(-bbox.width / 2, 0.0)
                    )
                )
                symbol(symbols[2], Delta(Symbols.Handle.CC, AffineTransform()))
                symbol(
                    symbols[3], Delta(
                        Symbols.Handle.LC, AffineTransform.getTranslateInstance(
                            bbox.width / 2, 0.0
                        )
                    )
                )
                symbol(
                    symbols[4],
                    Delta(
                        Symbols.Handle.TR,
                        AffineTransform.getTranslateInstance(-bbox.width / 2, bbox.height / 2)
                    )
                )
                symbol(
                    symbols[5],
                    Delta(
                        Symbols.Handle.TC,
                        AffineTransform.getTranslateInstance(0.0, bbox.height / 2)
                    )
                )
                symbol(
                    symbols[6], Delta(
                        Symbols.Handle.TL, AffineTransform.getTranslateInstance(
                            bbox.width / 2, bbox.height / 2
                        )
                    )
                )
            }
            8 -> {
                symbol(
                    symbols[0],
                    Delta(
                        Symbols.Handle.BR,
                        AffineTransform.getTranslateInstance(0.0, -bbox!!.height / 2)
                    )
                )
                symbol(
                    symbols[1],
                    Delta(
                        Symbols.Handle.BL,
                        AffineTransform.getTranslateInstance(0.0, -bbox.height / 2)
                    )
                )
                symbol(
                    symbols[2],
                    Delta(
                        Symbols.Handle.RC,
                        AffineTransform.getTranslateInstance(-bbox.width / 2, 0.0)
                    )
                )
                symbol(symbols[3], Delta(Symbols.Handle.CC, AffineTransform()))
                symbol(
                    symbols[4], Delta(
                        Symbols.Handle.LC, AffineTransform.getTranslateInstance(
                            bbox.width / 2, 0.0
                        )
                    )
                )
                symbol(
                    symbols[5],
                    Delta(
                        Symbols.Handle.TR,
                        AffineTransform.getTranslateInstance(-bbox.width / 2, bbox.height / 2)
                    )
                )
                symbol(
                    symbols[6],
                    Delta(
                        Symbols.Handle.TC,
                        AffineTransform.getTranslateInstance(0.0, bbox.height / 2)
                    )
                )
                symbol(
                    symbols[7], Delta(
                        Symbols.Handle.TL, AffineTransform.getTranslateInstance(
                            bbox.width / 2, bbox.height / 2
                        )
                    )
                )
            }
            9 -> {
                symbol(
                    symbols[0],
                    Delta(
                        Symbols.Handle.BR,
                        AffineTransform.getTranslateInstance(-bbox!!.width / 2, -bbox.height / 2)
                    )
                )
                symbol(
                    symbols[1],
                    Delta(
                        Symbols.Handle.BC,
                        AffineTransform.getTranslateInstance(0.0, -bbox.height / 2)
                    )
                )
                symbol(
                    symbols[2], Delta(
                        Symbols.Handle.BL, AffineTransform.getTranslateInstance(
                            bbox.width / 2, -bbox.height / 2
                        )
                    )
                )
                symbol(
                    symbols[3],
                    Delta(
                        Symbols.Handle.RC,
                        AffineTransform.getTranslateInstance(-bbox.width / 2, 0.0)
                    )
                )
                symbol(symbols[4], Delta(Symbols.Handle.CC, AffineTransform()))
                symbol(
                    symbols[5], Delta(
                        Symbols.Handle.LC, AffineTransform.getTranslateInstance(
                            bbox.width / 2, 0.0
                        )
                    )
                )
                symbol(
                    symbols[6],
                    Delta(
                        Symbols.Handle.TR,
                        AffineTransform.getTranslateInstance(-bbox.width / 2, bbox.height / 2)
                    )
                )
                symbol(
                    symbols[7],
                    Delta(
                        Symbols.Handle.TC,
                        AffineTransform.getTranslateInstance(0.0, bbox.height / 2)
                    )
                )
                symbol(
                    symbols[8], Delta(
                        Symbols.Handle.TL, AffineTransform.getTranslateInstance(
                            bbox.width / 2, bbox.height / 2
                        )
                    )
                )
            }
        }
    }

    private fun symbolSize(symbol: Symbol?): Rectangle2D.Double? {
        var ssymb = symbol
        while (ssymb != null) {
            for (item in symbol!!) {
                if (item.type === Form.BBOX) {
                    return item.params as Rectangle2D.Double?
                }
                if (item.type === Form.SYMB) {
                    ssymb = (item.params as Symbols.SubSymbol?)!!.instr
                    break
                }
            }
            if (ssymb === symbol) break
        }
        return null
    }

    fun lineSymbols(
        prisymb: Symbol?,
        space: Double,
        secsymb: Symbol?,
        tersymb: Symbol?,
        ratioInt: Int,
        col: Color?
    ) {
        var ratio = ratioInt
        if (Rules.feature!!.geom.prim === Pflag.NOSP || Rules.feature!!.geom.prim === Pflag.POINT) return
        val prect = symbolSize(prisymb)
        val srect = symbolSize(secsymb)
        val trect = symbolSize(tersymb)
        if (srect == null) ratio = 0
        if (prect != null) {
            val psize = abs(prect.getY()) * sScale
            val ssize: Double = if (srect != null) abs(srect.getY()) * sScale else 0.0
            val tsize: Double = if (trect != null) abs(srect!!.getY()) * sScale else 0.0
            var prev: Point2D?
            var next: Point2D? = Point2D.Double()
            var curr: Point2D? = Point2D.Double()
            var succ: Point2D?
            var gap = true
            var piv: Boolean
            var len = 0.0
            var angle: Double
            var stcount = ratio
            var stflag = false
            var symbol = prisymb
            val git = map!!.GeomIterator(Rules.feature!!.geom)
            while (git.hasComp()) {
                git.nextComp()
                var first = true
                while (git.hasEdge()) {
                    git.nextEdge()
                    while (git.hasNode()) {
                        val node = git.next() ?: continue
                        prev = next
                        next = context.getPoint(node)
                        angle = atan2(next!!.y - prev!!.y, next.x - prev.x)
                        piv = true
                        if (first) {
                            succ = next
                            curr = succ
                            gap = space > 0
                            stcount = ratio - 1
                            symbol = prisymb
                            len = if (gap) psize * space * 0.5 else psize
                            first = false
                        } else {
                            while (curr!!.distance(next) >= len) {
                                if (piv) {
                                    var rem = len
                                    val s = prev.distance(next)
                                    val p = curr.distance(prev)
                                    if (s > 0 && p > 0) {
                                        val n = curr.distance(next)
                                        val theta = acos((s * s + p * p - n * n) / 2 / s / p)
                                        val phi = asin(p / len * sin(theta))
                                        rem = len * sin(PI - theta - phi) / sin(theta)
                                    }
                                    succ =
                                        Point2D.Double(prev.x + rem * cos(angle), prev.y + rem * sin(angle))
                                    piv = false
                                } else {
                                    succ =
                                        Point2D.Double(curr.x + len * cos(angle), curr.y + len * sin(angle))
                                }
                                if (!gap) {
                                    drawSymbol(
                                        g2!!, symbol, sScale, curr.x, curr.y, Symbols.Scheme(col),
                                        Delta(
                                            Symbols.Handle.BC, AffineTransform.getRotateInstance(
                                                atan2(succ.getY() - curr.y, succ.getX() - curr.x) + deg2rad(
                                                    90.0
                                                )
                                            )
                                        )
                                    )
                                }
                                if (space > 0) gap = !gap
                                curr = succ
                                len =
                                    if (gap) psize * space else if (--stcount == 0) if (stflag) tsize else ssize else psize
                                if (stcount == 0) {
                                    symbol = if (stflag) tersymb else secsymb
                                    if (trect != null) stflag = !stflag
                                    stcount = ratio
                                } else {
                                    symbol = prisymb
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun lineVector(style: Symbols.LineStyle) {
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        var point: Point2D?
        val git = map!!.GeomIterator(Rules.feature!!.geom)
        while (git.hasComp()) {
            git.nextComp()
            var first = true
            while (git.hasEdge()) {
                git.nextEdge()
                point = context.getPoint(git.next()!!)
                if (first) {
                    p.moveTo(point!!.x, point.y)
                    first = false
                } else {
                    p.lineTo(point!!.x, point.y)
                }
                while (git.hasNode()) {
                    val node = git.next() ?: continue
                    point = context.getPoint(node)
                    p.lineTo(point!!.x, point.y)
                }
            }
        }
        if (style.fill != null && Rules.feature!!.geom.prim === Pflag.AREA) {
            g2!!.paint = style.fill
            g2!!.fill(p)
        }
        if (style.line != null) {
            if (style.dash != null) {
                val dash = FloatArray(style.dash!!.size)
                System.arraycopy(style.dash, 0, dash, 0, style.dash!!.size)
                for (i in style.dash!!.indices) {
                    dash[i] *= sScale.toFloat()
                }
                g2!!.stroke = BasicStroke(
                    (style.width * sScale).toFloat(),
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND,
                    1f,
                    dash,
                    0f
                )
            } else {
                g2!!.stroke = BasicStroke(
                    (style.width * sScale).toFloat(),
                    BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND
                )
            }
            g2!!.paint = style.line
            g2!!.draw(p)
        }
    }

    fun lineCircle(style: Symbols.LineStyle, radiusArg: Double, units: UniHLU?) {
        var radius = radiusArg
        when (units) {
            UniHLU.HLU_FEET -> radius /= 6076.0
            UniHLU.HLU_KMTR -> radius /= 1.852
            UniHLU.HLU_HMTR -> radius /= 18.52
            UniHLU.HLU_SMIL -> radius /= 1.15078
            UniHLU.HLU_NMIL -> {}
            else -> radius /= 1852.0
        }
        radius *= context.mile(Rules.feature!!)
        val circle = Symbol()
        if (style.fill != null) {
            circle.addInstr(Form.FILL, style.fill)
            circle.addInstr(Form.RSHP, Ellipse2D.Double(-radius, -radius, radius * 2, radius * 2))
        }
        circle.addInstr(Form.FILL, style.line)
        circle.addInstr(
            Form.STRK,
            BasicStroke(style.width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, style.dash, 0f)
        )
        circle.addInstr(Form.ELPS, Ellipse2D.Double(-radius, -radius, radius * 2, radius * 2))
        val point = context.getPoint(Rules.feature!!.geom.centre!!)
        drawSymbol(g2!!, circle, 1.0, point!!.x, point.y, null, null)
    }

    fun fillPattern(image: BufferedImage?) {
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        var point: Point2D?
        when (Rules.feature!!.geom.prim) {
            Pflag.POINT -> {
                point = context.getPoint(Rules.feature!!.geom.centre!!)
                g2!!.drawImage(
                    image,
                    AffineTransformOp(
                        AffineTransform.getScaleInstance(sScale, sScale),
                        AffineTransformOp.TYPE_NEAREST_NEIGHBOR
                    ),
                    (point!!.x - 50 * sScale).toInt(),
                    (point.y - 50 * sScale).toInt()
                )
            }
            Pflag.AREA -> {
                val git = map!!.GeomIterator(Rules.feature!!.geom)
                while (git.hasComp()) {
                    git.nextComp()
                    var newComp = true
                    while (git.hasEdge()) {
                        git.nextEdge()
                        point = context.getPoint(git.next()!!)
                        if (newComp) {
                            p.moveTo(point!!.x, point.y)
                            newComp = false
                        } else {
                            p.lineTo(point!!.x, point.y)
                        }
                        while (git.hasNode()) {
                            val node = git.next() ?: continue
                            point = context.getPoint(node)
                            p.lineTo(point!!.x, point.y)
                        }
                    }
                }
                g2!!.paint = TexturePaint(
                    image,
                    Rectangle(0, 0, 1 + (300 * sScale).toInt(), 1 + (300 * sScale).toInt())
                )
                g2!!.fill(p)
            }
            else -> {}
        }
    }

    fun labelText(str: String?, font: Font, tc: Color?, delta: Delta?) {
        labelText(str, font, tc, LabelStyle.NONE, null, null, delta)
    }

    fun labelText(str: String?, font: Font, tc: Color?, style: LabelStyle?, fg: Color?, delta: Delta?) {
        labelText(str, font, tc, style, fg, null, delta)
    }

    fun labelText(
        strArg: String?,
        font: Font,
        tc: Color?,
        style: LabelStyle? = LabelStyle.NONE,
        fg: Color? = null,
        bgArg: Color? = null,
        deltaArg: Delta? = null
    ) {
        var str = strArg
        var bg = bgArg
        var delta = deltaArg
        if (delta == null) delta = Delta(Symbols.Handle.CC)
        if (bg == null) bg = Color(0x00000000, true)
        if (str == null || str.isEmpty()) str = " "
        val frc = g2!!.fontRenderContext
        val gv = font.deriveFont(font.size.toFloat()).createGlyphVector(frc, if (str == " ") "M" else str)
        val bounds = gv.visualBounds
        var width = bounds.width
        var height = bounds.height
        val label = Symbol()
        val lx: Double
        val ly: Double
        val tx: Double
        val ty: Double
        when (style) {
            LabelStyle.RRCT -> {
                width += height * 1.0
                height *= 1.5
                if (width < height) width = height
                lx = -width / 2
                ly = -height / 2
                tx = lx + height * 0.34
                ty = ly + height * 0.17
                label.addInstr(Form.BBOX, Rectangle2D.Double(lx, ly, width, height))
                label.addInstr(Form.FILL, bg)
                label.addInstr(Form.RSHP, RoundRectangle2D.Double(lx, ly, width, height, height, height))
                label.addInstr(Form.FILL, fg)
                label.addInstr(
                    Form.STRK, BasicStroke(
                        (1 + (height / 10).toInt()).toFloat(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER
                    )
                )
                label.addInstr(Form.RRCT, RoundRectangle2D.Double(lx, ly, width, height, height, height))
            }
            LabelStyle.VCLR -> {
                width += height * 1.0
                height *= 2.0
                if (width < height) width = height
                lx = -width / 2
                ly = -height / 2
                tx = lx + height * 0.27
                ty = ly + height * 0.25
                label.addInstr(Form.BBOX, Rectangle2D.Double(lx, ly, width, height))
                label.addInstr(Form.FILL, bg)
                label.addInstr(Form.RSHP, RoundRectangle2D.Double(lx, ly, width, height, height, height))
                label.addInstr(Form.FILL, fg)
                val sw = 1 + (height / 10).toInt()
                val po = (sw / 2).toDouble()
                label.addInstr(Form.STRK, BasicStroke(sw.toFloat(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
                val p = Path2D.Double()
                p.moveTo(-height * 0.2, -ly - po)
                p.lineTo(height * 0.2, -ly - po)
                p.moveTo(0.0, -ly - po)
                p.lineTo(0.0, -ly - po - height * 0.15)
                p.moveTo(-height * 0.2, ly + po)
                p.lineTo(height * 0.2, ly + po)
                p.moveTo(0.0, ly + po)
                p.lineTo(0.0, ly + po + height * 0.15)
                label.addInstr(Form.PLIN, p)
            }
            LabelStyle.PCLR -> {
                width += height * 1.0
                height *= 2.0
                if (width < height) width = height
                lx = -width / 2
                ly = -height / 2
                tx = lx + height * 0.27
                ty = ly + height * 0.25
                label.addInstr(Form.BBOX, Rectangle2D.Double(lx, ly, width, height))
                label.addInstr(Form.FILL, bg)
                label.addInstr(Form.RSHP, RoundRectangle2D.Double(lx, ly, width, height, height, height))
                label.addInstr(Form.FILL, fg)
                val sw = 1 + (height / 10).toInt()
                val po = (sw / 2).toDouble()
                label.addInstr(Form.STRK, BasicStroke(sw.toFloat(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
                val p = Path2D.Double()
                p.moveTo(-height * 0.2, -ly - po)
                p.lineTo(height * 0.2, -ly - po)
                p.moveTo(0.0, -ly - po)
                p.lineTo(0.0, -ly - po - height * 0.15)
                p.moveTo(-height * 0.2, ly + po)
                p.lineTo(height * 0.2, ly + po)
                p.moveTo(0.0, ly + po)
                p.lineTo(0.0, ly + po + height * 0.15)
                label.addInstr(Form.PLIN, p)
                label.addInstr(
                    Form.SYMB, Symbols.SubSymbol(
                        Areas.CableFlash, 1.0, 0.0, 0.0, null,
                        Delta(Symbols.Handle.CC, AffineTransform(0.0, -1.0, 1.0, 0.0, -width / 2, 0.0))
                    )
                )
                label.addInstr(
                    Form.SYMB, Symbols.SubSymbol(
                        Areas.CableFlash, 1.0, 0.0, 0.0, null,
                        Delta(Symbols.Handle.CC, AffineTransform(0.0, -1.0, 1.0, 0.0, width / 2, 0.0))
                    )
                )
            }
            LabelStyle.HCLR -> {
                width += height * 1.5
                height *= 1.5
                if (width < height) width = height
                lx = -width / 2
                ly = -height / 2
                tx = lx + height * 0.5
                ty = ly + height * 0.17
                label.addInstr(Form.BBOX, Rectangle2D.Double(lx, ly, width, height))
                label.addInstr(Form.FILL, bg)
                label.addInstr(Form.RSHP, RoundRectangle2D.Double(lx, ly, width, height, height, height))
                label.addInstr(Form.FILL, fg)
                val sw = 1 + (height / 10).toInt()
                val vo = height / 4
                label.addInstr(Form.STRK, BasicStroke(sw.toFloat(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
                val p = Path2D.Double()
                p.moveTo(-width * 0.4 - sw, -ly - vo)
                p.lineTo(-width * 0.4 - sw, ly + vo)
                p.moveTo(-width * 0.4 - sw, 0.0)
                p.lineTo(-width * 0.4 + sw, 0.0)
                p.moveTo(width * 0.4 + sw, -ly - vo)
                p.lineTo(width * 0.4 + sw, ly + vo)
                p.moveTo(width * 0.4 - sw, 0.0)
                p.lineTo(width * 0.4 + sw, 0.0)
                label.addInstr(Form.PLIN, p)
            }
            else -> {
                lx = -width / 2
                ly = -height / 2
                tx = lx
                ty = ly
                label.addInstr(Form.BBOX, Rectangle2D.Double(lx, ly, width, height))
            }
        }
        label.addInstr(
            Form.TEXT,
            Caption(str, font, tc, Delta(Symbols.Handle.TL, AffineTransform.getTranslateInstance(tx, ty)))
        )
        val point = context.getPoint(Rules.feature!!.geom.centre!!)
        drawSymbol(g2!!, label, sScale, point!!.x, point.y, null, delta)
    }

    fun lineText(str: String, font: Font, colour: Color?, dy: Double) {
        if (str.isNotEmpty()) {
            g2!!.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            g2!!.paint = colour
            val frc = g2!!.fontRenderContext
            val gv = font.deriveFont(font.size2D * sScale.toFloat()).createGlyphVector(frc, str)
            val width = gv.visualBounds.width
            val height = gv.visualBounds.height
            val offset: Double =
                (Rules.feature!!.geom.length * context.mile(Rules.feature!!) - width) / 2
            if (offset > 0) {
                var before: Point2D? = null
                var after: Point2D? = null
                val between = ArrayList<Point2D?>()
                var prev: Point2D?
                var next: Point2D? = null
                var length = 0.0
                var lb = 0.0
                var la: Double
                val git = map!!.GeomIterator(Rules.feature!!.geom)
                if (git.hasComp()) {
                    git.nextComp()
                    while (git.hasEdge()) {
                        git.nextEdge()
                        while (git.hasNode()) {
                            val node = git.next() ?: continue
                            prev = next
                            next = context.getPoint(node)
                            if (prev != null) length += sqrt(
                                (next!!.x - prev.x).pow(2.0) + (next.y - prev.y).pow(2.0)
                            )
                            if (length < offset) {
                                before = next
                                la = length
                                lb = la
                            } else if (after == null) {
                                if (length > offset + width) {
                                    after = next
                                    la = length
                                    break
                                } else {
                                    between.add(next)
                                }
                            }
                        }
                        if (after != null) break
                    }
                }
                if (after != null) {
                    val angle = atan2(after.y - before!!.y, after.x - before.x)
                    val rotate = if (abs(angle) < PI / 2) angle else angle + PI
                    val mid: Point2D = Point2D.Double((before.x + after.x) / 2, (before.y + after.y) / 2)
                    val centre = context.getPoint(Rules.feature!!.geom.centre!!)
                    val pos = AffineTransform.getTranslateInstance(-dy * sin(rotate), dy * cos(rotate))
                    pos.rotate(rotate)
                    pos.translate(mid.x - centre!!.x, mid.y - centre.y)
                    val label = Symbol()
                    label.addInstr(Form.BBOX, Rectangle2D.Double(-width / 2, -height, width, height))
                    label.addInstr(Form.TEXT, Caption(str, font, colour, Delta(Symbols.Handle.BC)))
                    drawSymbol(g2!!, label, sScale, centre.x, centre.y, null, Delta(Symbols.Handle.BC, pos))
                }
            }
        }
    }

    fun lightSector(
        col1: Color?,
        col2: Color?,
        radiusArg: Double,
        s1: Double,
        s2: Double,
        dir: Double?,
        strArg: String?
    ) {
        var radius = radiusArg
        var str = strArg
        if (zoom >= 16 && radius > 0.2) {
            radius /= 2.0.pow((zoom - 15).toDouble())
        }
        val mid = ((s1 + s2) / 2 + if (s1 > s2) 180 else 0) % 360
        g2!!.stroke = BasicStroke(
            (3.0 * sScale).toFloat(),
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_ROUND,
            1f,
            floatArrayOf(20 * sScale.toFloat(), 20 * sScale.toFloat()),
            0f
        )
        g2!!.paint = black
        val centre = context.getPoint(Rules.feature!!.geom.centre!!) as Point2D.Double?
        var radial = radius * context.mile(Rules.feature!!)
        if (dir != null) {
            g2!!.draw(
                Line2D.Double(
                    centre!!.x, centre.y, centre.x - radial * sin(deg2rad(dir)),
                    centre.y + radial * cos(deg2rad(dir))
                )
            )
        } else {
            if (s1 != 0.0 || s2 != 360.0) {
                g2!!.draw(
                    Line2D.Double(
                        centre!!.x, centre.y, centre.x - radial * sin(deg2rad(s1)),
                        centre.y + radial * cos(deg2rad(s1))
                    )
                )
                g2!!.draw(
                    Line2D.Double(
                        centre.x, centre.y, centre.x - radial * sin(deg2rad(s2)),
                        centre.y + radial * cos(deg2rad(s2))
                    )
                )
            }
        }
        val arcWidth = 10.0 * sScale
        g2!!.stroke = BasicStroke(arcWidth.toFloat(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f)
        g2!!.paint = col1
        g2!!.draw(
            Arc2D.Double(
                centre!!.x - radial, centre.y - radial, 2 * radial, 2 * radial, -(s1 + 90),
                if (s1 < s2) s1 - s2 else s1 - s2 - 360, Arc2D.OPEN
            )
        )
        if (col2 != null) {
            g2!!.paint = col2
            g2!!.draw(
                Arc2D.Double(
                    centre.x - radial + arcWidth, centre.y - radial + arcWidth, 2 * (radial - arcWidth),
                    2 * (radial - arcWidth), -(s1 + 90), if (s1 < s2) s1 - s2 else s1 - s2 - 360, Arc2D.OPEN
                )
            )
        }
        if (str != null && str.isNotEmpty()) {
            var font = Font("Arial", Font.PLAIN, 40)
            val arc = if (s2 > s1) s2 - s1 else s2 - s1 + 360
            val awidth = deg2rad(arc) * radial
            var hand = mid > 270 || mid < 90
            var phi = deg2rad(mid)
            radial += 30 * sScale
            var at =
                AffineTransform.getTranslateInstance(-radial * sin(phi) / sScale, radial * cos(phi) / sScale)
            if (font.size * sScale * str.length < awidth) {
                at.rotate(deg2rad(mid + if (hand) 0 else 180))
                labelText(str, font, black, Delta(Symbols.Handle.CC, at))
            } else if (font.size * sScale < awidth) {
                hand = mid < 180
                at.rotate(deg2rad(mid + if (hand) -90 else 90))
                labelText(
                    str, font, black, if (hand) Delta(Symbols.Handle.RC, at) else Delta(
                        Symbols.Handle.LC, at
                    )
                )
            }
            if (dir != null) {
                font = Font("Arial", Font.PLAIN, 30)
                str = "$dir°"
                hand = dir > 180
                phi = deg2rad(dir + if (hand) -0.5 else 0.5)
                radial -= 70 * sScale
                at = AffineTransform.getTranslateInstance(
                    -radial * sin(phi) / sScale,
                    radial * cos(phi) / sScale
                )
                at.rotate(deg2rad(dir + if (hand) 90 else -90))
                labelText(
                    str, font, black,
                    if (hand) Delta(Symbols.Handle.BR, at) else Delta(Symbols.Handle.BL, at)
                )
            }
        }
    }

    enum class LabelStyle {
        NONE, RRCT, RECT, ELPS, CIRC, VCLR, PCLR, HCLR
    }
}