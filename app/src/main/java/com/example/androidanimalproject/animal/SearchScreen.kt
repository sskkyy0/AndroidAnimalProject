package com.example.androidanimalproject.animal

import androidx.compose.foundation.background
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
fun AnimalComponent(animal: Animal) {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Row {
            Box(
                modifier = Modifier.size(130.dp)
            ) {
                AsyncImage(
                    model = animal.url,
                    contentDescription = "강아지 사진"
                )
                Box(){
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
}

@Composable
fun SearchScreen(navController: NavController) {
    val orangeColor = Color(0xFFFFA938)
    val animal = Animal(
        "https://pixabay.com/ko/photos/%EA%B0%9C-%EA%B0%95%EC%95%84%EC%A7%80-%EC%86%A1%EA%B3%B3%EB%8B%88-%EC%95%A0%EC%99%84-%EB%8F%99%EB%AC%BC-8262506/",
        "강아디",
        "실종 상태",
        "광진구 화양동"
    )
    Column {
        Box(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text("조회하기")
        }
        LazyColumn(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            items(5) { index ->
                AnimalComponent(animal = animal)
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
                navController.navigate("post")
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
    SearchScreen(navController)
}