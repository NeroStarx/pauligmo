package com.nero.starx.hackjunction.pauligmo.ui.supplies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.nero.starx.hackjunction.pauligmo.R
import com.nero.starx.hackjunction.pauligmo.adapters.SuppliesAdapter
import com.nero.starx.hackjunction.pauligmo.models.Supply

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
    recycler.setHasFixedSize(false)
    val manager = LinearLayoutManager(requireContext(),VERTICAL,false)
    recycler.layoutManager = manager
    val list = ArrayList<Supply>()
    for(i in 1..13){
      val supply = Supply("Supply num $i","CODE X1726$i","Type$i",i,"7-11-2020")
      list.add(supply)
    }
    val adapter = SuppliesAdapter(list)
    recycler.adapter = adapter
  }
}