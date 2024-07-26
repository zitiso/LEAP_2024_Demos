package com.example.myconstraintapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.node.CanFocusChecker.start
//import androidx.compose.ui.node.CanFocusChecker.end
//import androidx.compose.ui.node.CanFocusChecker.start
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

import com.example.myconstraintapp.ui.theme.MyConstraintAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyConstraintAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MyLayout()
                    MyConstraintLayoutDemo()
                }
            }
        }
    }
}

//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun MyLayout() {
// Add depndency androidx.constraintlayout constraintlayout@2.1.4 & constraintlayout-compose@1.01
//    ConstraintLayout() {
//        val (first, last, submit, name, reset) = createRefs()  //Opt in to createRefs() -> references for composables
//        var show by remember { mutableStateOf(false) } // visibility state
//        var firstname by remember { mutableStateOf("") } // first name
//        var lastname by remember { mutableStateOf("") }
//
//        OutlinedTextField(
//            enabled = !show, // enable based on state variable
//            value = firstname,
//            onValueChange = { firstname = it }, // update state
//            label = { Text("First name") },
//            modifier = Modifier
//                .constrainAs(first) { // set reference
//                    top.linkTo(parent.top, 20.dp) // set constraints in relation to layout
//                    start.linkTo(parent.start, 15.dp) // in relation to layout
//                    end.linkTo(submit.start) // relation to submit button
//                }
//                .size(250.dp, 65.dp)
//        )
//
//        OutlinedTextField(
//            enabled = !show, // enable based on state variable
//            value = lastname,
//            onValueChange = { lastname = it }, // update state
//            label = { Text("Last name") },
//            modifier = Modifier
//                .constrainAs(last) { // set reference
//                    top.linkTo(first.bottom, 10.dp) // set constraints in relation to first name
//                    start.linkTo(first.start)
////                    end.linkTo(first.end)
//                }
//                .size(250.dp, 65.dp)
//        )
//        Button(
//            // enabled when user enter first & last name
//            enabled = lastname != "" && // disabled after click
//                    firstname != "" && // re-enabled after reset
//                    !show,
//            onClick = { show = true }, // display name & reset button, disable submit
//            modifier = Modifier
//                .padding(4.dp)
//                .constrainAs(submit) { // constrain to layout and first name
//                    top.linkTo(parent.top, 13.dp)
//                    start.linkTo(first.end)
//                    end.linkTo(parent.end)
//                }
//                .height(133.dp)
//        ) {
//            Text("Submit")
//        }
//        if (show && lastname != "" && firstname != "") {
//            Text(
//                """$firstname
//                    |$lastname""".trimMargin(), // combine first and last names
//                modifier = Modifier
//                    .constrainAs(name) { // constrain under the last name TextField
//                        top.linkTo(last.bottom, 10.dp)
//                        start.linkTo(last.start)
//                        end.linkTo(last.end)
//                    }
//                    .border(
//                        1.dp,
//                        Color.LightGray,
//                        shape = RoundedCornerShape(5.dp)
//                    )
//                    .size(250.dp, 65.dp)
//                    .padding(start = 10.dp, top = 20.dp)
//            )
//
//        }
//        Button(
//            onClick = {
//                show = false // hide reset button and name display
//                firstname = "" // clear name fields
//                lastname = ""
//            },
//            modifier = Modifier
//                .padding(4.dp)
//                .constrainAs(reset) {
//                    top.linkTo(submit.bottom, 13.dp) // constrain under submit button
//                    start.linkTo(submit.start)
//                    end.linkTo(submit.end)
//                }
//        ) {
//            Text("Reset")
//        }
//    }
//}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyConstraintLayoutDemo() {
   // ConstraintLayout(modifier = Modifier.size(200.dp)) {
        ConstraintLayout {
        val (redBox, blueBox, yellowBox, text) = createRefs()

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(redBox) {})

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
            .constrainAs(blueBox) {
                top.linkTo(redBox.bottom)
                start.linkTo(redBox.end)
            })

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                bottom.linkTo(blueBox.bottom)
                start.linkTo(blueBox.end, 20.dp)
            })

        Text("Hello World", modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            start.linkTo(yellowBox.start)
        })

    }
}
