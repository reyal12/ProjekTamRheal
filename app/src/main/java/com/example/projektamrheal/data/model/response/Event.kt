package com.example.projektamrheal.data.model.response

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("nama") val nama: String,
    @SerializedName("deskripsi") val deskripsi: String,
    @SerializedName("htm") val htm: Int,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("kategori") val kategori: String,
    @SerializedName("tanggal") val tanggal: String,
    @SerializedName("waktu") val waktu: String,
    @SerializedName("lokasi") val lokasi: String
)