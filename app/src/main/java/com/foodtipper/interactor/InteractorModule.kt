package com.foodtipper.interactor

import com.foodtipper.interactor.api.ApiInteractor
import com.foodtipper.interactor.persistence.PersistenceInteractor
import com.foodtipper.network.FoodApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideApiInteractor(foodApi: FoodApi) = ApiInteractor(foodApi)

    @Provides
    @Singleton
    fun providePersistenceInteractor() = PersistenceInteractor()
}