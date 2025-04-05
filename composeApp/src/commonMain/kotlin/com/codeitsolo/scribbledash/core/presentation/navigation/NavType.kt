package com.codeitsolo.scribbledash.core.presentation.navigation

import androidx.core.bundle.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.json.Json

/**
 * Returns a [NavType] for the given type [T].
 */
inline fun <reified T : Any?> getNavType(isNullableAllowed: Boolean = true) =
    object : NavType<T>(isNullableAllowed = isNullableAllowed) {
        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun get(bundle: Bundle, key: String): T? {
            return bundle.getString(key)?.let {
                Json.decodeFromString<T>(it)
            }
        }

        override fun serializeAsValue(value: T): String {
            return Json.encodeToString(value)
        }

        override fun parseValue(value: String): T {
            return Json.decodeFromString(value)
        }
    }