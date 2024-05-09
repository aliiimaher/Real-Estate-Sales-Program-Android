package com.example.androidcoures.feature.home.domain.data.model

class HouseResponse : ArrayList<HouseResponse.House>() {
    data class House(
        val image: Int,
        val price: String,
        val address: String,
        val subInfo: String,
        val squareFoot: Int,
        val bedrooms: Int,
        val bathrooms: Int,
        val toilet: Int,
        val garage: Int,
        val elevator: Int,
    )
}