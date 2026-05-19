package br.com.agvsistemas.myweight.designsystem.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.R
import br.com.agvsistemas.myweight.designsystem.components.loading.BouncingDotsLoadingUI
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme

@Composable
fun SocialButtonUI(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String? = null,
    isLoading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(58.dp)
            .border(
                width = 1.dp,
                color = MyWeightTheme.colorScheme.outline,
                shape = RoundedCornerShape(16.dp)
            ),
        enabled = !isLoading,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MyWeightTheme.colorScheme.surfaceContainerHigh,
        )
    ) {
        if (isLoading) {
            BouncingDotsLoadingUI()
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = icon,
                    contentDescription = text,
                    modifier = Modifier
                        .size(24.dp),
                    tint = Color.Unspecified
                )

                text?.let {
                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = text,
                        style = MyWeightTheme.typography.bodyLarge.copy(
                            color = MyWeightTheme.colorScheme.onSurface
                        )
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun SocialButtonUIPreview() {
    MyWeightTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MyWeightTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            SocialButtonUI(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Continuar com o Google",
                icon = painterResource(id = R.drawable.ic_google),
                isLoading = false,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            SocialButtonUI(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Continuar com o Facebook",
                icon = painterResource(id = R.drawable.ic_facebook),
                isLoading = false,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            SocialButtonUI(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Continuar com o Github",
                icon = painterResource(id = R.drawable.ic_github),
                isLoading = false,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SocialButtonUI(
                    icon = painterResource(id = R.drawable.ic_google),
                    isLoading = false,
                    onClick = {}
                )

                Spacer(modifier = Modifier.width(20.dp))

                SocialButtonUI(
                    icon = painterResource(id = R.drawable.ic_facebook),
                    isLoading = false,
                    onClick = {}
                )

                Spacer(modifier = Modifier.width(20.dp))

                SocialButtonUI(
                    icon = painterResource(id = R.drawable.ic_github),
                    isLoading = false,
                    onClick = {}
                )
            }
        }
    }
}