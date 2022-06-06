package com.example

import info.laht.threekt.cameras.PerspectiveCamera
import info.laht.threekt.external.ImprovedNoise.noise
import info.laht.threekt.external.controls.OrbitControls
import info.laht.threekt.external.libs.Stats
import info.laht.threekt.geometries.ConeGeometry
import info.laht.threekt.geometries.PlaneGeometry
import info.laht.threekt.materials.MeshNormalMaterial
import info.laht.threekt.math.Color
import info.laht.threekt.math.Vector3
import info.laht.threekt.objects.Mesh
import info.laht.threekt.renderers.WebGLRenderer
import info.laht.threekt.renderers.WebGLRendererParams
import info.laht.threekt.scenes.Scene
import kotlinx.browser.document
import kotlinx.browser.window
import kotlin.math.PI
import kotlin.math.abs
import kotlin.random.Random

external class ImprovedNoise {

    fun noise(x: Double, y: Double, z: Double): Double
}

class Terrain {

    private val stats: Stats = Stats()
    private val renderer: WebGLRenderer
    private val scene: Scene = Scene()
    private val camera: PerspectiveCamera
    private val controls: OrbitControls

    init {
        renderer = WebGLRenderer(WebGLRendererParams(antialias = true)).apply {
            setPixelRatio(window.devicePixelRatio)
            setSize(window.innerWidth, window.innerHeight)
        }
        camera = PerspectiveCamera(60, (window.innerWidth / window.innerHeight).toDouble(), 10, 20000)

        document.getElementById("scene")?.apply {
            appendChild(renderer.domElement)
            appendChild(stats.dom)
        }
        controls = OrbitControls(camera, renderer.domElement)
        controls.minDistance = 1000.0
        controls.maxDistance = 10000.0
        controls.maxPolarAngle = PI / 2

        scene.background = Color(0xbfd1e5)

        val worldWidth = 256
        val worldDepth = 256
        val geometry = PlaneGeometry(7500, 7500, worldWidth - 1, worldDepth - 1)
        geometry.rotateX(-PI / 2)

        val vertices = geometry.vertices
        val data = generateHeight(worldWidth, worldDepth)

        controls.target.y = (data[(worldWidth / 2) + (worldDepth / 2) * worldWidth] + 500).toDouble()
        camera.position.y = controls.target.y + 2000
        camera.position.x = 2000.0
        controls.update()

        for (i in vertices.indices) {
            vertices[i].z = (data[i] * 10).toDouble()
        }

        val geometryHelper = ConeGeometry(20, 100, 3)
        geometryHelper.translate(0, 50, 0)
        geometryHelper.rotateX(PI / 2)

        val helper = Mesh(geometryHelper, MeshNormalMaterial())
        scene.add(helper)

        val raycaster = camera.raycast()

        window.addEventListener("resize", {
            camera.aspect = window.innerWidth.toDouble() / window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize(window.innerWidth, window.innerHeight)
        }, false)
    }

    fun generateHeight(width: Int, height: Int): IntArray {
        val perlin = ImprovedNoise()
        val size = width * height
        val data = IntArray(size)
        val z = Random.nextInt(0, 100)
        var quality = 1
        for (j in 0 until 4) {
            for (i in 0 until size) {
                val x = i % width
                val y = i / width
                val n = perlin.noise(x.toDouble() / quality, y.toDouble() / quality, z.toDouble())
                data[i] += abs(n * quality * 1.75).toInt()
            }
            quality *= 5
        }
        return data
    }

    fun animate() {
        window.requestAnimationFrame {
            animate()
        }
        render()
    }

    fun render() {
        renderer.render(scene, camera)
        stats.update()
    }
}
