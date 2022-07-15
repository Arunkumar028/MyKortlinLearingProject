package com.example.mykortlinlearingproject.favorite

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun InsertFav(foodItems: FavItems)

    @Query("SELECT * FROM favtable order by name ASC")
    fun getFavDetails() : LiveData<List<FavItems>>

    @Delete
    fun DeleteFav(favItems: FavItems)
}