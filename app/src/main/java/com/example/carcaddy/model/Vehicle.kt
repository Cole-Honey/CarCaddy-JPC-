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
    val name: String? = null,
)

@Serializable
data class VehicleResponse(
    @SerialName("Results")
    val results: List<Vehicle>
)



//    @Relation(
//        parentColumn = "vin", // The column in the Vehicle entity
//        entity = MaintenanceLog::class,
//        entityColumn = "vehicleVin", // The column in the MaintenanceLog entity
//        associateBy = Junction(VehicleMaintenanceCrossRef::class)
//    )
//    val maintenanceLogs: List<MaintenanceLog> // List of maintenance logs for this vehicle