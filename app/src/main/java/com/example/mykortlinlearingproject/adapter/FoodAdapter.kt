package com.example.mykortlinlearingproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykortlinlearingproject.database.FoodItems
import com.example.mykortlinlearingproject.databinding.ListItemFoodBinding

class FoodAdapter(
    private var list: ArrayList<FoodItems>,
    val favInterface: FavInterface
) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(private var itembinding: ListItemFoodBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun bind(foodlitems: FoodItems) {
            var count = 0

            itembinding.TextviewName.text = foodlitems.name
            itembinding.TextviewAmount.text = foodlitems.price
            itembinding.TextviewShortform.text = foodlitems.shortname
            itembinding.TextviewBreaf.text = foodlitems.breaf
            itembinding.TextviewRating.text = foodlitems.rating

            itembinding.TextviewPlus.setOnClickListener {
                count++
                itembinding.TextviewPlus.text = count.toString()
            }
            itembinding.TextviewMinus.setOnClickListener {
                count--
                itembinding.TextviewPlus.text = count.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemFoodBinding =
            ListItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemFoodBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodlitems: FoodItems = list[position]
        holder.bind(foodlitems)

        holder.itemView.setOnClickListener {
            favInterface.favitem(list.get(position))
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newlist: List<FoodItems>) {
        list.clear()
        list.addAll(newlist)
        notifyDataSetChanged()
    }
}

interface FavInterface {
    fun favitem(foodItems: FoodItems)
}