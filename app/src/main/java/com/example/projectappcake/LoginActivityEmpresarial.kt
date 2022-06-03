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

class LoginActivityEmpresarial : AppCompatActivity() {

    companion object{
        lateinit var usernit: String
        lateinit var providerSession: String
    }

    private var nit by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()
    private lateinit var etNit: EditText
    private lateinit var etPassword: EditText
    private lateinit var termsCond: CheckBox

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_empresarial)

        termsCond = findViewById(R.id.checkAccept)
        termsCond.visibility = View.INVISIBLE

        etNit = findViewById(R.id.textNit)
        etPassword = findViewById(R.id.textUserPass)
        mAuth = FirebaseAuth.getInstance() //instancia para operar

        val btnRegister = findViewById<Button>(R.id.btnRegisterEmpresarial)
        btnRegister.setOnClickListener {
            createAccount()
        }

        manageButtonLogin()
        etNit.doOnTextChanged { text, start, before, count -> manageButtonLogin() }
        etPassword.doOnTextChanged { text, start, before, count -> manageButtonLogin() }

    }

    private fun manageButtonLogin(){

        var tvLogEmpresarial = findViewById<TextView>(R.id.tvLogEmpresarial)
        nit = etNit.text.toString()
        password = etPassword.text.toString()

        if(TextUtils.isEmpty(password) || ValidateNit.isNit(nit) == false){
            tvLogEmpresarial.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            tvLogEmpresarial.isEnabled = false
        }else{
            tvLogEmpresarial.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
            tvLogEmpresarial.isEnabled = true
        }
    }


    fun login(view: View){
        loginEmpresarialUser()
    }

    private fun loginEmpresarialUser(){
        nit = etNit.text.toString()
        password = etPassword.text.toString()

        mAuth.signInWithEmailAndPassword(nit, password)
            .addOnCompleteListener(this){ task-> //Nos muestra si el inicio de sesion se completo
                if(task.isSuccessful) catalogue(nit, "nit")
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

    fun catalogue(nit: String, provider: String){

        usernit = nit
        providerSession = provider

        val intent = Intent(this, CatalogueActivity::class.java)
        startActivity(intent)
    }

    private fun profile(){

        nit = etNit.text.toString()
        password = etPassword.text.toString()

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(nit, password)//Error en el nit de el login empresarial
            .addOnCompleteListener{
                if(it.isSuccessful){

                    var dateRegister = SimpleDateFormat("dd/MM/yyyy").format(Date())
                    var dbRegister = FirebaseFirestore.getInstance()
                    dbRegister.collection("user").document(nit).set(hashMapOf(
                        "user" to nit,
                        "dateRegister" to dateRegister
                    ))
                    catalogue(nit, "nit")

                }else{
                    Toast.makeText(this, "Error, algo ha ido mal!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun createAccount(){

        val intent = Intent(this, CreateAccountEmpresarial::class.java)
        startActivity(intent)

    }

}