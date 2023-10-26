package com.example.carcaddy.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.model.VehicleWithLogs

@Dao
interface VehicleDao {

    @Query("SELECT * FROM vehicle_table WHERE vin = :vin LIMIT 1")
    suspend fun getVehicleFromDatabaseByVin(vin: String): Vehicle

    @Transaction
    @Query("SELECT * FROM vehicle_table ORDER BY year DESC")
    fun getVehicleWithLogs(): List<VehicleWithLogs>

    @Update
    suspend fun updateVehicle(vehicle: Vehicle)
}