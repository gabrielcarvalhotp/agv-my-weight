package br.com.agvsistemas.myweight.designsystem.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun CircularLoadingUI(
    modifier: Modifier = Modifier
) {
    val fileName = if (isSystemInDarkTheme()) "circular-loading-dark.json" else "circular-loading-light.json"
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(fileName))

    LottieAnimation(
        composition = composition,
        modifier = modifier
            .size(120.dp),
        iterations = LottieConstants.IterateForever,
        maintainOriginalImageBounds = true
    )
}

@PreviewLightDark
@Composable
private fun CircularLoadingUIPreview() {
    MyWeightTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MyWeightTheme.colors.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularLoadingUI()
        }
    }
}