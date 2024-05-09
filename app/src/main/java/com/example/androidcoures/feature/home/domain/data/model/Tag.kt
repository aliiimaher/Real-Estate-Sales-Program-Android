package com.example.androidcoures.feature.home.domain.data.model

class TagResponse : ArrayList<TagResponse.Tag>() {
    data class Tag(
        val text: String
    )
}