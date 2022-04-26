package com.example.rgb_generator

import android.app.Instrumentation
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var btnToChange: Button
    lateinit var background: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnToChange = findViewById(R.id.setting_color)
        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val redColor = it.data?.getIntExtra("redColor", -1)
                val greenColor = it.data?.getIntExtra("greenColor", -1)
                val blueColor = it.data?.getIntExtra("blueColor", -1)
                val resultColor = Color.rgb(redColor!!, greenColor!!, blueColor!!)
                background = findViewById(R.id.user_constraint_layout)
                background.setBackgroundColor(resultColor)
            }
        }
        btnToChange.setOnClickListener {
            launcher.launch(Intent(this, ColorController::class.java))
        }
    }

}