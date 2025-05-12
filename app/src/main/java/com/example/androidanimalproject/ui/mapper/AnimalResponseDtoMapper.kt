package com.example.androidanimalproject.ui.mapper

import com.example.androidanimalproject.data.dto.AnimalRequestDto
import com.example.androidanimalproject.data.dto.AnimalResponseDto
import com.example.androidanimalproject.ui.animal.Animal
import com.example.androidanimalproject.ui.animal.AnimalStatus

fun AnimalResponseDto.toAnimal(): Animal {
    return Animal(
        id = this.id,
        url = this.url,
        name = this.name,
        status = when (this.state) {
            "PROTECT" -> AnimalStatus.PROTECTED
            "MISSING" -> AnimalStatus.MISSING
            "WITNESS" -> AnimalStatus.SIGHTED
            else -> AnimalStatus.MISSING
        },
        address = this.address
    )
}

fun Animal.toAnimalRequestDto(): AnimalRequestDto {
    return AnimalRequestDto(
        url = this.url,
        name = this.name,
        state = "PROTECT",
        breed = "시고르자브종",
        address = this.address
    )
}
// 서버 데이터를 내가 가공해서 쓰기
