package com.mountainstore.app.ui.store

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mountainstore.app.R
import com.mountainstore.app.databinding.FragmentStoreBinding
import com.mountainstore.app.ui.home.MainActivity
import kotlin.math.log

class StoreFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentStoreBinding

    private val viewModel: StoreViewModel by lazy { StoreViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreBinding.inflate(inflater, container, false).apply {
            viewModel = this@StoreFragment.viewModel
            lifecycleOwner = this@StoreFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }
    private fun init() {
        binding.recyclerView.adapter = StoreAdapter(parent)
        viewModel.listStore()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listStore()
        }
    }
    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
            binding.swipeRefresh.isRefreshing=it
        }
        viewModel.actionState.observe(viewLifecycleOwner){
            if(it.isConsumed){
                Log.i("ActinState","isConsumed")
            }else if(it.isSuccess){
                Toast.makeText(parent,it.message,Toast.LENGTH_SHORT).show()

            }

        }
    }

}