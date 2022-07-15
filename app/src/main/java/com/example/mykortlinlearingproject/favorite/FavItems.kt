package com.example.mykortlinlearingproject.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "favtable", indices = [Index(value = ["id","name"], unique = true)])
data class FavItems(
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