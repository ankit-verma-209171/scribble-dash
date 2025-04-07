package com.codeitsolo.scribbledash.feature.game.data

import kotlinx.serialization.Serializable

@Serializable
enum class GameDifficulty {
    Beginner,
    Challenging,
    Master,
}