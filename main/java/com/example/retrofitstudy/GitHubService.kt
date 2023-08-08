package com.example.retrofitstudy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

data class GitHubUser(
    val login : String,
    val avatar_url : String,
    val name : String,
    val public_repos : Int
)

data class GitHubRepo(
    val name: String,
    val html_url: String,
    val stargazers_count: Int,
    val watchers_count: Int,
    val forks_count: Int
)

interface GitHubService {
    @GET("/users/{username}")
    fun getUser(
        @Header("Authorization") auth: String,
        @Path("username") username : String)
            : Call<GitHubUser>

    @GET("/users/{username}/repos")
    fun getRepos(
        @Header("Authorization") auth: String,
        @Path("username") username : String)
            : Call<List<GitHubRepo>>

}