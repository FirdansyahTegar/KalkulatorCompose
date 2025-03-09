package com.example.test

import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*
import androidx.compose.material3.OutlinedTextField
import androidx.activity.compose.setContent
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InputFieldExample()
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun InputFieldExample() {
    // State untuk menyimpan nilai input
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var isError2 by remember { mutableStateOf(false) }
    var hasil by remember { mutableStateOf(0)}

    Column(modifier = Modifier.padding(16.dp)) {
        // Kolom input (TextField)
        OutlinedTextField(
            value = text, // Nilai yang ditampilkan
            onValueChange = { newText ->
                text = newText // Update nilai state saat input berubah
                isError = newText.isNotEmpty() && newText.toDoubleOrNull() == null
            },
            label = { Text("Masukkan Angka") }, // Label untuk TextField
            placeholder = { Text("Masukkan Angka") }, // Placeholder
            modifier = Modifier.padding(bottom = 16.dp),
            isError = isError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                if (isError) {
                    Text("", color = Color.Red) // Ikon error
                }
            }
        )

        // Tampilkan pesan error jika input bukan angka
        if (isError) {
            Text(
                text = "Input harus berupa angka!",
                color = Color.Red,
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        OutlinedTextField(
            value = text2, // Nilai yang ditampilkan
            onValueChange = { newText2 ->
                text2 = newText2 // Update nilai state saat input berubah
                isError2 = newText2.isNotEmpty() && newText2.toDoubleOrNull() == null
            },
            label = { Text("Masukkan Angka") }, // Label untuk TextField
            placeholder = { Text("Masukkan Angka") }, // Placeholder
            modifier = Modifier.padding(bottom = 16.dp),
            isError = isError2,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                if (isError2) {
                    Text("", color = Color.Red) // Ikon error
                }
            }
        )

        // Tampilkan pesan error jika input bukan angka
        if (isError2) {
            Text(
                text = "Input harus berupa angka!",
                color = Color.Red,
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        Row(modifier = Modifier.padding(16.dp)) {
            // Tombol 1
            Button(
                onClick = {
                    val angka1 = text.toInt()
                    val angka2 = text2.toInt()
                    hasil = (angka1 + angka2)
                },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("+")
            }

            // Tombol 2
            Button(
                onClick = {
                    val angka1 = text.toInt()
                    val angka2 = text2.toInt()
                    hasil = (angka1 - angka2)
                          },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("-")
            }

            // Tombol 3
            Button(
                onClick = {
                    val angka1 = text.toInt()
                    val angka2 = text2.toInt()
                    hasil = (angka1 * angka2)
                },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("x")
            }

            // Tombol 4
            Button(
                onClick = {
                    val angka1 = text.toInt()
                    val angka2 = text2.toInt()
                    hasil = (angka1 / angka2)
                },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("/")
            }
        }
        if (text == "" || text2 == "") {
            Text(text = "Hasil = ")
        } else {
            Text(text = "Hasil = $hasil")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInputFieldExample() {
    InputFieldExample()
}



@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.aika1),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.Black, CircleShape)

        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = Color.Green
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

@Composable
fun ImgMsg(msg: Message) {
    Row {
        Image(
            painter = painterResource(R.drawable.aika1),
            contentDescription = "Contact profile picture",
        )

        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }

    }
}

//@Preview
@Composable
fun PreviewMessageCard() {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(
                msg = Message("Lexi", "Take a look at Jetpack Compose, it's great!")
            )
        }
}