package com.example.mykortlinlearingproject

import com.example.mykortlinlearingproject.database.FoodItems

object Const {

    fun getallfood(): ArrayList<FoodItems> {
        var foodlist = ArrayList<FoodItems>()

        var food1 = FoodItems( "Pizza", "In Meals & Combos", "100",
            "Half portion of Pizza, checken 65, parotto,Ratha and Gray","150")

        foodlist.add(food1)

        var food2 = FoodItems( "Chicken", "In Meals & Combos", "200",
            "Half portion of chicken biriyani, checken 65, parotto,Ratha and Gray","110")

        foodlist.add(food2)

        var food3 = FoodItems( "Meals", "In Meals & Combos", "200",
            "Half portion of chicken biriyani, checken 65, parotto,Ratha and Gray","110")

        foodlist.add(food3)
        var food4 = FoodItems( "Dosa", "In Meals & Combos", "200",
            "Half portion of chicken biriyani, checken 65, parotto,Ratha and Gray","110")

        foodlist.add(food4)
        var food5 = FoodItems( "Itely", "In Meals & Combos", "200",
            "Half portion of chicken biriyani, checken 65, parotto,Ratha and Gray","110")

        foodlist.add(food5)
        return foodlist
    }
}