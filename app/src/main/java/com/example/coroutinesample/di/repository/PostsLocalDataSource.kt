package com.example.coroutinesample.di.repository

import com.example.coroutinesample.datamodel.PostModelItem
import com.example.coroutinesample.db.PostDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.coroutinesample.di.repository.Result


class PostsLocalDataSource internal constructor(
        private val postsDao: PostDao,
        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PostDataSource {


    override suspend fun getPosts() : Result<List<PostModelItem>> = withContext(ioDispatcher)
    {
        return@withContext try {
            Result.Success(postsDao.getAllPosts())
        }catch (e: Exception)
        {
            Result.Error(e)
        }


    }
}

