package com.sergeyfitis.androidexperiments.raycasting.rays

import android.graphics.Canvas
import android.graphics.Paint
import com.sergeyfitis.androidexperiments.common.Float2

data class Ray(
    val origin: Float2 = Float2(),
    val direction: Float2 = Float2(1.0f, 0.0f)
) {
    fun draw(canvas: Canvas, paint: Paint) = with(canvas) {
        save()
        translate(origin.x, origin.y)
        drawLine(0.0f, 0.0f, direction.x, direction.y, paint)
        restore()
    }

    fun lookAt(x: Float, y: Float) {
        direction.x = x - origin.x
        direction.y = y - origin.y
    }

    fun cast(boundary: Boundary): Float2? {
        val (x1, y1) = boundary.a
        val (x2, y2) = boundary.b

        val (x3, y3) = origin
        val x4 = origin.x + direction.x
        val y4 = origin.y + direction.y

        val denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4)
        if (denominator == 0.0f) {
            return null
        }

        val t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / denominator
        val u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / denominator

        return if (t > 0.0f && t < 1.0f && u > 0.0f) {
            Float2(
                x = x1 + t * (x2 - x1),
                y = y1 + t * (y2 - y1)
            )
        } else {
            null
        }
    }
}