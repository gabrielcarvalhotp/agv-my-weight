package br.com.agvsistemas.myweight.ui.features.signin

import br.com.agvsistemas.myweight.core.enums.FeedbackType
import br.com.agvsistemas.myweight.core.enums.InputType

data class SignInState(
    val isLoading: Boolean = false,
    val invalidInputType: InputType? = null,
    val hasFeedback: Boolean = false,
    val feedbackUI: Pair<FeedbackType, Int>? = null,
    val email: String = "",
    val password: String = "",
    val passwordVisibility: Boolean = false,
)