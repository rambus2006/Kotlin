package com.example.retrofitstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val githubService = retrofit.create(GitHubService::class.java)
        val productService=retrofit.create(ProductService::class.java)
        //val call : Call<Product> = productService.getProduct("1")
        val call=productService.getProduct(1)

        call.enqueue(object: Callback<Product>{
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                val body = response.body() as Product
                body?.let{
                    Log.d("mytag",it.toString())
                    findViewById<TextView>(R.id.id).text=it.id.toString()
                    findViewById<TextView>(R.id.id_title).text=it.title.toString()
                    findViewById<TextView>(R.id.id_description).text=it.description.toString()
                    findViewById<TextView>(R.id.id_discountPercentage).text=it.discountPercentage.toString()

                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("mytag","실패")
            }
            val call = githubService.getRepos("Bearer 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", "rambus2006")
            call.enqueue(object : Callback<List<GitHubRepo>> {
                override fun onResponse(
                    call: Call<List<GitHubRepo>>,
                    response: Response<List<GitHubRepo>>
                ) {
                    val repos = response.body() as List<GitHubRepo>
                    repos?.let {
                        Log.d("mytag", repos.toString())
                    }
                }

                override fun onFailure(call: Call<List<GitHubRepo>>, t: Throwable) {
                }
            }
            })
        val searchRepoBtn = findViewById<Button>(R.id.search_repo_btn)
        searchRepoBtn.setOnClickListener {
            val username = userIdInput.text.toString()
            val intent = Intent(this, RepoListActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }


    }
}