package com.example.chatgptapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import io.noties.markwon.Markwon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val API_KEY = "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"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val markwon = Markwon.builder(this).build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openai.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val gptService = retrofit.create(ChatGPTService::class.java)
        val queryInput = findViewById<EditText>(R.id.query_input)
        val queryBtn = findViewById<Button>(R.id.query_btn)
        val conversations = findViewById<LinearLayout>(R.id.conversations)
        queryBtn.setOnClickListener {
            val queryMessage = queryInput.text.toString().trim()
            if(queryMessage.isEmpty()) {
                Toast.makeText(
                    this,
                    "질문을 제대로 입력하세요.",
                    Toast.LENGTH_SHORT).show()
            } else {
                //queryBtn.isEnabled="false"
                val call = gptService.chat(
                    "Bearer ${API_KEY}",
                    GPTRequest.create(queryMessage)
                )
                call.enqueue(object : Callback<GPTResponse> {
                    override fun onResponse(
                        call: Call<GPTResponse>,
                        response: Response<GPTResponse>
                    ) {
                        val response = response.body() as GPTResponse
                        response?.let {
                            val inflater=LayoutInflater.from(this@MainActivity)
                            val view = inflater.inflate(R.layout.conversation_item,
                            null,false)
                            val reply = it.choices[0].message.content
                            val queryText = view.findViewById<TextView>(R.id.query_text)
                            val replyText = view.findViewById<TextView>(R.id.reply_text)
                            queryText.text="Q)" + queryMessage
                            markwon.setMarkdown(replyText,"A\n" + reply)
                            replyText.text="A)\n" + reply
                            conversations.addView(view)
                            //Log.d("mytag", it.choices[0].message.content)
                        }
                        queryInput.setText("")
                        queryBtn.isEnabled=true
                    }
                    override fun onFailure(call: Call<GPTResponse>, t: Throwable) {
                        queryBtn.isEnabled = true
                    }
                })

            }
        }

    }
}