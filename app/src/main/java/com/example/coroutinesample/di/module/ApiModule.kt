package com.example.coroutinesample.di.module


import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

//for subcomponent
@Module
abstract class ApiModule {
    companion object
    {
       /* @Provides
        fun provideSessionApi(retrofit: Retrofit): ApiInterface {
            return retrofit.create(ApiInterface::class.java)
        }


        @Provides
        open fun providePostAdapter(): PostAdapter {
            return PostAdapter()
        }*/


    }

}