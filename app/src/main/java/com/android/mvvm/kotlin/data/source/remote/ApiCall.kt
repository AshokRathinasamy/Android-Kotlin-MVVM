package com.android.mvvm.kotlin.data.source.remote

import com.android.mvvm.kotlin.data.source.model.RealestateResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiCall {

    @GET("choldGTFbC?indent=2")
    suspend fun getAllData(): Response<List<RealestateResponse>>

    companion object {
        operator fun invoke(): ApiCall {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.json-generator.com/api/json/get/")
                .build()
                .create(ApiCall::class.java)
        }
    }
}