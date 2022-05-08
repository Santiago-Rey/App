package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CatalogueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogue)

        val buttomChocolate = findViewById<TextView>(R.id.textChocolate)
        buttomChocolate.setOnClickListener{
            selectChocolate()
        }
    }

    fun selectChocolate(){
        val intent = Intent(this, ProductChocolateMain::class.java)
        startActivity(intent)
    }
}