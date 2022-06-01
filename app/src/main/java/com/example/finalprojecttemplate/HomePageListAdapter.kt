package com.example.finalprojecttemplate

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojecttemplate.databinding.HomePageItemLayoutBinding

class HomePageListAdapter(private val onClickAction: (Int) -> Unit) : ListAdapter<HomePageListItem, HomePageListAdapter.HomePageListItemViewHolder>(
    DiffCallBack
) {
    class HomePageListItemViewHolder(
        private var binding: HomePageItemLayoutBinding,
        private val onClickAction: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: HomePageListItem) {
            binding.apply {
                displayImage.setImageBitmap(item.displayedImage)
                displayName.text = item.displayedName
                displayItemLinearLayout.setOnClickListener {
                    onClickAction(item.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePageListItemViewHolder {
        val binding = HomePageItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return HomePageListItemViewHolder(binding, onClickAction)
    }

    override fun onBindViewHolder(holder: HomePageListItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindItem(currentItem)
    }

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<HomePageListItem>() {
            override fun areItemsTheSame(oldItem: HomePageListItem, newItem: HomePageListItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HomePageListItem, newItem: HomePageListItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}