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

    val Anchor = Symbol()
    init {
        Anchor.add(Instr(Form.BBOX, Rectangle2D.Double(-60.0, -60.0, 120.0, 120.0)))
        Anchor.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Anchor.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -59.0, 20.0, 20.0)))
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
        Anchor.add(Instr(Form.PGON, p))
    }

    val Yacht = Symbol()

    init {
        Yacht.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
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
        Yacht.add(Instr(Form.PGON, p))
    }

    val Anchorage = Symbol()

    init {
        Anchorage.add(Instr(Form.SYMB,SubSymbol(Anchor, 0.67, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val Bollard = Symbol()

    init {
        Bollard.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Bollard.add(Instr(Form.FILL, Color.white))
        val s = Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)
        Bollard.add(Instr(Form.RSHP, s))
        Bollard.add(Instr(Form.FILL, Color.black))
        Bollard.add(Instr(Form.ELPS, s))
    }

    val CallPoint1 = Symbol()

    init {
        CallPoint1.add(Instr(Form.BBOX, Rectangle2D.Double(-50.0, -50.0, 100.0, 100.0)))
        CallPoint1.add(Instr(Form.STRK, BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        CallPoint1.add(Instr(Form.FILL, Symbols.Msymb))
        CallPoint1.add(Instr(Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        val p = Path2D.Double()
        p.moveTo(-16.0, -20.0)
        p.lineTo(0.0, -50.0)
        p.lineTo(16.0, -20.0)
        CallPoint1.add(Instr(Form.PLIN, p))
    }

    val CallPoint2 = Symbol()

    init {
        CallPoint2.add(Instr(Form.BBOX, Rectangle2D.Double(-50.0, -50.0, 100.0, 100.0)))
        CallPoint2.add(Instr(Form.SYMB, SubSymbol(CallPoint1, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-16.0, 20.0)
        p.lineTo(0.0, 50.0)
        p.lineTo(16.0, 20.0)
        CallPoint2.add(Instr(Form.PLIN, p))
    }

    val ContainerCrane = Symbol()

    init {
        ContainerCrane.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ContainerCrane.add(Instr(Form.RSHP, Rectangle2D.Double(-15.0, -65.0, 30.0, 100.0)))
        ContainerCrane.add(Instr(Form.RECT, Rectangle2D.Double(-40.0, -12.5, 80.0, 25.0)))
    }

    val Customs = Symbol()

    init {
        Customs.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Customs.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Customs.add(Instr(Form.ELPS, Ellipse2D.Double(-28.0, -28.0, 56.0, 56.0)))
        Customs.add(Instr(Form.LINE, Line2D.Double(-25.0, 5.0, 25.0, 5.0)))
        Customs.add(Instr(Form.LINE, Line2D.Double(-25.0, -5.0, 25.0, -5.0)))
    }

    val DeviationDolphin = Symbol()

    init {
        DeviationDolphin.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-30.0, 0.0)
        p.lineTo(30.0, 0.0)
        p.moveTo(0.0, 0.0)
        p.lineTo(0.0, -40.0)
        p.moveTo(-20.0, 0.0)
        p.lineTo(-15.0, -32.0)
        p.lineTo(15.0, -32.0)
        p.lineTo(20.0, 0.0)
        DeviationDolphin.add(Instr(Form.PLIN, p))
    }

    val DistanceI = Symbol()

    init {
        DistanceI.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        DistanceI.add(Instr(Form.ELPS, Ellipse2D.Double(-11.0, -11.0, 22.0, 22.0)))
    }

    val DistanceU = Symbol()

    init {
        DistanceU.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        DistanceU.add(Instr(Form.FILL, Symbols.Msymb))
        DistanceU.add(Instr(Form.ELPS, Ellipse2D.Double(-11.0, -11.0, 22.0, 22.0)))
    }

    val Dolphin = Symbol()

    init {
        Dolphin.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Dolphin.add(Instr(Form.FILL, Color(0xffd400)))
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
        Dolphin.add(Instr(Form.PGON, p))
        Dolphin.add(Instr(Form.FILL, Color.black))
        Dolphin.add(Instr(Form.PLIN, p))
    }

    val Explosives = Symbol()

    init {
        Explosives.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Explosives.add(Instr(Form.RSHP, Ellipse2D.Double(-5.0, 25.0, 10.0, 10.0)))
        Explosives.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
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
        Explosives.add(Instr(Form.PLIN, p))
    }


    val Fishing = Symbol()

    init {
        Fishing.add(Instr(Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Fishing.add(Instr(Form.FILL, Symbols.Msymb))
        Fishing.add(Instr(Form.EARC, Arc2D.Double(-50.0, -50.0, 100.0, 100.0, 15.0, 140.0, Arc2D.OPEN)))
        Fishing.add(Instr(Form.EARC, Arc2D.Double(-50.0, -50.0, 100.0, 100.0, -15.0, -140.0, Arc2D.OPEN)))
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
        Fishing.add(Instr(Form.PGON, p))
    }


    val Harbour = Symbol()

    init {
        Harbour.add(Instr(Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Harbour.add(Instr(Form.FILL, Symbols.Msymb))
        Harbour.add(Instr(Form.ELPS, Ellipse2D.Double(-50.0, -50.0, 100.0, 100.0)))
        Harbour.add(Instr(Form.SYMB, SubSymbol(Anchor, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val HarbourMaster = Symbol()

    init {
        HarbourMaster.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        HarbourMaster.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        HarbourMaster.add(Instr(Form.ELPS, Ellipse2D.Double(-24.0, -28.0, 48.0, 56.0)))
        HarbourMaster.add(Instr(Form.SYMB, SubSymbol(Anchor, 0.4, 0.0, 0.0, null, null)))
    }

    val Hospital = Symbol()

    init {
        Hospital.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Hospital.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Hospital.add(Instr(Form.ELPS, Ellipse2D.Double(-28.0, -28.0, 56.0, 56.0)))
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
        Hospital.add(Instr(Form.PLIN, p))
    }

    val LandingSteps = Symbol()

    init {
        LandingSteps.add(Instr(Form.FILL, Symbols.Msymb))
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
        LandingSteps.add(Instr(Form.PGON, p))
    }

    val Marina = Symbol()

    init {
        Marina.add(Instr(Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Marina.add(Instr(Form.FILL, Symbols.Msymb))
        Marina.add(Instr(Form.EARC, Arc2D.Double(-50.0, -50.0, 100.0, 100.0, 215.0, -250.0, Arc2D.OPEN)))
        Marina.add(Instr(Form.SYMB, SubSymbol(Yacht, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val MarinaNF = Symbol()

    init {
        MarinaNF.add(Instr(Form.SYMB,SubSymbol(Yacht, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)))
    }

    val Pilot = Symbol()

    init {
        Pilot.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Pilot.add(Instr(Form.FILL, Color(0xd400d4)))
        val p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.lineTo(0.0, -56.0)
        p.lineTo(15.0, 0.0)
        p.lineTo(0.0, 56.0)
        p.closePath()
        Pilot.add(Instr(Form.PGON, p))
        Pilot.add(Instr(Form.ELPS, Ellipse2D.Double(-58.0, -58.0, 116.0, 116.0)))
    }

    val PortCrane = Symbol()

    init {
        PortCrane.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        PortCrane.add(Instr(Form.EARC, Arc2D.Double(-36.0, -36.0, 72.0, 72.0, 70.0, -320.0, Arc2D.OPEN)))
        PortCrane.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -60.0)))
    }

    val Post = Symbol()

    init {
        Post.add(Instr(Form.RSHP, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
    }

    val Rescue = Symbol()

    init {
        Rescue.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -50.0, 40.0, 100.0)))
        Rescue.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-11.0, 0.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(11.0, 0.0)
        p.lineTo(0.0, 43.0)
        p.closePath()
        Rescue.add(Instr(Form.PGON, p))
        Rescue.add(Instr(Form.LINE, Line2D.Double(-15.0, 0.0, 15.0, 0.0)))
    }

    val SignalStation = Symbol()

    init {
        SignalStation.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        SignalStation.add(Instr(Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        SignalStation.add(Instr(Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    val TideGauge = Symbol()

    init {
        TideGauge.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TideGauge.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        TideGauge.add(Instr(Form.LINE, Line2D.Double(-10.0, 0.0, -30.0, 0.0)))
        TideGauge.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 30.0, 0.0)))
        TideGauge.add(Instr(Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -80.0)))
        TideGauge.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TideGauge.add(Instr(Form.LINE, Line2D.Double(-15.0, -25.0, 15.0, -25.0)))
        TideGauge.add(Instr(Form.LINE, Line2D.Double(-25.0, -45.0, 25.0, -45.0)))
        TideGauge.add(Instr(Form.LINE, Line2D.Double(-15.0, -65.0, 15.0, -65.0)))
    }
}