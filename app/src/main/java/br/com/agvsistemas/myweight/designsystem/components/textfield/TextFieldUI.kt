package br.com.agvsistemas.myweight.designsystem.components.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import br.com.agvsistemas.myweight.R
import br.com.agvsistemas.myweight.designsystem.theme.MyWeightTheme

@Composable
fun TextFieldUI(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String? = null,
    placeholder: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    error: String = "",
    singleLine: Boolean = false,
    maxLength: Int = Int.MAX_VALUE,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    requireKeyboardFocus: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }
    val customTextSelectionColors = TextSelectionColors(
        handleColor = MyWeightTheme.colorScheme.primary,
        backgroundColor = MyWeightTheme.colorScheme.background
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        label?.let {
            Text(
                text = it,
                style = MyWeightTheme.typography.labelLarge.copy(
                    color = if (isError)
                        MyWeightTheme.colorScheme.onError
                    else
                        MyWeightTheme.colorScheme.outline
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
        }

        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                value = value,
                onValueChange = { value ->
                    if (value.length <= maxLength) {
                        onValueChange(value)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = if (isError) {
                            MyWeightTheme.colorScheme.error
                        } else {
                            MyWeightTheme.colorScheme.outline
                        },
                        shape = RoundedCornerShape(12.dp)
                    )
                    .focusRequester(focusRequester),
                enabled = enabled,
                placeholder = {
                    Text(
                        text = placeholder,
                        style = MyWeightTheme.typography.labelLarge
                    )
                },
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                isError = isError,
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                singleLine = singleLine,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MyWeightTheme.colorScheme.surfaceContainerHigh,
                    unfocusedContainerColor = MyWeightTheme.colorScheme.surfaceContainerHigh,
                    disabledContainerColor = MyWeightTheme.colorScheme.surfaceContainerHigh,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    focusedTextColor = MyWeightTheme.colorScheme.onSurface,
                    unfocusedTextColor = MyWeightTheme.colorScheme.onSurface,
                    disabledTextColor = MyWeightTheme.colorScheme.onSurfaceVariant,
                    errorTextColor = MyWeightTheme.colorScheme.onSurface,
                    cursorColor = MyWeightTheme.colorScheme.primary,
                    errorContainerColor = MyWeightTheme.colorScheme.errorContainer
                )
            )
        }

        if (isError) {
            Text(
                text = error,
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp),
                style = MyWeightTheme.typography.bodyMedium.copy(
                    color = MyWeightTheme.colorScheme.onError
                )
            )
        }

        if (requireKeyboardFocus) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun TextFieldUIPreview() {
    var textValue by remember {
        mutableStateOf("")
    }

    MyWeightTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MyWeightTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextFieldUI(
                modifier = Modifier
                    .padding(32.dp),
                value = textValue,
                isError = false,
                enabled = false,
                label = "Usuário",
                placeholder = "Ex: Arley Santana",
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibility_on),
                        contentDescription = null,
                        tint = MyWeightTheme.colorScheme.outline
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_visibility_off),
                                contentDescription = null,
                                tint = MyWeightTheme.colorScheme.outline
                            )
                        }
                    )
                },
                onValueChange = {
                    textValue = it
                }
            )

            TextFieldUI(
                modifier = Modifier
                    .padding(32.dp),
                value = textValue,
                isError = false,
                placeholder = "Ex: Arley Santana",
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibility_on),
                        contentDescription = null,
                        tint = MyWeightTheme.colorScheme.outline
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_visibility_off),
                                contentDescription = null,
                                tint = MyWeightTheme.colorScheme.outline
                            )
                        }
                    )
                },
                onValueChange = {
                    textValue = it
                }
            )

            TextFieldUI(
                modifier = Modifier
                    .padding(32.dp),
                value = textValue,
                isError = true,
                error = stringResource(R.string.error_first_name_invalid),
                label = "Usuário",
                placeholder = "Ex: Gabriel Oliveira",
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibility_on),
                        contentDescription = null,
                        tint = MyWeightTheme.colorScheme.outline
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_visibility_off),
                                contentDescription = null,
                                tint = MyWeightTheme.colorScheme.outline
                            )
                        }
                    )
                },
                onValueChange = {
                    textValue = it
                }
            )
        }
    }
}