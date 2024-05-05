package com.example.androidcoures.feature.home.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcoures.HouseActivity
import com.example.androidcoures.R
import com.example.androidcoures.databinding.ItemHouseBinding
import com.example.androidcoures.feature.home.domain.data.model.HouseResponse.House

class HouseAdapter(private val houses: ArrayList<House>) :
    RecyclerView.Adapter<HouseAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        init {
//            binding.root.setOnClickListener {
//                val intent = Intent(this, HouseActivity::class.java)
//                intent.putExtra("house_object", houses[adapterPosition].image)
//                context.startActivity(intent)
//            }
//        }

        fun bindData(position: Int) {
            binding.itemImageMain.setImageResource(houses[position].image)
            binding.iconHeartLoveTheHouse.setImageResource(R.drawable.heart)
            binding.itemTextPrice.text = houses[position].price
            binding.itemTextAddress.text = houses[position].address
            binding.itemHouseSubInfo.text = houses[position].subInfo
            //            binding.root.setOnClickListener {}
//            binding.root.setOnClickListener(View.OnClickListener {
//                override fun onClick(v: View) {
//                    val intent = Intent(series.getApplicationContext(), HouseActivity::class.java);
//                    String url = response.get(position).getUrl();
//                    Bundle bundle = new Bundle();
//                    bundle.putString(&quot;key_1&quot;,url);
//                    intent.putExtras(bundle);
//                    mContext.startActivity(intent);
//                }
//            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemHouseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = houses.size

    //        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            holder.bindData(position)
//        }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)

        // todo: maybe need change later
        holder.itemView.setOnClickListener {
            Intent(holder.itemView.context, HouseActivity::class.java).also {
                it.putExtra("house_image", houses[position].image)
                it.putExtra("house_price", houses[position].price)
                it.putExtra("house_address", houses[position].address)
                it.putExtra("house_subInfo", houses[position].subInfo)

                holder.itemView.context.startActivity(it)
            }
        }
    }
}