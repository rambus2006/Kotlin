package com.example.fragmentstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity(), CommunicationFragmentListener {
    override fun sendMessage(msg: String) {
        Log.d("mytag", msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val t = supportFragmentManager.beginTransaction()
//        t.add(R.id.fragment_container, FirstFragment())
//        t.commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FirstFragment())
            .commit()

        findViewById<Button>(R.id.first).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FirstFragment())
                .commit()
        }

        findViewById<Button>(R.id.second).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SecondFragment())
                .commit()
        }

        findViewById<Button>(R.id.args).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ArgumentsFragment.newInstance("Hello"))
                .commit()
        }

        findViewById<Button>(R.id.comm).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CommunicationFragment())
                .commit()
        }

    }


}