package com.example.carlist.data.api

import com.example.carlist.models.CarData
import com.example.carlist.models.CarItem
import retrofit2.http.GET

interface CarAPI {
    @GET("digitalinnovationone/cars-api/main/cars.json")
    suspend fun getCarList(): List<CarData>
}