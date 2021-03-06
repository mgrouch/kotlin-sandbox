// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.parser.S57val.BoySHP
import s57.parser.S57val.TopSHP
import s57.symbols.Symbols.Delta
import s57.symbols.Symbols.Form.*
import s57.symbols.Symbols.Handle
import s57.symbols.Symbols.SubSymbol
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.Color.*
import java.awt.geom.*
import java.awt.geom.AffineTransform.getTranslateInstance

/**
 * @author Malcolm Herring
 */
object Topmarks {

    val RadarReflector = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-50.0, -40.0, 100.0, 40.0))
        addInstr(STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
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
        addInstr(PLIN, p)
    }

    val TopBesom = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        val p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(15.0, 0.0)
        p.moveTo(0.0, 0.0)
        p.lineTo(0.0, -28.0)
        addInstr(PLIN, p)
    }

    val TopIBesom = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        val p = Path2D.Double()
        p.moveTo(-15.0, -30.0)
        p.lineTo(0.0, 0.0)
        p.lineTo(15.0, -30.0)
        addInstr(PLIN, p)
    }

    val TopBoard = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -59.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(B1, p)
        p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -30.0)
        p.lineTo(29.0, -30.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(0.0, -59.0)
        p.lineTo(0.0, -1.0)
        p.closePath()
        addInstr(S2, p)
        p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -30.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(0.0, -1.0)
        p.closePath()
        addInstr(S3, p)
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -30.0)
        p.lineTo(29.0, -30.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        addInstr(S4, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-29.0, -1.0)
        p.lineTo(-29.0, -59.0)
        p.lineTo(29.0, -59.0)
        p.lineTo(29.0, -1.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopCan = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-12.0, -15.0)
        p.lineTo(-12.0, -48.0)
        p.lineTo(12.0, -48.0)
        p.lineTo(12.0, -15.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
        p = Path2D.Double()
        p.moveTo(-12.0, -15.0)
        p.lineTo(-12.0, -48.0)
        p.lineTo(12.0, -48.0)
        p.lineTo(12.0, -15.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopCanSphere = Symbol()
    val TopCircle = Symbol()
    val TopCircleTriangle = Symbol()

    val TopCone = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
        p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopConeSphere = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -47.0)
        p.lineTo(0.0, -77.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        p.moveTo(-14.0, -28.0)
        p.curveTo(-14.0, -46.7, 14.0, -46.7, 14.0, -28.0)
        p.curveTo(14.0, -9.3, -14.0, -9.3, -14.0, -28.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
        addInstr(LINE, Line2D.Double(0.0, -42.0, 0.0, -47.0))
        p = Path2D.Double()
        p.moveTo(-15.0, -47.0)
        p.lineTo(0.0, -77.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        addInstr(ELPS, Ellipse2D.Double(-14.0, -42.0, 28.0, 28.0))
        addInstr(PLIN, p)
    }

    val TopCross = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
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
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
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
        addInstr(PLIN, p)
    }

    val TopCrosses = Symbol()

    val TopCrossCircle = Symbol()

    val TopCube = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -48.0)
        p.lineTo(-15.0, -37.0)
        p.lineTo(-15.0, -20.0)
        p.lineTo(0.0, -9.0)
        p.lineTo(15.0, -20.0)
        p.lineTo(15.0, -37.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
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
        addInstr(PLIN, p)
    }

    val TopEast = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -80.0)
        p.lineTo(-15.0, -47.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        addInstr(P2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0))
        addInstr(LINE, Line2D.Double(0.0, -43.0, 0.0, -47.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        p.moveTo(0.0, -80.0)
        p.lineTo(-15.0, -47.0)
        p.lineTo(15.0, -47.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopFlag = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -40.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -40.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(40.0, -10.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(0.0, -30.0)
        p.lineTo(0.0, -20.0)
        p.lineTo(40.0, -20.0)
        p.lineTo(39.0, -30.0)
        p.closePath()
        addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(19.5, -40.0)
        p.lineTo(19.5, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -40.0)
        p.closePath()
        addInstr(V2, p)
        p = Path2D.Double()
        p.moveTo(13.0, -40.0)
        p.lineTo(13.0, -10.0)
        p.lineTo(26.0, -10.0)
        p.lineTo(26.0, -40.0)
        p.closePath()
        addInstr(V3, p)
        p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(B1, p)
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(20.0, -40.0)
        p.lineTo(39.0, -40.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        addInstr(S2, p)
        p = Path2D.Double()
        p.moveTo(0.0, -25.0)
        p.lineTo(0.0, -10.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(20.0, -25.0)
        p.closePath()
        addInstr(S3, p)
        p = Path2D.Double()
        p.moveTo(20.0, -25.0)
        p.lineTo(20.0, -10.0)
        p.lineTo(39.0, -10.0)
        p.lineTo(39.0, -25.0)
        p.closePath()
        addInstr(S4, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -45.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(RECT, Rectangle2D.Double(0.0, -40.0, 39.0, 30.0))
    }

    val TopIcone = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -45.0)
        p.lineTo(0.0, -15.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
        p = Path2D.Double()
        p.moveTo(-15.0, -45.0)
        p.lineTo(0.0, -15.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopIsol = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -55.0)
        p.curveTo(-13.0, -72.3, 13.0, -72.3, 13.0, -55.0)
        p.curveTo(13.0, -37.7, -13.0, -37.7, -13.0, -55.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-13.0, -28.0)
        p.curveTo(-13.0, -45.3, 13.0, -45.3, 13.0, -28.0)
        p.curveTo(13.0, -10.7, -13.0, -10.7, -13.0, -28.0)
        p.closePath()
        addInstr(P2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(ELPS, Ellipse2D.Double(-13.0, -41.0, 26.0, 26.0))
        addInstr(ELPS, Ellipse2D.Double(-13.0, -68.0, 26.0, 26.0))
    }

    val TopMooring = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        addInstr(STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(ELPS, Ellipse2D.Double(-1.5, -6.0, 3.0, 3.0))
        addInstr(ELPS, Ellipse2D.Double(-8.5, -25.0, 17.0, 17.0))
    }

    val TopNorth = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -78.0)
        p.lineTo(-15.0, -45.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        addInstr(P2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        p.moveTo(0.0, -78.0)
        p.lineTo(-15.0, -45.0)
        p.lineTo(15.0, -45.0)
        p.closePath()
        addInstr(PLIN, p)
    }


    val TopSouth = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        addInstr(P2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(-15.0, -43.0)
        p.lineTo(15.0, -43.0)
        p.closePath()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopSphere = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -28.0)
        p.curveTo(-14.0, -46.7, 14.0, -46.7, 14.0, -28.0)
        p.curveTo(14.0, -9.3, -14.0, -9.3, -14.0, -28.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -15.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(ELPS, Ellipse2D.Double(-14.0, -42.0, 28.0, 28.0))
    }

    val TopSquare = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-13.0, -15.0)
        p.lineTo(-13.0, -1.0)
        p.lineTo(13.0, -1.0)
        p.lineTo(13.0, -15.0)
        p.closePath()
        addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-13.0, -19.3)
        p.lineTo(-13.0, -10.7)
        p.lineTo(13.0, -10.7)
        p.lineTo(13.0, -19.3)
        p.closePath()
        addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        addInstr(V2, p)
        p = Path2D.Double()
        p.moveTo(-4.3, -1.0)
        p.lineTo(-4.3, -27.0)
        p.lineTo(4.3, -27.0)
        p.lineTo(4.3, -1.0)
        p.closePath()
        addInstr(V3, p)
        p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(B1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-10.0, -1.0)
        p.lineTo(-10.0, -21.0)
        p.lineTo(12.0, -21.0)
        p.lineTo(10.0, -1.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopRectangleH = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -12.0)
        p.lineTo(14.0, -12.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-14.0, -16.0)
        p.lineTo(-14.0, -8.0)
        p.lineTo(14.0, -8.0)
        p.lineTo(14.0, -16.0)
        p.closePath()
        addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        addInstr(V2, p)
        p = Path2D.Double()
        p.moveTo(-5.0, -1.0)
        p.lineTo(-5.0, -23.0)
        p.lineTo(5.0, -23.0)
        p.lineTo(5.0, -1.0)
        p.closePath()
        addInstr(V3, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-14.0, -1.0)
        p.lineTo(-14.0, -23.0)
        p.lineTo(14.0, -23.0)
        p.lineTo(14.0, -1.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopRectangleV = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -15.0)
        p.lineTo(11.0, -15.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-11.0, -10.0)
        p.lineTo(-11.0, -20.0)
        p.lineTo(11.0, -20.0)
        p.lineTo(11.0, -10.0)
        p.closePath()
        addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(0.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        addInstr(V2, p)
        p = Path2D.Double()
        p.moveTo(-4.0, -1.0)
        p.lineTo(-4.0, -29.0)
        p.lineTo(4.0, -29.0)
        p.lineTo(4.0, -1.0)
        p.closePath()
        addInstr(V3, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-11.0, -1.0)
        p.lineTo(-11.0, -29.0)
        p.lineTo(11.0, -29.0)
        p.lineTo(11.0, -1.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopRhombus = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        addInstr(H2, p)
        p = Path2D.Double()
        p.moveTo(-10.0, -19.7)
        p.lineTo(-15.0, -15.0)
        p.lineTo(-10.0, -10.3)
        p.lineTo(10.0, -10.3)
        p.lineTo(15.0, -15.0)
        p.lineTo(10.0, -19.7)
        p.closePath()
        addInstr(H3, p)
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        addInstr(V2, p)
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-5.0, -24.3)
        p.lineTo(-5.0, -5.7)
        p.lineTo(0.0, -1.0)
        p.lineTo(5.0, -5.7)
        p.lineTo(5.0, -24.3)
        p.closePath()
        addInstr(V3, p)
        p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
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
        addInstr(B1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(0.0, -29.0)
        p.lineTo(-15.0, -15.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -15.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopRhombusCircle = Symbol()
    val TopSphereRhombus = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        addInstr(SYMB, SubSymbol(TopRhombus, 1.0, 0.0, 0.0, null, null))
        val colours = Symbol()
        val p = Path2D.Double()
        p.moveTo(-14.0, -44.0)
        p.curveTo(-14.0, -62.7, 14.0, -62.7, 14.0, -44.0)
        p.curveTo(14.0, -25.3, -14.0, -25.3, -14.0, -44.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(ELPS, Ellipse2D.Double(-14.0, -58.0, 28.0, 28.0))
    }

    val TopT = Symbol()
    val TopTrapeziumU = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-20.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(20.0, -1.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-20.0, -1.0)
        p.lineTo(-13.0, -27.0)
        p.lineTo(13.0, -27.0)
        p.lineTo(20.0, -1.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopTrapeziumD = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-20.0, -27.0)
        p.lineTo(20.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-13.0, -1.0)
        p.lineTo(-20.0, -27.0)
        p.lineTo(20.0, -27.0)
        p.lineTo(13.0, -1.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopTriangle = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        p.moveTo(-10.0, -6.0)
        p.lineTo(0.0, -24.0)
        p.lineTo(10.0, -6.0)
        p.closePath()
        addInstr(B1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-15.0, -1.0)
        p.lineTo(0.0, -29.0)
        p.lineTo(15.0, -1.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopItriangle = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-20.0, -80.0, 40.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.windingRule = GeneralPath.WIND_EVEN_ODD
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        p.moveTo(-10.0, -24.0)
        p.lineTo(0.0, -6.0)
        p.lineTo(10.0, -24.0)
        p.closePath()
        addInstr(B1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        p = Path2D.Double()
        p.moveTo(-15.0, -29.0)
        p.lineTo(0.0, -1.0)
        p.lineTo(15.0, -29.0)
        p.closePath()
        addInstr(PLIN, p)
    }

    val TopTriangleCircle = Symbol()

    val TopWest = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        addInstr(P1, p)
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        addInstr(P2, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -10.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        p = Path2D.Double()
        p.moveTo(-15.0, -10.0)
        p.lineTo(0.0, -43.0)
        p.lineTo(15.0, -10.0)
        p.closePath()
        p.moveTo(-15.0, -78.0)
        p.lineTo(0.0, -45.0)
        p.lineTo(15.0, -78.0)
        p.closePath()
        addInstr(PLIN, p)
    }


    val TopX = Symbol().apply {
        addInstr(BBOX, Rectangle2D.Double(-30.0, -80.0, 60.0, 80.0))
        val colours = Symbol()
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
        addInstr(P1, p)
        addInstr(COLR, colours)
        addInstr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
        addInstr(FILL, black)
        addInstr(LINE, Line2D.Double(0.0, 0.0, 0.0, -27.0))
        addInstr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER))
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
        addInstr(PLIN, p)
    }

    val TopOther = Symbol()

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
        BoySHP.BOY_SUPR to Delta(Handle.BC, getTranslateInstance(0.0, -42.0)),
        BoySHP.BOY_ICE to Delta(Handle.BC, getTranslateInstance(0.0, -25.0)),
    )

    val FloatDelta = Delta(Handle.BC, getTranslateInstance(0.0, -42.0))

    val BeaconDelta = Delta(Handle.BC, getTranslateInstance(0.0, -70.0))

    val LightDelta = Delta(Handle.BC, getTranslateInstance(0.0, -20.0))

    val AllTopmarks: List<Symbol> = listOf(
        RadarReflector,
        TopBesom,
        TopIBesom,
        TopBoard,
        TopCan,
        TopCanSphere,
        TopCircle,
        TopCircleTriangle,
        TopCone,
        TopConeSphere,
        TopCross,
        TopCrosses,
        TopCrossCircle,
        TopCube,
        TopEast,
        TopFlag,
        TopIcone,
        TopIsol,
        TopMooring,
        TopNorth,
        TopSouth,
        TopSphere,
        TopSquare,
        TopRectangleH,
        TopRectangleV,
        TopRhombus,
        TopRhombusCircle,
        TopSphereRhombus,
        TopT,
        TopTrapeziumU,
        TopTrapeziumD,
        TopTriangle,
        TopItriangle,
        TopTriangleCircle,
        TopWest,
        TopX,
        TopOther,
    )
}
