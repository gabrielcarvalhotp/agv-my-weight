package br.com.agvsistemas.myweight.ui.features.signin

sealed interface SignInAction {
    data class OnEmailChanged(val value: String) : SignInAction
    data class OnPasswordChanged(val value: String) : SignInAction
    data object OnPasswordVisibilityChanged : SignInAction
    data object OnSignInClick: SignInAction
    data object ClearFeedback: SignInAction
}