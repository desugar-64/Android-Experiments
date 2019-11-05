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