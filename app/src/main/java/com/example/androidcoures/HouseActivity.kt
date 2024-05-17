package com.example.androidcoures

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcoures.databinding.ActivityHouseBinding
import com.example.androidcoures.feature.home.presentation.ui.adapter.HouseInfoAdapter
import com.example.androidcoures.feature.home.presentation.ui.viewmodel.*

class HouseActivity : AppCompatActivity() {

    //region properties
    private lateinit var binding: ActivityHouseBinding
    private lateinit var viewModel: HouseInfoViewModel
    //endregion

    //region lifeCycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        removeHeader()
        initialBinding()
        initialViewModel()
        configViewModel()
        configBtnAction()
/*
        val houseInfoList = arrayListOf(
            HouseInfo("Square foot", 500),
            HouseInfo("Bedrooms", 4),
            HouseInfo("Bathrooms", 2),
            HouseInfo("Toilet", 1),
            HouseInfo("Garage", 2),
            HouseInfo("Elevator", 1),
        )

        val houseInfoAdapter = HouseInfoAdapter(houseInfoList)
        binding.recyclerHouseInfo.adapter = houseInfoAdapter
        binding.recyclerHouseInfo.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
 */
    }
    //endregion

    //region methods
    private fun removeHeader() {
        window.decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar()?.hide();
    }

    @SuppressLint("SetTextI18n")
    private fun initialBinding() {
        binding = ActivityHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image: Int? = intent.extras?.getInt("house_image")
        val price: String? = intent.extras?.getString("house_price")
        val address: String? = intent.extras?.getString("house_address")
//        val subInfo: String? = intent.extras?.getString("house_subInfo")
//        val squareFoot: Int? = intent.extras?.getInt("house_square_foot")
//        val bedrooms: Int? = intent.extras?.getInt("house_bedrooms")
//        val bathrooms: Int? = intent.extras?.getInt("house_bathrooms")
//        val toilet: Int? = intent.extras?.getInt("house_toilet")
//        val garage: Int? = intent.extras?.getInt("house_garage")
//        val elevator: Int? = intent.extras?.getInt("house_elevator")

        if (image != null) {
            binding.itemImageMain.setImageResource(image)
        }

        if (price != null) {
            binding.textPrice.text = price.toString()
        }

        if (address != null) {
            binding.textAddress.text = address.toString()
        }

        binding.textHouseFullDescription.text =
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                    " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                    "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                    "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old." +
                    " Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source." +
                    " Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32."
    }

    private fun initialViewModel() {
        viewModel =
            ViewModelProvider(this, HouseInfoViewModelFactory())[HouseInfoViewModel::class.java]
        viewModel.fetchAllHouseInfo()
    }

    private fun configViewModel() {
        viewModel.houseInfo.observe(this) { houseInfo ->
            val adapter = HouseInfoAdapter(houseInfo)
            binding.recyclerHouseInfo.adapter = adapter
            binding.recyclerHouseInfo.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun configBtnAction() {
        binding.iconBackToMain.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    //endregion
}