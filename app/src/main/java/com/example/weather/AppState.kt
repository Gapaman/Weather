package com.example.weather

import com.example.weather.ui.main.Weather

sealed class AppState {
    data class Success(val weatherData: List<Weather>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}