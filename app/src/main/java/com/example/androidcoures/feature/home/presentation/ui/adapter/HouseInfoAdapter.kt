package com.example.androidcoures.feature.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcoures.databinding.ItemHouseInfoBinding
import com.example.androidcoures.feature.home.domain.data.model.HouseInfoResponse.HouseInfo

class HouseInfoAdapter(private val houseInfos: List<HouseInfo>) :
    RecyclerView.Adapter<HouseInfoAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemHouseInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(position: Int) {
            binding.textTitle.text = houseInfos[position].text
            binding.countText.text = houseInfos[position].count.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHouseInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = houseInfos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }
}