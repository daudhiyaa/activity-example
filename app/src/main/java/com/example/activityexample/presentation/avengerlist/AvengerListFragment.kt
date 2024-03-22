package com.example.activityexample.presentation.avengerlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.activityexample.R
import com.example.activityexample.data.model.Avenger
import com.example.activityexample.databinding.FragmentAvengerListBinding
import com.example.activityexample.presentation.avengerdetail.AvengerDetailFragment
import com.example.activityexample.presentation.avengerlist.adapter.AvengersAdapter
import com.example.activityexample.presentation.avengerlist.adapter.OnItemClickedListener

class AvengerListFragment : Fragment() {
    private lateinit var binding: FragmentAvengerListBinding
    private var adapter: AvengersAdapter? = null

    // Init ViewModel
    private val viewModel: AvengerListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAvengerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeGridMode()
        setClickAction()
    }

    private fun observeGridMode() {
        viewModel.isUsingGridMode.observe(viewLifecycleOwner) { isUsingGridMode ->
            bindAvengerList(isUsingGridMode)
            setButtonText(isUsingGridMode)
        }
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            viewModel.changeListMode()
        }
    }

    private fun setButtonText(isUsingGridMode: Boolean) {
        binding.btnChangeListMode.text = if (isUsingGridMode) "List Mode" else "Grid Mode"
    }

    private fun bindAvengerList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) AvengersAdapter.MODE_GRID else AvengersAdapter.MODE_LIST
        adapter =
            AvengersAdapter(
                listMode = listMode,
                listener = object : OnItemClickedListener<Avenger> {
                    override fun onItemClicked(item: Avenger) {
                        navigateToDetail(item)
                    }
                },
            )
        binding.rvAvengerList.apply {
            adapter = this@AvengerListFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(viewModel.getAvengerList())
    }

    private fun navigateToDetail(item: Avenger) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(AvengerDetailFragment.EXTRAS_ITEM, item))
        navController.navigate(R.id.action_avengerListFragment_to_avengerDetailFragment, bundle)
    }
}