package com.example.mykortlinlearingproject.database

import androidx.lifecycle.LiveData

class FoodRespository (private val notesDao: FoodDao) {

    val allNotes: LiveData<List<FoodItems>> = notesDao.getfoodDetails()

    // on below line we are creating an insert method
     fun insert(foodItem: List<FoodItems>) {
        notesDao.InsertData(foodItem)
    }

}