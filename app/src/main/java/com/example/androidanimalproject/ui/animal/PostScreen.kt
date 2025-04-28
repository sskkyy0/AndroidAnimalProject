package com.example.androidanimalproject.ui.animal

import androidx.compose.animation.expandVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PostScreen(navController: NavController, animal: List<Animal>, onUpdateAnimal: (List<Animal>)-> Unit) {
    val orangeColor = Color(0xFFFFA938)
    val greyColor = Color(0xFFA0A0A0)
    val (url, setURL) = remember { mutableStateOf("") }
    val (name, setName) = remember { mutableStateOf("") }
    val (address, setAddress) = remember { mutableStateOf("") }
    Column {
        Box(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text("등록하기")
        }
        Box(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 21.dp)
        ) {
            Column {
                Text("사진 url 입력")
                TextField(
                    value = url, onValueChange = setURL,
                    modifier = Modifier
                        .height(56.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(color = greyColor)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text("이름 입력")
                TextField(
                    value = name, onValueChange = setName,
                    modifier = Modifier
                        .height(56.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(color = greyColor)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text("주소 입력")
                TextField(
                    value = address, onValueChange = setAddress,
                    modifier = Modifier
                        .height(56.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .background(color = greyColor)
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(bottom = 49.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = orangeColor,
                    contentColor = Color.Black
                ),
                onClick = {
                    onUpdateAnimal(animal+ Animal(url,name,"실종 신고",address))
                    navController.navigate(Routes.Home)
                }) {
                Text("등록하기")
            }
        }
    }
}

@Preview
@Composable
private fun PostScreenPrev() {
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
    PostScreen(navController, animal){

    }
}