package com.example

import io.kvision.*
import io.kvision.html.div
import io.kvision.panel.root
import io.kvision.panel.vPanel
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
            vPanel {
                width = 100.perc
                div(content = "Hello World5!")
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
