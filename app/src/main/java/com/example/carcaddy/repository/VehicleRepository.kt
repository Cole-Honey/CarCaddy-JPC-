package com.example.carcaddy.repository

import com.example.carcaddy.database.VehicleDatabase
import com.example.carcaddy.model.Vehicle
import com.example.carcaddy.network.VehicleService
import com.example.carcaddy.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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
            database.vehicleDao().upsertVehicle(fetchedVehicle)
            println("Vehicle Fetched Successfully in repository")

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

    fun getAllVehicles(): Flow<Response<List<Vehicle>>> = flow {
        emit(Response.Loading())

        try {
            val allVehicles = database.vehicleDao().getAllVehicles()

            emit(Response.Success(allVehicles))
        } catch (e: Exception) {
            emit(Response.Error(e.message))
        }
    }.flowOn(dispatcher)

    suspend fun addVehicleToDatabase(vehicle: Vehicle) {
        database.vehicleDao().upsertVehicle(vehicle)
    }
}