package br.com.agvsistemas.myweight.designsystem.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.R
import br.com.agvsistemas.myweight.designsystem.components.loading.BouncingDotsLoadingUI
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme

@Composable
fun PrimaryButtonUI(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    enabled: Boolean = true,
    isLoading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp),
        enabled = enabled && !isLoading,
        colors = ButtonDefaults.buttonColors(
            containerColor = MyWeightTheme.colorScheme.primary,
            contentColor = MyWeightTheme.colorScheme.onPrimary,
            disabledContainerColor = MyWeightTheme.colorScheme.surfaceVariant,
            disabledContentColor = MyWeightTheme.colorScheme.onSurfaceVariant,
        ),
    ) {
        if (isLoading) {
            BouncingDotsLoadingUI()
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (icon != null) {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = text,
                    style = MyWeightTheme.typography.bodyLarge
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PrimaryButtonUIPreview() {
    MyWeightTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MyWeightTheme.colorScheme.surface)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PrimaryButtonUI(
                text = "Primary Button",
                onClick = { },
                icon = painterResource(R.drawable.ic_arrow_back)
            )

            PrimaryButtonUI(
                text = "Loading Button",
                onClick = { },
                isLoading = true
            )
        }
    }
}