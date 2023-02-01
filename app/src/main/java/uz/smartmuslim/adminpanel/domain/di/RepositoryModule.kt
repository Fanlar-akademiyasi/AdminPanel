package uz.smartmuslim.adminpanel.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.smartmuslim.adminpanel.domain.repository.AppRepository
import uz.smartmuslim.adminpanel.domain.repository.impl.AppRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindRepository(impl: AppRepositoryImpl): AppRepository

}