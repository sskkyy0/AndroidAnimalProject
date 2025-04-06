package com.example.androidanimalproject.animal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home") {
            SearchScreen(navController)
        }
        composable("detail") {
            SearchDetailScreen(navController)
        }
        composable("post") {
            PostScreen(navController)
        }
    }
}