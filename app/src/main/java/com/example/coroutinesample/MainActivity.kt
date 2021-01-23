package com.example.coroutinesample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesample.adapter.PostAdapter
import com.example.coroutinesample.api.apiClient
import com.example.coroutinesample.datamodel.PostModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//https://jsonplaceholder.typicode.com/users
class MainActivity : AppCompatActivity() {

    private val postList = ArrayList<PostModelItem>()
lateinit var  recyclerView: RecyclerView
    //  val recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerViewpost)
       // val recyclerView: RecyclerView = findViewById(R.id.recyclerViewpost)
        val client = apiClient.getClient()
        GlobalScope.launch {
            val resultPosts = client.getPosts()
            withContext(Dispatchers.Main)
            {

                if (resultPosts.isSuccessful) {
                    postAdapter = PostAdapter(resultPosts.body() as ArrayList)
                    setAdapter(postAdapter)
                    /*val layoutManager = LinearLayoutManager(applicationContext)
                    recyclerView.layoutManager = layoutManager
                    recyclerView.itemAnimator = DefaultItemAnimator()
                    recyclerView.adapter = postAdapter
                    postAdapter.notifyDataSetChanged()*/
                } else
                    Log.d("fail", "falsls")
            }
        }
    }

    fun setAdapter(postAdapter: PostAdapter)
    {
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = this.postAdapter
        this.postAdapter.notifyDataSetChanged()
    }
}
// postAdapter= PostAdapter(postList)
// val layoutManager = LinearLayoutManager(applicationContext)
// recyclerView.layoutManager = layoutManager
// recyclerView.itemAnimator = DefaultItemAnimator()
// recyclerView.adapter = postAdapter
// postAdapter.notifyDataSetChanged()
// }
// getRecyclerView(resultPosts.body())
// // Log.d("success", "get successs ${resultPosts.body()?.size} dta values ${resultPosts.body()?.get(99)?.id}")
// else
// Log.d("fail", "falsls")
// }
// }
//
//
// //  moviesAdapter = MoviesAdapter(movieList)
// /*     postAdapter= PostAdapter(postList)
// val layoutManager = LinearLayoutManager(applicationContext)
// recyclerView.layoutManager = layoutManager
// recyclerView.itemAnimator = DefaultItemAnimator()
// recyclerView.adapter = postAdapter
// postAdapter.notifyDataSetChanged()
// *//*
//
//
// }
//
// private fun getRecyclerView(body: List<PostModelItem>? ) {
// postList.addAll(body as ArrayList)
// postAdapter= PostAdapter(postList)
//
// /*val layoutManager = LinearLayoutManager(applicationContext)
// recyclerView.layoutManager = layoutManager
// recyclerView.itemAnimator = DefaultItemAnimator()
// recyclerView.adapter = postAdapter*//*
//
// postAdapter.notifyDataSetChanged()
//
// }
// }*/