package com.foodtipper.network

import com.foodtipper.model.FoodItem
import com.foodtipper.model.FoodResult
import retrofit2.Call
import retrofit2.http.*

interface FoodApi {
    @GET("filter.php?a=Canadian")
    fun getFoods(): Call<FoodResult>

    @POST("update")
    fun editFood(
        @Body food: FoodItem
    ): Call<FoodResult>

    @GET("lookup.php")
    fun getFoodDetail(
        @Query("i") id: String,
        ): Call<FoodResult>

    @DELETE("lookup.php")
    fun deleteFood(
        @Query("i") id: String,
    ): Call<FoodResult>
}