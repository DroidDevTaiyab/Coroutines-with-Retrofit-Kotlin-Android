package com.ali.coroutineswithretrofit.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Taiyab Ali on 07-Dec-20.
 */

data class Post(
        val id: String,
        val title: String,
        val body: String)
