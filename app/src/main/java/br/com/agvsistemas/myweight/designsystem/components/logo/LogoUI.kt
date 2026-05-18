package br.com.agvsistemas.myweight.designsystem.components.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import br.com.agvsistemas.myweight.R
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme

@Composable
fun LogoUI(modifier: Modifier = Modifier) {
    val drawable = if (isSystemInDarkTheme()) R.drawable.logo_white else R.drawable.logo_primary
    Image(
        painter = painterResource(id = drawable),
        contentDescription = null,
        modifier = modifier
    )
}

@PreviewLightDark
@Composable
private fun LogoUIPreview() {
    MyWeightTheme() {
        LogoUI()
    }
}