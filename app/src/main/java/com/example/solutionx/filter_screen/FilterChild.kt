package com.example.solutionx.filter_screen

import android.graphics.Color
import androidx.core.view.isVisible
import com.example.solutionx.utils.Constant
import com.example.solutionx.adapter.ItemListAdapter
import com.example.solutionx.utils.Logger
import com.example.solutionx.utils.LoggerType
import com.example.solutionx.R
import com.example.solutionx.data.Countries
import com.example.solutionx.databinding.ItemListBinding
import java.util.Locale

class FilterChild(private val filters: List<Countries>) : ItemListAdapter(filters) {


    override fun onBind(countries: Countries, binding: ItemListBinding, isSelected: Boolean) {
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
}