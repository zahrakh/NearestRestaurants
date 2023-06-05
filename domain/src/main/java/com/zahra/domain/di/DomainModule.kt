package com.zahra.domain.di

import com.zahra.domain.repository.TakeAwayRepository
import com.zahra.domain.usecase.GetRestaurantsUseCase
import com.zahra.domain.usecase.GetRestaurantsUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetRestaurantsUseCaseImp(repository: TakeAwayRepository): GetRestaurantsUseCase {
        return GetRestaurantsUseCaseImp(repository)
    }

}