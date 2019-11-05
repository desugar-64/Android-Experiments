@file:Suppress("NOTHING_TO_INLINE")

package com.sergeyfitis.androidexperiments.common

import android.content.res.Resources
import android.util.TypedValue

inline val Float.dp get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    Resources.getSystem().displayMetrics
)

inline val Int.dp
    get() =  this.toFloat().dp