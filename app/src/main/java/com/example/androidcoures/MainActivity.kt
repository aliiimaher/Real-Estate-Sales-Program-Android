package com.example.androidcoures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcoures.databinding.HouseRecyclerViewBinding
import com.example.androidcoures.feature.home.domain.data.model.Tag
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
        initialBinding()
        initialViewModel()
        configViewModel()
    }
    //endregion

    //region methods
    private fun initialBinding() {
        binding = HouseRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        viewModel = ViewModelProvider(this, HouseViewModelFactory())[HomeViewModel::class.java]
        viewModel.fetchAllHouses()
    }

    private fun configViewModel() {
        viewModel.houses.observe(this) { houses ->
            val adapter = HouseAdapter(houses)
            binding.recyclerMain.adapter = adapter
            binding.recyclerMain.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }

//        val houseList = arrayListOf(
//            House(R.drawable.house1, "200.000", "Shiraz, Eram", "4 bedrooms"),
//            House(R.drawable.house2, "200.000", "Shiraz, Eram", "4 bedrooms"),
//            House(R.drawable.house3, "200.000", "Shiraz, Eram", "4 bedrooms"),
//            House(R.drawable.house4, "200.000", "Shiraz, Eram", "4 bedrooms")
//        )

        //        here
//    val testHouseList = HomeRepository().fetchAllHouses()
//        here end

//        val houseAdapter = HouseAdapter(houseList)
//        binding.recyclerMain.adapter = houseAdapter
//        binding.recyclerMain.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val tagList = arrayListOf(
            Tag("200.000"),
            Tag("test1"),
            Tag("test2"),
            Tag("test3"),
        )

        val tagAdapter = TagAdapter(tagList)
        binding.recyclerTags.adapter = tagAdapter
        binding.recyclerTags.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.iconMenu.setOnClickListener()
        {
            Intent(this, HouseActivity::class.java).also {
                startActivity(it)
            }
        }

//        binding.recyclerMain.setOnClickListener()
//        {
//            val intent = Intent(this, HouseActivity::class.java).also {
//                it.putExtra("price", houseList[0].price)
//            }
//        }

        val test: String = intent.extras?.getString("item1") ?: "shit!"

        binding.textCity.text = test
    }
    //endregion
}