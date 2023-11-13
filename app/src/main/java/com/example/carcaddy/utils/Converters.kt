package com.example.carcaddy.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

//    @TypeConverter
//    fun fromLongList(value: List<Long>): String {
//        return Gson().toJson(value)
//    }
//
//    @TypeConverter
//    fun toLongList(value: String): List<Long> {
//        val listType = object : TypeToken<List<Long>>() {}.type
//        return Gson().fromJson(value, listType)
//    }
}