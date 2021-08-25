package com.joelson.delgram.apiService

import com.joelson.delgram.model.LoginResponse
import com.joelson.delgram.model.LoginUserModel
import com.joelson.delgram.model.SignUpModel
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/users/login")
    suspend fun loginUser(@Body newUser: LoginUserModel):
            List<LoginUserModel>

}