package org.kmebin.seminar28th.api

import org.kmebin.seminar28th.data.request.RequestLoginData
import org.kmebin.seminar28th.data.request.RequestSignUpData
import org.kmebin.seminar28th.data.response.ResponseLoginData
import org.kmebin.seminar28th.data.response.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>

    @POST("/login/signup")
    fun postSignUp(
        @Body body: RequestSignUpData
    ): Call<ResponseSignUpData>
}