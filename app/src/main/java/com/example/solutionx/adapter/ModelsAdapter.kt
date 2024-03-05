package com.example.solutionx.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.solutionx.utils.Constant
import com.example.solutionx.utils.Logger
import com.example.solutionx.utils.LoggerType
import com.example.solutionx.data.ModelsItem
import com.example.solutionx.R
import com.example.solutionx.databinding.ItemListBinding
import java.util.Locale

class ModelsAdapter(
    private val items: List<ModelsItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var selectedItem = RecyclerView.NO_POSITION

    inner class CountriesViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ModelsItem.Country, position: Int) {
            item.countries.isSelected = position == selectedItem
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    selectItem(adapterPosition)
                }
            }
            binding.tvCountry.text = item.countries.name
            val appLanguage = Locale.getDefault().language
            Logger.log(LoggerType.D(Constant.TAG, appLanguage))

            if (appLanguage == "English") {
                binding.tvCountry.setTextAppearance(R.style.english_font_style)
            } else {
                binding.tvCountry.setTextAppearance(R.style.arabic_font_style)
            }

            if (item.countries.isSelected) {
                binding.tvCountry.setTextColor(Color.BLUE)
                binding.checkMark.isVisible = true
                binding.itemList.setBackgroundColor(Color.LTGRAY)
            } else {
                binding.tvCountry.setTextColor(Color.BLACK)
                binding.checkMark.isVisible = false
                binding.itemList.setBackgroundColor(Color.WHITE)
            }
        }
    }

    inner class FilterViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ModelsItem.Filter, position: Int) {
            item.countries.isSelected = position == selectedItem
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    selectItem(adapterPosition)
                }
            }
            binding.tvCountry.text = item.countries.name
            val appLanguage = Locale.getDefault().language
            Logger.log(LoggerType.D(Constant.TAG, appLanguage))

            if (appLanguage == "English") {
                binding.tvCountry.setTextAppearance(R.style.english_font_style)
            } else {
                binding.tvCountry.setTextAppearance(R.style.arabic_font_style)
            }

            if (item.countries.isSelected) {
                binding.tvCountry.setTextColor(Color.GREEN)
                binding.checkMark.isVisible = true
                binding.itemList.setBackgroundColor(Color.LTGRAY)
            } else {
                binding.tvCountry.setTextColor(Color.BLACK)
                binding.checkMark.isVisible = false
                binding.itemList.setBackgroundColor(Color.WHITE)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ModelsItem.Country -> 0
            is ModelsItem.Filter -> 1
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> CountriesViewHolder(
                ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            1 -> FilterViewHolder(
                ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalAccessException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(val item = items[position]) {
            is ModelsItem.Country -> (holder as CountriesViewHolder).bind(item, position)
            is ModelsItem.Filter -> (holder as FilterViewHolder).bind(item, position)

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    private fun selectItem(position: Int) {
        val previousSelectedPosition = selectedItem
        selectedItem = position
        notifyItemChanged(previousSelectedPosition)
        notifyItemChanged(selectedItem)
    }
}