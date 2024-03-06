package com.example.solutionx.data

import com.example.solutionx.ModelShare

data class Countries(
    val countryName: String,
    var isSelect: Boolean = false,
    val countryImage: Int
) : ModelShare {
    override val name: String
        get() = countryName

    override var isSelected: Boolean = isSelect

    override val image: Int
        get() = countryImage
}
