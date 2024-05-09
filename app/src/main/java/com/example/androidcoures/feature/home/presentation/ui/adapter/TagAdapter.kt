package com.example.androidcoures.feature.home.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcoures.databinding.ItemTagBinding
import com.example.androidcoures.feature.home.domain.data.model.TagResponse

class TagAdapter(private val tags: List<TagResponse.Tag>) :
    RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TagResponse.Tag) {
            binding.mainText.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = tags.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = tags[position]
        holder.bindData(data)
    }
}