package com.example.democustomview.widget.compoundview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.democustomview.R
import kotlinx.android.synthetic.main.view_color_options.view.*

class ColorOptionsView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        setAttribute(context, attrs)
    }

    @SuppressLint("ResourceAsColor")
    fun setAttribute(context: Context, attrs: AttributeSet?) {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorOptionsView, 0, 0)
        val titleText: String? = typedArray.getString(R.styleable.ColorOptionsView_titleText)
        val valueColor: Int = typedArray.getColor(R.styleable.ColorOptionsView_valueColor, android.R.color.holo_green_dark)
        typedArray.recycle()

        val view: View = LayoutInflater.from(context).inflate(R.layout.view_color_options, this, true)
        view.textViewTitle.text = titleText
        view.viewColor.setBackgroundColor(valueColor)
    }
}

