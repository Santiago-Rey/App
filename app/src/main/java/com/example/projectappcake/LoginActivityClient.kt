package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivityClient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_client)

        val buttomCatalog = findViewById<Button>(R.id.btnLogClient)
        buttomCatalog.setOnClickListener{
            catalogue()
        }

        val buttomRegister = findViewById<Button>(R.id.btnRegister)
        buttomRegister.setOnClickListener {
            profile()
        }
    }

    fun catalogue(){
        val intent = Intent(this, CatalogueActivity::class.java)
        startActivity(intent)
    }



    fun profile(){

        val intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)

    }
}