// License: GPL. For details, see LICENSE file.
package s57.render

import s57.S57map

import java.awt.Color
import java.awt.geom.Point2D

/**
 * @author Malcolm Herring
 * @author mgrouch
 */
interface ChartContext {

    enum class RuleSet {
        ALL, BASE, SEAMARK
    }

    fun getPoint(coord: S57map.Snode): Point2D?
    fun mile(feature: S57map.Feature): Double
    fun clip(): Boolean
    fun background(map: S57map): Color?
    fun ruleset(): RuleSet?
}
