package com.example.androidcoures.feature.home.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcoures.HouseActivity
import com.example.androidcoures.R
import com.example.androidcoures.databinding.ItemHouseBinding
import com.example.androidcoures.feature.home.domain.data.model.HouseResponse

class HouseAdapter(private val houses: List<HouseResponse.House>) :
    RecyclerView.Adapter<HouseAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: HouseResponse.House) {
            binding.itemImageMain.setImageResource(item.image)
            binding.iconHeartLoveTheHouse.setImageResource(R.drawable.heart)
            binding.itemTextPrice.text = item.price
            binding.itemTextAddress.text = item.address
            binding.itemHouseSubInfo.text = item.subInfo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHouseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = houses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = houses[position]
        holder.bindData(data)

        // todo: maybe need change later
        holder.itemView.setOnClickListener {
            Intent(holder.itemView.context, HouseActivity::class.java).also {
                it.putExtra("house_image", houses[position].image)
                it.putExtra("house_price", houses[position].price)
                it.putExtra("house_address", houses[position].address)
                it.putExtra("house_subInfo", houses[position].subInfo)
                it.putExtra("house_square_foot", houses[position].squareFoot)
                it.putExtra("house_bedrooms", houses[position].bedrooms)
                it.putExtra("house_bathrooms", houses[position].bathrooms)
                it.putExtra("house_toilet", houses[position].toilet)
                it.putExtra("house_garage", houses[position].garage)
                it.putExtra("house_elevator", houses[position].elevator)

                holder.itemView.context.startActivity(it)
            }
        }
    }
}