package com.example.solutionx.data

import com.example.solutionx.ModelShare

data class Filter(
    val filterName: String,
    var isFilterSelected: Boolean = false
): ModelShare {
    override val name: String
        get() = filterName
    override var isSelected: Boolean = isFilterSelected

}
