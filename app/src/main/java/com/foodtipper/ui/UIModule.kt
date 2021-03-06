package com.foodtipper.ui

import android.content.Context
import com.foodtipper.interactor.api.ApiInteractor
import com.foodtipper.ui.detail.DetailPresenter
import com.foodtipper.ui.edit.EditPresenter
import com.foodtipper.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context


    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, foodInteractor: ApiInteractor) =
        MainPresenter(executor, foodInteractor)

    @Provides
    @Singleton
    fun editPresenter() = EditPresenter()


    @Provides
    @Singleton
    fun detailPresenter() = DetailPresenter()


    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}
