package com.example.androidanimalproject.animal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var animals = remember{ mutableStateListOf(
        Animal(
            "https://cdn.pixabay.com/photo/2023/09/19/12/34/dog-8262506_1280.jpg",
            "강아디",
            "실종 신고",
            "광진구 화양동"
        )
    ) }

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home") {
            SearchScreen(navController, animals)
        }
        composable("detail") {
            //SearchDetailScreen(navController)
        }
        composable("post") {
            PostScreen(navController, animals){ Update ->
//                animals = Update as SnapshotStateList<Animal>
            }
        }
    }
}

