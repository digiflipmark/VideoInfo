package com.example.videoinfo.data.model

import android.icu.util.MeasureUnit.EM
import android.util.Log
import android.util.Patterns
import java.util.regex.Pattern

class Person(fName: String, personAge: Int, email: String, gender: Char) {

    var name = fName
        get() {
            return field.toLowerCase()
        }


    var personage = personAge
        set(value) {
            field = if (value >= 18) {
                value
            } else {
                throw IllegalArgumentException("your age should be higher or equal 18")
            }
        }

    var mail = email
        get() = field
        set(value) {
            field = Patterns.EMAIL_ADDRESS.matcher(value).matches().toString()
        }

    var gen = gender
        set(value) {
            field = if (value=='M') value else throw IllegalArgumentException("User should be male")
        }


    init {
        Log.e("name", ": ${name}", )
        Log.e("personage", ": ${personage}", )
        Log.e("mail", ": ${mail}", )
        Log.e("gen", ": ${gen}", )

    }
}