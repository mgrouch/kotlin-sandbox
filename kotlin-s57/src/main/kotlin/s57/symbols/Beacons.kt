// License: GPL. For details, see LICENSE file.
package s57.symbols


import s57.S57val.BcnSHP
import s57.symbols.Symbols.Form
import s57.symbols.Symbols.Instr
import s57.symbols.Symbols.Symbol
import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.*

/**
 * @author Malcolm Herring
 */
object Beacons {

    val Beacon = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        p.curveTo(6.0, -10.0, -6.0, -10.0, -6.0, -8.5)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -40.0)
        p.lineTo(6.0, -40.0)
        p.lineTo(6.0, -8.5)
        p.curveTo(6.0, -10.0, -6.0, -10.0, -6.0, -8.5)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -30.0)
        p.lineTo(-6.0, -50.0)
        p.lineTo(6.0, -50.0)
        p.lineTo(6.0, -30.0)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -40.0)
        p.lineTo(-6.0, -55.0)
        p.lineTo(6.0, -55.0)
        p.lineTo(6.0, -40.0)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-6.0, -25.0)
        p.lineTo(-6.0, -40.0)
        p.lineTo(6.0, -40.0)
        p.lineTo(6.0, -25.0)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        p.quadTo(3.0, -9.3, 0.0, -10.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Beacon.add(Instr(Form.COLR, colours))
        Beacon.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Beacon.add(Instr(Form.FILL, Color.black))
        Beacon.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Beacon.add(Instr(Form.LINE, Line2D.Double(-20.0, 0.0, -10.0, 0.0)))
        Beacon.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 20.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        Beacon.add(Instr(Form.PLIN, p))
    }

    val Cairn = Symbol()

    init {
        Cairn.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Cairn.add(Instr(Form.FILL, Color.black))
        Cairn.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Cairn.add(Instr(Form.LINE, Line2D.Double(-40.0, 0.0, -10.0, 0.0)))
        Cairn.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 40.0, 0.0)))
        Cairn.add(Instr(Form.ELPS, Ellipse2D.Double(3.0, -40.0, 40.0, 40.0)))
        Cairn.add(Instr(Form.ELPS, Ellipse2D.Double(-43.0, -40.0, 40.0, 40.0)))
        Cairn.add(Instr(Form.ELPS, Ellipse2D.Double(-18.0, -70.0, 36.0, 36.0)))
    }


    val FogSignal = Symbol()

    init {
        FogSignal.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        FogSignal.add(Instr(Form.FILL, Color.black))
        FogSignal.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        FogSignal.add(Instr(Form.STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        FogSignal.add(Instr(Form.FILL, Color(0xd400d4)))
        FogSignal.add(
            Instr(
                Form.EARC,
                Arc2D.Double(-120.0, -120.0, 240.0, 240.0, 190.0, 50.0, Arc2D.OPEN)
            )
        )
        FogSignal.add(
            Instr(
                Form.EARC,
                Arc2D.Double(-92.5, -92.5, 185.0, 185.0, 190.0, 50.0, Arc2D.OPEN)
            )
        )
        FogSignal.add(
            Instr(
                Form.EARC,
                Arc2D.Double(-65.0, -65.0, 130.0, 130.0, 190.0, 50.0, Arc2D.OPEN)
            )
        )
    }

    val Lattice = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-15.0, -70.0)
        p.lineTo(15.0, -70.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-17.5, -35.0)
        p.lineTo(17.5, -35.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-18.3, -23.3)
        p.lineTo(-16.7, -46.7)
        p.lineTo(16.7, -46.7)
        p.lineTo(18.3, -23.3)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-17.5, -35.0)
        p.lineTo(-16.25, -52.5)
        p.lineTo(16.25, -52.5)
        p.lineTo(17.5, -35.0)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-18.75, -17.5)
        p.lineTo(-17.5, -35.0)
        p.lineTo(17.5, -35.0)
        p.lineTo(18.75, -17.5)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(15.0, -70.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.quadTo(10.0, -10.0, 0.0, -10.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Lattice.add(Instr(Form.COLR, colours))
        Lattice.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Lattice.add(Instr(Form.FILL, Color.black))
        Lattice.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Lattice.add(Instr(Form.LINE, Line2D.Double(-30.0, 0.0, -10.0, 0.0)))
        Lattice.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 30.0, 0.0)))
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
        Lattice.add(Instr(Form.PLIN, p))
    }


    val LightFlare = Symbol()

    init {
        LightFlare.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -100.0, 40.0, 100.0)))
        LightFlare.add(Instr(Form.RSHP, Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0)))
        val p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(15.0, -95.0)
        p.curveTo(20.0, -123.0, -20.0, -123.0, -15.0, -95.0)
        p.closePath()
        LightFlare.add(Instr(Form.PGON, p))
    }


    val LightMajor = Symbol()

    init {
        LightMajor.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_NON_ZERO
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
        LightMajor.add(Instr(Form.PGON, p))
    }


    val LightMinor = Symbol()

    init {
        LightMinor.add(Instr(Form.FILL, Color.black))
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
        LightMinor.add(Instr(Form.PGON, p))
    }


    val PerchPort = Symbol()

    init {
        PerchPort.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        PerchPort.add(Instr(Form.FILL, Color.black))
        PerchPort.add(Instr(Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        PerchPort.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -40.0)))
        PerchPort.add(Instr(Form.LINE, Line2D.Double(25.0, -70.0, 0.0, -40.0)))
        PerchPort.add(Instr(Form.LINE, Line2D.Double(-25.0, -70.0, 0.0, -40.0)))
    }


    val PerchStarboard = Symbol()

    init {
        PerchStarboard.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)
            )
        )
        PerchStarboard.add(Instr(Form.FILL, Color.black))
        PerchStarboard.add(Instr(Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        PerchStarboard.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        PerchStarboard.add(Instr(Form.LINE, Line2D.Double(25.0, -40.0, 0.0, -68.7)))
        PerchStarboard.add(Instr(Form.LINE, Line2D.Double(-25.0, -40.0, 0.0, -68.7)))
    }


    val RadarStation = Symbol()

    init {
        RadarStation.add(
            Instr(
                Form.STRK,
                BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)
            )
        )
        RadarStation.add(Instr(Form.FILL, Color(0xd400d4)))
        RadarStation.add(Instr(Form.ELPS, Ellipse2D.Double(-125.0, -125.0, 250.0, 250.0)))
    }


    val Stake = Symbol()

    init {
        Stake.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Stake.add(Instr(Form.FILL, Color.black))
        Stake.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-2.0, 0.0)
        p.lineTo(-2.0, -70.0)
        p.lineTo(2.0, -70.0)
        p.lineTo(2.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-2.0, 0.0)
        p.lineTo(-2.0, -35.0)
        p.lineTo(2.0, -35.0)
        p.lineTo(2.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-2.0, -23.3)
        p.lineTo(-2.0, -46.7)
        p.lineTo(2.0, -46.7)
        p.lineTo(2.0, -23.3)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-2.0, -35.0)
        p.lineTo(-2.0, -52.5)
        p.lineTo(2.0, -52.5)
        p.lineTo(2.0, -35.0)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-2.0, -17.5)
        p.lineTo(-2.0, -35.0)
        p.lineTo(2.0, -35.0)
        p.lineTo(2.0, -17.5)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        Stake.add(Instr(Form.COLR, colours))
        Stake.add(Instr(Form.FILL, Color.black))
        Stake.add(Instr(Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
    }

    val Tower = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-20.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-22.5, -35.0)
        p.lineTo(22.5, -35.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-23.3, -23.3)
        p.lineTo(-21.7, -46.7)
        p.lineTo(21.7, -46.7)
        p.lineTo(23.3, -23.3)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-22.5, -35.0)
        p.lineTo(-21.0, -52.5)
        p.lineTo(21.0, -52.5)
        p.lineTo(22.5, -35.0)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-23.6, -17.5)
        p.lineTo(-22.5, -35.0)
        p.lineTo(22.5, -35.0)
        p.lineTo(23.6, -17.5)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.quadTo(10.0, -10.0, 0.0, -10.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Tower.add(Instr(Form.COLR, colours))
        Tower.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Tower.add(Instr(Form.FILL, Color.black))
        Tower.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Tower.add(Instr(Form.LINE, Line2D.Double(-35.0, 0.0, -10.0, 0.0)))
        Tower.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 35.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-20.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        Tower.add(Instr(Form.PLIN, p))
    }


    val WithyPort = Symbol()

    init {
        WithyPort.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        WithyPort.add(Instr(Form.FILL, Color.black))
        WithyPort.add(Instr(Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        WithyPort.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        WithyPort.add(Instr(Form.LINE, Line2D.Double(20.0, -60.0, 0.0, -50.0)))
        WithyPort.add(Instr(Form.LINE, Line2D.Double(-20.0, -60.0, 0.0, -50.0)))
        WithyPort.add(Instr(Form.LINE, Line2D.Double(30.0, -35.0, 0.0, -21.0)))
        WithyPort.add(Instr(Form.LINE, Line2D.Double(-30.0, -35.0, 0.0, -21.0)))
    }


    val WithyStarboard = Symbol()

    init {
        WithyStarboard.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)
            )
        )
        WithyStarboard.add(Instr(Form.FILL, Color.black))
        WithyStarboard.add(Instr(Form.LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0)))
        WithyStarboard.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0)))
        WithyStarboard.add(Instr(Form.LINE, Line2D.Double(20.0, -50.0, 0.0, -60.0)))
        WithyStarboard.add(Instr(Form.LINE, Line2D.Double(-20.0, -50.0, 0.0, -60.0)))
        WithyStarboard.add(Instr(Form.LINE, Line2D.Double(30.0, -21.0, 0.0, -35.0)))
        WithyStarboard.add(Instr(Form.LINE, Line2D.Double(-30.0, -21.0, 0.0, -35.0)))
    }


    val Shapes = mapOf(
        BcnSHP.BCN_UNKN to Beacon,
        BcnSHP.BCN_STAK to Stake,
        BcnSHP.BCN_TOWR to Tower,
        BcnSHP.BCN_LATT to Lattice,
        BcnSHP.BCN_PILE to Beacon,
        BcnSHP.BCN_POLE to Stake,
        BcnSHP.BCN_CARN to Cairn,
        BcnSHP.BCN_BUOY to Beacon,
        BcnSHP.BCN_POST to Stake,
        BcnSHP.BCN_PRCH to Stake,
    )
}