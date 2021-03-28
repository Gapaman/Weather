package com.example.weather.ui.main

data class Weather (
    val city: City = getDefaultCity(),
    val temperature: Int=0,
    val feelsLike: Int =0
)
fun getDefaultCity() = City("Москва", 55.755826, 37.61729990000035)
