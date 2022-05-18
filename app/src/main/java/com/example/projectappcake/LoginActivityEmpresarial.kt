package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivityEmpresarial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_empresarial)

        val btnCatalog = findViewById<Button>(R.id.btnLoginEmpresarial)
        btnCatalog.setOnClickListener{
            catalogue()
        }

        val btnRegister = findViewById<Button>(R.id.btnRegisterEmpresarial)
        btnRegister.setOnClickListener {
            createAccount()
        }

    }

    fun catalogue(){
        val intent = Intent(this, CatalogueActivity::class.java)
        startActivity(intent)
    }

    fun createAccount(){

        val intent = Intent(this, CreateAccountEmpresarial::class.java)
        startActivity(intent)

    }

}