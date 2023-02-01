package uz.smartmuslim.adminpanel.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.adminpanel.domain.repository.AppRepository
import uz.smartmuslim.adminpanel.domain.usecase.SplashScreenUseCase
import javax.inject.Inject

class SplashScreenUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : SplashScreenUseCase {
    override fun getIsFirst(): Flow<Boolean> = repository.getIsFirst()
}