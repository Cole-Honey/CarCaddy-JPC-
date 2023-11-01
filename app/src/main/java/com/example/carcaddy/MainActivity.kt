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
import com.example.carcaddy.screens.my_garage.MyGarageScreen
import com.example.carcaddy.screens.navigation.Directions
import com.example.carcaddy.screens.splash_screen.SplashScreen
import com.example.carcaddy.screens.tab_bar.TabBarScreen
import com.example.carcaddy.ui.theme.CarCaddyTheme
import dagger.hilt.android.AndroidEntryPoint

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
                    SetUpNavGraph(navController = navController)
//                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}

@Composable
fun SetUpNavGraph(
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
            arguments = listOf(navArgument("vin") { type = NavType.StringType })
        ) {
            TabBarScreen(
                vin = it.arguments?.getString("vin")
                    ?: throw Exception("Expected VIN but didn't get it"),
                navController = navController
            )
        }
    }
}