package com.example.emqtest

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *@author : Administrator
 *@descreption :
 */
class MainPresent<MainView> {
    var mView :MainView? = null
    fun bindView(view :MainView){
        mView = view
    }
    var mOkHttpClient:OkHttpClient? = null
    fun login(map: Map<String, String>):Call<Any> {
        val api: Api = Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create()).build().create(Api::class.java)
        return api.login(map)
    }

    private fun getClient(): OkHttpClient {
        if (mOkHttpClient==null){
            mOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS)
                .build()
        }
        return mOkHttpClient!!
    }

    private fun getInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}