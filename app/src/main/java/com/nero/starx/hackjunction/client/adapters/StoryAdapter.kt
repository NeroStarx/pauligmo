package com.nero.starx.hackjunction.client.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.nero.starx.hackjunction.client.Activities.CoffeeSection
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.paulig.client.R

class StoryAdapter(private val MealList:ArrayList<Meal>)
    :RecyclerView.Adapter<StoryAdapter.StoryHolder>() {

    private var itemMealList = ArrayList<Meal>()

    init {
        itemMealList = MealList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StoryHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: StoryHolder, position: Int) {
        val item = itemMealList[position]

        when(position){
            0->holder.view.setActualImageResource(R.drawable.pic1)
            1->holder.view.setActualImageResource(R.drawable.pic2)
            2->holder.view.setActualImageResource(R.drawable.pic3)
            3->holder.view.setActualImageResource(R.drawable.pic4)
            else->holder.view.setActualImageResource(R.drawable.pic1)
        }


    }

    override fun getItemCount(): Int = itemMealList.size

    class StoryHolder(inflater:LayoutInflater,parent:ViewGroup)
        :RecyclerView.ViewHolder(inflater.inflate(R.layout.story_item,parent,false)){

        val view:SimpleDraweeView = itemView.findViewById(R.id.account_image)
    }
}