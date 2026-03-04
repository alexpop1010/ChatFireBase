package com.litecashtop.firebase

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChatViewModel: ViewModel() {
    val message = mutableStateOf("")
    val messageStorage = mutableStateListOf<String>()
    fun messageChanged(text: String){
        message.value = text
    }
    fun sendMessage(text: String){
        messageStorage.add(text)

    }

}