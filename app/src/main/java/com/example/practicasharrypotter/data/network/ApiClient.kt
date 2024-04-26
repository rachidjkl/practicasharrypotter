package com.example.practicasharrypotter.data.network

import com.example.practicasharrypotter.data.model.Books
import com.example.practicasharrypotter.data.model.Characters
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/es/books")
    suspend fun getAllBooksEs(): Response<List<Books>>

    @GET("/en/books")
    suspend fun getAllBooksEn(): Response<List<Books>>

    @GET ("/es/characters")
    suspend fun getAllCharactersEs(): Response<List<Characters>>

    @GET ("/en/characters")
    suspend fun getAllCharactersEn(): Response<List<Characters>>

}