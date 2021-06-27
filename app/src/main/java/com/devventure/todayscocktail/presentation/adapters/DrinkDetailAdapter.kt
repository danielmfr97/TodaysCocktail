package com.devventure.todayscocktail.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devventure.todayscocktail.R

class DrinkDetailAdapter(private val mData: HashMap<String?, String?>) : RecyclerView.Adapter<DrinkDetailAdapter.MyViewHolder>() {

    private val mKeys = mData.keys.toTypedArray()
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDrinkIngredient: TextView = itemView.findViewById(R.id.tvDrinkIngredient)
        private val tvDrinkMeasure: TextView = itemView.findViewById(R.id.tvDrinkMeasure)
        fun bind(drinkIngredient: String?, drinkMeasure: String) {
            tvDrinkIngredient.text = drinkIngredient
            tvDrinkMeasure.text = drinkMeasure
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_drink_detail, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val drinkIngredient = mKeys[position]
        val drinkMeasure = mData[drinkIngredient].toString()
        holder.bind(drinkIngredient, drinkMeasure)
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}