package com.example.todayquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuoteListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qoute_list_activity)

        val value = intent.getIntExtra("key1",1)
        val value2 = intent.getDoubleExtra("key2",3.2)
        val value3 = intent.getIntExtra("key3",4)
        Log.d("mytag",value.toString())
    }
}


