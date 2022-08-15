package com.wenger.natifetesttask.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.wenger.natifetesttask.R
import com.wenger.natifetesttask.model.GifResponse

class GifsAdapter(
    private val clickListener: IOnGifsClickListener
) : RecyclerView.Adapter<GifsAdapter.MyViewHolder>() {

    private val data = mutableListOf<GifResponse>()

    fun addRandomGifs(newRandomGifs: List<GifResponse>) {
        data.addAll(newRandomGifs)
        notifyItemRangeInserted(data.size + 1, newRandomGifs.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
        return MyViewHolder(itemView, clickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = data[position]
        holder.onBind(data)
    }

    override fun getItemCount(): Int = data.size


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