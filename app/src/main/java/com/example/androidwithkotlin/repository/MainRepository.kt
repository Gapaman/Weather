package com.example.androidwithkotlin.repository

import com.example.androidwithkotlin.model.Weather

interface MainRepository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>
}
