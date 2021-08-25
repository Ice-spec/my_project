package com.joelson.delgram.apiService

import com.joelson.delgram.model.LoginUserModel
import com.joelson.delgram.model.SignUpModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SignUpService {
    @POST("api/users/signup")
    suspend fun signUpUser(@Body newUser: SignUpModel)
    : List<SignUpModel>

}