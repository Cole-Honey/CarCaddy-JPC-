package com.example.carcaddy.screens.navigation

sealed class Directions(
    val path: String
) {
    data object SplashScreen: Directions("splash_screen")
    data object MyGarage: Directions("my_garage")
    data object FetchVin: Directions("fetch_vin")
    data object TabBar: Directions("tab_bar")
    data object LogDetail: Directions("log_detail")
    data object CheckOil: Directions("check_oil")
    data object ChangeOil: Directions("change_oil")
    data object CheckBrakes: Directions("check_brakes")
    data object ChangeBrakes: Directions("change_brakes")
    data object CheckTires: Directions("check_tires")
    data object ChangeTires: Directions("change_tires")
    data object CheckBattery: Directions("check_battery")
    data object ChangeBattery: Directions("change_battery")
    data object CheckTransmissionFluid: Directions("check_transmission_fluid")
    data object ChangeTransmissionFluid: Directions("change_transmission_fluid")
}