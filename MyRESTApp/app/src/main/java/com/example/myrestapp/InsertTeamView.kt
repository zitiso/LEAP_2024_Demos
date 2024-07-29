package com.example.myrestapp

import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun InsertTeamView(vm: TeamViewModel) {
    var teamName by remember { mutableStateOf("") }
    var teamCity by remember { mutableStateOf("") }
    Text("Add a Team")
    OutlinedTextField(value = teamName,
        onValueChange = { teamName = it },
        label = { Text("Team name") })
    OutlinedTextField(value = teamCity,
        onValueChange = { teamCity = it },
        label = { Text("Team city") })
    Button(
        enabled = teamCity != "" && teamName!= "",
//        onClick = { vm.addTeam(teamName, teamCity); teamName = ""; teamCity = "" }) {
        onClick = { vm.addTeam(Team(teamName, teamCity))
            teamName = ""
            teamCity = "" })
    {
        Text("Submit")
    }
}