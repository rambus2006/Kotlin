package com.example.recyclerviewstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Contact(var name:String,var phone:String)

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val contacts = mutableListOf<Contact>()
        for(i in 1..100){
            contacts.add(Contact("아무개 ${i}", "010-1234-0${i.toString().padStart(3, '0')}"))
        }

        val contactList = findViewById<RecyclerView>(R.id.contact_list)
        contactList.setHasFixedSize(false)
        contactList.layoutManager = LinearLayoutManager(this)
        contactList.adapter = ContactListAdapter(contacts)
    }
}