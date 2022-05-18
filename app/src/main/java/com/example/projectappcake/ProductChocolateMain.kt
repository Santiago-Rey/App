package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView

class ProductChocolateMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_chocolate_main)

        val btnP1 = findViewById<Button>(R.id.btnComprar)
        btnP1.setOnClickListener{
            product1()
        }

        val btnP2 = findViewById<Button>(R.id.btnComprar1)
        btnP2.setOnClickListener{
            product2()
        }

        val btnP3 = findViewById<Button>(R.id.btnComprar2)
        btnP3.setOnClickListener{
            product3()
        }

    }

    fun showProductOne(v: View){
        selectProduct("tortachocolate")
    }

    fun showProductTwo(v: View){
        selectProduct("tortachispaschocolate")
    }

    fun showProductThree(v: View){
        selectProduct("tortachocolatearequipe")
    }

    fun selectProduct(name: String){

        if(name == "tortachocolate"){
            changeImage(R.drawable.tortachocolate)
        }else if (name == "tortachispaschocolate"){
            changeImage(R.drawable.tortachispaschocolate)
        }else{
            changeImage(R.drawable.tortachocolatearequipe)
        }
    }

    fun changeImage(image: Int){
        val img = findViewById<ImageView>(R.id.productImage)
        img.setImageResource(image)
    }

    fun product1(){
        val intent = Intent(this, SelectionProduct::class.java)
        startActivity(intent)
    }

    fun product2(){
        val intent = Intent(this, SelectionProduct::class.java)
        startActivity(intent)
    }

    fun product3(){
        val intent = Intent(this, SelectionProduct::class.java)
        startActivity(intent)
    }
}