package com.example.weather.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import com.example.weather.AppState
import com.example.weather.R
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {
    private lateinit var loadingLayout: ProgressBar
    private lateinit var mainView: ConstraintLayout
    private lateinit var cityName: TextView
    private lateinit var cityCoordinates: TextView
    private lateinit var temperatureValue: TextView
    private lateinit var feelsLikeValue: TextView
    private lateinit var viewModel: MainViewModel


    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getWeather()

    }

    private fun renderData(appState: AppState) = when (appState) {
        is AppState.Success -> {
            val weatherData = appState.weatherData
            loadingLayout.visibility = View.GONE
            setData(weatherData)
        }
        is AppState.Loading -> {
            loadingLayout.visibility = View.VISIBLE
        }
        is AppState.Error -> {
            loadingLayout.visibility = View.GONE
            Snackbar
                .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                .setAction("Reload") { viewModel.getWeather() }
                .show()
        }
    }
    private fun setData(weatherData: Weather) {
        cityName.text = weatherData.city.city
        cityCoordinates.text = String.format(
            getString(R.string.city_coordinates),
            weatherData.city.lat.toString(),
            weatherData.city.lon.toString()
        )
        temperatureValue.text = weatherData.temperature.toString()
        feelsLikeValue.text = weatherData.feelsLike.toString()
    }


}

