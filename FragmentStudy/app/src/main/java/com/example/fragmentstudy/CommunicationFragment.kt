package com.example.fragmentstudy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

interface CommunicationFragmentListener {
    fun sendMessage(msg: String)
}

class CommunicationFragment : Fragment() {
    lateinit var listener: CommunicationFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is CommunicationFragmentListener) {
            listener = context
        } else {
            throw Exception("액티비티가 CommunicationFragmentListener를 구현하고 있지 않습니다.")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.communication_fragment,
            container,
            false)

        view.findViewById<Button>(R.id.send_message).setOnClickListener {
            listener.sendMessage("Hello Activity!")
        }

        return view
    }

}