package s57

import java.io.FileInputStream
import java.io.IOException

fun main(args : Array<String>) {
    try {
        val input = FileInputStream("D:\\US5MA11M.000")
        val map = S57map(true)
        S57dec.decodeChart(input, map)
        println(map.edges)
        println(map.bounds)
        println(map.xref)
        println(map.features)
        println(map.index)
        println(map.nodes)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}