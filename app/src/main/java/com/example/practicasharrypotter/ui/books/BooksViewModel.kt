package com.example.practicasharrypotter.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicasharrypotter.data.model.Books
import com.example.practicasharrypotter.dominio.GetBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@HiltViewModel
class BooksViewModel : ViewModel() {

    var booksModel = MutableLiveData<List<Books>?>()
    var getBooksUseCase = GetBooksUseCase()

    fun onCreate() {
        viewModelScope.launch {
            var result = emptyList<Books>()
            var idioma = "en"
            if (idioma == "es"){
                result = getBooksUseCase.getAllBooksEs()!!
            }else if(idioma=="en"){
                result = getBooksUseCase.getAllBooksEn()!!
            }

            if(!result.isNullOrEmpty()){
                booksModel.postValue(result)
            }
        }
    }

    fun getAllBooksOrdenados(listBooks: MutableLiveData<List<Books>?>): List<Books> {
        // Obtener la lista de libros desde MutableLiveData
        val libros = listBooks.value ?: return emptyList()

        // Función para convertir la cadena de fecha en objeto Date
        val dateFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
        val obtenerFecha: (Books) -> Date = { libro ->
            dateFormatter.parse(libro.releaseDate)
        }

        // Ordenar la lista de libros por fecha de lanzamiento
        val librosOrdenados = libros.sortedBy(obtenerFecha)

        return librosOrdenados
    }

    fun getAllBooksOrdenadosDesc(listBooks: MutableLiveData<List<Books>?>): List<Books> {
        val libros = listBooks.value ?: return emptyList()
        val dateFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
        val obtenerFecha: (Books) -> Date = { libro ->
            dateFormatter.parse(libro.releaseDate)
        }
        val librosOrdenados = libros.sortedByDescending(obtenerFecha)

        return librosOrdenados
    }

    private var ordenAscendente = true

    fun toggleOrden() {
        ordenAscendente = !ordenAscendente
    }

    fun obtenerOrdenAscendente(): Boolean {
        return ordenAscendente
    }

}


