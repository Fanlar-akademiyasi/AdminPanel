package uz.smartmuslim.adminpanel.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SplashScreenUseCase {
    fun getIsFirst(): Flow<Boolean>
}