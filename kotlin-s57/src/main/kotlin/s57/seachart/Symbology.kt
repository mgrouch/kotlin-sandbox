package s57.seachart

import s57.symbols.*
import java.awt.*
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingUtilities

class Symbology : JPanel() {

    private var rectangularBounds: Rectangle? = null

    init {
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        preferredSize = Dimension(screenSize.width - 40, screenSize.height - 40)
        rectangularBounds = this.bounds
    }

    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        background = Color.WHITE
        val all = arrayListOf<Symbols.Symbol>()
        with(all) {
            addAll(Areas.AllAreas)
            addAll(Beacons.AllBeacons)
            addAll(Buoys.AllBuoys)
            addAll(Facilities.AllFacilities)
            addAll(Harbours.AllHarbourSymbols)
            addAll(Landmarks.AllLandmarks)
            addAll(Notices.AllNotices)
            addAll(Topmarks.AllTopmarks)
        }
        for ((idx, s) in all.withIndex()) {
            val x = 100.0 + idx.mod(8) * 150
            val y = 100.0 + idx.div(8) * 150
            Symbols.drawSymbol(g as Graphics2D, s, 0.5, x, y, null, null)
        }
    }

    companion object {
        const val TITLE = "...Test..."

        @JvmStatic
        fun main(args: Array<String>) {
            SwingUtilities.invokeLater {
                val frame = JFrame(TITLE)
                frame.contentPane = Symbology()
                frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
                frame.pack()
                frame.setLocationRelativeTo(null)
                frame.isVisible = true
            }
        }
    }
}