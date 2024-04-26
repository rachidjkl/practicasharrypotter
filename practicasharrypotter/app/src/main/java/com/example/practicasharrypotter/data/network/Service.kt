package com.example.practicasharrypotter.data.network

import com.example.practicasharrypotter.core.RetrofitHelper
import com.example.practicasharrypotter.data.model.Books
import com.example.practicasharrypotter.data.model.Characters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Service {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBooksEs(): List<Books> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllBooksEs()
            response.body() ?: emptyList()
        }
    }

    suspend fun getBooksEn(): List<Books> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllBooksEn()
            response.body() ?: emptyList()
        }
    }

    suspend fun getCharactersEs(): List<Characters> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllCharactersEs()
            response.body() ?: emptyList()
        }
    }

    suspend fun getCharactersEn(): List<Characters> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getAllCharactersEn()
            response.body() ?: emptyList()
        }
    }
}