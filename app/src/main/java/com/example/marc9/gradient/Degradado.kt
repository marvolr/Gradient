package com.example.marc9.gradient

import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.drawable.ShapeDrawable

class Degradado (private val colors: IntArray, val positionX: Float,val positionY: Float, var size: Float) : ShapeDrawable.ShaderFactory() {
        constructor( colors: IntArray, size: Float):this(colors,0.0F,0.0F,size)

        override fun resize(width: Int, height: Int): Shader {
            return RadialGradient(
                width * positionX,
                height * positionY,
                minOf(width, height) * size,
                colors,
                null,
                Shader.TileMode.CLAMP
            )
        }

}
