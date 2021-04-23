package com.foodtipper.persistence
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FoodEntity::class], version = 1, exportSchema = false)
abstract class FoodDataBase: RoomDatabase() {
    abstract fun foodDAO(): FoodDAO
}