package com.nero.starx.hackjunction.client.ui.supplies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.client.adapters.CartItemAdapter
import com.nero.starx.hackjunction.client.adapters.MealsAdapter
import com.nero.starx.hackjunction.client.adapters.RecomendationAdapter
import com.nero.starx.hackjunction.client.adapters.StoryAdapter
import com.nero.starx.hackjunction.client.models.Meal
import com.nero.starx.hackjunction.client.models.MealExtended
import com.nero.starx.hackjunction.paulig.client.R

class SupplyFragment : Fragment() {

  private lateinit var homeViewModel: SupplyViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    homeViewModel =
            ViewModelProvider(this).get(SupplyViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_supplies, container, false)
    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initRecycler(view)
  }

  fun initRecycler(v:View){
    val recycler:RecyclerView = v.findViewById(R.id.supply_recycler)
    val recommendRecycler:RecyclerView = v.findViewById(R.id.recycler_recommend)
    recycler.setHasFixedSize(false)
    recommendRecycler.setHasFixedSize(false)
    val manager = LinearLayoutManager(requireContext(), HORIZONTAL,false)
    val verManager = LinearLayoutManager(requireContext(), VERTICAL,false)
    recycler.layoutManager = manager
    recommendRecycler.layoutManager = verManager
    val list = ArrayList<Meal>()
    for(i in 1..5){
      val meal = Meal("Coffee X$i",9 + i, ArrayList())
      list.add(meal)
    }
    val adapter = StoryAdapter(list)
    recycler.adapter = adapter
    recommendRecycler.adapter = RecomendationAdapter(list)
  }
}