package com.example

import io.kvision.*
import io.kvision.panel.root

class Showcase : Application() {
    init {
        require("css/showcase.css")
    }

    override fun dispose(): Map<String, Any> {
        return mapOf()
    }

    override fun start(state: Map<String, Any>) {
        root("showcase") {
            WaterSurface().animate()
        }
    }
}

fun main() {
    startApplication(
        ::Showcase,
        module.hot,
        FontAwesomeModule,
        CoreModule,
    )
}
