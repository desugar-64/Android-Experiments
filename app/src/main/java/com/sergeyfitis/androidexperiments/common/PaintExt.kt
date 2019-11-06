package com.sergeyfitis.androidexperiments.common

import android.graphics.Color
import android.graphics.Paint
import androidx.annotation.ColorInt

inline fun fillPaint(
    @ColorInt color: Int = Color.BLACK,
    aa: Boolean = false,
    body: Paint.() -> Unit = { -> }
): Paint {
    val paint = Paint()
    paint.color = color
    paint.style = Paint.Style.FILL
    paint.isAntiAlias = aa
    return paint.apply(body)
}

inline fun strokePaint(
    @ColorInt color: Int = Color.BLACK,
    aa: Boolean = false,
    width: Float = 1.dp,
    body: Paint.() -> Unit = { -> }
): Paint {
    val paint = Paint()
    paint.color = color
    paint.style = Paint.Style.STROKE
    paint.isAntiAlias = aa
    paint.strokeWidth = width
    return paint.apply(body)
}