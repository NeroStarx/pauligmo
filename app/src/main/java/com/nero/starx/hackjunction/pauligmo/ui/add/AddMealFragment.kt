package com.nero.starx.hackjunction.pauligmo.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nero.starx.hackjunction.pauligmo.R

class AddMealFragment : Fragment() {

  private lateinit var slideshowViewModel: AddMealViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    slideshowViewModel =
            ViewModelProvider(this).get(AddMealViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_addsupply, container, false)
    slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
    })
    return root
  }
}