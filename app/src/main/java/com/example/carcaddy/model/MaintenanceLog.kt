package com.example.carcaddy.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "maintenance_table")
data class MaintenanceLog(
    @PrimaryKey(autoGenerate = true)
    val logId: Long = 0,
    val maintenanceType: MaintenanceType,
//    val date: Date,
    val cost: Long,
    val description: String,
    val vin: String
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