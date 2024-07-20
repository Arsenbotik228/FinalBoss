package com.myself223.data.remote.dto.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesDto (
    val id: Int,
    val name: String,
    @SerializedName("air_date")
    val date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)