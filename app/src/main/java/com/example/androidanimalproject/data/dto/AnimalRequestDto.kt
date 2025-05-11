package com.example.androidanimalproject.data.dto

import android.location.Address
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimalRequestDto(
    @SerialName("url")
    val url:String,
    @SerialName("name")
    val name:String,
    @SerialName("state")
    val state:String,
    @SerialName("breed")
    val breed:String,
    @SerialName("address")
    val address: String
)