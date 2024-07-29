package com.example.myrestapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {
    private val _teamList = mutableStateListOf<Team>()
    val teamList: List<Team> get() = _teamList

    fun getTeams() {
        viewModelScope.launch { // coroutine to call getTeams
            val teamService = TeamService.getInstance()
            try {
                _teamList.clear() // empty the list
                _teamList.addAll(teamService.getTeams()) // get the teams and add to list
            } catch (e: Exception) {
            }
        }
    }

    fun addTeam(team: Team) {
        viewModelScope.launch {
            val teamService = TeamService.getInstance()
            try {
                teamService.addTeam(team) // adds the team to the REST service
                _teamList.clear() // update the data that the client
                _teamList.addAll(teamService.getTeams()) // observable is 'watching'
            } catch (e: Exception) {
            }
        }
    }
}