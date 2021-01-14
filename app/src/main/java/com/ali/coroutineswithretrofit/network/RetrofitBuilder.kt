package com.ali.coroutineswithretrofit.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Taiyab Ali on 14-Jan-20.
 */


class RetrofitBuilder {

    companion object
    {
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Url.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: Api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}