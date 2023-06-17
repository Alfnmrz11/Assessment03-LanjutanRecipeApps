package com.d3if3005.yummytime.db

import androidx.room.*
import com.d3if3005.yummytime.utils.Constant.FOOD_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFood(entity: FoodEntity)

    @Delete
    suspend fun deleteFood(entity: FoodEntity)

    @Query("SELECT * FROM $FOOD_TABLE")
    fun getAllFoods(): Flow<MutableList<FoodEntity>>

    @Query("SELECT EXISTS (SELECT 1 FROM $FOOD_TABLE WHERE id = :id)")
    fun existsFood(id: Int): Flow<Boolean>
}