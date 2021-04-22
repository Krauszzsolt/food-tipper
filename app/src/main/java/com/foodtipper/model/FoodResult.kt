package com.foodtipper.model

import com.google.gson.annotations.SerializedName

data class FoodResult(
    @SerializedName("meals")
    var foods: List<FoodItem>? = null
)