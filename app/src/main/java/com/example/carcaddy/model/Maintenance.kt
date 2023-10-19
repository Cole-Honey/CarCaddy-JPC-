package com.example.carcaddy.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "maintenance_log_table",
    foreignKeys = [
        ForeignKey(
            entity = Vehicle::class,
            parentColumns = ["vin"],
            childColumns = ["vehicleVin"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MaintenanceLog(
    @PrimaryKey(autoGenerate = true)
    val logId: Long = 0,
    val vehicleVin: String, // Foreign key to link the log to a vehicle
    val maintenanceType: String, // Oil change, brake change, etc.
    val date: Long, // Date of the maintenance event (timestamp)
    // Add more fields as needed
)

