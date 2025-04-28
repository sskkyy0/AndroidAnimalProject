package com.example.androidanimalproject.ui.animal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage

@Composable
fun AnimalComponent(animal: Animal, onClick: ()->Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable { onClick }
    ) {
        Row {
            Box(
                modifier = Modifier.size(130.dp)
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            ) {
                AsyncImage(
                    model = animal.url,
                    contentDescription = "강아지 사진"
                )
            }
            Box(
            ){
                Column {
                    Text(animal.name)
                    Spacer(Modifier.height(10.dp))
                    Text(animal.status)
                    Spacer(Modifier.height(31.dp))
                    Text(animal.address)
                }
            }
        }
    }
}

@Composable
fun SearchScreen(navController: NavController, animal: List<Animal>) {
    val orangeColor = Color(0xFFFFA938)

    Column {
        Box(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text("조회하기")
        }
        Spacer(Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 20.dp)
        ) {
            items(animal.size) { index ->
                AnimalComponent(animal[index]){
                    navController.navigate(Routes.Detail(index))
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        IconButton(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = orangeColor), // modifier 순서에따라 달라짐
            onClick = {
                navController.navigate(Routes.Register)
            }) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "추가 등록"
            )
        }
    }
}

@Preview
@Composable
private fun SearchScreenPrev() {
    val navController = rememberNavController()
    val animal = remember {
        mutableListOf(
            Animal(
                "https://cdn.pixabay.com/photo/2023/09/19/12/34/dog-8262506_1280.jpg",
                "이름",
                "실종 신고",
                "광진구 화양동"
            )
        )
    }
    SearchScreen(navController,animal)
}