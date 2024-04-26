package com.example.practicasharrypotter.dominio

import com.example.practicasharrypotter.data.BooksRepository
import com.example.practicasharrypotter.data.model.Books
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class GetBooksUseCase @Inject constructor() {

    private val repository = BooksRepository()

    suspend fun getAllBooksEn():List<Books>? = repository.getAllBooksEn()
    suspend fun getAllBooksEs():List<Books>? = repository.getAllBooksEs()



}