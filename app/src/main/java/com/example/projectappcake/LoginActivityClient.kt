package com.example.projectappcake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class LoginActivityClient : AppCompatActivity() {

    companion object{
        lateinit var useremail: String
        lateinit var providerSession: String
    }

    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var termsCond: CheckBox

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_client)

        termsCond = findViewById(R.id.checkAccept)
        termsCond.visibility = View.INVISIBLE

        etEmail = findViewById(R.id.textUserName)
        etPassword = findViewById(R.id.textUserPass)
        mAuth = FirebaseAuth.getInstance() //instancia para operar


        val buttomRegister = findViewById<Button>(R.id.btnRegister)

        buttomRegister.setOnClickListener {
            createAccount()
        }

        manageButtonLogin()//Esta función verifica si escribio correctamente
        etEmail.doOnTextChanged { text, start, before, count -> manageButtonLogin() }
        etPassword.doOnTextChanged { text, start, before, count -> manageButtonLogin() }
    }

    private fun manageButtonLogin(){
        var tvLoginClient = findViewById<TextView>(R.id.tvLogClient)
        email = etEmail.text.toString()
        password = etPassword.text.toString()

        if(TextUtils.isEmpty(password) || ValidateEmail.isEmail(email) == false){
            tvLoginClient.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            tvLoginClient.isEnabled = false
        }else{
            tvLoginClient.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
            tvLoginClient.isEnabled = true
        }
    }

    fun login(view: View){
        loginUser()
    }
    private fun loginUser(){
        email = etEmail.text.toString()
        password = etPassword.text.toString()

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ task-> //Nos muestra si el inicio de sesion se completo
                if(task.isSuccessful) catalogue(email, "email")
                else{
                    if(termsCond.visibility == View.INVISIBLE){
                        termsCond.visibility = View.VISIBLE
                    }else{
                        var checkAccept = findViewById<CheckBox>(R.id.checkAccept)
                        if (checkAccept.isChecked)
                            profile()
                    }
                }
            }

    }

    fun catalogue(email: String, provider: String){

        useremail = email
        providerSession = provider

        val intent = Intent(this, CatalogueActivity::class.java)
        startActivity(intent)
    }



    private fun profile(){

        email = etEmail.text.toString()
        password = etPassword.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){

                    var dateRegister = SimpleDateFormat("dd/MM/yyyy").format(Date())
                    var dbRegister = FirebaseFirestore.getInstance()
                    dbRegister.collection("users").document(email).set(hashMapOf(
                        "user" to email,
                        "dateRegister" to dateRegister
                    ))
                    catalogue(email, "email")

                }else{
                    Toast.makeText(this, "Error, algo ha ido mal!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun createAccount(){
        val intent = Intent(this, CreateAccount::class.java)
        startActivity(intent)

    }
}