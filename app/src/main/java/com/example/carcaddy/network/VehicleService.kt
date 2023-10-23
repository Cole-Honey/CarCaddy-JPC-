package com.example.carcaddy.network

import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.model.VehicleResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import io.ktor.http.Url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.Json

object VehicleService {

    private const val BASE_URL = "https://vpic.nhtsa.dot.gov/api/vehicles/decodevinvalues"
    private const val FORMAT_KEY = "format=json"

    private val client: HttpClient
        get() = HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }

    private val json = Json { ignoreUnknownKeys = true }

    suspend fun getVehicleInfo(withVIN: String): Vehicle {
        val response: HttpResponse = client.get("$BASE_URL/$withVIN?$FORMAT_KEY")
        val responseBody = response.bodyAsText()
        val vehicleResponse = json.decodeFromString<VehicleResponse>(responseBody)

        if (vehicleResponse.results.isNotEmpty()) {
            return vehicleResponse.results.first().toVehicle()
        } else {
            throw Exception("No results found for the given VIN.")
        }
    }
}

fun Vehicle.toVehicle(): Vehicle {
    return Vehicle(
        vin = this.vin,
        year = this.year,
        make = this.make,
        model = this.model,
        mileage = this.mileage,
        image = this.image,
        insuranceImage = this.insuranceImage,
        registrationImage = this.registrationImage,
        name = this.name
    )
}
