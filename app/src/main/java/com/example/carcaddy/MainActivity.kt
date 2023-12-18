package com.example.carcaddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.carcaddy.screens.fetch_vin.FetchVinScreen
import com.example.carcaddy.screens.how_to.ChangeBattery
import com.example.carcaddy.screens.how_to.ChangeBrakes
import com.example.carcaddy.screens.how_to.ChangeOil
import com.example.carcaddy.screens.how_to.ChangeTires
import com.example.carcaddy.screens.how_to.ChangeTransmissionFluid
import com.example.carcaddy.screens.how_to.CheckBattery
import com.example.carcaddy.screens.how_to.CheckBrakes
import com.example.carcaddy.screens.how_to.CheckOil
import com.example.carcaddy.screens.how_to.CheckTires
import com.example.carcaddy.screens.how_to.CheckTransmissionFluid
import com.example.carcaddy.screens.log_detail.LogDetailScreen
import com.example.carcaddy.screens.my_garage.MyGarageScreen
import com.example.carcaddy.screens.navigation.Directions
import com.example.carcaddy.screens.splash_screen.SplashScreen
import com.example.carcaddy.screens.tab_bar.TabBarScreen
import com.example.carcaddy.ui.theme.CarCaddyTheme
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import com.google.gson.Gson

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarCaddyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    SetUpNavGraph(
                        navController = navController,
                        activity = this
                        )
                }
            }
        }
    }
}

@Composable
fun SetUpNavGraph(
    activity: ComponentActivity,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Directions.SplashScreen.path
    ) {

        composable(Directions.SplashScreen.path) {
            SplashScreen(navController = navController)
        }

        composable(Directions.MyGarage.path) {
            MyGarageScreen(navController = navController)
        }

        composable(Directions.FetchVin.path) {
            FetchVinScreen(navController = navController)
        }

        composable(
            route = Directions.TabBar.path + "/{vin}",
            arguments = listOf(
                navArgument(name = "vin") { type = NavType.StringType }
                )
        ) {

            TabBarScreen(
                vin = it.arguments?.getString("vin")
                    ?: throw Exception("Expected VIN but didn't get it"),
                activity = activity,
                navController = navController
            )
        }

        composable(
            route = Directions.LogDetail.path + "/{logId}",
            arguments = listOf(
                navArgument(name = "logId") { type = NavType.StringType }
            )
        ) {
            LogDetailScreen(
                log = it.arguments?.getString("logId")
                    ?: throw Exception("Expected LogId but didn't get it")
            )
        }

        composable(Directions.CheckOil.path) {
            CheckOil()
        }

        composable(Directions.ChangeOil.path) {
            ChangeOil()
        }

        composable(Directions.CheckBrakes.path) {
            CheckBrakes()
        }

        composable(Directions.ChangeBrakes.path) {
            ChangeBrakes()
        }

        composable(Directions.CheckTires.path) {
            CheckTires()
        }

        composable(Directions.ChangeTires.path) {
            ChangeTires()
        }

        composable(Directions.CheckTransmissionFluid.path) {
            CheckTransmissionFluid()
        }

        composable(Directions.ChangeTransmissionFluid.path) {
            ChangeTransmissionFluid()
        }

        composable(Directions.CheckBattery.path) {
            CheckBattery()
        }

        composable(Directions.ChangeBattery.path) {
            ChangeBattery()
        }
    }
}