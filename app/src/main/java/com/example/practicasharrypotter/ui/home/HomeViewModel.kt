package com.example.practicasharrypotter.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicasharrypotter.data.model.Books
import com.example.practicasharrypotter.data.model.Characters
import com.example.practicasharrypotter.dominio.GetBooksUseCase
import com.example.practicasharrypotter.dominio.GetCharactersUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject



class HomeViewModel  : ViewModel()  {


    val charactersModel = MutableLiveData<List<Characters>?>()
    var getCharactersUseCase = GetCharactersUseCase()

    fun onCreate() {
        viewModelScope.launch {
            var result = emptyList<Characters>()
            var idioma = "en"
            if (idioma == "es"){
                result = getCharactersUseCase.getAllCharactersEs()!!
            }else if(idioma=="en"){
                result = getCharactersUseCase.getAllCharactersEn()!!
            }

            if(!result.isNullOrEmpty()){
                charactersModel.postValue(result)
            }
        }
    }
}