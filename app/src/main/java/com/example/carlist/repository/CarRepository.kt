package com.example.carlist.repository

import com.example.carlist.data.api.CarAPI
import com.example.carlist.models.CarData
import com.example.carlist.models.CarItem
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CarRepository @Inject constructor(
    private val api: CarAPI
) {

    suspend fun getCarList() : MutableList<CarItem>{
        val cars = emptyList<CarItem>().toMutableList()
        val response = try {
            api.getCarList()
        } catch (e: Exception) {
            emptyList<CarData>().toMutableList()
        }

        for (data in response){
            val car = CarItem(
                data.id,
                data.preco,
                data.bateria,
                data.potencia,
                data.recarga,
                data.urlPhoto,
            )
            cars.add(car)
        }
        return cars
    }
}