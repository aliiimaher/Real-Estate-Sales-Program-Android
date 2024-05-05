package com.example.androidcoures

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcoures.databinding.ActivityHouseBinding
import com.example.androidcoures.feature.home.domain.data.model.HouseInfo
import com.example.androidcoures.feature.home.presentation.ui.adapter.HouseInfoAdapter

class HouseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHouseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHouseBinding.inflate(layoutInflater)
        setContentView(binding.root)

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


        binding.iconBackToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).also {
                it.putExtra("item1", houseInfoList.size.toString())
                startActivity(it)
            }
        }

//        val price: String = intent.extras?.getString("price") ?: "null"

//        binding.textPrice.text = price.toString()

        val image: Int? = intent.extras?.getInt("house_image")
        val price: String? = intent.extras?.getString("house_price")
        val address: String? = intent.extras?.getString("house_address")
//        val subInfo: String? = intent.extras?.getString("house_subInfo")

        if (image != null) {
            binding.itemImageMain.setImageResource(image)
        }

        if (price != null) {
            binding.textPrice.text = price.toString()
        }

        if (address != null) {
            binding.textAddress.text = address.toString()
        }

//        if (subInfo != null) {
//            binding.
//        }


    }
}