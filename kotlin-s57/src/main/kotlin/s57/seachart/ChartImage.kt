// License: GPL. For details, see LICENSE file.
package s57.seachart

import s57.render.ChartContext
import s57.S57map
import s57.S57obj
import s57.rad2deg
import s57.symbols.Symbols

import java.awt.Color
import java.awt.geom.Point2D

/**
 * contains code from Malcolm Herring
 */
class ChartImage : ChartContext {

    var debug = false

    override fun getPoint(coord: S57map.Snode): Point2D.Double {
        if (debug) println(rad2deg(coord.lat).toString() + " " + rad2deg(coord.lon))
        val point = Point2D.Double(
            (rad2deg(coord.lat) - 50) / 8 * 10000 - 4000,
            (rad2deg(coord.lon) - 8) / 8 * 10000 - 0
        )
        if (debug) println(point)
        return point //MainApplication.getMap().mapView.getPoint2D(new LatLon(rad2deg(coord.lat), rad2deg(coord.lon)));
    }

    override fun mile(feature: S57map.Feature): Double {
        return 185.2
    }

    override fun clip(): Boolean {
        return false
    }

    override fun background(map: S57map): Color {
        return if (map.features!!.containsKey(S57obj.Obj.COALNE)) {
            for (feature in map.features!![S57obj.Obj.COALNE]!!) {
                if (feature!!.geom!!.prim === S57map.Pflag.POINT) {
                    break
                }
                val git = map.GeomIterator(feature!!.geom)
                git.nextComp()
                while (git.hasEdge()) {
                    git.nextEdge()
                    while (git.hasNode()) {
                        val node = git.next() ?: continue
                        if (node.lat >= map.bounds!!.minlat && node.lat <= map.bounds!!.maxlat
                            && node.lon >= map.bounds!!.minlon && node.lon <= map.bounds!!.maxlon) {
                            return Symbols.Bwater
                        }
                    }
                }
            }
            Symbols.Yland
        } else {
            if (map.features!!.containsKey(S57obj.Obj.ROADWY) || map.features!!.containsKey(S57obj.Obj.RAILWY)
                || map.features!!.containsKey(S57obj.Obj.LAKARE) || map.features!!.containsKey(S57obj.Obj.RIVERS)
                || map.features!!.containsKey(S57obj.Obj.CANALS)) {
                Symbols.Yland
            } else {
                Symbols.Bwater
            }
        }
    }

    override fun ruleset(): ChartContext.RuleSet {
        return ChartContext.RuleSet.ALL
    }
}