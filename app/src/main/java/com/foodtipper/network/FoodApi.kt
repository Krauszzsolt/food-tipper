package com.foodtipper.network

import com.foodtipper.model.FoodResult
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface FoodApi {
    @GET("filter.php?a=Canadian")
    fun getFoods(): Call<FoodResult>
}