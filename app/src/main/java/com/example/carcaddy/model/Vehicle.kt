package com.example.carcaddy.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity("vehicle_table")
data class Vehicle(
    @PrimaryKey
    @SerialName("VIN")
    val vin: String?,
    @SerialName("ModelYear")
    val year: String?,
    @SerialName("Make")
    val make: String?,
    @SerialName("Model")
    val model: String?,
    val mileage: String?,
    val image: String?,
    val insuranceImage: String?,
    val registrationImage: String?,

    // ux information
    val name: String?,
)