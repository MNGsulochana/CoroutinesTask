package com.example.coroutinesample.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesample.R
import com.example.coroutinesample.adapter.PostAdapter
import com.example.coroutinesample.api.ApiInterface
import com.example.coroutinesample.datamodel.PostModelItem
import com.example.coroutinesample.db.AppDataBase
import com.example.coroutinesample.di.scope.AppScope
import com.example.coroutinesample.di.scope.DbInfo
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    lateinit var recyclerView: RecyclerView
   // private lateinit var postAdapter: PostAdapter

    @Inject
    lateinit var apiInterface: ApiInterface

    @Inject
    lateinit var postAdapter: PostAdapter

    /*@Inject
    @AppScope
    lateinit var context: Context*/

    @Inject
    lateinit var appDataBase: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerViewp)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                var postLists = apiInterface.getPosts()
                withContext(Dispatchers.IO)
                {
                    val dbInstance=appDataBase.postDao()
                    dbInstance.insertAllPosts(postLists.body())
                    withContext(Dispatchers.Main)
                    {
                        setAdapter(dbInstance.getAllPosts())
                    }
                }

            } catch (e: Exception) {

            }


        }

    }
    fun setAdapter(postList: List<PostModelItem>?)
    {
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        postList?.let { postAdapter.setPostList(it) }
        recyclerView.adapter = this.postAdapter


    }
}

//https://jsonplaceholder.typicode.com/users
