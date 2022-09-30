package com.example.todoapp.data

import androidx.room.*

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(entity: TaskEntity)

    @Update
    suspend fun updateTask(entity: TaskEntity)

    @Delete
    suspend fun deleteTask(entity: TaskEntity)

    @Query("Delete from todo")
    suspend fun deleteAll()

    @Query("Select * from Todo")
    suspend fun getTasks():List<TaskInfo>
}