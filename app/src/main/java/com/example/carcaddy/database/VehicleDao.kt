package com.example.carcaddy.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.carcaddy.model.Vehicle

@Dao
interface VehicleDao {

    @Query("SELECT * FROM vehicle_table ORDER BY make")
    suspend fun getAllVehicles(): List<Vehicle>

    @Query("SELECT * FROM vehicle_table WHERE vin = :vin LIMIT 1")
    suspend fun getVehicleFromDatabaseByVin(vin: String): Vehicle

    @Upsert
    suspend fun upsertVehicle(vehicle: Vehicle)
}