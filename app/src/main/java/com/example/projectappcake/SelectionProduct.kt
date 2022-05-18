package com.example.projectappcake

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SelectionProduct : AppCompatActivity() {

    lateinit var textCounts : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_product)

        val drop = findViewById<Spinner>(R.id.spinner1)
        val items = arrayOf("1", "2", "3")
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items)
        drop.adapter = adapter

        val btnBuy = findViewById<Button>(R.id.btnComprarF)
        textCounts = findViewById(R.id.textC)
        textCounts.setTextColor(resources.getColor(android.R.color.holo_red_dark))
        btnBuy.setOnClickListener {
            textCounts.text = "Compra Realizada!"
        }

    }


}