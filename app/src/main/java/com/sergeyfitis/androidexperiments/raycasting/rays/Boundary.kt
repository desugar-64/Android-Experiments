package com.sergeyfitis.androidexperiments.raycasting.rays

import android.graphics.Canvas
import android.graphics.Paint
import com.sergeyfitis.androidexperiments.common.Float2

data class Boundary(
    var a: Float2 = Float2(),
    var b: Float2 = Float2()
) {
    constructor(x1: Float, y1: Float, x2: Float, y2: Float): this(
        a = Float2(x1, y1),
        b = Float2(x2, y2)
    )

    fun draw(canvas: Canvas, paint: Paint) = with(canvas) {
        drawLine(a.x, a.y, b.x, b.y, paint)
    }
}