package com.sergeyfitis.androidexperiments.raycasting.rays

import android.graphics.Canvas
import android.graphics.Paint
import com.sergeyfitis.androidexperiments.common.Float2
import com.sergeyfitis.androidexperiments.common.distance

data class Light(
    val position: Float2 = Float2(),
    val rays: ArrayList<Ray> = ArrayList()
) {
    fun draw(canvas: Canvas, paint: Paint) = with(canvas) {
        rays.forEach { ray -> ray.draw(this, paint) }
    }

    fun look(walls: List<Boundary>, canvas: Canvas, paint: Paint) {
        rays.forEach { ray ->
            var closest: Float2? = null
            var record: Float = Float.POSITIVE_INFINITY
            walls.forEach { wall ->
                val point: Float2? = ray.cast(wall)
                if (point != null) {
                    val distance = distance(position, point)
                    if (distance < record) {
                        record = distance
                        closest = point
                    }
                }
            }
            if (closest != null) {
                canvas.drawLine(position.x, position.y, closest!!.x, closest!!.y, paint)
            }
        }
    }
}