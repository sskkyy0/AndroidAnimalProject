package com.example.androidanimalproject.ui.mapper

import com.example.androidanimalproject.data.dto.AnimalRequestDto
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

fun Animal.toAnimalRequestDto():AnimalRequestDto{
    return AnimalRequestDto(
        url = this.url,
        name = this.name,
        state = "PROTECT",
        breed = "시고르자브종",
        address = this.address
    )
}
// 서버 데이터를 내가 가공해서 쓰기
