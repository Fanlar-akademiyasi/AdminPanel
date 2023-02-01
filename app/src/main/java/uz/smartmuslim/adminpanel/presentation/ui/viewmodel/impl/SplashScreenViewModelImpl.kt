package uz.smartmuslim.adminpanel.presentation.ui.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import uz.smartmuslim.adminpanel.domain.usecase.SplashScreenUseCase
import uz.smartmuslim.adminpanel.presentation.direction.SplashScreenDirection
import uz.smartmuslim.adminpanel.presentation.direction.impl.SplashScreenDirectionImpl
import uz.smartmuslim.adminpanel.presentation.ui.viewmodel.SplashIntent
import uz.smartmuslim.adminpanel.presentation.ui.viewmodel.SplashScreenViewModel
import uz.smartmuslim.adminpanel.presentation.ui.viewmodel.SplashState
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModelImpl @Inject constructor(
    private val direction: SplashScreenDirection,
    private val useCase: SplashScreenUseCase
) : SplashScreenViewModel, ViewModel() {
    override fun onEventDispatcher(intent: SplashIntent) {

        viewModelScope.launch {
            delay(2000)
            useCase.getIsFirst().collectLatest {
                if (it) {
                    direction.openLoginScreen()
                } else {
                    direction.openMainScreen()
                }
            }
        }
    }

    override val container: Container<SplashState, Nothing> =
        container(SplashState("Splash Screen"))

}