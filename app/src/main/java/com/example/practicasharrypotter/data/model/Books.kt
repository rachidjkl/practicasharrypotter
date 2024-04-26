package com.example.practicasharrypotter.data.model

import com.google.gson.annotations.SerializedName

data class Books (
    @SerializedName("number") var number: Int,
    @SerializedName("title") var title: String,
    @SerializedName("originalTitle") var originalTitle: String,
    @SerializedName("releaseDate") var releaseDate: String,
    @SerializedName("description") var description: String,
    @SerializedName("pages") var pages: Int,
    @SerializedName("cover") var cover: String
)

