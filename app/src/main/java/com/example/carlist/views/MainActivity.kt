package com.example.carlist.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.carlist.R
import com.example.carlist.adapters.CarAdapter
import com.example.carlist.models.CarItem

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
        setAdapter()

    }

    private fun setViews() {
       //btnAdd = findViewById(R.id.btnAdd)
        recyclerView = findViewById(R.id.rv_cars_list)
    }

    private fun setAdapter() {
        val cars = listOf(
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
            CarItem(Math.random().toInt(), Math.random(), Math.random(), Math.random(), Math.random(),""),
        )

        val adapter = CarAdapter(cars.toMutableList())
        recyclerView.adapter = adapter
    }
}