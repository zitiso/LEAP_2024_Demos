package com.example.mymvvmapp


import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class TeamViewModelTest {

    lateinit var vm: TeamViewModel

    @Before
    fun setup() {
        vm = TeamViewModel()

    }

    @Test
    fun vmIsCreated() {
        assertNotNull { vm }
    }

    @Test
    fun addTeamWorks() {
        vm.addTeam("Blue Jays", "Toronto")
        var teamList = vm.teamListState.value

        assertEquals( "Blue Jays",teamList[0].name)
        assertEquals(1, teamList.count())
    }
}