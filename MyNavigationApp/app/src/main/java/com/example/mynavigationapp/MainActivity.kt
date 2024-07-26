package com.example.mynavigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.mynavigationapp.ui.theme.MyNavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNavHost()
                }
            }
        }
    }
}



@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    //add dependency androidx.navigation navigation-runtime-ktx@2.7.7 navigation-compose@2.7.7
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    Column() {
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = startDestination
        ) {
            // build route graph here
            composable("home") {
                Home(
                    onNavigateToPageTwo = { navController.navigate("pageTwo") } // nav callback
                )
            }
            composable("pageTwo") {
                PageTwo(
                    onNavigateToHome = { navController.navigate("home") } // nav callback
                )
            }
//
//            composable("pageTwoB") {
//                PageTwoB(
//                    onNavigateBack = { navController.popBackStack() },
//                )
//            }
        }

    }
}

@Composable
fun Home(
    onNavigateToPageTwo: () -> Unit
) {
    Column() {
        Text("Home", fontSize = 30.sp)
        Button(onClick = onNavigateToPageTwo) {
            Text("Goto Page 2", fontSize = 30.sp)
        }
    }
}

@Composable
fun PageTwo(onNavigateToHome: () -> Unit) {
    Column {
        Text("Page 2", color = Color.Red, fontSize = 30.sp)
        Button(onClick = onNavigateToHome) { Text("Back", fontSize = 30.sp) }
    }
}
//
//@Composable
//fun PageTwoB( onNavigateToHome: () -> Unit, onNavigateBack: () -> Unit ) {
//    Column{
//        Text( "Page 2", color = Color.Red, fontSize = 30.sp)
//        Button(onClick = onNavigateBack) { Text("Back", fontSize = 30.sp) }
//    }
//}

