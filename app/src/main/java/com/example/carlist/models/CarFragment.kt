package com.example.carlist.models

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.carlist.R
import com.example.carlist.adapters.CarAdapter
import com.example.carlist.modules.AppModule.AppModule.provideCarAPI
import com.example.carlist.modules.AppModule.AppModule.provideCarRepository
import com.example.carlist.views.FormActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CarFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd: FloatingActionButton
    private var job: Job = Job()
    private val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViews(view)
        setAdapter()
        setListeners()
    }

    private fun setViews(view: View) {
        view.let {
            btnAdd = it.findViewById(R.id.btn_add_item)
            recyclerView = it.findViewById(R.id.rv_cars_list)
        }
    }

    private fun setListeners(){
        btnAdd.setOnClickListener {
            activity?.let{
                val intent = Intent (it, FormActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    private fun setAdapter() {
        val api = provideCarAPI()
        val repository = provideCarRepository(api)

        activity.let {
            lifecycleScope.launch(coroutineContext) {
                val cars = repository.getCarList()
                val adapter = CarAdapter(cars)
                recyclerView.adapter = adapter
            }
        }
    }
}