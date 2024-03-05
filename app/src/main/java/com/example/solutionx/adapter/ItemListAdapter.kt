package com.example.solutionx.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.R
import com.example.solutionx.data.Countries
import com.example.solutionx.databinding.ItemListBinding
import com.example.solutionx.utils.Constant
import com.example.solutionx.utils.Logger
import com.example.solutionx.utils.LoggerType
import java.util.Locale

open class ItemListAdapter(private val countries: List<Countries>) :
    RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    private var selectedItem = RecyclerView.NO_POSITION

    inner class ItemViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(countries: Countries, position: Int) {
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

    // I can Inherit this method and apply different models with same layout
    open fun onBind(countries: Countries, binding: ItemListBinding, isSelected: Boolean) {
        binding.tvCountry.text = countries.name
        val appLanguage = Locale.getDefault().language
        Logger.log(LoggerType.D(Constant.TAG, appLanguage))

        if (appLanguage == "English"){
            binding.tvCountry.setTextAppearance(R.style.english_font_style)
        } else {
            binding.tvCountry.setTextAppearance(R.style.arabic_font_style)
        }

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

    //notify the adapter with current and previous selected item
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