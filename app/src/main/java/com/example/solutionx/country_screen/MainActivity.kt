package com.example.solutionx.country_screen

import android.content.Intent
import android.graphics.Typeface
import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.solutionx.utils.Constant.TAG
import com.example.solutionx.filter_screen.FilterActivity
import com.example.solutionx.utils.Logger
import com.example.solutionx.utils.LoggerType
import com.example.solutionx.data.ModelsItem
import com.example.solutionx.R
import com.example.solutionx.adapter.ModelsAdapter
import com.example.solutionx.data.Countries
import com.example.solutionx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countries = listOf(
        ModelsItem.Country(Countries(name = "Egypt")),
        ModelsItem.Country(Countries(name = "Saudi Arabia")),
        ModelsItem.Country(Countries(name = "Emirates")),
        ModelsItem.Country(Countries(name = "Kuwait")),
    )


    @RequiresApi(Build.VERSION_CODES.Q)
    val englishTypeface = Typeface.CustomFallbackBuilder(
        FontFamily.Builder(Font.Builder(resources, R.font.galanogrotesquebold).build()).build()
    ).addCustomFallback(
        FontFamily.Builder(Font.Builder(resources, R.font.galanogrotesquemedium).build()).build()
    ).addCustomFallback(
        FontFamily.Builder(Font.Builder(resources, R.font.galanogrotesqueregular).build()).build()
    ).build()

    @RequiresApi(Build.VERSION_CODES.Q)
    val arabicTypeface = Typeface.CustomFallbackBuilder(
        FontFamily.Builder(Font.Builder(resources, R.font.tajawalbold).build()).build()
    ).addCustomFallback(
        FontFamily.Builder(Font.Builder(resources, R.font.tajawalmedium).build()).build()
    ).addCustomFallback(
        FontFamily.Builder(Font.Builder(resources, R.font.tajawalregular).build()).build()
    ).build()



    private val listAdapter = ModelsAdapter(countries)
    @RequiresApi(Build.VERSION_CODES.Q)
    //private val itemAdapter = ItemListAdapter(countries, arabicTypeface, englishTypeface)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Logger.logState()
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