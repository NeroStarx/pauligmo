package com.nero.starx.hackjunction.client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.paulig.client.R

class CartItemAdapter(private val supplyList:ArrayList<Meal>)
    :RecyclerView.Adapter<CartItemAdapter.SupplyHolder>() {

    var ItemsSupplyList = ArrayList<Meal>()
    init {
        ItemsSupplyList = supplyList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplyHolder {
        val inflater=LayoutInflater.from(parent.context)
        return SupplyHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SupplyHolder, position: Int) {
        val item = ItemsSupplyList[position]

        holder.name.text = item.name
        holder.price.text = "${item.price}Eur"
        holder.delButton.setOnClickListener {
            ItemsSupplyList.remove(item)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int = ItemsSupplyList.size

    class SupplyHolder(inflater:LayoutInflater,parent:ViewGroup)
        :RecyclerView.ViewHolder(inflater.inflate(R.layout.cart_item,parent,false)){


        val name: TextView = itemView.findViewById(R.id.coffee_name)
        val price: TextView = itemView.findViewById(R.id.coffee_price)
        val delButton: Button = itemView.findViewById(R.id.delete_coffee)
    }
}

