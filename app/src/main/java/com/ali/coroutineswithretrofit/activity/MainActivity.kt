package com.ali.coroutineswithretrofit.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ali.coroutineswithretrofit.R
import com.ali.coroutineswithretrofit.adapter.PostAdapter
import com.ali.coroutineswithretrofit.model.Post
import com.ali.coroutineswithretrofit.repository.PostRepo
import com.ali.coroutineswithretrofit.viewmodel.PostViewModel
import com.ali.coroutineswithretrofit.viewmodel.PostViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Taiyab Ali on 07-Dec-20.
 */

class MainActivity : AppCompatActivity() {

    //    lateinit  -  it is promise to the compiler that value will be init in future
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    val isLoadingData: Boolean = true
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()


        val postRepo = PostRepo()
        val viewModelFactory = PostViewModelFactory(postRepo)

        postViewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost() // fetch on IO thread
        postViewModel.my_response.observe(this, Observer {

            postAdapter.setPostData(it as ArrayList<Post>) // back on UI thread
            Log.d("xyzT", it[0].title)
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }


    private fun initRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView)
        postAdapter = PostAdapter(this, ArrayList())

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }

    }
}