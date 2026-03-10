package com.litecashtop.firebase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageItem(message: SentMessage) {
    val context = LocalContext.current
    val bubbleColor =
        if (message.id == UserManager.getUserId(context))
            Color(0xFFE8F5E9)
        else
            Color(0xFFE3F2FD)

    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = bubbleColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
            .widthIn(max = 260.dp)
    ) {

        Text(
            text = message.id.take(6),
            fontSize = 12.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = message.text,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = message.time.toString(),
            fontSize = 11.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.End)
        )
    }
}