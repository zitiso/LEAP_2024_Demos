package com.example.mystateapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

import com.example.mystateapp.ui.theme.MyStateAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStateAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StateApp()
                }
            }
        }
    }
}

const val TAG = "StateApp"

@Composable
fun StateApp() {
    Text("Application State")

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val latestEvent = remember { mutableStateOf(Lifecycle.Event.ON_ANY) }

    DisposableEffect(lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            latestEvent.value = event
            when (latestEvent.value) {
                Lifecycle.Event.ON_START -> Log.wtf(TAG, Lifecycle.Event.ON_START.name)
                Lifecycle.Event.ON_CREATE -> Log.wtf(TAG, Lifecycle.Event.ON_CREATE.name)
                Lifecycle.Event.ON_RESUME -> Log.wtf(TAG, Lifecycle.Event.ON_RESUME.name)
                Lifecycle.Event.ON_PAUSE -> Log.wtf(TAG, Lifecycle.Event.ON_PAUSE.name)
                Lifecycle.Event.ON_STOP -> Log.wtf(TAG, Lifecycle.Event.ON_STOP.name)
                Lifecycle.Event.ON_DESTROY -> Log.wtf(TAG, Lifecycle.Event.ON_DESTROY.name)
                Lifecycle.Event.ON_ANY -> Log.wtf(TAG, Lifecycle.Event.ON_ANY.name)
            }
        }

        lifecycle.addObserver(observer)

        onDispose { lifecycle.removeObserver(observer)  }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyStateAppTheme {
//        Greeting("Android")
//    }
//}