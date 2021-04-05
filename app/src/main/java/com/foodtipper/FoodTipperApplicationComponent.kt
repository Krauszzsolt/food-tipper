package com.foodtipper

import com.foodtipper.ui.UIModule
import com.foodtipper.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class])
interface FoodTipperApplicationComponent {
    fun inject(mainActivity: MainActivity)
}