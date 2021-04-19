package com.example.androidwithkotlin.repository

import com.example.androidwithkotlin.model.Weather

interface LocalRepository {
    fun getAllHistory(): List<Weather>
    fun saveEntity(weather: Weather)
}
