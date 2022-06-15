// License: GPL. For details, see LICENSE file.
package s57.seachart

import s57.parser.S57map
import s57.parser.S57map.*
import s57.parser.S57obj.Obj
import s57.parser.rad2deg
import s57.render.ChartContext
import s57.render.ChartContext.RuleSet
import s57.symbols.Symbols
import s57.symbols.Symbols.Bwater
import s57.symbols.Symbols.Yland

import java.awt.Color
import java.awt.geom.Point2D
import kotlin.math.*

/**
 * contains code from Malcolm Herring
 */
class ChartImage(val map: S57map, val zoom: Double, val x: Int = 0, val y: Int = 0) : ChartContext {

    val top = (1.0 - ln(tan(map.bounds.maxlat) + 1.0 / cos(map.bounds.maxlat)) / PI) / 2.0 * 256.0 * 4096.0 *
            2.0.pow((zoom - 12))

    val mile = (2.0 *
            (if (zoom < 12) 256.0 / 2.0.pow(11 - zoom)
            else 256.0) +
            256.0) / (rad2deg(map.bounds.maxlat) - rad2deg(map.bounds.minlat)) / 60.0

    override fun getPoint(coord: Snode): Point2D.Double {
        val x = (rad2deg(coord.lon) - rad2deg(map.bounds.minlon)) * 256.0 * 2048.0 *
                2.0.pow(zoom - 12) / 180.0
        val y: Double = ((1.0 - ln(tan(coord.lat) + 1.0 / cos(coord.lat)) / PI) /
                2.0) * 256.0 * 4096.0 * 2.0.pow(zoom - 12) - top
        return Point2D.Double(x - this.x, y - this.y)
    }

    override fun mile(feature: Feature): Double {
        return mile
    }

    override fun clip(): Boolean {
        return false
    }

    override fun background(map: S57map): Color {
        return if (map.features.containsKey(Obj.COALNE)) {
            for (feature in map.features[Obj.COALNE]!!) {
                if (feature!!.geom.prim === Pflag.POINT) {
                    break
                }
                val git = map.GeomIterator(feature!!.geom)
                git.nextComp()
                while (git.hasEdge()) {
                    git.nextEdge()
                    while (git.hasNode()) {
                        val node = git.next() ?: continue
                        if (node.lat >= map.bounds.minlat && node.lat <= map.bounds.maxlat
                            && node.lon >= map.bounds.minlon && node.lon <= map.bounds.maxlon) {
                            return Bwater
                        }
                    }
                }
            }
            Yland
        } else {
            if (map.features.containsKey(Obj.ROADWY) || map.features.containsKey(Obj.RAILWY)
                || map.features.containsKey(Obj.LAKARE) || map.features.containsKey(Obj.RIVERS)
                || map.features.containsKey(Obj.CANALS)) {
                Yland
            } else {
                Bwater
            }
        }
    }

    override fun ruleset(): RuleSet {
        return RuleSet.ALL
    }
}