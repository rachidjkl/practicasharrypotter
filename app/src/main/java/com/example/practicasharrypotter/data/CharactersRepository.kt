package com.example.practicasharrypotter.data

import com.example.practicasharrypotter.data.model.BooksProveider
import com.example.practicasharrypotter.data.model.Characters
import com.example.practicasharrypotter.data.model.CharactersProveider
import com.example.practicasharrypotter.data.network.Service
import javax.inject.Inject

class CharactersRepository {
    private val api = Service()

    suspend fun getAllCharactersEs():List<Characters>{
        val response = api.getCharactersEs()
        CharactersProveider.characters = response
        return response
    }

    suspend fun getAllCharactersEn():List<Characters>{
        val response = api.getCharactersEn()
        CharactersProveider.characters = response
        return response
    }
}