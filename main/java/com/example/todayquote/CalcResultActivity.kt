package com.example.todayquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CalcResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)

        val resultText = findViewById<TextView>(R.id.result)
        val num1 = intent.getIntExtra("num1",-1)
        val num2 = intent.getIntExtra("num2",-1)
        val op = intent.getStringExtra("op")

        if(op=="+"){
            val result = num1 + num2
            resultText.text = result.toString()
        }
        val closeButton = findViewById<Button>(R.id.close)
        closeButton.setOnClickListener{
            this.finish()
        }

    }
}