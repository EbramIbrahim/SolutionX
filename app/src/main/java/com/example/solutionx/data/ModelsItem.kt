package com.example.solutionx.data

sealed class ModelsItem {

    data class Country(val countries: Countries): ModelsItem()
    data class Filter(val countries: Countries): ModelsItem()
}
