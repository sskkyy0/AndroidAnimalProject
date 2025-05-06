package com.example.androidanimalproject.ui.animal

import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes {
    @Serializable
    data object Home : Routes

    @Serializable
    data class Detail(val index: Int) : Routes

    @Serializable
    data object Register: Routes
}