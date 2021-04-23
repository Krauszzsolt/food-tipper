package com.foodtipper.persistence
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) var foodId: Int?,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "url") var url: String
)
