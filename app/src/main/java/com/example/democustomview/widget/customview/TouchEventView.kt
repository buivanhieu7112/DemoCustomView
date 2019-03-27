package com.example.democustomview.widget.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class TouchEventView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    private lateinit var paint: Paint
    private lateinit var path: Path

    init {
        setAttribute()
    }

    private fun setAttribute() {
        paint = Paint()
        path = Path()

        paint.isAntiAlias = true
        paint.strokeWidth = 10F
        paint.color = Color.BLACK

        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawRect(0F, 0F, width.toFloat(), height.toFloat(), paint)
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val eventX: Float = event.x
        val eventY: Float = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(eventX, eventY)
            }

            MotionEvent.ACTION_MOVE -> path.lineTo(eventX, eventY)

            MotionEvent.ACTION_UP -> {
            }
        }

        // Schedules a repaint.
        invalidate()
        return true
    }

    fun erase() {
        path.reset()
        invalidate()
    }
}
