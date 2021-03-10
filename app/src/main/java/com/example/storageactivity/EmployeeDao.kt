package com.example.storageactivity

import androidx.room.*

@Dao
interface EmployeeDao {

    @Query("Select * from employee_table")
    fun getAllEmp():List<Employee>

    @Insert
    fun insertEmp(employee: Employee)

    @Update
    fun updateEmp(employee: Employee)

    @Delete
    fun deleteEmp(employee: Employee)
}