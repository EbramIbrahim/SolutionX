package com.example.solutionx.filter_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.data.ModelsItem
import com.example.solutionx.adapter.ModelsAdapter
import com.example.solutionx.data.Countries
import com.example.solutionx.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    private val filter = listOf(
        ModelsItem.Country(Countries(name = "Most Popular")),
        ModelsItem.Country(Countries(name = "Most Selling")),
        ModelsItem.Country(Countries(name = "Most Viewed")),
        ModelsItem.Country(Countries(name = "Most Expensive")),
    )
    private val countries2 = listOf(
        Countries(name = "Ebram"),
        Countries(name = "Ibrahim"),
        Countries(name = "Aziz"),
    )
    private val listAdapter = ModelsAdapter(filter)
    private val filterChild = FilterChild(countries2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        binding.rvFilter.apply {
            adapter = filterChild
            layoutManager = LinearLayoutManager(context)
        }
    }
}