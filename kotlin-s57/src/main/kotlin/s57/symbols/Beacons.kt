// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.S57val
import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.*
import java.util.*

/**
 * @author Malcolm Herring
 */
object Beacons {
    // CHECKSTYLE.OFF: LineLength
    val Beacon = Symbols.Symbol()

    init {
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        p.curveTo(6.0, -10.0, -6.0, -10.0, -6.0, -8.5)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -40.0)
        p.lineTo(6.0, -40.0)
        p.lineTo(6.0, -8.5)
        p.curveTo(6.0, -10.0, -6.0, -10.0, -6.0, -8.5)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -30.0)
        p.lineTo(-6.0, -50.0)
        p.lineTo(6.0, -50.0)
        p.lineTo(6.0, -30.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -40.0)
        p.lineTo(-6.0, -55.0)
        p.lineTo(6.0, -55.0)
        p.lineTo(6.0, -40.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -25.0)
        p.lineTo(-6.0, -40.0)
        p.lineTo(6.0, -40.0)
        p.lineTo(6.0, -25.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        p.quadTo(3.0, -9.3, 0.0, -10.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        Beacon.add(Symbols.Instr(Symbols.Form.COLR, colours))
        Beacon.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Beacon.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Beacon.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Beacon.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, 0.0, -10.0, 0.0)))
        Beacon.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(10.0, 0.0, 20.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        Beacon.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val Cairn = Symbols.Symbol()

    init {
        Cairn.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Cairn.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Cairn.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Cairn.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-40.0, 0.0, -10.0, 0.0)))
        Cairn.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(10.0, 0.0, 40.0, 0.0)))
        Cairn.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(3.0, -40.0, 40.0, 40.0)))
        Cairn.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-43.0, -40.0, 40.0, 40.0)))
        Cairn.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-18.0, -70.0, 36.0, 36.0)))
    }

    @JvmField
    val FogSignal = Symbols.Symbol()

    init {
        FogSignal.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        FogSignal.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        FogSignal.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        FogSignal.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        FogSignal.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd400d4)))
        FogSignal.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-120.0, -120.0, 240.0, 240.0, 190.0, 50.0, Arc2D.OPEN)
            )
        )
        FogSignal.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-92.5, -92.5, 185.0, 185.0, 190.0, 50.0, Arc2D.OPEN)
            )
        )
        FogSignal.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-65.0, -65.0, 130.0, 130.0, 190.0, 50.0, Arc2D.OPEN)
            )
        )
    }

    val Lattice = Symbols.Symbol()

    init {
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-15.0, -70.0)
        p.lineTo(15.0, -70.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-17.5, -35.0)
        p.lineTo(17.5, -35.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-18.3, -23.3)
        p.lineTo(-16.7, -46.7)
        p.lineTo(16.7, -46.7)
        p.lineTo(18.3, -23.3)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-17.5, -35.0)
        p.lineTo(-16.25, -52.5)
        p.lineTo(16.25, -52.5)
        p.lineTo(17.5, -35.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-18.75, -17.5)
        p.lineTo(-17.5, -35.0)
        p.lineTo(17.5, -35.0)
        p.lineTo(18.75, -17.5)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(15.0, -70.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.quadTo(10.0, -10.0, 0.0, -10.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        Lattice.add(Symbols.Instr(Symbols.Form.COLR, colours))
        Lattice.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Lattice.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Lattice.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Lattice.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-30.0, 0.0, -10.0, 0.0)))
        Lattice.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(10.0, 0.0, 30.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-15.0, -70.0)
        p.lineTo(15.0, -70.0)
        p.lineTo(20.0, 0.0)
        p.moveTo(-19.0, -7.0)
        p.lineTo(17.5, -33.0)
        p.moveTo(19.0, -7.0)
        p.lineTo(-17.5, -33.0)
        p.moveTo(-15.0, -65.0)
        p.lineTo(18.0, -40.0)
        p.moveTo(15.0, -65.0)
        p.lineTo(-18.0, -40.0)
        Lattice.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val LightFlare = Symbols.Symbol()

    init {
        LightFlare.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -100.0, 40.0, 100.0)))
        LightFlare.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0)))
        val p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(15.0, -95.0)
        p.curveTo(20.0, -123.0, -20.0, -123.0, -15.0, -95.0)
        p.closePath()
        LightFlare.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val LightMajor = Symbols.Symbol()

    init {
        LightMajor.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_NON_ZERO)
        p.moveTo(0.0, -7.0)
        p.curveTo(-9.3, -6.5, -9.3, 6.5, 0.0, 7.0)
        p.curveTo(9.3, 6.5, 9.3, -6.5, 0.0, -7.0)
        p.closePath()
        p.moveTo(0.0, -35.5)
        p.lineTo(8.0, -11.2)
        p.lineTo(33.5, -11.2)
        p.lineTo(12.8, 4.0)
        p.lineTo(20.5, 28.5)
        p.lineTo(0.0, 13.0)
        p.lineTo(-20.5, 28.5)
        p.lineTo(-12.8, 4.0)
        p.lineTo(-33.5, -11.2)
        p.lineTo(-8.0, -11.2)
        p.closePath()
        LightMajor.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val LightMinor = Symbols.Symbol()

    init {
        LightMinor.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(0.0, -26.5)
        p.lineTo(6.0, -8.4)
        p.lineTo(25.1, -8.4)
        p.lineTo(9.6, 3.0)
        p.lineTo(15.4, 21.4)
        p.lineTo(0.0, 9.8)
        p.lineTo(-15.4, 21.4)
        p.lineTo(-9.6, 3.0)
        p.lineTo(-25.1, -8.4)
        p.lineTo(-6.0, -8.4)
        p.closePath()
        LightMinor.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val PerchPort = Symbols.Symbol()

    init {
        PerchPort.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        PerchPort.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        PerchPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        PerchPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -40.0)))
        PerchPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(25.0, -70.0, 0.0, -40.0)))
        PerchPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, -70.0, 0.0, -40.0)))
    }

    @JvmField
    val PerchStarboard = Symbols.Symbol()

    init {
        PerchStarboard.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)
            )
        )
        PerchStarboard.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        PerchStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        PerchStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        PerchStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(25.0, -40.0, 0.0, -68.7)))
        PerchStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, -40.0, 0.0, -68.7)))
    }

    @JvmField
    val RadarStation = Symbols.Symbol()

    init {
        RadarStation.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)
            )
        )
        RadarStation.add(Symbols.Instr(Symbols.Form.FILL, Color(0xd400d4)))
        RadarStation.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-125.0, -125.0, 250.0, 250.0)))
    }

    @JvmField
    val Stake = Symbols.Symbol()

    init {
        Stake.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Stake.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Stake.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-2.0, 0.0)
        p.lineTo(-2.0, -70.0)
        p.lineTo(2.0, -70.0)
        p.lineTo(2.0, 0.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-2.0, 0.0)
        p.lineTo(-2.0, -35.0)
        p.lineTo(2.0, -35.0)
        p.lineTo(2.0, 0.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-2.0, -23.3)
        p.lineTo(-2.0, -46.7)
        p.lineTo(2.0, -46.7)
        p.lineTo(2.0, -23.3)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-2.0, -35.0)
        p.lineTo(-2.0, -52.5)
        p.lineTo(2.0, -52.5)
        p.lineTo(2.0, -35.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-2.0, -17.5)
        p.lineTo(-2.0, -35.0)
        p.lineTo(2.0, -35.0)
        p.lineTo(2.0, -17.5)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H5, p))
        Stake.add(Symbols.Instr(Symbols.Form.COLR, colours))
        Stake.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Stake.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
    }

    val Tower = Symbols.Symbol()

    init {
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-20.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-22.5, -35.0)
        p.lineTo(22.5, -35.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-23.3, -23.3)
        p.lineTo(-21.7, -46.7)
        p.lineTo(21.7, -46.7)
        p.lineTo(23.3, -23.3)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-22.5, -35.0)
        p.lineTo(-21.0, -52.5)
        p.lineTo(21.0, -52.5)
        p.lineTo(22.5, -35.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-23.6, -17.5)
        p.lineTo(-22.5, -35.0)
        p.lineTo(22.5, -35.0)
        p.lineTo(23.6, -17.5)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.quadTo(10.0, -10.0, 0.0, -10.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        Tower.add(Symbols.Instr(Symbols.Form.COLR, colours))
        Tower.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Tower.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Tower.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Tower.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-35.0, 0.0, -10.0, 0.0)))
        Tower.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(10.0, 0.0, 35.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-20.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        Tower.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val WithyPort = Symbols.Symbol()

    init {
        WithyPort.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        WithyPort.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        WithyPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        WithyPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        WithyPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(20.0, -60.0, 0.0, -50.0)))
        WithyPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, -60.0, 0.0, -50.0)))
        WithyPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(30.0, -35.0, 0.0, -21.0)))
        WithyPort.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-30.0, -35.0, 0.0, -21.0)))
    }

    @JvmField
    val WithyStarboard = Symbols.Symbol()

    init {
        WithyStarboard.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)
            )
        )
        WithyStarboard.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        WithyStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        WithyStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        WithyStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(20.0, -50.0, 0.0, -60.0)))
        WithyStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, -50.0, 0.0, -60.0)))
        WithyStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(30.0, -21.0, 0.0, -35.0)))
        WithyStarboard.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-30.0, -21.0, 0.0, -35.0)))
    }

    @JvmField
    val Shapes = EnumMap<S57val.BcnSHP, Symbols.Symbol>(
        S57val.BcnSHP::class.java
    )

    init {
        Shapes[S57val.BcnSHP.BCN_UNKN] = Beacon
        Shapes[S57val.BcnSHP.BCN_STAK] = Stake
        Shapes[S57val.BcnSHP.BCN_TOWR] = Tower
        Shapes[S57val.BcnSHP.BCN_LATT] = Lattice
        Shapes[S57val.BcnSHP.BCN_PILE] = Beacon
        Shapes[S57val.BcnSHP.BCN_POLE] = Stake
        Shapes[S57val.BcnSHP.BCN_CARN] = Cairn
        Shapes[S57val.BcnSHP.BCN_BUOY] = Beacon
        Shapes[S57val.BcnSHP.BCN_POST] = Stake
        Shapes[S57val.BcnSHP.BCN_PRCH] = Stake
    }
}