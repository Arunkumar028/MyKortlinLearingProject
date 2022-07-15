package com.example.mykortlinlearingproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foodtable")
data class FoodItems(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "shortname")
    var shortname: String,
    @ColumnInfo(name = "price")
    var price: String,
    @ColumnInfo(name = "breaf")
    var breaf: String,
    @ColumnInfo(name = "rating")
    var rating: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}