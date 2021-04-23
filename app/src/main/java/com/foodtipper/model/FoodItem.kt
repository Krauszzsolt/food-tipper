package com.foodtipper.model

import com.google.gson.annotations.SerializedName


data class FoodItem (
    @SerializedName("idMeal")
    var id: String? = null,

    @SerializedName("strMeal")
    var name: String? = null,

    @SerializedName("strMealThumb")
    var url: String? = null)