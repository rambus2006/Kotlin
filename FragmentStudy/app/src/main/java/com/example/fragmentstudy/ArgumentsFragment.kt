package com.example.fragmentstudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ArgumentsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.arguments_fragment,
            container,
            false)

        arguments?.getString("mykey")?.let {
            view.findViewById<TextView>(R.id.arguments_text).text = it
        }

        return view
    }

    companion object {
        fun newInstance(text: String)
            : ArgumentsFragment {
            val fragment = ArgumentsFragment()
            val bundle = Bundle()
            bundle.putString("mykey", text)
            fragment.arguments = bundle
            return fragment
        }
    }

}