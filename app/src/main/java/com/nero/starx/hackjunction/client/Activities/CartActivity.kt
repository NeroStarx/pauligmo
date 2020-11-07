package com.nero.starx.hackjunction.client.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.client.adapters.CartItemAdapter
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.paulig.client.R
import java.util.Calendar.SHORT

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_PAULIGMO)
        setContentView(R.layout.activity_cart)

        val background = ResourcesCompat.getDrawable(resources,
            R.drawable.background, theme)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setBackgroundDrawable(background)

        val button: Button = findViewById(R.id.finish_button)
        button.setOnClickListener {
            finish()
        }

        initRecycler()


    }

    private fun initRecycler() {
        val recycler:RecyclerView = findViewById(R.id.cart_recycler)
        recycler.setHasFixedSize(false)
        val manager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
        recycler.layoutManager = manager
        val list = ArrayList<Meal>()
        for(i in 1..8){
            val meal = Meal("Coffee X$i",i+9,ArrayList())
            list.add(meal)
        }
        val adapter = CartItemAdapter(list)
        recycler.adapter = adapter
        val button2:Button = findViewById(R.id.delete_all)
        button2.setOnClickListener {
            adapter.ItemsSupplyList.clear()
            adapter.notifyDataSetChanged()
            Toast.makeText(applicationContext,"All selection deleted", LENGTH_SHORT).show()
        }
    }
}