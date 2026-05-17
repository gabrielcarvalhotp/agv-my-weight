package br.com.agvsistemas.myweight.designsystem.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun BouncingDotsLoadingUI(
    modifier: Modifier = Modifier
) {
    val fileName = if (isSystemInDarkTheme()) "bouncing-dots-loading-dark.json" else "bouncing-dots-loading-light.json"
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(fileName))

    LottieAnimation(
        composition = composition,
        modifier = modifier
            .size(120.dp),
        iterations = LottieConstants.IterateForever,
        maintainOriginalImageBounds = true,
        contentScale = ContentScale.Fit
    )
}

@PreviewLightDark
@Composable
private fun BouncingDotsLoadingUIPreview() {
    MyWeightTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MyWeightTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BouncingDotsLoadingUI()
        }
    }
}