package uz.smartmuslim.adminpanel.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.smartmuslim.adminpanel.domain.usecase.SplashScreenUseCase
import uz.smartmuslim.adminpanel.domain.usecase.impl.SplashScreenUseCaseImpl


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindSplashScreenUseCase(impl: SplashScreenUseCaseImpl): SplashScreenUseCase

}