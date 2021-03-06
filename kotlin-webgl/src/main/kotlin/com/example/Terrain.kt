package com.example

import info.laht.threekt.THREE.ClampToEdgeWrapping
import info.laht.threekt.cameras.PerspectiveCamera
import info.laht.threekt.core.Intersect
import info.laht.threekt.core.Raycaster
import info.laht.threekt.external.controls.OrbitControls
import info.laht.threekt.external.libs.Stats
import info.laht.threekt.geometries.ConeGeometry
import info.laht.threekt.geometries.PlaneGeometry
import info.laht.threekt.materials.MeshBasicMaterial
import info.laht.threekt.materials.MeshNormalMaterial
import info.laht.threekt.math.Color
import info.laht.threekt.math.Vector2
import info.laht.threekt.math.Vector3
import info.laht.threekt.objects.Mesh
import info.laht.threekt.renderers.WebGLRenderer
import info.laht.threekt.renderers.WebGLRendererParams
import info.laht.threekt.scenes.Scene
import info.laht.threekt.textures.Texture
import kotlinx.browser.document
import kotlinx.browser.window
import org.khronos.webgl.get
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.Element
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.events.Event
import kotlin.math.PI
import kotlin.math.abs
import kotlin.random.Random

// porting: https://threejs.org/examples/webgl_geometry_terrain_raycast

external class ImprovedNoise {
    fun noise(x: Double, y: Double, z: Double): Double
}

class Terrain {

    private val stats: Stats = Stats()
    private val renderer: WebGLRenderer
    private val scene: Scene = Scene()
    private val camera: PerspectiveCamera
    private val controls: OrbitControls
    private val pointer = Vector2()
    private val raycaster = Raycaster(Vector3(), Vector3(), 2000, 2000)
    private val mesh: Mesh
    private val helper: Mesh

    init {
        renderer = WebGLRenderer(WebGLRendererParams(antialias = true)).apply {
            setPixelRatio(window.devicePixelRatio)
            setSize(window.innerWidth, window.innerHeight)
        }
        camera = PerspectiveCamera(60, (window.innerWidth / window.innerHeight).toDouble(), 10, 20000)

        val container = document.getElementById("scene")?.apply {
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
            vertices[i].y = (data[i] * 10).toDouble()
        }

        val texture = Texture(generateTexture(data, worldWidth, worldDepth)).apply {
            wrapS = ClampToEdgeWrapping
            wrapT = ClampToEdgeWrapping
        }

        mesh = Mesh(geometry, MeshBasicMaterial().apply {
            map = texture
            wireframe = true
        })
        scene.add(mesh)

        val geometryHelper = ConeGeometry(20, 100, 3)
        geometryHelper.translate(0, 50, 0)
        geometryHelper.rotateX(PI / 2)

        helper = Mesh(geometry, MeshNormalMaterial())
        scene.add(helper)

        container?.addEventListener("pointermove", this::onPointerMove)

        window.addEventListener("resize", {
            camera.aspect = window.innerWidth.toDouble() / window.innerHeight
            camera.updateProjectionMatrix()
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

    fun generateTexture(data: IntArray, width: Int, height: Int): Element {
        val vector3 = Vector3(0, 0, 0)
        val sun = Vector3(1, 1, 1)
        sun.normalize()

        val canvas = document.createElement("canvas") as HTMLCanvasElement
        canvas.width = width
        canvas.height = height

        val context = canvas.getContext("2d") as CanvasRenderingContext2D
        context.fillStyle = "#000000"
        context.fillRect(0.0, 0.0, width.toDouble(), height.toDouble())

        val image = context.getImageData(
            0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble()
        )
        val imageData = image.data
        var j = 0
        for (i in 0 until imageData.length step 4) {
            vector3.x = data[j - 2].toDouble() - data[j + 2]
            vector3.y = 2.0
            vector3.z = data[j - width * 2].toDouble() - data[j + width * 2]
            vector3.normalize()
            val shade = vector3.dot(sun)
            imageData.asDynamic()[i] = ((96 + shade * 128) * (0.5 + data[j] * 0.007))
            imageData.asDynamic()[i + 1] = ((32 + shade * 96) * (0.5 + data[j] * 0.007))
            imageData.asDynamic()[i + 2] = ((shade * 96) * (0.5 + data[j] * 0.007))
            j++
        }
        context.putImageData(image, 0.0, 0.0)
        //console.log("${image.data.length}  image.data[255]=${image.data[255]}")

        // Scaled 4x
        val canvasScaled = document.createElement("canvas") as HTMLCanvasElement
        canvasScaled.width = 4*width
        canvasScaled.height = 4*height
        val canvasScaledContext = canvasScaled.getContext("2d") as CanvasRenderingContext2D
        canvasScaledContext.scale(4.0, 4.0)
        canvasScaledContext.drawImage(canvas, 0.0, 0.0)

        val image2 = canvasScaledContext.getImageData(
            0.0, 0.0, canvasScaled.width.toDouble(), canvasScaled.height.toDouble()
        )
        val imageData2 = image2.data
        //console.log("${image2.data.length}")
        for (i in 0 until imageData2.length step 4) {
            val v: Byte = (Random.nextDouble() * 5).toInt().toByte()
            imageData2.asDynamic()[i] = imageData2[i].asDynamic()[i] + v
            imageData2.asDynamic()[i + 1] = imageData2.asDynamic()[i + 1] + v
            imageData2.asDynamic()[i + 2] = imageData2.asDynamic()[i + 2] + v
        }
        canvasScaledContext.putImageData(image2, 0.0, 0.0)
        return canvasScaled
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

    fun onPointerMove( event: Event ) {
        pointer.x = ((event.asDynamic().clientX / renderer.domElement.asDynamic().clientWidth) * 2 - 1) as Double
        pointer.y = (-(event.asDynamic().clientY / renderer.domElement.asDynamic().clientHeight) * 2 + 1) as Double

        //console.log("x,y ${pointer.x} ${pointer.y}")

        // See if the ray from the camera into the world hits one of our meshes
        raycaster.setFromCamera(pointer, camera)
        val intersects: List<Intersect> = raycaster.intersectObject(mesh, false)

        // Toggle rotation bool for meshes that we clicked
        if (intersects.size > 0) {
            helper.position.set(0, 0, 0)
            val v: Vector3? = intersects[0].face?.normal
            if (v != null) helper.lookAt(v)
            helper.position.copy(intersects[0].point)
        }
    }
}
