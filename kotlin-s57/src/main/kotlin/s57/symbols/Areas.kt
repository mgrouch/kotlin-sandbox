// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.deg2rad
import s57.symbols.Symbols.Delta
import s57.symbols.Symbols.Form.*
import s57.symbols.Symbols.Instr
import s57.symbols.Symbols.SubSymbol
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.*
import java.awt.image.BufferedImage

/**
 * @author Malcolm Herring
 */
object Areas {

    val Plane = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-60.0, -60.0, 120.0, 120.0)))
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
        add(Instr(PGON, p))
    }

    val Cable = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        add(Instr(STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        add(Instr(FILL, Color(0xc480ff)))
        val p = Path2D.Double()
        p.moveTo(0.0, 0.0)
        p.curveTo(-13.0, -13.0, -13.0, -17.0, 0.0, -30.0)
        p.curveTo(13.0, -43.0, 13.0, -47.0, 0.0, -60.0)
        add(Instr(PLIN, p))
    }

    val CableDot = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        add(Instr(RSHP, Ellipse2D.Double(-10.0, -40.0, 20.0, 20.0)))
    }

    val CableDash = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        add(Instr(STRK, BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)))
        add(Instr(LINE, Line2D.Double(0.0, -15.0, 0.0, -45.0)))
    }

    val CableFlash = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 60.0)))
        val p = Path2D.Double()
        p.moveTo(-30.0, -25.0)
        p.lineTo(-10.0, -40.0)
        p.lineTo(10.0, -26.0)
        p.lineTo(30.0, -35.0)
        p.lineTo(10.0, -20.0)
        p.lineTo(-10.0, -34.0)
        p.closePath()
        add(Instr(PGON, p))
    }

    val LaneArrow = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-20.0, -240.0, 40.0, 240.0)))
        add(Instr(STRK, BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
        add(Instr(FILL, Symbols.Mtss))
        val p = Path2D.Double()
        p.moveTo(15.0, 0.0)
        p.lineTo(15.0, -195.0)
        p.lineTo(40.0, -195.0)
        p.lineTo(0.0, -240.0)
        p.lineTo(-40.0, -195.0)
        p.lineTo(-15.0, -195.0)
        p.lineTo(-15.0, 0.0)
        p.closePath()
        add(Instr(PLIN, p))
    }

    val LineAnchor = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 90.0)))
        add(Instr(SYMB, SubSymbol(
                    Harbours.Anchor, 0.5, 0.0, 0.0, null, Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(deg2rad(-90.0))
                    )
                )
            )
        )
    }

    val LinePlane = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-30.0, -60.0, 60.0, 90.0)))
        add(Instr(FILL, Color(0xc480ff)))
        add(Instr(SYMB, SubSymbol(
                    Plane, 0.5, 0.0, 0.0, null, Delta(
                        Symbols.Handle.CC, AffineTransform.getRotateInstance(deg2rad(-90.0))
                    )
                )
            )
        )
    }

    val MarineFarm = Symbol().apply {
        add(Instr(STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
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
        add(Instr(PLIN, p))
        add(Instr(RSHP, Ellipse2D.Double(9.0, -2.0, 4.0, 4.0)))
    }

    val NoWake = Symbol().apply {
        add(Instr(STRK, BasicStroke(12f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(FILL, Color(0xa30075)))
        val p = Path2D.Double()
        p.moveTo(-60.0, 20.0)
        p.curveTo(-28.0, 20.0, -32.0, 0.0, 0.0, 0.0)
        p.curveTo(32.0, 0.0, 28.0, 20.0, 60.0, 20.0)
        p.moveTo(-60.0, 0.0)
        p.curveTo(-28.0, 0.0, -32.0, -20.0, 0.0, -20.0)
        p.curveTo(32.0, -20.0, 28.0, 0.0, 60.0, 0.0)
        add(Instr(PLIN, p))
        add(Instr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(LINE, Line2D.Double(-60.0, 60.0, 60.0, -60.0)))
        add(Instr(LINE, Line2D.Double(-60.0, -60.0, 60.0, 60.0)))
    }

    val Pipeline = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-15.0, -60.0, 30.0, 60.0)))
        add(Instr(STRK, BasicStroke(8f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        add(Instr(FILL, Color(0xc480ff)))
        add(Instr(LINE, Line2D.Double(0.0, 0.0, 0.0, -50.0)))
        add(Instr(RSHP, Ellipse2D.Double(-10.0, -60.0, 20.0, 20.0)))
    }

    val Restricted = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-15.0, -30.0, 30.0, 30.0)))
        add(Instr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        add(Instr(LINE, Line2D.Double(0.0, 0.0, 0.0, -30.0)))
        add(Instr(LINE, Line2D.Double(0.0, -15.0, 17.0, -15.0)))
    }

    val Rock = Symbol().apply {
        add(Instr(FILL, Color(0x80c0ff)))
        add(Instr(RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(STRK, BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        add(Instr(FILL, Color.black))
        add(Instr(ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        add(Instr(LINE, Line2D.Double(0.0, -20.0, 0.0, 20.0)))
    }

    val RockA = Symbol().apply {
        add(Instr(FILL, Color(0x80c0ff)))
        add(Instr(RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        add(Instr(FILL, Color.black))
        add(Instr(ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        add(Instr(LINE, Line2D.Double(0.0, -20.0, 0.0, 20.0)))
        add(Instr(RSHP, Ellipse2D.Double(-17.0, -17.0, 8.0, 8.0)))
        add(Instr(RSHP, Ellipse2D.Double(-17.0, 9.0, 8.0, 8.0)))
        add(Instr(RSHP, Ellipse2D.Double(9.0, -17.0, 8.0, 8.0)))
        add(Instr(RSHP, Ellipse2D.Double(9.0, 9.0, 8.0, 8.0)))
    }

    val RockC = Symbol().apply {
        add(Instr(FILL, Color(0x80c0ff)))
        add(Instr(RSHP, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        add(Instr(FILL, Color.black))
        add(Instr(ELPS, Ellipse2D.Double(-30.0, -30.0, 60.0, 60.0)))
        add(Instr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(LINE, Line2D.Double(-20.0, 0.0, 20.0, 0.0)))
        add(Instr(LINE, Line2D.Double(-10.0, 17.3, 10.0, -17.3)))
        add(Instr(LINE, Line2D.Double(10.0, 17.3, -10.0, -17.3)))
    }

    val Seaplane = Symbol().apply {
        add(Instr(BBOX, Rectangle2D.Double(-60.0, -60.0, 120.0, 120.0)))
        add(Instr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(ELPS, Ellipse2D.Double(-58.0, -58.0, 116.0, 116.0)))
        add(Instr(SYMB, SubSymbol(Plane, 1.0, 0.0, 0.0, null, null)))
    }

    val WindFarm = Symbol().apply {
        add(Instr(STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(ELPS, Ellipse2D.Double(-100.0, -100.0, 200.0, 200.0)))
        add(Instr(LINE, Line2D.Double(-35.0, 50.0, 35.0, 50.0)))
        add(Instr(LINE, Line2D.Double(0.0, 50.0, 0.0, -27.5)))
        add(Instr(LINE, Line2D.Double(0.0, -27.5, 30.0, -27.5)))
        add(Instr(LINE, Line2D.Double(0.0, -27.5, -13.8, -3.8)))
        add(Instr(LINE, Line2D.Double(0.0, -27.5, -13.8, -53.6)))
    }

    val WreckD = Symbol().apply {
        add(Instr(FILL, Color(0x80c0ff)))
        add(Instr(RSHP, Ellipse2D.Double(-50.0, -40.0, 100.0, 80.0)))
        add(Instr(STRK,
                BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, floatArrayOf(5f, 5f), 0f)
            )
        )
        add(Instr(FILL, Color.black))
        add(Instr(ELPS, Ellipse2D.Double(-50.0, -40.0, 100.0, 80.0)))
        add(Instr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(LINE, Line2D.Double(-40.0, 0.0, 40.0, 0.0)))
        add(Instr(LINE, Line2D.Double(0.0, -30.0, 0.0, 30.0)))
        add(Instr(LINE, Line2D.Double(-20.0, -15.0, -20.0, 15.0)))
        add(Instr(LINE, Line2D.Double(20.0, -15.0, 20.0, 15.0)))
    }

    val WreckND = Symbol().apply {
        add(Instr(STRK, BasicStroke(5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(LINE, Line2D.Double(-40.0, 0.0, 40.0, 0.0)))
        add(Instr(LINE, Line2D.Double(0.0, -30.0, 0.0, 30.0)))
        add(Instr(LINE, Line2D.Double(-20.0, -15.0, -20.0, 15.0)))
        add(Instr(LINE, Line2D.Double(20.0, -15.0, 20.0, 15.0)))
    }

    val WreckS = Symbol().apply {
        add(Instr(STRK, BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        add(Instr(ELPS, Ellipse2D.Double(-6.0, -6.0, 12.0, 12.0)))
        add(Instr(LINE, Line2D.Double(-40.0, 0.0, -6.0, 0.0)))
        add(Instr(LINE, Line2D.Double(40.0, 0.0, 6.0, 0.0)))
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
        add(Instr(PGON, p))
    }

    val Sandwaves = BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).apply {
        val g2 = createGraphics()
        g2.stroke = BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
        g2.background = Color(0, true)
        g2.clearRect(0, 0, 100, 100)
        g2.paint = Color(0xffd400)
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

    val KelpS = Symbol().apply {
        add(Instr(STRK, BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER)))
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
        add(Instr(PLIN, p))
    }

    val KelpA = BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB).apply {
        val g2 = createGraphics()
        g2.stroke = BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
        g2.background = Color(0, true)
        g2.clearRect(0, 0, 240, 240)
        g2.paint = Color.black
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