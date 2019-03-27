package com.example.democustomview.widget.compoundview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.democustomview.R
import kotlinx.android.synthetic.main.demo_view.view.*

class DemoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        setAttribute(context, attrs)
    }

    @SuppressLint("ResourceAsColor")
    fun setAttribute(context: Context, attrs: AttributeSet?) {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.DemoView, 0, 0)
        val hintText: String? = typedArray.getString(R.styleable.DemoView_hintText)
        val valueColor: Int = typedArray.getColor(R.styleable.DemoView_valueColorIcon, android.R.color.transparent)
        typedArray.recycle()

        val view: View = LayoutInflater.from(context).inflate(R.layout.demo_view, this, true)
        view.demoViewEditText.hint = hintText
        view.demoViewButtonRecord.setBackgroundColor(valueColor)
        view.demoViewButtonArrowDropDown.setBackgroundColor(valueColor)
    }
}
