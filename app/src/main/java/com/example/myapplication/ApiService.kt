package com.example.myapplication

import com.example.myapplication.models.Comment
import com.example.myapplication.models.Post
import com.example.myapplication.models.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("users")
    fun getUsers() : Call<List<User>>

    @GET("users/{id}/posts")
    fun getPostByUser(@Path("id") id : Int): Call<List<Post>>


    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create() : ApiService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}
