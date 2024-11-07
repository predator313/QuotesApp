package com.example.quotesappcompose.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.quotesappcompose.QuotesModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.decodeFromJsonElement

object CustomNavType {
    val quoteModelNavDc = object : NavType<QuotesModel>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): QuotesModel? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): QuotesModel {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun put(bundle: Bundle, key: String, value: QuotesModel) {
            bundle.putString( key, Json.encodeToString(value))
        }

        override fun serializeAsValue(value: QuotesModel): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}