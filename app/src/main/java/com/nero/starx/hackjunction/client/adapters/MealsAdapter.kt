package com.nero.starx.hackjunction.client.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.client.Activities.CoffeeSection
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.paulig.client.R

class MealsAdapter(private val MealList:ArrayList<Meal>)
    :RecyclerView.Adapter<MealsAdapter.MealHolder>() {

    private var itemMealList = ArrayList<Meal>()

    init {
        itemMealList = MealList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MealHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MealHolder, position: Int) {
        val item = itemMealList[position]
        holder.name.text = item.name
        holder.price.text = "${item.price}EUR"
        holder.moreButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, CoffeeSection::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = itemMealList.size

    class MealHolder(inflater:LayoutInflater,parent:ViewGroup)
        :RecyclerView.ViewHolder(inflater.inflate(R.layout.meal_item,parent,false)){

        val name: TextView = itemView.findViewById(R.id.meal_name)
        val price: TextView = itemView.findViewById(R.id.meal_price)
        val moreButton:Button = itemView.findViewById(R.id.more_button)

    }
}