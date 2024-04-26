package com.example.practicasharrypotter.data

import com.example.practicasharrypotter.data.model.Books
import com.example.practicasharrypotter.data.model.BooksProveider
import com.example.practicasharrypotter.data.network.Service
import javax.inject.Inject

class BooksRepository @Inject constructor(){
    private val api = Service()

    suspend fun getAllBooksEs():List<Books>{
        val response = api.getBooksEs()
        BooksProveider.books = response
        return response
    }

    suspend fun getAllBooksEn():List<Books>{
        val response = api.getBooksEn()
        BooksProveider.books = response
        return response
    }
}