package com.example.carcaddy.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.carcaddy.model.Vehicle

@Database(entities = [Vehicle::class], version = 1, exportSchema = false)
abstract class VehicleDatabase: RoomDatabase() {

    abstract val vehicleDao: VehicleDao

}