package com.example.myworkerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp

import androidx.work.*
import androidx.work.Constraints
import com.example.myworkerapp.ui.theme.MyWorkerAppTheme
import java.time.Duration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWorkerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetWorkDone()
                }
            }
        }
    }
}

@Composable
fun GetWorkDone() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "WorkManger App",
            Modifier.padding(10.dp)
        )

        Button(
            onClick = {
                val constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

                val myWorkRequest: WorkRequest =
                    PeriodicWorkRequestBuilder<TheWorker>(Duration.ofMinutes(15))
                        .setConstraints(constraints)
                        .build()

//                val myWorkRequest: WorkRequest =
//                    OneTimeWorkRequestBuilder<TheWorker>()
//                        .setConstraints(constraints)
//                        .build()

//                val myWorkRequest: WorkRequest =
//                    OneTimeWorkRequestBuilder<TheWorker>()
//                        .build()

                WorkManager
                    //.getInstance(LocalContext.current)
                    .getInstance(context)
                    .enqueue(myWorkRequest)
            },
            modifier = Modifier.padding(4.dp)
        ) {
            Text("Set Up The Work")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyWorkerAppTheme {
//        Greeting("Android")
//    }
//}