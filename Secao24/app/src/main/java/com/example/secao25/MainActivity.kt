package com.example.secao25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkbox_treinar.setOnClickListener{
            otherColor()
        }

    }

    private fun otherColor() = if (checkbox_treinar.isChecked) {
        imageview_joystick.setColorFilter(resources.getColor(R.color.turquesa))
    } else
        imageview_joystick.setColorFilter(resources.getColor(R.color.white))
}
