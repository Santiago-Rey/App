package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val buttomC = findViewById<Button>(R.id.btnClient)
        buttomC.setOnClickListener {
            loginClient()
        }
    }

    fun loginClient() {
        val intent = Intent(this, LoginActivityClient::class.java)
        startActivity(intent)
    }
}