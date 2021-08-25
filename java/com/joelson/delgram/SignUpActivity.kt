package com.joelson.delgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.joelson.delgram.databinding.ActivitySignUpBinding
import com.joelson.delgram.model.SignUpModel
import com.joelson.delgram.viewModel.SignUpViewModel

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var sViewModel: SignUpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val tvLogin = binding.login
        tvLogin.setOnClickListener {
            val logIntent: Intent = Intent(this,LoginActivity::class.java)
            startActivity(logIntent)
        }

        sViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        binding.btnSignUp.setOnClickListener {
            signUpNewUser()
            val intent: Intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun signUpNewUser() {
        val fullName = binding.fullName.text.toString()
        val email = binding.email.text.toString()
        val username = binding.username.text.toString()
        val phoneNumber = binding.phoneNumber.text.toString().toInt()
        val stack = binding.stackDropdown.toString()
        val password = binding.password.text.toString()

        if (fullName.isNotEmpty() && email.isNotEmpty() && username.isNotEmpty()
            && phoneNumber != null && stack.isNotEmpty() && password.isNotEmpty()) {

            val myUser = SignUpModel(fullName, email, username, phoneNumber, stack, password)
            sViewModel.apply {
                sViewModel.signUpUser(myUser)
            }
            Toast.makeText(this, "Signup Successful", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_LONG).show()
        }



    }
}