package com.ali.coroutineswithretrofit.network

import com.ali.coroutineswithretrofit.model.Post
import retrofit2.http.GET
/**
 * Created by Taiyab Ali on 07-Dec-20.
 */

interface Api {

    @GET("posts")
    suspend fun getAllPost() : List<Post>          // suspend for background task
}