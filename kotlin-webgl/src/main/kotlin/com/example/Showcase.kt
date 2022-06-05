package com.example

import io.kvision.*
import io.kvision.panel.root

import info.laht.threekt.THREE
import info.laht.threekt.cameras.PerspectiveCamera
import info.laht.threekt.external.controls.OrbitControls
import info.laht.threekt.external.libs.Stats
import info.laht.threekt.external.objects.Water
import info.laht.threekt.external.objects.WaterOptions
import info.laht.threekt.lights.DirectionalLight
import info.laht.threekt.loaders.TextureLoader
import info.laht.threekt.math.ColorConstants
import info.laht.threekt.scenes.Scene
import info.laht.threekt.renderers.WebGLRenderer
import info.laht.threekt.renderers.WebGLRendererParams
import kotlinx.browser.document
import kotlinx.browser.window

import kotlin.math.PI

data class WaterParameters(
    val oceanSide: Int,
    val size: Number,
    val distortionScale: Number,
    val alpha: Number
)

class Showcase : Application() {
    init {
        require("css/showcase.css")
    }

    override fun dispose(): Map<String, Any> {
        return mapOf()
    }

    val stats = Stats()
    val scene = Scene()

    private lateinit var light: DirectionalLight
    private lateinit var camera: PerspectiveCamera
    lateinit var water: Water
    lateinit var renderer: WebGLRenderer

    private val parameters = WaterParameters(
        oceanSide = 2000,
        size = 1.0,
        distortionScale = 3.7,
        alpha = 1.0
    )

    override fun start(state: Map<String, Any>) {

        root("showcase") {

            light = DirectionalLight(0xffffff, 0.5).apply {
                position.set(0, 0, 0)
            }
            scene.add(light)

            camera = PerspectiveCamera(75, window.innerWidth.toDouble() / window.innerHeight.toDouble(), 0.1, 1000)
            camera.position.set(0.0, 50.0, -100.0)

            val renderer = WebGLRenderer(
                WebGLRendererParams(
                    antialias = true
                )
            ).apply {
                setClearColor(ColorConstants.skyblue, 1)
                setSize(window.innerWidth, window.innerHeight)
            }

            document.getElementById("scene")?.apply {
                appendChild(renderer.domElement)
                appendChild(stats.dom)
            }
            val controls = OrbitControls(camera, renderer.domElement)

            water = Water(
                width = parameters.oceanSide * 2,
                height = parameters.oceanSide * 2,
                options = WaterOptions(
                    textureWidth = 512,
                    textureHeight = 512,
                    waterNormals = TextureLoader().load("textures/waternormals.jpg", {
                        it.wrapS = THREE.RepeatWrapping
                        it.wrapT = THREE.RepeatWrapping
                    }),
                    alpha = parameters.alpha,
                    sunDirection = light.position.clone().normalize(),
                    waterColor = 0x001e0f,
                    distortionScale = parameters.distortionScale,
                    fog = scene.asDynamic().fog != undefined
                )
            ).apply {
                rotation.x = -PI / 2
                receiveShadows = true
            }.also(scene::add)

            window.addEventListener("resize", {
                camera.aspect = window.innerWidth.toDouble() / window.innerHeight
                camera.updateProjectionMatrix()
                renderer.setSize(window.innerWidth, window.innerHeight)
            }, false)

            addAfterInsertHook {
                animate()
            }

            renderer.render(scene, camera)
            stats.update()
        }
    }

    fun animate() {
        window.requestAnimationFrame {
            water.material.apply {
                asDynamic().uniforms.time.value += 1.0 / 60.0
                asDynamic().uniforms.size.value = parameters.size
                asDynamic().uniforms.distortionScale.value = parameters.distortionScale
                asDynamic().uniforms.alpha.value = parameters.alpha
            }
            animate()
        }
        renderer.render(scene, camera)
        stats.update()
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
