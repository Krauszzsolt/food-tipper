package com.foodtipper.interactor.api

import android.util.Log
import com.foodtipper.interactor.api.event.DeleteFoodApiEvent
import com.foodtipper.interactor.api.event.GetFoodDetailApiEvent
import com.foodtipper.interactor.api.event.GetFoodsApiEvent
import com.foodtipper.interactor.api.event.PostFoodApiEvent
import com.foodtipper.model.FoodDetails
import com.foodtipper.network.FoodApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class ApiInteractor @Inject constructor(private var foodApi: FoodApi) {


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
            val response = foodApi.getFoods().execute();

            event.foods = response.body()?.foods;
//                listOf(FoodItem("Teszt", "Teszt", "Teszt"), FoodItem("Teszt", "Teszt", "Teszt"))
//
            Log.d("Response", response.body().toString())
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