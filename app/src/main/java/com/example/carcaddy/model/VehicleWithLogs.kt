package com.example.carcaddy.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class VehicleWithLogs(
    @Embedded val vehicle: Vehicle,
    @Relation(
        parentColumn = "vin",
        entityColumn = "vin"
    )
    val logs: List<MaintenanceLog>
)
