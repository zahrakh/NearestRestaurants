package com.zahra.domain.di

import com.zahra.domain.repository.TakeAwayRepository
import com.zahra.domain.usecase.GetRestaurantsByLocationUseCase
import com.zahra.domain.usecase.GetRestaurantsByLocationUseCaseImp
import com.zahra.domain.usecase.GetRestaurantsByPostCodeUseCase
import com.zahra.domain.usecase.GetRestaurantsByPostCodeUseCaseImp
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
    fun provideGetRestaurantsByPostCodeUseCase(
        repository: TakeAwayRepository
    ): GetRestaurantsByPostCodeUseCase {
        return GetRestaurantsByPostCodeUseCaseImp(repository)
    }

    @Provides
    @Singleton
    fun provideGetRestaurantsByLocationUseCase(
        repository: TakeAwayRepository
    ): GetRestaurantsByLocationUseCase {
        return GetRestaurantsByLocationUseCaseImp(repository)
    }

}