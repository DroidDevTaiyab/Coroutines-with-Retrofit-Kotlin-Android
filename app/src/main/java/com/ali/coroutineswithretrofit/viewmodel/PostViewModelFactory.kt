package com.ali.coroutineswithretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ali.coroutineswithretrofit.repository.PostRepo


/**
 * Created by Taiyab Ali on 14-Jan-20.
 */

class PostViewModelFactory (private val postRepo: PostRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(postRepo) as T
    }
}