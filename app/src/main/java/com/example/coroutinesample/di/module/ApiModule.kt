package com.example.coroutinesample.di.module

import com.example.coroutinesample.adapter.PostAdapter
import com.example.coroutinesample.api.ApiInterface
import com.example.coroutinesample.dataSource.PostDataSource
import com.example.coroutinesample.dataSource.PostsLocalDataSource
import com.example.coroutinesample.db.AppDataBase
import com.example.coroutinesample.di.scope.ActivityScope
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