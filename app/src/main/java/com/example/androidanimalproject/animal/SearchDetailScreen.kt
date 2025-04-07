package com.example.androidanimalproject.animal

import android.media.Image
import androidx.collection.mutableObjectIntMapOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun SearchDetailScreen(navController: NavController, animal: Animal) {
    Column {
        Box(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
        ){
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "뒤로 가기"
                )
            }
        }
        AsyncImage(
            model = animal.url,
            contentDescription = animal.name+"사진",
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier.height(304.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            .background(color = Color.White)){

        }

    }
}

@Preview
@Composable
private fun SearchDetailScreenPrev() {
    val navController = rememberNavController()
    val animal = Animal("he", "naen", "so", "home")
    SearchDetailScreen(navController,animal)
}
