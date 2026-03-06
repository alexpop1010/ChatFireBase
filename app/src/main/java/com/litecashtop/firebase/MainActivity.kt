package com.litecashtop.firebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.litecashtop.firebase.ui.theme.FireBaseTheme
import androidx.compose.foundation.lazy.items
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FireBaseTheme {
                Greeting(
                    name = "Отправьте сообщение",
                    modifier = Modifier
                        .padding(top=50.dp, start=50.dp)

                )
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, chatViewModel: ChatViewModel = viewModel()) {
    Column(modifier){
        Text(
            text = name
        )
        TextField(
            value = chatViewModel.message.value,
            onValueChange = {chatViewModel.messageChanged(it)},
            label = {Text("")}
        )
        Button(
            onClick = {chatViewModel.sendMessage(chatViewModel.message.value)}){
                Text("Отправить сообщение")
            }

        LazyColumn{
            items(chatViewModel.messageStorage){it ->
                Text(it.text, modifier = Modifier.padding(start=200.dp))

            }

        }
    }
}

