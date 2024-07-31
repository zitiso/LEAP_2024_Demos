package com.example.mysenderapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.mysenderapp.ui.theme.MySenderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySenderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
       val myIntent = Intent("ACTION_SHOWNAME").also {
            it. putExtra("name", "Barbie")
        }
        val context = LocalContext.current

        Button(onClick = {   with(context) { startActivity(myIntent) }}) {
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