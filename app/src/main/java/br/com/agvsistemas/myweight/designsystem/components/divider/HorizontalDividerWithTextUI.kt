package br.com.agvsistemas.myweight.designsystem.components.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme

@Composable
fun HorizontalDividerWithTextUI(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .weight(1f),
            color = MyWeightTheme.colorScheme.outline
        )

        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 10.dp),
            style = MyWeightTheme.typography.bodyMedium.copy(
                color = MyWeightTheme.colorScheme.outline
            )
        )

        HorizontalDivider(
            modifier = Modifier
                .weight(1f),
            color = MyWeightTheme.colorScheme.outline
        )
    }
}

@PreviewLightDark
@Composable
private fun HorizontalDividerWithTextUIPreview() {
    MyWeightTheme {
        Column(
            modifier = Modifier
                .background(MyWeightTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalDividerWithTextUI(
                text = "ou"
            )
        }
    }
}