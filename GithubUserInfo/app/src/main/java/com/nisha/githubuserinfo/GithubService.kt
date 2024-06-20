package com.nisha.githubuserinfo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String):GithubUser

    companion object{
        private const val BASE_URL = "https://api.github.com/"

        fun create():GithubService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(GithubService::class.java)
        }
    }
}