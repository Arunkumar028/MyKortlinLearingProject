package com.example.mykortlinlearingproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun InsertData(foodItems: List<FoodItems>)

    @Query("SELECT * FROM foodtable order by id ASC")
    fun getfoodDetails() : LiveData<List<FoodItems>>
}