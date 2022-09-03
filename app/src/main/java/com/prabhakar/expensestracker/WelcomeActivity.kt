package com.prabhakar.expensestracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_activity)

        startActivity(Intent(this,MainActivity::class.java))
    }
}