package com.example.mykortlinlearingproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.mykortlinlearingproject.favorite.FavItems
import com.example.mykortlinlearingproject.database.FoodDatabase
import com.example.mykortlinlearingproject.database.FoodItems
import com.example.mykortlinlearingproject.database.FoodRespository
import com.example.mykortlinlearingproject.favorite.FavRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {


    val allEvents: LiveData<List<FoodItems>>
    val repository: FoodRespository

    var allfavlist: LiveData<List<FavItems>>
    var favRespository: FavRespository

    init {
        val dao = FoodDatabase.getDatabase(application).getFoodDao()
        val dao1 = FoodDatabase.getDatabase(application).getFavorite()
        repository = FoodRespository(dao)
        allEvents = repository.allNotes

        favRespository = FavRespository(dao1)
        allfavlist = favRespository.allNotes
    }

    fun insertdata(foodItems: List<FoodItems>) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(foodItems)
    }

    fun insertfav(foodItems: FavItems) = viewModelScope.launch(Dispatchers.IO) {
        favRespository.insert(foodItems)
    }

    fun removeFav(foodItems: FavItems)= viewModelScope.launch(Dispatchers.IO){
        favRespository.delete(foodItems)
    }

}