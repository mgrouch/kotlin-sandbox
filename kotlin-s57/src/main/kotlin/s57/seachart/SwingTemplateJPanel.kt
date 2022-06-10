package s57.seachart

import s57.render.Renderer.reRender
import s57.S57dec.decodeChart
import s57.S57map

import java.awt.*
import java.io.FileInputStream
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

/**
 * GUI Code
 *
 *
 */
class SwingTemplateJPanel : JPanel() {
    private var rectangularBounds: Rectangle? = null
    private var zoom = 0
    private var factor = 0.0
    private var chartImage: ChartImage? = null
    private lateinit var map: S57map

    /**
     * Ctor
     */
    init {
        preferredSize = Dimension(CANVAS_WIDTH, CANVAS_HEIGHT)
        val input: FileInputStream
        try {
            input = FileInputStream("D:\\kotlin-sandbox\\kotlin-introspection\\src\\main\\kotlin\\US5MA11M.000")
            map = S57map(true)
            decodeChart(input, map)
            rectangularBounds = this.bounds
            zoom = 14
            factor = 3.0
            chartImage = ChartImage()
            println("ChartImage() done")
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
        private const val serialVersionUID = 1L
        const val CANVAS_WIDTH = 640
        const val CANVAS_HEIGHT = 480
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