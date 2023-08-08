package com.example.recyclerviewstudy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter(val data: List<Contact>) :
    RecyclerView.Adapter<ContactListAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType, parent, false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val nameTextView = holder.view.findViewById<TextView>(R.id.contact_name)
        val phoneTextView = holder.view.findViewById<TextView>(R.id.contact_phone)
        nameTextView.text = item.name
        phoneTextView.text = item.phone
        holder.view.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, ContactDetailActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("phone", item.phone)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun getItemViewType(position: Int): Int {
        return R.layout.contact_item
    }
}