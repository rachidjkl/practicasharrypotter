package com.example.practicasharrypotter.data.model

import javax.inject.Inject

class BooksProveider @Inject constructor() {

    companion object {
        var books:List<Books> = emptyList()
    }

}