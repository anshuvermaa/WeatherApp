package com.example.weather_app.network

import com.example.weather_app.model.Weather
import com.example.weather_app.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
//    https://api.openweathermap.org/data/2.5/forecast?q=lucknow&appid=73775abd92f45feb6ed14f0b8fe932dc&units=metric&&cnt=7
    @GET(value="data/2.5/forecast")
    suspend fun  getWeather(
    @Query("q") query: String,
    @Query("units") units:String ="imperial",
    @Query("appid") appid: String =Constants.API_KEY,
    @Query("cnt") cnt : String="7",

    ): Weather
}