// License: GPL. For details, see LICENSE file.
package s57.symbols

import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.*

/**
 * @author Malcolm Herring
 */
object Harbours {
    // CHECKSTYLE.OFF: LineLength
    @JvmField
    val Anchor = Symbols.Symbol()

    init {
        Anchor.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-60.0, -60.0, 120.0, 120.0)))
        Anchor.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Anchor.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -59.0, 20.0, 20.0)))
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
        Anchor.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    val Yacht = Symbols.Symbol()

    init {
        Yacht.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
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
        Yacht.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val Anchorage = Symbols.Symbol()

    init {
        Anchorage.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Anchor, 0.67, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)
            )
        )
    }

    @JvmField
    val Bollard = Symbols.Symbol()

    init {
        Bollard.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Bollard.add(Symbols.Instr(Symbols.Form.FILL, Color.white))
        val s = Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)
        Bollard.add(Symbols.Instr(Symbols.Form.RSHP, s))
        Bollard.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Bollard.add(Symbols.Instr(Symbols.Form.ELPS, s))
    }

    @JvmField
    val CallPoint1 = Symbols.Symbol()

    init {
        CallPoint1.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-50.0, -50.0, 100.0, 100.0)))
        CallPoint1.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        CallPoint1.add(Symbols.Instr(Symbols.Form.FILL, Symbols.Msymb))
        CallPoint1.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        val p = Path2D.Double()
        p.moveTo(-16.0, -20.0)
        p.lineTo(0.0, -50.0)
        p.lineTo(16.0, -20.0)
        CallPoint1.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val CallPoint2 = Symbols.Symbol()

    init {
        CallPoint2.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-50.0, -50.0, 100.0, 100.0)))
        CallPoint2.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(CallPoint1, 1.0, 0.0, 0.0, null, null)))
        val p = Path2D.Double()
        p.moveTo(-16.0, 20.0)
        p.lineTo(0.0, 50.0)
        p.lineTo(16.0, 20.0)
        CallPoint2.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val ContainerCrane = Symbols.Symbol()

    init {
        ContainerCrane.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        ContainerCrane.add(Symbols.Instr(Symbols.Form.RSHP, Rectangle2D.Double(-15.0, -65.0, 30.0, 100.0)))
        ContainerCrane.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-40.0, -12.5, 80.0, 25.0)))
    }

    val Customs = Symbols.Symbol()

    init {
        Customs.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Customs.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Customs.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-28.0, -28.0, 56.0, 56.0)))
        Customs.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, 5.0, 25.0, 5.0)))
        Customs.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, -5.0, 25.0, -5.0)))
    }

    @JvmField
    val DeviationDolphin = Symbols.Symbol()

    init {
        DeviationDolphin.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        val p = Path2D.Double()
        p.moveTo(-30.0, 0.0)
        p.lineTo(30.0, 0.0)
        p.moveTo(0.0, 0.0)
        p.lineTo(0.0, -40.0)
        p.moveTo(-20.0, 0.0)
        p.lineTo(-15.0, -32.0)
        p.lineTo(15.0, -32.0)
        p.lineTo(20.0, 0.0)
        DeviationDolphin.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val DistanceI = Symbols.Symbol()

    init {
        DistanceI.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        DistanceI.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-11.0, -11.0, 22.0, 22.0)))
    }

    @JvmField
    val DistanceU = Symbols.Symbol()

    init {
        DistanceU.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        DistanceU.add(Symbols.Instr(Symbols.Form.FILL, Symbols.Msymb))
        DistanceU.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-11.0, -11.0, 22.0, 22.0)))
    }

    @JvmField
    val Dolphin = Symbols.Symbol()

    init {
        Dolphin.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Dolphin.add(Symbols.Instr(Symbols.Form.FILL, Color(0xffd400)))
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
        Dolphin.add(Symbols.Instr(Symbols.Form.PGON, p))
        Dolphin.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Dolphin.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val Explosives = Symbols.Symbol()

    init {
        Explosives.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Explosives.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-5.0, 25.0, 10.0, 10.0)))
        Explosives.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
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
        Explosives.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val Fishing = Symbols.Symbol()

    init {
        Fishing.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Fishing.add(Symbols.Instr(Symbols.Form.FILL, Symbols.Msymb))
        Fishing.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-50.0, -50.0, 100.0, 100.0, 15.0, 140.0, Arc2D.OPEN)))
        Fishing.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-50.0, -50.0, 100.0, 100.0, -15.0, -140.0, Arc2D.OPEN)
            )
        )
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
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
        Fishing.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val Harbour = Symbols.Symbol()

    init {
        Harbour.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Harbour.add(Symbols.Instr(Symbols.Form.FILL, Symbols.Msymb))
        Harbour.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-50.0, -50.0, 100.0, 100.0)))
        Harbour.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Anchor, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)
            )
        )
    }

    val HarbourMaster = Symbols.Symbol()

    init {
        HarbourMaster.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        HarbourMaster.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        HarbourMaster.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-24.0, -28.0, 48.0, 56.0)))
        HarbourMaster.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Anchor, 0.4, 0.0, 0.0, null, null)))
    }

    @JvmField
    val Hospital = Symbols.Symbol()

    init {
        Hospital.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Hospital.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Hospital.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-28.0, -28.0, 56.0, 56.0)))
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
        Hospital.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val LandingSteps = Symbols.Symbol()

    init {
        LandingSteps.add(Symbols.Instr(Symbols.Form.FILL, Symbols.Msymb))
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
        LandingSteps.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val Marina = Symbols.Symbol()

    init {
        Marina.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Marina.add(Symbols.Instr(Symbols.Form.FILL, Symbols.Msymb))
        Marina.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-50.0, -50.0, 100.0, 100.0, 215.0, -250.0, Arc2D.OPEN)
            )
        )
        Marina.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Yacht, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)
            )
        )
    }

    @JvmField
    val MarinaNF = Symbols.Symbol()

    init {
        MarinaNF.add(
            Symbols.Instr(
                Symbols.Form.SYMB,
                Symbols.SubSymbol(Yacht, 0.6, 0.0, 0.0, Symbols.Scheme(Symbols.Msymb), null)
            )
        )
    }

    @JvmField
    val Pilot = Symbols.Symbol()

    init {
        Pilot.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Pilot.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd400d4)))
        val p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.lineTo(0.0, -56.0)
        p.lineTo(15.0, 0.0)
        p.lineTo(0.0, 56.0)
        p.closePath()
        Pilot.add(Symbols.Instr(Symbols.Form.PGON, p))
        Pilot.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-58.0, -58.0, 116.0, 116.0)))
    }

    @JvmField
    val PortCrane = Symbols.Symbol()

    init {
        PortCrane.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        PortCrane.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-36.0, -36.0, 72.0, 72.0, 70.0, -320.0, Arc2D.OPEN)
            )
        )
        PortCrane.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -60.0)))
    }

    @JvmField
    val Post = Symbols.Symbol()

    init {
        Post.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
    }

    @JvmField
    val Rescue = Symbols.Symbol()

    init {
        Rescue.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -50.0, 40.0, 100.0)))
        Rescue.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-11.0, 0.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(11.0, 0.0)
        p.lineTo(0.0, 43.0)
        p.closePath()
        Rescue.add(Symbols.Instr(Symbols.Form.PGON, p))
        Rescue.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, 0.0, 15.0, 0.0)))
    }

    @JvmField
    val SignalStation = Symbols.Symbol()

    init {
        SignalStation.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        SignalStation.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        SignalStation.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    @JvmField
    val TideGauge = Symbols.Symbol()

    init {
        TideGauge.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TideGauge.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        TideGauge.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-10.0, 0.0, -30.0, 0.0)))
        TideGauge.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(10.0, 0.0, 30.0, 0.0)))
        TideGauge.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -80.0)))
        TideGauge.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TideGauge.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, -25.0, 15.0, -25.0)))
        TideGauge.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, -45.0, 25.0, -45.0)))
        TideGauge.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-15.0, -65.0, 15.0, -65.0)))
    }
}