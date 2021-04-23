package com.foodtipper.persistence

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule(context: Context) {

    private var foodDatabase: FoodDataBase? = null

    init {
        foodDatabase = Room.databaseBuilder(
            context.applicationContext,
            FoodDataBase::class.java,
            "food-db"
        ).build()
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): FoodDataBase {
        return foodDatabase!!
    }

    @Singleton
    @Provides
    fun providesProductDao(foodDatabase: FoodDataBase): FoodDAO {
        return foodDatabase.foodDAO()
    }

}