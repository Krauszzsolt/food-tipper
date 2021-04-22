package com.foodtipper.interactor.api

import com.foodtipper.interactor.api.event.DeleteFoodApiEvent
import com.foodtipper.interactor.api.event.GetFoodDetailApiEvent
import com.foodtipper.interactor.api.event.GetFoodsApiEvent
import com.foodtipper.interactor.api.event.PostFoodApiEvent
import com.foodtipper.model.FoodDetails
import com.foodtipper.model.FoodItem
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
        val event = GetFoodsApiEvent()

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
        val event = PostFoodApiEvent()
        try {
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }

    fun deleteFood() {
        val event = DeleteFoodApiEvent()
        try {

            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }
}