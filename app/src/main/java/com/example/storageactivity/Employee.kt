package com.example.storageactivity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_table")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0 ,
    //@ColumnInfo(name = "name")
    var name:String? = null,
    var address:String? = null,
    var phone:String? = null
)