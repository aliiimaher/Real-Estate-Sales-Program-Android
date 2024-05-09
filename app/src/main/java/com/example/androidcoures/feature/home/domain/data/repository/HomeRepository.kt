package com.example.androidcoures.feature.home.domain.data.repository

import com.example.androidcoures.R
import com.example.androidcoures.feature.home.domain.data.model.HouseResponse.House

class HomeRepository {
    private val houseList = listOf(
        House(
            R.drawable.house1,
            "$200.000",
            "Jenison, Ml 49428, SF",
            "4 bedrooms / 2 bathrooms / 1.416 ft^2",
            500,
            4,
            2,
            1,
            2,
            0
        ), House(
            R.drawable.house2,
            "$140.000",
            "351 Rockwood Dr, SF",
            "2 bedrooms / 1 bathrooms / 0.58 ft^2",
            400,
            2,
            1,
            1,
            1,
            1
        ), House(
            R.drawable.house3,
            "$500.000",
            "214 JakeNorton, EF",
            "5 bedrooms / 5 bathrooms / 2.18 ft^2",
            1000,
            5,
            5,
            4,
            3,
            2
        ), House(
            R.drawable.house4,
            "$290.000",
            "DrKeyOk 2549, SF",
            "3 bedrooms / 2 bathrooms / 1.967 ft^2",
            300,
            3,
            2,
            1,
            1,
            1
        ), House(
            R.drawable.house2,
            "$290.000",
            "DrKeyOk 2549, SF",
            "3 bedrooms / 2 bathrooms / 1.967 ft^2",
            300,
            3,
            2,
            1,
            1,
            1
        )
    )

    fun fetchAllHouses(): List<House> {
        return houseList
    }
}