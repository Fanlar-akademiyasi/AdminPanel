package uz.smartmuslim.adminpanel.presentation.direction.impl

import uz.smartmuslim.adminpanel.presentation.direction.SplashScreenDirection
import uz.smartmuslim.adminpanel.presentation.navigation.AppNavigation
import uz.smartmuslim.adminpanel.presentation.ui.screen.auth.LoginScreen
import uz.smartmuslim.adminpanel.presentation.ui.screen.main.MainScreen
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val navigator: AppNavigation
) : SplashScreenDirection {

    override suspend fun openMainScreen() = navigator.navigateTo(MainScreen())

    override suspend fun openLoginScreen() = navigator.navigateTo(LoginScreen())
}