package com.example.carcaddy.model

import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "vehicle_table")
data class Vehicle(
    @PrimaryKey(autoGenerate = false)
    @SerialName("VIN")
    val vin: String,
    @SerialName("ModelYear")
    val year: String? = null,
    @SerialName("Make")
    val make: String? = null,
    @SerialName("Model")
    val model: String? = null,
    val mileage: String? = null,
    val image: String? = null,
    val insuranceImage: String? = null,
    val registrationImage: String? = null,
    // ux information
    val name: String? = null,
)


// Fetching Vehicle From API and converting Results object to a Vehicle Object
@Serializable
data class VehicleResponse(
    @SerialName("Results")
    val results: List<Vehicle>
)