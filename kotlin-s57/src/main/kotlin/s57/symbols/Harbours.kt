// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.symbols.Symbols.Form
import s57.symbols.Symbols.Instr
import s57.symbols.Symbols.SubSymbol
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.*

/**
 * @author Malcolm Herring
 */
object Harbours {

    val Anchor = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-60.0, -60.0, 120.0, 120.0)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -59.0, 20.0, 20.0)))
        val p = Path2D.Double()
        p.moveTo(23.0, -40.0)
        p.lineTo(23.0, -30.0)
        p.lineTo(6.0, -30.0)
        p.lineTo(7.0, 31.0)
        p.quadTo(21.0, 29.0, 31.0, 22.0)
        p.lineTo(27.0, 18.0)
        p.lineTo(52.0, 0.0)
        p.lineTo(45.0, 35.0)
        p.lineTo(37.0, 28.0)
        p.quadTo(25.0, 39.0, 7.0, 43.0)
        p.lineTo(6.0, 51.0)
        p.lineTo(-6.0, 51.0)
        p.lineTo(-7.0, 43.0)
        p.quadTo(-25.0, 39.0, -37.0, 28.0)
        p.lineTo(-45.0, 35.0)
        p.lineTo(-52.0, 0.0)
        p.lineTo(-27.0, 18.0)
        p.lineTo(-31.0, 22.0)
        p.quadTo(-21.0, 29.0, -7.0, 31.0)
        p.lineTo(-6.0, -30.0)
        p.lineTo(-23.0, -30.0)
        p.lineTo(-23.0, -40.0)
        p.closePath()
        add(Instr(Form.PGON, p))
    }

    val Yacht = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-65.0, 50.0)
        p.curveTo(-36.0, 97.0, 36.0, 97.0, 65.0, 50.0)
        p.lineTo(3.0, 50.0)
        p.lineTo(3.0, 40.0)
        p.lineTo(55.0, 30.0)
        p.curveTo(32.0, 4.0, 25.0, -15.0, 26.0, -52.0)
        p.lineTo(1.5, -40.0)
        p.lineTo(1.0, -64.0)
        p.lineTo(-2.0, -64.0)
        p.lineTo(-4.0, 50.0)
        p.closePath()
        p.moveTo(-50.0, 45.0)
        p.curveTo(-55.0, 3.0, -37.0, -28.5, -7.0, -46.0)
        p.curveTo(-28.0, -15.0, -26.0, 11.0, -20.5, 30.0)
        p.closePath()
        add(Instr(Form.PGON, p))
    }

    val Anchorage = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Anchor, 0.67, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val Bollard = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Color.white))
        val s = Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)
        add(Instr(Form.RSHP, s))
        add(Instr(Form.FILL, Color.black))
        add(Instr(Form.ELPS, s))
    }

    val CallPoint1 = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-50.0, -50.0, 100.0, 100.0)))
        add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Symbols.Msymb))
        add(Instr(Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        val p = Path2D.Double()
        p.moveTo(-16.0, -20.0)
        p.lineTo(0.0, -50.0)
        p.lineTo(16.0, -20.0)
        add(Instr(Form.PLIN, p))
    }

    val CallPoint2 = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-50.0, -50.0, 100.0, 100.0)))
        add(Instr(Form.SYMB, SubSymbol(CallPoint1, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-16.0, 20.0)
        p.lineTo(0.0, 50.0)
        p.lineTo(16.0, 20.0)
        add(Instr(Form.PLIN, p))
    }

    val ContainerCrane = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.RSHP, Rectangle2D.Double(-15.0, -65.0, 30.0, 100.0)))
        add(Instr(Form.RECT, Rectangle2D.Double(-40.0, -12.5, 80.0, 25.0)))
    }

    val Customs = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-28.0, -28.0, 56.0, 56.0)))
        add(Instr(Form.LINE, Line2D.Double(-25.0, 5.0, 25.0, 5.0)))
        add(Instr(Form.LINE, Line2D.Double(-25.0, -5.0, 25.0, -5.0)))
    }

    val DeviationDolphin = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-30.0, 0.0)
        p.lineTo(30.0, 0.0)
        p.moveTo(0.0, 0.0)
        p.lineTo(0.0, -40.0)
        p.moveTo(-20.0, 0.0)
        p.lineTo(-15.0, -32.0)
        p.lineTo(15.0, -32.0)
        p.lineTo(20.0, 0.0)
        add(Instr(Form.PLIN, p))
    }

    val DistanceI = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-11.0, -11.0, 22.0, 22.0)))
    }

    val DistanceU = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Symbols.Msymb))
        add(Instr(Form.ELPS, Ellipse2D.Double(-11.0, -11.0, 22.0, 22.0)))
    }

    val Dolphin = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Color(0xffd400)))
        val p = Path2D.Double()
        p.moveTo(3.8, -9.2)
        p.lineTo(9.2, -3.8)
        p.lineTo(9.2, 3.8)
        p.lineTo(3.8, 9.2)
        p.lineTo(-3.8, 9.2)
        p.lineTo(-9.2, 3.8)
        p.lineTo(-9.2, -3.8)
        p.lineTo(-3.8, -9.2)
        p.closePath()
        add(Instr(Form.PGON, p))
        add(Instr(Form.FILL, Color.black))
        add(Instr(Form.PLIN, p))
    }

    val Explosives = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(Form.RSHP, Ellipse2D.Double(-5.0, 25.0, 10.0, 10.0)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        val p = Path2D.Double()
        p.moveTo(-10.0, 20.0)
        p.lineTo(-13.0, 17.0)
        p.lineTo(-13.0, 8.0)
        p.moveTo(0.0, 10.0)
        p.lineTo(0.0, 0.0)
        p.lineTo(-8.0, -10.0)
        p.moveTo(10.0, 17.0)
        p.lineTo(18.0, -10.0)
        p.lineTo(10.0, -20.0)
        add(Instr(Form.PLIN, p))
    }

    val Fishing = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Symbols.Msymb))
        add(Instr(Form.EARC, Arc2D.Double(-50.0, -50.0, 100.0, 100.0, 15.0, 140.0, Arc2D.OPEN)))
        add(Instr(Form.EARC, Arc2D.Double(-50.0, -50.0, 100.0, 100.0, -15.0, -140.0, Arc2D.OPEN)))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-24.0, 3.0)
        p.curveTo(12.0, 24.0, 30.0, 15.0, 48.0, 0.0)
        p.curveTo(30.0, -15.0, 12.0, -24.0, -24.0, -3.0)
        p.lineTo(-45.0, -15.0)
        p.quadTo(-48.0, 0.0, -45.0, 15.0)
        p.closePath()
        p.moveTo(25.0, 0.0)
        p.curveTo(25.0, 6.0, 34.0, 6.0, 34.0, 0.0)
        p.curveTo(34.0, -6.0, 25.0, -6.0, 25.0, 0.0)
        p.closePath()
        add(Instr(Form.PGON, p))
    }

    val Harbour = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Symbols.Msymb))
        add(Instr(Form.ELPS, Ellipse2D.Double(-50.0, -50.0, 100.0, 100.0)))
        add(Instr(Form.SYMB, SubSymbol(Anchor, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val HarbourMaster = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-24.0, -28.0, 48.0, 56.0)))
        add(Instr(Form.SYMB, SubSymbol(Anchor, 0.4, 0.0, 0.0, null, null)))
    }

    val Hospital = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-28.0, -28.0, 56.0, 56.0)))
        val p = Path2D.Double()
        p.moveTo(-26.0, -5.0)
        p.lineTo(-5.0, -5.0)
        p.lineTo(-5.0, -25.0)
        p.moveTo(5.0, -25.0)
        p.lineTo(5.0, -5.0)
        p.lineTo(25.0, -5.0)
        p.moveTo(-25.0, 5.0)
        p.lineTo(-5.0, 5.0)
        p.lineTo(-5.0, 25.0)
        p.moveTo(5.0, 25.0)
        p.lineTo(5.0, 5.0)
        p.lineTo(25.0, 5.0)
        add(Instr(Form.PLIN, p))
    }

    val LandingSteps = Symbol().apply {
        add(Instr(Form.FILL, Symbols.Msymb))
        val p = Path2D.Double()
        p.moveTo(-20.0, -10.0)
        p.lineTo(10.0, 20.0)
        p.lineTo(20.0, 20.0)
        p.lineTo(20.0, 10.0)
        p.lineTo(10.0, 10.0)
        p.lineTo(10.0, 0.0)
        p.lineTo(0.0, 0.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(-10.0, -10.0)
        p.lineTo(-10.0, -20.0)
        p.lineTo(-20.0, -20.0)
        p.closePath()
        add(Instr(Form.PGON, p))
    }

    val Marina = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Symbols.Msymb))
        add(Instr(Form.EARC, Arc2D.Double(-50.0, -50.0, 100.0, 100.0, 215.0, -250.0, Arc2D.OPEN)))
        add(Instr(Form.SYMB, SubSymbol(Yacht, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val MarinaNF = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Yacht, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val Pilot = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.FILL, Color(0xd400d4)))
        val p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.lineTo(0.0, -56.0)
        p.lineTo(15.0, 0.0)
        p.lineTo(0.0, 56.0)
        p.closePath()
        add(Instr(Form.PGON, p))
        add(Instr(Form.ELPS, Ellipse2D.Double(-58.0, -58.0, 116.0, 116.0)))
    }

    val PortCrane = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.EARC, Arc2D.Double(-36.0, -36.0, 72.0, 72.0, 70.0, -320.0, Arc2D.OPEN)))
        add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -60.0)))
    }

    val Post = Symbol().apply {
        add(Instr(Form.RSHP, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
    }

    val Rescue = Symbol().apply {
        add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -50.0, 40.0, 100.0)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-11.0, 0.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(11.0, 0.0)
        p.lineTo(0.0, 43.0)
        p.closePath()
        add(Instr(Form.PGON, p))
        add(Instr(Form.LINE, Line2D.Double(-15.0, 0.0, 15.0, 0.0)))
    }

    val SignalStation = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        add(Instr(Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    val TideGauge = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        add(Instr(Form.LINE, Line2D.Double(-10.0, 0.0, -30.0, 0.0)))
        add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 30.0, 0.0)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -80.0)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(-15.0, -25.0, 15.0, -25.0)))
        add(Instr(Form.LINE, Line2D.Double(-25.0, -45.0, 25.0, -45.0)))
        add(Instr(Form.LINE, Line2D.Double(-15.0, -65.0, 15.0, -65.0)))
    }
}
