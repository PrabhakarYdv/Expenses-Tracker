package com.prabhakar.expensestracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    private val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        redirectLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnRegister.setOnClickListener {
            if (signUpValidation()) {
                startActivity(Intent(this, HomeActivity::class.java))

            }
        }
    }

    private fun signUpValidation(): Boolean {
        var isValidate = true
        if (registerName.text == null || registerName.text.isEmpty()) {
            isValidate = false
            registerName.error = "Please enter the name"
        }
        if (registerEmail.text == null) {
            isValidate = false
            registerEmail.error = "Please enter the email"
        }
        if (!registerEmail.text.toString().matches(emailPattern)) {
            isValidate = false
            registerEmail.error = "Please enter valid the email"
        }
        if (registerPassword.text.toString().length < 5) {
            isValidate = false
            registerPassword.error = "Please create a Strong Password"

        }
        if (registerConfirmPass.text.toString() != registerPassword.text.toString()) {
            isValidate = false
            registerConfirmPass.error = "Password and confirm password should be same"
        }
        return isValidate
    }
}