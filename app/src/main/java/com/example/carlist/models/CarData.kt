package com.example.carlist.models

import java.io.Serializable

data class CarData (
    val id: Int,
    val preco: String,
    val bateria: String,
    val potencia: String,
    val recarga: String,
    val urlPhoto: String
) : Serializable
