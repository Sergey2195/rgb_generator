package com.example.rgb_generator

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi

class ColorController : AppCompatActivity() {
    lateinit var tvColor: TextView
    lateinit var btn: Button
    lateinit var redSeekBar: SeekBar
    lateinit var greenSeekBar: SeekBar
    lateinit var blueSeekBar: SeekBar
    lateinit var setButton: Button
    lateinit var info: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_controller)
        setup()
        setButton.setOnClickListener {
            val color = Color.rgb(redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
            tvColor.setBackgroundColor(color)
            info.text = "red: ${redSeekBar.progress} green: ${greenSeekBar.progress} blue: ${blueSeekBar.progress}"
        }
    }
    fun done(view: View){
        val intent = Intent()
        intent.putExtra("redColor", redSeekBar.progress)
        intent.putExtra("greenColor", greenSeekBar.progress)
        intent.putExtra("blueColor", blueSeekBar.progress)
        setResult(RESULT_OK, intent)
        finish()
    }
    fun setup(){
        tvColor = findViewById(R.id.currentColor)
        btn = findViewById(R.id.btnDone)
        redSeekBar = findViewById(R.id.red_bar)
        greenSeekBar = findViewById(R.id.green_bar)
        blueSeekBar = findViewById(R.id.blue_bar)
        setButton = findViewById(R.id.set_button)
        redSeekBar.progress = 128
        greenSeekBar.progress = 203
        blueSeekBar.progress = 196
        info = findViewById(R.id.textView)
    }
}

