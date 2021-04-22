package com.foodtipper.interactor.persistence

import com.foodtipper.interactor.persistence.event.DeleteFoodPersistenceEvent
import com.foodtipper.interactor.persistence.event.GetFoodDetailPersistenceEvent
import com.foodtipper.interactor.persistence.event.GetFoodsPersistenceEvent
import com.foodtipper.interactor.persistence.event.PostFoodPersistenceEvent
import com.foodtipper.model.FoodDetails
import com.foodtipper.model.FoodItem
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
        val event = GetFoodsPersistenceEvent()

        try {
            event.foods =
                listOf(FoodItem("Teszt", "Teszt", "Teszt"), FoodItem("Teszt", "Teszt", "Teszt"))
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }

    fun editFood() {
        val event = PostFoodPersistenceEvent()
        try {
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }

    fun deleteFood() {
        val event = DeleteFoodPersistenceEvent()
        try {

            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }
}