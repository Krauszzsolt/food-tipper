package com.foodtipper

import com.foodtipper.interactor.InteractorModule
import com.foodtipper.network.NetworkModule
import com.foodtipper.ui.UIModule
import com.foodtipper.ui.detail.DetailActivity
import com.foodtipper.ui.detail.DetailFragment
import com.foodtipper.ui.edit.EditActivity
import com.foodtipper.ui.edit.EditFragment
import com.foodtipper.ui.main.FoodFragment
import com.foodtipper.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface FoodTipperApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(foodFragment: FoodFragment)
    fun inject(editActivity: EditActivity)
    fun inject(editFragment: EditFragment)
    fun inject(detailActivity: DetailActivity)
    fun inject(detailFragment: DetailFragment)
}