package com.example.carcaddy.network

import com.example.carcaddy.model.Vehicle
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.time.Year

object VehicleService {

    private const val BASE_URL = "https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues/"
    private const val FORMAT_KEY = "format=json"
    private const val MODEL_YEAR = "modelyear"

    private const val YEAR_FILLER_TEXT = "2018"

    private val client: HttpClient
        get() = HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    suspend fun getVehicleInfo(withVIN: String): Vehicle = client
        .get("$BASE_URL/$withVIN?$FORMAT_KEY&$MODEL_YEAR=$YEAR_FILLER_TEXT")
        .also { println(it.body<String>()) }
        .body()
}