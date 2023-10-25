package com.example.carcaddy.model

import androidx.room.Embedded
import androidx.room.Relation

data class VehicleWithLogs(
    @Embedded val vehicle: Vehicle,
    @Relation(
        parentColumn = "vin",
        entityColumn = "logId"
    )
    val logs: List<MaintenanceLog>
)
