package com.foodtipper.ui.main

import com.foodtipper.model.FoodItem

interface MainScreen {
    fun testInjection(text: String)
    fun showFood(foods : List<FoodItem>)
}