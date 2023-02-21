package com.prabhakar.expensestracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        redirectRegister.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        btnLogin.setOnClickListener {
            if (loginValidation()) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }

    private fun loginValidation(): Boolean {
        var isValidate = true
        if (loginEmail.text == null) {
            isValidate = false
            loginEmail.error = "Please enter the email"
        }
        if (!loginEmail.text.toString().matches(emailPattern)) {
            isValidate = false
            loginEmail.error = "Please enter valid the email"
        }
        if (loginPassword.text.toString().isEmpty()) {
            isValidate = false
            loginPassword.error = "Please enter the password"

        }

        return isValidate
    }
}