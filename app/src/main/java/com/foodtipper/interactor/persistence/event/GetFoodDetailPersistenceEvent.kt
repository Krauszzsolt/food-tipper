package com.foodtipper.interactor.persistence.event

import com.foodtipper.interactor.Event
import com.foodtipper.model.FoodDetails

data class GetFoodDetailPersistenceEvent (var food: FoodDetails? = null): Event()