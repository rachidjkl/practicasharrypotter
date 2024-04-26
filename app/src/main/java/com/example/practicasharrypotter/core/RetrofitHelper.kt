package com.example.practicasharrypotter.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://potterapi-fedeperin.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}