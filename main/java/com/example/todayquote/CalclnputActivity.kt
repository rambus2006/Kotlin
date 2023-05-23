package com.example.todayquote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CalclnputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calclnput)

        val intent = Intent(this, CalcResultActivity::class.java)
        // putExtra 메서드 호출해서 전달할 값을 추가
        intent.putExtra("key1", 1)

    }
}