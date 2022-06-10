// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.S57val
import s57.S57val.BnkWTW
import s57.S57val.CatNMK
import s57.S57val.MarSYS
import s57.symbols.Symbols.Caption
import s57.symbols.Symbols.Form
import s57.symbols.Symbols.Instr
import s57.symbols.Symbols.SubSymbol
import s57.symbols.Symbols.Symbol
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Font
import java.awt.geom.*


/**
 * @author Malcolm Herring
 */
object Notices {

    private val Bollard = Symbol()

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
        Bollard.add(Instr(Form.PGON, p))
    }

    private val Motor = Symbol()

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
        Motor.add(Instr(Form.PGON, p))
    }

    private val Rowboat = Symbol()

    init {
        val p = Path2D.Double()
        p.moveTo(-17.5, -2.0)
        p.lineTo(17.5, -2.0)
        p.lineTo(15.0, 6.0)
        p.lineTo(-11.0, 6.0)
        p.closePath()
        Rowboat.add(Instr(Form.PGON, p))
        Rowboat.add(Instr(Form.RSHP, Ellipse2D.Double(-6.0, -17.5, 6.0, 6.0)))
        Rowboat.add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Rowboat.add(Instr(Form.LINE, Line2D.Double(-5.5, -9.0, -8.0, 0.0)))
        Rowboat.add(Instr(Form.LINE, Line2D.Double(-5.0, 10.0, -7.5, 14.0)))
        Rowboat.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Rowboat.add(Instr(Form.LINE, Line2D.Double(-5.5, -9.0, 7.0, -6.5)))
        Rowboat.add(Instr(Form.LINE, Line2D.Double(7.3, -7.8, -5.0, 10.0)))
    }

    private val Sailboard = Symbol()

    init {
        var p = Path2D.Double()
        p.moveTo(-6.0, 19.0)
        p.quadTo(-4.0, -5.0, 1.5, -20.0)
        p.quadTo(14.0, -7.0, 15.5, 6.5)
        p.quadTo(7.0, 17.0, -6.0, 19.0)
        p.closePath()
        Sailboard.add(Instr(Form.PGON, p))
        Sailboard.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Sailboard.add(Instr(Form.LINE, Line2D.Double(-2.0, 20.0, -10.0, 20.0)))
        Sailboard.add(Instr(Form.LINE, Line2D.Double(-13.0, 2.5, -3.0, 2.5)))
        Sailboard.add(Instr(Form.RSHP, Ellipse2D.Double(-15.0, -4.0, 5.0, 5.0)))
        Sailboard.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-13.0, 2.5)
        p.lineTo(-12.0, 6.0)
        p.lineTo(-12.0, 9.5)
        Sailboard.add(Instr(Form.PLIN, p))
        Sailboard.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-12.0, 9.5)
        p.lineTo(-7.5, 13.0)
        p.lineTo(-6.0, 19.0)
        Sailboard.add(Instr(Form.PLIN, p))
    }

    private val Sailboat = Symbol()

    init {
        var p = Path2D.Double()
        p.moveTo(3.75, -20.5)
        p.lineTo(3.75, 8.5)
        p.lineTo(-19.5, 8.5)
        p.closePath()
        Sailboat.add(Instr(Form.PGON, p))
        p = Path2D.Double()
        p.moveTo(-19.5, 12.0)
        p.lineTo(19.5, 12.0)
        p.lineTo(13.0, 20.5)
        p.lineTo(-16.0, 20.5)
        p.closePath()
        Sailboat.add(Instr(Form.PGON, p))
    }

    private val Slipway = Symbol()

    init {
        var p = Path2D.Double()
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
        Slipway.add(Instr(Form.PGON, p))
        Slipway.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Slipway.add(Instr(Form.LINE, Line2D.Double(-14.0, 3.0, 20.0, -2.5)))
        Slipway.add(Instr(Form.STRK, BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Slipway.add(Instr(Form.ELPS, Ellipse2D.Double(1.0, 1.5, 3.0, 3.0)))
        p = Path2D.Double()
        p.moveTo(-21.0, 8.5)
        p.curveTo(-17.5, 5.0, -17.5, 12.0, -13.0, 7.2)
        Slipway.add(Instr(Form.PLIN, p))
    }

    private val Speedboat = Symbol()

    init {
        Speedboat.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Speedboat.add(Instr(Form.LINE, Line2D.Double(-21.0, 0.0, -17.0, -1.0)))
        var p = Path2D.Double()
        p.moveTo(-17.5, 8.5)
        p.curveTo(-10.5, 13.0, -2.5, 2.0, 4.0, 6.0)
        p.curveTo(12.0, 2.0, 11.5, 9.5, 20.0, 6.0)
        Speedboat.add(Instr(Form.PLIN, p))
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
        Speedboat.add(Instr(Form.PGON, p))
        Speedboat.add(Instr(Form.RSHP, Ellipse2D.Double(-1.5, -13.0, 5.0, 5.0)))
        Speedboat.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Speedboat.add(Instr(Form.LINE, Line2D.Double(-2.0, -7.0, -5.0, 0.0)))
        Speedboat.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Speedboat.add(Instr(Form.LINE, Line2D.Double(-2.0, -7.0, 5.0, -5.0)))
    }

    private val Turn = Symbol()

    init {
        Turn.add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Turn.add(Instr(Form.EARC, Arc2D.Double(-9.0, -9.0, 18.0, 18.0, 270.0, 230.0, Arc2D.OPEN)))
        Turn.add(Instr(Form.EARC, Arc2D.Double(-20.0, -20.0, 40.0, 40.0, 315.0, -280.0, Arc2D.OPEN)))
        val p = Path2D.Double()
        p.moveTo(21.8, -7.0)
        p.lineTo(18.8, -18.2)
        p.lineTo(10.5, -10.0)
        p.closePath()
        p.moveTo(-12.9, 0.7)
        p.lineTo(-1.7, -2.3)
        p.lineTo(-9.9, -10.5)
        p.closePath()
        Turn.add(Instr(Form.PGON, p))
    }

    private val Waterbike = Symbol()

    init {
        var p = Path2D.Double()
        p.moveTo(-17.5, 13.0)
        p.curveTo(-10.5, 17.5, -2.5, 6.5, 4.0, 10.5)
        p.curveTo(12.0, 6.5, 11.5, 14.0, 20.0, 10.5)
        Waterbike.add(Instr(Form.PLIN, p))
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
        Waterbike.add(Instr(Form.PGON, p))
        Waterbike.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-7.0, 1.0)
        p.lineTo(-7.5, -1.5)
        p.lineTo(-12.5, -3.5)
        p.lineTo(-11.5, -10.5)
        Waterbike.add(Instr(Form.PLIN, p))
        Waterbike.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Waterbike.add(Instr(Form.LINE, Line2D.Double(-11.5, -10.5, -3.0, -8.5)))
        Waterbike.add(Instr(Form.RSHP, Ellipse2D.Double(-11.5, -18.0, 5.0, 5.0)))
    }

    private val Waterski = Symbol()

    init {
        Waterski.add(Instr(Form.RSHP, Ellipse2D.Double(12.0, -18.0, 6.0, 6.0)))
        Waterski.add(Instr(Form.STRK, BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Waterski.add(Instr(Form.LINE, Line2D.Double(-18.0, -6.0, 0.0, -6.0)))
        Waterski.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        var p = Path2D.Double()
        p.moveTo(6.5, 17.5)
        p.lineTo(-13.0, 14.5)
        p.curveTo(-15.0, 14.25, -16.0, 13.6, -17.5, 12.0)
        Waterski.add(Instr(Form.PLIN, p))
        Waterski.add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(-1.5, -4.0)
        p.lineTo(14.0, -7.5)
        p.lineTo(9.5, 3.5)
        p.lineTo(2.0, 6.0)
        p.lineTo(-4.4, 15.8)
        Waterski.add(Instr(Form.PLIN, p))
    }

    private val NoticeA = Symbol()

    init {
        NoticeA.add(Instr(Form.FILL, Color(0xe80000)))
        NoticeA.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeA.add(Instr(Form.FILL, Color.white))
        NoticeA.add(Instr(Form.RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0)))
        NoticeA.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        NoticeA.add(Instr(Form.FILL, Color(0xe80000)))
        NoticeA.add(Instr(Form.LINE, Line2D.Double(-25.0, -25.0, 25.0, 25.0)))
        NoticeA.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA.add(Instr(Form.FILL, Color.black))
        NoticeA.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeB = Symbol()

    init {
        NoticeB.add(Instr(Form.FILL, Color(0xe80000)))
        NoticeB.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeB.add(Instr(Form.FILL, Color.white))
        NoticeB.add(Instr(Form.RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0)))
        NoticeB.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB.add(Instr(Form.FILL, Color.black))
        NoticeB.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeE = Symbol()

    init {
        NoticeE.add(Instr(Form.FILL, Color(0x0000a0)))
        NoticeE.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeE.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE.add(Instr(Form.FILL, Color.black))
        NoticeE.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeE.add(Instr(Form.FILL, Color.white))
    }


    val Notice = Symbol()

    init {
        Notice.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Notice.add(Instr(Form.FILL, Color(0xe80000)))
        Notice.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        Notice.add(Instr(Form.FILL, Color(0x0000a0)))
        Notice.add(Instr(Form.RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0)))
        Notice.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Notice.add(Instr(Form.FILL, Color.black))
        Notice.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    val NoticeA1 = Symbol()

    init {
        NoticeA1.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA1.add(Instr(Form.FILL, Color(0xe80000)))
        NoticeA1.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeA1.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA1.add(Instr(Form.FILL, Color.white))
        NoticeA1.add(Instr(Form.RSHP, Rectangle2D.Double(-30.0, -10.0, 60.0, 20.0)))
        NoticeA1.add(Instr(Form.FILL, Color.black))
        NoticeA1.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    val NoticeA1a = Symbol()

    init {
        NoticeA1a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA1a.add(Instr(Form.FILL, Color(0xe80000)))
        NoticeA1a.add(Instr(Form.RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA1a.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA1a.add(Instr(Form.FILL, Color.white))
        NoticeA1a.add(Instr(Form.RSHP, Rectangle2D.Double(-29.0, -10.0, 58.0, 20.0)))
        NoticeA1a.add(Instr(Form.FILL, Color.black))
        NoticeA1a.add(Instr(Form.ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
    }

    val NoticeA2 = Symbol()

    init {
        NoticeA2.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA2.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA2.add(Instr(Form.FILL, Color.black))
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
        NoticeA2.add(Instr(Form.PGON, p))
    }

    val NoticeA3 = Symbol()

    init {
        NoticeA3.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA3.add(Instr(Form.SYMB, SubSymbol(NoticeA2, 1.0, 0.0, 0.0, null, null)))
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
        NoticeA3.add(Instr(Form.PGON, p))
    }

    val NoticeA4 = Symbol()

    init {
        NoticeA4.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA4.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA4.add(Instr(Form.FILL, Color.black))
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
        NoticeA4.add(Instr(Form.PGON, p))
    }

    val NoticeA4_1 = Symbol()

    init {
        NoticeA4_1.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA4_1.add(Instr(Form.SYMB, SubSymbol(NoticeA4, 1.0, 0.0, 0.0, null, null)))
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
        NoticeA4_1.add(Instr(Form.PGON, p))
    }

    val NoticeA5 = Symbol()

    init {
        NoticeA5.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA5.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
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
        NoticeA5.add(Instr(Form.PGON, p))
    }

    val NoticeA5_1 = Symbol()

    init {
        NoticeA5_1.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA5_1.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeA6 = Symbol()

    init {
        NoticeA6.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA6.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA6.add(
            Instr(
                Form.SYMB, SubSymbol(
                    Harbours.Anchor, 0.4, 0.0, 0.0, Symbols.Scheme(
                        Color.black
                    ), Symbols.Delta(Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(180.0)))
                )
            )
        )
    }

    val NoticeA7 = Symbol()

    init {
        NoticeA7.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA7.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA7.add(
            Instr(
                Form.SYMB,
                SubSymbol(Bollard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA8 = Symbol()

    init {
        NoticeA8.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA8.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA8.add(
            Instr(
                Form.SYMB,
                SubSymbol(Turn, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA9 = Symbol()

    init {
        NoticeA9.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA9.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA9.add(Instr(Form.STRK, BasicStroke(7f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA9.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-23.0, 10.0)
        p.curveTo(-11.0, 10.0, -12.0, 4.0, 0.0, 4.0)
        p.curveTo(12.0, 4.0, 11.0, 10.0, 23.0, 10.0)
        p.moveTo(-23.0, -3.0)
        p.curveTo(-11.0, -3.0, -12.0, -9.0, 0.0, -9.0)
        p.curveTo(12.0, -9.0, 11.0, -3.0, 23.0, -3.0)
        NoticeA9.add(Instr(Form.PLIN, p))
    }

    val NoticeA10a = Symbol()

    init {
        NoticeA10a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA10a.add(Instr(Form.FILL, Color.white))
        var p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeA10a.add(Instr(Form.PGON, p))
        NoticeA10a.add(Instr(Form.FILL, Color(0xe80000)))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeA10a.add(Instr(Form.PGON, p))
        NoticeA10a.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeA10a.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeA10a.add(Instr(Form.PLIN, p))
    }

    val NoticeA10b = Symbol()

    init {
        NoticeA10b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA10b.add(
            Instr(
                Form.SYMB, SubSymbol(
                    NoticeA10a, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(180.0))
                    )
                )
            )
        )
    }

    val NoticeA12 = Symbol()

    init {
        NoticeA12.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA12.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA12.add(
            Instr(
                Form.SYMB,
                SubSymbol(Motor, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA13 = Symbol()

    init {
        NoticeA13.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA13.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA13.add(
            Instr(
                Form.TEXT, Caption(
                    "SPORT", Font("Arial", Font.BOLD, 15), Color.black, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 5.0)
                    )
                )
            )
        )
    }

    val NoticeA14 = Symbol()

    init {
        NoticeA14.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA14.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA14.add(
            Instr(
                Form.SYMB,
                SubSymbol(Waterski, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA15 = Symbol()

    init {
        NoticeA15.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA15.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA15.add(
            Instr(
                Form.SYMB,
                SubSymbol(Sailboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA16 = Symbol()

    init {
        NoticeA16.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA16.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA16.add(
            Instr(
                Form.SYMB,
                SubSymbol(Rowboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA17 = Symbol()

    init {
        NoticeA17.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA17.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA17.add(
            Instr(
                Form.SYMB,
                SubSymbol(Sailboard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA18 = Symbol()

    init {
        NoticeA18.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA18.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA18.add(
            Instr(
                Form.SYMB,
                SubSymbol(Speedboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA19 = Symbol()

    init {
        NoticeA19.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA19.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA19.add(
            Instr(
                Form.SYMB,
                SubSymbol(Slipway, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeA20 = Symbol()

    init {
        NoticeA20.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeA20.add(Instr(Form.SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null)))
        NoticeA20.add(
            Instr(
                Form.SYMB,
                SubSymbol(Waterbike, 1.0, 0.0, 0.0, Symbols.Scheme(Color.black), null)
            )
        )
    }

    val NoticeB1a = Symbol()

    init {
        NoticeB1a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB1a.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(21.0, 8.0)
        p.lineTo(-8.0, 8.0)
        p.lineTo(-8.0, 18.0)
        p.lineTo(-21.0, 0.0)
        p.lineTo(-8.0, -18.0)
        p.lineTo(-8.0, -8.0)
        p.lineTo(21.0, -8.0)
        p.closePath()
        NoticeB1a.add(Instr(Form.PGON, p))
    }

    val NoticeB1b = Symbol()

    init {
        NoticeB1b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB1b.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-21.0, 8.0)
        p.lineTo(8.0, 8.0)
        p.lineTo(8.0, 18.0)
        p.lineTo(21.0, 0.0)
        p.lineTo(8.0, -18.0)
        p.lineTo(8.0, -8.0)
        p.lineTo(-21.0, -8.0)
        p.closePath()
        NoticeB1b.add(Instr(Form.PGON, p))
    }

    val NoticeB2a = Symbol()

    init {
        NoticeB2a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB2a.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB2a.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        var p = Path2D.Double()
        p.moveTo(18.0, 21.0)
        p.lineTo(18.0, 10.0)
        p.lineTo(-15.0, -10.0)
        p.lineTo(-15.0, -15.0)
        NoticeB2a.add(Instr(Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(-21.0, -15.0)
        p.lineTo(-9.0, -15.0)
        p.closePath()
        NoticeB2a.add(Instr(Form.PGON, p))
    }

    val NoticeB2b = Symbol()

    init {
        NoticeB2b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB2b.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB2b.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB2b.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        var p = Path2D.Double()
        p.moveTo(-18.0, 21.0)
        p.lineTo(-18.0, 10.0)
        p.lineTo(15.0, -10.0)
        p.lineTo(15.0, -15.0)
        NoticeB2b.add(Instr(Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(15.0, -21.0)
        p.lineTo(21.0, -15.0)
        p.lineTo(9.0, -15.0)
        p.closePath()
        NoticeB2b.add(Instr(Form.PGON, p))
    }

    val NoticeB3a = Symbol()

    init {
        NoticeB3a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB3a.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB3a.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB3a.add(Instr(Form.LINE, Line2D.Double(-15.0, 21.0, -15.0, -15.0)))
        var p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(-21.0, -15.0)
        p.lineTo(-9.0, -15.0)
        p.closePath()
        NoticeB3a.add(Instr(Form.PGON, p))
        NoticeB3a.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        NoticeB3a.add(Instr(Form.LINE, Line2D.Double(15.0, -21.0, 15.0, 15.0)))
        p = Path2D.Double()
        p.moveTo(15.0, 21.0)
        p.lineTo(21.0, 15.0)
        p.lineTo(9.0, 15.0)
        p.closePath()
        NoticeB3a.add(Instr(Form.PGON, p))
    }

    val NoticeB3b = Symbol()

    init {
        NoticeB3b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB3b.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB3b.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB3b.add(Instr(Form.LINE, Line2D.Double(15.0, 21.0, 15.0, -15.0)))
        var p = Path2D.Double()
        p.moveTo(15.0, -21.0)
        p.lineTo(21.0, -15.0)
        p.lineTo(9.0, -15.0)
        p.closePath()
        NoticeB3b.add(Instr(Form.PGON, p))
        NoticeB3b.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        NoticeB3b.add(Instr(Form.LINE, Line2D.Double(-15.0, -21.0, -15.0, 15.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(-21.0, 15.0)
        p.lineTo(-9.0, 15.0)
        p.closePath()
        NoticeB3b.add(Instr(Form.PGON, p))
    }

    val NoticeB4a = Symbol()

    init {
        NoticeB4a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB4a.add(Instr(Form.SYMB, SubSymbol(NoticeB2a, 1.0, 0.0, 0.0, null, null)))
        NoticeB4a.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        var p = Path2D.Double()
        p.moveTo(18.0, -21.0)
        p.lineTo(18.0, -10.0)
        p.lineTo(-15.0, 10.0)
        p.lineTo(-15.0, 15.0)
        NoticeB4a.add(Instr(Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(-21.0, 15.0)
        p.lineTo(-9.0, 15.0)
        p.closePath()
        NoticeB4a.add(Instr(Form.PGON, p))
    }

    val NoticeB4b = Symbol()

    init {
        NoticeB4b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB4b.add(Instr(Form.SYMB, SubSymbol(NoticeB2b, 1.0, 0.0, 0.0, null, null)))
        NoticeB4b.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        var p = Path2D.Double()
        p.moveTo(-18.0, -21.0)
        p.lineTo(-18.0, -10.0)
        p.lineTo(15.0, 10.0)
        p.lineTo(15.0, 15.0)
        NoticeB4b.add(Instr(Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(15.0, 21.0)
        p.lineTo(21.0, 15.0)
        p.lineTo(9.0, 15.0)
        p.closePath()
        NoticeB4b.add(Instr(Form.PGON, p))
    }

    val NoticeB5 = Symbol()

    init {
        NoticeB5.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB5.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB5.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        NoticeB5.add(Instr(Form.LINE, Line2D.Double(15.0, 0.0, -15.0, 0.0)))
    }

    val NoticeB6 = Symbol()

    init {
        NoticeB6.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB6.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeB7 = Symbol()

    init {
        NoticeB7.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB7.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB7.add(Instr(Form.RSHP, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
    }

    val NoticeB8 = Symbol()

    init {
        NoticeB8.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB8.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB8.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        NoticeB8.add(Instr(Form.LINE, Line2D.Double(0.0, 15.0, 0.0, -15.0)))
    }

    val NoticeB9a = Symbol()

    init {
        NoticeB9a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB9a.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB9a.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9a.add(Instr(Form.LINE, Line2D.Double(-21.0, 0.0, 21.0, 0.0)))
        NoticeB9a.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9a.add(Instr(Form.LINE, Line2D.Double(0.0, 21.0, 0.0, 0.0)))
    }

    val NoticeB9b = Symbol()

    init {
        NoticeB9b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB9b.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB9b.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9b.add(Instr(Form.LINE, Line2D.Double(-21.0, 0.0, 21.0, 0.0)))
        NoticeB9b.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeB9b.add(Instr(Form.LINE, Line2D.Double(0.0, 21.0, 0.0, -21.0)))
    }

    val NoticeB11 = Symbol()

    init {
        NoticeB11.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeB11.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        NoticeB11.add(
            Instr(
                Form.TEXT, Caption(
                    "VHF", Font("Arial", Font.BOLD, 20), Color.black, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 0.0)
                    )
                )
            )
        )
    }

    val NoticeC1 = Symbol()

    init {
        NoticeC1.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC1.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(0.0, 12.0)
        p.lineTo(15.0, 21.0)
        p.closePath()
        NoticeC1.add(Instr(Form.PGON, p))
    }

    val NoticeC2 = Symbol()

    init {
        NoticeC2.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC2.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(0.0, -12.0)
        p.lineTo(15.0, -21.0)
        p.closePath()
        NoticeC2.add(Instr(Form.PGON, p))
    }

    val NoticeC3 = Symbol()

    init {
        NoticeC3.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC3.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(21.0, -15.0)
        p.lineTo(12.0, 0.0)
        p.lineTo(21.0, 15.0)
        p.closePath()
        p.moveTo(-21.0, -15.0)
        p.lineTo(-12.0, 0.0)
        p.lineTo(-21.0, 15.0)
        p.closePath()
        NoticeC3.add(Instr(Form.PGON, p))
    }

    val NoticeC4 = Symbol()

    init {
        NoticeC4.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC4.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeC5a = Symbol()

    init {
        NoticeC5a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC5a.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-21.0, -21.0)
        p.lineTo(10.0, -21.0)
        p.lineTo(21.0, 0.0)
        p.lineTo(10.0, 21.0)
        p.lineTo(-21.0, 21.0)
        p.closePath()
        NoticeC5a.add(Instr(Form.PGON, p))
    }

    val NoticeC5b = Symbol()

    init {
        NoticeC5b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeC5b.add(Instr(Form.SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(21.0, -21.0)
        p.lineTo(-10.0, -21.0)
        p.lineTo(-21.0, 0.0)
        p.lineTo(-10.0, 21.0)
        p.lineTo(21.0, 21.0)
        p.closePath()
        NoticeC5b.add(Instr(Form.PGON, p))
    }

    val NoticeD1a = Symbol()

    init {
        NoticeD1a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD1a.add(Instr(Form.FILL, Color.yellow))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeD1a.add(Instr(Form.PGON, p))
        NoticeD1a.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeD1a.add(Instr(Form.FILL, Color.black))
        NoticeD1a.add(Instr(Form.PLIN, p))
    }

    val NoticeD1b = Symbol()

    init {
        NoticeD1b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD1b.add(Instr(Form.FILL, Color.yellow))
        val p = Path2D.Double()
        p.moveTo(-30.0, 0.0)
        p.lineTo(-15.0, 25.0)
        p.lineTo(15.0, -25.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(15.0, 25.0)
        p.lineTo(-15.0, -25.0)
        p.closePath()
        NoticeD1b.add(Instr(Form.PGON, p))
        NoticeD1b.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeD1b.add(Instr(Form.FILL, Color.black))
        NoticeD1b.add(Instr(Form.PLIN, p))
    }

    val NoticeD2a = Symbol()

    init {
        NoticeD2a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD2a.add(Instr(Form.FILL, Color.white))
        var p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeD2a.add(Instr(Form.PGON, p))
        NoticeD2a.add(Instr(Form.FILL, Color(0x00e800)))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        NoticeD2a.add(Instr(Form.PGON, p))
        NoticeD2a.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeD2a.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeD2a.add(Instr(Form.PLIN, p))
    }

    val NoticeD2b = Symbol()

    init {
        NoticeD2b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD2b.add(
            Instr(
                Form.SYMB, SubSymbol(
                    NoticeD2a, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(180.0))
                    )
                )
            )
        )
    }

    val NoticeD3a = Symbol()

    init {
        NoticeD3a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD3a.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(28.0, 10.0)
        p.lineTo(-10.0, 10.0)
        p.lineTo(-10.0, 20.0)
        p.lineTo(-28.0, 0.0)
        p.lineTo(-10.0, -20.0)
        p.lineTo(-10.0, -10.0)
        p.lineTo(28.0, -10.0)
        p.closePath()
        NoticeD3a.add(Instr(Form.PGON, p))
    }

    val NoticeD3b = Symbol()

    init {
        NoticeD3b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeD3b.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-28.0, 10.0)
        p.lineTo(10.0, 10.0)
        p.lineTo(10.0, 20.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(10.0, -20.0)
        p.lineTo(10.0, -10.0)
        p.lineTo(-28.0, -10.0)
        p.closePath()
        NoticeD3b.add(Instr(Form.PGON, p))
    }

    val NoticeE1 = Symbol()

    init {
        NoticeE1.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE1.add(Instr(Form.FILL, Color(0x00e800)))
        NoticeE1.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeE1.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE1.add(Instr(Form.FILL, Color.white))
        NoticeE1.add(Instr(Form.RSHP, Rectangle2D.Double(-10.0, -30.0, 20.0, 60.0)))
        NoticeE1.add(Instr(Form.FILL, Color.black))
        NoticeE1.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    val NoticeE2 = Symbol()

    init {
        NoticeE2.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE2.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE2.add(Instr(Form.PGON, p))
    }

    val NoticeE3 = Symbol()

    init {
        NoticeE3.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE3.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE3.add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(25.0, -20.0, 25.0, 20.0)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(-25.0, -20.0, -25.0, 20.0)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(-15.0, -15.0, -15.0, 20.0)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(-5.0, -15.0, -5.0, 20.0)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(5.0, -15.0, 5.0, 20.0)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(15.0, -15.0, 15.0, 20.0)))
        NoticeE3.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(-26.0, 18.5, 26.0, 18.5)))
        NoticeE3.add(Instr(Form.LINE, Line2D.Double(-26.0, -15.0, 26.0, -15.0)))
    }

    val NoticeE4a = Symbol()

    init {
        NoticeE4a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE4a.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE4a.add(Instr(Form.PGON, p))
    }

    val NoticeE4b = Symbol()

    init {
        NoticeE4b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE4b.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE4b.add(Instr(Form.PGON, p))
    }

    val NoticeE5 = Symbol()

    init {
        NoticeE5.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5.add(Instr(Form.PGON, p))
    }

    val NoticeE5_1 = Symbol()

    init {
        NoticeE5_1.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_1.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeE5_2 = Symbol()

    init {
        NoticeE5_2.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_2.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeE5_3 = Symbol()

    init {
        NoticeE5_3.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_3.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeE5_4 = Symbol()

    init {
        NoticeE5_4.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_4.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 25.0)
        p.lineTo(0.0, -28.0)
        p.lineTo(28.0, 25.0)
        p.closePath()
        NoticeE5_4.add(Instr(Form.PGON, p))
    }

    val NoticeE5_5 = Symbol()

    init {
        NoticeE5_5.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_5.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_5.add(Instr(Form.PGON, p))
    }

    val NoticeE5_6 = Symbol()

    init {
        NoticeE5_6.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_6.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_6.add(Instr(Form.PGON, p))
    }

    val NoticeE5_7 = Symbol()

    init {
        NoticeE5_7.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_7.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_7.add(Instr(Form.PGON, p))
    }

    val NoticeE5_8 = Symbol()

    init {
        NoticeE5_8.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_8.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, -25.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, -25.0)
        p.closePath()
        NoticeE5_8.add(Instr(Form.PGON, p))
    }

    val NoticeE5_9 = Symbol()

    init {
        NoticeE5_9.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_9.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_9.add(Instr(Form.PGON, p))
    }

    val NoticeE5_10 = Symbol()

    init {
        NoticeE5_10.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_10.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_10.add(Instr(Form.PGON, p))
    }

    val NoticeE5_11 = Symbol()

    init {
        NoticeE5_11.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_11.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_11.add(Instr(Form.PGON, p))
    }

    val NoticeE5_12 = Symbol()

    init {
        NoticeE5_12.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_12.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-28.0, 0.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(0.0, -28.0)
        p.closePath()
        NoticeE5_12.add(Instr(Form.PGON, p))
    }

    val NoticeE5_13 = Symbol()

    init {
        NoticeE5_13.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_13.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_13.add(Instr(Form.PGON, p))
    }

    val NoticeE5_14 = Symbol()

    init {
        NoticeE5_14.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_14.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_14.add(Instr(Form.PGON, p))
    }

    val NoticeE5_15 = Symbol()

    init {
        NoticeE5_15.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE5_15.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE5_15.add(Instr(Form.PGON, p))
    }

    val NoticeE6 = Symbol()

    init {
        NoticeE6.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE6.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE6.add(
            Instr(
                Form.SYMB, SubSymbol(
                    Harbours.Anchor, 0.4, 0.0, 0.0, Symbols.Scheme(
                        Color.white
                    ), null
                )
            )
        )
    }

    val NoticeE7 = Symbol()

    init {
        NoticeE7.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE7.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE7.add(
            Instr(
                Form.SYMB,
                SubSymbol(Bollard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE7_1 = Symbol()

    init {
        NoticeE7_1.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE7_1.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE7_1.add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE7_1.add(Instr(Form.LINE, Line2D.Double(20.0, 25.0, 20.0, -10.0)))
        NoticeE7_1.add(Instr(Form.LINE, Line2D.Double(22.0, -8.0, -15.0, -20.0)))
        NoticeE7_1.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE7_1.add(Instr(Form.LINE, Line2D.Double(20.0, 8.0, 0.0, -15.0)))
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
        NoticeE7_1.add(Instr(Form.PGON, p))
        NoticeE7_1.add(Instr(Form.FILL, Color(0x0000a0)))
        NoticeE7_1.add(Instr(Form.RSHP, Ellipse2D.Double(-16.0, 13.0, 4.0, 4.0)))
        NoticeE7_1.add(Instr(Form.RSHP, Ellipse2D.Double(2.0, 13.0, 4.0, 4.0)))
    }

    val NoticeE8 = Symbol()

    init {
        NoticeE8.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE8.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE8.add(
            Instr(
                Form.SYMB,
                SubSymbol(Turn, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE9a = Symbol()

    init {
        NoticeE9a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9a.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9a.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9a.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
        NoticeE9a.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9a.add(Instr(Form.LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE9b = Symbol()

    init {
        NoticeE9b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9b.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9b.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9b.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
        NoticeE9b.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9b.add(Instr(Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE9c = Symbol()

    init {
        NoticeE9c.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9c.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9c.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9c.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
        NoticeE9c.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9c.add(Instr(Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE9d = Symbol()

    init {
        NoticeE9d.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9d.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9d.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9d.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9d.add(Instr(Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE9d.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9d.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
    }

    val NoticeE9e = Symbol()

    init {
        NoticeE9e.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9e.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9e.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9e.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9e.add(Instr(Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE9e.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9e.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
    }

    val NoticeE9f = Symbol()

    init {
        NoticeE9f.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9f.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9f.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9f.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9f.add(Instr(Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE9f.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9f.add(Instr(Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE9g = Symbol()

    init {
        NoticeE9g.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9g.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9g.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9g.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9g.add(Instr(Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE9g.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9g.add(Instr(Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE9h = Symbol()

    init {
        NoticeE9h.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9h.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9h.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9h.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9h.add(Instr(Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE9h.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9h.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
        NoticeE9h.add(Instr(Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE9i = Symbol()

    init {
        NoticeE9i.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE9i.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE9i.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9i.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0)))
        NoticeE9i.add(Instr(Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE9i.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE9i.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0)))
        NoticeE9i.add(Instr(Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE10a = Symbol()

    init {
        NoticeE10a.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10a.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10a.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10a.add(Instr(Form.LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0)))
        NoticeE10a.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10a.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0)))
    }

    val NoticeE10b = Symbol()

    init {
        NoticeE10b.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10b.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10b.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10b.add(Instr(Form.LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0)))
        NoticeE10b.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10b.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
    }

    val NoticeE10c = Symbol()

    init {
        NoticeE10c.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10c.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10c.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10c.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10c.add(Instr(Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE10c.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10c.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
    }

    val NoticeE10d = Symbol()

    init {
        NoticeE10d.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10d.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10d.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10d.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10d.add(Instr(Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE10d.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10d.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
    }

    val NoticeE10e = Symbol()

    init {
        NoticeE10e.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10e.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10e.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10e.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10e.add(Instr(Form.LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0)))
        NoticeE10e.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10e.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
        NoticeE10e.add(Instr(Form.LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0)))
    }

    val NoticeE10f = Symbol()

    init {
        NoticeE10f.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE10f.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE10f.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10f.add(Instr(Form.LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0)))
        NoticeE10f.add(Instr(Form.LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0)))
        NoticeE10f.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeE10f.add(Instr(Form.LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0)))
        NoticeE10f.add(Instr(Form.LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0)))
    }

    val NoticeE11 = Symbol()

    init {
        NoticeE11.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE11.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE11.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        NoticeE11.add(Instr(Form.LINE, Line2D.Double(-27.0, -27.0, 27.0, 27.0)))
    }

    val NoticeE13 = Symbol()

    init {
        NoticeE13.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE13.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE13.add(Instr(Form.PGON, p))
    }

    val NoticeE14 = Symbol()

    init {
        NoticeE14.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE14.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
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
        NoticeE14.add(Instr(Form.PGON, p))
    }

    val NoticeE15 = Symbol()

    init {
        NoticeE15.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE15.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE15.add(
            Instr(
                Form.SYMB,
                SubSymbol(Motor, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE16 = Symbol()

    init {
        NoticeE16.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE16.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE16.add(
            Instr(
                Form.TEXT, Caption(
                    "SPORT", Font("Arial", Font.BOLD, 15), Color.white, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 5.0)
                    )
                )
            )
        )
    }

    val NoticeE17 = Symbol()

    init {
        NoticeE17.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE17.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE17.add(
            Instr(
                Form.SYMB,
                SubSymbol(Waterski, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE18 = Symbol()

    init {
        NoticeE18.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE18.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE18.add(
            Instr(
                Form.SYMB,
                SubSymbol(Sailboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE19 = Symbol()

    init {
        NoticeE19.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE19.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE19.add(
            Instr(
                Form.SYMB,
                SubSymbol(Rowboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE20 = Symbol()

    init {
        NoticeE20.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE20.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE20.add(
            Instr(
                Form.SYMB,
                SubSymbol(Sailboard, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE21 = Symbol()

    init {
        NoticeE21.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE21.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE21.add(
            Instr(
                Form.SYMB,
                SubSymbol(Speedboat, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE22 = Symbol()

    init {
        NoticeE22.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE22.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE22.add(
            Instr(
                Form.SYMB,
                SubSymbol(Slipway, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }

    val NoticeE23 = Symbol()

    init {
        NoticeE23.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE23.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE23.add(
            Instr(
                Form.TEXT, Caption(
                    "VHF", Font("Arial", Font.BOLD, 20), Color.white, Symbols.Delta(
                        Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, 0.0)
                    )
                )
            )
        )
    }

    val NoticeE24 = Symbol()

    init {
        NoticeE24.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeE24.add(Instr(Form.SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null)))
        NoticeE24.add(
            Instr(
                Form.SYMB,
                SubSymbol(Waterbike, 1.0, 0.0, 0.0, Symbols.Scheme(Color.white), null)
            )
        )
    }


    val NoticeBoard = Symbol()

    init {
        NoticeBoard.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 30.0)))
        NoticeBoard.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(20.0, -15.0)
        p.lineTo(-20.0, -15.0)
        p.closePath()
        NoticeBoard.add(Instr(Form.FILL, Color.white))
        NoticeBoard.add(Instr(Form.PGON, p))
        NoticeBoard.add(Instr(Form.FILL, Color.black))
        NoticeBoard.add(Instr(Form.PLIN, p))
    }

    val NoticeTriangle = Symbol()

    init {
        NoticeTriangle.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 30.0)))
        NoticeTriangle.add(
            Instr(
                Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        val p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(0.0, -15.0)
        p.closePath()
        NoticeTriangle.add(Instr(Form.FILL, Color.white))
        NoticeTriangle.add(Instr(Form.PGON, p))
        NoticeTriangle.add(Instr(Form.FILL, Color.black))
        NoticeTriangle.add(Instr(Form.PLIN, p))
    }

    val NmkCevni = mapOf(
        CatNMK.NMK_UNKN to Notice,
        CatNMK.NMK_NENT to NoticeA1,
        CatNMK.NMK_CLSA to NoticeA1a,
        CatNMK.NMK_NOVK to NoticeA2,
        CatNMK.NMK_NCOV to NoticeA3,
        CatNMK.NMK_NPAS to NoticeA4,
        CatNMK.NMK_NCPS to NoticeA4_1,
        CatNMK.NMK_NBRT to NoticeA5,
        CatNMK.NMK_NBLL to NoticeA5_1,
        CatNMK.NMK_NANK to NoticeA6,
        CatNMK.NMK_NMOR to NoticeA7,
        CatNMK.NMK_NTRN to NoticeA8,
        CatNMK.NMK_NWSH to NoticeA9,
        CatNMK.NMK_NPSL to NoticeA10a,
        CatNMK.NMK_NPSR to NoticeA10b,
        CatNMK.NMK_NMTC to NoticeA12,
        CatNMK.NMK_NSPC to NoticeA13,
        CatNMK.NMK_NWSK to NoticeA14,
        CatNMK.NMK_NSLC to NoticeA15,
        CatNMK.NMK_NUPC to NoticeA16,
        CatNMK.NMK_NSLB to NoticeA17,
        CatNMK.NMK_NWBK to NoticeA20,
        CatNMK.NMK_NHSC to NoticeA18,
        CatNMK.NMK_NLBG to NoticeA19,
        CatNMK.NMK_MVTL to NoticeB1a,
        CatNMK.NMK_MVTR to NoticeB1b,
        CatNMK.NMK_MVTP to NoticeB2a,
        CatNMK.NMK_MVTS to NoticeB2b,
        CatNMK.NMK_KPTP to NoticeB3a,
        CatNMK.NMK_KPTS to NoticeB3b,
        CatNMK.NMK_CSTP to NoticeB4a,
        CatNMK.NMK_CSTS to NoticeB4b,
        CatNMK.NMK_STOP to NoticeB5,
        CatNMK.NMK_SPDL to NoticeB6,
        CatNMK.NMK_SHRN to NoticeB7,
        CatNMK.NMK_KPLO to NoticeB8,
        CatNMK.NMK_GWJN to NoticeB9a,
        CatNMK.NMK_GWCS to NoticeB9b,
        CatNMK.NMK_MKRC to NoticeB11,
        CatNMK.NMK_LMDP to NoticeC1,
        CatNMK.NMK_LMHR to NoticeC2,
        CatNMK.NMK_LMWD to NoticeC3,
        CatNMK.NMK_NAVR to NoticeC4,
        CatNMK.NMK_CHDL to NoticeC5a,
        CatNMK.NMK_CHDR to NoticeC5b,
        CatNMK.NMK_CHTW to NoticeD1a,
        CatNMK.NMK_CHOW to NoticeD1b,
        CatNMK.NMK_OPTR to NoticeD2a,
        CatNMK.NMK_OPTL to NoticeD2b,
        CatNMK.NMK_PRTL to NoticeD3a,
        CatNMK.NMK_PRTR to NoticeD3b,
        CatNMK.NMK_ENTP to NoticeE1,
        CatNMK.NMK_OVHC to NoticeE2,
        CatNMK.NMK_WEIR to NoticeE3,
        CatNMK.NMK_FERN to NoticeE4a,
        CatNMK.NMK_FERI to NoticeE4b,
        CatNMK.NMK_BRTP to NoticeE5,
        CatNMK.NMK_BTLL to NoticeE5_1,
        CatNMK.NMK_BTLS to NoticeE5_2,
        CatNMK.NMK_BTRL to NoticeE5_3,
        CatNMK.NMK_BTUP to NoticeE5_4,
        CatNMK.NMK_BTP1 to NoticeE5_5,
        CatNMK.NMK_BTP2 to NoticeE5_6,
        CatNMK.NMK_BTP3 to NoticeE5_7,
        CatNMK.NMK_BTUN to NoticeE5_8,
        CatNMK.NMK_BTN1 to NoticeE5_9,
        CatNMK.NMK_BTN2 to NoticeE5_10,
        CatNMK.NMK_BTN3 to NoticeE5_11,
        CatNMK.NMK_BTUM to NoticeE5_12,
        CatNMK.NMK_BTU1 to NoticeE5_13,
        CatNMK.NMK_BTU2 to NoticeE5_14,
        CatNMK.NMK_BTU3 to NoticeE5_15,
        CatNMK.NMK_ANKP to NoticeE6,
        CatNMK.NMK_MORP to NoticeE7,
        CatNMK.NMK_VLBT to NoticeE7_1,
        CatNMK.NMK_TRNA to NoticeE8,
        CatNMK.NMK_SWWC to NoticeE9a,
        CatNMK.NMK_SWWR to NoticeE9b,
        CatNMK.NMK_SWWL to NoticeE9c,
        CatNMK.NMK_WRSA to NoticeE9d,
        CatNMK.NMK_WLSA to NoticeE9e,
        CatNMK.NMK_WRSL to NoticeE9f,
        CatNMK.NMK_WLSR to NoticeE9g,
        CatNMK.NMK_WRAL to NoticeE9h,
        CatNMK.NMK_WLAR to NoticeE9i,
        CatNMK.NMK_MWWC to NoticeE10a,
        CatNMK.NMK_MWWJ to NoticeE10b,
        CatNMK.NMK_MWAR to NoticeE10c,
        CatNMK.NMK_MWAL to NoticeE10d,
        CatNMK.NMK_WARL to NoticeE10e,
        CatNMK.NMK_WALR to NoticeE10f,
        CatNMK.NMK_PEND to NoticeE11,
        CatNMK.NMK_DWTR to NoticeE13,
        CatNMK.NMK_TELE to NoticeE14,
        CatNMK.NMK_MTCP to NoticeE15,
        CatNMK.NMK_SPCP to NoticeE16,
        CatNMK.NMK_WSKP to NoticeE17,
        CatNMK.NMK_SLCP to NoticeE18,
        CatNMK.NMK_UPCP to NoticeE19,
        CatNMK.NMK_SLBP to NoticeE20,
        CatNMK.NMK_RADI to NoticeE23,
        CatNMK.NMK_WTBP to NoticeE24,
        CatNMK.NMK_HSCP to NoticeE21,
        CatNMK.NMK_LBGP to NoticeE22,
    )

    // CHECKSTYLE.ON: SingleSpaceSeparator
    private val NoticeBB = Symbol()

    init {
        NoticeBB.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeBB.add(Instr(Form.LINE, Line2D.Double(-29.0, -29.0, -29.0, 29.0)))
        NoticeBB.add(Instr(Form.LINE, Line2D.Double(29.0, -29.0, 29.0, 29.0)))
        NoticeBB.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeBB.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeBP = Symbol()

    init {
        NoticeBP.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeBP.add(Instr(Form.FILL, Color.white))
        NoticeBP.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeBP.add(Instr(Form.FILL, Color.black))
        NoticeBP.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
    }

    private val NoticeCR = Symbol()

    init {
        NoticeCR.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeCR.add(Instr(Form.FILL, Color.white))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        NoticeCR.add(Instr(Form.PGON, p))
        NoticeCR.add(Instr(Form.FILL, Color.black))
        NoticeCR.add(Instr(Form.PLIN, p))
    }

    private val NoticeKT = Symbol()

    init {
        NoticeKT.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeKT.add(Instr(Form.FILL, Color.white))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        NoticeKT.add(Instr(Form.PGON, p))
        NoticeKT.add(Instr(Form.FILL, Color.black))
        NoticeKT.add(Instr(Form.PLIN, p))
    }

    val NoticeBnank = Symbol()

    init {
        NoticeBnank.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        ss.add(Instr(Form.SYMB, SubSymbol(Harbours.Anchor, 0.4, 0.0, 0.0, null, null)))
        ss.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.LINE, Line2D.Double(-27.0, -27.0, 27.0, 27.0)))
        ss.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N2, ss))
        NoticeBnank.add(Instr(Form.COLR, colours))
    }

    val NoticeBlmhr = Symbol()

    init {
        NoticeBlmhr.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        ss.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-29.0, -29.0)
        p.lineTo(29.0, -29.0)
        p.lineTo(0.0, 0.0)
        p.closePath()
        ss.add(Instr(Form.PGON, p))
        ss.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N2, ss))
        NoticeBlmhr.add(Instr(Form.COLR, colours))
    }

    val NoticeBktpm = Symbol()

    init {
        NoticeBktpm.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -26.0)
        p.lineTo(-20.0, -12.0)
        p.lineTo(-8.0, -12.0)
        p.closePath()
        ss.add(Instr(Form.PGON, p))
        ss.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.LINE, Line2D.Double(-14.0, -16.0, -14.0, 25.0)))
        ss.add(Instr(Form.SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Instr(Form.N2, ss))
        NoticeBktpm.add(Instr(Form.COLR, colours))
    }

    val NoticeBktsm = Symbol()

    init {
        NoticeBktsm.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        val p = Path2D.Double()
        p.moveTo(14.0, -26.0)
        p.lineTo(20.0, -12.0)
        p.lineTo(8.0, -12.0)
        p.closePath()
        ss.add(Instr(Form.PGON, p))
        ss.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.LINE, Line2D.Double(14.0, -16.0, 14.0, 25.0)))
        ss.add(Instr(Form.SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Instr(Form.N2, ss))
        NoticeBktsm.add(Instr(Form.COLR, colours))
    }

    val NoticeBktmr = Symbol()

    init {
        NoticeBktmr.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        val p = Path2D.Double()
        p.moveTo(0.0, -26.0)
        p.lineTo(-6.0, -12.0)
        p.lineTo(6.0, -12.0)
        p.closePath()
        ss.add(Instr(Form.PGON, p))
        ss.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.LINE, Line2D.Double(0.0, -16.0, 0.0, 25.0)))
        ss.add(Instr(Form.SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Instr(Form.N2, ss))
        NoticeBktmr.add(Instr(Form.COLR, colours))
    }

    val NoticeBcrtp = Symbol()

    init {
        NoticeBcrtp.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        var p = Path2D.Double()
        p.moveTo(-14.0, -26.0)
        p.lineTo(-20.0, -12.0)
        p.lineTo(-8.0, -12.0)
        p.closePath()
        ss.add(Instr(Form.PGON, p))
        ss.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(-14.0, -16.0)
        p.lineTo(-14.0, 0.0)
        p.lineTo(14.0, 10.0)
        p.lineTo(14.0, 25.0)
        ss.add(Instr(Form.PLIN, p))
        ss.add(Instr(Form.SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Instr(Form.N2, ss))
        NoticeBcrtp.add(Instr(Form.COLR, colours))
    }

    val NoticeBcrts = Symbol()

    init {
        NoticeBcrts.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        var p = Path2D.Double()
        p.moveTo(14.0, -26.0)
        p.lineTo(20.0, -12.0)
        p.lineTo(8.0, -12.0)
        p.closePath()
        ss.add(Instr(Form.PGON, p))
        ss.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(14.0, -16.0)
        p.lineTo(14.0, 0.0)
        p.lineTo(-14.0, 10.0)
        p.lineTo(-14.0, 25.0)
        ss.add(Instr(Form.PLIN, p))
        ss.add(Instr(Form.SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Instr(Form.N2, ss))
        NoticeBcrts.add(Instr(Form.COLR, colours))
    }

    val NoticeBtrbm = Symbol()

    init {
        NoticeBtrbm.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        ss.add(Instr(Form.STRK, BasicStroke(15f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.LINE, Line2D.Double(0.0, -25.0, 0.0, 25.0)))
        ss.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ss.add(Instr(Form.LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        ss.add(Instr(Form.SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Instr(Form.N2, ss))
        NoticeBtrbm.add(Instr(Form.COLR, colours))
    }

    val NoticeBrspd = Symbol()

    init {
        NoticeBrspd.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        val colours = Symbol()
        var ss = Symbol()
        ss.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        colours.add(Instr(Form.N1, ss))
        ss = Symbol()
        ss.add(
            Instr(
                Form.TEXT, Caption(
                    "R", Font("Arial", Font.BOLD, 60), null, Symbols.Delta(
                        Symbols.Handle.CC, null
                    )
                )
            )
        )
        ss.add(Instr(Form.SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null)))
        colours.add(Instr(Form.N2, ss))
        NoticeBrspd.add(Instr(Form.COLR, colours))
    }

    val NoticePBwral = Symbol()

    init {
        NoticePBwral.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePBwral.add(Instr(Form.FILL, Color(0xffff00)))
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
        NoticePBwral.add(Instr(Form.PGON, p))
    }

    val NoticeBwral = Symbol()

    init {
        NoticeBwral.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBwral.add(Instr(Form.FILL, Color.black))
        NoticeBwral.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeBwral.add(Instr(Form.SYMB, SubSymbol(NoticePBwral, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticeBwlar = Symbol()

    init {
        NoticeBwlar.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBwlar.add(Instr(Form.FILL, Color.black))
        NoticeBwlar.add(Instr(Form.RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0)))
        NoticeBwlar.add(
            Instr(
                Form.SYMB, SubSymbol(
                    NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getScaleInstance(-1.0, 1.0)
                    )
                )
            )
        )
    }

    val NoticeBoptr = Symbol()

    init {
        NoticeBoptr.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBoptr.add(Instr(Form.SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticeBoptr.add(Instr(Form.FILL, Color(0x00a000)))
        NoticeBoptr.add(Instr(Form.RSHP, Rectangle2D.Double(-20.0, -20.0, 40.0, 40.0)))
    }

    val NoticeBoptl = Symbol()

    init {
        NoticeBoptl.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeBoptl.add(Instr(Form.SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticeBoptl.add(Instr(Form.FILL, Color(0xf00000)))
        val p = Path2D.Double()
        p.moveTo(0.0, -20.0)
        p.lineTo(-20.0, 20.0)
        p.lineTo(20.0, 20.0)
        p.closePath()
        NoticeBoptl.add(Instr(Form.PGON, p))
    }

    val NmkBniwr = mapOf(
        CatNMK.NMK_NANK to NoticeBnank,
        CatNMK.NMK_LMHR to NoticeBlmhr,
        CatNMK.NMK_OPTR to NoticeBoptr,
        CatNMK.NMK_OPTL to NoticeBoptl,
        CatNMK.NMK_WRAL to NoticeBwral,
        CatNMK.NMK_WLAR to NoticeBwlar,
        CatNMK.NMK_KTPM to NoticeBktpm,
        CatNMK.NMK_KTSM to NoticeBktsm,
        CatNMK.NMK_KTMR to NoticeBktmr,
        CatNMK.NMK_CRTP to NoticeBcrtp,
        CatNMK.NMK_CRTS to NoticeBcrts,
        CatNMK.NMK_TRBM to NoticeBtrbm,
        CatNMK.NMK_RSPD to NoticeBrspd,
    )

    val NoticePwralL = Symbol()

    init {
        NoticePwralL.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwralL.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        NoticePwralL.add(Instr(Form.PGON, p))
        NoticePwralL.add(
            Instr(
                Form.SYMB, SubSymbol(
                    NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.TC, AffineTransform.getScaleInstance(0.5, 0.5)
                    )
                )
            )
        )
    }

    val NoticePwralR = Symbol()

    init {
        NoticePwralR.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwralR.add(Instr(Form.SYMB, SubSymbol(NoticeBwral, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticePwlarL = Symbol()

    init {
        NoticePwlarL.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwlarL.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        NoticePwlarL.add(Instr(Form.PGON, p))
        NoticePwlarL.add(
            Instr(
                Form.SYMB, SubSymbol(
                    NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.TC, AffineTransform.getScaleInstance(-0.5, 0.5)
                    )
                )
            )
        )
    }

    val NoticePwlarR = Symbol()

    init {
        NoticePwlarR.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePwlarR.add(Instr(Form.SYMB, SubSymbol(NoticeBwlar, 1.0, 0.0, 0.0, null, null)))
    }

    val NoticePktmR = Symbol()

    init {
        NoticePktmR.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmR.add(Instr(Form.SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticePktmR.add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePktmR.add(Instr(Form.FILL, Color(0x00d400)))
        NoticePktmR.add(Instr(Form.RECT, Rectangle2D.Double(-20.0, -20.0, 40.0, 40.0)))
    }

    val NoticePktmL = Symbol()

    init {
        NoticePktmL.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmL.add(Instr(Form.SYMB, SubSymbol(NoticeKT, 1.0, 0.0, 0.0, null, null)))
        NoticePktmL.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePktmL.add(Instr(Form.FILL, Color(0xd40000)))
        NoticePktmL.add(Instr(Form.RECT, Rectangle2D.Double(-12.0, 2.0, 24.0, 24.0)))
    }

    val NoticePktmrL = Symbol()

    init {
        NoticePktmrL.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmrL.add(Instr(Form.SYMB, SubSymbol(NoticeKT, 1.0, 0.0, 0.0, null, null)))
        NoticePktmrL.add(
            Instr(
                Form.STRK,
                BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        NoticePktmrL.add(Instr(Form.FILL, Color(0xd40000)))
        NoticePktmrL.add(Instr(Form.LINE, Line2D.Double(-12.0, 2.0, -12.0, 28.0)))
        NoticePktmrL.add(Instr(Form.LINE, Line2D.Double(12.0, 2.0, 12.0, 28.0)))
        NoticePktmrL.add(Instr(Form.LINE, Line2D.Double(-12.0, 15.0, 12.0, 15.0)))
    }

    val NoticePktmrR = Symbol()

    init {
        NoticePktmrR.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePktmrR.add(Instr(Form.SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null)))
        NoticePktmrR.add(
            Instr(
                Form.STRK,
                BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        NoticePktmrR.add(Instr(Form.FILL, Color(0x00d400)))
        NoticePktmrR.add(Instr(Form.LINE, Line2D.Double(-15.0, -20.0, -15.0, 20.0)))
        NoticePktmrR.add(Instr(Form.LINE, Line2D.Double(15.0, -20.0, 15.0, 20.0)))
        NoticePktmrR.add(Instr(Form.LINE, Line2D.Double(-15.0, 0.0, 15.0, 0.0)))
    }

    val NoticePcrL = Symbol()

    init {
        NoticePcrL.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePcrL.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePcrL.add(Instr(Form.SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticePcrL.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePcrL.add(Instr(Form.FILL, Color(0xd40000)))
        NoticePcrL.add(Instr(Form.LINE, Line2D.Double(-12.0, -12.0, 12.0, 12.0)))
        NoticePcrL.add(Instr(Form.LINE, Line2D.Double(-12.0, 12.0, 12.0, -12.0)))
    }

    val NoticePcrR = Symbol()

    init {
        NoticePcrR.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticePcrR.add(Instr(Form.SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticePcrR.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticePcrR.add(Instr(Form.FILL, Color(0x00d400)))
        NoticePcrR.add(Instr(Form.LINE, Line2D.Double(-12.0, -12.0, 12.0, 12.0)))
        NoticePcrR.add(Instr(Form.LINE, Line2D.Double(-12.0, 12.0, 12.0, -12.0)))
    }

    val NoticeRphib = Symbol()

    init {
        NoticeRphib.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRphib.add(Instr(Form.FILL, Color(0xd40000)))
        NoticeRphib.add(Instr(Form.ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRphib.add(Instr(Form.LINE, Line2D.Double(-20.0, -20.0, 20.0, 20.0)))
    }

    val NoticeRinfo = Symbol()

    init {
        NoticeRinfo.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRinfo.add(Instr(Form.FILL, Color(0xd40000)))
        NoticeRinfo.add(Instr(Form.RECT, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
    }

    val NoticeRnpas = Symbol()

    init {
        NoticeRnpas.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnpas.add(Instr(Form.SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnpas.add(Instr(Form.FILL, Color.black))
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
        NoticeRnpas.add(Instr(Form.PGON, p))
    }

    val NoticeRnank = Symbol()

    init {
        NoticeRnank.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnank.add(Instr(Form.SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnank.add(
            Instr(
                Form.SYMB, SubSymbol(
                    Harbours.Anchor, 0.4, 0.0, 0.0, Symbols.Scheme(
                        Color.black
                    ), null
                )
            )
        )
    }

    val NoticeRnwsh = Symbol()

    init {
        NoticeRnwsh.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnwsh.add(Instr(Form.SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnwsh.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-23.0, 10.0)
        p.curveTo(-11.0, 10.0, -12.0, 4.0, 0.0, 4.0)
        p.curveTo(12.0, 4.0, 11.0, 10.0, 23.0, 10.0)
        p.moveTo(-23.0, -3.0)
        p.curveTo(-11.0, -3.0, -12.0, -9.0, 0.0, -9.0)
        p.curveTo(12.0, -9.0, 11.0, -3.0, 23.0, -3.0)
        NoticeRnwsh.add(Instr(Form.PLIN, p))
    }

    val NoticeRlmhr = Symbol()

    init {
        NoticeRlmhr.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRlmhr.add(Instr(Form.SYMB, SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null)))
        NoticeRlmhr.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(27.0, -27.0)
        p.lineTo(-27.0, -27.0)
        p.closePath()
        NoticeRlmhr.add(Instr(Form.PGON, p))
    }

    val NoticeRtrna = Symbol()

    init {
        NoticeRtrna.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRtrna.add(Instr(Form.SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticeRtrna.add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRtrna.add(
            Instr(
                Form.EARC,
                Arc2D.Double(-15.0, -15.0, 30.0, 30.0, 315.0, -280.0, Arc2D.OPEN)
            )
        )
        val p = Path2D.Double()
        p.moveTo(18.8, -2.0)
        p.lineTo(15.8, -13.2)
        p.lineTo(7.5, -5.0)
        p.closePath()
        NoticeRtrna.add(Instr(Form.PGON, p))
    }

    val NoticeRncps = Symbol()

    init {
        NoticeRncps.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRncps.add(Instr(Form.SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRncps.add(Instr(Form.FILL, Color.black))
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
        NoticeRncps.add(Instr(Form.PGON, p))
    }

    val NoticeRnsmc = Symbol()

    init {
        NoticeRnsmc.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRnsmc.add(Instr(Form.SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null)))
        NoticeRnsmc.add(Instr(Form.FILL, Color.black))
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
        NoticeRnsmc.add(Instr(Form.PGON, p))
    }

    val NoticeRattn = Symbol()

    init {
        NoticeRattn.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRattn.add(Instr(Form.SYMB, SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null)))
        NoticeRattn.add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoticeRattn.add(Instr(Form.FILL, Color.black))
        NoticeRattn.add(Instr(Form.LINE, Line2D.Double(0.0, -20.0, 0.0, 10.0)))
        NoticeRattn.add(Instr(Form.LINE, Line2D.Double(0.0, 15.0, 0.0, 20.0)))
    }

    val NoticeRfwcr = Symbol()

    init {
        NoticeRfwcr.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRfwcr.add(Instr(Form.SYMB, SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null)))
        NoticeRfwcr.add(Instr(Form.FILL, Color.black))
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
        NoticeRfwcr.add(Instr(Form.PGON, p))
    }

    val NoticeRship = Symbol()

    init {
        NoticeRship.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        NoticeRship.add(Instr(Form.SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null)))
        NoticeRship.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)
            )
        )
        NoticeRship.add(Instr(Form.FILL, Color.black))
        NoticeRship.add(Instr(Form.LINE, Line2D.Double(-12.0, -12.0, 10.0, 10.0)))
        NoticeRship.add(Instr(Form.LINE, Line2D.Double(-12.0, -8.0, -8.0, -12.0)))
        NoticeRship.add(Instr(Form.LINE, Line2D.Double(12.0, -12.0, -10.0, 10.0)))
        NoticeRship.add(Instr(Form.LINE, Line2D.Double(12.0, -8.0, 8.0, -12.0)))
        NoticeRship.add(
            Instr(
                Form.EARC,
                Arc2D.Double(-17.0, -13.0, 30.0, 30.0, 185.0, 80.0, Arc2D.OPEN)
            )
        )
        NoticeRship.add(
            Instr(
                Form.EARC,
                Arc2D.Double(-13.0, -13.0, 30.0, 30.0, 275.0, 80.0, Arc2D.OPEN)
            )
        )
    }

    val NmkPpwbcl = mapOf(
        CatNMK.NMK_WRAL to NoticePwralL,
        CatNMK.NMK_WLAR to NoticePwlarL,
        CatNMK.NMK_KTPM to NoticePktmL,
        CatNMK.NMK_KTSM to NoticePktmL,
        CatNMK.NMK_KTMR to NoticePktmrL,
        CatNMK.NMK_CRTP to NoticePcrL,
        CatNMK.NMK_CRTS to NoticePcrL,
    )

    val NmkPpwbcr = mapOf(
        CatNMK.NMK_WRAL to NoticePwralR,
        CatNMK.NMK_WLAR to NoticePwlarR,
        CatNMK.NMK_KTPM to NoticePktmR,
        CatNMK.NMK_KTSM to NoticePktmR,
        CatNMK.NMK_KTMR to NoticePktmrR,
        CatNMK.NMK_CRTP to NoticePcrR,
        CatNMK.NMK_CRTS to NoticePcrR,
    )

    val NmkRiwr = mapOf(
        CatNMK.NMK_NPAS to NoticeRnpas,
        CatNMK.NMK_NANK to NoticeRnank,
        CatNMK.NMK_NWSH to NoticeRnwsh,
        CatNMK.NMK_LMHR to NoticeRlmhr,
        CatNMK.NMK_TRNA to NoticeRtrna,
        CatNMK.NMK_NCPS to NoticeRncps,
        CatNMK.NMK_NSMC to NoticeRnsmc,
        CatNMK.NMK_ATTN to NoticeRattn,
        CatNMK.NMK_FWCR to NoticeRfwcr,
        CatNMK.NMK_SHIP to NoticeRship,
    )

    fun getScheme(sys: MarSYS?, bank: BnkWTW?): Symbols.Scheme {
        val colours = ArrayList<Color?>()
        val scheme = Symbols.Scheme(colours)
        when (sys) {
            MarSYS.SYS_BNWR, MarSYS.SYS_BWR2 -> when (bank) {
                BnkWTW.BWW_LEFT -> {
                    colours.add(Color.white)
                    colours.add(Color(0xf00000))
                }
                BnkWTW.BWW_RGHT -> {
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


    fun getNotice(cat: CatNMK, sys: MarSYS?, bank: BnkWTW?): Symbol? {
        var symbol: Symbol? = null
        when (sys) {
            MarSYS.SYS_CEVN -> symbol = NmkCevni[cat]
            MarSYS.SYS_BNWR, MarSYS.SYS_BWR2 -> symbol = NmkBniwr[cat]
            MarSYS.SYS_PPWB -> when (bank) {
                BnkWTW.BWW_LEFT -> symbol = NmkPpwbcl[cat]
                BnkWTW.BWW_RGHT -> symbol = NmkPpwbcr[cat]
                else -> {}
            }
            MarSYS.SYS_RIWR -> symbol = NmkRiwr[cat]
            else -> {}
        }
        return symbol
    }
}