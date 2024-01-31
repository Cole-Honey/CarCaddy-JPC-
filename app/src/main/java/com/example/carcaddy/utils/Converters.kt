package com.example.carcaddy.utils

import android.net.Uri
import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class Converters {

    @TypeConverter
    fun dateToString(date: LocalDate): Long {
        return date.toEpochDay()
    }

    @TypeConverter
    fun stringToDate(value: Long): LocalDate {
        return LocalDate.ofEpochDay(value)
    }

    @TypeConverter
    fun fromUri(uri: Uri?): String? {
        return uri?.toString()
    }

    @TypeConverter
    fun toUri(uriString: String?): Uri? {
        return uriString?.let { Uri.parse(it) }
    }
}