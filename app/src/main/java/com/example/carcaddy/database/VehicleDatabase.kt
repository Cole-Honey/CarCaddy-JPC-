package com.example.carcaddy.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.model.Vehicle

@Database(entities = [Vehicle::class, MaintenanceLog::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
    abstract fun maintenanceLogDao(): MaintenanceDao

    companion object {
        // Database creation and singleton pattern here
    }
}
