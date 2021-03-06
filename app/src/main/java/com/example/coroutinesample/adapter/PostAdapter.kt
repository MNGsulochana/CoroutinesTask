package com.example.coroutinesample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesample.R
import com.example.coroutinesample.datamodel.PostModelItem

class PostAdapter(private var postsList:List<PostModelItem>) :RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    class PostViewHolder(view:View):RecyclerView.ViewHolder(view)
    {
        var title: TextView = view.findViewById(R.id.textTitle)
        var id: TextView = view.findViewById(R.id.textId)
        var body: TextView = view.findViewById(R.id.textBody)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_values, parent, false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val posts = postsList[position]
        holder.title.text = "TITLE :   "+posts.title
        holder.id.text = "ID :   "+posts.id
        holder.body.text = "BODY :  "+posts.body
    }

    override fun getItemCount(): Int {
      return postsList.size
    }
}
/*
internal class MoviesAdapter(private var moviesList: List<MovieModel>) :
    RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var year: TextView = view.findViewById(R.id.year)
        var genre: TextView = view.findViewById(R.id.genre)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.getTitle()
        holder.genre.text = movie.getGenre()
        holder.year.text = movie.getYear()
    }
    override fun getItemCount(): Int {
        return moviesList.size
    }
}*/
