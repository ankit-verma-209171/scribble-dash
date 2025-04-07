package com.codeitsolo.scribbledash.app

import com.codeitsolo.scribbledash.core.presentation.navigation.getNavType
import com.codeitsolo.scribbledash.feature.game.data.GameDifficulty
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
sealed interface Destination

@Serializable
data object Dashboard : Destination

@Serializable
data object GameRoute : Destination

@Serializable
data object StartGame : Destination

@Serializable
data class Game(val difficulty: GameDifficulty) : Destination {

    companion object {
        val typeMap = mapOf(
            typeOf<GameDifficulty>() to getNavType<GameDifficulty>()
        )
    }
}
