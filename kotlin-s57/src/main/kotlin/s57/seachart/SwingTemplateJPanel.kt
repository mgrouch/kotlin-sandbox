package s57.seachart

import s57.parser.S57dec.decodeChart
import s57.parser.S57map
import s57.render.ChartImage
import s57.render.Renderer.reRender

import java.awt.*
import java.io.FileInputStream
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities
import kotlin.concurrent.timer

/**
 * GUI Code
 */
class SwingTemplateJPanel : JPanel() {

    private var rectangularBounds: Rectangle? = null
    private var zoom = 0
    private var factor = 0.0
    private lateinit var chartImage: ChartImage
    private lateinit var map: S57map

    init {
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        preferredSize = Dimension(screenSize.width - 40, screenSize.height - 40)
        try {
            val input = FileInputStream("./kotlin-s57/ENC_ROOT/US5NYCDF/US5NYCDF.000")
            input.use {
                map = S57map(true)
                decodeChart(input, map)
                rectangularBounds = this.bounds
                zoom = 16
                factor = 20.0
                chartImage = ChartImage(map, zoom.toDouble(), 2000, 1500)
                println("ChartImage() done")
                timer(period = 200) {
                    if (chartImage.x > 1 && chartImage.y > 1) {
                        chartImage.x -= 5
                        chartImage.y += 5
                    } else {
                        chartImage.x = 2000
                        chartImage.y = 1500
                    }
                    repaint()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        background = Color.WHITE
        reRender(g as Graphics2D, rectangularBounds, zoom, factor, map, chartImage)
        //			g.drawRect(10, 10, 100, 100);
    }

    companion object {
        const val TITLE = "...Test..."

        @JvmStatic
        fun main(args: Array<String>) {
            SwingUtilities.invokeLater {
                val frame = JFrame(TITLE)
                frame.contentPane = SwingTemplateJPanel()
                frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
                frame.pack()
                frame.setLocationRelativeTo(null)
                frame.isVisible = true
            }
        }
    }
}