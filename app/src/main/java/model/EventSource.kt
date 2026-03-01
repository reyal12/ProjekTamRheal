package model

import com.example.projektamrheal.R

object EventSource {
    val dummyEvent = listOf(
        Event("Basket", "Pertandingan basket antar sma", 15000, R.drawable.basket),
        Event("EXPO CAMPUS", "Acara Pameran Pendidikan Kampus", 0, R.drawable.campus),
        Event("BLABLA Fest", "Konser blablafest menghadirkan banyak penyanyi terkenal", 15000, R.drawable.konser),
        Event("Festival Kuliner", "Bazar kuliner lengkap", 5000, R.drawable.kuliner),
    )
}