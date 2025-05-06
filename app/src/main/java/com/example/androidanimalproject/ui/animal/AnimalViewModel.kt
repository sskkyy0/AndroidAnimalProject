package com.example.androidanimalproject.ui.animal

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidanimalproject.data.AnimalService
import com.example.androidanimalproject.data.dto.AnimalResponseDto
import com.example.androidanimalproject.ui.mapper.toAnimal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalViewModel @Inject constructor(
    private val animalService: AnimalService
) : ViewModel() {

    private val _animals = MutableStateFlow(emptyList<Animal>())
    val animals=_animals.asStateFlow()
    init {
        getAnimals()
    }

    fun getAnimals() {
        viewModelScope.launch {
            _animals.value = animalService.getAnimals().data.map { it.toAnimal() }

        }
    }
}
