package com.codeitsolo.scribbledash.feature.game.presentation.start

import androidx.lifecycle.ViewModel
import com.codeitsolo.scribbledash.app.Game
import com.codeitsolo.scribbledash.core.presentation.navigation.Navigator
import com.codeitsolo.scribbledash.feature.game.data.GameDifficulty

internal class StartGameViewModel(
    private val navigator: Navigator,
) : ViewModel() {

    fun onBackClick() {
        navigator.navigateUp()
    }

    fun onChooseDifficultyClick(difficulty: GameDifficulty) {
        navigator.navigate(route = Game(difficulty = difficulty))
    }
}