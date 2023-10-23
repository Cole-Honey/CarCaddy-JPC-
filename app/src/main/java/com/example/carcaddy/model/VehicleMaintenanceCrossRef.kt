package com.example.carcaddy.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity(primaryKeys = ["vehicleVin", "logId"])
data class VehicleMaintenanceCrossRef(
    val vehicleVin: String,
    val logId: Long
)
