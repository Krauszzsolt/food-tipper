package com.foodtipper

import android.app.Application
import com.foodtipper.persistence.PersistenceModule
import com.foodtipper.ui.UIModule


class FoodTipperApplication  : Application() {
    lateinit var injector: FoodTipperApplicationComponent


    override fun onCreate() {
        super.onCreate()
        injector = DaggerFoodTipperApplicationComponent.builder()
            .uIModule(UIModule(this))
            .persistenceModule(PersistenceModule(this))
            .build()
    }
}