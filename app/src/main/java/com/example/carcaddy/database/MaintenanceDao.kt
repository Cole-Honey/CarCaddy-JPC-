package com.example.carcaddy.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.carcaddy.model.MaintenanceLog

@Dao
interface MaintenanceDao {

    @Query("SELECT * FROM vehicle_table")
    suspend fun getMaintenanceLogs(): List<MaintenanceLog>

    @Insert
    suspend fun insertLog(log: MaintenanceLog)

    @Delete
    suspend fun deleteLog(log: MaintenanceLog)

    @Update
    suspend fun updateLog(log: MaintenanceLog)

}