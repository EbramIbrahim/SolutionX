package com.example.solutionx.filter_screen

import android.graphics.Color
import androidx.core.view.isVisible
import com.example.solutionx.ModelShare
import com.example.solutionx.utils.Constant
import com.example.solutionx.adapter.ItemListAdapter
import com.example.solutionx.utils.Logger
import com.example.solutionx.utils.LoggerType
import com.example.solutionx.data.Filter
import com.example.solutionx.databinding.ItemListBinding
import java.util.Locale

class FilterChild(filters: List<Filter>) : ItemListAdapter(filters) {


    override fun onBind(model: ModelShare, binding: ItemListBinding, isSelected: Boolean) {
        binding.tvCountry.text = model.name
        val appLanguage = Locale.getDefault().language
        Logger.log(LoggerType.D(Constant.TAG, appLanguage))

        if (isSelected) {
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