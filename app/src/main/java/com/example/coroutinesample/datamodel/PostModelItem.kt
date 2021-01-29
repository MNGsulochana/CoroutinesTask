package com.example.coroutinesample.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.Provides


@Entity(tableName = "PostItems")
data class PostModelItem(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name="body")
    val body: String,

    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "userId")
    val userId: Int
)




