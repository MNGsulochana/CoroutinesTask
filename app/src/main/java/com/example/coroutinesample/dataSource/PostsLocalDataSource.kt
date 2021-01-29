package com.example.coroutinesample.dataSource

import android.util.Log
import com.example.coroutinesample.api.ApiInterface
import com.example.coroutinesample.datamodel.PostModelItem
import com.example.coroutinesample.db.PostDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.coroutinesample.dataSource.Result.Success
import javax.inject.Inject

class PostsLocalDataSource @Inject constructor(
        private val tasksDao: PostDao,
        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
,private val apiInterface: ApiInterface
) : PostDataSource {

    override suspend fun insertPost(modelList: List<PostModelItem>): Unit = withContext(ioDispatcher){

        val postList= apiInterface.getPosts()
        Log.d("mylist", "insertPost: "+postList.body()?.size)
        tasksDao.insertAllPosts(postList.body() as ArrayList)
    }

    override suspend fun getTasks(): Result<List<PostModelItem>> = withContext(ioDispatcher) {
        return@withContext try {
            //Success(tasksDao.getAllPosts())
            Success{

            }
        } catch (e: Exception) {
            Error(e)
        }

    } as Result<List<PostModelItem>>


}