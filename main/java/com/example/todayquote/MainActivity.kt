package com.example.todayquote

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.indexOf
import android.util.Log
import android.widget.*
import com.example.todayquote.R.id.*
import kotlin.random.Random


import kotlin.collections.indexOf as indexOf

class MainActivity : AppCompatActivity() {
    //2023-05-23
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calclnput)

        val num1Text = findViewById<EditText>(R.id.num1)
        val num2Text = findViewById<EditText>(R.id.num2)
        val plusButton = findViewById<Button>(R.id.plus)
        plusButton.setOnClickListener{
            val num1Str = num1Text.text.toString()
            val num2Str = num2Text.text.toString()
            //공백문자를 넣는 것을 방지
            if(num1Str.isNotBlank()&&num2Str.isNotBlank()){
                val num1 = num1Text.text.toString().trim().toInt()
                val num2 = num2Text.text.toString().trim().toInt()

                val intent = Intent(this,CalcResultActivity::class.java)
                intent.putExtra("num1",num1)
                intent.putExtra("num2",num2)
                intent.putExtra("op", "+")

                startActivity(intent)
            }else{
                Toast.makeText(this,"잘못된 입력값",
                    Toast.LENGTH_SHORT).show()

            }

        }

    }
    /*
    lateinit var quotes : MutableList<Quote>
    lateinit var pref : SharedPreferences

    fun initializeQuotes() {
        // Q) 처음 사용자가 앱을 키면 아무 명언이 없으니까 5개의 명언을 추가하는데,
        // 그 이후에 켰을때는 아무것도 안하게 하고 싶음
        // "initialized"라는 키가 있어서 boolean 타입 값을 저장하는데
        // 이게 false 면 지금 처음 켜는거, true면 그 이후킨거
        // val pref = getSharedPreferences("quotes", Context.MODE_PRIVATE)
        val initialized = pref.getBoolean("initialized", false)
        if(!initialized) {
            // 임시 명언 5개를 추가
            for(i in 0..5) {
                Quote.saveToPreferences(pref, i, "명언 ${i}", "출처 ${i}")
            }
        }
        val editor = pref.edit()
        editor.putBoolean("initialized", true)
        editor.apply()

        fun button1(){

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = getSharedPreferences("quotes", MODE_PRIVATE)
        initializeQuotes()

        quotes = Quote.getQuotesFromPreference(pref)
        val index = Random.nextInt(0, quotes.size)
        val randomQuote = quotes[index]
        val quoteText = findViewById<TextView>(R.id.quote_text)
        val quoteFrom = findViewById<TextView>(R.id.quote_from)
        quoteText.text = randomQuote.text
        quoteFrom.text = randomQuote.from

        val toList=findViewById<Button>(R.id.quote_list)
        toList.setOnClickListener{
            val intent= Intent(this,
                                CalclnputActivity::class.java)
            intent.putExtra("key1",1)
            intent.putExtra("key2",3.2)
            intent.putExtra("key3",4)
            startActivity(intent) //
        }
    }*/

}