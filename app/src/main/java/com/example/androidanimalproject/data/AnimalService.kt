package com.example.androidanimalproject.data

import com.example.androidanimalproject.data.dto.AnimalRequestDto
import com.example.androidanimalproject.data.dto.AnimalResponseDto
import com.example.androidanimalproject.data.dto.BaseResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AnimalService {
    @GET("dev/animals")
    suspend fun getAnimals(): BaseResponse<List<AnimalResponseDto>>

    @POST("dev/animals")
    suspend fun postAnimals(
        @Body requestDto: AnimalRequestDto
    ): BaseResponse<AnimalResponseDto>
}