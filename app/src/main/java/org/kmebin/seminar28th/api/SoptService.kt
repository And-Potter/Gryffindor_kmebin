package org.kmebin.seminar28th.api

import org.kmebin.seminar28th.data.request.RequestLoginData
import org.kmebin.seminar28th.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>
}