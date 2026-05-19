package br.com.agvsistemas.myweight.ui.features.signin

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.R
import br.com.agvsistemas.myweight.core.enums.InputType
import br.com.agvsistemas.myweight.core.enums.inputErrorMessage
import br.com.agvsistemas.myweight.designsystem.components.button.PrimaryButtonUI
import br.com.agvsistemas.myweight.designsystem.components.button.SocialButtonUI
import br.com.agvsistemas.myweight.designsystem.components.divider.HorizontalDividerWithTextUI
import br.com.agvsistemas.myweight.designsystem.components.feedback.FeedbackUI
import br.com.agvsistemas.myweight.designsystem.components.logo.LogoUI
import br.com.agvsistemas.myweight.designsystem.components.textfield.TextFieldUI
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme
import kotlinx.coroutines.launch
@Composable
fun SignInScreen(
    navigateToSignUpScreen: () -> Unit,
    viewModel: SignInViewModel = koinViewModel<SignInViewModel>()
) {
    val state by viewModel.state.collectAsState()

    SignInContent(
        state = state,
        onAction = viewModel::onAction,
        navigateToSignUpScreen = navigateToSignUpScreen
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("LocalContextGetResourceValueCall")
@Composable
fun SignInContent(
    state: SignInState,
    onAction: (SignInAction) -> Unit,
    navigateToSignUpScreen: () -> Unit,
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.hasFeedback) {
        if (state.hasFeedback) {
            scope.launch {
                val result = snackbarHostState
                    .showSnackbar(
                        message = context.getString(
                            state.feedbackUI?.second ?: R.string.error_generic
                        ),
                        duration = SnackbarDuration.Long
                    )

                if (result == SnackbarResult.Dismissed) {
                    onAction(SignInAction.ClearFeedback)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { snackbarData ->
                    state.feedbackUI?.let { feedbackUI ->
                        FeedbackUI(
                            message = snackbarData.visuals.message,
                            type = feedbackUI.first
                        )
                    }
                }
            )
        },
        containerColor = MyWeightTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LogoUI(
                modifier = Modifier.size(128.dp)
            )

            Spacer(modifier = Modifier.height(MyWeightTheme.spacing.large))

            Text(
                text = stringResource(R.string.label_title_signin_screen),
                style = MyWeightTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(MyWeightTheme.spacing.large))

            TextFieldUI(
                modifier = Modifier,
                value = state.email,
                label = stringResource(id = R.string.label_input_email_signin_screen),
                placeholder = "example@gmail.com",
                isError = state.invalidInputType == InputType.EMAIL,
                error = stringResource(state.invalidInputType.inputErrorMessage()),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = null,
                        tint = MyWeightTheme.colorScheme.outline
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    onAction(SignInAction.OnEmailChanged(it))
                }
            )

            Spacer(modifier = Modifier.height(MyWeightTheme.spacing.large))

            TextFieldUI(
                modifier = Modifier,
                value = state.password,
                label = stringResource(R.string.label_input_password_signin_screen),
                placeholder = "********",
                isError = state.invalidInputType == InputType.PASSWORD,
                error = stringResource(state.invalidInputType.inputErrorMessage()),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibility_on),
                        contentDescription = null,
                        tint = MyWeightTheme.colorScheme.outline
                    )
                },
                trailingIcon = {
                    if (state.password.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                onAction(SignInAction.OnPasswordVisibilityChanged)
                            },
                            content = {
                                Icon(
                                    painter = if (state.passwordVisibility) {
                                        painterResource(id = R.drawable.ic_visibility_off)
                                    } else {
                                        painterResource(id = R.drawable.ic_visibility_on)
                                    },
                                    contentDescription = null,
                                    tint = MyWeightTheme.colorScheme.outline
                                )
                            }
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = if (state.passwordVisibility) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                onValueChange = {
                    onAction(SignInAction.OnPasswordChanged(value = it))
                }
            )

            Spacer(modifier = Modifier.height(MyWeightTheme.spacing.large))

            PrimaryButtonUI(
                text = stringResource(id = R.string.label_button_signin_screen),
                isLoading = state.isLoading,
                enabled = true,
                onClick = { onAction(SignInAction.OnSignInClick) }
            )

            Spacer(modifier = Modifier.height(MyWeightTheme.spacing.large))

            HorizontalDividerWithTextUI(
                text = stringResource(id = R.string.label_or_signin_screen)
            )

            Spacer(modifier = Modifier.height(20.dp))

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

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.label_sign_up_account_signin_screen),
                    style = MyWeightTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = stringResource(id = R.string.label_sign_up_signin_screen),
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { navigateToSignUpScreen()  },
                    style = MyWeightTheme.typography.labelLarge.copy(
                        color = MyWeightTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun SignInPreview() {
    MyWeightTheme {
        SignInContent(
            state = SignInState(),
            onAction = {},
            navigateToSignUpScreen = { }
        )
    }
}