package com.example.projectappcake

import java.util.regex.Matcher
import java.util.regex.Pattern

class ValidateEmail {

    companion object{
        var pat: Pattern?= null //Creamos un patrón
        var mat: Matcher?= null //Generamos la búsqueda

        fun isEmail(email: String):Boolean{
            pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9]+\\.)+[A-Za-z]{2,4}$") //Estructura de caracteres para cumplir con el email
            mat = pat!!.matcher(email) //verificación del email con el patrón
            return mat!!.find()
        }
    }
}