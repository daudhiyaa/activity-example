package com.example.activityexample.feature.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.activityexample.R
import com.example.activityexample.databinding.FragmentHomeBinding
import com.example.activityexample.feature.detail.DetailActivity
import com.example.activityexample.model.Person

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickAction()
    }

    private fun setClickAction() {
       binding.btnProfile.setOnClickListener {
           navigateToProfile()
       }
   }

    private fun navigateToProfile() {
        DetailActivity.startActivity(
            requireContext(),
            Person(
                "Your Name",
                "Software Engineer",
                "Lorem ipsum dolor sir amet",
                R.drawable.ic_profile
            )
        )
    }
}