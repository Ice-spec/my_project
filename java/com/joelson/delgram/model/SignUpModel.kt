package com.joelson.delgram.model

data class SignUpModel(
    val fullName: String,
    val email: String,
    val userName: String,
    val phoneNumber: Int,
    val stack: String,
    val password: String

)