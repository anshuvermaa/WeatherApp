package com.example.weather_app.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weather_app.screens.MainScreen
import com.example.weather_app.screens.WeatherSplashScreen
import com.example.weather_app.screens.main.MainViewModel
import com.example.weather_app.screens.search.SearchScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()    // controls to whole navigation ex lets go to screen x
    NavHost(navController=navController,       // all that being driven in nav host   here we pass nav controller it tells how to navigate to x
        startDestination = WeatherScreens.SplashScreen.name){
        composable(WeatherScreens.SplashScreen.name){
            // routes
            WeatherSplashScreen(navController = navController)         // actual screen
        }
        val route=WeatherScreens.MainScreen.name
        composable("${route}/{city}",
        arguments = listOf(
            navArgument( name = "city"){
                type= NavType.StringType
            })){
            navBack->
            navBack.arguments?.getString("city").let { city->

                val mainViewModel= hiltViewModel<MainViewModel>()
                // routes
                MainScreen(navController = navController,
                    mainViewModel,city=city)         // actual screen
            }
        }

        composable(WeatherScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }

    }
}