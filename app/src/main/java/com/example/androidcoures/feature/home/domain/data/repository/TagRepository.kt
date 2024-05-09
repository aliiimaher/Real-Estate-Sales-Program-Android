package com.example.androidcoures.feature.home.domain.data.repository

import com.example.androidcoures.feature.home.domain.data.model.TagResponse.Tag

class TagRepository {
    private val tagList = listOf(
        Tag("< $220.000"),
        Tag("For Sale"),
        Tag("With Garage"),
        Tag("With Elevator"),
        Tag("Has Pool"),
        Tag("More than 4 beds")
    )

    fun fetchAllTags(): List<Tag> {
        return tagList
    }
}