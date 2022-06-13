// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.S57val.CatLMK
import s57.S57val.FncFNC
import s57.symbols.Symbols.Form
import s57.symbols.Symbols.Instr
import s57.symbols.Symbols.SubSymbol
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.geom.*

/**
 * @author Malcolm Herring
 */
object Landmarks {

    private val Base = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        add(Instr(Form.LINE, Line2D.Double(-35.0, 0.0, -10.0, 0.0)))
        add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 35.0, 0.0)))
    }

    val Chimney = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(-10.0, -120.0)
        p.lineTo(10.0, -120.0)
        p.lineTo(25.0, 0.0)
        p.moveTo(-10.0, -128.0)
        p.curveTo(-13.0, -147.0, 15.0, -159.0, 20.0, -148.0)
        p.moveTo(16.0, -152.3)
        p.curveTo(58.0, -194.0, 98.0, -87.0, 16.0, -132.0)
        p.moveTo(11.0, -128.0)
        p.curveTo(13.4, -132.0, 20.0, -132.0, 20.0, -136.0)
        add(Instr(Form.PLIN, p))
    }

    val Church = Symbol().apply {
        val p = Path2D.Double()
        p.moveTo(10.0, -10.0)
        p.lineTo(37.0, -10.0)
        p.quadTo(48.0, -10.0, 48.0, -21.0)
        p.lineTo(50.0, -21.0)
        p.lineTo(50.0, 21.0)
        p.lineTo(48.0, 21.0)
        p.quadTo(48.0, 10.0, 37.0, 10.0)
        p.lineTo(10.0, 10.0)
        p.lineTo(10.0, 37.0)
        p.quadTo(10.0, 48.0, 21.0, 48.0)
        p.lineTo(21.0, 50.0)
        p.lineTo(-21.0, 50.0)
        p.lineTo(-21.0, 48.0)
        p.quadTo(-10.0, 48.0, -10.0, 37.0)
        p.lineTo(-10.0, 10.0)
        p.lineTo(-37.0, 10.0)
        p.quadTo(-48.0, 10.0, -48.0, 21.0)
        p.lineTo(-50.0, 21.0)
        p.lineTo(-50.0, -21.0)
        p.lineTo(-48.0, -21.0)
        p.quadTo(-48.0, -10.0, -37.0, -10.0)
        p.lineTo(-10.0, -10.0)
        p.lineTo(-10.0, -37.0)
        p.quadTo(-10.0, -48.0, -21.0, -48.0)
        p.lineTo(-21.0, -50.0)
        p.lineTo(21.0, -50.0)
        p.lineTo(21.0, -48.0)
        p.quadTo(10.0, -48.0, 10.0, -37.0)
        p.closePath()
        add(Instr(Form.PGON, p))
    }

    val ChurchTower = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.RECT, Rectangle2D.Double(-36.0, -36.0, 72.0, 72.0)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-2.0, -2.0, 4.0, 4.0)))
    }

    val Cross = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -150.0)))
        add(Instr(Form.LINE, Line2D.Double(-30.0, -115.0, 30.0, -115.0)))
    }

    val DishAerial = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL)))
        val p = Path2D.Double()
        p.moveTo(-7.8, -6.0)
        p.lineTo(0.0, -62.0)
        p.lineTo(7.8, -6.0)
        p.moveTo(18.0, -109.0)
        p.lineTo(25.0, -113.0)
        p.moveTo(-9.5, -157.0)
        p.curveTo(-60.7, -125.5, -16.5, -33.9, 44.9, -61.7)
        p.closePath()
        add(Instr(Form.PLIN, p))
    }

    val Dome = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-36.0, -36.0, 72.0, 72.0)))
        add(Instr(Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    val Flagstaff = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(0.0, -150.0)
        p.moveTo(0.0, -140.0)
        p.lineTo(40.0, -140.0)
        p.lineTo(40.0, -100.0)
        p.lineTo(0.0, -100.0)
        add(Instr(Form.PLIN, p))
    }

    val FlareStack = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        var p = Path2D.Double()
        p.moveTo(-7.8, -6.0)
        p.lineTo(-7.8, -100.0)
        p.lineTo(7.8, -100.0)
        p.lineTo(7.8, -6.0)
        add(Instr(Form.PLIN, p))
        add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(21.6, -169.6)
        p.curveTo(-22.0, -132.4, -27.4, -103.5, 3.0, -100.0)
        p.curveTo(39.0, -118.0, -4.0, -141.0, 21.6, -169.6)
        add(Instr(Form.PLIN, p))
    }

    val LandTower = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(-25.0, 0.0, -15.0, -120.0)))
        add(Instr(Form.LINE, Line2D.Double(25.0, 0.0, 15.0, -120.0)))
        add(Instr(Form.RECT, Rectangle2D.Double(-15.0, -150.0, 30.0, 30.0)))
    }

    val Mast = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL)))
        val p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(0.0, -150.0)
        p.lineTo(25.0, 0.0)
        add(Instr(Form.PLIN, p))
    }

    val Monument = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(-25.0, 0.0, -15.0, -105.0)))
        add(Instr(Form.LINE, Line2D.Double(25.0, 0.0, 15.0, -105.0)))
        add(Instr(Form.EARC, Arc2D.Double(-25.0, -150.0, 50.0, 50.0, 233.0, -285.0, Arc2D.OPEN)))
    }

    val Platform = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.RECT, Rectangle2D.Double(-48.0, -48.0, 96.0, 96.0)))
        add(Instr(Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    val RadioTV = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL)))
        add(Instr(Form.EARC, Arc2D.Double(-30.0, -180.0, 60.0, 60.0, 45.0, -90.0, Arc2D.OPEN)))
        add(Instr(Form.EARC, Arc2D.Double(-45.0, -195.0, 90.0, 90.0, 45.0, -90.0, Arc2D.OPEN)))
        add(Instr(Form.EARC, Arc2D.Double(-30.0, -180.0, 60.0, 60.0, 225.0, -90.0, Arc2D.OPEN)))
        add(Instr(Form.EARC, Arc2D.Double(-45.0, -195.0, 90.0, 90.0, 225.0, -90.0, Arc2D.OPEN)))
    }

    val Spire = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        add(Instr(Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    val Minaret = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Spire, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -25.0, 0.0, -50.0)))
        add(Instr(Form.STRK, BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.EARC, Arc2D.Double(-40.0, -110.0, 80.0, 60.0, 180.0, 180.0, Arc2D.OPEN)))
    }

    val Temple = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.RECT, Rectangle2D.Double(-25.0, -15.0, 50.0, 30.0)))
        add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(-35.0, -21.0, 35.0, 21.0)))
        add(Instr(Form.LINE, Line2D.Double(-35.0, 21.0, 35.0, -21.0)))
    }

    val WaterTower = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(-25.0, 0.0, -15.0, -120.0)))
        add(Instr(Form.LINE, Line2D.Double(25.0, 0.0, 15.0, -120.0)))
        add(Instr(Form.RECT, Rectangle2D.Double(-25.0, -150.0, 50.0, 30.0)))
    }

    val WindMotor = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -90.0)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -90.0, 30.0, -90.0)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -90.0, -14.0, -116.6)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -90.0, -14.3, -66.7)))
    }

    val Windmill = Symbol().apply {
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(Form.ELPS, Ellipse2D.Double(-12.0, -12.0, 24.0, 24.0)))
        add(Instr(Form.LINE, Line2D.Double(-30.0, -42.0, 30.0, 10.0)))
        add(Instr(Form.LINE, Line2D.Double(-30.0, 10.0, 30.0, -42.0)))
    }

    val Windsock = Symbol().apply {
        add(Instr(Form.SYMB, SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -100.0)))
        add(Instr(Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(Form.LINE, Line2D.Double(0.0, -100.0, 0.0, -150.0)))
        add(Instr(Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        val p = Path2D.Double()
        p.moveTo(0.0, -100.0)
        p.lineTo(10.0, -100.0)
        p.lineTo(10.0, -150.0)
        p.lineTo(0.0, -150.0)
        p.moveTo(10.0, -150.0)
        p.lineTo(50.0, -145.0)
        p.lineTo(120.0, -70.0)
        p.quadTo(120.0, -55.0, 105.0, -55.0)
        p.lineTo(55.0, -95.0)
        p.lineTo(40.0, -102.0)
        p.lineTo(10.0, -100.0)
        p.moveTo(40.0, -102.0)
        p.lineTo(50.0, -120.0)
        p.moveTo(55.0, -95.0)
        p.lineTo(75.0, -97.0)
        add(Instr(Form.PLIN, p))
    }

    val Shapes = mapOf(
        CatLMK.LMK_CARN to Beacons.Cairn,
        CatLMK.LMK_CHMY to Chimney,
        CatLMK.LMK_DISH to DishAerial,
        CatLMK.LMK_FLAG to Flagstaff,
        CatLMK.LMK_FLAR to FlareStack,
        CatLMK.LMK_MAST to Mast,
        CatLMK.LMK_WNDS to Windsock,
        CatLMK.LMK_MNMT to Monument,
        CatLMK.LMK_CLMN to Monument,
        CatLMK.LMK_MEML to Monument,
        CatLMK.LMK_OBLK to Monument,
        CatLMK.LMK_STAT to Monument,
        CatLMK.LMK_CROS to Cross,
        CatLMK.LMK_DOME to Dome,
        CatLMK.LMK_RADR to Mast,
        CatLMK.LMK_TOWR to LandTower,
        CatLMK.LMK_WNDM to Windmill,
        CatLMK.LMK_WNDG to WindMotor,
        CatLMK.LMK_SPIR to Spire,
        CatLMK.LMK_BLDR to Beacons.Cairn,
    )

    val Funcs = mapOf(
        FncFNC.FNC_CHCH to Church,
        FncFNC.FNC_CHPL to Church,
        FncFNC.FNC_TMPL to Temple,
        FncFNC.FNC_PGDA to Temple,
        FncFNC.FNC_SHSH to Temple,
        FncFNC.FNC_BTMP to Temple,
        FncFNC.FNC_MOSQ to Minaret,
        FncFNC.FNC_MRBT to Spire,
        FncFNC.FNC_COMM to RadioTV,
        FncFNC.FNC_TV to RadioTV,
        FncFNC.FNC_RADO to RadioTV,
        FncFNC.FNC_RADR to RadioTV,
        FncFNC.FNC_LGHT to Beacons.LightMajor,
        FncFNC.FNC_MCWV to RadioTV,
        FncFNC.FNC_HBRM to Harbours.HarbourMaster,
        FncFNC.FNC_CSTM to Harbours.Customs,
        FncFNC.FNC_HLTH to Harbours.Hospital,
        FncFNC.FNC_HOSP to Harbours.Hospital,
    )
}