package br.com.agvsistemas.myweight.ui.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.designsystem.components.loading.CircularLoadingUI
import br.com.agvsistemas.myweight.designsystem.components.logo.LogoUI
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel<SplashViewModel>()
) {
    val state by viewModel.state.collectAsState()

    SplashContent(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SplashContent(
    state: SplashState,
    onAction: (SplashAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MyWeightTheme.colorScheme.surface
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoUI(
                modifier = Modifier.size(258.dp)
            )

            CircularLoadingUI()
        }
    }
}

@PreviewLightDark
@Composable
private fun SplashPreview() {
    MyWeightTheme {
        SplashContent(
            state = SplashState(),
            onAction = {}
        )
    }
}