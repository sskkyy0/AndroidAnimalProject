package com.example.androidanimalproject.ui.mapper

import com.example.androidanimalproject.data.dto.AnimalResponseDto
import com.example.androidanimalproject.ui.animal.Animal

fun AnimalResponseDto.toAnimal(): Animal {
    return Animal(
        url = this.url,
        name = this.name,
        status = this.state,
        address = this.address
    )
}
// 서버 데이터를 내가 가공해서 쓰기
