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
object Topmarks {
    // CHECKSTYLE.OFF: LineLength
    @JvmField
    val RadarReflector = Symbols.Symbol()

    init {
        RadarReflector.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-50.0, -40.0, 100.0, 40.0)))
        RadarReflector.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        RadarReflector.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
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
        RadarReflector.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopBesom = Symbols.Symbol()

    init {
        TopBesom.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        TopBesom.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopBesom.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(15.0, 0.0)
        p.moveTo(0.0, 0.0)
        p.lineTo(0.0, -28.0)
        TopBesom.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopIBesom = Symbols.Symbol()

    init {
        TopIBesom.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        TopIBesom.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIBesom.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        val p = Path2D.Double()
        p.moveTo(-15.0, -30.0)
        p.lineTo(0.0, 0.0)
        p.lineTo(15.0, -30.0)
        TopIBesom.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopBoard = Symbols.Symbol()

    init {
        TopBoard.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -59.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
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
        colours.add(Symbols.Instr(Symbols.Form.B1, p))
        p = Path2D.Double()
        p.setWindingRule(GeneralPath.WIND_EVEN_ODD)
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -30.0)
        p.lineTo(29.0, -30.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(0.0, -59.0)
        p.lineTo(0.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.S2, p))
        p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -30.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(0.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.S3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(29.0, -30.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.S4, p))
        TopBoard.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopBoard.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopBoard.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -59.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        TopBoard.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val TopCan = Symbols.Symbol()

    init {
        TopCan.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-12.0, -15.0)
        p.lineTo(-12.0, -48.0)
        p.lineTo(12.0, -48.0)
        p.lineTo(12.0, -15.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopCan.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopCan.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCan.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopCan.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        p = Path2D.Double()
        p.moveTo(-12.0, -15.0)
        p.lineTo(-12.0, -48.0)
        p.lineTo(12.0, -48.0)
        p.lineTo(12.0, -15.0)
        p.closePath()
        TopCan.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopCanSphere = Symbols.Symbol()
    val TopCircle = Symbols.Symbol()
    val TopCircleTriangle = Symbols.Symbol()
    @JvmField
    val TopCone = Symbols.Symbol()

    init {
        TopCone.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopCone.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopCone.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCone.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopCone.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        TopCone.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopConeSphere = Symbols.Symbol()

    init {
        TopConeSphere.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
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
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopConeSphere.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopConeSphere.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopConeSphere.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopConeSphere.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopConeSphere.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -42.0, 0.0, -47.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, -47.0)
        p.lineTo(0.0, -77.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        TopConeSphere.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-14.0, -42.0, 28.0, 28.0)))
        TopConeSphere.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val TopCross = Symbols.Symbol()

    init {
        TopCross.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
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
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopCross.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopCross.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCross.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopCross.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopCross.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
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
        TopCross.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopCrosses = Symbols.Symbol()
    val TopCrossCircle = Symbols.Symbol()
    val TopCube = Symbols.Symbol()

    init {
        TopCube.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -48.0)
        p.lineTo(-15.0, -37.0)
        p.lineTo(-15.0, -20.0)
        p.lineTo(0.0, -9.0)
        p.lineTo(15.0, -20.0)
        p.lineTo(15.0, -37.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopCube.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopCube.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopCube.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopCube.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
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
        TopCube.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val TopEast = Symbols.Symbol()

    init {
        TopEast.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -80.0)
        p.lineTo(-15.0, -47.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P2, p))
        TopEast.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopEast.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopEast.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopEast.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopEast.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -43.0, 0.0, -47.0)))
        TopEast.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        p.moveTo(0.0, -80.0)
        p.lineTo(-15.0, -47.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        TopEast.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopFlag = Symbols.Symbol()

    init {
        TopFlag.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -40.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -40.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(40.0, -10.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(0.0, -20.0)
        p.lineTo(40.0, -20.0)
        p.lineTo(39.0, -30.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(19.5, -40.0)
        p.lineTo(19.5, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -40.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        p = Path2D.Double()
        p.moveTo(13.0, -40.0)
        p.lineTo(13.0, -10.0)
        p.lineTo(26.0, -10.0)
        p.lineTo(26.0, -40.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V3, p))
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
        colours.add(Symbols.Instr(Symbols.Form.B1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(20.0, -40.0)
        p.lineTo(39.0, -40.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.S2, p))
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(20.0, -25.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.S3, p))
        p = Path2D.Double()
        p.moveTo(20.0, -25.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.S4, p))
        TopFlag.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopFlag.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopFlag.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopFlag.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -45.0)))
        TopFlag.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopFlag.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(0.0, -40.0, 39.0, 30.0)))
    }

    val TopIcone = Symbols.Symbol()

    init {
        TopIcone.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -45.0)
        p.lineTo(0.0, -15.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopIcone.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopIcone.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIcone.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopIcone.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, -45.0)
        p.lineTo(0.0, -15.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        TopIcone.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val TopIsol = Symbols.Symbol()

    init {
        TopIsol.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -55.0)
        p.curveTo(-13.0, -72.3, 13.0, -72.3, 13.0, -55.0)
        p.curveTo(13.0, -37.7, -13.0, -37.7, -13.0, -55.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-13.0, -28.0)
        p.curveTo(-13.0, -45.3, 13.0, -45.3, 13.0, -28.0)
        p.curveTo(13.0, -10.7, -13.0, -10.7, -13.0, -28.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P2, p))
        TopIsol.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopIsol.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIsol.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopIsol.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopIsol.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopIsol.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-13.0, -41.0, 26.0, 26.0)))
        TopIsol.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-13.0, -68.0, 26.0, 26.0)))
    }

    @JvmField
    val TopMooring = Symbols.Symbol()

    init {
        TopMooring.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        TopMooring.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopMooring.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopMooring.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-1.5, -6.0, 3.0, 3.0)))
        TopMooring.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-8.5, -25.0, 17.0, 17.0)))
    }

    @JvmField
    val TopNorth = Symbols.Symbol()

    init {
        TopNorth.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -78.0)
        p.lineTo(-15.0, -45.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P2, p))
        TopNorth.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopNorth.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopNorth.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopNorth.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopNorth.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        p.moveTo(0.0, -78.0)
        p.lineTo(-15.0, -45.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        TopNorth.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val TopSouth = Symbols.Symbol()

    init {
        TopSouth.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P2, p))
        TopSouth.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopSouth.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSouth.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopSouth.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopSouth.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        TopSouth.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val TopSphere = Symbols.Symbol()

    init {
        TopSphere.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -28.0)
        p.curveTo(-14.0, -46.7, 14.0, -46.7, 14.0, -28.0)
        p.curveTo(14.0, -9.3, -14.0, -9.3, -14.0, -28.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopSphere.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopSphere.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSphere.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopSphere.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0)))
        TopSphere.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSphere.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-14.0, -42.0, 28.0, 28.0)))
    }

    val TopSquare = Symbols.Symbol()

    init {
        TopSquare.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-13.0, -15.0)
        p.lineTo(-13.0, -1.0)
        p.lineTo(13.0, -1.0)
        p.lineTo(13.0, -15.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-13.0, -19.3)
        p.lineTo(-13.0, -10.7)
        p.lineTo(13.0, -10.7)
        p.lineTo(13.0, -19.3)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        p = Path2D.Double()
        p.moveTo(-4.3, -1.0)
        p.lineTo(-4.3, -27.0)
        p.lineTo(4.3, -27.0)
        p.lineTo(4.3, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V3, p))
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
        colours.add(Symbols.Instr(Symbols.Form.B1, p))
        TopSquare.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopSquare.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopSquare.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-10.0, -1.0)
        p.lineTo(-10.0, -21.0)
        p.lineTo(12.0, -21.0)
        p.lineTo(10.0, -1.0)
        p.closePath()
        TopSquare.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopRectangleH = Symbols.Symbol()

    init {
        TopRectangleH.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -12.0)
        p.lineTo(14.0, -12.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-14.0, -16.0)
        p.lineTo(-14.0, -8.0)
        p.lineTo(14.0, -8.0)
        p.lineTo(14.0, -16.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        p = Path2D.Double()
        p.moveTo(-5.0, -1.0)
        p.lineTo(-5.0, -23.0)
        p.lineTo(5.0, -23.0)
        p.lineTo(5.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V3, p))
        TopRectangleH.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopRectangleH.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopRectangleH.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        TopRectangleH.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopRectangleV = Symbols.Symbol()

    init {
        TopRectangleV.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -15.0)
        p.lineTo(11.0, -15.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-11.0, -10.0)
        p.lineTo(-11.0, -20.0)
        p.lineTo(11.0, -20.0)
        p.lineTo(11.0, -10.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        p = Path2D.Double()
        p.moveTo(-4.0, -1.0)
        p.lineTo(-4.0, -29.0)
        p.lineTo(4.0, -29.0)
        p.lineTo(4.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V3, p))
        TopRectangleV.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopRectangleV.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopRectangleV.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        TopRectangleV.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopRhombus = Symbols.Symbol()

    init {
        TopRhombus.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-10.0, -19.7)
        p.lineTo(-15.0, -15.0)
        p.lineTo(-10.0, -10.3)
        p.lineTo(10.0, -10.3)
        p.lineTo(15.0, -15.0)
        p.lineTo(10.0, -19.7)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.H3, p))
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V2, p))
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-5.0, -24.3)
        p.lineTo(-5.0, -5.7)
        p.lineTo(0.0, -1.0)
        p.lineTo(5.0, -5.7)
        p.lineTo(5.0, -24.3)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.V3, p))
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
        colours.add(Symbols.Instr(Symbols.Form.B1, p))
        TopRhombus.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopRhombus.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopRhombus.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        TopRhombus.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopRhombusCircle = Symbols.Symbol()
    val TopSphereRhombus = Symbols.Symbol()

    init {
        TopSphereRhombus.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        TopSphereRhombus.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(TopRhombus, 1.0, 0.0, 0.0, null, null)))
        val colours = Symbols.Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -44.0)
        p.curveTo(-14.0, -62.7, 14.0, -62.7, 14.0, -44.0)
        p.curveTo(14.0, -25.3, -14.0, -25.3, -14.0, -44.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopSphereRhombus.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopSphereRhombus.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopSphereRhombus.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopSphereRhombus.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopSphereRhombus.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-14.0, -58.0, 28.0, 28.0)))
    }

    val TopT = Symbols.Symbol()
    val TopTrapeziumU = Symbols.Symbol()

    init {
        TopTrapeziumU.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-20.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(20.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopTrapeziumU.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopTrapeziumU.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopTrapeziumU.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-20.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(20.0, -1.0)
        p.closePath()
        TopTrapeziumU.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopTrapeziumD = Symbols.Symbol()

    init {
        TopTrapeziumD.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-20.0, -27.0)
        p.lineTo(20.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopTrapeziumD.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopTrapeziumD.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopTrapeziumD.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-20.0, -27.0)
        p.lineTo(20.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        TopTrapeziumD.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopTriangle = Symbols.Symbol()

    init {
        TopTriangle.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
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
        colours.add(Symbols.Instr(Symbols.Form.B1, p))
        TopTriangle.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopTriangle.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopTriangle.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        TopTriangle.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopItriangle = Symbols.Symbol()

    init {
        TopItriangle.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
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
        colours.add(Symbols.Instr(Symbols.Form.B1, p))
        TopItriangle.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopItriangle.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)
            )
        )
        TopItriangle.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        p = Path2D.Double()
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        TopItriangle.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopTriangleCircle = Symbols.Symbol()
    @JvmField
    val TopWest = Symbols.Symbol()

    init {
        TopWest.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
        val colours = Symbols.Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        colours.add(Symbols.Instr(Symbols.Form.P2, p))
        TopWest.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopWest.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopWest.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopWest.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0)))
        TopWest.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        TopWest.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val TopX = Symbols.Symbol()

    init {
        TopX.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0)))
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
        colours.add(Symbols.Instr(Symbols.Form.P1, p))
        TopX.add(Symbols.Instr(Symbols.Form.COLR, colours))
        TopX.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        TopX.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        TopX.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -27.0)))
        TopX.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
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
        TopX.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val TopOther = Symbols.Symbol()
    @JvmField
    val Shapes = EnumMap<S57val.TopSHP, Symbols.Symbol>(
        S57val.TopSHP::class.java
    )

    init {
        Shapes[S57val.TopSHP.TOP_BESM] = TopBesom
        Shapes[S57val.TopSHP.TOP_IBESM] = TopIBesom
        Shapes[S57val.TopSHP.TOP_BORD] = TopBoard
        Shapes[S57val.TopSHP.TOP_CAN] = TopCan
        Shapes[S57val.TopSHP.TOP_CONE] = TopCone
        Shapes[S57val.TopSHP.TOP_CROS] = TopCross
        Shapes[S57val.TopSHP.TOP_EAST] = TopEast
        Shapes[S57val.TopSHP.TOP_ICONE] = TopIcone
        Shapes[S57val.TopSHP.TOP_ISD] = TopIsol
        Shapes[S57val.TopSHP.TOP_NORTH] = TopNorth
        Shapes[S57val.TopSHP.TOP_SOUTH] = TopSouth
        Shapes[S57val.TopSHP.TOP_SPHR] = TopSphere
        Shapes[S57val.TopSHP.TOP_SQUR] = TopSquare
        Shapes[S57val.TopSHP.TOP_TRI] = TopTriangle
        Shapes[S57val.TopSHP.TOP_ITRI] = TopItriangle
        Shapes[S57val.TopSHP.TOP_WEST] = TopWest
        Shapes[S57val.TopSHP.TOP_SALT] = TopX
        Shapes[S57val.TopSHP.TOP_RHOM] = TopRhombus
        Shapes[S57val.TopSHP.TOP_FLAG] = TopFlag
        Shapes[S57val.TopSHP.TOP_CUBE] = TopCube
        Shapes[S57val.TopSHP.TOP_SPRH] = TopSphereRhombus
        Shapes[S57val.TopSHP.TOP_HRECT] = TopRectangleH
        Shapes[S57val.TopSHP.TOP_VRECT] = TopRectangleV
        Shapes[S57val.TopSHP.TOP_TRAP] = TopTrapeziumU
        Shapes[S57val.TopSHP.TOP_ITRAP] = TopTrapeziumD
        Shapes[S57val.TopSHP.TOP_COSP] = TopConeSphere
        Shapes[S57val.TopSHP.TOP_CIRC] = TopCircle
        Shapes[S57val.TopSHP.TOP_CRSS] = TopCrosses
        Shapes[S57val.TopSHP.TOP_T] = TopT
        Shapes[S57val.TopSHP.TOP_TRCL] = TopTriangleCircle
        Shapes[S57val.TopSHP.TOP_CRCL] = TopCrossCircle
        Shapes[S57val.TopSHP.TOP_RHCL] = TopRhombusCircle
        Shapes[S57val.TopSHP.TOP_CLTR] = TopCircleTriangle
        Shapes[S57val.TopSHP.TOP_CYSP] = TopCanSphere
        Shapes[S57val.TopSHP.TOP_OTHR] = TopOther
    }

    // CHECKSTYLE.OFF: SingleSpaceSeparator
    @JvmField
    val BuoyDeltas = EnumMap<S57val.BoySHP, Symbols.Delta>(
        S57val.BoySHP::class.java
    )

    init {
        BuoyDeltas[S57val.BoySHP.BOY_PILR] = Symbols.Delta(
            Symbols.Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 31.5, -95.0)
        )
        BuoyDeltas[S57val.BoySHP.BOY_SPAR] = Symbols.Delta(
            Symbols.Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 31.5, -95.0)
        )
        BuoyDeltas[S57val.BoySHP.BOY_CAN] = Symbols.Delta(
            Symbols.Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        )
        BuoyDeltas[S57val.BoySHP.BOY_CONE] = Symbols.Delta(
            Symbols.Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        )
        BuoyDeltas[S57val.BoySHP.BOY_SPHR] = Symbols.Delta(
            Symbols.Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        )
        BuoyDeltas[S57val.BoySHP.BOY_BARL] = Symbols.Delta(
            Symbols.Handle.BC,
            AffineTransform(0.948324, 0.317305, -0.3173047, 0.948324, 12.7, -37.9)
        )
        BuoyDeltas[S57val.BoySHP.BOY_SUPR] =
            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -42.0))
        BuoyDeltas[S57val.BoySHP.BOY_ICE] =
            Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -25.0))
    }

    @JvmField
    val FloatDelta = Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -42.0))
    @JvmField
    val BeaconDelta = Symbols.Delta(Symbols.Handle.BC, AffineTransform.getTranslateInstance(0.0, -70.0))
    @JvmField
    val LightDelta = Symbols.Delta(
        Symbols.Handle.BC,
        AffineTransform.getTranslateInstance(0.0, -20.0)
    ) // CHECKSTYLE.ON: SingleSpaceSeparator
}