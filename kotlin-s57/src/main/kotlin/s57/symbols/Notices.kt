// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.parser.S57val.BnkWTW
import s57.parser.S57val.CatNMK
import s57.parser.S57val.MarSYS
import s57.parser.deg2rad
import s57.symbols.Symbols.Caption
import s57.symbols.Symbols.Form.*
import s57.symbols.Symbols.Handle
import s57.symbols.Symbols.Instr
import s57.symbols.Symbols.Scheme
import s57.symbols.Symbols.SubSymbol
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Color.*
import java.awt.Font
import java.awt.geom.*
import java.awt.geom.AffineTransform.*


/**
 * @author Malcolm Herring
 */
object Notices {

    private val Bollard = Symbol().apply {
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
        addInstr(PGON, p)
    }

    private val Motor = Symbol().apply {
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
        addInstr(PGON, p)
    }

    private val Rowboat = Symbol().apply {
        val p = Path2D.Double()
        p.moveTo(-17.5, -2.0)
        p.lineTo(17.5, -2.0)
        p.lineTo(15.0, 6.0)
        p.lineTo(-11.0, 6.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(RSHP, Ellipse2D.Double(-6.0, -17.5, 6.0, 6.0))
        addInstr(STRK, BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-5.5, -9.0, -8.0, 0.0))
        addInstr(LINE, Line2D.Double(-5.0, 10.0, -7.5, 14.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-5.5, -9.0, 7.0, -6.5))
        addInstr(LINE, Line2D.Double(7.3, -7.8, -5.0, 10.0))
    }

    private val Sailboard = Symbol().apply {
        var p = Path2D.Double()
        p.moveTo(-6.0, 19.0)
        p.quadTo(-4.0, -5.0, 1.5, -20.0)
        p.quadTo(14.0, -7.0, 15.5, 6.5)
        p.quadTo(7.0, 17.0, -6.0, 19.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-2.0, 20.0, -10.0, 20.0))
        addInstr(LINE, Line2D.Double(-13.0, 2.5, -3.0, 2.5))
        addInstr(RSHP, Ellipse2D.Double(-15.0, -4.0, 5.0, 5.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        p = Path2D.Double()
        p.moveTo(-13.0, 2.5)
        p.lineTo(-12.0, 6.0)
        p.lineTo(-12.0, 9.5)
        addInstr(PLIN, p)
        addInstr(STRK, BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        p = Path2D.Double()
        p.moveTo(-12.0, 9.5)
        p.lineTo(-7.5, 13.0)
        p.lineTo(-6.0, 19.0)
        addInstr(PLIN, p)
    }

    private val Sailboat = Symbol().apply {
        var p = Path2D.Double()
        p.moveTo(3.75, -20.5)
        p.lineTo(3.75, 8.5)
        p.lineTo(-19.5, 8.5)
        p.closePath()
        addInstr(PGON, p)
        p = Path2D.Double()
        p.moveTo(-19.5, 12.0)
        p.lineTo(19.5, 12.0)
        p.lineTo(13.0, 20.5)
        p.lineTo(-16.0, 20.5)
        p.closePath()
        addInstr(PGON, p)
    }

    private val Slipway = Symbol().apply {
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
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-14.0, 3.0, 20.0, -2.5))
        addInstr(STRK, BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(ELPS, Ellipse2D.Double(1.0, 1.5, 3.0, 3.0))
        p = Path2D.Double()
        p.moveTo(-21.0, 8.5)
        p.curveTo(-17.5, 5.0, -17.5, 12.0, -13.0, 7.2)
        addInstr(PLIN, p)
    }

    private val Speedboat = Symbol().apply {
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-21.0, 0.0, -17.0, -1.0))
        var p = Path2D.Double()
        p.moveTo(-17.5, 8.5)
        p.curveTo(-10.5, 13.0, -2.5, 2.0, 4.0, 6.0)
        p.curveTo(12.0, 2.0, 11.5, 9.5, 20.0, 6.0)
        addInstr(PLIN, p)
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
        addInstr(PGON, p)
        addInstr(RSHP, Ellipse2D.Double(-1.5, -13.0, 5.0, 5.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-2.0, -7.0, -5.0, 0.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-2.0, -7.0, 5.0, -5.0))
    }

    private val Turn = Symbol().apply {
        addInstr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(EARC, Arc2D.Double(-9.0, -9.0, 18.0, 18.0, 270.0, 230.0, Arc2D.OPEN))
        addInstr(EARC, Arc2D.Double(-20.0, -20.0, 40.0, 40.0, 315.0, -280.0, Arc2D.OPEN))
        val p = Path2D.Double()
        p.moveTo(21.8, -7.0)
        p.lineTo(18.8, -18.2)
        p.lineTo(10.5, -10.0)
        p.closePath()
        p.moveTo(-12.9, 0.7)
        p.lineTo(-1.7, -2.3)
        p.lineTo(-9.9, -10.5)
        p.closePath()
        addInstr(PGON, p)
    }

    private val Waterbike = Symbol().apply {
        var p = Path2D.Double()
        p.moveTo(-17.5, 13.0)
        p.curveTo(-10.5, 17.5, -2.5, 6.5, 4.0, 10.5)
        p.curveTo(12.0, 6.5, 11.5, 14.0, 20.0, 10.5)
        addInstr(PLIN, p)
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
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        p = Path2D.Double()
        p.moveTo(-7.0, 1.0)
        p.lineTo(-7.5, -1.5)
        p.lineTo(-12.5, -3.5)
        p.lineTo(-11.5, -10.5)
        addInstr(PLIN, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-11.5, -10.5, -3.0, -8.5))
        addInstr(RSHP, Ellipse2D.Double(-11.5, -18.0, 5.0, 5.0))
    }

    private val Waterski = Symbol().apply {
        addInstr(RSHP, Ellipse2D.Double(12.0, -18.0, 6.0, 6.0))
        addInstr(STRK, BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-18.0, -6.0, 0.0, -6.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        var p = Path2D.Double()
        p.moveTo(6.5, 17.5)
        p.lineTo(-13.0, 14.5)
        p.curveTo(-15.0, 14.25, -16.0, 13.6, -17.5, 12.0)
        addInstr(PLIN, p)
        addInstr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        p = Path2D.Double()
        p.moveTo(-1.5, -4.0)
        p.lineTo(14.0, -7.5)
        p.lineTo(9.5, 3.5)
        p.lineTo(2.0, 6.0)
        p.lineTo(-4.4, 15.8)
        addInstr(PLIN, p)
    }

    private val NoticeA = Symbol().apply {
        addInstr(FILL, Color(0xe80000))
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(FILL, white)
        addInstr(RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0xe80000))
        addInstr(LINE, Line2D.Double(-25.0, -25.0, 25.0, 25.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
    }

    private val NoticeB = Symbol().apply {
        addInstr(FILL, Color(0xe80000))
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(FILL, white)
        addInstr(RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
    }

    private val NoticeE = Symbol().apply {
        addInstr(FILL, Color(0x0000a0))
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(FILL, white)
    }


    val Notice = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, Color(0xe80000))
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(FILL, Color(0x0000a0))
        addInstr(RSHP, Rectangle2D.Double(-21.0, -21.0, 42.0, 42.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
    }

    val NoticeA1 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, Color(0xe80000))
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, white)
        addInstr(RSHP, Rectangle2D.Double(-30.0, -10.0, 60.0, 20.0))
        addInstr(FILL, black)
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
    }

    val NoticeA1a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, Color(0xe80000))
        addInstr(RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, white)
        addInstr(RSHP, Rectangle2D.Double(-29.0, -10.0, 58.0, 20.0))
        addInstr(FILL, black)
        addInstr(ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0))
    }

    val NoticeA2 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val NoticeA3 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA2, 1.0, 0.0, 0.0, null, null))
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
        addInstr(PGON, p)
    }

    val NoticeA4 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val NoticeA4_1 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA4, 1.0, 0.0, 0.0, null, null))
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
        addInstr(PGON, p)
    }

    val NoticeA5 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeA5_1 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
    }

    val NoticeA6 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(
            SYMB, SubSymbol(
                Harbours.Anchor, 0.4, 0.0, 0.0, Scheme(black),
                Symbols.Delta(Handle.CC, getRotateInstance(deg2rad(180.0)))
            )
        )
    }

    val NoticeA7 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Bollard, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA8 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Turn, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA9 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(7f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        val p = Path2D.Double()
        p.moveTo(-23.0, 10.0)
        p.curveTo(-11.0, 10.0, -12.0, 4.0, 0.0, 4.0)
        p.curveTo(12.0, 4.0, 11.0, 10.0, 23.0, 10.0)
        p.moveTo(-23.0, -3.0)
        p.curveTo(-11.0, -3.0, -12.0, -9.0, 0.0, -9.0)
        p.curveTo(12.0, -9.0, 11.0, -3.0, 23.0, -3.0)
        addInstr(PLIN, p)
    }

    val NoticeA10a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, white)
        var p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(FILL, Color(0xe80000))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val NoticeA10b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(
            SYMB, SubSymbol(
                NoticeA10a, 1.0, 0.0, 0.0, null, Symbols.Delta(
                    Handle.CC, getRotateInstance(deg2rad(180.0))
                )
            )
        )
    }

    val NoticeA12 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Motor, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA13 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(
            TEXT, Caption(
                "SPORT", Font("Arial", Font.BOLD, 15), black, Symbols.Delta(
                    Handle.BC, getTranslateInstance(0.0, 5.0)
                )
            )
        )
    }

    val NoticeA14 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Waterski, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA15 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Sailboat, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA16 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Rowboat, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA17 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Sailboard, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA18 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Speedboat, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA19 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Slipway, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeA20 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeA, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Waterbike, 1.0, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeB1a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(21.0, 8.0)
        p.lineTo(-8.0, 8.0)
        p.lineTo(-8.0, 18.0)
        p.lineTo(-21.0, 0.0)
        p.lineTo(-8.0, -18.0)
        p.lineTo(-8.0, -8.0)
        p.lineTo(21.0, -8.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB1b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(-21.0, 8.0)
        p.lineTo(8.0, 8.0)
        p.lineTo(8.0, 18.0)
        p.lineTo(21.0, 0.0)
        p.lineTo(8.0, -18.0)
        p.lineTo(8.0, -8.0)
        p.lineTo(-21.0, -8.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB2a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        var p = Path2D.Double()
        p.moveTo(18.0, 21.0)
        p.lineTo(18.0, 10.0)
        p.lineTo(-15.0, -10.0)
        p.lineTo(-15.0, -15.0)
        addInstr(PLIN, p)
        p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(-21.0, -15.0)
        p.lineTo(-9.0, -15.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB2b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        var p = Path2D.Double()
        p.moveTo(-18.0, 21.0)
        p.lineTo(-18.0, 10.0)
        p.lineTo(15.0, -10.0)
        p.lineTo(15.0, -15.0)
        addInstr(PLIN, p)
        p = Path2D.Double()
        p.moveTo(15.0, -21.0)
        p.lineTo(21.0, -15.0)
        p.lineTo(9.0, -15.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB3a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-15.0, 21.0, -15.0, -15.0))
        var p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(-21.0, -15.0)
        p.lineTo(-9.0, -15.0)
        p.closePath()
        addInstr(PGON, p)
        add(
            Instr(
                STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
            )
        )
        addInstr(LINE, Line2D.Double(15.0, -21.0, 15.0, 15.0))
        p = Path2D.Double()
        p.moveTo(15.0, 21.0)
        p.lineTo(21.0, 15.0)
        p.lineTo(9.0, 15.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB3b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(15.0, 21.0, 15.0, -15.0))
        var p = Path2D.Double()
        p.moveTo(15.0, -21.0)
        p.lineTo(21.0, -15.0)
        p.lineTo(9.0, -15.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(
            STRK,
            BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
        )
        addInstr(LINE, Line2D.Double(-15.0, -21.0, -15.0, 15.0))
        p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(-21.0, 15.0)
        p.lineTo(-9.0, 15.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB4a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB2a, 1.0, 0.0, 0.0, null, null))
        addInstr(
            STRK,
            BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
        )
        var p = Path2D.Double()
        p.moveTo(18.0, -21.0)
        p.lineTo(18.0, -10.0)
        p.lineTo(-15.0, 10.0)
        p.lineTo(-15.0, 15.0)
        addInstr(PLIN, p)
        p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(-21.0, 15.0)
        p.lineTo(-9.0, 15.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB4b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB2b, 1.0, 0.0, 0.0, null, null))
        addInstr(
            STRK,
            BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, floatArrayOf(5.5f, 2.4f), 0.0f)
        )
        var p = Path2D.Double()
        p.moveTo(-18.0, -21.0)
        p.lineTo(-18.0, -10.0)
        p.lineTo(15.0, 10.0)
        p.lineTo(15.0, 15.0)
        addInstr(PLIN, p)
        p = Path2D.Double()
        p.moveTo(15.0, 21.0)
        p.lineTo(21.0, 15.0)
        p.lineTo(9.0, 15.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeB5 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(15.0, 0.0, -15.0, 0.0))
    }

    val NoticeB6 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
    }

    val NoticeB7 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(RSHP, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
    }

    val NoticeB8 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 15.0, 0.0, -15.0))
    }

    val NoticeB9a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-21.0, 0.0, 21.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 21.0, 0.0, 0.0))
    }

    val NoticeB9b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-21.0, 0.0, 21.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 21.0, 0.0, -21.0))
    }

    val NoticeB11 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        addInstr(
            TEXT, Caption(
                "VHF", Font("Arial", Font.BOLD, 20), black, Symbols.Delta(
                    Handle.BC, getTranslateInstance(0.0, 0.0)
                )
            )
        )
    }

    val NoticeC1 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(-15.0, 21.0)
        p.lineTo(0.0, 12.0)
        p.lineTo(15.0, 21.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeC2 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(-15.0, -21.0)
        p.lineTo(0.0, -12.0)
        p.lineTo(15.0, -21.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeC3 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(21.0, -15.0)
        p.lineTo(12.0, 0.0)
        p.lineTo(21.0, 15.0)
        p.closePath()
        p.moveTo(-21.0, -15.0)
        p.lineTo(-12.0, 0.0)
        p.lineTo(-21.0, 15.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeC4 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
    }

    val NoticeC5a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(-21.0, -21.0)
        p.lineTo(10.0, -21.0)
        p.lineTo(21.0, 0.0)
        p.lineTo(10.0, 21.0)
        p.lineTo(-21.0, 21.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeC5b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeB, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(21.0, -21.0)
        p.lineTo(-10.0, -21.0)
        p.lineTo(-21.0, 0.0)
        p.lineTo(-10.0, 21.0)
        p.lineTo(21.0, 21.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeD1a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, yellow)
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(PLIN, p)
    }

    val NoticeD1b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, yellow)
        val p = Path2D.Double()
        p.moveTo(-30.0, 0.0)
        p.lineTo(-15.0, 25.0)
        p.lineTo(15.0, -25.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(15.0, 25.0)
        p.lineTo(-15.0, -25.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(PLIN, p)
    }

    val NoticeD2a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, white)
        var p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(FILL, Color(0x00e800))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val NoticeD2b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(
            SYMB, SubSymbol(
                NoticeD2a, 1.0, 0.0, 0.0, null,
                Symbols.Delta(Handle.CC, getRotateInstance(deg2rad(180.0)))
            )
        )
    }

    val NoticeD3a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(28.0, 10.0)
        p.lineTo(-10.0, 10.0)
        p.lineTo(-10.0, 20.0)
        p.lineTo(-28.0, 0.0)
        p.lineTo(-10.0, -20.0)
        p.lineTo(-10.0, -10.0)
        p.lineTo(28.0, -10.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeD3b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.moveTo(-28.0, 10.0)
        p.lineTo(10.0, 10.0)
        p.lineTo(10.0, 20.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(10.0, -20.0)
        p.lineTo(10.0, -10.0)
        p.lineTo(-28.0, -10.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeE1 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, Color(0x00e800))
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, white)
        addInstr(RSHP, Rectangle2D.Double(-10.0, -30.0, 20.0, 60.0))
        addInstr(FILL, black)
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
    }

    val NoticeE2 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
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
        addInstr(PGON, p)
    }

    val NoticeE3 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(25.0, -20.0, 25.0, 20.0))
        addInstr(LINE, Line2D.Double(-25.0, -20.0, -25.0, 20.0))
        addInstr(LINE, Line2D.Double(-15.0, -15.0, -15.0, 20.0))
        addInstr(LINE, Line2D.Double(-5.0, -15.0, -5.0, 20.0))
        addInstr(LINE, Line2D.Double(5.0, -15.0, 5.0, 20.0))
        addInstr(LINE, Line2D.Double(15.0, -15.0, 15.0, 20.0))
        addInstr(STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-26.0, 18.5, 26.0, 18.5))
        addInstr(LINE, Line2D.Double(-26.0, -15.0, 26.0, -15.0))
    }

    val NoticeE4a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
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
        addInstr(PGON, p)
    }

    val NoticeE4b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
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
        addInstr(PGON, p)
    }

    val NoticeE5 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeE5_1 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
    }

    val NoticeE5_2 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
    }

    val NoticeE5_3 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
    }

    val NoticeE5_4 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-28.0, 25.0)
        p.lineTo(0.0, -28.0)
        p.lineTo(28.0, 25.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeE5_5 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-28.0, 25.0)
        p.lineTo(0.0, -28.0)
        p.lineTo(28.0, 25.0)
        p.closePath()
        p.moveTo(0.0, 24.0)
        p.lineTo(-15.0, 2.0)
        p.lineTo(15.0, 2.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeE5_6 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeE5_7 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeE5_8 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-28.0, -25.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, -25.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeE5_9 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-28.0, -25.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, -25.0)
        p.closePath()
        p.moveTo(0.0, 8.0)
        p.lineTo(-15.0, -14.0)
        p.lineTo(15.0, -14.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeE5_10 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeE5_11 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeE5_12 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-28.0, 0.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(0.0, -28.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeE5_13 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-28.0, 0.0)
        p.lineTo(0.0, 28.0)
        p.lineTo(28.0, 0.0)
        p.lineTo(0.0, -28.0)
        p.closePath()
        p.moveTo(0.0, 15.0)
        p.lineTo(-15.0, -7.0)
        p.lineTo(15.0, -7.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeE5_14 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeE5_15 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
    }

    val NoticeE6 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Harbours.Anchor, 0.4, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE7 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Bollard, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE7_1 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(20.0, 25.0, 20.0, -10.0))
        addInstr(LINE, Line2D.Double(22.0, -8.0, -15.0, -20.0))
        addInstr(STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(20.0, 8.0, 0.0, -15.0))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(PGON, p)
        addInstr(FILL, Color(0x0000a0))
        addInstr(RSHP, Ellipse2D.Double(-16.0, 13.0, 4.0, 4.0))
        addInstr(RSHP, Ellipse2D.Double(2.0, 13.0, 4.0, 4.0))
    }

    val NoticeE8 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Turn, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE9a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0))
    }

    val NoticeE9b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0))
    }

    val NoticeE9c = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0))
    }

    val NoticeE9d = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0))
        addInstr(LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0))
    }

    val NoticeE9e = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0))
        addInstr(LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0))
    }

    val NoticeE9f = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0))
        addInstr(LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0))
    }

    val NoticeE9g = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0))
        addInstr(LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0))
    }

    val NoticeE9h = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0))
        addInstr(LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0))
        addInstr(LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0))
    }

    val NoticeE9i = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -4.0))
        addInstr(LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 2.0))
        addInstr(LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0))
    }

    val NoticeE10a = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -29.0))
    }

    val NoticeE10b = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-29.0, 0.0, 29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0))
    }

    val NoticeE10c = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0))
        addInstr(LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0))
    }

    val NoticeE10d = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0))
        addInstr(LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0))
    }

    val NoticeE10e = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0))
        addInstr(LINE, Line2D.Double(-4.0, 0.0, 29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0))
        addInstr(LINE, Line2D.Double(2.0, 0.0, -29.0, 0.0))
    }

    val NoticeE10f = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -29.0, 0.0, 4.0))
        addInstr(LINE, Line2D.Double(4.0, 0.0, -29.0, 0.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, 29.0, 0.0, -2.0))
        addInstr(LINE, Line2D.Double(-2.0, 0.0, 29.0, 0.0))
    }

    val NoticeE11 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-27.0, -27.0, 27.0, 27.0))
    }

    val NoticeE13 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
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
        addInstr(PGON, p)
    }

    val NoticeE14 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
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
        addInstr(PGON, p)
    }

    val NoticeE15 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Motor, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE16 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(
            TEXT, Caption(
                "SPORT", Font("Arial", Font.BOLD, 15), white, Symbols.Delta(
                    Handle.BC, getTranslateInstance(0.0, 5.0)
                )
            )
        )
    }

    val NoticeE17 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Waterski, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE18 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Sailboat, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE19 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Rowboat, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE20 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Sailboard, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE21 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Speedboat, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE22 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Slipway, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeE23 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(
            TEXT, Caption(
                "VHF", Font("Arial", Font.BOLD, 20), white, Symbols.Delta(
                    Handle.BC, getTranslateInstance(0.0, 0.0)
                )
            )
        )
    }

    val NoticeE24 = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeE, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Waterbike, 1.0, 0.0, 0.0, Scheme(white), null))
    }

    val NoticeBoard = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 30.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        val p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(20.0, -15.0)
        p.lineTo(-20.0, -15.0)
        p.closePath()
        addInstr(FILL, white)
        addInstr(PGON, p)
        addInstr(FILL, black)
        addInstr(PLIN, p)
    }

    val NoticeTriangle = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 30.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        val p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(0.0, -15.0)
        p.closePath()
        addInstr(FILL, white)
        addInstr(PGON, p)
        addInstr(FILL, black)
        addInstr(PLIN, p)
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
    private val NoticeBB = Symbol().apply {
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-29.0, -29.0, -29.0, 29.0))
        addInstr(LINE, Line2D.Double(29.0, -29.0, 29.0, 29.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
    }

    private val NoticeBP = Symbol().apply {
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, white)
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(FILL, black)
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
    }

    private val NoticeCR = Symbol().apply {
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, white)
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 0.0)
        p.lineTo(0.0, 30.0)
        p.lineTo(30.0, 0.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(FILL, black)
        addInstr(PLIN, p)
    }

    private val NoticeKT = Symbol().apply {
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, white)
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(FILL, black)
        addInstr(PLIN, p)
    }

    val NoticeBnank = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        addInstr(SYMB, SubSymbol(Harbours.Anchor, 0.4, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-27.0, -27.0, 27.0, 27.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBlmhr = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        val p = Path2D.Double()
        p.moveTo(-29.0, -29.0)
        p.lineTo(29.0, -29.0)
        p.lineTo(0.0, 0.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(RRCT, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBktpm = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -26.0)
        p.lineTo(-20.0, -12.0)
        p.lineTo(-8.0, -12.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-14.0, -16.0, -14.0, 25.0))
        addInstr(SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBktsm = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        val p = Path2D.Double()
        p.moveTo(14.0, -26.0)
        p.lineTo(20.0, -12.0)
        p.lineTo(8.0, -12.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(14.0, -16.0, 14.0, 25.0))
        addInstr(SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBktmr = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        val p = Path2D.Double()
        p.moveTo(0.0, -26.0)
        p.lineTo(-6.0, -12.0)
        p.lineTo(6.0, -12.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -16.0, 0.0, 25.0))
        addInstr(SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBcrtp = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        var p = Path2D.Double()
        p.moveTo(-14.0, -26.0)
        p.lineTo(-20.0, -12.0)
        p.lineTo(-8.0, -12.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        p = Path2D.Double()
        p.moveTo(-14.0, -16.0)
        p.lineTo(-14.0, 0.0)
        p.lineTo(14.0, 10.0)
        p.lineTo(14.0, 25.0)
        addInstr(PLIN, p)
        addInstr(SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBcrts = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        var p = Path2D.Double()
        p.moveTo(14.0, -26.0)
        p.lineTo(20.0, -12.0)
        p.lineTo(8.0, -12.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        p = Path2D.Double()
        p.moveTo(14.0, -16.0)
        p.lineTo(14.0, 0.0)
        p.lineTo(-14.0, 10.0)
        p.lineTo(-14.0, 25.0)
        addInstr(PLIN, p)
        addInstr(SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBtrbm = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        addInstr(STRK, BasicStroke(15f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(0.0, -25.0, 0.0, 25.0))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0))
        addInstr(SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticeBrspd = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        val colours = Symbol()
        var ss = Symbol()
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(N1, ss)
        ss = Symbol()
        addInstr(
            TEXT, Caption(
                "R", Font("Arial", Font.BOLD, 60), null, Symbols.Delta(
                    Handle.CC, null
                )
            )
        )
        addInstr(SYMB, SubSymbol(NoticeBB, 1.0, 0.0, 0.0, null, null))
        addInstr(N2, ss)
        addInstr(COLR, colours)
    }

    val NoticePBwral = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, Color(0xffff00))
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
        addInstr(PGON, p)
    }

    val NoticeBwral = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, black)
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(SYMB, SubSymbol(NoticePBwral, 1.0, 0.0, 0.0, null, null))
    }

    val NoticeBwlar = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, black)
        addInstr(RSHP, RoundRectangle2D.Double(-30.0, -30.0, 60.0, 60.0, 4.0, 4.0))
        addInstr(
            SYMB, SubSymbol(
                NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                    Handle.CC, getScaleInstance(-1.0, 1.0)
                )
            )
        )
    }

    val NoticeBoptr = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, Color(0x00a000))
        addInstr(RSHP, Rectangle2D.Double(-20.0, -20.0, 40.0, 40.0))
    }

    val NoticeBoptl = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, Color(0xf00000))
        val p = Path2D.Double()
        p.moveTo(0.0, -20.0)
        p.lineTo(-20.0, 20.0)
        p.lineTo(20.0, 20.0)
        p.closePath()
        addInstr(PGON, p)
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

    val NoticePwralL = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, black)
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(
            SYMB, SubSymbol(
                NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                    Handle.TC, getScaleInstance(0.5, 0.5)
                )
            )
        )
    }

    val NoticePwralR = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeBwral, 1.0, 0.0, 0.0, null, null))
    }

    val NoticePwlarL = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, black)
        val p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(-30.0, 30.0)
        p.lineTo(30.0, 30.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(
            SYMB, SubSymbol(
                NoticePBwral, 1.0, 0.0, 0.0, null, Symbols.Delta(
                    Handle.TC, getScaleInstance(-0.5, 0.5)
                )
            )
        )
    }

    val NoticePwlarR = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeBwlar, 1.0, 0.0, 0.0, null, null))
    }

    val NoticePktmR = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0x00d400))
        addInstr(RECT, Rectangle2D.Double(-20.0, -20.0, 40.0, 40.0))
    }

    val NoticePktmL = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeKT, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0xd40000))
        addInstr(RECT, Rectangle2D.Double(-12.0, 2.0, 24.0, 24.0))
    }

    val NoticePktmrL = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeKT, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0xd40000))
        addInstr(LINE, Line2D.Double(-12.0, 2.0, -12.0, 28.0))
        addInstr(LINE, Line2D.Double(12.0, 2.0, 12.0, 28.0))
        addInstr(LINE, Line2D.Double(-12.0, 15.0, 12.0, 15.0))
    }

    val NoticePktmrR = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeBP, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0x00d400))
        addInstr(LINE, Line2D.Double(-15.0, -20.0, -15.0, 20.0))
        addInstr(LINE, Line2D.Double(15.0, -20.0, 15.0, 20.0))
        addInstr(LINE, Line2D.Double(-15.0, 0.0, 15.0, 0.0))
    }

    val NoticePcrL = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0xd40000))
        addInstr(LINE, Line2D.Double(-12.0, -12.0, 12.0, 12.0))
        addInstr(LINE, Line2D.Double(-12.0, 12.0, 12.0, -12.0))
    }

    val NoticePcrR = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0x00d400))
        addInstr(LINE, Line2D.Double(-12.0, -12.0, 12.0, 12.0))
        addInstr(LINE, Line2D.Double(-12.0, 12.0, 12.0, -12.0))
    }

    val NoticeRphib = Symbol().apply {
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0xd40000))
        addInstr(ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(LINE, Line2D.Double(-20.0, -20.0, 20.0, 20.0))
    }

    val NoticeRinfo = Symbol().apply {
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0xd40000))
        addInstr(RECT, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
    }

    val NoticeRnpas = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val NoticeRnank = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null))
        addInstr(SYMB, SubSymbol(Harbours.Anchor, 0.4, 0.0, 0.0, Scheme(black), null))
    }

    val NoticeRnwsh = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
        val p = Path2D.Double()
        p.moveTo(-23.0, 10.0)
        p.curveTo(-11.0, 10.0, -12.0, 4.0, 0.0, 4.0)
        p.curveTo(12.0, 4.0, 11.0, 10.0, 23.0, 10.0)
        p.moveTo(-23.0, -3.0)
        p.curveTo(-11.0, -3.0, -12.0, -9.0, 0.0, -9.0)
        p.curveTo(12.0, -9.0, 11.0, -3.0, 23.0, -3.0)
        addInstr(PLIN, p)
    }

    val NoticeRlmhr = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
        val p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(27.0, -27.0)
        p.lineTo(-27.0, -27.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeRtrna = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(EARC, Arc2D.Double(-15.0, -15.0, 30.0, 30.0, 315.0, -280.0, Arc2D.OPEN))
        val p = Path2D.Double()
        p.moveTo(18.8, -2.0)
        p.lineTo(15.8, -13.2)
        p.lineTo(7.5, -5.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val NoticeRncps = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val NoticeRnsmc = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRphib, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val NoticeRattn = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, -20.0, 0.0, 10.0))
        addInstr(LINE, Line2D.Double(0.0, 15.0, 0.0, 20.0))
    }

    val NoticeRfwcr = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeRinfo, 1.0, 0.0, 0.0, null, null))
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val NoticeRship = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(NoticeCR, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(-12.0, -12.0, 10.0, 10.0))
        addInstr(LINE, Line2D.Double(-12.0, -8.0, -8.0, -12.0))
        addInstr(LINE, Line2D.Double(12.0, -12.0, -10.0, 10.0))
        addInstr(LINE, Line2D.Double(12.0, -8.0, 8.0, -12.0))
        addInstr(EARC, Arc2D.Double(-17.0, -13.0, 30.0, 30.0, 185.0, 80.0, Arc2D.OPEN))
        addInstr(EARC, Arc2D.Double(-13.0, -13.0, 30.0, 30.0, 275.0, 80.0, Arc2D.OPEN))
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

    fun getScheme(sys: MarSYS?, bank: BnkWTW?): Scheme {
        val colours = ArrayList<Color?>()
        val scheme = Scheme(colours)
        when (sys) {
            MarSYS.SYS_BNWR, MarSYS.SYS_BWR2 -> when (bank) {
                BnkWTW.BWW_LEFT -> {
                    colours.add(white)
                    colours.add(Color(0xf00000))
                }
                BnkWTW.BWW_RGHT -> {
                    colours.add(white)
                    colours.add(Color(0x00a000))
                }
                else -> {
                    colours.add(Color(0xff8040))
                    colours.add(black)
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

    val AllNotices: List<Symbol> = listOf(
        Bollard,
        Motor,
        Rowboat,
        Sailboard,
        Sailboat,
        Slipway,
        Speedboat,
        Turn,
        Waterbike,
        Waterski,
        NoticeA,
        NoticeB,
        NoticeE,
        Notice,
        NoticeA1,
        NoticeA1a,
        NoticeA2,
        NoticeA3,
        NoticeA4,
        NoticeA4_1,
        NoticeA5,
        NoticeA5_1,
        NoticeA6,
        NoticeA7,
        NoticeA8,
        NoticeA9,
        NoticeA10a,
        NoticeA10b,
        NoticeA12,
        NoticeA13,
        NoticeA14,
        NoticeA15,
        NoticeA16,
        NoticeA17,
        NoticeA18,
        NoticeA19,
        NoticeA20,
        NoticeB1a,
        NoticeB1b,
        NoticeB2a,
        NoticeB2b,
        NoticeB3a,
        NoticeB3b,
        NoticeB4a,
        NoticeB4b,
        NoticeB5,
        NoticeB6,
        NoticeB7,
        NoticeB8,
        NoticeB9a,
        NoticeB9b,
        NoticeB11,
        NoticeC1,
        NoticeC2,
        NoticeC3,
        NoticeC4,
        NoticeC5a,
        NoticeC5b,
        NoticeD1a,
        NoticeD1b,
        NoticeD2a,
        NoticeD2b,
        NoticeD3a,
        NoticeD3b,
        NoticeE1,
        NoticeE2,
        NoticeE3,
        NoticeE4a,
        NoticeE4b,
        NoticeE5,
        NoticeE5_1,
        NoticeE5_2,
        NoticeE5_3,
        NoticeE5_4,
        NoticeE5_5,
        NoticeE5_6,
        NoticeE5_7,
        NoticeE5_8,
        NoticeE5_9,
        NoticeE5_10,
        NoticeE5_11,
        NoticeE5_12,
        NoticeE5_13,
        NoticeE5_14,
        NoticeE5_15,
        NoticeE6,
        NoticeE7,
        NoticeE7_1,
        NoticeE8,
        NoticeE9a,
        NoticeE9b,
        NoticeE9c,
        NoticeE9d,
        NoticeE9e,
        NoticeE9f,
        NoticeE9g,
        NoticeE9h,
        NoticeE9i,
        NoticeE10a,
        NoticeE10b,
        NoticeE10c,
        NoticeE10d,
        NoticeE10e,
        NoticeE10f,
        NoticeE11,
        NoticeE13,
        NoticeE14,
        NoticeE15,
        NoticeE16,
        NoticeE17,
        NoticeE18,
        NoticeE19,
        NoticeE20,
        NoticeE21,
        NoticeE22,
        NoticeE23,
        NoticeE24,
        NoticeBoard,
        NoticeTriangle,
        NoticeBB,
        NoticeBP,
        NoticeCR,
        NoticeKT,
        NoticeBnank,
        NoticeBlmhr,
        NoticeBktpm,
        NoticeBktsm,
        NoticeBktmr,
        NoticeBcrtp,
        NoticeBcrts,
        NoticeBtrbm,
        NoticeBrspd,
        NoticePBwral,
        NoticeBwral,
        NoticeBwlar,
        NoticeBoptr,
        NoticeBoptl,
        NoticePwralL,
        NoticePwralR,
        NoticePwlarL,
        NoticePwlarR,
        NoticePktmR,
        NoticePktmL,
        NoticePktmrL,
        NoticePktmrR,
        NoticePcrL,
        NoticePcrR,
        NoticeRphib,
        NoticeRinfo,
        NoticeRnpas,
        NoticeRnank,
        NoticeRnwsh,
        NoticeRlmhr,
        NoticeRtrna,
        NoticeRncps,
        NoticeRnsmc,
        NoticeRattn,
        NoticeRfwcr,
        NoticeRship,
    )
}