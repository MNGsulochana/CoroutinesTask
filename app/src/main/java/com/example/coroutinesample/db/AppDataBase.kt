package com.example.coroutinesample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coroutinesample.datamodel.PostModelItem
import dagger.Provides
import kotlin.reflect.KClass


@Database(entities = [PostModelItem::class], version = 1)
abstract class AppDataBase :RoomDatabase(){
    abstract fun postDao():PostDao


}