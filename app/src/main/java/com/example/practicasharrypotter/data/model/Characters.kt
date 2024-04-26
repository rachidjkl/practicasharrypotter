package com.example.practicasharrypotter.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("fullName") var fullName: String,
    @SerializedName("nickname") var nickname: String,
    @SerializedName("hogwartsHouse") var hogwartsHouse: String,
    @SerializedName("interpretedBy") var interpretedBy: String,
    @SerializedName("children") var children: List<String>,
    @SerializedName("image") var image: String,
    @SerializedName("birthdate") var birthdate: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: ArrayList(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(nickname)
        parcel.writeString(hogwartsHouse)
        parcel.writeString(interpretedBy)
        parcel.writeStringList(children)
        parcel.writeString(image)
        parcel.writeString(birthdate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Characters> {
        override fun createFromParcel(parcel: Parcel): Characters {
            return Characters(parcel)
        }

        override fun newArray(size: Int): Array<Characters?> {
            return arrayOfNulls(size)
        }
    }
}
