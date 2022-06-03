package com.example

import io.kvision.snabbdom.VNode
import io.kvision.core.AttributeSetBuilder
import io.kvision.core.Container
import io.kvision.core.Widget
import io.kvision.html.TagMarker
import org.khronos.webgl.WebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement

/**
 * Canvas component.
 *
 * @constructor
 * @param canvasWidth the width of the canvas
 * @param canvasHeight the height of the canvas
 * @param className CSS class names
 * @param init an initializer extension function
 */
@TagMarker
open class CanvasGL(
    canvasWidth: Int? = null, canvasHeight: Int? = null, className: String? = null,
    init: (CanvasGL.() -> Unit)? = null
) : Widget(className) {

    /**
     * The width of the canvas.
     */
    var canvasWidth by refreshOnUpdate(canvasWidth)

    /**
     * The height of the canvas.
     */
    var canvasHeight by refreshOnUpdate(canvasHeight)

    /**
     * The canvas rendering context.
     */
    lateinit var contextGL: WebGLRenderingContext

    init {
        @Suppress("LeakingThis")
        init?.invoke(this)
    }

    override fun render(): VNode {
        return render("canvas")
    }

    override fun buildAttributeSet(attributeSetBuilder: AttributeSetBuilder) {
        super.buildAttributeSet(attributeSetBuilder)
        canvasWidth?.let {
            attributeSetBuilder.add("width", "$it")
        }
        canvasHeight?.let {
            attributeSetBuilder.add("height", "$it")
        }
    }

    override fun afterInsert(node: VNode) {
        super.afterInsert(node)
        contextGL = (node.elm as HTMLCanvasElement).getContext("webgl") as WebGLRenderingContext
    }
}

/**
 * DSL builder extension function.
 *
 * It takes the same parameters as the constructor of the built component.
 */
fun Container.canvasGL(
    canvasWidth: Int? = null, canvasHeight: Int? = null,
    className: String? = null,
    init: (CanvasGL.() -> Unit)? = null
): CanvasGL {
    val canvas = CanvasGL(canvasWidth, canvasHeight, className, init)
    this.add(canvas)
    return canvas
}
