package com.foodtipper.interactor.api.event

import com.foodtipper.interactor.Event
import com.foodtipper.model.FoodDetails

data class GetFoodDetailApiEvent (var food: FoodDetails? = null): Event()

