package com.example.marc9.gradient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.animation.ValueAnimator
import android.graphics.*
import android.graphics.Color.BLACK
import android.graphics.RadialGradient
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.PaintDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.y
import android.R.attr.x
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth


class MainActivity : AppCompatActivity() {
    val colors = intArrayOf(Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK)
    val colors2 = intArrayOf(Color.WHITE, Color.MAGENTA, Color.CYAN, Color.BLACK)

    //var degradado2:PaintDrawable=radialGradientBackground(colors2[0],colors2[1],colors2[2],colors2[3],size=0.7F)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //animateImageView(image)
        val canvas = Canvas()


        val radialGradientBackground = PaintDrawable()
        radialGradientBackground.shape = RectShape()
        radialGradientBackground.shaderFactory = Degradado(colors, 0.5F, 0.5F, 0.5F)

        //view.background=radialGradientBackground

         //radialGradientBackground.setBounds(500,500,500,500)
         ///radialGradientBackground.setAlpha(255)
        //radialGradientBackground.setColorFilter(Color.TRANSPARENT,PorterDuff.Mode.SCREEN)
         //radialGradientBackground.draw(canvas)

       // val lienzo = Lienzo(this)
        //view.addView(lienzo)


         view.background = radialGradientBackground


        button.setOnClickListener {
            ObjectAnimator.ofFloat(Degradado(colors2, 0.05F, 0.05F, 0.07F), "size", 10f).apply {
                duration = 1000
                start()
            }

        }

        /*
        val animator = ValueAnimator.ofFloat(0.0f, 1.0f)
        animator.duration = 1500
        animator.repeatMode = ValueAnimator.REVERSE
        animator.addUpdateListener { animation ->
            radialGradientBackground.shaderFactory=ShaderUtils.RadialShaderFactory(colors2,0.5F,0.5F,5)
        }
        animator.repeatCount = -1
        animator.start()

        }*/


    }

    class Lienzo(context: Context) : View(context) {
        val colors = intArrayOf(Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK)


        override fun onDraw(canvas: Canvas) {
            val p = Paint()

            val radialGradientBackground = PaintDrawable()
            radialGradientBackground.shape = RectShape()
            radialGradientBackground.shaderFactory = Degradado(colors, 0.5F, 0.5F, 0.05F)
            radialGradientBackground.draw(canvas)
            //  p.setShader()
            //  canvas.d
        }

    }
}


/*
object ShaderUtils {
        class RadialShaderFactory(private val colors: IntArray, val positionX: Float,val positionY: Float, var size: Int) : ShapeDrawable.ShaderFactory() {
            constructor( colors: IntArray, size: Int):this(colors,0.0F,0.0F,size)

            override fun resize(width: Int, height: Int): Shader {
                return RadialGradient(
                    width * positionX,
                    height * positionY,
                    minOf(width, height) * size.toFloat(),
                    colors,
                    null,
                    Shader.TileMode.CLAMP
                )
            }

        }

    }
val ancho = getWidth()
val alto = getHeight().toFloat()
 lateinit var punto:Canvas

var colores = calculateColor(meterValue)
Background del lienzo
 canvas.drawRGB(255,255,255)
withDelay(800){clearcanvas()}
val scaleFactor = scale(0.01f)
canvas.scale(scaleFactor, scaleFactor)
 postInvalidateOnAnimation()
 val linearLayout = findViewById(R.id.view) as LinearLayout

  val animationDrawable = linearLayout.background as AnimationDrawable

animationDrawable.setEnterFadeDuration(2500)
 animationDrawable.setExitFadeDuration(5000)

 animationDrawable.start()

fun radialGradientBackground(vararg colors: Int, positionX: Float = 0.5f, positionY: Float = 0.5f,size: Float): PaintDrawable {
     val radialGradientBackground = PaintDrawable()
     radialGradientBackground.shape = RectShape()
     radialGradientBackground.shaderFactory = ShaderUtils.RadialShaderFactory(colors, positionX, positionY, size)
     return radialGradientBackground

 }*/