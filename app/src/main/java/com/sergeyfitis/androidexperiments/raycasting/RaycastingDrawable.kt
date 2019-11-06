package com.sergeyfitis.androidexperiments.raycasting

import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.core.graphics.ColorUtils
import com.sergeyfitis.androidexperiments.common.Float2
import com.sergeyfitis.androidexperiments.common.dp
import com.sergeyfitis.androidexperiments.common.strokePaint
import com.sergeyfitis.androidexperiments.raycasting.rays.Boundary
import com.sergeyfitis.androidexperiments.raycasting.rays.Light
import com.sergeyfitis.androidexperiments.raycasting.rays.Ray
import kotlin.random.Random

class RaycastingDrawable : Drawable() {

    private val rnd: Random
        get() = Random(System.nanoTime())

    private var walls = listOf(
        Boundary(
            a = Float2(
                x = rnd.nextInt(360.dp.toInt()).toFloat(),
                y = rnd.nextInt(360.dp.toInt()).toFloat()
            ),
            b = Float2(
                x = rnd.nextInt(600.dp.toInt()).toFloat(),
                y = rnd.nextInt(600.dp.toInt()).toFloat()
            )
        ),
        Boundary(
            a = Float2(
                x = rnd.nextInt(360.dp.toInt()).toFloat(),
                y = rnd.nextInt(360.dp.toInt()).toFloat()
            ),
            b = Float2(
                x = rnd.nextInt(600.dp.toInt()).toFloat(),
                y = rnd.nextInt(600.dp.toInt()).toFloat()
            )
        ),
        Boundary(
            a = Float2(
                x = rnd.nextInt(360.dp.toInt()).toFloat(),
                y = rnd.nextInt(360.dp.toInt()).toFloat()
            ),
            b = Float2(
                x = rnd.nextInt(600.dp.toInt()).toFloat(),
                y = rnd.nextInt(600.dp.toInt()).toFloat()
            )
        ),
        Boundary(
            a = Float2(
                x = rnd.nextInt(360.dp.toInt()).toFloat(),
                y = rnd.nextInt(360.dp.toInt()).toFloat()
            ),
            b = Float2(
                x = rnd.nextInt(600.dp.toInt()).toFloat(),
                y = rnd.nextInt(600.dp.toInt()).toFloat()
            )
        )
    )

    private val wallPaint: Paint = strokePaint(color = Color.WHITE)

    private val rayPaint: Paint = strokePaint(color = ColorUtils.setAlphaComponent(Color.GREEN, 50), width = 3.dp)

    private val light = Light(position = Float2(100.dp, 100.dp)).apply {
        for (i in 0..360 step 1) {
            val rad: Double = Math.toRadians(i.toDouble())
            rays.add(
                Ray(origin = position, direction = Float2.fromAngle(rad))
            )
        }
    }

    override fun setHotspot(x: Float, y: Float) {
        super.setHotspot(x, y)
        light.position.x = x
        light.position.y = y
        invalidateSelf()
    }

    override fun draw(canvas: Canvas) = with(canvas) {
        drawColor(Color.BLACK)
        walls.forEach { wall -> wall.draw(this, wallPaint) }
        light.look(walls, this, rayPaint)
        light.draw(this, rayPaint)


        Unit
    }

    override fun setAlpha(alpha: Int) {
        // TODO
    }

    override fun getOpacity() = PixelFormat.OPAQUE

    override fun setColorFilter(colorFilter: ColorFilter?) {
        // TODO
    }
}