package com.example.myroomdbapp

import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue //manually add these!!
import androidx.compose.runtime.setValue
//import androidx.compose.runtime.*  //option to all the imports above

@Composable
fun InsertTeamView(vm :TeamViewModel) {
    var teamName by remember { mutableStateOf("") }
    var teamCity by remember { mutableStateOf("") }
    Text("Add a Team")
    OutlinedTextField( value = teamName, // City TextField not shown
        onValueChange = {teamName = it}, // styling/layout not shown
        label = { Text("Team name") } )
    OutlinedTextField( value = teamCity, // City TextField not shown
        onValueChange = {teamCity = it}, // styling/layout not shown
        label = { Text("Team name") } )
    Button(
        enabled = teamName != "" && teamCity != "", // enable if name/city entered
        onClick = {
            vm.insertTeam(Team(teamName,teamCity)) // insert data in database
            teamName = ""
            teamCity = ""
        } ) { Text( "Submit" ) }
}