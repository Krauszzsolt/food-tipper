package com.foodtipper.interactor.api

import com.foodtipper.interactor.api.event.GetFoodDetailApiEvent
import com.foodtipper.model.FoodDetails
import org.greenrobot.eventbus.EventBus

class ApiInteractor {


    fun getFoodDetail(id: String) {
        val event = GetFoodDetailApiEvent()

        try {
            event.food = FoodDetails(id, "Teszt", "Teszt", "Teszt")
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }

    fun getFoods() {

    }

    fun editFood() {

    }

    fun deleteFood() {

    }
}