package com.example.weather_app.repository

import android.util.Log
import com.example.weather_app.data.DataOrException
import com.example.weather_app.model.Weather
import com.example.weather_app.model.WeatherObject
import com.example.weather_app.network.WeatherApi
import javax.inject.Inject

class WeatherRepository  @Inject constructor(private val api: WeatherApi){
    suspend fun getWeather(cityQuery : String)
    : DataOrException<Weather,Boolean,Exception> {
        val response= try{
      api.getWeather(query =cityQuery )
        }catch (e:Exception){
            Log.d("EX", "getWeather: ${e}")
            return  DataOrException(e=e)

        }
        Log.d("INSIDE", "getWeather: ${response}")

        return  DataOrException(data = response)
    }
}