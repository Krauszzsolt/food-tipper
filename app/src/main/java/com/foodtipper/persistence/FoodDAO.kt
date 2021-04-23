package com.foodtipper.persistence
import androidx.room.*
@Dao
interface FoodDAO {

    @Query("SELECT * FROM foods WHERE foodId = :foodId LIMIT 1")
    fun getFoodById(foodId: String): FoodEntity?

    @Query("SELECT * FROM foods")
    fun loadAllFoods(): Array<FoodEntity>

    @Insert
    fun insertFood(foods: FoodEntity)

    @Update
    fun updateFood(foods: FoodEntity)

    @Query("DELETE FROM foods WHERE foodId = :foodId")
    fun deleteFoodById(foodId: String)

}
