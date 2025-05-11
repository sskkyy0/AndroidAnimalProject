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
class AnimalViewModel @Inject constructor(
    private val animalService: AnimalService
) : ViewModel() {

    private val _animals = MutableStateFlow(emptyList<Animal>())
    val animals=_animals.asStateFlow()
    private val _registerAnimal = MutableStateFlow(Animal())
    val registerAnimal = _registerAnimal.asStateFlow()

    init {
        getAnimals()
    }

    fun getAnimals() {
        viewModelScope.launch {
            _animals.value = animalService.getAnimals().data.map { it.toAnimal() }

        }
    }

    fun postAnimal(){
        viewModelScope.launch {
            animalService.postAnimals(
                _registerAnimal.value.toAnimalRequestDto()
            )
        }
    }

    fun updateUrl(url:String){
        _registerAnimal.update {
            it.copy(url=url)
        }
    }
    fun updateName(name:String){
        _registerAnimal.update {
            it.copy(name=name)
        }
    }
     fun updateStatus(state:String){
        _registerAnimal.update {
            it.copy(status = state)
        }
    }
     fun updateAddress(address:String){
        _registerAnimal.update {
            it.copy(address = address)
        }
    }

}
