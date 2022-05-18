package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CreateAccountEmpresarial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account_empresarial)

        val btnLog = findViewById<Button>(R.id.btnEmpresarial)
        btnLog.setOnClickListener{
            loginEmpresarial()
        }
    }

    fun loginEmpresarial(){
        val intent = Intent(this, LoginActivityEmpresarial::class.java)
        startActivity(intent)
    }
}