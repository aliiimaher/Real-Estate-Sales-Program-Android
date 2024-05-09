package com.example.androidcoures.feature.home.domain.data.model

class HouseInfoResponse : ArrayList<HouseInfoResponse.HouseInfo>() {
    data class HouseInfo(
        val text: String,
        val count: Int,
    )
}