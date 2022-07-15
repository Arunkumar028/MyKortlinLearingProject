package com.example.mykortlinlearingproject.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykortlinlearingproject.Const
import com.example.mykortlinlearingproject.adapter.FavInterface
import com.example.mykortlinlearingproject.adapter.FoodAdapter
import com.example.mykortlinlearingproject.database.FoodDatabase
import com.example.mykortlinlearingproject.database.FoodItems
import com.example.mykortlinlearingproject.databinding.ActivityMainBinding
import com.example.mykortlinlearingproject.favorite.FavItems
import com.example.mykortlinlearingproject.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), FavInterface {

    lateinit var binding: ActivityMainBinding
    var foodlitems = ArrayList<FoodItems>()
    private lateinit var foodAdapter: FoodAdapter
    lateinit var viewModal: MainViewModel

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        viewmodels()
        observeEvents()
    }

    private fun initView() {
        foodlitems = Const.getallfood()
        foodAdapter = FoodAdapter(foodlitems, this)
        binding.recyclerFoodItems.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerFoodItems.adapter = foodAdapter
    }

    private fun viewmodels() {
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(MainViewModel::class.java)
        for (i in foodlitems) {
            viewModal.insertdata(listOf(i))
        }
    }

    private fun observeEvents() {
        viewModal.allEvents.observeForever {
            it?.let {
                foodAdapter.updateList(it)
            }
        }
    }

    override fun favitem(foodItems: FoodItems) {
        viewModal.insertfav(
            FavItems(
                foodItems.name, foodItems.shortname, foodItems.price,
                foodItems.breaf, foodItems.rating
            )
        )
       // startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))

        var intent=Intent(applicationContext,FavoriteActivity::class.java)
        intent.putExtra("arun","arun")
        startActivity(intent)

        startActivity(Intent(this@MainActivity,FavoriteActivity::class.java))
    }

}
