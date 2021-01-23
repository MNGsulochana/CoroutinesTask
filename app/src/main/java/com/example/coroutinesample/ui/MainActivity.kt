package com.example.coroutinesample.ui


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesample.R
import com.example.coroutinesample.adapter.PostAdapter
import com.example.coroutinesample.api.apiClient
import com.example.coroutinesample.datamodel.PostModelItem
import com.example.coroutinesample.db.AppDataBase
import kotlinx.coroutines.*


//https://jsonplaceholder.typicode.com/users
class MainActivity : AppCompatActivity() {

    lateinit var  recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerViewpost)
        val client = apiClient.getClient()
        GlobalScope.launch {
            val resultPosts = client.getPosts()
            withContext(Dispatchers.IO)
            {
                val dbInstance=AppDataBase.getDatabase(this@MainActivity)

                if (resultPosts.isSuccessful) {
                        Log.d("getvalues","${resultPosts.body()}")
                    val postList:List<PostModelItem> = resultPosts.body()!!
                   // for (i in postList)
                       // dbInstance?.postDao()?.insertPost(i)
                        dbInstance?.postDao()?.insertAllPosts(postList)

                    postAdapter = PostAdapter(dbInstance?.postDao()?.getAllPosts() as ArrayList,context = this@MainActivity)
                    withContext(Dispatchers.Main)
                    {
                        setAdapter(postAdapter)
                    }
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
