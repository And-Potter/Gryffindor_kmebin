package org.kmebin.seminar28th.data.response

data class ResponseSignUpData(
    val success: Boolean,
    val message: String,
    val data: Data?,
) {
    data class Data(
        val nickname: String,
    )
}