package com.example.mykortlinlearingproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mykortlinlearingproject.adapter.FavAdapter
import com.example.mykortlinlearingproject.adapter.FavoriteRemove
import com.example.mykortlinlearingproject.databinding.ActivityFavoriteBinding
import com.example.mykortlinlearingproject.favorite.FavItems
import com.example.mykortlinlearingproject.viewmodel.MainViewModel

class FavoriteActivity : AppCompatActivity(), FavoriteRemove {

    lateinit var binding: ActivityFavoriteBinding
    private lateinit var favAdapter: FavAdapter
    var favitems = ArrayList<FavItems>()
    lateinit var favoriteviewmodel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ObserverView()
        intviews()
    }

    private fun ObserverView() {
        favoriteviewmodel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(MainViewModel::class.java)

        favoriteviewmodel.allfavlist.observeForever {
            it?.let {
                favitems = it as ArrayList<FavItems>
                favAdapter.updateList(it)
            }
        }
    }

    private fun intviews() {
        favAdapter = FavAdapter(favitems, this)
        binding.favoriteItems.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.favoriteItems.adapter = favAdapter
    }

    override fun onBackPressed() {
        //  super.onBackPressed()
        finish()
    }

    override fun Removefav(favItems: FavItems) {
        favoriteviewmodel.removeFav(favItems)
        favAdapter.notifyDataSetChanged()
        favAdapter.RemoveFav()
        Toast.makeText(this, "Deleted successfully", Toast.LENGTH_LONG).show()
    }
}