package com.example.coroutinesample.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
@Entity
data class PostModelItem(
    @ColumnInfo(name="body")
    val body: String,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "userId")
    val userId: Int
)*/



data class PostModelItem(
        val body: String,
        val id: Int,
        val title: String,
        val userId: Int
)