@file:Suppress("NOTHING_TO_INLINE")

package com.sergeyfitis.androidexperiments.common

import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.sqrt

data class Float2(var x: Float = 0.0f, var y: Float = 0.0f) {
    constructor(v: Float) : this(v, v)
    constructor(v: Float2) : this(v.x, v.y)


    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        else -> throw IllegalArgumentException("index must be in 0..1")
    }

    operator fun get(index1: Int, index2: Int) = Float2(get(index1), get(index2))

    inline operator fun invoke(index: Int) = get(index - 1)

    operator fun set(index: Int, v: Float) = when (index) {
        0 -> x = v
        1 -> y = v
        else -> throw IllegalArgumentException("index must be in 0..1")
    }

    operator fun set(index1: Int, index2: Int, v: Float) {
        set(index1, v)
        set(index2, v)
    }
    operator fun unaryMinus() = Float2(-x, -y)
    operator fun inc(): Float2 {
        x += 1.0f
        y += 1.0f
        return this
    }

    operator fun dec(): Float2 {
        x -= 1.0f
        y -= 1.0f
        return this
    }

    inline operator fun plus(v: Float) = Float2(x + v, y + v)
    inline operator fun minus(v: Float) = Float2(x - v, y - v)
    inline operator fun times(v: Float) = Float2(x * v, y * v)
    inline operator fun div(v: Float) = Float2(x / v, y / v)

    inline operator fun plus(v: Float2) = Float2(x + v.x, y + v.y)
    inline operator fun minus(v: Float2) = Float2(x - v.x, y - v.y)
    inline operator fun times(v: Float2) = Float2(x * v.x, y * v.y)
    inline operator fun div(v: Float2) = Float2(x / v.x, y / v.y)

    inline fun transform(block: (Float) -> Float): Float2 {
        x = block(x)
        y = block(y)
        return this
    }

    fun normalize() {
        val l = 1.0f / length(this)
        x *= l
        y *= l
    }
}

inline fun length(v: Float2) = sqrt(v.x * v.x + v.y * v.y)

inline fun Float2.draw(canvas: Canvas, paint: Paint, radius: Float) = with(canvas) {
    drawCircle(x, y, radius, paint)
}