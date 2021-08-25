package com.joelson.delgram.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joelson.delgram.apiService.RetrofitProvider
import com.joelson.delgram.model.LoginUserModel
import com.joelson.delgram.model.SignUpModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    val signUpUsers: MutableLiveData<List<SignUpModel>> = MutableLiveData()
    val loginUsers: MutableLiveData<List<LoginUserModel>> = MutableLiveData()

    fun signUpUser (user: SignUpModel){

           CoroutineScope(Dispatchers.IO).launch {
               try {
               val newSignUp: List<SignUpModel> = RetrofitProvider.service.signUpUser(user)
               signUpUsers.postValue(newSignUp)
           }catch (e: Exception){
               e.printStackTrace()
           }
       }
    }

    fun loginUser (user: LoginUserModel){

        CoroutineScope(Dispatchers.IO).launch {

            try {
                val newLogin: List<LoginUserModel> = RetrofitProvider.loginService.loginUser(user)
                loginUsers.postValue(newLogin)

            }  catch (e: Exception){
                e.printStackTrace()
            }

        }
    }
}