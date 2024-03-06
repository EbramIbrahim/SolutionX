package com.example.solutionx.country_screen

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.utils.Constant.TAG
import com.example.solutionx.filter_screen.FilterActivity
import com.example.solutionx.utils.Logger
import com.example.solutionx.utils.LoggerType
import com.example.solutionx.R
import com.example.solutionx.adapter.ItemListAdapter
import com.example.solutionx.data.Countries
import com.example.solutionx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countries = listOf(
        Countries(countryName = "Egypt", countryImage = R.drawable.egypt),
       Countries(countryName = "Saudi Arabia", countryImage = R.drawable.saudiarabia),
        Countries(countryName = "Emirates", countryImage = R.drawable.unitedarabemirates),
        Countries(countryName = "Kuwait", countryImage = R.drawable.kuwait)
    )

    private val listAdapter = ItemListAdapter(countries)
    @RequiresApi(Build.VERSION_CODES.Q)
    //private val itemAdapter = ItemListAdapter(countries, arabicTypeface, englishTypeface)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        binding.filterBtn.setOnClickListener {
            val intent = Intent(this, FilterActivity::class.java)
            startActivity(intent)
        }


        Logger.log(LoggerType.D(TAG, getString(R.string.egypt)))
        Logger.log(LoggerType.D(TAG, getString(R.string.saudiarabia)))
        Logger.log(LoggerType.D(TAG, getString(R.string.emirates)))
        Logger.log(LoggerType.D(TAG, getString(R.string.kuwait)))
    }

    private fun setUpRecyclerView() {
        binding.rvItems.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }


}