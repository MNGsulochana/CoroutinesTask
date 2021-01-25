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
        val client = apiClient.getClient()
        GlobalScope.launch {
            val resultPosts = client.getPosts()
            withContext(Dispatchers.Main)
            {

                if (resultPosts.isSuccessful) {
                    postAdapter = PostAdapter(resultPosts.body() as ArrayList)
                    setAdapter(postAdapter)
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
        this.postAdapter.notifyDataSetChanged() //no need of this
    }
}