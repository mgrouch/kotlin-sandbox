// License: GPL. For details, see LICENSE file.
package s57.symbols

import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.*
import java.awt.image.BufferedImage

/**
 * @author Malcolm Herring
 */
object Areas {
    // CHECKSTYLE.OFF: LineLength
    @JvmField
    val Plane = Symbols.Symbol()

    init {
        Plane.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-60.0, -60.0, 120.0, 120.0)))
        val p = Path2D.Double()
        p.moveTo(40.0, 20.0)
        p.lineTo(50.0, 10.0)
        p.lineTo(27.0, 13.3)
        p.lineTo(23.7, 6.8)
        p.lineTo(40.0, 5.0)
        p.curveTo(55.0, 4.0, 55.0, -9.0, 40.0, -10.0)
        p.quadTo(31.0, -11.0, 30.0, -15.0)
        p.lineTo(-30.0, 2.0)
        p.quadTo(-35.0, -12.0, -45.0, -15.0)
        p.quadTo(-56.0, -3.0, -50.0, 15.0)
        p.lineTo(18.4, 7.3)
        p.lineTo(21.7, 14.0)
        p.lineTo(-20.0, 20.0)
        p.closePath()
        Plane.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val Cable = Symbols.Symbol()

    init {
        Cable.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        Cable.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        Cable.add(Symbols.Instr(Symbols.Form.FILL, Color(0xc480ff)))
        val p = Path2D.Double()
        p.moveTo(0.0, 0.0)
        p.curveTo(-13.0, -13.0, -13.0, -17.0, 0.0, -30.0)
        p.curveTo(13.0, -43.0, 13.0, -47.0, 0.0, -60.0)
        Cable.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val CableDot = Symbols.Symbol()

    init {
        CableDot.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        CableDot.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-10.0, -40.0, 20.0, 20.0)))
    }

    @JvmField
    val CableDash = Symbols.Symbol()

    init {
        CableDash.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        CableDash.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        CableDash.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -15.0, 0.0, -45.0)))
    }

    @JvmField
    val CableFlash = Symbols.Symbol()

    init {
        CableFlash.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        val p = Path2D.Double()
        p.moveTo(-30.0, -25.0)
        p.lineTo(-10.0, -40.0)
        p.lineTo(10.0, -26.0)
        p.lineTo(30.0, -35.0)
        p.lineTo(10.0, -20.0)
        p.lineTo(-10.0, -34.0)
        p.closePath()
        CableFlash.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val LaneArrow = Symbols.Symbol()

    init {
        LaneArrow.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-20.0, -240.0, 40.0, 240.0)))
        LaneArrow.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        LaneArrow.add(Symbols.Instr(Symbols.Form.FILL, Symbols.Mtss))
        val p = Path2D.Double()
        p.moveTo(15.0, 0.0)
        p.lineTo(15.0, -195.0)
        p.lineTo(40.0, -195.0)
        p.lineTo(0.0, -240.0)
        p.lineTo(-40.0, -195.0)
        p.lineTo(-15.0, -195.0)
        p.lineTo(-15.0, 0.0)
        p.closePath()
        LaneArrow.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val LineAnchor = Symbols.Symbol()

    init {
        LineAnchor.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 90.0)))
        LineAnchor.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    Harbours.Anchor, 0.5, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(-90.0))
                    )
                )
            )
        )
    }

    @JvmField
    val LinePlane = Symbols.Symbol()

    init {
        LinePlane.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 90.0)))
        LinePlane.add(Symbols.Instr(Symbols.Form.FILL, Color(0xc480ff)))
        LinePlane.add(
            Symbols.Instr(
                Symbols.Form.SYMB, Symbols.SubSymbol(
                    Plane, 0.5, 0.0, 0.0, null, Symbols.Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(Math.toRadians(-90.0))
                    )
                )
            )
        )
    }

    @JvmField
    val MarineFarm = Symbols.Symbol()

    init {
        MarineFarm.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        val p = Path2D.Double()
        p.moveTo(-23.0, 12.0)
        p.lineTo(-23.0, 23.0)
        p.lineTo(23.0, 23.0)
        p.lineTo(23.0, 12.0)
        p.moveTo(-8.0, 15.0)
        p.lineTo(-8.0, 23.0)
        p.moveTo(8.0, 15.0)
        p.lineTo(8.0, 23.0)
        p.moveTo(-23.0, -12.0)
        p.lineTo(-23.0, -23.0)
        p.lineTo(23.0, -23.0)
        p.lineTo(23.0, -12.0)
        p.moveTo(-8.0, -15.0)
        p.lineTo(-8.0, -23.0)
        p.moveTo(8.0, -15.0)
        p.lineTo(8.0, -23.0)
        p.moveTo(-21.0, 8.0)
        p.quadTo(-1.0, -14.0, 21.0, 0.0)
        p.quadTo(-1.0, 14.0, -21.0, -8.0)
        p.moveTo(7.0, 6.0)
        p.quadTo(2.0, 0.0, 7.0, -6.0)
        MarineFarm.add(Symbols.Instr(Symbols.Form.PLIN, p))
        MarineFarm.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(9.0, -2.0, 4.0, 4.0)))
    }

    @JvmField
    val NoWake = Symbols.Symbol()

    init {
        NoWake.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(12f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoWake.add(Symbols.Instr(Symbols.Form.FILL, Color(0xa30075)))
        val p = Path2D.Double()
        p.moveTo(-60.0, 20.0)
        p.curveTo(-28.0, 20.0, -32.0, 0.0, 0.0, 0.0)
        p.curveTo(32.0, 0.0, 28.0, 20.0, 60.0, 20.0)
        p.moveTo(-60.0, 0.0)
        p.curveTo(-28.0, 0.0, -32.0, -20.0, 0.0, -20.0)
        p.curveTo(32.0, -20.0, 28.0, 0.0, 60.0, 0.0)
        NoWake.add(Symbols.Instr(Symbols.Form.PLIN, p))
        NoWake.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        NoWake.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-60.0, 60.0, 60.0, -60.0)))
        NoWake.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-60.0, -60.0, 60.0, 60.0)))
    }

    @JvmField
    val Pipeline = Symbols.Symbol()

    init {
        Pipeline.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-15.0, -60.0, 30.0, 60.0)))
        Pipeline.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Pipeline.add(Symbols.Instr(Symbols.Form.FILL, Color(0xc480ff)))
        Pipeline.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -50.0)))
        Pipeline.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-10.0, -60.0, 20.0, 20.0)))
    }

    @JvmField
    val Restricted = Symbols.Symbol()

    init {
        Restricted.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-15.0, -30.0, 30.0, 30.0)))
        Restricted.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Restricted.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 0.0, 0.0, -30.0)))
        Restricted.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -15.0, 17.0, -15.0)))
    }

    @JvmField
    val Rock = Symbols.Symbol()

    init {
        Rock.add(Symbols.Instr(Symbols.Form.FILL, Color(0x80c0ff)))
        Rock.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Rock.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        Rock.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        Rock.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        Rock.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Rock.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        Rock.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -20.0, 0.0, 20.0)))
    }

    @JvmField
    val RockA = Symbols.Symbol()

    init {
        RockA.add(Symbols.Instr(Symbols.Form.FILL, Color(0x80c0ff)))
        RockA.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        RockA.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        RockA.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        RockA.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        RockA.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        RockA.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        RockA.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -20.0, 0.0, 20.0)))
        RockA.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-17.0, -17.0, 8.0, 8.0)))
        RockA.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-17.0, 9.0, 8.0, 8.0)))
        RockA.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(9.0, -17.0, 8.0, 8.0)))
        RockA.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(9.0, 9.0, 8.0, 8.0)))
    }

    @JvmField
    val RockC = Symbols.Symbol()

    init {
        RockC.add(Symbols.Instr(Symbols.Form.FILL, Color(0x80c0ff)))
        RockC.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        RockC.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        RockC.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        RockC.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        RockC.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        RockC.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        RockC.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-10.0, 17.3, 10.0, -17.3)))
        RockC.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(10.0, 17.3, -10.0, -17.3)))
    }

    @JvmField
    val Seaplane = Symbols.Symbol()

    init {
        Seaplane.add(Symbols.Instr(Symbols.Form.BBOX, Rectangle2D.Double(-60.0, -60.0, 120.0, 120.0)))
        Seaplane.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Seaplane.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-58.0, -58.0, 116.0, 116.0)))
        Seaplane.add(Symbols.Instr(Symbols.Form.SYMB, Symbols.SubSymbol(Plane, 1.0, 0.0, 0.0, null, null)))
    }

    @JvmField
    val WindFarm = Symbols.Symbol()

    init {
        WindFarm.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        WindFarm.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-100.0, -100.0, 200.0, 200.0)))
        WindFarm.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-35.0, 50.0, 35.0, 50.0)))
        WindFarm.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, 50.0, 0.0, -27.5)))
        WindFarm.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -27.5, 30.0, -27.5)))
        WindFarm.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -27.5, -13.8, -3.8)))
        WindFarm.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -27.5, -13.8, -53.6)))
    }

    @JvmField
    val WreckD = Symbols.Symbol()

    init {
        WreckD.add(Symbols.Instr(Symbols.Form.FILL, Color(0x80c0ff)))
        WreckD.add(Symbols.Instr(Symbols.Form.RSHP, Ellipse2D.Double(-50.0, -40.0, 100.0, 80.0)))
        WreckD.add(
            Symbols.Instr(
                Symbols.Form.STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        WreckD.add(Symbols.Instr(Symbols.Form.FILL, Color.black))
        WreckD.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-50.0, -40.0, 100.0, 80.0)))
        WreckD.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        WreckD.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-40.0, 0.0, 40.0, 0.0)))
        WreckD.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -30.0, 0.0, 30.0)))
        WreckD.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, -15.0, -20.0, 15.0)))
        WreckD.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(20.0, -15.0, 20.0, 15.0)))
    }

    @JvmField
    val WreckND = Symbols.Symbol()

    init {
        WreckND.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        WreckND.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-40.0, 0.0, 40.0, 0.0)))
        WreckND.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(0.0, -30.0, 0.0, 30.0)))
        WreckND.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-20.0, -15.0, -20.0, 15.0)))
        WreckND.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(20.0, -15.0, 20.0, 15.0)))
    }

    @JvmField
    val WreckS = Symbols.Symbol()

    init {
        WreckS.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        WreckS.add(Symbols.Instr(Symbols.Form.ELPS, Ellipse2D.Double(-6.0, -6.0, 12.0, 12.0)))
        WreckS.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(-40.0, 0.0, -6.0, 0.0)))
        WreckS.add(Symbols.Instr(Symbols.Form.LINE, Line2D.Double(40.0, 0.0, 6.0, 0.0)))
        val p = Path2D.Double()
        p.moveTo(-30.0, 0.0)
        p.lineTo(-40.0, -25.0)
        p.lineTo(-0.3, -12.6)
        p.lineTo(13.7, -37.7)
        p.lineTo(16.3, -36.3)
        p.lineTo(2.7, -11.6)
        p.lineTo(37.5, 0.0)
        p.lineTo(6.0, 0.0)
        p.curveTo(5.6, -8.0, -5.6, -8.0, -6.0, 0.0)
        p.closePath()
        WreckS.add(Symbols.Instr(Symbols.Form.PGON, p))
    }

    @JvmField
    val Sandwaves = BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB)

    init {
        val g2 = Sandwaves.createGraphics()
        g2.setStroke(BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        g2.setBackground(Color(0, true))
        g2.clearRect(0, 0, 100, 100)
        g2.setPaint(Color(0xffd400))
        val p = Path2D.Double()
        p.moveTo(0.0, 34.5)
        p.lineTo(03.3, 30.8)
        p.lineTo(09.9, 19.3)
        p.lineTo(13.2, 16.0)
        p.lineTo(16.5, 16.1)
        p.lineTo(18.2, 19.5)
        p.lineTo(19.9, 25.0)
        p.lineTo(21.6, 30.3)
        p.lineTo(23.3, 33.4)
        p.lineTo(25.0, 33.3)
        p.lineTo(28.3, 30.1)
        p.lineTo(31.6, 25.0)
        p.lineTo(34.9, 20.1)
        p.lineTo(38.2, 17.2)
        p.lineTo(41.5, 17.3)
        p.lineTo(43.2, 20.3)
        p.lineTo(44.9, 25.0)
        p.lineTo(46.6, 29.6)
        p.lineTo(48.3, 32.2)
        p.lineTo(50.0, 32.1)
        p.moveTo(50.0, 84.5)
        p.lineTo(53.3, 80.8)
        p.lineTo(56.6, 75.0)
        p.lineTo(59.9, 69.3)
        p.lineTo(63.2, 66.0)
        p.lineTo(66.5, 66.1)
        p.lineTo(68.2, 69.5)
        p.lineTo(69.9, 75.0)
        p.lineTo(71.6, 80.3)
        p.lineTo(73.3, 83.4)
        p.lineTo(75.0, 83.3)
        p.lineTo(78.3, 80.1)
        p.lineTo(81.6, 75.0)
        p.lineTo(84.9, 70.1)
        p.lineTo(88.2, 67.2)
        p.lineTo(91.5, 67.3)
        p.lineTo(93.2, 70.3)
        p.lineTo(94.9, 75.0)
        p.lineTo(96.6, 79.6)
        p.lineTo(98.3, 82.2)
        p.lineTo(100.0, 82.1)
        g2.draw(p)
    }

    @JvmField
    val KelpS = Symbols.Symbol()

    init {
        KelpS.add(Symbols.Instr(Symbols.Form.STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        val p = Path2D.Double()
        p.moveTo(-60.0, 0.0)
        p.curveTo(-20.0, -20.0, -24.0, 40.0, 24.0, 20.0)
        p.moveTo(-60.0, 0.0)
        p.quadTo(-48.0, 20.0, -32.0, 12.0)
        p.moveTo(-36.0, -4.0)
        p.quadTo(-24.0, -24.0, -4.0, -16.0)
        p.quadTo(8.0, -32.0, 20.0, -24.0)
        p.moveTo(-4.0, -16.0)
        p.quadTo(8.0, 0.0, 20.0, -8.0)
        p.moveTo(-8.0, 20.0)
        p.quadTo(12.0, 0.0, 36.0, 8.0)
        p.quadTo(48.0, 24.0, 60.0, 16.0)
        p.moveTo(36.0, 8.0)
        p.quadTo(48.0, -8.0, 60.0, 0.0)
        KelpS.add(Symbols.Instr(Symbols.Form.PLIN, p))
    }

    @JvmField
    val KelpA = BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB)

    init {
        val g2 = KelpA.createGraphics()
        g2.setStroke(BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND))
        g2.setBackground(Color(0, true))
        g2.clearRect(0, 0, 240, 240)
        g2.setPaint(Color.black)
        val p = Path2D.Double()
        p.moveTo(0.0, 60.0)
        p.curveTo(40.0, 40.0, 44.0, 100.0, 84.0, 80.0)
        p.moveTo(0.0, 60.0)
        p.quadTo(12.0, 80.0, 28.0, 72.0)
        p.moveTo(24.0, 56.0)
        p.quadTo(36.0, 36.0, 56.0, 44.0)
        p.quadTo(68.0, 28.0, 80.0, 36.0)
        p.moveTo(56.0, 44.0)
        p.quadTo(68.0, 60.0, 80.0, 52.0)
        p.moveTo(52.0, 76.0)
        p.quadTo(72.0, 60.0, 96.0, 68.0)
        p.quadTo(108.0, 84.0, 120.0, 76.0)
        p.moveTo(96.0, 68.0)
        p.quadTo(108.0, 52.0, 120.0, 60.0)
        p.moveTo(120.0, 180.0)
        p.curveTo(160.0, 160.0, 164.0, 220.0, 204.0, 200.0)
        p.moveTo(120.0, 180.0)
        p.quadTo(132.0, 200.0, 148.0, 192.0)
        p.moveTo(144.0, 176.0)
        p.quadTo(156.0, 156.0, 176.0, 164.0)
        p.quadTo(188.0, 148.0, 200.0, 156.0)
        p.moveTo(176.0, 164.0)
        p.quadTo(188.0, 180.0, 200.0, 172.0)
        p.moveTo(172.0, 196.0)
        p.quadTo(192.0, 180.0, 216.0, 188.0)
        p.quadTo(228.0, 204.0, 240.0, 196.0)
        p.moveTo(216.0, 188.0)
        p.quadTo(228.0, 172.0, 240.0, 180.0)
        g2.draw(p)
    }
}