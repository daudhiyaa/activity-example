package com.example.activityexample.presentation.avengerdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activityexample.data.model.Avenger
import com.example.activityexample.databinding.FragmentAvengerDetailBinding

class AvengerDetailFragment : Fragment() {
    private lateinit var binding: FragmentAvengerDetailBinding

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentData()
    }

    private fun getArgumentData() {
        val item = arguments?.getParcelable<Avenger>(EXTRAS_ITEM)
        binding.tvName.text = item?.name
        binding.tvDesc.text = item?.profileDesc
        binding.tvAvengerPower.text = item?.power
    }
}