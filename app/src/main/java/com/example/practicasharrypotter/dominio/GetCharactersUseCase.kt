package com.example.practicasharrypotter.dominio

import com.example.practicasharrypotter.data.BooksRepository
import com.example.practicasharrypotter.data.CharactersRepository
import com.example.practicasharrypotter.data.model.Books
import com.example.practicasharrypotter.data.model.Characters
import javax.inject.Inject

class GetCharactersUseCase {

    private val repository = CharactersRepository()

    suspend fun getAllCharactersEs():List<Characters>? = repository.getAllCharactersEs()
    suspend fun getAllCharactersEn():List<Characters>? = repository.getAllCharactersEn()
}