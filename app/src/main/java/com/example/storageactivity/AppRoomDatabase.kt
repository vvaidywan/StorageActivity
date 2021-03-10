package com.example.storageactivity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Employee::class), version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}