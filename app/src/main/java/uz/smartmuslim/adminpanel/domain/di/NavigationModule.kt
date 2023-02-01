package uz.smartmuslim.adminpanel.domain.di

import cafe.adriel.voyager.navigator.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.adminpanel.presentation.navigation.AppNavigation
import uz.smartmuslim.adminpanel.presentation.navigation.NavigationDispatcher
import uz.smartmuslim.adminpanel.presentation.navigation.NavigationHandler


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun navigator(dispatcher: NavigationDispatcher): AppNavigation

    @Binds
    fun navigatorHandler(dispatcher: NavigationDispatcher): NavigationHandler

}