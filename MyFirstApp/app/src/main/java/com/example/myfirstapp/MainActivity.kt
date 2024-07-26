package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.data.EmptyGroup.name
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    MyComposableFunction()
                }
            }
        }
    }
}

@Composable
fun MyComposableFunction() {
    // Updated
    Text(
        text = "Foo",
        color = Color.Red,
        fontSize = 40.sp,
        fontWeight = FontWeight.Black,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .background(Color.LightGray)
            .padding(20.dp)
            .border(5.dp, Color.Blue)
            .background(Color.Yellow)
            .padding(20.dp)
    )
    Text(
        stringResource(R.string.hello_android), // load string from resource
        color = Color.Blue, // set text color
        fontSize = 40.sp, // font size in sp (scalable by users)
        modifier = Modifier // *** apply modifier chain starting at end
            .border(5.dp, Color.Yellow) // outer red border
            .padding(25.dp) // padding outside border
            .border(5.dp, Color.Red) // inner red border
            .background(Color.LightGray) // gray background (inside border)
            .padding(10.dp) // padding around text
    )
    Button(
        onClick = {}
    ) {
        Text("Simple Button")
    }

    Button(
        onClick = {},
        shape = RoundedCornerShape(15.dp),
        enabled = true,
        //enabled = false,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue, //new materials3 - replaces backgroundColor form materials2
            contentColor = Color.White,
            disabledContainerColor = Color.DarkGray, // new per the above
            disabledContentColor = Color.LightGray
        )
    ) {
        Text("Complex Button")
    }

    CircularProgressIndicator(
        progress = 0.70f, // percent complete (or infinite if absent)
        strokeWidth = 8.dp,
        color = Color.Red,
        modifier = Modifier.padding(4.dp)
    )

    LinearProgressIndicator(
        progress = 0.2f,
        color = Color.Red,
        trackColor = Color.Gray, //new for materials3
        modifier = Modifier.padding(4.dp)
    )

    Spacer(
        modifier = Modifier
            .background(Color.Magenta)
            .size(100.dp, 30.dp)
    )


    Row {
        var name by remember { mutableStateOf(" ") }
        OutlinedTextField(
            value = name,
            onValueChange = { it -> name = it },
            label = { Text(text = "Username") },
            modifier = Modifier
                .padding(10.dp)
                .background(Color.White)
                .fillMaxWidth()
                .height(60.dp)
        )
    }

    Column(
        modifier = Modifier.background(Color.White)
    ) {
        var name by remember { mutableStateOf("") }
        OutlinedTextField(
            value = name,
            onValueChange = { it -> name = it },
            label = { Text("Username") },
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = name,
            modifier = Modifier
                .padding(start = 25.dp)
                .height(30.dp)
        )
    }

    var checkStatus by remember {
        mutableStateOf(false)
    }
    Row {
        Checkbox(
            checked = checkStatus,
            onCheckedChange = { checkStatus = it })
        Text(
            text = "Checkbox",
            Modifier
                .clickable { checkStatus = !checkStatus }
                .padding(start = 0.dp, top = 12.dp, end = 5.dp)
        )
    }

    // The UI state is managed by the UI itself
    var count by remember { mutableStateOf(0) }
    Row {
        Button(onClick = { ++count }) {
            Text(text = "Increment")
        }
        Button(onClick = { --count }) {
            Text(text = "Decrement")
        }
    }

//    var checkStatus by remember { mutableStateOf(false)}

    Row {

        Text(
            text = "On/Off",
            Modifier
                .clickable { checkStatus = !checkStatus }
                .padding(start = 10.dp, top = 12.dp)
        )
        Switch(
            checked = checkStatus,
            onCheckedChange = { checkStatus = it }
        )
    }


    val hotdogToppings = listOf("none", "Mustard", "Ketchup")

    val (selected, onOptionSelected) = remember {
        mutableStateOf(hotdogToppings[0])
    }
    Column(Modifier.padding(4.dp)) {
        Text(
            "Hotdog toppings",
            modifier = Modifier.padding(15.dp)
        )
        hotdogToppings.forEach { topping ->
            Row(modifier = Modifier.padding(4.dp)) {
                RadioButton(
                    selected = selected == topping,
                    onClick = { onOptionSelected(topping) })
                Text(
                    text = topping,
                    modifier = Modifier
                        .clickable { onOptionSelected(topping) }
                        .padding(top = 10.dp))
            }
        }
    }

    Column() {


        var sliderValue by remember {
            mutableStateOf(0f)
        }
        Text(
            text = sliderValue.toInt().toString(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            //steps = 10, //determines number of steps
            valueRange = -100f..100f,
            modifier = Modifier.padding(20.dp)
        )

    }

    Row() {
        var msg by remember { mutableStateOf("") }
        TextField(value = msg, onValueChange = { msg = it })
        Button(
            enabled = msg.length > 2,
            onClick = {}) { Text("Submit") }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
        Greeting("Android")
    }
}


@Composable
fun MyColumn() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(2.dp)
            .border(1.dp, Color.Blue)
            .padding(5.dp)
    ){
        Text(text = "Hello,", color = Color.Red)
        Text(text = "World!", color = Color.Black)
        Button(
            onClick = {},
            shape = RoundedCornerShape(15.dp),
  enabled = true,
         //   enabled = false,
            colors = ButtonDefaults.buttonColors(
                containerColor =  Color.Blue,
                contentColor = Color.White,
                disabledContainerColor = Color.DarkGray,
                disabledContentColor = Color.LightGray
            )
        ){
            Text("Complex Button")
        }
        MyFooter("July 25, 2024", "Sally Smith")

    }
}
@Composable
fun MyFooter(
    date: String,
    author: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Text(
            text = date,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = """by $author""",
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

    }
}
