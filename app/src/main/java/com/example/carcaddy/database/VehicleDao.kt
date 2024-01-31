package com.example.carcaddy.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.model.VehicleWithLogs

@Dao
interface VehicleDao {

    //* Vehicle Section *//

    @Query("SELECT * FROM vehicle_table WHERE vin = :vin LIMIT 1")
    suspend fun getVehicleFromDatabaseByVin(vin: String): Vehicle

    @Transaction
    @Query("SELECT * FROM vehicle_table ORDER BY year DESC")
    suspend fun getVehiclesWithLogs(): List<VehicleWithLogs>

    @Insert
    suspend fun insertVehicle(vehicle: Vehicle)

    @Update
    suspend fun updateVehicle(vehicle: Vehicle)

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    //* Log Section *//

    @Query("SELECT * FROM maintenance_table WHERE vin IN (:vin) ORDER BY date DESC")
    suspend fun getAllLogs(vin: String): List<MaintenanceLog>

    @Query("SELECT * FROM maintenance_table WHERE logId = :log LIMIT 1")
    suspend fun getLogById(log: String): MaintenanceLog

    @Insert
    suspend fun addLog(log: MaintenanceLog)

    @Delete
    suspend fun deleteLog(log: MaintenanceLog)

    //* Combined Section *//

    @Query("DELETE FROM maintenance_table WHERE vin = :vin")
    suspend fun deleteLogsForVehicle(vin: String)
}