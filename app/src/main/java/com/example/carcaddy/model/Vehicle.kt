package com.example.carcaddy.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "vehicle_table")
data class Vehicle(
    @PrimaryKey
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
    val name: String?,

    @Relation(
        parentColumn = "vin",
        entityColumn = "vehicleVin"
    )
    val maintenanceLogs: List<MaintenanceLog> // List of maintenance logs for this vehicle
)
