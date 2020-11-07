package com.nero.starx.hackjunction.client.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.client.adapters.MessageAdapter
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.paulig.client.R

class CoffeeSection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee_section)

        initRecycler()
    }

    private fun initRecycler() {
        val recycler:RecyclerView = findViewById(R.id.review_recycler)
        recycler.setHasFixedSize(false)
        val manager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
        recycler.layoutManager = manager
        val list = ArrayList<Meal>()
        for(i in 1..9){
            val meal = Meal("Coffee X$i",i+9,ArrayList())
            list.add(meal)
        }
        recycler.adapter = MessageAdapter(list)
    }

    fun finishAct(v: View){
        finish()
    }

    fun addToCart(v: View){
        Toast.makeText(this,"Added to cart successfully.",LENGTH_SHORT).show()
    }
}