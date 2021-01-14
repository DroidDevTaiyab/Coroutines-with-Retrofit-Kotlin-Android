package com.ali.coroutineswithretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ali.coroutineswithretrofit.model.Post
import com.ali.coroutineswithretrofit.repository.PostRepo
import kotlinx.coroutines.launch


/**
 * Created by Taiyab Ali on 14-Jan-20.
 */


// we will keep data in viewModel, if we rotate your screen in landscape then our data will not be lost.
// viewModel with liveData( with livedata you can change/update/modify ui on live).
// we will fetch all data in viewModel from repo.

class PostViewModel(private val postRepo: PostRepo) : ViewModel() {

    val my_response : MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost() {

        viewModelScope.launch {

            try {

                val response = postRepo.getPost()
                my_response.value = response
                Log.d("main", "Success")

            } catch (e: Exception) {

                Log.d("main", "getmsg- ${e.message}")
            }
        }
    }


}