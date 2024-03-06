package com.example.solutionx.filter_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.data.Filter
import com.example.solutionx.databinding.ActivityFilterBinding

class FilterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    private val filter = listOf(
        Filter(filterName = "Most Visit"),
        Filter(filterName = "Most Visit"),
        Filter(filterName = "Most Visit"),
        Filter(filterName = "Most Visit")
    )

    private val filterChild = FilterChild(filter)

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