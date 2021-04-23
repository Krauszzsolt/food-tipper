package com.foodtipper.interactor.persistence

import com.foodtipper.interactor.persistence.event.DeleteFoodPersistenceEvent
import com.foodtipper.interactor.persistence.event.GetFoodDetailPersistenceEvent
import com.foodtipper.interactor.persistence.event.GetFoodsPersistenceEvent
import com.foodtipper.interactor.persistence.event.PostFoodPersistenceEvent
import com.foodtipper.model.FoodDetails
import com.foodtipper.model.FoodItem
import com.foodtipper.persistence.FoodDAO
import com.foodtipper.persistence.FoodEntity
import org.greenrobot.eventbus.EventBus

class PersistenceInteractor(private val foodDAO: FoodDAO) {

    fun getFoodDetail(id: String) {
        val event = GetFoodDetailPersistenceEvent()

        try {
            val food = foodDAO.getFoodById(id)
            if (food != null) {
                event.food = FoodDetails(food.foodId.toString(), food.name, food.url)
            }
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }

    fun getFoods() {
        val event = GetFoodsPersistenceEvent()

        try {
            val foods = foodDAO.loadAllFoods()
            event.foods = foods.map { FoodItem(it.foodId.toString(), it.name, it.url) }
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }

    fun editFood(food: FoodItem) {
        val event = PostFoodPersistenceEvent()
        try {
            if (food.id != null) {
                foodDAO.insertFood(FoodEntity(food.id?.toInt(), food.name!!, food.url!!))

            } else {
                foodDAO.insertFood(FoodEntity(null, food.name!!, food.url!!))

            }
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }

    fun deleteFood(id: String) {
        val event = DeleteFoodPersistenceEvent()
        try {
            foodDAO.deleteFoodById(id)
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.exception = e
            EventBus.getDefault().post(event)
        }
    }
}