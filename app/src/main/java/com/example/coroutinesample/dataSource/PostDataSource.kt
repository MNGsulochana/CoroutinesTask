package com.example.coroutinesample.dataSource

import com.example.coroutinesample.datamodel.PostModelItem


interface PostDataSource {
    suspend fun insertPost(modelList:List<PostModelItem>)
    suspend fun getTasks(): Result<List<PostModelItem>>
}