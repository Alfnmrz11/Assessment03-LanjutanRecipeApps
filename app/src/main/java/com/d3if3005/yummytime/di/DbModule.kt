package com.d3if3005.yummytime.di

import android.content.Context
import androidx.room.Room
import com.d3if3005.yummytime.db.FoodDatabase
import com.d3if3005.yummytime.db.FoodEntity
import com.d3if3005.yummytime.utils.Constant.FOOD_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, FoodDatabase::class.java, FOOD_DATABASE
    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: FoodDatabase) = db.foodDao()

    @Provides
    @Singleton
    fun provideEntity() = FoodEntity()
}