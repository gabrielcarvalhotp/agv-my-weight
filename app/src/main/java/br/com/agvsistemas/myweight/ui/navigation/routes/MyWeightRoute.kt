package br.com.agvsistemas.myweight.ui.navigation.routes

import kotlinx.serialization.Serializable

sealed class MyWeightRoute {
    @Serializable
    data object Splash
}
