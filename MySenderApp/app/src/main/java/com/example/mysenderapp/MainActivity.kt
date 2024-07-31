package com.example.mysenderapp

import android.content.Intent
import android.net.Uri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.tooling.preview.Preview
import com.example.mysenderapp.ui.theme.MySenderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySenderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sender()
                }
            }
        }
    }
}

@Composable
fun Sender() {
    Column {
//        val myIntent = Intent(
//            Intent.ACTION_VIEW,
//            Uri.parse("https://www.youtube.com/watch/?v=jrK-f5BX9FI")
//        )
//        val myIntent = Intent(Intent.ACTION_MAIN).also {
//            it.setPackage("com.google.android.youtube")
//        }
//
        val myIntent = Intent(Intent.ACTION_MAIN).also {
            // Fully qualified class name so this is an explicit Intent
            it.setPackage("com.example.myreceiverapp")
            it.addCategory("android.intent.category.LAUNCHER")
            it.putExtra("name", "Barbie")
        }

        val context = LocalContext.current

        Button(onClick = { context.startActivity(myIntent) }) {
            Text("Send Intent")
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MySenderAppTheme {
//        Greeting("Android")
//    }
//}