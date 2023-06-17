package com.d3if3005.yummytime.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.d3if3005.yummytime.utils.Constant.FOOD_TABLE

@Entity(tableName = FOOD_TABLE)
data class FoodEntity(
    @PrimaryKey
    var id: Int = 0,
    var title: String = "",
    var img: String = ""
)