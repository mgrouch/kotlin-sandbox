package com.example

import io.kvision.*
import io.kvision.html.div
import io.kvision.panel.root
import io.kvision.panel.simplePanel
import io.kvision.utils.perc

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
                div(content = "Hello World8!")
                div(content = "Hello World13!")
                div(content = "Hello World13!")
                div(content = "Hello World14!")
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
