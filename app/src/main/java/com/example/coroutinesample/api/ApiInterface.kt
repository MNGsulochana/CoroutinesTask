package com.example.coroutinesample.api

import com.example.coroutinesample.datamodel.PostModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts(): Response<List<PostModelItem>>
}