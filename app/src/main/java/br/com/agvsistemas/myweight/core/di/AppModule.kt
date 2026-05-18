package br.com.agvsistemas.myweight.core.di

import org.koin.dsl.module

val appModules = module {
    includes(
        presenterModule
    )
}