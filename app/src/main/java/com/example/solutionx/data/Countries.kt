package com.example.solutionx.data

import com.example.solutionx.R

data class Countries(
    val name: String,
    val selectedColor: Int = R.color.selected_color,
    val unSelectedColor: Int = R.color.default_color,
    var isSelected: Boolean = false
)
