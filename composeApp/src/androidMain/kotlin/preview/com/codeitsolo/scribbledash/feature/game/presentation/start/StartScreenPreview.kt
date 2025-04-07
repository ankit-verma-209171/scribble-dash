package preview.com.codeitsolo.scribbledash.feature.game.presentation.start

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.codeitsolo.scribbledash.feature.game.presentation.start.StartGameScreen
import com.codeitsolo.scribbledash.ui.theme.AppTheme

@Composable
@Preview(showSystemUi = true)
fun StartScreenPreview() {
    AppTheme {
        StartGameScreen(
            onBackClick = {},
            onChooseDifficultyClick = {}
        )
    }
}