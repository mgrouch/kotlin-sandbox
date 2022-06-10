// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.S57val
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Font
import java.awt.geom.*
import java.util.*

/**
 * @author Malcolm Herring
 */
object Notices {
    // CHECKSTYLE.OFF: LineLength
    private val Bollard = Symbols.Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(20.0, 21.0)
        p.lineTo(20.0, 16.5)
        p.lineTo(11.6, 16.5)
        p.quadTo(9.1, 9.6, 8.3, 2.0)
        p.lineTo(-8.0, -0.3)
        p.quadTo(-8.6, 9.0, -11.3, 16.5)
        p.lineTo(-23.5, 16.5)
        p.lineTo(-23.5, 21.0)
        p.closePath()
        p.moveTo(23.8, 3.0)
        p.lineTo(-10.7, -1.8)
        p.curveTo(-13.1, -2.2, -12.8, -6.0, -10.2, -5.8)
        p.lineTo(23.8, -1.1)
        p.closePath()
        p.moveTo(8.4, -4.3)
        p.curveTo(9.0, -9.3, 9.0, -11.4, 11.2, -13.0)
        p.curveTo(12.8, -15.0, 12.8, -16.7, 11.0, -18.6)
        p.curveTo(4.0, -22.2, -4.0, -22.2, -11.0, -18.6)
        p.curveTo(-12.8, -16.7, -12.8, -15.0, -11.2, -13.0)
        p.curveTo(-9.0, -11.3, -8.7, -9.5, -8.4, -6.5)
        p.closePath()
        Bollard.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    private val Motor = Symbols.Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(-5.0, 4.3)
        p.curveTo(-3.7, 5.5, -1.8, 5.7, -0.2, 4.9)
        p.curveTo(1.3, 8.7, 4.6, 10.9, 8.4, 10.9)
        p.curveTo(14.0, 10.9, 17.5, 6.3, 17.5, 2.0)
        p.curveTo(17.5, -0.7, 16.1, -3.2, 14.5, -3.2)
        p.curveTo(12.5, -3.2, 11.7, 0.8, 2.5, 1.1)
        p.curveTo(2.5, -1.2, 1.6, -2.2, 0.6, -3.0)
        p.curveTo(3.2, -5.6, 4.0, -12.6, -1.0, -16.1)
        p.curveTo(-5.3, -19.2, -11.6, -18.3, -13.7, -13.7)
        p.curveTo(-14.3, -12.2, -14.0, -11.2, -12.5, -10.6)
        p.curveTo(-8.6, -9.6, -5.3, -6.0, -4.0, -3.4)
        p.curveTo(-5.4, -2.6, -6.2, -2.0, -6.2, 0.2)
        p.curveTo(-12.8, -1.0, -17.5, 3.7, -17.5, 9.3)
        p.curveTo(-17.5, 14.7, -12.6, 18.8, -8.0, 17.6)
        p.curveTo(-7.0, 17.2, -6.6, 16.2, -7.2, 14.6)
        p.curveTo(-7.7, 12.4, -7.0, 7.7, -5.0, 4.3)
        p.closePath()
        Motor.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    private val Rowboat = Symbols.Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(-17.5, -2.0)
        p.lineTo(17.5, -2.0)
        p.lineTo(15.0, 6.0)
        p.lineTo(-11.0, 6.0)
        p.closePath()
        Rowboat.add(Symbols.Instr(Symbols.Form.PGON, p))
        Rowboat.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-6.0, -17.5, 6.0, 6.0)))
        Rowboat.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Rowboat.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-5.5, -9.0, -8.0, 0.0)))
        Rowboat.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-5.0, 10.0, -7.5, 14.0)))
        Rowboat.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Rowboat.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-5.5, -9.0, 7.0, -6.5)))
        Rowboat.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(7.3, -7.8, -5.0, 10.0)))
    }

    private val Sailboard = Symbols.Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(-6.0, 19.0)
        p.quadTo(-4.0, -5.0, 1.5, -20.0)
        p.quadTo(14.0, -7.0, 15.5, 6.5)
        p.quadTo(7.0, 17.0, -6.0, 19.0)
        p.closePath()
        Sailboard.add(Symbols.Instr(Symbols.Form.PGON, p))
        Sailboard.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Sailboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-2.0, 20.0, -10.0, 20.0)))
        Sailboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-13.0, 2.5, -3.0, 2.5)))
        Sailboard.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-15.0, -4.0, 5.0, 5.0)))
        Sailboard.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-13.0, 2.5)
        p.lineTo(-12.0, 6.0)
        p.lineTo(-12.0, 9.5)
        Sailboard.add(Symbols.Instr(Symbols.Form.PLIN, p))
        Sailboard.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-12.0, 9.5)
        p.lineTo(-7.5, 13.0)
        p.lineTo(-6.0, 19.0)
        Sailboard.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    private val Sailboat = Symbols.Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(3.75, -20.5)
        p.lineTo(3.75, 8.5)
        p.lineTo(-19.5, 8.5)
        p.closePath()
        Sailboat.add(Symbols.Instr(Symbols.Form.PGON, p))
        p = Path2D.Double()
        p.moveTo(-19.5, 12.0)
        p.lineTo(19.5, 12.0)
        p.lineTo(13.0, 20.5)
        p.lineTo(-16.0, 20.5)
        p.closePath()
        Sailboat.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    private val Slipway = Symbols.Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(-17.0, -5.5)
        p.lineTo(-13.5, 0.0)
        p.lineTo(4.0, -1.5)
        p.quadTo(18.0, -5.0, 20.0, -13.5)
        p.closePath()
        p.moveTo(-14.0, 7.0)
        p.lineTo(-14.0, 11.0)
        p.lineTo(20.0, 11.0)
        p.lineTo(20.0, 2.0)
        p.closePath()
        Slipway.add(Symbols.Instr(Symbols.Form.PGON, p))
        Slipway.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Slipway.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-14.0, 3.0, 20.0, -2.5)))
        Slipway.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Slipway.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(1.0, 1.5, 3.0, 3.0)))
        p = Path2D.Double()
        p.moveTo(-21.0, 8.5)
        p.curveTo(-17.5, 5.0, -17.5, 12.0, -13.0, 7.2)
        Slipway.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    private val Speedboat = Symbols.Symbol()

    init {
        Speedboat.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Speedboat.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-21.0, 0.0, -17.0, -1.0)))
        val p = Path2D.Double()
        p.moveTo(-17.5, 8.5)
        p.curveTo(-10.5, 13.0, -2.5, 2.0, 4.0, 6.0)
        p.curveTo(12.0, 2.0, 11.5, 9.5, 20.0, 6.0)
        Speedboat.add(Symbols.Instr(Symbols.Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(-18.5, 1.5)
        p.lineTo(-16.0, 6.0)
        p.curveTo(-9.0, 9.0, -3.5, -2.0, 4.5, 3.5)
        p.lineTo(14.5, 0.0)
        p.quadTo(19.0, -3.0, 19.5, -9.0)
        p.lineTo(9.5, -6.0)
        p.lineTo(6.5, -8.0)
        p.lineTo(2.5, -4.0)
        p.closePath()
        Speedboat.add(Symbols.Instr(Symbols.Form.PGON, p))
        Speedboat.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-1.5, -13.0, 5.0, 5.0)))
        Speedboat.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Speedboat.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-2.0, -7.0, -5.0, 0.0)))
        Speedboat.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Speedboat.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-2.0, -7.0, 5.0, -5.0)))
    }

    private val Turn = Symbols.Symbol()

    init {
        Turn.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Turn.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-9.0, -9.0, 18.0, 18.0, 270.0, 230.0, Arc2D.OPEN)))
        Turn.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-20.0, -20.0, 40.0, 40.0, 315.0, -280.0, Arc2D.OPEN)))
        val p = Path2D.Double()
        p.moveTo(21.8, -7.0)
        p.lineTo(18.8, -18.2)
        p.lineTo(10.5, -10.0)
        p.closePath()
        p.moveTo(-12.9, 0.7)
        p.lineTo(-1.7, -2.3)
        p.lineTo(-9.9, -10.5)
        p.closePath()
        Turn.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    private val Waterbike = Symbols.Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(-17.5, 13.0)
        p.curveTo(-10.5, 17.5, -2.5, 6.5, 4.0, 10.5)
        p.curveTo(12.0, 6.5, 11.5, 14.0, 20.0, 10.5)
        Waterbike.add(Symbols.Instr(Symbols.Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(-16.5, 9.5)
        p.lineTo(-16.0, 10.5)
        p.curveTo(-9.0, 13.5, -3.5, 2.5, 4.5, 8.0)
        p.quadTo(15.0, 4.0, 19.5, -4.0)
        p.closePath()
        p.moveTo(19.5, -5.0)
        p.lineTo(1.0, -5.0)
        p.lineTo(-4.5, -10.0)
        p.lineTo(-5.5, -10.0)
        p.lineTo(2.0, -2.0)
        p.lineTo(-15.0, 4.0)
        p.lineTo(-16.0, 8.0)
        p.closePath()
        Waterbike.add(Symbols.Instr(Symbols.Form.PGON, p))
        Waterbike.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-7.0, 1.0)
        p.lineTo(-7.5, -1.5)
        p.lineTo(-12.5, -3.5)
        p.lineTo(-11.5, -10.5)
        Waterbike.add(Symbols.Instr(Symbols.Form.PLIN, p))
        Waterbike.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Waterbike.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-11.5, -10.5, -3.0, -8.5)))
        Waterbike.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-11.5, -18.0, 5.0, 5.0)))
    }

    private val Waterski = Symbols.Symbol()

    init {
        Waterski.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(12.0, -18.0, 6.0, 6.0)))
        Waterski.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Waterski.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-18.0, -6.0, 0.0, -6.0)))
        Waterski.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        val p = Path2D.Double()
        p.moveTo(6.5, 17.5)
        p.lineTo(-13.0, 14.5)
        p.curveTo(-15.0, 14.25, -16.0, 13.6, -17.5, 12.0)
        Waterski.add(Symbols.Instr(Symbols.Form.PLIN, p))
        Waterski.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-1.5, -4.0)
        p.lineTo(14.0, -7.5)
        p.lineTo(9.5, 3.5)
        p.lineTo(2.0, 6.0)
        p.lineTo(-4.4, 15.8)
        Waterski.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    private val NoticeA = Symbols.Symbol()

    init {
        NoticeA.add(Symbols.Instr(Symbols.Form.FILL, Color(0xe80000)))
        NoticeA.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeA.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeA.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0)))
        NoticeA.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        NoticeA.add(Symbols.Instr(Symbols.Form.FILL, Color(0xe80000)))
        NoticeA.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, -25.0, 25.0, 25.0)))
        NoticeA.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeA.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeB = Symbols.Symbol()

    init {
        NoticeB.add(Symbols.Instr(Symbols.Form.FILL, Color(0xe80000)))
        NoticeB.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeB.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeB.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0)))
        NoticeB.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeB.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeE = Symbols.Symbol()

    init {
        NoticeE.add(Symbols.Instr(Symbols.Form.FILL, Color(0x0000a0)))
        NoticeE.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeE.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeE.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeE.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
    }


    val Notice = Symbols.Symbol()

    init {
        Notice.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Notice.add(Symbols.Instr(Symbols.Form.FILL, Color(0xe80000)))
        Notice.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        Notice.add(Symbols.Instr(Symbols.Form.FILL, Color(0x0000a0)))
        Notice.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0)))
        Notice.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Notice.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Notice.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    val NoticeA1 = Symbols.Symbol()

    init {
        NoticeA1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA1.add(Symbols.Instr(Symbols.Form.FILL, Color(0xe80000)))
        NoticeA1.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeA1.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA1.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeA1.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-30.0, -10.0, 60.0, 20.0)))
        NoticeA1.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeA1.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    val NoticeA1a = Symbols.Symbol()

    init {
        NoticeA1a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA1a.add(Symbols.Instr(Symbols.Form.FILL, Color(0xe80000)))
        NoticeA1a.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA1a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA1a.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeA1a.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-29.0, -10.0, 58.0, 20.0)))
        NoticeA1a.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeA1a.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
    }

    val NoticeA2 = Symbols.Symbol()

    init {
        NoticeA2.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA2.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA2.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-10.0, 23.0)
        p.lineTo(-10.0, 0.0)
        p.lineTo(-6.0, 0.0)
        p.lineTo(-12.5, -8.0)
        p.lineTo(-19.0, 0.0)
        p.lineTo(-15.0, 0.0)
        p.lineTo(-15.0, 23.0)
        p.closePath()
        p.moveTo(10.0, 8.0)
        p.lineTo(10.0, -15.0)
        p.lineTo(6.0, -15.0)
        p.lineTo(12.5, -23.0)
        p.lineTo(19.0, -15.0)
        p.lineTo(15.0, -15.0)
        p.lineTo(15.0, 8.0)
        p.closePath()
        NoticeA2.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeA3 = Symbols.Symbol()

    init {
        NoticeA3.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA3.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA2, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-10.0, 12.0)
        p.lineTo(-6.0, 12.0)
        p.lineTo(-12.5, 4.0)
        p.lineTo(-19.0, 12.0)
        p.closePath()
        p.moveTo(10.0, -3.0)
        p.lineTo(6.0, -3.0)
        p.lineTo(12.5, -11.0)
        p.lineTo(19.0, -3.0)
        p.closePath()
        NoticeA3.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeA4 = Symbols.Symbol()

    init {
        NoticeA4.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA4.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA4.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-10.0, -15.0)
        p.lineTo(-10.0, 8.0)
        p.lineTo(-6.0, 8.0)
        p.lineTo(-12.5, 16.0)
        p.lineTo(-19.0, 8.0)
        p.lineTo(-15.0, 8.0)
        p.lineTo(-15.0, -15.0)
        p.closePath()
        p.moveTo(10.0, 15.0)
        p.lineTo(10.0, -8.0)
        p.lineTo(6.0, -8.0)
        p.lineTo(12.5, -16.0)
        p.lineTo(19.0, -8.0)
        p.lineTo(15.0, -8.0)
        p.lineTo(15.0, 15.0)
        p.closePath()
        NoticeA4.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeA4_1 = Symbols.Symbol()

    init {
        NoticeA4_1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA4_1.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA4, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-10.0, -4.0)
        p.lineTo(-6.0, -4.0)
        p.lineTo(-12.5, 4.0)
        p.lineTo(-19.0, -4.0)
        p.closePath()
        p.moveTo(10.0, 5.0)
        p.lineTo(6.0, 5.0)
        p.lineTo(12.5, -3.0)
        p.lineTo(19.0, 5.0)
        p.closePath()
        NoticeA4_1.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeA5 = Symbols.Symbol()

    init {
        NoticeA5.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA5.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-5.3, 14.6)
        p.lineTo(-5.3, 4.0)
        p.lineTo(0.0, 4.0)
        p.curveTo(4.2, 4.0, 7.4, 3.5, 9.4, 0.0)
        p.curveTo(11.4, -2.8, 11.4, -7.2, 9.4, -10.5)
        p.curveTo(7.4, -13.6, 4.2, -14.0, 0.0, -14.0)
        p.lineTo(-11.0, -14.0)
        p.lineTo(-11.0, 14.6)
        p.closePath()
        p.moveTo(-5.3, -1.0)
        p.lineTo(0.0, -1.0)
        p.curveTo(6.5, -1.0, 6.5, -9.0, 0.0, -9.0)
        p.lineTo(-5.3, -9.0)
        p.closePath()
        NoticeA5.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeA5_1 = Symbols.Symbol()

    init {
        NoticeA5_1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA5_1.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeA6 = Symbols.Symbol()

    init {
        NoticeA6.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA6.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA6.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    Harbours.Anchor, 0.4, 0.0, 0.0, Symbols.Scheme(
                        Color.black
                    ), Symbols.Delta(Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(180.0)))
                )
            )
        )
    }

    val NoticeA7 = Symbols.Symbol()

    init {
        NoticeA7.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA7.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA7.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Bollard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA8 = Symbols.Symbol()

    init {
        NoticeA8.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA8.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA8.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Turn, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA9 = Symbols.Symbol()

    init {
        NoticeA9.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA9.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA9.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(7f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA9.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-23.0, 10.0)
        p.curveTo(-11.0, 10.0, -12.0, 4.0, 0.0, 4.0)
        p.curveTo(12.0, 4.0, 11.0, 10.0, 23.0, 10.0)
        p.moveTo(-23.0, -3.0)
        p.curveTo(-11.0, -3.0, -12.0, -9.0, 0.0, -9.0)
        p.curveTo(12.0, -9.0, 11.0, -3.0, 23.0, -3.0)
        NoticeA9.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeA10a = Symbols.Symbol()

    init {
        NoticeA10a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA10a.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeA10a.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeA10a.add(Symbols.Instr(Symbols.Form.FILL, Color(0xe80000)))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeA10a.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeA10a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA10a.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeA10a.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeA10b = Symbols.Symbol()

    init {
        NoticeA10b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA10b.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    NoticeA10a, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(180.0))
                    )
                )
            )
        )
    }

    val NoticeA12 = Symbols.Symbol()

    init {
        NoticeA12.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA12.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA12.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Motor, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA13 = Symbols.Symbol()

    init {
        NoticeA13.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA13.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA13.add(
            Symbols.Instr(
                Symbols.Form.TEXT, Symbols.Caption(
                    "SPORT", Font("Arial", Font.BOLD, 15), Color.black, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 5.0)
                    )
                )
            )
        )
    }

    val NoticeA14 = Symbols.Symbol()

    init {
        NoticeA14.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA14.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA14.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Waterski, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA15 = Symbols.Symbol()

    init {
        NoticeA15.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA15.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA15.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Sailboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA16 = Symbols.Symbol()

    init {
        NoticeA16.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA16.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA16.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Rowboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA17 = Symbols.Symbol()

    init {
        NoticeA17.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA17.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA17.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Sailboard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA18 = Symbols.Symbol()

    init {
        NoticeA18.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA18.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA18.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Speedboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA19 = Symbols.Symbol()

    init {
        NoticeA19.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA19.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA19.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Slipway, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA20 = Symbols.Symbol()

    init {
        NoticeA20.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA20.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA20.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Waterbike, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeB1a = Symbols.Symbol()

    init {
        NoticeB1a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB1a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(21.0, 8.0)
        p.lineTo(-8.0, 8.0)
        p.lineTo(-8.0, 18.0)
        p.lineTo(-21.0, 0.0)
        p.lineTo(-8.0, -18.0)
        p.lineTo(-8.0, -8.0)
        p.lineTo(21.0, -8.0)
        p.closePath()
        NoticeB1a.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB1b = Symbols.Symbol()

    init {
        NoticeB1b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB1b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-21.0, 8.0)
        p.lineTo(8.0, 8.0)
        p.lineTo(8.0, 18.0)
        p.lineTo(21.0, 0.0)
        p.lineTo(8.0, -18.0)
        p.lineTo(8.0, -8.0)
        p.lineTo(-21.0, -8.0)
        p.closePath()
        NoticeB1b.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB2a = Symbols.Symbol()

    init {
        NoticeB2a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB2a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB2a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(18.0, 21.0)
        p.lineTo(18.0, 10.0)
        p.lineTo(-15.0, -10.0)
        p.lineTo(-15.0, -15.0)
        NoticeB2a.add(Symbols.Instr(Symbols.Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(-21.0, -15.0)
        p.lineTo(-9.0, -15.0)
        p.closePath()
        NoticeB2a.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB2b = Symbols.Symbol()

    init {
        NoticeB2b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB2b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB2b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB2b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-18.0, 21.0)
        p.lineTo(-18.0, 10.0)
        p.lineTo(15.0, -10.0)
        p.lineTo(15.0, -15.0)
        NoticeB2b.add(Symbols.Instr(Symbols.Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(15.0, -21.0)
        p.lineTo(21.0, -15.0)
        p.lineTo(9.0, -15.0)
        p.closePath()
        NoticeB2b.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB3a = Symbols.Symbol()

    init {
        NoticeB3a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB3a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB3a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB3a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, 21.0, -15.0, -15.0)))
        val p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(-21.0, -15.0)
        p.lineTo(-9.0, -15.0)
        p.closePath()
        NoticeB3a.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeB3a.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        NoticeB3a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(15.0, -21.0, 15.0, 15.0)))
        p = Path2D.Double()
        p.moveTo(15.0, 21.0)
        p.lineTo(21.0, 15.0)
        p.lineTo(9.0, 15.0)
        p.closePath()
        NoticeB3a.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB3b = Symbols.Symbol()

    init {
        NoticeB3b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB3b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB3b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB3b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(15.0, 21.0, 15.0, -15.0)))
        val p = Path2D.Double()
        p.moveTo(15.0, -21.0)
        p.lineTo(21.0, -15.0)
        p.lineTo(9.0, -15.0)
        p.closePath()
        NoticeB3b.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeB3b.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        NoticeB3b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, -21.0, -15.0, 15.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(-21.0, 15.0)
        p.lineTo(-9.0, 15.0)
        p.closePath()
        NoticeB3b.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB4a = Symbols.Symbol()

    init {
        NoticeB4a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB4a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB2a, 1.0, 0.0, 0.0, null, null)))
        NoticeB4a.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        val p = Path2D.Double()
        p.moveTo(18.0, -21.0)
        p.lineTo(18.0, -10.0)
        p.lineTo(-15.0, 10.0)
        p.lineTo(-15.0, 15.0)
        NoticeB4a.add(Symbols.Instr(Symbols.Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(-21.0, 15.0)
        p.lineTo(-9.0, 15.0)
        p.closePath()
        NoticeB4a.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB4b = Symbols.Symbol()

    init {
        NoticeB4b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB4b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB2b, 1.0, 0.0, 0.0, null, null)))
        NoticeB4b.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        val p = Path2D.Double()
        p.moveTo(-18.0, -21.0)
        p.lineTo(-18.0, -10.0)
        p.lineTo(15.0, 10.0)
        p.lineTo(15.0, 15.0)
        NoticeB4b.add(Symbols.Instr(Symbols.Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(15.0, 21.0)
        p.lineTo(21.0, 15.0)
        p.lineTo(9.0, 15.0)
        p.closePath()
        NoticeB4b.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeB5 = Symbols.Symbol()

    init {
        NoticeB5.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB5.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB5.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        NoticeB5.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(15.0, 0.0, -15.0, 0.0)))
    }

    val NoticeB6 = Symbols.Symbol()

    init {
        NoticeB6.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB6.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeB7 = Symbols.Symbol()

    init {
        NoticeB7.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB7.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB7.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
    }

    val NoticeB8 = Symbols.Symbol()

    init {
        NoticeB8.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB8.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB8.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        NoticeB8.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 15.0, 0.0, -15.0)))
    }

    val NoticeB9a = Symbols.Symbol()

    init {
        NoticeB9a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB9a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB9a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-21.0, 0.0, 21.0, 0.0)))
        NoticeB9a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 21.0, 0.0, 0.0)))
    }

    val NoticeB9b = Symbols.Symbol()

    init {
        NoticeB9b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB9b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB9b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-21.0, 0.0, 21.0, 0.0)))
        NoticeB9b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 21.0, 0.0, -21.0)))
    }

    val NoticeB11 = Symbols.Symbol()

    init {
        NoticeB11.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB11.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB11.add(
            Symbols.Instr(
                Symbols.Form.TEXT, Symbols.Caption(
                    "VHF", Font("Arial", Font.BOLD, 20), Color.black, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 0.0)
                    )
                )
            )
        )
    }

    val NoticeC1 = Symbols.Symbol()

    init {
        NoticeC1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC1.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(0.0, 12.0)
        p.lineTo(15.0, 21.0)
        p.closePath()
        NoticeC1.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeC2 = Symbols.Symbol()

    init {
        NoticeC2.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC2.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(0.0, -12.0)
        p.lineTo(15.0, -21.0)
        p.closePath()
        NoticeC2.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeC3 = Symbols.Symbol()

    init {
        NoticeC3.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC3.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(21.0, -15.0)
        p.lineTo(12.0, 0.0)
        p.lineTo(21.0, 15.0)
        p.closePath()
        p.moveTo(-21.0, -15.0)
        p.lineTo(-12.0, 0.0)
        p.lineTo(-21.0, 15.0)
        p.closePath()
        NoticeC3.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeC4 = Symbols.Symbol()

    init {
        NoticeC4.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC4.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeC5a = Symbols.Symbol()

    init {
        NoticeC5a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC5a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-21.0, -21.0)
        p.lineTo(10.0, -21.0)
        p.lineTo(21.0, 0.0)
        p.lineTo(10.0, 21.0)
        p.lineTo(-21.0, 21.0)
        p.closePath()
        NoticeC5a.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeC5b = Symbols.Symbol()

    init {
        NoticeC5b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC5b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(21.0, -21.0)
        p.lineTo(-10.0, -21.0)
        p.lineTo(-21.0, 0.0)
        p.lineTo(-10.0, 21.0)
        p.lineTo(21.0, 21.0)
        p.closePath()
        NoticeC5b.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeD1a = Symbols.Symbol()

    init {
        NoticeD1a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD1a.add(Symbols.Instr(Symbols.Form.FILL, Color.yellow))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeD1a.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeD1a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeD1a.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeD1a.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeD1b = Symbols.Symbol()

    init {
        NoticeD1b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD1b.add(Symbols.Instr(Symbols.Form.FILL, Color.yellow))
        val p = Path2D.Double()
        p.moveTo(-30.0, 0.0)
        p.lineTo(-15.0, 25.0)
        p.lineTo(15.0, -25.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(15.0, 25.0)
        p.lineTo(-15.0, -25.0)
        p.closePath()
        NoticeD1b.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeD1b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeD1b.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeD1b.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeD2a = Symbols.Symbol()

    init {
        NoticeD2a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD2a.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeD2a.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeD2a.add(Symbols.Instr(Symbols.Form.FILL, Color(0x00e800)))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeD2a.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeD2a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeD2a.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeD2a.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeD2b = Symbols.Symbol()

    init {
        NoticeD2b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD2b.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    NoticeD2a, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(180.0))
                    )
                )
            )
        )
    }

    val NoticeD3a = Symbols.Symbol()

    init {
        NoticeD3a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD3a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(28.0, 10.0)
        p.lineTo(-10.0, 10.0)
        p.lineTo(-10.0, 20.0)
        p.lineTo(-28.0, 0.0)
        p.lineTo(-10.0, -20.0)
        p.lineTo(-10.0, -10.0)
        p.lineTo(28.0, -10.0)
        p.closePath()
        NoticeD3a.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeD3b = Symbols.Symbol()

    init {
        NoticeD3b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD3b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-28.0, 10.0)
        p.lineTo(10.0, 10.0)
        p.lineTo(10.0, 20.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(10.0, -20.0)
        p.lineTo(10.0, -10.0)
        p.lineTo(-28.0, -10.0)
        p.closePath()
        NoticeD3b.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE1 = Symbols.Symbol()

    init {
        NoticeE1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE1.add(Symbols.Instr(Symbols.Form.FILL, Color(0x00e800)))
        NoticeE1.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeE1.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE1.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeE1.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-10.0, -30.0, 20.0, 60.0)))
        NoticeE1.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeE1.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    val NoticeE2 = Symbols.Symbol()

    init {
        NoticeE2.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE2.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(5.0, -25.0)
        p.lineTo(-10.0, -1.0)
        p.lineTo(10.0, -1.0)
        p.lineTo(-10.0, 20.0)
        p.lineTo(-7.0, 20.0)
        p.lineTo(-12.0, 25.0)
        p.lineTo(-16.0, 20.0)
        p.lineTo(-13.0, 20.0)
        p.lineTo(4.0, 1.0)
        p.lineTo(-14.0, 1.0)
        p.lineTo(2.0, -25.0)
        p.closePath()
        NoticeE2.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE3 = Symbols.Symbol()

    init {
        NoticeE3.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(25.0, -20.0, 25.0, 20.0)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, -20.0, -25.0, 20.0)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, -15.0, -15.0, 20.0)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-5.0, -15.0, -5.0, 20.0)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(5.0, -15.0, 5.0, 20.0)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(15.0, -15.0, 15.0, 20.0)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-26.0, 18.5, 26.0, 18.5)))
        NoticeE3.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-26.0, -15.0, 26.0, -15.0)))
    }

    val NoticeE4a = Symbols.Symbol()

    init {
        NoticeE4a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE4a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-20.0, -10.0)
        p.lineTo(-5.0, -10.0)
        p.lineTo(-5.0, -20.0)
        p.lineTo(5.0, -20.0)
        p.lineTo(5.0, -10.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(15.0, 0.0)
        p.lineTo(-15.0, 0.0)
        p.closePath()
        p.moveTo(-25.0, 5.0)
        p.lineTo(25.0, 5.0)
        p.lineTo(25.0, 10.0)
        p.lineTo(-25.0, 10.0)
        p.closePath()
        NoticeE4a.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE4b = Symbols.Symbol()

    init {
        NoticeE4b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE4b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-5.0, 0.0)
        p.lineTo(-5.0, -10.0)
        p.lineTo(5.0, -10.0)
        p.lineTo(5.0, 0.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(15.0, 10.0)
        p.lineTo(-15.0, 10.0)
        p.closePath()
        NoticeE4b.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5 = Symbols.Symbol()

    init {
        NoticeE5.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-5.3, 14.6)
        p.lineTo(-5.3, 4.0)
        p.lineTo(0.0, 4.0)
        p.curveTo(4.2, 4.0, 7.4, 3.5, 9.4, 0.0)
        p.curveTo(11.4, -2.8, 11.4, -7.2, 9.4, -10.5)
        p.curveTo(7.4, -13.6, 4.2, -14.0, 0.0, -14.0)
        p.lineTo(-11.0, -14.0)
        p.lineTo(-11.0, 14.6)
        p.closePath()
        p.moveTo(-5.3, -1.0)
        p.lineTo(0.0, -1.0)
        p.curveTo(6.5, -1.0, 6.5, -9.0, 0.0, -9.0)
        p.lineTo(-5.3, -9.0)
        p.closePath()
        NoticeE5.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_1 = Symbols.Symbol()

    init {
        NoticeE5_1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_1.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeE5_2 = Symbols.Symbol()

    init {
        NoticeE5_2.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_2.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeE5_3 = Symbols.Symbol()

    init {
        NoticeE5_3.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_3.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeE5_4 = Symbols.Symbol()

    init {
        NoticeE5_4.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_4.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 25.0)
        p.lineTo(0.0, -28.0)
        p.lineTo(28.0, 25.0)
        p.closePath()
        NoticeE5_4.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_5 = Symbols.Symbol()

    init {
        NoticeE5_5.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_5.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 25.0)
        p.lineTo(0.0, -28.0)
        p.lineTo(28.0, 25.0)
        p.closePath()
        p.moveTo(0.0, 24.0)
        p.lineTo(-15.0, 2.0)
        p.lineTo(15.0, 2.0)
        p.closePath()
        NoticeE5_5.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_6 = Symbols.Symbol()

    init {
        NoticeE5_6.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_6.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 25.0)
        p.lineTo(0.0, -28.0)
        p.lineTo(28.0, 25.0)
        p.closePath()
        p.moveTo(0.0, 7.0)
        p.lineTo(-10.0, -8.0)
        p.lineTo(10.0, -8.0)
        p.closePath()
        p.moveTo(0.0, 24.0)
        p.lineTo(-10.0, 9.0)
        p.lineTo(10.0, 9.0)
        p.closePath()
        NoticeE5_6.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_7 = Symbols.Symbol()

    init {
        NoticeE5_7.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_7.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 25.0)
        p.lineTo(0.0, -28.0)
        p.lineTo(28.0, 25.0)
        p.closePath()
        p.moveTo(0.0, -1.0)
        p.lineTo(-8.0, -11.0)
        p.lineTo(8.0, -11.0)
        p.closePath()
        p.moveTo(0.0, 11.0)
        p.lineTo(-8.0, 1.0)
        p.lineTo(8.0, 1.0)
        p.closePath()
        p.moveTo(0.0, 23.0)
        p.lineTo(-8.0, 13.0)
        p.lineTo(8.0, 13.0)
        p.closePath()
        NoticeE5_7.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_8 = Symbols.Symbol()

    init {
        NoticeE5_8.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_8.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, -25.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, -25.0)
        p.closePath()
        NoticeE5_8.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_9 = Symbols.Symbol()

    init {
        NoticeE5_9.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_9.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, -25.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, -25.0)
        p.closePath()
        p.moveTo(0.0, 8.0)
        p.lineTo(-15.0, -14.0)
        p.lineTo(15.0, -14.0)
        p.closePath()
        NoticeE5_9.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_10 = Symbols.Symbol()

    init {
        NoticeE5_10.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_10.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, -25.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, -25.0)
        p.closePath()
        p.moveTo(0.0, -5.0)
        p.lineTo(-10.0, -20.0)
        p.lineTo(10.0, -20.0)
        p.closePath()
        p.moveTo(0.0, 15.0)
        p.lineTo(-10.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.closePath()
        NoticeE5_10.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_11 = Symbols.Symbol()

    init {
        NoticeE5_11.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_11.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, -25.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, -25.0)
        p.closePath()
        p.moveTo(0.0, -12.0)
        p.lineTo(-8.0, -22.0)
        p.lineTo(8.0, -22.0)
        p.closePath()
        p.moveTo(0.0, 3.0)
        p.lineTo(-8.0, -7.0)
        p.lineTo(8.0, -7.0)
        p.closePath()
        p.moveTo(0.0, 18.0)
        p.lineTo(-8.0, 8.0)
        p.lineTo(8.0, 8.0)
        p.closePath()
        NoticeE5_11.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_12 = Symbols.Symbol()

    init {
        NoticeE5_12.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_12.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 0.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(0.0, -28.0)
        p.closePath()
        NoticeE5_12.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_13 = Symbols.Symbol()

    init {
        NoticeE5_13.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_13.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 0.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(0.0, -28.0)
        p.closePath()
        p.moveTo(0.0, 15.0)
        p.lineTo(-15.0, -7.0)
        p.lineTo(15.0, -7.0)
        p.closePath()
        NoticeE5_13.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_14 = Symbols.Symbol()

    init {
        NoticeE5_14.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_14.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 0.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(0.0, -28.0)
        p.closePath()
        p.moveTo(0.0, 0.0)
        p.lineTo(-10.0, -15.0)
        p.lineTo(10.0, -15.0)
        p.closePath()
        p.moveTo(0.0, 20.0)
        p.lineTo(-10.0, 5.0)
        p.lineTo(10.0, 5.0)
        p.closePath()
        NoticeE5_14.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE5_15 = Symbols.Symbol()

    init {
        NoticeE5_15.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_15.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 0.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(0.0, -28.0)
        p.closePath()
        p.moveTo(0.0, -7.0)
        p.lineTo(-8.0, -17.0)
        p.lineTo(8.0, -17.0)
        p.closePath()
        p.moveTo(0.0, 8.0)
        p.lineTo(-8.0, -2.0)
        p.lineTo(8.0, -2.0)
        p.closePath()
        p.moveTo(0.0, 23.0)
        p.lineTo(-8.0, 13.0)
        p.lineTo(8.0, 13.0)
        p.closePath()
        NoticeE5_15.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE6 = Symbols.Symbol()

    init {
        NoticeE6.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE6.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE6.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    Harbours.Anchor, 0.4, 0.0, 0.0, Symbols.Scheme(
                        Color.white
                    ), null
                )
            )
        )
    }

    val NoticeE7 = Symbols.Symbol()

    init {
        NoticeE7.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE7.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE7.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Bollard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE7_1 = Symbols.Symbol()

    init {
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(20.0, 25.0, 20.0, -10.0)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(22.0, -8.0, -15.0, -20.0)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(20.0, 8.0, 0.0, -15.0)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-17.0, 2.0)
        p.quadTo(-5.0, 0.0, 7.0, 2.0)
        p.lineTo(9.0, 12.0)
        p.lineTo(7.0, 20.0)
        p.lineTo(6.0, 20.0)
        p.lineTo(6.0, 23.0)
        p.lineTo(3.0, 23.0)
        p.lineTo(3.0, 20.0)
        p.quadTo(-5.0, 22.0, -13.0, 20.0)
        p.lineTo(-13.0, 23.0)
        p.lineTo(-16.0, 23.0)
        p.lineTo(-16.0, 20.0)
        p.lineTo(-17.0, 20.0)
        p.lineTo(-19.0, 12.0)
        p.closePath()
        p.moveTo(-15.0, 4.0)
        p.quadTo(-3.0, 2.0, 5.0, 4.0)
        p.lineTo(6.0, 11.0)
        p.quadTo(-5.0, 9.0, -16.0, 11.0)
        p.closePath()
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.FILL, Color(0x0000a0)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-16.0, 13.0, 4.0, 4.0)))
        NoticeE7_1.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(2.0, 13.0, 4.0, 4.0)))
    }

    val NoticeE8 = Symbols.Symbol()

    init {
        NoticeE8.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE8.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE8.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Turn, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE9a = Symbols.Symbol()

    init {
        NoticeE9a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
        NoticeE9a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE9b = Symbols.Symbol()

    init {
        NoticeE9b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
        NoticeE9b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE9c = Symbols.Symbol()

    init {
        NoticeE9c.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9c.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9c.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9c.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
        NoticeE9c.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9c.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE9d = Symbols.Symbol()

    init {
        NoticeE9d.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9d.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9d.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9d.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9d.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE9d.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9d.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
    }

    val NoticeE9e = Symbols.Symbol()

    init {
        NoticeE9e.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9e.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9e.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9e.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9e.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE9e.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9e.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
    }

    val NoticeE9f = Symbols.Symbol()

    init {
        NoticeE9f.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9f.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9f.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9f.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9f.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE9f.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9f.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE9g = Symbols.Symbol()

    init {
        NoticeE9g.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9g.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9g.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9g.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9g.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE9g.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9g.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE9h = Symbols.Symbol()

    init {
        NoticeE9h.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9h.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9h.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9h.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9h.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE9h.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9h.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
        NoticeE9h.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE9i = Symbols.Symbol()

    init {
        NoticeE9i.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9i.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9i.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9i.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9i.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE9i.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9i.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
        NoticeE9i.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE10a = Symbols.Symbol()

    init {
        NoticeE10a.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10a.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0)))
        NoticeE10a.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10a.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
    }

    val NoticeE10b = Symbols.Symbol()

    init {
        NoticeE10b.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10b.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0)))
        NoticeE10b.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10b.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
    }

    val NoticeE10c = Symbols.Symbol()

    init {
        NoticeE10c.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10c.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10c.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10c.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10c.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE10c.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10c.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
    }

    val NoticeE10d = Symbols.Symbol()

    init {
        NoticeE10d.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10d.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10d.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10d.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10d.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE10d.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10d.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
    }

    val NoticeE10e = Symbols.Symbol()

    init {
        NoticeE10e.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10e.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10e.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10e.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10e.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE10e.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10e.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
        NoticeE10e.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE10f = Symbols.Symbol()

    init {
        NoticeE10f.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10f.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10f.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10f.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10f.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE10f.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10f.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
        NoticeE10f.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE11 = Symbols.Symbol()

    init {
        NoticeE11.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE11.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE11.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        NoticeE11.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-27.0, -27.0, 27.0, 27.0)))
    }

    val NoticeE13 = Symbols.Symbol()

    init {
        NoticeE13.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE13.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-4.0, -16.0)
        p.lineTo(9.0, -16.0)
        p.lineTo(9.0, -14.0)
        p.lineTo(3.5, -14.0)
        p.lineTo(3.5, -7.0)
        p.lineTo(5.0, -7.0)
        p.lineTo(5.0, 1.0)
        p.lineTo(6.5, 1.0)
        p.lineTo(6.5, 5.0)
        p.lineTo(17.5, 5.0)
        p.lineTo(17.5, 1.0)
        p.lineTo(19.0, 1.0)
        p.lineTo(19.0, 15.0)
        p.lineTo(17.5, 15.0)
        p.lineTo(17.5, 10.0)
        p.lineTo(17.5, 10.0)
        p.lineTo(6.5, 10.0)
        p.lineTo(6.5, 13.0)
        p.lineTo(-2.0, 13.0)
        p.lineTo(-2.0, 10.0)
        p.lineTo(-9.0, 10.0)
        p.quadTo(-13.5, 10.0, -13.5, 16.0)
        p.lineTo(-19.0, 16.0)
        p.quadTo(-19.0, 5.0, -9.0, 5.0)
        p.lineTo(-2.0, 5.0)
        p.lineTo(-2.0, 1.0)
        p.lineTo(0.0, 1.0)
        p.lineTo(0.0, -7.0)
        p.lineTo(1.5, -7.0)
        p.lineTo(1.5, -14.0)
        p.lineTo(-4.0, -14.0)
        p.closePath()
        NoticeE13.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE14 = Symbols.Symbol()

    init {
        NoticeE14.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE14.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-18.0, -18.0)
        p.lineTo(-11.0, -7.0)
        p.lineTo(-9.0, -10.0)
        p.lineTo(-14.0, -18.0)
        p.closePath()
        p.moveTo(9.5, 7.0)
        p.lineTo(22.5, 9.0)
        p.lineTo(21.5, 5.5)
        p.lineTo(12.0, 4.0)
        p.closePath()
        p.moveTo(-19.0, -16.5)
        p.lineTo(-13.0, -6.5)
        p.quadTo(-15.5, -2.0, -12.5, 0.0)
        p.lineTo(4.0, 11.0)
        p.quadTo(7.0, 13.0, 10.0, 9.0)
        p.lineTo(21.5, 11.0)
        p.curveTo(15.5, 23.0, 1.0, 18.5, -9.0, 12.0)
        p.curveTo(-18.0, 6.0, -28.5, -7.0, -19.0, -16.5)
        p.closePath()
        NoticeE14.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeE15 = Symbols.Symbol()

    init {
        NoticeE15.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE15.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE15.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Motor, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE16 = Symbols.Symbol()

    init {
        NoticeE16.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE16.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE16.add(
            Symbols.Instr(
                Symbols.Form.TEXT, Symbols.Caption(
                    "SPORT", Font("Arial", Font.BOLD, 15), Color.white, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 5.0)
                    )
                )
            )
        )
    }

    val NoticeE17 = Symbols.Symbol()

    init {
        NoticeE17.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE17.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE17.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Waterski, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE18 = Symbols.Symbol()

    init {
        NoticeE18.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE18.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE18.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Sailboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE19 = Symbols.Symbol()

    init {
        NoticeE19.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE19.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE19.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Rowboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE20 = Symbols.Symbol()

    init {
        NoticeE20.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE20.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE20.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Sailboard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE21 = Symbols.Symbol()

    init {
        NoticeE21.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE21.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE21.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Speedboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE22 = Symbols.Symbol()

    init {
        NoticeE22.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE22.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE22.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Slipway, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE23 = Symbols.Symbol()

    init {
        NoticeE23.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE23.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE23.add(
            Symbols.Instr(
                Symbols.Form.TEXT, Symbols.Caption(
                    "VHF", Font("Arial", Font.BOLD, 20), Color.white, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 0.0)
                    )
                )
            )
        )
    }

    val NoticeE24 = Symbols.Symbol()

    init {
        NoticeE24.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE24.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE24.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Waterbike, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }


    val NoticeBoard = Symbols.Symbol()

    init {
        NoticeBoard.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 30.0)))
        NoticeBoard.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(20.0, -15.0)
        p.lineTo(-20.0, -15.0)
        p.closePath()
        NoticeBoard.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeBoard.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeBoard.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeBoard.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeTriangle = Symbols.Symbol()

    init {
        NoticeTriangle.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 30.0)))
        NoticeTriangle.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        val p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(0.0, -15.0)
        p.closePath()
        NoticeTriangle.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeTriangle.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeTriangle.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeTriangle.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    // CHECKSTYLE.OFF: SingleSpaceSeparator
    val NmkCevni = EnumMap<S57val.CatNMK, Symbols.Symbol>(
        S57val.CatNMK::class.java
    )

    init {
        NmkCevni[S57val.CatNMK.NMK_UNKN] = Notice
        NmkCevni[S57val.CatNMK.NMK_NENT] = NoticeA1
        NmkCevni[S57val.CatNMK.NMK_CLSA] = NoticeA1a
        NmkCevni[S57val.CatNMK.NMK_NOVK] = NoticeA2
        NmkCevni[S57val.CatNMK.NMK_NCOV] = NoticeA3
        NmkCevni[S57val.CatNMK.NMK_NPAS] = NoticeA4
        NmkCevni[S57val.CatNMK.NMK_NCPS] = NoticeA4_1
        NmkCevni[S57val.CatNMK.NMK_NBRT] = NoticeA5
        NmkCevni[S57val.CatNMK.NMK_NBLL] = NoticeA5_1
        NmkCevni[S57val.CatNMK.NMK_NANK] = NoticeA6
        NmkCevni[S57val.CatNMK.NMK_NMOR] = NoticeA7
        NmkCevni[S57val.CatNMK.NMK_NTRN] = NoticeA8
        NmkCevni[S57val.CatNMK.NMK_NWSH] = NoticeA9
        NmkCevni[S57val.CatNMK.NMK_NPSL] = NoticeA10a
        NmkCevni[S57val.CatNMK.NMK_NPSR] = NoticeA10b
        NmkCevni[S57val.CatNMK.NMK_NMTC] = NoticeA12
        NmkCevni[S57val.CatNMK.NMK_NSPC] = NoticeA13
        NmkCevni[S57val.CatNMK.NMK_NWSK] = NoticeA14
        NmkCevni[S57val.CatNMK.NMK_NSLC] = NoticeA15
        NmkCevni[S57val.CatNMK.NMK_NUPC] = NoticeA16
        NmkCevni[S57val.CatNMK.NMK_NSLB] = NoticeA17
        NmkCevni[S57val.CatNMK.NMK_NWBK] = NoticeA20
        NmkCevni[S57val.CatNMK.NMK_NHSC] = NoticeA18
        NmkCevni[S57val.CatNMK.NMK_NLBG] = NoticeA19
        NmkCevni[S57val.CatNMK.NMK_MVTL] = NoticeB1a
        NmkCevni[S57val.CatNMK.NMK_MVTR] = NoticeB1b
        NmkCevni[S57val.CatNMK.NMK_MVTP] = NoticeB2a
        NmkCevni[S57val.CatNMK.NMK_MVTS] = NoticeB2b
        NmkCevni[S57val.CatNMK.NMK_KPTP] = NoticeB3a
        NmkCevni[S57val.CatNMK.NMK_KPTS] = NoticeB3b
        NmkCevni[S57val.CatNMK.NMK_CSTP] = NoticeB4a
        NmkCevni[S57val.CatNMK.NMK_CSTS] = NoticeB4b
        NmkCevni[S57val.CatNMK.NMK_STOP] = NoticeB5
        NmkCevni[S57val.CatNMK.NMK_SPDL] = NoticeB6
        NmkCevni[S57val.CatNMK.NMK_SHRN] = NoticeB7
        NmkCevni[S57val.CatNMK.NMK_KPLO] = NoticeB8
        NmkCevni[S57val.CatNMK.NMK_GWJN] = NoticeB9a
        NmkCevni[S57val.CatNMK.NMK_GWCS] = NoticeB9b
        NmkCevni[S57val.CatNMK.NMK_MKRC] = NoticeB11
        NmkCevni[S57val.CatNMK.NMK_LMDP] = NoticeC1
        NmkCevni[S57val.CatNMK.NMK_LMHR] = NoticeC2
        NmkCevni[S57val.CatNMK.NMK_LMWD] = NoticeC3
        NmkCevni[S57val.CatNMK.NMK_NAVR] = NoticeC4
        NmkCevni[S57val.CatNMK.NMK_CHDL] = NoticeC5a
        NmkCevni[S57val.CatNMK.NMK_CHDR] = NoticeC5b
        NmkCevni[S57val.CatNMK.NMK_CHTW] = NoticeD1a
        NmkCevni[S57val.CatNMK.NMK_CHOW] = NoticeD1b
        NmkCevni[S57val.CatNMK.NMK_OPTR] = NoticeD2a
        NmkCevni[S57val.CatNMK.NMK_OPTL] = NoticeD2b
        NmkCevni[S57val.CatNMK.NMK_PRTL] = NoticeD3a
        NmkCevni[S57val.CatNMK.NMK_PRTR] = NoticeD3b
        NmkCevni[S57val.CatNMK.NMK_ENTP] = NoticeE1
        NmkCevni[S57val.CatNMK.NMK_OVHC] = NoticeE2
        NmkCevni[S57val.CatNMK.NMK_WEIR] = NoticeE3
        NmkCevni[S57val.CatNMK.NMK_FERN] = NoticeE4a
        NmkCevni[S57val.CatNMK.NMK_FERI] = NoticeE4b
        NmkCevni[S57val.CatNMK.NMK_BRTP] = NoticeE5
        NmkCevni[S57val.CatNMK.NMK_BTLL] = NoticeE5_1
        NmkCevni[S57val.CatNMK.NMK_BTLS] = NoticeE5_2
        NmkCevni[S57val.CatNMK.NMK_BTRL] = NoticeE5_3
        NmkCevni[S57val.CatNMK.NMK_BTUP] = NoticeE5_4
        NmkCevni[S57val.CatNMK.NMK_BTP1] = NoticeE5_5
        NmkCevni[S57val.CatNMK.NMK_BTP2] = NoticeE5_6
        NmkCevni[S57val.CatNMK.NMK_BTP3] = NoticeE5_7
        NmkCevni[S57val.CatNMK.NMK_BTUN] = NoticeE5_8
        NmkCevni[S57val.CatNMK.NMK_BTN1] = NoticeE5_9
        NmkCevni[S57val.CatNMK.NMK_BTN2] = NoticeE5_10
        NmkCevni[S57val.CatNMK.NMK_BTN3] = NoticeE5_11
        NmkCevni[S57val.CatNMK.NMK_BTUM] = NoticeE5_12
        NmkCevni[S57val.CatNMK.NMK_BTU1] = NoticeE5_13
        NmkCevni[S57val.CatNMK.NMK_BTU2] = NoticeE5_14
        NmkCevni[S57val.CatNMK.NMK_BTU3] = NoticeE5_15
        NmkCevni[S57val.CatNMK.NMK_ANKP] = NoticeE6
        NmkCevni[S57val.CatNMK.NMK_MORP] = NoticeE7
        NmkCevni[S57val.CatNMK.NMK_VLBT] = NoticeE7_1
        NmkCevni[S57val.CatNMK.NMK_TRNA] = NoticeE8
        NmkCevni[S57val.CatNMK.NMK_SWWC] = NoticeE9a
        NmkCevni[S57val.CatNMK.NMK_SWWR] = NoticeE9b
        NmkCevni[S57val.CatNMK.NMK_SWWL] = NoticeE9c
        NmkCevni[S57val.CatNMK.NMK_WRSA] = NoticeE9d
        NmkCevni[S57val.CatNMK.NMK_WLSA] = NoticeE9e
        NmkCevni[S57val.CatNMK.NMK_WRSL] = NoticeE9f
        NmkCevni[S57val.CatNMK.NMK_WLSR] = NoticeE9g
        NmkCevni[S57val.CatNMK.NMK_WRAL] = NoticeE9h
        NmkCevni[S57val.CatNMK.NMK_WLAR] = NoticeE9i
        NmkCevni[S57val.CatNMK.NMK_MWWC] = NoticeE10a
        NmkCevni[S57val.CatNMK.NMK_MWWJ] = NoticeE10b
        NmkCevni[S57val.CatNMK.NMK_MWAR] = NoticeE10c
        NmkCevni[S57val.CatNMK.NMK_MWAL] = NoticeE10d
        NmkCevni[S57val.CatNMK.NMK_WARL] = NoticeE10e
        NmkCevni[S57val.CatNMK.NMK_WALR] = NoticeE10f
        NmkCevni[S57val.CatNMK.NMK_PEND] = NoticeE11
        NmkCevni[S57val.CatNMK.NMK_DWTR] = NoticeE13
        NmkCevni[S57val.CatNMK.NMK_TELE] = NoticeE14
        NmkCevni[S57val.CatNMK.NMK_MTCP] = NoticeE15
        NmkCevni[S57val.CatNMK.NMK_SPCP] = NoticeE16
        NmkCevni[S57val.CatNMK.NMK_WSKP] = NoticeE17
        NmkCevni[S57val.CatNMK.NMK_SLCP] = NoticeE18
        NmkCevni[S57val.CatNMK.NMK_UPCP] = NoticeE19
        NmkCevni[S57val.CatNMK.NMK_SLBP] = NoticeE20
        NmkCevni[S57val.CatNMK.NMK_RADI] = NoticeE23
        NmkCevni[S57val.CatNMK.NMK_WTBP] = NoticeE24
        NmkCevni[S57val.CatNMK.NMK_HSCP] = NoticeE21
        NmkCevni[S57val.CatNMK.NMK_LBGP] = NoticeE22
    }

    // CHECKSTYLE.ON: SingleSpaceSeparator
    private val NoticeBB = Symbols.Symbol()

    init {
        NoticeBB.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeBB.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-29.0, -29.0, -29.0, 29.0)))
        NoticeBB.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(29.0, -29.0, 29.0, 29.0)))
        NoticeBB.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeBB.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeBP = Symbols.Symbol()

    init {
        NoticeBP.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeBP.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        NoticeBP.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeBP.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeBP.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeCR = Symbols.Symbol()

    init {
        NoticeCR.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeCR.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeCR.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeCR.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeCR.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    private val NoticeKT = Symbols.Symbol()

    init {
        NoticeKT.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeKT.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        NoticeKT.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticeKT.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeKT.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeBnank = Symbols.Symbol()

    init {
        NoticeBnank.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Harbours.Anchor, 0.4, 0.0, 0.0, null, null)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-27.0, -27.0, 27.0, 27.0)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBnank.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBlmhr = Symbols.Symbol()

    init {
        NoticeBlmhr.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-29.0, -29.0)
        p.lineTo(29.0, -29.0)
        p.lineTo(0.0, 0.0)
        p.closePath()
        symbols.ss.add(Symbols.Instr(Symbols.Form.PGON, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBlmhr.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBktpm = Symbols.Symbol()

    init {
        NoticeBktpm.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -26.0)
        p.lineTo(-20.0, -12.0)
        p.lineTo(-8.0, -12.0)
        p.closePath()
        symbols.ss.add(Symbols.Instr(Symbols.Form.PGON, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-14.0, -16.0, -14.0, 25.0)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBktpm.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBktsm = Symbols.Symbol()

    init {
        NoticeBktsm.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(14.0, -26.0)
        p.lineTo(20.0, -12.0)
        p.lineTo(8.0, -12.0)
        p.closePath()
        symbols.ss.add(Symbols.Instr(Symbols.Form.PGON, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(14.0, -16.0, 14.0, 25.0)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBktsm.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBktmr = Symbols.Symbol()

    init {
        NoticeBktmr.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(0.0, -26.0)
        p.lineTo(-6.0, -12.0)
        p.lineTo(6.0, -12.0)
        p.closePath()
        symbols.ss.add(Symbols.Instr(Symbols.Form.PGON, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -16.0, 0.0, 25.0)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBktmr.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBcrtp = Symbols.Symbol()

    init {
        NoticeBcrtp.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -26.0)
        p.lineTo(-20.0, -12.0)
        p.lineTo(-8.0, -12.0)
        p.closePath()
        symbols.ss.add(Symbols.Instr(Symbols.Form.PGON, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(-14.0, -16.0)
        p.lineTo(-14.0, 0.0)
        p.lineTo(14.0, 10.0)
        p.lineTo(14.0, 25.0)
        symbols.ss.add(Symbols.Instr(Symbols.Form.PLIN, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBcrtp.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBcrts = Symbols.Symbol()

    init {
        NoticeBcrts.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(14.0, -26.0)
        p.lineTo(20.0, -12.0)
        p.lineTo(8.0, -12.0)
        p.closePath()
        symbols.ss.add(Symbols.Instr(Symbols.Form.PGON, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(14.0, -16.0)
        p.lineTo(14.0, 0.0)
        p.lineTo(-14.0, 10.0)
        p.lineTo(-14.0, 25.0)
        symbols.ss.add(Symbols.Instr(Symbols.Form.PLIN, p))
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBcrts.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBtrbm = Symbols.Symbol()

    init {
        NoticeBtrbm.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(15f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -25.0, 0.0, 25.0)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBtrbm.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticeBrspd = Symbols.Symbol()

    init {
        NoticeBrspd.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        val ss = Symbols.Symbol()
        symbols.ss.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Symbols.Instr(Symbols.Form.N1, symbols.ss))
        symbols.ss = Symbols.Symbol()
        symbols.ss.add(
            Symbols.Instr(
                Symbols.Form.TEXT, Symbols.Caption(
                    "R", Font("Arial", Font.BOLD, 60), null, Symbols.Delta(
                        Symbols.Handle.CC, null
                    )
                )
            )
        )
        symbols.ss.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Symbols.Instr(Symbols.Form.N2, symbols.ss))
        NoticeBrspd.add(Symbols.Instr(Symbols.Form.COLR, colours))
    }

    val NoticePBwral = Symbols.Symbol()

    init {
        NoticePBwral.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePBwral.add(Symbols.Instr(Symbols.Form.FILL, Color(0xffff00)))
        val p = Path2D.Double()
        p.moveTo(-20.0, -25.0)
        p.lineTo(-8.0, -5.0)
        p.lineTo(-8.0, 25.0)
        p.lineTo(8.0, 25.0)
        p.lineTo(8.0, -5.0)
        p.lineTo(20.0, -25.0)
        p.lineTo(5.0, -25.0)
        p.lineTo(-5.0, -10.0)
        p.lineTo(-15.0, -25.0)
        p.closePath()
        NoticePBwral.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeBwral = Symbols.Symbol()

    init {
        NoticeBwral.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBwral.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeBwral.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeBwral.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticePBwral, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeBwlar = Symbols.Symbol()

    init {
        NoticeBwlar.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBwlar.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeBwlar.add(Symbols.Instr(Symbols.Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeBwlar.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getScaleInstance(-1.0, 1.0)
                    )
                )
            )
        )
    }

    val NoticeBoptr = Symbols.Symbol()

    init {
        NoticeBoptr.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBoptr.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticeBoptr.add(Symbols.Instr(Symbols.Form.FILL, Color(0x00a000)))
        NoticeBoptr.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-20.0, -20.0, 40.0, 40.0)))
    }

    val NoticeBoptl = Symbols.Symbol()

    init {
        NoticeBoptl.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBoptl.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticeBoptl.add(Symbols.Instr(Symbols.Form.FILL, Color(0xf00000)))
        val p = Path2D.Double()
        p.moveTo(0.0, -20.0)
        p.lineTo(-20.0, 20.0)
        p.lineTo(20.0, 20.0)
        p.closePath()
        NoticeBoptl.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NmkBniwr = EnumMap<S57val.CatNMK, Symbols.Symbol>(
        S57val.CatNMK::class.java
    )

    init {
        NmkBniwr[S57val.CatNMK.NMK_NANK] = NoticeBnank
        NmkBniwr[S57val.CatNMK.NMK_LMHR] = NoticeBlmhr
        NmkBniwr[S57val.CatNMK.NMK_OPTR] = NoticeBoptr
        NmkBniwr[S57val.CatNMK.NMK_OPTL] = NoticeBoptl
        NmkBniwr[S57val.CatNMK.NMK_WRAL] = NoticeBwral
        NmkBniwr[S57val.CatNMK.NMK_WLAR] = NoticeBwlar
        NmkBniwr[S57val.CatNMK.NMK_KTPM] = NoticeBktpm
        NmkBniwr[S57val.CatNMK.NMK_KTSM] = NoticeBktsm
        NmkBniwr[S57val.CatNMK.NMK_KTMR] = NoticeBktmr
        NmkBniwr[S57val.CatNMK.NMK_CRTP] = NoticeBcrtp
        NmkBniwr[S57val.CatNMK.NMK_CRTS] = NoticeBcrts
        NmkBniwr[S57val.CatNMK.NMK_TRBM] = NoticeBtrbm
        NmkBniwr[S57val.CatNMK.NMK_RSPD] = NoticeBrspd
    }

    val NoticePwralL = Symbols.Symbol()

    init {
        NoticePwralL.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwralL.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        NoticePwralL.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticePwralL.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.TC, AffineTransform.getScaleInstance(0.5, 0.5)
                    )
                )
            )
        )
    }

    val NoticePwralR = Symbols.Symbol()

    init {
        NoticePwralR.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwralR.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBwral, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticePwlarL = Symbols.Symbol()

    init {
        NoticePwlarL.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwlarL.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        NoticePwlarL.add(Symbols.Instr(Symbols.Form.PGON, p))
        NoticePwlarL.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.TC, AffineTransform.getScaleInstance(-0.5, 0.5)
                    )
                )
            )
        )
    }

    val NoticePwlarR = Symbols.Symbol()

    init {
        NoticePwlarR.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwlarR.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBwlar, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticePktmR = Symbols.Symbol()

    init {
        NoticePktmR.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmR.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticePktmR.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePktmR.add(Symbols.Instr(Symbols.Form.FILL, Color(0x00d400)))
        NoticePktmR.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-20.0, -20.0, 40.0, 40.0)))
    }

    val NoticePktmL = Symbols.Symbol()

    init {
        NoticePktmL.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmL.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeKT, 1.0, 0.0, 0.0, null, null)))
        NoticePktmL.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePktmL.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd40000)))
        NoticePktmL.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-12.0, 2.0, 24.0, 24.0)))
    }

    val NoticePktmrL = Symbols.Symbol()

    init {
        NoticePktmrL.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmrL.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeKT, 1.0, 0.0, 0.0, null, null)))
        NoticePktmrL.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        NoticePktmrL.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd40000)))
        NoticePktmrL.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, 2.0, -12.0, 28.0)))
        NoticePktmrL.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(12.0, 2.0, 12.0, 28.0)))
        NoticePktmrL.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, 15.0, 12.0, 15.0)))
    }

    val NoticePktmrR = Symbols.Symbol()

    init {
        NoticePktmrR.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmrR.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticePktmrR.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        NoticePktmrR.add(Symbols.Instr(Symbols.Form.FILL, Color(0x00d400)))
        NoticePktmrR.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, -20.0, -15.0, 20.0)))
        NoticePktmrR.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(15.0, -20.0, 15.0, 20.0)))
        NoticePktmrR.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, 0.0, 15.0, 0.0)))
    }

    val NoticePcrL = Symbols.Symbol()

    init {
        NoticePcrL.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePcrL.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePcrL.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticePcrL.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePcrL.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd40000)))
        NoticePcrL.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, -12.0, 12.0, 12.0)))
        NoticePcrL.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, 12.0, 12.0, -12.0)))
    }

    val NoticePcrR = Symbols.Symbol()

    init {
        NoticePcrR.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePcrR.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticePcrR.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePcrR.add(Symbols.Instr(Symbols.Form.FILL, Color(0x00d400)))
        NoticePcrR.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, -12.0, 12.0, 12.0)))
        NoticePcrR.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, 12.0, 12.0, -12.0)))
    }

    val NoticeRphib = Symbols.Symbol()

    init {
        NoticeRphib.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRphib.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd40000)))
        NoticeRphib.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRphib.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, -20.0, 20.0, 20.0)))
    }

    val NoticeRinfo = Symbols.Symbol()

    init {
        NoticeRinfo.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRinfo.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd40000)))
        NoticeRinfo.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
    }

    val NoticeRnpas = Symbols.Symbol()

    init {
        NoticeRnpas.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnpas.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnpas.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-10.0, -15.0)
        p.lineTo(-10.0, 8.0)
        p.lineTo(-6.0, 8.0)
        p.lineTo(-12.5, 16.0)
        p.lineTo(-19.0, 8.0)
        p.lineTo(-15.0, 8.0)
        p.lineTo(-15.0, -15.0)
        p.closePath()
        p.moveTo(10.0, 15.0)
        p.lineTo(10.0, -8.0)
        p.lineTo(6.0, -8.0)
        p.lineTo(12.5, -16.0)
        p.lineTo(19.0, -8.0)
        p.lineTo(15.0, -8.0)
        p.lineTo(15.0, 15.0)
        p.closePath()
        NoticeRnpas.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeRnank = Symbols.Symbol()

    init {
        NoticeRnank.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnank.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnank.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    Harbours.Anchor, 0.4, 0.0, 0.0, Symbols.Scheme(
                        Color.black
                    ), null
                )
            )
        )
    }

    val NoticeRnwsh = Symbols.Symbol()

    init {
        NoticeRnwsh.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnwsh.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnwsh.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-23.0, 10.0)
        p.curveTo(-11.0, 10.0, -12.0, 4.0, 0.0, 4.0)
        p.curveTo(12.0, 4.0, 11.0, 10.0, 23.0, 10.0)
        p.moveTo(-23.0, -3.0)
        p.curveTo(-11.0, -3.0, -12.0, -9.0, 0.0, -9.0)
        p.curveTo(12.0, -9.0, 11.0, -3.0, 23.0, -3.0)
        NoticeRnwsh.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val NoticeRlmhr = Symbols.Symbol()

    init {
        NoticeRlmhr.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRlmhr.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null)))
        NoticeRlmhr.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(27.0, -27.0)
        p.lineTo(-27.0, -27.0)
        p.closePath()
        NoticeRlmhr.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeRtrna = Symbols.Symbol()

    init {
        NoticeRtrna.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRtrna.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticeRtrna.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRtrna.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-15.0, -15.0, 30.0, 30.0, 315.0, -280.0, Arc2D.OPEN)
            )
        )
        val p = Path2D.Double()
        p.moveTo(18.8, -2.0)
        p.lineTo(15.8, -13.2)
        p.lineTo(7.5, -5.0)
        p.closePath()
        NoticeRtrna.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeRncps = Symbols.Symbol()

    init {
        NoticeRncps.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRncps.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRncps.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-10.0, 0.0)
        p.lineTo(-10.0, 8.0)
        p.lineTo(-6.0, 8.0)
        p.lineTo(-12.5, 16.0)
        p.lineTo(-19.0, 8.0)
        p.lineTo(-15.0, 8.0)
        p.lineTo(-15.0, 0.0)
        p.closePath()
        p.moveTo(10.0, 0.0)
        p.lineTo(10.0, -8.0)
        p.lineTo(6.0, -8.0)
        p.lineTo(12.5, -16.0)
        p.lineTo(19.0, -8.0)
        p.lineTo(15.0, -8.0)
        p.lineTo(15.0, 0.0)
        p.closePath()
        NoticeRncps.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeRnsmc = Symbols.Symbol()

    init {
        NoticeRnsmc.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnsmc.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnsmc.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-15.0, 5.0)
        p.lineTo(15.0, 5.0)
        p.lineTo(25.0, -10.0)
        p.lineTo(12.0, -5.0)
        p.lineTo(-18.0, -1.0)
        p.closePath()
        p.moveTo(-23.0, 2.0)
        p.lineTo(-21.0, 10.0)
        p.lineTo(-18.0, 8.0)
        p.lineTo(-20.0, 0.0)
        p.closePath()
        NoticeRnsmc.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeRattn = Symbols.Symbol()

    init {
        NoticeRattn.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRattn.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null)))
        NoticeRattn.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRattn.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeRattn.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -20.0, 0.0, 10.0)))
        NoticeRattn.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 15.0, 0.0, 20.0)))
    }

    val NoticeRfwcr = Symbols.Symbol()

    init {
        NoticeRfwcr.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRfwcr.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null)))
        NoticeRfwcr.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(-8.0, -15.0)
        p.lineTo(-8.0, 5.0)
        p.lineTo(-20.0, 5.0)
        p.lineTo(-20.0, 15.0)
        p.lineTo(-8.0, 15.0)
        p.lineTo(-8.0, 25.0)
        p.lineTo(8.0, 25.0)
        p.lineTo(8.0, 15.0)
        p.lineTo(20.0, 15.0)
        p.lineTo(20.0, 5.0)
        p.lineTo(8.0, 5.0)
        p.lineTo(8.0, -15.0)
        p.closePath()
        NoticeRfwcr.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val NoticeRship = Symbols.Symbol()

    init {
        NoticeRship.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRship.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticeRship.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)
            )
        )
        NoticeRship.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        NoticeRship.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, -12.0, 10.0, 10.0)))
        NoticeRship.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-12.0, -8.0, -8.0, -12.0)))
        NoticeRship.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(12.0, -12.0, -10.0, 10.0)))
        NoticeRship.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(12.0, -8.0, 8.0, -12.0)))
        NoticeRship.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-17.0, -13.0, 30.0, 30.0, 185.0, 80.0, Arc2D.OPEN)
            )
        )
        NoticeRship.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-13.0, -13.0, 30.0, 30.0, 275.0, 80.0, Arc2D.OPEN)
            )
        )
    }

    val NmkPpwbcl = EnumMap<S57val.CatNMK, Symbols.Symbol>(
        S57val.CatNMK::class.java
    )

    init {
        NmkPpwbcl[S57val.CatNMK.NMK_WRAL] = NoticePwralL
        NmkPpwbcl[S57val.CatNMK.NMK_WLAR] = NoticePwlarL
        NmkPpwbcl[S57val.CatNMK.NMK_KTPM] = NoticePktmL
        NmkPpwbcl[S57val.CatNMK.NMK_KTSM] = NoticePktmL
        NmkPpwbcl[S57val.CatNMK.NMK_KTMR] = NoticePktmrL
        NmkPpwbcl[S57val.CatNMK.NMK_CRTP] = NoticePcrL
        NmkPpwbcl[S57val.CatNMK.NMK_CRTS] = NoticePcrL
    }

    val NmkPpwbcr = EnumMap<S57val.CatNMK, Symbols.Symbol>(
        S57val.CatNMK::class.java
    )

    init {
        NmkPpwbcr[S57val.CatNMK.NMK_WRAL] = NoticePwralR
        NmkPpwbcr[S57val.CatNMK.NMK_WLAR] = NoticePwlarR
        NmkPpwbcr[S57val.CatNMK.NMK_KTPM] = NoticePktmR
        NmkPpwbcr[S57val.CatNMK.NMK_KTSM] = NoticePktmR
        NmkPpwbcr[S57val.CatNMK.NMK_KTMR] = NoticePktmrR
        NmkPpwbcr[S57val.CatNMK.NMK_CRTP] = NoticePcrR
        NmkPpwbcr[S57val.CatNMK.NMK_CRTS] = NoticePcrR
    }

    val NmkRiwr = EnumMap<S57val.CatNMK, Symbols.Symbol>(
        S57val.CatNMK::class.java
    )

    init {
        NmkRiwr[S57val.CatNMK.NMK_NPAS] = NoticeRnpas
        NmkRiwr[S57val.CatNMK.NMK_NANK] = NoticeRnank
        NmkRiwr[S57val.CatNMK.NMK_NWSH] = NoticeRnwsh
        NmkRiwr[S57val.CatNMK.NMK_LMHR] = NoticeRlmhr
        NmkRiwr[S57val.CatNMK.NMK_TRNA] = NoticeRtrna
        NmkRiwr[S57val.CatNMK.NMK_NCPS] = NoticeRncps
        NmkRiwr[S57val.CatNMK.NMK_NSMC] = NoticeRnsmc
        NmkRiwr[S57val.CatNMK.NMK_ATTN] = NoticeRattn
        NmkRiwr[S57val.CatNMK.NMK_FWCR] = NoticeRfwcr
        NmkRiwr[S57val.CatNMK.NMK_SHIP] = NoticeRship
    }

    @JvmStatic
    fun getScheme(sys: S57val.MarSYS?, bank: S57val.BnkWTW?): Symbols.Scheme {
        val colours = ArrayList<Color?>()
        val scheme = Symbols.Scheme(colours)
        when (sys) {
            S57val.MarSYS.SYS_BNWR, S57val.MarSYS.SYS_BWR2 -> when (bank) {
                S57val.BnkWTW.BWW_LEFT -> {
                    colours.add(Color.white)
                    colours.add(Color(0xf00000))
                }
                S57val.BnkWTW.BWW_RGHT -> {
                    colours.add(Color.white)
                    colours.add(Color(0x00a000))
                }
                else -> {
                    colours.add(Color(0xff8040))
                    colours.add(Color.black)
                }
            }
            else -> {}
        }
        return scheme
    }

    @JvmStatic
    fun getNotice(cat: S57val.CatNMK, sys: S57val.MarSYS?, bank: S57val.BnkWTW?): Symbols.Symbol? {
        var symbol: Symbols.Symbol? = null
        when (sys) {
            S57val.MarSYS.SYS_CEVN -> symbol = NmkCevni[cat]
            S57val.MarSYS.SYS_BNWR, S57val.MarSYS.SYS_BWR2 -> symbol = NmkBniwr[cat]
            S57val.MarSYS.SYS_PPWB -> when (bank) {
                S57val.BnkWTW.BWW_LEFT -> symbol = NmkPpwbcl[cat]
                S57val.BnkWTW.BWW_RGHT -> symbol = NmkPpwbcr[cat]
                else -> {}
            }
            S57val.MarSYS.SYS_RIWR -> symbol = NmkRiwr[cat]
            else -> {}
        }
        return symbol
    }
}