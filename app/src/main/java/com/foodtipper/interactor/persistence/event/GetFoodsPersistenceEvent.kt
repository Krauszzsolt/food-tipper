package com.foodtipper.interactor.persistence.event

import com.foodtipper.model.FoodItem

data class GetFoodsPersistenceEvent (
    var foods: List<FoodItem>? = null
)