package com.example

import io.kvision.*
import io.kvision.html.canvas
import io.kvision.html.div
import io.kvision.panel.root
import io.kvision.panel.simplePanel
import io.kvision.utils.perc
import io.kvision.utils.px
import kotlinx.browser.document
import org.khronos.webgl.WebGLProgram
import org.khronos.webgl.WebGLRenderingContext as GL
import org.w3c.dom.HTMLCanvasElement

class Showcase : Application() {
    init {
        require("css/showcase.css")
    }

    override fun dispose(): Map<String, Any> {
        return mapOf()
    }

    override fun start(state: Map<String, Any>) {
        root("showcase") {
            div(content = "hello") {
            }
            val canvas = document.getElementById("glCanvas") as HTMLCanvasElement
            console.log(canvas)
            val gl = canvas.getContext("webgl") as GL
            console.log(gl)
            gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f)
            gl.clear(GL.COLOR_BUFFER_BIT)

            //val shaderProgram: WebGLProgram = gl.createProgram() ?: throw IllegalStateException("Could not initialize shader program")
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
