package com.example.solutionx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.Constant.TAG
import com.example.solutionx.data.Countries
import com.example.solutionx.databinding.ActivityMainBinding
import java.util.Locale
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countries2 = listOf(
        Countries(name = "Egypt"),
        Countries(name = "Saudi Arabia"),
        Countries(name = "Emirates"),
        Countries(name = "Kuwait")
    )
    private val listAdapter = ItemListAdapter(countries2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Logger.logState()
        setUpRecyclerView()
//        Log.d(TAG, getString(R.string.egypt))
//        Log.d(TAG, getString(R.string.saudiarabia))
//        Log.d(TAG, getString(R.string.emirates))
//        Log.d(TAG, getString(R.string.kuwait))


        Logger.log(LoggerType.D(TAG, getString(R.string.egypt)))
        Logger.log(LoggerType.D(TAG, getString(R.string.saudiarabia)))
        Logger.log(LoggerType.D(TAG, getString(R.string.emirates)))
        Logger.log(LoggerType.D(TAG, getString(R.string.kuwait)))
        Logger.logToFile("AHHHHHHHHHHHHHHHHHHHH")
    }

    private fun setUpRecyclerView() {
        binding.rvItems.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }


}