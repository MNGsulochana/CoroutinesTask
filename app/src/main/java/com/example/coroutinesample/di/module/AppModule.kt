package com.example.coroutinesample.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.coroutinesample.adapter.PostAdapter
import com.example.coroutinesample.api.ApiInterface
import com.example.coroutinesample.constants.Utils
import com.example.coroutinesample.db.AppDataBase
import com.example.coroutinesample.di.scope.AppScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule (private  val  mApplication:Application){

    @Singleton
    @Provides
    @AppScope
    internal fun provideContext(): Context {
        return mApplication.applicationContext
    }

    companion object {

        @Provides
        @Singleton
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        }

        @Provides
        fun provideSessionApi(retrofit: Retrofit): ApiInterface {
            return retrofit.create(ApiInterface::class.java)
        }

        @Provides
        open fun providePostAdapter(): PostAdapter {
            return PostAdapter()
        }


        @JvmStatic
        @Singleton
        @Provides
        fun provideIoDispatcher() = Dispatchers.IO

    }


}