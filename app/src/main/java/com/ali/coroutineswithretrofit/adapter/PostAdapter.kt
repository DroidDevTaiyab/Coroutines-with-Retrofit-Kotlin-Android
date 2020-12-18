package com.ali.coroutineswithretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ali.coroutineswithretrofit.R
import com.ali.coroutineswithretrofit.model.Post

/**
 * Created by Taiyab Ali on 07-Dec-20.
 */

class PostAdapter(private val context: Context, private var postList: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        return PostViewHolder(
            LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val post = postList[position]

        holder.id.text = post.id
        holder.title.text = post.title
        holder.body.text = post.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.post_id)
        val title: TextView = itemView.findViewById(R.id.post_title)
        val body: TextView = itemView.findViewById(R.id.post_body)
    }

    fun setPostData(postList: ArrayList<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }


}