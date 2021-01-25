package com.example.coroutinesample.di.component.scope.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    private var urlPath: String? = null

    fun NetworkModule(urlPath: String?) {
        this.urlPath = urlPath
    }

    @Singleton
    @Provides
    fun provideGson(): Gson? {
        val builder = GsonBuilder()
        return builder.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson?): Retrofit? {
        return Retrofit.Builder()
                .baseUrl(urlPath)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}