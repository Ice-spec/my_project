package com.joelson.delgram.apiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://ict-del-gram-app.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: SignUpService = retrofit.create(SignUpService::class.java)
    val loginService: LoginService = retrofit.create(LoginService::class.java)
}