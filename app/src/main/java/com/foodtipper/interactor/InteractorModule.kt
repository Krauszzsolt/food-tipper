package com.foodtipper.interactor

import com.foodtipper.interactor.api.ApiInteractor
import com.foodtipper.interactor.persistence.PersistenceInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideApiInteractor() = ApiInteractor()

    @Provides
    @Singleton
    fun providePersistenceInteractor() = PersistenceInteractor()
}