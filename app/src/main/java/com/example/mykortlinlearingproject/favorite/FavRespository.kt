package com.example.mykortlinlearingproject.favorite

import androidx.lifecycle.LiveData

class FavRespository(private val favDao: FavDao) {
    val allNotes: LiveData<List<FavItems>> = favDao.getFavDetails()

    // on below line we are creating an insert method
    fun insert(foodItem: FavItems) {
        favDao.InsertFav(foodItem)
    }
    fun delete(favItems: FavItems){
        favDao.DeleteFav(favItems)
    }
}