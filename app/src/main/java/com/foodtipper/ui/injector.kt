package com.foodtipper.ui


import android.app.Activity
import androidx.fragment.app.Fragment
import com.foodtipper.FoodTipperApplication
import com.foodtipper.FoodTipperApplicationComponent


val Activity.injector: FoodTipperApplicationComponent
    get() {
        return (this.applicationContext as FoodTipperApplication).injector
    }

val Fragment.injector: FoodTipperApplicationComponent
    get() {
        return (this.context!!.applicationContext as FoodTipperApplication).injector
    }