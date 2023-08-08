package com.example.recyclerviewstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val contactNameTextView = findViewById<TextView>(R.id.detail_contact_name)
        val contactPhoneTextView = findViewById<TextView>(R.id.detail_contact_phone)
        contactNameTextView.text = name
        contactPhoneTextView.text = phone

    }
}