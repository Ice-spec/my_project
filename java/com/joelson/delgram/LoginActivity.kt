package com.joelson.delgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joelson.delgram.MainActivity
import com.joelson.delgram.databinding.ActivityLoginBinding
import com.joelson.delgram.SignUpActivity


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityLoginBinding: ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(activityLoginBinding.root)

        val tvSignup = activityLoginBinding.signUp
        tvSignup.setOnClickListener {
            val intent: Intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        val tvLogin = activityLoginBinding.btnLogin
        tvLogin.setOnClickListener {
            val loginIntent: Intent = Intent (this@LoginActivity, MainActivity::class.java)
            startActivity(loginIntent)
        }


    }
}