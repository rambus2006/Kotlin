package com.example.todayquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CalcResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)

        val num1 = intent.getIntExtra("num1",-1)
        val num2 = intent.getIntExtra("num2",-1)
        val op = intent.getStringExtra("op")

        if(op=="+"){

        }


    }
}