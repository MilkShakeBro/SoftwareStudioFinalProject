package com.example.finalprojecttemplate.ui.homepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.HomePageItemLayoutBinding
import com.example.finalprojecttemplate.domain.models.HomePageInfo

class HomePageListAdapter(private val onClickAction: (Int) -> Unit) : ListAdapter<HomePageInfo, HomePageListAdapter.HomePageListItemViewHolder>(
    DiffCallBack
) {
    class HomePageListItemViewHolder(
        private var binding: HomePageItemLayoutBinding,
        private val onClickAction: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: HomePageInfo) {
            binding.apply {
                bindImage(displayImage, item.img)
                displayName.text = item.name
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
        private val DiffCallBack = object : DiffUtil.ItemCallback<HomePageInfo>() {
            override fun areItemsTheSame(oldItem: HomePageInfo, newItem: HomePageInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HomePageInfo, newItem: HomePageInfo): Boolean {
                return oldItem == newItem
            }
        }
    }

}