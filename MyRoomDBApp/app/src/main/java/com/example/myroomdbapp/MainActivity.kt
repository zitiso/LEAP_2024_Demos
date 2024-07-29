package com.example.myroomdbapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myroommvvmapplication.ui.theme.MyRoomMVVMApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRoomMVVMApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        val owner = LocalViewModelStoreOwner.current
                        owner?.let {
                            val viewModel: TeamViewModel = viewModel(
                                it,
                                "TeamViewModel",
                                TeamViewModelFactory(
                                    LocalContext.current.applicationContext
                                            as Application
                                )
                            )
                            TeamView(viewModel) // Views
                            InsertTeamView(viewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyRoomMVVMApplicationTheme {
        Greeting("Android")
    }
}