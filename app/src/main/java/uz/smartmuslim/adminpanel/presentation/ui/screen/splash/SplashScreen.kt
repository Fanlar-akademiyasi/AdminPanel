package uz.smartmuslim.adminpanel.presentation.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.smartmuslim.adminpanel.R
import uz.smartmuslim.adminpanel.presentation.ui.viewmodel.SplashIntent
import uz.smartmuslim.adminpanel.presentation.ui.viewmodel.SplashScreenViewModel
import uz.smartmuslim.adminpanel.presentation.ui.viewmodel.SplashState
import uz.smartmuslim.adminpanel.presentation.ui.viewmodel.impl.SplashScreenViewModelImpl

class SplashScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: SplashScreenViewModel = getViewModel<SplashScreenViewModelImpl>()
        val uiState = viewModel.collectAsState().value
        SplashScreenContent(uiState, viewModel::onEventDispatcher)
    }
}

@Composable
fun SplashScreenContent(uiState: SplashState, onEventDispatcher: (SplashIntent) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        LaunchedEffect(key1 = true) {
            onEventDispatcher(SplashIntent.OpenMainScreen)
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            colorFilter = ColorFilter.tint(Color.Blue),
            contentDescription = "icon"
        )

    }
}