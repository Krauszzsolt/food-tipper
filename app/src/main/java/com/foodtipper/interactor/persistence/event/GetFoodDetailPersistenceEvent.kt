package com.foodtipper.interactor.persistence.event

import com.foodtipper.model.FoodDetails

data class GetFoodDetailPersistenceEvent (var food: FoodDetails? = null)