package com.ali.coroutineswithretrofit.repository

import com.ali.coroutineswithretrofit.model.Post
import com.ali.coroutineswithretrofit.network.RetrofitBuilder


/**
 * Created by Taiyab Ali on 07-Dec-20.
 */

//  Suspend function is a function that could be started, paused, and resume.
// call getPost function for getting all data from Api Interface


class PostRepo {

    suspend fun getPost(): List<Post> = RetrofitBuilder.api.getAllPost()
}