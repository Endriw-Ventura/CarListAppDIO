package com.example.carlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carlist.R
import com.example.carlist.models.CarItem

class CarAdapter(private val carsList: MutableList<CarItem>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(view: View) : RecyclerView.ViewHolder(view){
         val price: TextView
         val battery: TextView
         val potency: TextView
         val recharge: TextView
         val carImage: ImageView

        init {
            view.apply {
                price = findViewById(R.id.tv_price_value)
                battery = findViewById(R.id.tv_battery_value)
                potency = findViewById(R.id.tv_potency_value)
                recharge = findViewById(R.id.tv_recharge_value)
                carImage = findViewById(R.id.iv_car_image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.apply {
            price.text = carsList[position].price.toString()
            battery.text = carsList[position].battery.toString()
            potency.text = carsList[position].potency.toString()
            recharge.text = carsList[position].recharge.toString()
        }
    }

    override fun getItemCount(): Int = carsList.size
}

