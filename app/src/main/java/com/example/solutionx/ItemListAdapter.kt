package com.example.solutionx

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.data.Countries
import com.example.solutionx.databinding.ItemListBinding

open class ItemListAdapter(val countries: List<Countries>) :
    RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    private var selectedItem = RecyclerView.NO_POSITION

    inner class ItemViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(countries: Countries, position: Int) {
            binding.tvCountry.text = countries.name
            countries.isSelected = position == selectedItem
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    selectItem(adapterPosition)
                }
            }
            onBind(countries, binding, countries.isSelected)

        }

    }


    open override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(countries[position], position)
    }

    open fun onBind(countries: Countries, binding: ItemListBinding, isSelected: Boolean) {
        if (isSelected) {
            binding.tvCountry.setTextColor(Color.BLUE)
            binding.checkMark.isVisible = true
            binding.itemList.setBackgroundColor(Color.LTGRAY)
        } else {
            binding.tvCountry.setTextColor(Color.BLACK)
            binding.checkMark.isVisible = false
            binding.itemList.setBackgroundColor(Color.WHITE)
        }
    }

    private fun selectItem(position: Int) {
        val previousSelectedPosition = selectedItem
        selectedItem = position
        notifyItemChanged(previousSelectedPosition)
        notifyItemChanged(selectedItem)
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}