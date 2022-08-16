package com.wenger.natifetesttask.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wenger.natifetesttask.R
import com.wenger.natifetesttask.model.GifResponse

class GifsAdapter(
    private val clickListener: IOnGifsClickListener
) : ListAdapter<GifResponse, GifsAdapter.MyViewHolder>(GifsDiffCallback()) {

    class GifsDiffCallback : DiffUtil.ItemCallback<GifResponse>() {
        override fun areItemsTheSame(oldItem: GifResponse, newItem: GifResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GifResponse, newItem: GifResponse): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
        return MyViewHolder(itemView, clickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class MyViewHolder(
        itemView: View,
        private val clickListener: IOnGifsClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        private val gif: ImageView = itemView.findViewById(R.id.gif)

        fun onBind(currentItem: GifResponse) {
            Glide.with(itemView.context)
                .asGif()
                .load(currentItem.images.fixedHeight.url)
                .into(gif)

            itemView.setOnClickListener {
                clickListener.onGifsClick(currentItem.images.original.url)
            }
        }
    }
}