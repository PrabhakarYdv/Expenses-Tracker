package com.prabhakar.expensestracker

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        redirectRegister.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        btnLogin.setOnClickListener {
            if (loginValidation()) {
                loginUser()

            }
        }
    }

    private fun loginUser() {
        firebaseAuth.signInWithEmailAndPassword(loginEmail.text.toString(),
            loginPassword.text.toString())
            .addOnSuccessListener {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }
            .addOnCompleteListener {
                Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Some error occur", Toast.LENGTH_SHORT).show()

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