// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.parser.S57val.BcnSHP
import s57.symbols.Symbols.Form.*
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Color.black
import java.awt.geom.*

/**
 * @author Malcolm Herring
 */
object Beacons {

    val Beacon = Symbol().apply {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        p.curveTo(6.0, -10.0, -6.0, -10.0, -6.0, -8.5)
        p.closePath()
        colours.addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -40.0)
        p.lineTo(6.0, -40.0)
        p.lineTo(6.0, -8.5)
        p.curveTo(6.0, -10.0, -6.0, -10.0, -6.0, -8.5)
        p.closePath()
        colours.addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-6.0, -30.0)
        p.lineTo(-6.0, -50.0)
        p.lineTo(6.0, -50.0)
        p.lineTo(6.0, -30.0)
        p.closePath()
        colours.addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(-6.0, -40.0)
        p.lineTo(-6.0, -55.0)
        p.lineTo(6.0, -55.0)
        p.lineTo(6.0, -40.0)
        p.closePath()
        colours.addInstr(H4, p)
        p = Path2D.Double()
        p.moveTo(-6.0, -25.0)
        p.lineTo(-6.0, -40.0)
        p.lineTo(6.0, -40.0)
        p.lineTo(6.0, -25.0)
        p.closePath()
        colours.addInstr(H5, p)
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        p.quadTo(3.0, -9.3, 0.0, -10.0)
        p.closePath()
        colours.addInstr(V2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
        addInstr(LINE, Line2D.Double(-20.0, 0.0, -10.0, 0.0))
        addInstr(LINE, Line2D.Double(10.0, 0.0, 20.0, 0.0))
        p = Path2D.Double()
        p.moveTo(-6.0, -8.5)
        p.lineTo(-6.0, -70.0)
        p.lineTo(6.0, -70.0)
        p.lineTo(6.0, -8.5)
        addInstr(PLIN, p)
    }

    val Cairn = Symbol().apply {
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
        addInstr(LINE, Line2D.Double(-40.0, 0.0, -10.0, 0.0))
        addInstr(LINE, Line2D.Double(10.0, 0.0, 40.0, 0.0))
        addInstr(ELPS, Ellipse2D.Double(3.0, -40.0, 40.0, 40.0))
        addInstr(ELPS, Ellipse2D.Double(-43.0, -40.0, 40.0, 40.0))
        addInstr(ELPS, Ellipse2D.Double(-18.0, -70.0, 36.0, 36.0))
    }

    val FogSignal = Symbol().apply {
        addInstr(STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
        addInstr(STRK, BasicStroke(10f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xd400d4))
        addInstr(EARC, Arc2D.Double(-120.0, -120.0, 240.0, 240.0, 190.0, 50.0, Arc2D.OPEN))
        addInstr(EARC, Arc2D.Double(-92.5, -92.5, 185.0, 185.0, 190.0, 50.0, Arc2D.OPEN))
        addInstr(EARC, Arc2D.Double(-65.0, -65.0, 130.0, 130.0, 190.0, 50.0, Arc2D.OPEN))
    }

    val Lattice = Symbol().apply {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-15.0, -70.0)
        p.lineTo(15.0, -70.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-20.0, 0.0)
        p.lineTo(-17.5, -35.0)
        p.lineTo(17.5, -35.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-18.3, -23.3)
        p.lineTo(-16.7, -46.7)
        p.lineTo(16.7, -46.7)
        p.lineTo(18.3, -23.3)
        p.closePath()
        colours.addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(-17.5, -35.0)
        p.lineTo(-16.25, -52.5)
        p.lineTo(16.25, -52.5)
        p.lineTo(17.5, -35.0)
        p.closePath()
        colours.addInstr(H4, p)
        p = Path2D.Double()
        p.moveTo(-18.75, -17.5)
        p.lineTo(-17.5, -35.0)
        p.lineTo(17.5, -35.0)
        p.lineTo(18.75, -17.5)
        p.closePath()
        colours.addInstr(H5, p)
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(15.0, -70.0)
        p.lineTo(20.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.quadTo(10.0, -10.0, 0.0, -10.0)
        p.closePath()
        colours.addInstr(V2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
        addInstr(LINE, Line2D.Double(-30.0, 0.0, -10.0, 0.0))
        addInstr(LINE, Line2D.Double(10.0, 0.0, 30.0, 0.0))
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
        addInstr(PLIN, p)
    }

    val LightFlare = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -100.0, 40.0, 100.0))
        addInstr(RSHP, Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0))
        val p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(15.0, -95.0)
        p.curveTo(20.0, -123.0, -20.0, -123.0, -15.0, -95.0)
        p.closePath()
        addInstr(PGON, p)
    }

    val LightMajor = Symbol().apply {
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val LightMinor = Symbol().apply {
        addInstr(FILL, black)
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
        addInstr(PGON, p)
    }

    val PerchPort = Symbol().apply {
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0))
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -40.0))
        addInstr(LINE, Line2D.Double(25.0, -70.0, 0.0, -40.0))
        addInstr(LINE, Line2D.Double(-25.0, -70.0, 0.0, -40.0))
    }

    val PerchStarboard = Symbol().apply {
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0))
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0))
        addInstr(LINE, Line2D.Double(25.0, -40.0, 0.0, -68.7))
        addInstr(LINE, Line2D.Double(-25.0, -40.0, 0.0, -68.7))
    }

    val RadarStation = Symbol().apply {
        addInstr(STRK, BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, Color(0xd400d4))
        addInstr(ELPS, Ellipse2D.Double(-125.0, -125.0, 250.0, 250.0))
    }

    val Stake = Symbol().apply {
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-2.0, 0.0)
        p.lineTo(-2.0, -70.0)
        p.lineTo(2.0, -70.0)
        p.lineTo(2.0, 0.0)
        p.closePath()
        colours.addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-2.0, 0.0)
        p.lineTo(-2.0, -35.0)
        p.lineTo(2.0, -35.0)
        p.lineTo(2.0, 0.0)
        p.closePath()
        colours.addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-2.0, -23.3)
        p.lineTo(-2.0, -46.7)
        p.lineTo(2.0, -46.7)
        p.lineTo(2.0, -23.3)
        p.closePath()
        colours.addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(-2.0, -35.0)
        p.lineTo(-2.0, -52.5)
        p.lineTo(2.0, -52.5)
        p.lineTo(2.0, -35.0)
        p.closePath()
        colours.addInstr(H4, p)
        p = Path2D.Double()
        p.moveTo(-2.0, -17.5)
        p.lineTo(-2.0, -35.0)
        p.lineTo(2.0, -35.0)
        p.lineTo(2.0, -17.5)
        p.closePath()
        colours.addInstr(H5, p)
        addInstr(COLR, colours)
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0))
    }

    val Tower = Symbol().apply {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-20.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-22.5, -35.0)
        p.lineTo(22.5, -35.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.curveTo(10.0, -13.3, -10.0, -13.3, -10.0, 0.0)
        p.closePath()
        colours.addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-23.3, -23.3)
        p.lineTo(-21.7, -46.7)
        p.lineTo(21.7, -46.7)
        p.lineTo(23.3, -23.3)
        p.closePath()
        colours.addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(-22.5, -35.0)
        p.lineTo(-21.0, -52.5)
        p.lineTo(21.0, -52.5)
        p.lineTo(22.5, -35.0)
        p.closePath()
        colours.addInstr(H4, p)
        p = Path2D.Double()
        p.moveTo(-23.6, -17.5)
        p.lineTo(-22.5, -35.0)
        p.lineTo(22.5, -35.0)
        p.lineTo(23.6, -17.5)
        p.closePath()
        colours.addInstr(H5, p)
        p = Path2D.Double()
        p.moveTo(0.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        p.lineTo(10.0, 0.0)
        p.quadTo(10.0, -10.0, 0.0, -10.0)
        p.closePath()
        colours.addInstr(V2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0))
        addInstr(LINE, Line2D.Double(-35.0, 0.0, -10.0, 0.0))
        addInstr(LINE, Line2D.Double(10.0, 0.0, 35.0, 0.0))
        p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-20.0, -70.0)
        p.lineTo(20.0, -70.0)
        p.lineTo(25.0, 0.0)
        addInstr(PLIN, p)
    }

    val WithyPort = Symbol().apply {
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0))
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0))
        addInstr(LINE, Line2D.Double(20.0, -60.0, 0.0, -50.0))
        addInstr(LINE, Line2D.Double(-20.0, -60.0, 0.0, -50.0))
        addInstr(LINE, Line2D.Double(30.0, -35.0, 0.0, -21.0))
        addInstr(LINE, Line2D.Double(-30.0, -35.0, 0.0, -21.0))
    }

    val WithyStarboard = Symbol().apply {
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(-10.0, 0.0, 10.0, 0.0))
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -70.0))
        addInstr(LINE, Line2D.Double(20.0, -50.0, 0.0, -60.0))
        addInstr(LINE, Line2D.Double(-20.0, -50.0, 0.0, -60.0))
        addInstr(LINE, Line2D.Double(30.0, -21.0, 0.0, -35.0))
        addInstr(LINE, Line2D.Double(-30.0, -21.0, 0.0, -35.0))
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

    val AllBeacons: List<Symbol> = listOf(
        Beacon,
        Cairn,
        FogSignal,
        Lattice,
        LightFlare,
        LightMajor,
        LightMinor,
        PerchPort,
        PerchStarboard,
        RadarStation,
        Stake,
        Tower,
        WithyPort,
        WithyStarboard,
    )
}