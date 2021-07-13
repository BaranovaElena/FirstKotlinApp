package com.example.firstkotlinapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var incButton: MaterialButton
    private lateinit var incTextView: TextView
    private var value: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        incButton = findViewById(R.id.inc_button)
        incTextView = findViewById(R.id.inc_text_view)
        incTextView.text = value.toString()

        incButton.setOnClickListener {
            value++
            incTextView.text = value.toString()
        }
    }
}