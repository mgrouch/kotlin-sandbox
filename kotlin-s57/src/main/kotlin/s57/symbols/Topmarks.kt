// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.S57val.BoySHP
import s57.S57val.TopSHP
import s57.symbols.Symbols.Delta
import s57.symbols.Symbols.Form
import s57.symbols.Symbols.Handle
import s57.symbols.Symbols.Instr
import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.*


/**
 * @author Malcolm Herring
 */
object Topmarks {
    // CHECKSTYLE.OFF: LineLength

    val RadarReflector = Symbols.Symbol()

    init {
        RadarReflector.add(Instr(Form.BBOX, Rectangle2D.Double(-50.0, -40.0, 100.0, 40.0)))
        RadarReflector.add(
            Instr(
                Form.STRK,
                BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        RadarReflector.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-30.0, -3.0)
        p.quadTo(0.0, -40.0, 30.0, -3.0)
        p.moveTo(0.0, -20.0)
        p.lineTo(0.0, -37.0)
        p.moveTo(-30.0, -3.0)
        p.lineTo(-43.0, -14.0)
        p.moveTo(30.0, -3.0)
        p.lineTo(44.0, -14.0)
        p.moveTo(-15.0, -14.0)
        p.lineTo(-25.0, -30.0)
        p.moveTo(15.0, -14.0)
        p.lineTo(25.0, -30.0)
        RadarReflector.add(Instr(Form.PLIN, p))
    }

    val TopBesom = Symbols.Symbol()

    init {
        TopBesom.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        TopBesom.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopBesom.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(15.0, 0.0)
        p.moveTo(0.0, 0.0)
        p.lineTo(0.0, -28.0)
        TopBesom.add(Instr(Form.PLIN, p))
    }

    val TopIBesom = Symbols.Symbol()

    init {
        TopIBesom.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        TopIBesom.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIBesom.add(Instr(Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-15.0, -30.0)
        p.lineTo(0.0, 0.0)
        p.lineTo(15.0, -30.0)
        TopIBesom.add(Instr(Form.PLIN, p))
    }

    val TopBoard = Symbols.Symbol()

    init {
        TopBoard.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -59.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -59.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        p.moveTo(-19.0, -10.0)
        p.lineTo(-19.0, -49.0)
        p.lineTo(19.0, -49.0)
        p.lineTo(19.0, -10.0)
        p.closePath()
        colours.add(Instr(Form.B1, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -30.0)
        p.lineTo(29.0, -30.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(0.0, -59.0)
        p.lineTo(0.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.S2, p))
        p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -30.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(0.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.S3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(29.0, -30.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.S4, p))
        TopBoard.add(Instr(Form.COLR, colours))
        TopBoard.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopBoard.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -59.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        TopBoard.add(Instr(Form.PLIN, p))
    }


    val TopCan = Symbols.Symbol()

    init {
        TopCan.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-12.0, -15.0)
        p.lineTo(-12.0, -48.0)
        p.lineTo(12.0, -48.0)
        p.lineTo(12.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopCan.add(Instr(Form.COLR, colours))
        TopCan.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCan.add(Instr(Form.FILL, Color.black))
        TopCan.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        p = Path2D.Double()
        p.moveTo(-12.0, -15.0)
        p.lineTo(-12.0, -48.0)
        p.lineTo(12.0, -48.0)
        p.lineTo(12.0, -15.0)
        p.closePath()
        TopCan.add(Instr(Form.PLIN, p))
    }

    val TopCanSphere = Symbols.Symbol()
    val TopCircle = Symbols.Symbol()
    val TopCircleTriangle = Symbols.Symbol()

    val TopCone = Symbols.Symbol()

    init {
        TopCone.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopCone.add(Instr(Form.COLR, colours))
        TopCone.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCone.add(Instr(Form.FILL, Color.black))
        TopCone.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        TopCone.add(Instr(Form.PLIN, p))
    }

    val TopConeSphere = Symbols.Symbol()

    init {
        TopConeSphere.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -47.0)
        p.lineTo(0.0, -77.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        p.moveTo(-14.0, -28.0)
        p.curveTo(-14.0, -46.7, 14.0, -46.7, 14.0, -28.0)
        p.curveTo(14.0, -9.3, -14.0, -9.3, -14.0, -28.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopConeSphere.add(Instr(Form.COLR, colours))
        TopConeSphere.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopConeSphere.add(Instr(Form.FILL, Color.black))
        TopConeSphere.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopConeSphere.add(Instr(Form.LINE, Line2D.Double(0.0, -42.0, 0.0, -47.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, -47.0)
        p.lineTo(0.0, -77.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        TopConeSphere.add(Instr(Form.ELPS, Ellipse2D.Double(-14.0, -42.0, 28.0, 28.0)))
        TopConeSphere.add(Instr(Form.PLIN, p))
    }


    val TopCross = Symbols.Symbol()

    init {
        TopCross.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-5.0, -15.0)
        p.lineTo(-5.0, -32.5)
        p.lineTo(-22.5, -32.5)
        p.lineTo(-22.5, -42.5)
        p.lineTo(-5.0, -42.5)
        p.lineTo(-5.0, -60.0)
        p.lineTo(5.0, -60.0)
        p.lineTo(5.0, -42.5)
        p.lineTo(22.5, -42.5)
        p.lineTo(22.5, -32.5)
        p.lineTo(5.0, -32.5)
        p.lineTo(5.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopCross.add(Instr(Form.COLR, colours))
        TopCross.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCross.add(Instr(Form.FILL, Color.black))
        TopCross.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopCross.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(-5.0, -15.0)
        p.lineTo(-5.0, -32.5)
        p.lineTo(-22.5, -32.5)
        p.lineTo(-22.5, -42.5)
        p.lineTo(-5.0, -42.5)
        p.lineTo(-5.0, -60.0)
        p.lineTo(5.0, -60.0)
        p.lineTo(5.0, -42.5)
        p.lineTo(22.5, -42.5)
        p.lineTo(22.5, -32.5)
        p.lineTo(5.0, -32.5)
        p.lineTo(5.0, -15.0)
        p.closePath()
        TopCross.add(Instr(Form.PLIN, p))
    }

    val TopCrosses = Symbols.Symbol()
    val TopCrossCircle = Symbols.Symbol()
    val TopCube = Symbols.Symbol()

    init {
        TopCube.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -48.0)
        p.lineTo(-15.0, -37.0)
        p.lineTo(-15.0, -20.0)
        p.lineTo(0.0, -9.0)
        p.lineTo(15.0, -20.0)
        p.lineTo(15.0, -37.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopCube.add(Instr(Form.COLR, colours))
        TopCube.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCube.add(Instr(Form.FILL, Color.black))
        TopCube.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        p = Path2D.Double()
        p.moveTo(0.0, -48.0)
        p.lineTo(-14.0, -37.0)
        p.lineTo(0.0, -26.0)
        p.lineTo(14.0, -37.0)
        p.closePath()
        p.moveTo(0.0, -26.0)
        p.lineTo(0.0, 0.0)
        p.moveTo(-15.0, -37.0)
        p.lineTo(-15.0, -20.0)
        p.lineTo(0.0, -9.0)
        p.lineTo(15.0, -20.0)
        p.lineTo(15.0, -37.0)
        TopCube.add(Instr(Form.PLIN, p))
    }


    val TopEast = Symbols.Symbol()

    init {
        TopEast.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -80.0)
        p.lineTo(-15.0, -47.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        colours.add(Instr(Form.P2, p))
        TopEast.add(Instr(Form.COLR, colours))
        TopEast.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopEast.add(Instr(Form.FILL, Color.black))
        TopEast.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopEast.add(Instr(Form.LINE, Line2D.Double(0.0, -43.0, 0.0, -47.0)))
        TopEast.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        p.moveTo(0.0, -80.0)
        p.lineTo(-15.0, -47.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        TopEast.add(Instr(Form.PLIN, p))
    }

    val TopFlag = Symbols.Symbol()

    init {
        TopFlag.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -40.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -40.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(40.0, -10.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(0.0, -20.0)
        p.lineTo(40.0, -20.0)
        p.lineTo(39.0, -30.0)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(19.5, -40.0)
        p.lineTo(19.5, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -40.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        p = Path2D.Double()
        p.moveTo(13.0, -40.0)
        p.lineTo(13.0, -10.0)
        p.lineTo(26.0, -10.0)
        p.lineTo(26.0, -40.0)
        p.closePath()
        colours.add(Instr(Form.V3, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(0.0, -40.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -40.0)
        p.closePath()
        p.moveTo(8.0, -35.0)
        p.lineTo(8.0, -15.0)
        p.lineTo(33.0, -15.0)
        p.lineTo(33.0, -35.0)
        p.closePath()
        colours.add(Instr(Form.B1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(20.0, -40.0)
        p.lineTo(39.0, -40.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        colours.add(Instr(Form.S2, p))
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(20.0, -25.0)
        p.closePath()
        colours.add(Instr(Form.S3, p))
        p = Path2D.Double()
        p.moveTo(20.0, -25.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        colours.add(Instr(Form.S4, p))
        TopFlag.add(Instr(Form.COLR, colours))
        TopFlag.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopFlag.add(Instr(Form.FILL, Color.black))
        TopFlag.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -45.0)))
        TopFlag.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopFlag.add(Instr(Form.RECT, Rectangle2D.Double(0.0, -40.0, 39.0, 30.0)))
    }

    val TopIcone = Symbols.Symbol()

    init {
        TopIcone.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -45.0)
        p.lineTo(0.0, -15.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopIcone.add(Instr(Form.COLR, colours))
        TopIcone.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIcone.add(Instr(Form.FILL, Color.black))
        TopIcone.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, -45.0)
        p.lineTo(0.0, -15.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        TopIcone.add(Instr(Form.PLIN, p))
    }


    val TopIsol = Symbols.Symbol()

    init {
        TopIsol.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -55.0)
        p.curveTo(-13.0, -72.3, 13.0, -72.3, 13.0, -55.0)
        p.curveTo(13.0, -37.7, -13.0, -37.7, -13.0, -55.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-13.0, -28.0)
        p.curveTo(-13.0, -45.3, 13.0, -45.3, 13.0, -28.0)
        p.curveTo(13.0, -10.7, -13.0, -10.7, -13.0, -28.0)
        p.closePath()
        colours.add(Instr(Form.P2, p))
        TopIsol.add(Instr(Form.COLR, colours))
        TopIsol.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIsol.add(Instr(Form.FILL, Color.black))
        TopIsol.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopIsol.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIsol.add(Instr(Form.ELPS, Ellipse2D.Double(-13.0, -41.0, 26.0, 26.0)))
        TopIsol.add(Instr(Form.ELPS, Ellipse2D.Double(-13.0, -68.0, 26.0, 26.0)))
    }


    val TopMooring = Symbols.Symbol()

    init {
        TopMooring.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        TopMooring.add(Instr(Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopMooring.add(Instr(Form.FILL, Color.black))
        TopMooring.add(Instr(Form.ELPS, Ellipse2D.Double(-1.5, -6.0, 3.0, 3.0)))
        TopMooring.add(Instr(Form.ELPS, Ellipse2D.Double(-8.5, -25.0, 17.0, 17.0)))
    }


    val TopNorth = Symbols.Symbol()

    init {
        TopNorth.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -78.0)
        p.lineTo(-15.0, -45.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        colours.add(Instr(Form.P2, p))
        TopNorth.add(Instr(Form.COLR, colours))
        TopNorth.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopNorth.add(Instr(Form.FILL, Color.black))
        TopNorth.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopNorth.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        p.moveTo(0.0, -78.0)
        p.lineTo(-15.0, -45.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        TopNorth.add(Instr(Form.PLIN, p))
    }


    val TopSouth = Symbols.Symbol()

    init {
        TopSouth.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        colours.add(Instr(Form.P2, p))
        TopSouth.add(Instr(Form.COLR, colours))
        TopSouth.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSouth.add(Instr(Form.FILL, Color.black))
        TopSouth.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopSouth.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        TopSouth.add(Instr(Form.PLIN, p))
    }


    val TopSphere = Symbols.Symbol()

    init {
        TopSphere.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -28.0)
        p.curveTo(-14.0, -46.7, 14.0, -46.7, 14.0, -28.0)
        p.curveTo(14.0, -9.3, -14.0, -9.3, -14.0, -28.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopSphere.add(Instr(Form.COLR, colours))
        TopSphere.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSphere.add(Instr(Form.FILL, Color.black))
        TopSphere.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopSphere.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSphere.add(Instr(Form.ELPS, Ellipse2D.Double(-14.0, -42.0, 28.0, 28.0)))
    }

    val TopSquare = Symbols.Symbol()

    init {
        TopSquare.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-13.0, -15.0)
        p.lineTo(-13.0, -1.0)
        p.lineTo(13.0, -1.0)
        p.lineTo(13.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-13.0, -19.3)
        p.lineTo(-13.0, -10.7)
        p.lineTo(13.0, -10.7)
        p.lineTo(13.0, -19.3)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        p = Path2D.Double()
        p.moveTo(-4.3, -1.0)
        p.lineTo(-4.3, -27.0)
        p.lineTo(4.3, -27.0)
        p.lineTo(4.3, -1.0)
        p.closePath()
        colours.add(Instr(Form.V3, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-13.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        p.moveTo(-8.0, -6.0)
        p.lineTo(-8.0, -22.0)
        p.lineTo(8.0, -22.0)
        p.lineTo(8.0, -6.0)
        p.closePath()
        colours.add(Instr(Form.B1, p))
        TopSquare.add(Instr(Form.COLR, colours))
        TopSquare.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSquare.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-10.0, -1.0)
        p.lineTo(-10.0, -21.0)
        p.lineTo(12.0, -21.0)
        p.lineTo(10.0, -1.0)
        p.closePath()
        TopSquare.add(Instr(Form.PLIN, p))
    }

    val TopRectangleH = Symbols.Symbol()

    init {
        TopRectangleH.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -12.0)
        p.lineTo(14.0, -12.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-14.0, -16.0)
        p.lineTo(-14.0, -8.0)
        p.lineTo(14.0, -8.0)
        p.lineTo(14.0, -16.0)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        p = Path2D.Double()
        p.moveTo(-5.0, -1.0)
        p.lineTo(-5.0, -23.0)
        p.lineTo(5.0, -23.0)
        p.lineTo(5.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.V3, p))
        TopRectangleH.add(Instr(Form.COLR, colours))
        TopRectangleH.add(
            Instr(
                Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopRectangleH.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        TopRectangleH.add(Instr(Form.PLIN, p))
    }

    val TopRectangleV = Symbols.Symbol()

    init {
        TopRectangleV.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -15.0)
        p.lineTo(11.0, -15.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-11.0, -10.0)
        p.lineTo(-11.0, -20.0)
        p.lineTo(11.0, -20.0)
        p.lineTo(11.0, -10.0)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        p = Path2D.Double()
        p.moveTo(-4.0, -1.0)
        p.lineTo(-4.0, -29.0)
        p.lineTo(4.0, -29.0)
        p.lineTo(4.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.V3, p))
        TopRectangleV.add(Instr(Form.COLR, colours))
        TopRectangleV.add(
            Instr(
                Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopRectangleV.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        TopRectangleV.add(Instr(Form.PLIN, p))
    }

    val TopRhombus = Symbols.Symbol()

    init {
        TopRhombus.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-10.0, -19.7)
        p.lineTo(-15.0, -15.0)
        p.lineTo(-10.0, -10.3)
        p.lineTo(10.0, -10.3)
        p.lineTo(15.0, -15.0)
        p.lineTo(10.0, -19.7)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-5.0, -24.3)
        p.lineTo(-5.0, -5.7)
        p.lineTo(0.0, -1.0)
        p.lineTo(5.0, -5.7)
        p.lineTo(5.0, -24.3)
        p.closePath()
        colours.add(Instr(Form.V3, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(0.0, -29.0)
        p.lineTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        p.moveTo(0.0, -23.0)
        p.lineTo(-9.0, -15.0)
        p.lineTo(0.0, -7.0)
        p.lineTo(9.0, -15.0)
        p.closePath()
        colours.add(Instr(Form.B1, p))
        TopRhombus.add(Instr(Form.COLR, colours))
        TopRhombus.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopRhombus.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        TopRhombus.add(Instr(Form.PLIN, p))
    }

    val TopRhombusCircle = Symbols.Symbol()
    val TopSphereRhombus = Symbols.Symbol()

    init {
        TopSphereRhombus.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        TopSphereRhombus.add(Instr(Form.SYMB, Symbols.SubSymbol(TopRhombus, 1.0, 0.0, 0.0, null, null)))
        val colours = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -44.0)
        p.curveTo(-14.0, -62.7, 14.0, -62.7, 14.0, -44.0)
        p.curveTo(14.0, -25.3, -14.0, -25.3, -14.0, -44.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopSphereRhombus.add(Instr(Form.COLR, colours))
        TopSphereRhombus.add(
            Instr(
                Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopSphereRhombus.add(Instr(Form.FILL, Color.black))
        TopSphereRhombus.add(
            Instr(
                Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopSphereRhombus.add(Instr(Form.ELPS, Ellipse2D.Double(-14.0, -58.0, 28.0, 28.0)))
    }

    val TopT = Symbols.Symbol()
    val TopTrapeziumU = Symbols.Symbol()

    init {
        TopTrapeziumU.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-20.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(20.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopTrapeziumU.add(Instr(Form.COLR, colours))
        TopTrapeziumU.add(
            Instr(
                Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopTrapeziumU.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-20.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(20.0, -1.0)
        p.closePath()
        TopTrapeziumU.add(Instr(Form.PLIN, p))
    }

    val TopTrapeziumD = Symbols.Symbol()

    init {
        TopTrapeziumD.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-20.0, -27.0)
        p.lineTo(20.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopTrapeziumD.add(Instr(Form.COLR, colours))
        TopTrapeziumD.add(
            Instr(
                Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopTrapeziumD.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-20.0, -27.0)
        p.lineTo(20.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        TopTrapeziumD.add(Instr(Form.PLIN, p))
    }

    val TopTriangle = Symbols.Symbol()

    init {
        TopTriangle.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        p.moveTo(-10.0, -6.0)
        p.lineTo(0.0, -24.0)
        p.lineTo(10.0, -6.0)
        p.closePath()
        colours.add(Instr(Form.B1, p))
        TopTriangle.add(Instr(Form.COLR, colours))
        TopTriangle.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopTriangle.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        TopTriangle.add(Instr(Form.PLIN, p))
    }

    val TopItriangle = Symbols.Symbol()

    init {
        TopItriangle.add(Instr(Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        p.moveTo(-10.0, -24.0)
        p.lineTo(0.0, -6.0)
        p.lineTo(10.0, -24.0)
        p.closePath()
        colours.add(Instr(Form.B1, p))
        TopItriangle.add(Instr(Form.COLR, colours))
        TopItriangle.add(
            Instr(
                Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopItriangle.add(Instr(Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        TopItriangle.add(Instr(Form.PLIN, p))
    }

    val TopTriangleCircle = Symbols.Symbol()

    val TopWest = Symbols.Symbol()

    init {
        TopWest.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        colours.add(Instr(Form.P2, p))
        TopWest.add(Instr(Form.COLR, colours))
        TopWest.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopWest.add(Instr(Form.FILL, Color.black))
        TopWest.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopWest.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        TopWest.add(Instr(Form.PLIN, p))
    }


    val TopX = Symbols.Symbol()

    init {
        TopX.add(Instr(Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -27.7)
        p.lineTo(-12.4, -15.7)
        p.lineTo(-19.3, -22.6)
        p.lineTo(-7.3, -35.0)
        p.lineTo(-19.3, -47.3)
        p.lineTo(-12.4, -54.2)
        p.lineTo(0.0, -42.4)
        p.lineTo(12.4, -54.2)
        p.lineTo(19.3, -47.3)
        p.lineTo(7.3, -35.0)
        p.lineTo(19.3, -22.6)
        p.lineTo(12.4, -15.7)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        TopX.add(Instr(Form.COLR, colours))
        TopX.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopX.add(Instr(Form.FILL, Color.black))
        TopX.add(Instr(Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -27.0)))
        TopX.add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(0.0, -27.7)
        p.lineTo(-12.4, -15.7)
        p.lineTo(-19.3, -22.6)
        p.lineTo(-7.3, -35.0)
        p.lineTo(-19.3, -47.3)
        p.lineTo(-12.4, -54.2)
        p.lineTo(0.0, -42.4)
        p.lineTo(12.4, -54.2)
        p.lineTo(19.3, -47.3)
        p.lineTo(7.3, -35.0)
        p.lineTo(19.3, -22.6)
        p.lineTo(12.4, -15.7)
        p.closePath()
        TopX.add(Instr(Form.PLIN, p))
    }

    val TopOther = Symbols.Symbol()

    val Shapes = mapOf(
        TopSHP.TOP_BESM to TopBesom,
        TopSHP.TOP_IBESM to TopIBesom,
        TopSHP.TOP_BORD to TopBoard,
        TopSHP.TOP_CAN to TopCan,
        TopSHP.TOP_CONE to TopCone,
        TopSHP.TOP_CROS to TopCross,
        TopSHP.TOP_EAST to TopEast,
        TopSHP.TOP_ICONE to TopIcone,
        TopSHP.TOP_ISD to TopIsol,
        TopSHP.TOP_NORTH to TopNorth,
        TopSHP.TOP_SOUTH to TopSouth,
        TopSHP.TOP_SPHR to TopSphere,
        TopSHP.TOP_SQUR to TopSquare,
        TopSHP.TOP_TRI to TopTriangle,
        TopSHP.TOP_ITRI to TopItriangle,
        TopSHP.TOP_WEST to TopWest,
        TopSHP.TOP_SALT to TopX,
        TopSHP.TOP_RHOM to TopRhombus,
        TopSHP.TOP_FLAG to TopFlag,
        TopSHP.TOP_CUBE to TopCube,
        TopSHP.TOP_SPRH to TopSphereRhombus,
        TopSHP.TOP_HRECT to TopRectangleH,
        TopSHP.TOP_VRECT to TopRectangleV,
        TopSHP.TOP_TRAP to TopTrapeziumU,
        TopSHP.TOP_ITRAP to TopTrapeziumD,
        TopSHP.TOP_COSP to TopConeSphere,
        TopSHP.TOP_CIRC to TopCircle,
        TopSHP.TOP_CRSS to TopCrosses,
        TopSHP.TOP_T to TopT,
        TopSHP.TOP_TRCL to TopTriangleCircle,
        TopSHP.TOP_CRCL to TopCrossCircle,
        TopSHP.TOP_RHCL to TopRhombusCircle,
        TopSHP.TOP_CLTR to TopCircleTriangle,
        TopSHP.TOP_CYSP to TopCanSphere,
        TopSHP.TOP_OTHR to TopOther,
    )

    // CHECKSTYLE.OFF: SingleSpaceSeparator

    val BuoyDeltas = mapOf(
        BoySHP.BOY_PILR to Delta(
            Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 31.5, -95.0)
        ),
        BoySHP.BOY_SPAR to Delta(
            Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 31.5, -95.0)
        ),
        BoySHP.BOY_CAN to Delta(
            Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        ),
        BoySHP.BOY_CONE to Delta(
            Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        ),
        BoySHP.BOY_SPHR to Delta(
            Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        ),
        BoySHP.BOY_BARL to Delta(
            Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        ),
        BoySHP.BOY_SUPR to
                Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -42.0)),
        BoySHP.BOY_ICE to
                Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0)),
    )

    val FloatDelta = Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -42.0))

    val BeaconDelta = Delta(Handle.BC, AffineTransform.getTranslateInstance(0.0, -70.0))

    val LightDelta = Delta(
        Handle.BC,
        AffineTransform.getTranslateInstance(0.0, -20.0)
    ) // CHECKSTYLE.ON: SingleSpaceSeparator
}