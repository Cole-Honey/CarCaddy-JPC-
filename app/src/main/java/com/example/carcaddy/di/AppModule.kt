package com.example.carcaddy.di

import android.content.Context
import androidx.room.Room
import com.example.carcaddy.database.VehicleDatabase
import com.example.carcaddy.network.VehicleService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideVehicleDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        VehicleDatabase::class.java,
        "vehicle_database"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideVehicleNetworkingService() = VehicleService
}