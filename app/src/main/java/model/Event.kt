package model

import androidx.annotation.DrawableRes

data class Event(
    val nama: String,
    val deskripsi: String,
    val htm: Int,
    @DrawableRes val imageRes: Int
)