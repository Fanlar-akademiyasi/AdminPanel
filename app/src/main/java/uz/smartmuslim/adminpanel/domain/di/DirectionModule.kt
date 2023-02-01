package uz.smartmuslim.adminpanel.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.smartmuslim.adminpanel.presentation.direction.SplashScreenDirection
import uz.smartmuslim.adminpanel.presentation.direction.impl.SplashScreenDirectionImpl
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @[Binds]
    fun bindSplashScreenDirection(impl: SplashScreenDirectionImpl): SplashScreenDirection
}