package com.example.weather.ui.main

import com.example.weather.ui.main.Weather

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): Weather
}