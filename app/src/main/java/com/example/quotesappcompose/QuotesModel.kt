package com.example.quotesappcompose

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class QuotesModel(
    @SerializedName("quote")
    val quotes: String,
    val author: String
)
