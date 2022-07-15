package com.example.mykortlinlearingproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykortlinlearingproject.databinding.ListItemFoodBinding
import com.example.mykortlinlearingproject.favorite.FavItems

class FavAdapter(private var list: ArrayList<FavItems>,
private var removefav: FavoriteRemove

) :
    RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    class ViewHolder(private var itembinding: ListItemFoodBinding) :
        RecyclerView.ViewHolder(itembinding.root) {
        fun bind(foodlitems: FavItems) {
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
        val foodlitems: FavItems = list[position]
        holder.bind(foodlitems)
        holder.itemView.setOnClickListener{
            removefav.Removefav(list.get(position))

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newlist: List<FavItems>) {
        list.addAll(newlist)
        notifyDataSetChanged()
    }

    fun RemoveFav() {
        notifyDataSetChanged()
    }


}
interface FavoriteRemove{
    fun Removefav(favItems: FavItems)
}