package com.example.androidcoures.feature.home.domain.data.repository

import com.example.androidcoures.feature.home.domain.data.model.HouseInfoResponse
import com.example.androidcoures.feature.home.domain.data.model.HouseInfoResponse.HouseInfo

class HouseInfoRepository {
    private val houseInfoList = arrayListOf(
        HouseInfoResponse.HouseInfo("Square foot", 500),
        HouseInfo("Bedrooms", 4),
        HouseInfo("Bathrooms", 2),
        HouseInfo("Toilet", 1),
        HouseInfo("Garage", 2),
        HouseInfo("Elevator", 1),
    )

    fun fetchAllHouseInfo(): List<HouseInfo> {
        return houseInfoList
    }
}