package com.example.coroutinesample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coroutinesample.datamodel.PostModelItem

@Database(entities = arrayOf(PostModelItem::class), version = 1)
abstract class AppDataBase :RoomDatabase(){
    abstract fun postDao():PostDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getDatabase(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDataBase::class.java, "PostLists.db"
                    ).build()
                }
            }
            return INSTANCE
        }

    }
}