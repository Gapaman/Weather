package com.example.androidwithkotlin.repository

import com.example.androidwithkotlin.model.Weather
import com.example.androidwithkotlin.room.HistoryDao
import com.example.androidwithkotlin.utils.convertHistoryEntityToWeather
import com.example.androidwithkotlin.utils.convertWeatherToEntity

class LocalRepositoryImpl(private val localDataSource: HistoryDao) :
    LocalRepository {

    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        localDataSource.insert(convertWeatherToEntity(weather))
    }
}
