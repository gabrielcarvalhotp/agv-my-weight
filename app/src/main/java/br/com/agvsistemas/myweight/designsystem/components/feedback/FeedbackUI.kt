package br.com.agvsistemas.myweight.designsystem.components.feedback
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.R
import br.com.agvsistemas.myweight.core.enums.FeedbackType
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme

@Composable
fun FeedbackUI(
    modifier: Modifier = Modifier,
    message: String,
    type: FeedbackType
) {
    val containerColor = when (type) {
        FeedbackType.SUCCESS -> MyWeightTheme.extendedColors.success
        FeedbackType.INFO -> MyWeightTheme.extendedColors.info
        FeedbackType.WARNING -> MyWeightTheme.extendedColors.warning
        FeedbackType.ERROR -> MyWeightTheme.colorScheme.error
    }

    val drawableRes = when (type) {
        FeedbackType.SUCCESS -> R.drawable.ic_success
        FeedbackType.INFO -> R.drawable.ic_info
        FeedbackType.WARNING -> R.drawable.ic_warning
        FeedbackType.ERROR -> R.drawable.ic_bug_report
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(drawableRes),
                contentDescription = message,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = message,
                style = MyWeightTheme.typography.bodyMedium.copy(
                    color = Color.White
                )
            )
        }
    }
}

@Preview
@Composable
private fun FeedbackUIPreview() {
    MyWeightTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MyWeightTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FeedbackUI(
                message = "Login efetuado com sucesso",
                type = FeedbackType.SUCCESS
            )

            FeedbackUI(
                message = "Login efetuado com sucesso",
                type = FeedbackType.INFO
            )

            FeedbackUI(
                message = "Login efetuado com sucesso",
                type = FeedbackType.WARNING
            )

            FeedbackUI(
                message = "Login efetuado com sucesso",
                type = FeedbackType.ERROR
            )
        }
    }
}