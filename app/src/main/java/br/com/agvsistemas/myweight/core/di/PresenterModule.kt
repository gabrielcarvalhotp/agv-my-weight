package br.com.agvsistemas.myweight.core.di

import br.com.agvsistemas.myweight.ui.features.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presenterModule = module {
    viewModelOf(::SplashViewModel)
}