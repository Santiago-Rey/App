package com.example.projectappcake

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttomC = findViewById<Button>(R.id.btnCliente)
        buttomC.setOnClickListener {
            loginClient()
        }
        val buttomE = findViewById<Button>(R.id.btnEmpresarial)
        buttomE.setOnClickListener {
            loginEmpresarial()
        }



    }



    fun loginClient() {
       val intent = Intent(this, LoginActivityClient::class.java)
        startActivity(intent)
    }

    fun loginEmpresarial() {
        val intent = Intent(this, LoginActivityEmpresarial::class.java)
        startActivity(intent)
    }

}