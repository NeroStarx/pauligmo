package com.nero.starx.hackjunction.client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.paulig.client.R

class MessageAdapter(private val MealList:ArrayList<Meal>)
    : RecyclerView.Adapter<MessageAdapter.MessageHolder>() {

    private var itemMealList = ArrayList<Meal>()

    init {
        itemMealList = MealList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MessageHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        val item = itemMealList[position]
    }

    override fun getItemCount(): Int = itemMealList.size

    class MessageHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.message_item,parent,false)){

        val view: ImageView = itemView.findViewById(R.id.user_image)
    }
}