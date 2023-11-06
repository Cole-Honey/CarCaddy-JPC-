package com.example.carcaddy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carcaddy.model.MaintenanceLog
import com.example.carcaddy.model.Vehicle

@Database(
    entities = [
        Vehicle::class,
        MaintenanceLog::class
    ],
    version = 4,
    exportSchema = false
)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao

    companion object {
        @Volatile
        private var INSTANCE: VehicleDatabase? = null

        fun getInstance(context: Context): VehicleDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        VehicleDatabase::class.java,
                        "vehicle_database"
                    )
                        // Add migration strategies or fallbackToDestructiveMigration if needed
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

