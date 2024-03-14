package com.example.activityexample.presentation.avengerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.activityexample.databinding.FragmentAvengerListBinding

class AvengerListFragment : Fragment() {
    private lateinit var binding: FragmentAvengerListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengerListBinding.inflate(inflater, container, false)
        return binding.root
    }
}