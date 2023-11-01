package com.example.carcaddy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MaintenanceLog(
    @PrimaryKey
    val logId: Long = 0,
    val maintenanceType: MaintenanceType,
    val date: Long,
    val cost: Long
) {
    enum class MaintenanceType {
        MISCELLANEOUS,
        OIL,
        BRAKES,
        TRANSMISSION,
        TIRES,
        BATTERY,
        FUEL,
        WINDSHIELD
    }
}