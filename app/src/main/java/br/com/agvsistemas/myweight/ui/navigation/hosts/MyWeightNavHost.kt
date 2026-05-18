package br.com.agvsistemas.myweight.ui.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.agvsistemas.myweight.ui.features.splash.SplashScreen
import br.com.agvsistemas.myweight.ui.navigation.routes.MyWeightRoute

@Composable
fun MyWeightNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MyWeightRoute.Splash
    ) {
        composable<MyWeightRoute.Splash> {
            SplashScreen()
        }
    }
}