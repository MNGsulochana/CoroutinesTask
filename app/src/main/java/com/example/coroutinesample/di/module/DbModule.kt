package com.example.coroutinesample.di.module

import android.content.Context
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.room.Room
import com.example.coroutinesample.db.AppDataBase
import com.example.coroutinesample.db.PostDao
import com.example.coroutinesample.di.scope.AppScope
import com.example.coroutinesample.di.scope.DbInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun provideDatabase(@AppScope context: Context,@DbInfo dbname:String): AppDataBase{
        return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                dbname).build()
    }

    @Provides
    @DbInfo
    fun provideDatabaseName(): String{
        return "PostLists.db"
    }

    @Singleton
    @Provides
    fun providePostDao(db: AppDataBase): PostDao {
        return db.postDao()
    }


}