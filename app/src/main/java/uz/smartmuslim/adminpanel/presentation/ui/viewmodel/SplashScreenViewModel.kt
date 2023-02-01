package uz.smartmuslim.adminpanel.presentation.ui.viewmodel

import uz.smartmuslim.adminpanel.presentation.ui.screen.splash.SplashScreen
import uz.smartmuslim.adminpanel.utils.AppViewModel

interface SplashScreenViewModel : AppViewModel<SplashIntent, SplashState, Nothing>

sealed class SplashIntent {
    object OpenMainScreen : SplashIntent()
    object OpenLoginScreen : SplashIntent()

}

data class SplashState(val text: String)