// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.S57val
import s57.S57val.FncFNC
import java.awt.BasicStroke
import java.awt.geom.*


/**
 * @author Malcolm Herring
 */
object Landmarks {
    // CHECKSTYLE.OFF: LineLength
    private val Base = Symbols.Symbol()

    init {
        Base.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Base.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Base.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-35.0, 0.0, -10.0, 0.0)))
        Base.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(10.0, 0.0, 35.0, 0.0)))
    }

    val Chimney = Symbols.Symbol()

    init {
        Chimney.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        Chimney.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
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
        Chimney.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val Church = Symbols.Symbol()

    init {
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
        Church.add(Symbols.Instr(Symbols.Form.PGON, p))
    }


    val ChurchTower = Symbols.Symbol()

    init {
        ChurchTower.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        ChurchTower.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-36.0, -36.0, 72.0, 72.0)))
        ChurchTower.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-2.0, -2.0, 4.0, 4.0)))
    }

    val Cross = Symbols.Symbol()

    init {
        Cross.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        Cross.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Cross.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -150.0)))
        Cross.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-30.0, -115.0, 30.0, -115.0)))
    }

    val DishAerial = Symbols.Symbol()

    init {
        DishAerial.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        DishAerial.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL)))
        val p = Path2D.Double()
        p.moveTo(-7.8, -6.0)
        p.lineTo(0.0, -62.0)
        p.lineTo(7.8, -6.0)
        p.moveTo(18.0, -109.0)
        p.lineTo(25.0, -113.0)
        p.moveTo(-9.5, -157.0)
        p.curveTo(-60.7, -125.5, -16.5, -33.9, 44.9, -61.7)
        p.closePath()
        DishAerial.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val Dome = Symbols.Symbol()

    init {
        Dome.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Dome.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-36.0, -36.0, 72.0, 72.0)))
        Dome.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    val Flagstaff = Symbols.Symbol()

    init {
        Flagstaff.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        Flagstaff.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(0.0, -10.0)
        p.lineTo(0.0, -150.0)
        p.moveTo(0.0, -140.0)
        p.lineTo(40.0, -140.0)
        p.lineTo(40.0, -100.0)
        p.lineTo(0.0, -100.0)
        Flagstaff.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val FlareStack = Symbols.Symbol()

    init {
        FlareStack.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        FlareStack.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        var p = Path2D.Double()
        p.moveTo(-7.8, -6.0)
        p.lineTo(-7.8, -100.0)
        p.lineTo(7.8, -100.0)
        p.lineTo(7.8, -6.0)
        FlareStack.add(Symbols.Instr(Symbols.Form.PLIN, p))
        FlareStack.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        p = Path2D.Double()
        p.moveTo(21.6, -169.6)
        p.curveTo(-22.0, -132.4, -27.4, -103.5, 3.0, -100.0)
        p.curveTo(39.0, -118.0, -4.0, -141.0, 21.6, -169.6)
        FlareStack.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val LandTower = Symbols.Symbol()

    init {
        LandTower.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        LandTower.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        LandTower.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, 0.0, -15.0, -120.0)))
        LandTower.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(25.0, 0.0, 15.0, -120.0)))
        LandTower.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-15.0, -150.0, 30.0, 30.0)))
    }

    val Mast = Symbols.Symbol()

    init {
        Mast.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        Mast.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL)))
        val p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.lineTo(0.0, -150.0)
        p.lineTo(25.0, 0.0)
        Mast.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    val Monument = Symbols.Symbol()

    init {
        Monument.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        Monument.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Monument.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, 0.0, -15.0, -105.0)))
        Monument.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(25.0, 0.0, 15.0, -105.0)))
        Monument.add(
            Symbols.Instr(
                Symbols.Form.EARC,
                Arc2D.Double(-25.0, -150.0, 50.0, 50.0, 233.0, -285.0, Arc2D.OPEN)
            )
        )
    }


    val Platform = Symbols.Symbol()

    init {
        Platform.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Platform.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-48.0, -48.0, 96.0, 96.0)))
        Platform.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }


    val RadioTV = Symbols.Symbol()

    init {
        RadioTV.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL)))
        RadioTV.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-30.0, -180.0, 60.0, 60.0, 45.0, -90.0, Arc2D.OPEN)))
        RadioTV.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-45.0, -195.0, 90.0, 90.0, 45.0, -90.0, Arc2D.OPEN)))
        RadioTV.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-30.0, -180.0, 60.0, 60.0, 225.0, -90.0, Arc2D.OPEN)))
        RadioTV.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-45.0, -195.0, 90.0, 90.0, 225.0, -90.0, Arc2D.OPEN)))
    }

    val Spire = Symbols.Symbol()

    init {
        Spire.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Spire.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-25.0, -25.0, 50.0, 50.0)))
        Spire.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0)))
    }

    val Minaret = Symbols.Symbol()

    init {
        Minaret.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Spire, 1.0, 0.0, 0.0, null, null)))
        Minaret.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Minaret.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -25.0, 0.0, -50.0)))
        Minaret.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(6f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Minaret.add(Symbols.Instr(Symbols.Form.EARC, Arc2D.Double(-40.0, -110.0, 80.0, 60.0, 180.0, 180.0, Arc2D.OPEN)))
    }

    val Temple = Symbols.Symbol()

    init {
        Temple.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Temple.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-25.0, -15.0, 50.0, 30.0)))
        Temple.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Temple.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-35.0, -21.0, 35.0, 21.0)))
        Temple.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-35.0, 21.0, 35.0, -21.0)))
    }


    val WaterTower = Symbols.Symbol()

    init {
        WaterTower.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        WaterTower.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        WaterTower.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-25.0, 0.0, -15.0, -120.0)))
        WaterTower.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(25.0, 0.0, 15.0, -120.0)))
        WaterTower.add(Symbols.Instr(Symbols.Form.RECT, Rectangle2D.Double(-25.0, -150.0, 50.0, 30.0)))
    }

    val WindMotor = Symbols.Symbol()

    init {
        WindMotor.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        WindMotor.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        WindMotor.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -90.0)))
        WindMotor.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -90.0, 30.0, -90.0)))
        WindMotor.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -90.0, -14.0, -116.6)))
        WindMotor.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -90.0, -14.3, -66.7)))
    }

    val Windmill = Symbols.Symbol()

    init {
        Windmill.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Windmill.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-12.0, -12.0, 24.0, 24.0)))
        Windmill.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-30.0, -42.0, 30.0, 10.0)))
        Windmill.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-30.0, 10.0, 30.0, -42.0)))
    }

    val Windsock = Symbols.Symbol()

    init {
        Windsock.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Base, 1.0, 0.0, 0.0, null, null)))
        Windsock.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Windsock.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -10.0, 0.0, -100.0)))
        Windsock.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        Windsock.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -100.0, 0.0, -150.0)))
        Windsock.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
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
        Windsock.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }


    val Shapes = mapOf(
        S57val.CatLMK.LMK_CARN to Beacons.Cairn,
        S57val.CatLMK.LMK_CHMY to Chimney,
        S57val.CatLMK.LMK_DISH to DishAerial,
        S57val.CatLMK.LMK_FLAG to Flagstaff,
        S57val.CatLMK.LMK_FLAR to FlareStack,
        S57val.CatLMK.LMK_MAST to Mast,
        S57val.CatLMK.LMK_WNDS to Windsock,
        S57val.CatLMK.LMK_MNMT to Monument,
        S57val.CatLMK.LMK_CLMN to Monument,
        S57val.CatLMK.LMK_MEML to Monument,
        S57val.CatLMK.LMK_OBLK to Monument,
        S57val.CatLMK.LMK_STAT to Monument,
        S57val.CatLMK.LMK_CROS to Cross,
        S57val.CatLMK.LMK_DOME to Dome,
        S57val.CatLMK.LMK_RADR to Mast,
        S57val.CatLMK.LMK_TOWR to LandTower,
        S57val.CatLMK.LMK_WNDM to Windmill,
        S57val.CatLMK.LMK_WNDG to WindMotor,
        S57val.CatLMK.LMK_SPIR to Spire,
        S57val.CatLMK.LMK_BLDR to Beacons.Cairn,
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