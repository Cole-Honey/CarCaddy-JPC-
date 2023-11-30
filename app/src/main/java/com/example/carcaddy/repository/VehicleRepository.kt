package com.example.carcaddy.repository

import android.util.Log
import com.example.carcaddy.database.VehicleDatabase
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.model.VehicleWithLogs
import com.example.carcaddy.network.VehicleService
import com.example.carcaddy.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VehicleRepository @Inject constructor(
    private val database: VehicleDatabase,
    private val networkingService: VehicleService
) {

    private var dispatcher = Dispatchers.IO

    suspend fun fetchVehicleByVin(vin: String): Flow<Response<Vehicle>> = flow {
        emit(Response.Loading())

        try {
            val fetchedVehicle = networkingService.getVehicleInfo(vin)
            database.vehicleDao().insertVehicle(fetchedVehicle)
            println("Vehicle Fetched Successfully in repository")
            println("Vehicle: $fetchedVehicle")

            emit(Response.Success(fetchedVehicle))
        } catch (e: Exception) {
            emit(Response.Error(e.message))
        }
    }.flowOn(dispatcher)

    suspend fun getVehicleFromDatabaseByVin(vin: String): Flow<Response<Vehicle>> = flow {
        emit(Response.Loading())


        database.vehicleDao().getVehicleFromDatabaseByVin(vin).let {
            emit(Response.Success(it))
            return@flow
        }

    }.flowOn(dispatcher)

    suspend fun getVehicleWithLogs(): Flow<Response<List<VehicleWithLogs>>> = flow {
        emit(Response.Loading())

        try {
            val allVehicles = database.vehicleDao().getVehiclesWithLogs()

            emit(Response.Success(allVehicles))
        } catch (e: Exception) {
            emit(Response.Error(e.message))
        }
    }.flowOn(dispatcher)

    suspend fun getAllLogs(vin: String): Flow<Response<List<MaintenanceLog>>> = flow {
        emit(Response.Loading())
        if (vin.isEmpty()) {
            emit(Response.Success(emptyList()))
            return@flow
        }
        database.vehicleDao().getAllLogs(vin).let {
            emit(Response.Success(it))
            return@flow
        }
    }.flowOn(dispatcher)

    suspend fun updateVehicle(vehicle: Vehicle) {
        return withContext(dispatcher) {
            return@withContext database.vehicleDao().updateVehicle(vehicle)
        }
    }

    suspend fun addLog(log: MaintenanceLog) {
        return withContext(dispatcher) {
            try {
                database.vehicleDao().addLog(log)
            } catch (e: Exception) {
                // Propagate the exception if needed
                throw e
            }
        }
    }

    suspend fun deleteLog(log: MaintenanceLog) {
        return withContext(dispatcher) {
            return@withContext database.vehicleDao().deleteLog(log)
        }
    }

    suspend fun deleteVehicle(vehicle: Vehicle) {
        return withContext(dispatcher) {
            return@withContext database.vehicleDao().deleteVehicle(vehicle)
        }
    }

    suspend fun deleteLogsForVehicle(vin: String) {
        return withContext(dispatcher) {
            return@withContext database.vehicleDao().deleteLogsForVehicle(vin)
        }
    }
}