package com.litecashtop.firebase

import com.google.firebase.Firebase
import com.google.firebase.database.database

object DataBase {
    val database = Firebase.database
    val ref = database.getReference("message")
    fun setText(text: String){
        ref.setValue(text)
    }
}