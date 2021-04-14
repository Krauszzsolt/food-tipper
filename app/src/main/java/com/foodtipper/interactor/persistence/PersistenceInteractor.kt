package com.foodtipper.interactor.persistence

import com.foodtipper.interactor.persistence.event.GetFoodDetailPersistenceEvent
import com.foodtipper.model.FoodDetails
import org.greenrobot.eventbus.EventBus

class PersistenceInteractor {

    fun getFoodDetail(id: String) {
        val event = GetFoodDetailPersistenceEvent()

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