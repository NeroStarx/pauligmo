package com.nero.starx.hackjunction.client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.client.models.Supply
import com.nero.starx.hackjunction.paulig.client.R

class SuppliesAdapter(private val supplyList:ArrayList<Supply>)
    :RecyclerView.Adapter<SuppliesAdapter.SupplyHolder>() {

    private var ItemsSupplyList = ArrayList<Supply>()
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
        holder.code.text = item.code
        holder.quantity.text = "Quantity: ${item.quantity}"
        holder.date.text = "Date added: ${item.date}"

    }

    override fun getItemCount(): Int = ItemsSupplyList.size

    class SupplyHolder(inflater:LayoutInflater,parent:ViewGroup)
        :RecyclerView.ViewHolder(inflater.inflate(R.layout.supply_item,parent,false)){


        val name: TextView = itemView.findViewById(R.id.supply_name)
        val code: TextView = itemView.findViewById(R.id.supply_code)
        val quantity: TextView = itemView.findViewById(R.id.supply_quantity)
        val date: TextView = itemView.findViewById(R.id.supply_date)
    }
}

