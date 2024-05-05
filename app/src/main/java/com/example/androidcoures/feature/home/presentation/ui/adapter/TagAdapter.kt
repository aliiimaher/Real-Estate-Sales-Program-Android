package com.example.androidcoures.feature.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcoures.databinding.ItemTagBinding

class TagAdapter(private val tags: ArrayList<com.example.androidcoures.feature.home.domain.data.model.Tag>) :
    RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(position: Int) {
            binding.mainText.text = tags[position].text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false)
//        return ViewHolder(view)
        val view = ItemTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = tags.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = tags[position]
//        holder.bindData(item)
        holder.bindData(position)
    }
}