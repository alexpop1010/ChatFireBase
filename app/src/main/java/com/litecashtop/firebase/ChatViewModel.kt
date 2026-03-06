package com.litecashtop.firebase

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class ChatViewModel: ViewModel() {
    val message = mutableStateOf("")
    val messageStorage = mutableStateListOf<SentMessage>()
    fun messageChanged(text: String){
        message.value = text
    }
    init { receiveMessage(DataBase.ref) }

    fun sendMessage(text: String){
        DataBase.setText(text)
    }
    fun receiveMessage(dRef: DatabaseReference){
        dRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                messageStorage.add(SentMessage(snapshot.value.toString()))

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

}