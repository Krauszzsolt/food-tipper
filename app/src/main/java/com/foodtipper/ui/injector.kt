package com.foodtipper.ui


import android.app.Activity
import com.foodtipper.FoodTipperApplication
import com.foodtipper.FoodTipperApplicationComponent


val Activity.injector: FoodTipperApplicationComponent
    get() {
        return (this.applicationContext as FoodTipperApplication).injector
    }

