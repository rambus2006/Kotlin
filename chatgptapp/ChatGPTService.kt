package com.example.chatgptapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

// 응답 관련
data class ChoiceMessage(val content: String)
data class Choice(val message: ChoiceMessage)
data class GPTResponse(val choices: List<Choice>)

// 요청 관련
data class Message(val role: String,
                   val content: String)
data class GPTRequest(val messages: List<Message>,
                      val model: String="gpt-3.5-turbo") {
    companion object {
        fun create(content: String) : GPTRequest {
            val message = Message("user", content)
            val request = GPTRequest(listOf(message))
            return request
        }
    }
}

interface ChatGPTService {
    @Headers("Content-Type: application/json")
    @POST("/v1/chat/completions")
    fun chat(
        @Header("Authorization") apiKey: String,
        @Body gptRequest: GPTRequest
    ) : Call<GPTResponse>
}