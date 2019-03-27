package com.example.democustomview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.democustomview.widget.customview.TouchEventView

class MainActivity : AppCompatActivity() {
    private lateinit var touchEventView: TouchEventView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        touchEventView = findViewById(R.id.touchView)
    }

    fun onButtonEraseClicked(view: View) {
        touchEventView.erase()
    }
}
