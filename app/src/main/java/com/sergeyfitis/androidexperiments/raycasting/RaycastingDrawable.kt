package com.sergeyfitis.androidexperiments.raycasting

import android.graphics.*
import android.graphics.drawable.Drawable
import com.sergeyfitis.androidexperiments.common.Float2
import com.sergeyfitis.androidexperiments.common.dp
import com.sergeyfitis.androidexperiments.common.draw
import com.sergeyfitis.androidexperiments.common.fillPaint
import com.sergeyfitis.androidexperiments.raycasting.rays.Boundary
import com.sergeyfitis.androidexperiments.raycasting.rays.Ray

class RaycastingDrawable : Drawable() {

    private var wall = Boundary(
        a = Float2(200.dp, 100.dp),
        b = Float2(280.dp, 400.dp)
    )

    private val wallPaint: Paint = fillPaint(color = Color.WHITE)

    private val ray = Ray(
        origin = Float2(50.dp, 50.dp),
        direction = Float2(100.dp, 100.dp)
    )

    private val rayPaint: Paint = fillPaint(color = Color.GREEN)

    private var castPoint: Float2? = null
    private val castPaint: Paint = fillPaint(color = Color.RED)
    private val castPointRadius: Float = 5.dp

    override fun setHotspot(x: Float, y: Float) {
        super.setHotspot(x, y)
        ray.lookAt(x, y)
        castPoint = ray.cast(wall)
        invalidateSelf()
    }

    override fun onBoundsChange(bounds: Rect?) {
        super.onBoundsChange(bounds)
    }

    override fun draw(canvas: Canvas) = with(canvas) {
        drawColor(Color.BLACK)
        wall.draw(this, wallPaint)
        ray.draw(canvas, rayPaint)
        castPoint?.draw(canvas, castPaint, castPointRadius)

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