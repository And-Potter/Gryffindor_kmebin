package org.kmebin.seminar28th.data.response

import com.google.gson.annotations.SerializedName

data class ResponseLoginData(
    val success: Boolean,
    val message: String,
    val data: Data?,
) {
    data class Data(
        @SerializedName("UserId")
        val userId: Int,
        @SerializedName("user_nickname")
        val nickname: String,
        val token: String,
    )
}
