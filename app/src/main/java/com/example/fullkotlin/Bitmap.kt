package com.example.fullkotlin

import android.graphics.*
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Bitmap : AppCompatActivity() {

    var bitmap: Bitmap? = null
    var canvas: Canvas? = null
    var paint: Paint? = null
    var paint2: Paint? = null
    var paint3: Paint? = null

    var imageView: ImageView? = null
    var fontsize = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap)

// this is for check the time complexity
        Log.d("timeCheck-", System.currentTimeMillis().toString())
        // here we get the display width or height.
        val currentdisplay = windowManager.defaultDisplay
        val dw = currentdisplay.width.toFloat()
        val dh = currentdisplay.height.toFloat()
        Log.i("width", dw.toString())
        Log.i("height", dh.toString())

        // here we get the display centerX or centerY
        val centerX = currentdisplay.width.toFloat() / 2
        val centerY = currentdisplay.height.toFloat() / 2

        imageView = findViewById<ImageView>(R.id.bitmap)


        // here we create the Bitmap on imageView
        bitmap = Bitmap.createBitmap(dw.toInt(), dh.toInt(), Bitmap.Config.ARGB_8888)
        canvas = Canvas(bitmap!!)
        imageView!!.setImageBitmap(bitmap)

        paint = Paint()
        paint!!.color = Color.BLACK
        fontsize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15f, resources.displayMetrics).toInt()
        paint!!.textSize = fontsize.toFloat()

        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = 5f
        //////////////////////////////////////////

        paint2 = Paint()
        paint2!!.color = Color.BLACK
        val dashPath = DashPathEffect(floatArrayOf(10f, 10f), 10.0.toFloat())
        paint2!!.pathEffect = dashPath
        paint2!!.style = Paint.Style.FILL_AND_STROKE

        canvas!!.drawCircle(centerX,centerY,centerX - 50 , paint!!)
        canvas!!.drawLine(50f, dh / 2, dw - 50, dh / 2, paint!!)

        paint3 = Paint()
        paint3!!.color = Color.YELLOW
        paint3!!.textSize = 20f
        imageView!!.setImageBitmap(bitmap)
        //////////////////
        val width = 800f
        val height = 800f
        val left = 100f
        val top = 200f
        val right = left + width
        val bottom = top + height

        canvas!!.drawArc(left, top, right, bottom, 30f, 300f, true, paint3!!)


        Log.d("timeCheck--", System.currentTimeMillis().toString())

    }
}