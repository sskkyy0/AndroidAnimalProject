package com.example.androidanimalproject.ui.animal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidanimalproject.data.AnimalService
import com.example.androidanimalproject.data.dto.AnimalRequestDto
import com.example.androidanimalproject.ui.mapper.toAnimal
import com.example.androidanimalproject.ui.mapper.toAnimalRequestDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.net.ssl.SSLEngineResult.Status

@HiltViewModel
class AnimalDetailViewModel @Inject constructor(
    private val animalService: AnimalService
) : ViewModel() {

    private val _animal = MutableStateFlow(Animal())
    val animal = _animal.asStateFlow()


    fun getAnimal(index: Int) {
        viewModelScope.launch {
            _animal.value = animalService.getAnimal(id = index).data.toAnimal()
        }
    }
}
