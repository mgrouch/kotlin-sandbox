// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.parser.S57val.CatSCF
import s57.symbols.Symbols.Form.*
import s57.symbols.Symbols.SubSymbol
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Color.white
import java.awt.geom.*

/**
 * @author Malcolm Herring
 */
object Facilities {

    val Facility = Symbol().apply {
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(-0x7f000001, true))
        val s = RoundRectangle2D.Double(-29.0, -29.0, 58.0, 58.0, 15.0, 15.0)
        addInstr(RSHP, s)
        addInstr(FILL, Color(0xa30075))
        addInstr(RRCT, s)
    }

    val Boatlift = Symbol().apply {//was Crane
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        addInstr(ELPS, Ellipse2D.Double(-3.7, -19.7, 12.0, 12.0))
        addInstr(LINE, Line2D.Double(2.3, -7.7, 2.3, -2.0))
        addInstr(EARC, Arc2D.Double(-10.0, -1.5, 20.0, 20.0, 75.0, -260.0, Arc2D.OPEN))
    }

    val Boatyard = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        addInstr(LINE, Line2D.Double(19.0, 19.0, -8.0, -8.0))
        val p = Path2D.Double()
        p.moveTo(-11.3, -11.3)
        p.lineTo(-10.5, -17.5)
        p.lineTo(-14.8, -21.9)
        p.lineTo(-11.3, -25.4)
        p.lineTo(-7.4, -21.5)
        p.curveTo(1.0, -11.5, -11.5, 1.0, -21.5, -7.4)
        p.lineTo(-25.4, -11.3)
        p.lineTo(-21.9, -14.8)
        p.lineTo(-17.5, -10.5)
        p.closePath()
        addInstr(PGON, p)
    }

    val Chandler = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(ELPS, Ellipse2D.Double(14.0, 7.0, 10.0, 10.0))
        addInstr(LINE, Line2D.Double(-23.0, 12.0, 14.0, 12.0))
        addInstr(LINE, Line2D.Double(8.0, 21.0, 8.0, -8.6))
        addInstr(LINE, Line2D.Double(-16.0, 21.0, -16.0, -8.6))
        addInstr(EARC, Arc2D.Double(-16.0, -20.5, 24.0, 24.0, 0.0, 180.0, Arc2D.OPEN))
    }

    val Fuel = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xa30075))
        var p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-15.6, 22.1)
        p.lineTo(-15.6, -19.4)
        p.quadTo(-15.5, -22.7, -12.2, -22.8)
        p.lineTo(0.2, -22.8)
        p.quadTo(3.3, -22.7, 3.4, -19.4)
        p.lineTo(3.4, 22.1)
        p.closePath()
        p.moveTo(-12.8, -19.0)
        p.quadTo(-12.7, -19.9, -11.8, -20.0)
        p.lineTo(-0.4, -20.0)
        p.quadTo(0.5, -19.9, 0.6, -19.0)
        p.lineTo(0.6, -9.4)
        p.quadTo(0.5, -8.5, -0.4, -8.4)
        p.lineTo(-11.8, -8.4)
        p.quadTo(-12.7, -8.3, -12.8, -9.4)
        p.closePath()
        addInstr(PGON, p)
        p = Path2D.Double()
        p.moveTo(3.0, -3.0)
        p.lineTo(7.0, -3.0)
        p.quadTo(9.4, -2.8, 9.6, -0.4)
        p.lineTo(9.6, 18.0)
        p.curveTo(10.1, 23.2, 18.4, 21.5, 17.4, 17.2)
        p.lineTo(14.9, 3.5)
        p.lineTo(15.1, -10.3)
        p.quadTo(14.9, -11.9, 13.9, -13.1)
        p.lineTo(7.4, -19.6)
        p.moveTo(15.1, -7.4)
        p.lineTo(12.6, -7.4)
        p.quadTo(11.1, -7.4, 11.1, -8.9)
        p.lineTo(11.1, -16.0)
        addInstr(PLIN, p)
    }

    val Laundrette = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xa30075))
        addInstr(RECT, Rectangle2D.Double(-15.0, -15.0, 30.0, 30.0))
        addInstr(ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
        val p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(-15.0, -20.0)
        p.lineTo(15.0, -20.0)
        p.lineTo(15.0, -15.0)
        p.moveTo(-10.0, 15.0)
        p.lineTo(-10.0, 20.0)
        p.lineTo(10.0, 20.0)
        p.lineTo(10.0, 15.0)
        addInstr(PLIN, p)
    }

    val PumpOut = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER))
        addInstr(FILL, Color(0xa30075))
        var p = Path2D.Double()
        p.moveTo(3.9, -3.7)
        p.lineTo(-7.4, -3.7)
        p.lineTo(-12.0, 2.0)
        p.lineTo(-22.7, 2.0)
        p.lineTo(-11.8, 14.9)
        p.lineTo(15.1, 14.9)
        p.lineTo(21.9, 10.2)
        p.lineTo(21.9, 3.1)
        p.lineTo(13.5, 3.1)
        addInstr(PLIN, p)
        addInstr(STRK, BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        p = Path2D.Double()
        p.moveTo(-2.5, 3.0)
        p.lineTo(-2.5, -13.8)
        p.lineTo(6.9, -13.8)
        p.lineTo(6.9, -6.7)
        p.lineTo(14.5, -6.7)
        addInstr(PLIN, p)
        p = Path2D.Double()
        p.moveTo(9.7, 2.3)
        p.lineTo(9.7, 10.3)
        p.lineTo(-4.1, 10.3)
        p.lineTo(-4.1, 2.3)
        p.closePath()
        addInstr(PGON, p)
        p = Path2D.Double()
        p.moveTo(14.1, -10.6)
        p.lineTo(23.1, -6.7)
        p.lineTo(14.1, -2.8)
        p.closePath()
        addInstr(PGON, p)
    }

    val SailingClub = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xa30075))
        addInstr(LINE, Line2D.Double(-5.0, 20.0, -5.0, -20.0))
        val p = Path2D.Double()
        p.moveTo(-5.0, 0.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(-5.0, -20.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val Shower = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xa30075))
        addInstr(LINE, Line2D.Double(-4.8, -24.5, 6.2, -13.5))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-18.1, -17.9, -6.1, -21.3))
        addInstr(LINE, Line2D.Double(-13.9, -10.2, -3.9, -17.7))
        addInstr(LINE, Line2D.Double(-7.8, -4.4, -0.5, -14.3))
        addInstr(LINE, Line2D.Double(-0.2, -0.2, 3.1, -12.1))
        val p = Path2D.Double()
        p.moveTo(11.1, 24.6)
        p.lineTo(11.1, -16.0)
        p.curveTo(11.1, -22.7, 3.4, -23.6, 0.8, -19.3)
        addInstr(PLIN, p)
    }

    val Slipway = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xa30075))
        var p = Path2D.Double()
        p.moveTo(-24.8, 0.1)
        p.lineTo(-24.8, 18.0)
        p.curveTo(-21.2, 18.0, -22.2, 16.7, -18.6, 16.7)
        p.curveTo(-15.0, 16.7, -16.0, 18.0, -12.4, 18.0)
        p.curveTo(-8.8, 18.0, -9.8, 16.7, -6.2, 16.7)
        p.curveTo(-2.6, 16.7, -3.6, 18.0, 0.0, 18.0)
        p.curveTo(3.6, 18.0, 2.6, 16.7, 6.2, 16.7)
        p.curveTo(9.8, 16.7, 8.8, 18.0, 12.4, 18.0)
        p.curveTo(16.0, 18.0, 15.0, 16.7, 18.6, 16.7)
        p.curveTo(22.2, 16.7, 21.2, 18.0, 24.8, 18.0)
        p.lineTo(24.8, 13.6)
        p.closePath()
        addInstr(PGON, p)
        addInstr(ELPS, Ellipse2D.Double(-1.65, -1.9, 8.0, 8.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(LINE, Line2D.Double(-24.5, -8.3, -3.1, -2.4))
        addInstr(LINE, Line2D.Double(9.3, 1.1, 22.2, 4.6))
        p = Path2D.Double()
        p.moveTo(22.9, 0.6)
        p.lineTo(25.0, -7.4)
        p.lineTo(-5.1, -15.8)
        p.lineTo(0.3, -19.6)
        p.lineTo(-1.6, -20.1)
        p.lineTo(-7.2, -16.2)
        p.lineTo(-17.1, -18.9)
        p.quadTo(-16.8, -11.4, -7.7, -7.7)
        p.closePath()
        addInstr(PGON, p)
    }

    val Toilet = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(SYMB, SubSymbol(Facility, 1.0, 0.0, 0.0, null, null))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xa30075))
        addInstr(LINE, Line2D.Double(0.0, 20.0, 0.0, -20.0))
        addInstr(RSHP, Ellipse2D.Double(-18.5, -22.5, 7.4, 7.4))
        addInstr(RSHP, Ellipse2D.Double(11.0, -22.5, 7.4, 7.4))
        var p = Path2D.Double()
        p.moveTo(-9.8, -12.2)
        p.lineTo(-4.8, 2.7)
        p.lineTo(-7.3, 3.9)
        p.lineTo(-10.6, -7.0)
        p.lineTo(-11.7, -6.4)
        p.lineTo(-7.6, 9.0)
        p.lineTo(-11.3, 9.0)
        p.lineTo(-11.6, 22.1)
        p.lineTo(-13.9, 22.1)
        p.lineTo(-14.2, 9.0)
        p.lineTo(-15.8, 9.0)
        p.lineTo(-16.2, 22.1)
        p.lineTo(-18.4, 22.1)
        p.lineTo(-18.8, 9.0)
        p.lineTo(-22.3, 9.0)
        p.lineTo(-18.2, -6.4)
        p.lineTo(-19.1, -7.0)
        p.lineTo(-22.9, 3.9)
        p.lineTo(-25.1, 2.7)
        p.lineTo(-19.9, -12.2)
        p.closePath()
        addInstr(PGON, p)
        p = Path2D.Double()
        p.moveTo(19.2, -12.2)
        p.lineTo(22.3, -10.1)
        p.lineTo(22.3, 4.4)
        p.lineTo(20.2, 4.4)
        p.lineTo(20.2, -7.3)
        p.lineTo(18.3, -7.3)
        p.lineTo(18.3, 22.1)
        p.lineTo(15.8, 22.1)
        p.lineTo(15.8, 4.6)
        p.lineTo(13.8, 4.6)
        p.lineTo(13.4, 22.1)
        p.lineTo(11.0, 22.1)
        p.lineTo(11.0, -7.3)
        p.lineTo(9.5, -7.3)
        p.lineTo(9.5, 4.4)
        p.lineTo(6.8, 4.4)
        p.lineTo(6.8, -10.1)
        p.lineTo(9.4, -12.2)
        p.closePath()
        addInstr(PGON, p)
    }

    val VisitorBerth = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0))
        addInstr(FILL, Color(0xa30075))
        addInstr(RSHP, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0))
        addInstr(FILL, white)
        val p = Path2D.Double()
        p.moveTo(7.9, -13.6)
        p.lineTo(14.0, -13.6)
        p.lineTo(3.4, 13.6)
        p.lineTo(-3.4, 13.6)
        p.lineTo(-14.0, -13.6)
        p.lineTo(-7.9, -13.6)
        p.lineTo(0.0, 8.7)
        p.closePath()
        addInstr(PGON, p)
    }

    val VisitorMooring = Symbol().apply {
        addInstr(FILL, Color(0xa30075))
        var p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.curveTo(-32.0, -21.0, -14.0, -45.5, 12.7, -37.9)
        p.curveTo(27.5, -33.8, 37.8, -15.5, 32.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        addInstr(PGON, p)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
        addInstr(LINE, Line2D.Double(-33.0, 0.0, -10.0, 0.0))
        addInstr(LINE, Line2D.Double(10.0, 0.0, 40.0, 0.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(ELPS, Ellipse2D.Double(6.5, -49.5, 12.0, 12.0))
        addInstr(FILL, white)
        p = Path2D.Double()
        p.moveTo(8.3, -32.8)
        p.lineTo(12.5, -32.8)
        p.lineTo(5.4, -12.9)
        p.lineTo(1.0, -12.9)
        p.lineTo(-6.1, -32.8)
        p.lineTo(-1.9, -32.8)
        p.lineTo(3.2, -18.1)
        p.closePath()
        addInstr(PGON, p)
    }

    val Cats = mapOf(
        CatSCF.SCF_BHST to Boatlift,
        CatSCF.SCF_BTYD to Boatyard,
        CatSCF.SCF_CHDR to Chandler,
        CatSCF.SCF_FUEL to Fuel,
        CatSCF.SCF_LAUN to Laundrette,
        CatSCF.SCF_PMPO to PumpOut,
        CatSCF.SCF_CLUB to SailingClub,
        CatSCF.SCF_SHWR to Shower,
        CatSCF.SCF_SLPW to Slipway,
        CatSCF.SCF_WC to Toilet,
        CatSCF.SCF_VBTH to VisitorBerth,
        CatSCF.SCF_VMOR to VisitorMooring,
    )
}
