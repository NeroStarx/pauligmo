package com.nero.starx.hackjunction.pauligmo.ui.meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.pauligmo.R
import com.nero.starx.hackjunction.pauligmo.adapters.MealsAdapter
import com.nero.starx.hackjunction.pauligmo.adapters.SuppliesAdapter
import com.nero.starx.hackjunction.pauligmo.models.Meal
import com.nero.starx.hackjunction.pauligmo.models.Supply

class MealsFragment : Fragment() {

  private lateinit var galleryViewModel: MealsViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    galleryViewModel =
            ViewModelProvider(this).get(MealsViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_meals, container, false)
    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initRecycler(view)
  }

  private fun initRecycler(view: View) {
    val recycler: RecyclerView = view.findViewById(R.id.meal_recycler)
    recycler.setHasFixedSize(false)
    val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
    recycler.layoutManager = manager
    val list = ArrayList<Meal>()
    for(i in 1..10){
      val meal = Meal("Coffee X$i",9 + i, ArrayList())
      list.add(meal)
    }
    val adapter = MealsAdapter(list)
    recycler.adapter = adapter
  }
}