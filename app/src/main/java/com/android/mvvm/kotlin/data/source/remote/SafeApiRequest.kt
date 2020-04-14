package com.android.mvvm.kotlin.data.source.remote

import com.android.mvvm.kotlin.data.Result
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>): Result<T> {
        val response = call.invoke()
        if (response.isSuccessful){
            return Result.Success(response.body()!!)
        } else {
            return Result.Error(response.code().toString(), response.message().toString())
        }
    }
}

class ApiException(message: String) : IOException(message)