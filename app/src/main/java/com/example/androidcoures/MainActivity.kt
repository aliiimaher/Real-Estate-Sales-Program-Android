package com.example.androidcoures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcoures.databinding.HouseRecyclerViewBinding
import com.example.androidcoures.feature.home.presentation.ui.adapter.HouseAdapter
import com.example.androidcoures.feature.home.presentation.ui.adapter.TagAdapter
import com.example.androidcoures.feature.home.presentation.ui.viewmodel.HomeViewModel
import com.example.androidcoures.feature.home.presentation.ui.viewmodel.HouseViewModelFactory

class MainActivity : AppCompatActivity() {

    //region properties
    private lateinit var binding: HouseRecyclerViewBinding
    private lateinit var viewModel: HomeViewModel
    //endregion

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        removeHeader()
        initialBinding()
        initialViewModel()
        configViewModel()
    }
    //endregion

    //region methods
    private fun removeHeader() {
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar()?.hide();
    }

    private fun initialBinding() {
        binding = HouseRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        viewModel = ViewModelProvider(this, HouseViewModelFactory())[HomeViewModel::class.java]
        viewModel.fetchAllHouses()
        viewModel.fetchAllTags()

//        tagViewModel = ViewModelProvider(this, TagViewModelFactory())[TagViewModel::class.java]
//        tagViewModel.fetchAllTags()
    }

    private fun configViewModel() {
        viewModel.houses.observe(this) { houses ->
            val adapter = HouseAdapter(houses)
            binding.recyclerMain.adapter = adapter
            binding.recyclerMain.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.tags.observe(this) { tags ->
            val adapter = TagAdapter(tags)
            binding.recyclerTags.adapter = adapter
            binding.recyclerTags.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }
    }
    //endregion
}