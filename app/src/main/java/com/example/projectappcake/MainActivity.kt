package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

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

        val btn: Button = findViewById(R.id.btnCatalog)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, CatalogueActivity::class.java)
            startActivity(intent)
        }

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            createProfile()
        }

    }

    fun loginClient() {
       val intent = Intent(this, LoginActivityC::class.java)
        startActivity(intent)
    }

    fun loginEmpresarial() {
        val intent = Intent(this, LoginActivityE::class.java)
        startActivity(intent)
    }


    fun createProfile(){
        val intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)
    }
}