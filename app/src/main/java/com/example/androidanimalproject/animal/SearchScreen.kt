package com.example.androidanimalproject.animal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.round

@Composable
fun AnimalComponent() {

}

@Composable
fun SearchScreen() {
    val Corange=Color(0xFFFFA938)
    Column {
        Box(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text("조회하기")
        }
        LazyColumn(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            items(5){ index ->
                Box(){
                    Text("index")
                }
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        IconButton(
            modifier = Modifier.size(56.dp)
                .background(color = Corange),
            onClick = {}) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "추가 등록"
            )
        }
    }


}

@Preview
@Composable
private fun SearchscreenPrev() {
   SearchScreen()
}