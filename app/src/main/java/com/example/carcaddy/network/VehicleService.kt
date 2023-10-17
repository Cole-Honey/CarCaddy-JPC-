package com.example.carcaddy.network

import com.example.carcaddy.model.Vehicle
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object VehicleService {

    private const val BASE_URL = "https://vpic.nhtsa.dot.gov/api/vehicles/DecodeVinValues/"

    private val client: HttpClient
        get() = HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    suspend fun getVehicleInfo(withVIN: String): Vehicle = client
        .get("$BASE_URL/$withVIN")
        .body()
}