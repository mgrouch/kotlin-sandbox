package com.example

import io.kvision.*
import io.kvision.html.div
import io.kvision.panel.root
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
            div(content = "hello")
            val canvas = canvasGL()
            val gl = canvas.contextGL
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
