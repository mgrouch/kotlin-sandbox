// License: GPL. For details, see LICENSE file.
package s57.symbols

import s57.S57val.BoySHP
import s57.symbols.Symbols.Form
import s57.symbols.Symbols.Instr
import s57.symbols.Symbols.Symbol

import java.awt.BasicStroke
import java.awt.Color
import java.awt.geom.Arc2D
import java.awt.geom.Ellipse2D
import java.awt.geom.Line2D
import java.awt.geom.Path2D

/**
 * @author Malcolm Herring
 */
object Buoys {

    val Barrel = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-50.0, 0.0)
        p.curveTo(-50.0, -11.0, -45.0, -32.0, -32.0, -36.0)
        p.curveTo(-18.0, -40.0, 12.0, -40.0, 25.0, -36.0)
        p.curveTo(38.0, -32.0, 43.0, -11.0, 43.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        Barrel.add(Instr(Form.COLR, colours))
        Barrel.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Barrel.add(Instr(Form.FILL, Color.black))
        Barrel.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Barrel.add(Instr(Form.LINE, Line2D.Double(-57.0, 0.0, -10.0, 0.0)))
        Barrel.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 50.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-50.0, 0.0)
        p.curveTo(-50.0, -11.0, -45.0, -32.0, -32.0, -36.0)
        p.curveTo(-18.0, -40.0, 12.0, -40.0, 25.0, -36.0)
        p.curveTo(38.0, -32.0, 43.0, -11.0, 43.0, 0.0)
        p.moveTo(-32.0, -36.0)
        p.curveTo(-23.0, -25.0, -21.0, -12.0, -21.0, 0.0)
        Barrel.add(Instr(Form.PLIN, p))
    }

    val Can = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-31.6, 0.0)
        p.lineTo(-15.7, -47.4)
        p.lineTo(41.1, -28.4)
        p.lineTo(31.6, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-31.6, 0.0)
        p.lineTo(-22.0, -28.4)
        p.lineTo(34.8, -9.4)
        p.lineTo(31.6, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-24.2, -22.1)
        p.lineTo(-19.9, -34.8)
        p.lineTo(36.9, -15.8)
        p.lineTo(32.6, -3.1)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-22.0, -28.4)
        p.lineTo(-18.9, -37.9)
        p.lineTo(37.9, -18.9)
        p.lineTo(34.8, -9.4)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-25.2, -19.0)
        p.lineTo(-22.0, -28.4)
        p.lineTo(34.8, -9.4)
        p.lineTo(31.6, 0.0)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(12.7, -37.9)
        p.lineTo(41.1, -28.4)
        p.lineTo(31.6, 0.0)
        p.lineTo(8.0, 0.0)
        p.quadTo(8.0, -6.0, 2.5, -7.6)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Can.add(Instr(Form.COLR, colours))
        Can.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Can.add(Instr(Form.FILL, Color.black))
        Can.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Can.add(Instr(Form.LINE, Line2D.Double(-40.0, 0.0, -10.0, 0.0)))
        Can.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 40.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-31.6, 0.0)
        p.lineTo(-15.7, -47.4)
        p.lineTo(41.1, -28.4)
        p.lineTo(31.6, 0.0)
        Can.add(Instr(Form.PLIN, p))
    }

    val Cone = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-31.6, 0.0)
        p.curveTo(-24.9, -32.2, 1.4, -38.7, 12.7, -37.9)
        p.curveTo(21.9, -30.5, 32.8, -18.4, 32.1, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-31.6, 0.0)
        p.quadTo(-29.0, -15.5, -17.3, -26.9)
        p.lineTo(31.5, -10.5)
        p.quadTo(33.0, -5.0, 32.1, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-22.3, -21.4)
        p.quadTo(-15.2, -29.8, -10.8, -31.8)
        p.lineTo(28.8, -18.5)
        p.quadTo(31.8, -12.5, 32.6, -3.1)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-17.3, -27.0)
        p.quadTo(-13.0, -31.4, -6.9, -33.8)
        p.lineTo(26.4, -22.7)
        p.quadTo(30.0, -17.0, 31.7, -10.3)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-24.4, -18.7)
        p.quadTo(-20.3, -25.0, -17.3, -27.0)
        p.lineTo(31.7, -10.3)
        p.quadTo(32.7, -4.5, 32.1, 0.0)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(12.7, -37.9)
        p.curveTo(21.9, -30.5, 32.8, -18.4, 32.1, 0.0)
        p.lineTo(8.0, 0.0)
        p.quadTo(8.0, -6.0, 2.5, -7.6)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Cone.add(Instr(Form.COLR, colours))
        Cone.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Cone.add(Instr(Form.FILL, Color.black))
        Cone.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Cone.add(Instr(Form.LINE, Line2D.Double(-40.0, 0.0, -10.0, 0.0)))
        Cone.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 40.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-31.6, 0.0)
        p.curveTo(-24.9, -32.2, 1.4, -38.7, 12.7, -37.9)
        p.curveTo(21.9, -30.5, 32.8, -18.4, 32.1, 0.0)
        Cone.add(Instr(Form.PLIN, p))
    }


    val Float = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-36.0, 0.0)
        p.lineTo(-47.0, -33.0)
        p.quadTo(-30.0, -25.0, -19.0, -23.0)
        p.lineTo(-12.0, -42.0)
        p.lineTo(12.0, -42.0)
        p.lineTo(19.0, -23.0)
        p.quadTo(30.0, -25.0, 47.0, -33.0)
        p.lineTo(36.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-36.0, 0.0)
        p.lineTo(-43.0, -21.0)
        p.lineTo(43.0, -21.0)
        p.lineTo(36.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-40.8, -14.0)
        p.lineTo(-45.4, -28.0)
        p.lineTo(-35.5, -28.0)
        p.quadTo(-28.0, -25.0, -19.0, -23.0)
        p.lineTo(-17.2, -28.0)
        p.lineTo(17.2, -28.0)
        p.lineTo(19.0, -23.0)
        p.quadTo(28.0, -25.0, 35.5, -28.0)
        p.lineTo(45.4, -28.0)
        p.lineTo(40.8, -14.0)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-43.0, -21.0)
        p.lineTo(-47.0, -33.0)
        p.quadTo(-29.7, -24.8, -19.0, -23.0)
        p.lineTo(-15.8, -31.5)
        p.lineTo(15.8, -31.5)
        p.lineTo(19.0, -23.0)
        p.quadTo(28.4, -24.3, 47.0, -33.0)
        p.lineTo(43.0, -21.0)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-39.8, -11.5)
        p.lineTo(-43.0, -21.0)
        p.lineTo(43.0, -21.0)
        p.lineTo(39.8, -11.5)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -42.0)
        p.lineTo(12.0, -42.0)
        p.lineTo(19.0, -23.0)
        p.quadTo(28.4, -24.3, 47.0, -33.0)
        p.lineTo(36.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.quadTo(7.7, -7.7, 0.0, -8.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Float.add(Instr(Form.COLR, colours))
        Float.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Float.add(Instr(Form.FILL, Color.black))
        Float.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Float.add(Instr(Form.LINE, Line2D.Double(-54.0, 0.0, -10.0, 0.0)))
        Float.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 54.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-36.0, 0.0)
        p.lineTo(-47.0, -33.0)
        p.curveTo(-15.0, -17.0, 15.0, -17.0, 47.0, -33.0)
        p.lineTo(36.0, 0.0)
        p.moveTo(-19.0, -23.0)
        p.lineTo(-12.0, -42.0)
        p.lineTo(12.0, -42.0)
        p.lineTo(19.0, -23.0)
        Float.add(Instr(Form.PLIN, p))
    }

    val Ice = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.quadTo(-30.0, 0.0, -30.0, -15.0)
        p.lineTo(-30.0, -25.0)
        p.lineTo(30.0, -25.0)
        p.lineTo(30.0, -15.0)
        p.quadTo(30.0, 0.0, 15.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        Ice.add(Instr(Form.COLR, colours))
        Ice.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Ice.add(Instr(Form.FILL, Color.black))
        Ice.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Ice.add(Instr(Form.LINE, Line2D.Double(-35.0, 0.0, -10.0, 0.0)))
        Ice.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 35.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-15.0, 0.0)
        p.quadTo(-30.0, 0.0, -30.0, -15.0)
        p.lineTo(-30.0, -25.0)
        p.lineTo(30.0, -25.0)
        p.lineTo(30.0, -15.0)
        p.quadTo(30.0, 0.0, 15.0, 0.0)
        Ice.add(Instr(Form.PLIN, p))
        p = Path2D.Double()
        p.moveTo(-6.0, 8.0)
        p.lineTo(-6.0, 40.0)
        p.lineTo(6.0, 40.0)
        p.lineTo(6.0, 8.0)
        Ice.add(Instr(Form.PLIN, p))
    }

    val Pillar = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-32.0, 0.0)
        p.lineTo(-2.8, -32.5)
        p.lineTo(25.6, -96.7)
        p.lineTo(37.0, -92.9)
        p.lineTo(21.8, -24.3)
        p.lineTo(25.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-32.0, 0.0)
        p.lineTo(-2.8, -32.5)
        p.lineTo(5.3, -51.0)
        p.lineTo(26.3, -43.9)
        p.lineTo(21.8, -24.3)
        p.lineTo(25.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-0.9, -37.1)
        p.lineTo(11.3, -64.6)
        p.lineTo(29.6, -58.7)
        p.lineTo(23.1, -29.3)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(5.3, -51.0)
        p.lineTo(14.5, -71.5)
        p.lineTo(31.2, -65.9)
        p.lineTo(26.3, -43.9)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-5.2, -29.7)
        p.lineTo(-2.8, -32.5)
        p.lineTo(5.3, -51.0)
        p.lineTo(26.3, -43.9)
        p.lineTo(21.8, -24.3)
        p.lineTo(22.2, -21.5)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(12.7, -37.9)
        p.lineTo(31.3, -94.8)
        p.lineTo(37.0, -92.9)
        p.lineTo(21.8, -24.3)
        p.lineTo(25.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.quadTo(8.0, -6.0, 2.5, -7.6)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Pillar.add(Instr(Form.COLR, colours))
        Pillar.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Pillar.add(Instr(Form.FILL, Color.black))
        Pillar.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Pillar.add(Instr(Form.LINE, Line2D.Double(-42.0, 0.0, -10.0, 0.0)))
        Pillar.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 36.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-32.0, 0.0)
        p.lineTo(-2.8, -32.5)
        p.lineTo(25.6, -96.7)
        p.lineTo(37.0, -92.9)
        p.lineTo(21.8, -24.3)
        p.lineTo(25.0, 0.0)
        Pillar.add(Instr(Form.PLIN, p))
    }

    val Spar = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-3.2, -9.5)
        p.lineTo(25.6, -96.7)
        p.lineTo(37.0, -92.9)
        p.lineTo(8.2, -5.7)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-3.2, -9.5)
        p.lineTo(11.2, -53.1)
        p.lineTo(22.6, -49.3)
        p.lineTo(8.2, -5.7)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(6.4, -38.6)
        p.lineTo(16.0, -67.6)
        p.lineTo(27.4, -63.8)
        p.lineTo(17.8, -34.8)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(11.2, -53.1)
        p.lineTo(18.4, -74.9)
        p.lineTo(29.8, -71.1)
        p.lineTo(22.6, -49.3)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(4.0, -31.3)
        p.lineTo(11.2, -53.1)
        p.lineTo(22.6, -49.3)
        p.lineTo(15.4, -27.5)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(2.5, -7.6)
        p.lineTo(31.3, -94.8)
        p.lineTo(37.0, -92.9)
        p.lineTo(8.2, -5.7)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Spar.add(Instr(Form.COLR, colours))
        Spar.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Spar.add(Instr(Form.FILL, Color.black))
        Spar.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Spar.add(Instr(Form.LINE, Line2D.Double(-20.0, 0.0, -10.0, 0.0)))
        Spar.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 20.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-3.2, -9.5)
        p.lineTo(25.6, -96.7)
        p.lineTo(37.0, -92.9)
        p.lineTo(8.2, -5.7)
        Spar.add(Instr(Form.PLIN, p))
    }

    val Sphere = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.curveTo(-32.0, -21.0, -14.0, -45.5, 12.7, -37.9)
        p.curveTo(27.5, -33.8, 37.8, -15.5, 32.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-25.0, 0.0)
        p.quadTo(-30.0, -15.0, -20.5, -28.0)
        p.lineTo(33.8, -10.0)
        p.quadTo(33.7, -4.0, 32.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-24.2, -22.1)
        p.quadTo(-21.0, -28.5, -15.2, -33.3)
        p.lineTo(32.8, -17.2)
        p.quadTo(34.6, -10.0, 33.0, -2.9)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-20.5, -28.0)
        p.quadTo(-16.5, -33.0, -12.0, -35.5)
        p.lineTo(31.5, -21.0)
        p.quadTo(33.5, -17.0, 34.0, -9.5)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-25.2, -19.0)
        p.quadTo(-23.5, -24.0, -20.5, -28.0)
        p.lineTo(34.0, -9.5)
        p.quadTo(34.0, -3.0, 32.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(12.7, -37.9)
        p.curveTo(27.5, -33.8, 37.8, -15.5, 32.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.quadTo(8.0, -6.0, 2.5, -7.6)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Sphere.add(Instr(Form.COLR, colours))
        Sphere.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Sphere.add(Instr(Form.FILL, Color.black))
        Sphere.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Sphere.add(Instr(Form.LINE, Line2D.Double(-33.0, 0.0, -10.0, 0.0)))
        Sphere.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 40.0, 0.0)))
        Sphere.add(Instr(Form.EARC, Arc2D.Double(-26.5, -39.4, 60.0, 60.0, -18.0, 216.0, Arc2D.OPEN)))
    }


    val Storage = Symbol()

    init {
        Storage.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER)))
        Storage.add(Instr(Form.FILL, Color.black))
        Storage.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        val p = Path2D.Double()
        p.moveTo(-50.0, 0.0)
        p.lineTo(-40.0, -20.0)
        p.lineTo(40.0, -20.0)
        p.lineTo(40.0, -20.0)
        p.lineTo(50.0, 0.0)
        p.lineTo(40.0, 20.0)
        p.lineTo(-40.0, 20.0)
        p.closePath()
        Storage.add(Instr(Form.PLIN, p))
    }


    val Super = Symbol()

    init {
        val colours = Symbol()
        var p = Path2D.Double()
        p.moveTo(-48.0, 0.0)
        p.lineTo(-28.0, -42.0)
        p.lineTo(28.0, -42.0)
        p.lineTo(48.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.P1, p))
        p = Path2D.Double()
        p.moveTo(-48.0, 0.0)
        p.lineTo(-38.0, -21.0)
        p.lineTo(38.0, -21.0)
        p.lineTo(48.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.curveTo(8.0, -11.0, -8.0, -11.0, -8.0, 0.0)
        p.closePath()
        colours.add(Instr(Form.H2, p))
        p = Path2D.Double()
        p.moveTo(-41.3, -14.0)
        p.lineTo(-34.7, -28.0)
        p.lineTo(34.7, -28.0)
        p.lineTo(41.3, -14.0)
        p.closePath()
        colours.add(Instr(Form.H3, p))
        p = Path2D.Double()
        p.moveTo(-38.0, -21.0)
        p.lineTo(-33.0, -31.5)
        p.lineTo(33.0, -31.5)
        p.lineTo(38.0, -21.0)
        p.closePath()
        colours.add(Instr(Form.H4, p))
        p = Path2D.Double()
        p.moveTo(-43.0, -11.5)
        p.lineTo(-38.0, -21.0)
        p.lineTo(38.0, -21.0)
        p.lineTo(43.0, -11.5)
        p.closePath()
        colours.add(Instr(Form.H5, p))
        p = Path2D.Double()
        p.moveTo(0.0, -42.0)
        p.lineTo(28.0, -42.0)
        p.lineTo(48.0, 0.0)
        p.lineTo(8.0, 0.0)
        p.quadTo(7.7, -7.7, 0.0, -8.0)
        p.closePath()
        colours.add(Instr(Form.V2, p))
        Super.add(Instr(Form.COLR, colours))
        Super.add(Instr(Form.STRK, BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND)))
        Super.add(Instr(Form.FILL, Color.black))
        Super.add(Instr(Form.ELPS, Ellipse2D.Double(-10.0, -10.0, 20.0, 20.0)))
        Super.add(Instr(Form.LINE, Line2D.Double(-54.0, 0.0, -10.0, 0.0)))
        Super.add(Instr(Form.LINE, Line2D.Double(10.0, 0.0, 54.0, 0.0)))
        p = Path2D.Double()
        p.moveTo(-48.0, 0.0)
        p.lineTo(-28.0, -42.0)
        p.lineTo(28.0, -42.0)
        p.lineTo(48.0, 0.0)
        Super.add(Instr(Form.PLIN, p))
    }

    val Shapes = mapOf(
        BoySHP.BOY_UNKN to Pillar,
        BoySHP.BOY_CONE to Cone,
        BoySHP.BOY_CAN to Can,
        BoySHP.BOY_SPHR to Sphere,
        BoySHP.BOY_PILR to Pillar,
        BoySHP.BOY_SPAR to Spar,
        BoySHP.BOY_BARL to Barrel,
        BoySHP.BOY_SUPR to Super,
        BoySHP.BOY_ICE to Ice,
    )
}