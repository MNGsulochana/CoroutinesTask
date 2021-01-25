package com.example.coroutinesample.di.repository

import com.example.coroutinesample.datamodel.PostModelItem


interface PostDataSource {
    suspend fun getPosts() : Result<List<PostModelItem>>
}