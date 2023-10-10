package com.example.carcaddy.screens.navigation

sealed class Directions(
    val path: String
) {
    data object SplashScreen: Directions("splash_screen")
    data object VehicleDetails: Directions("vehicle_details")
    data object MyGarage: Directions("my_garage")
    data object FetchVin: Directions("fetch_vin")
    data object GoogleMaps: Directions("google_maps")
    data object Maintenance: Directions("maintenance")
}