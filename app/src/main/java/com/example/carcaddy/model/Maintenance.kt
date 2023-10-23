package com.example.carcaddy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "maintenance_log_table")
data class MaintenanceLog(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "logId")
    val logId: Long = 0,
    @ColumnInfo(name = "vehicleVin")
    val vehicleVin: String, // Foreign key to link the log to a vehicle
    @ColumnInfo(name = "maintenanceType")
    val maintenanceType: String, // Oil change, brake change, etc.
    @ColumnInfo(name = "date")
    val date: Long // Date of the maintenance event (timestamp)
    // Add more fields as needed
)