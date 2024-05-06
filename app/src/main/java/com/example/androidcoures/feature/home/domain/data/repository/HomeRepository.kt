package com.example.androidcoures.feature.home.domain.data.repository

import com.example.androidcoures.R
import com.example.androidcoures.feature.home.domain.data.model.HouseResponse.House

class HomeRepository {
    val houseList = listOf(
        House(R.drawable.house1, "200.000", "Shiraz, Chap", "2 bedrooms"),
        House(R.drawable.house2, "400.000", "Shiraz, Bala", "4 bedrooms"),
        House(R.drawable.house3, "600.000", "Shiraz, Paiin", "6 bedrooms"),
        House(R.drawable.house4, "800.000", "Shiraz, Eram", "8 bedrooms")
    )

    fun fetchAllHouses(): List<House> {
        return houseList
    }
}