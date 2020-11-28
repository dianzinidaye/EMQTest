package com.example.emqtest

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PartMap

/**
 *@author : Administrator
 *@descreption :
 */
interface Api {
   // @POST("mqtt/auth/")
    @POST("mqtt/authapi/v4/auth_clientid/")
    @FormUrlEncoded
    fun login(@FieldMap args: Map<String, String> ): Call<Any>
}