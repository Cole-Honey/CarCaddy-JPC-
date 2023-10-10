package com.example.carcaddy.repository

import com.example.carcaddy.database.VehicleDatabase
import com.example.carcaddy.model.Vehicle
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

    fun fetchVehicleByVin(vin: String): Flow<Response<Vehicle>> = flow {
        emit(Response.Loading())

        try {
            val fetchedVehicle = networkingService.getVehicleInfo(vin)
            database.vehicleDao.upsertVehicle(fetchedVehicle)

            emit(Response.Success(fetchedVehicle))
        } catch (e: Exception) {
            emit(Response.Error(e.message))
        }
    }

    suspend fun getVehicleByVin(vehicle: Vehicle): Flow<Response<Vehicle>> = flow {
        emit(Response.Loading())

        try {
            database.vehicleDao.getVehicleByVin(vehicle.vin)?.let {
                emit(Response.Success(it))
                return@flow
            }

            emit(Response.Success(vehicle))
        } catch (e: Exception) {
            emit(Response.Error(e.message))
        }
    }.flowOn(dispatcher)

    fun getAllVehicles(): Flow<Response<List<Vehicle>>> = flow {
        emit(Response.Loading())

        try {
            var allVehicles = database.vehicleDao.getAllVehicles()

            emit(Response.Success(allVehicles))
        } catch (e: Exception) {
            emit(Response.Error(e.message))
        }
    }.flowOn(dispatcher)
}