package com.example.coroutinesample.api

import com.example.coroutinesample.constants.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiClient {
    fun getClient(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}