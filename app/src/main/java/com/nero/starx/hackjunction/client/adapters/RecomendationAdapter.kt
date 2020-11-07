package com.nero.starx.hackjunction.client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.paulig.client.R

class RecomendationAdapter(private val MealList:ArrayList<Meal>)
    : RecyclerView.Adapter<RecomendationAdapter.RecommendHolder>() {

    private var itemMealList = ArrayList<Meal>()

    init {
        itemMealList = MealList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecommendHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecommendHolder, position: Int) {
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

    class RecommendHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recommendation,parent,false)){

        val view: SimpleDraweeView = itemView.findViewById(R.id.caffe_view)
    }
}