package com.example.retrofitstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)

        val username = intent.getStringExtra("username")!!

        val list = findViewById<RecyclerView>(R.id.repo_list)
        list.setHasFixedSize(false)
        list.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val githubService = retrofit.create(GitHubService::class.java)
        val call = githubService.getRepos("Bearer ${Config.API_KEY}", username)
        call.enqueue(object : Callback<List<GitHubRepo>> {
            override fun onResponse(
                call: Call<List<GitHubRepo>>,
                response: Response<List<GitHubRepo>>
            ) {
                val repos = response.body() as List<GitHubRepo>
                repos?.let {
                    list.adapter = RepoListAdapter(it)
                }
            }

            override fun onFailure(call: Call<List<GitHubRepo>>, t: Throwable) {
            }

        })
    }
}