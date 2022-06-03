package com.example.projectappcake

import java.util.regex.Matcher
import java.util.regex.Pattern

class ValidateNit {

    companion object{
        var pat: Pattern?= null //Creamos un patrón
        var mat: Matcher?= null //Generamos la búsqueda

        fun isNit(nit: String):Boolean{
            pat = Pattern.compile("[0-9]{9,15}$") //Estructura de caracteres para cumplir con el email
            mat = pat!!.matcher(nit) //verificación del email con el patrón
            return mat!!.find()
        }
    }
}