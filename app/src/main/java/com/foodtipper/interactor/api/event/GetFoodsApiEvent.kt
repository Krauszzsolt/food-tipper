package com.foodtipper.interactor.api.event

import com.foodtipper.model.FoodItem

data class GetFoodsApiEvent (
    var foods: List<FoodItem>? = null
    )