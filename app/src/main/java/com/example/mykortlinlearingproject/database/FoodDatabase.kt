package com.example.mykortlinlearingproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mykortlinlearingproject.favorite.FavDao
import com.example.mykortlinlearingproject.favorite.FavItems

@Database(entities = [FoodItems::class,FavItems::class], version = 1, exportSchema = false)
abstract class FoodDatabase :RoomDatabase(){

    abstract fun getFoodDao(): FoodDao

    abstract fun getFavorite(): FavDao

    companion object {
        @Volatile
        private var INSTANCE: FoodDatabase? = null

        fun getDatabase(context: Context): FoodDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(FoodDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Get PhraseRoomDatabase database instance
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            FoodDatabase::class.java, "food_database")
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE!!
            }
        }
    }
