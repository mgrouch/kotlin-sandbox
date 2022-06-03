package com.example

import io.kvision.*
import io.kvision.html.canvas
import io.kvision.html.div
import io.kvision.panel.root
import io.kvision.panel.simplePanel
import io.kvision.utils.perc
import org.khronos.webgl.WebGLProgram
import org.w3c.dom.HTMLCanvasElement
import org.khronos.webgl.WebGLRenderingContext as GL

class Showcase : Application() {
    init {
        require("css/showcase.css")
    }

    override fun dispose(): Map<String, Any> {
        return mapOf()
    }

    override fun start(state: Map<String, Any>) {
        root("showcase") {
            simplePanel {
                width = 100.perc
                val can = canvas {

                }
                val element: HTMLCanvasElement = can.getElement() as HTMLCanvasElement
                val webgl: GL = element.getContext("webgl") as GL

                val shaderProgram: WebGLProgram = webgl.createProgram() ?: throw IllegalStateException("Could not initialize shader program")

            }
        }
    }
}

fun main() {
    startApplication(
        ::Showcase,
        module.hot,
        BootstrapModule,
        BootstrapCssModule,
        FontAwesomeModule,
        CoreModule,
    )
}
