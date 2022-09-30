package com.example.todoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(entity: TaskEntity)

    @Update
    suspend fun updateTask(entity: TaskEntity)

    @Delete
    suspend fun deleteTask(entity: TaskEntity)

    @Query("Delete from to_do")
    suspend fun deleteAll()

    @Query("SELECT * FROM to_do")
     suspend fun getTasks():List<TaskInfo>

    @Query("SELECT * FROM to_do WHERE task LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<TaskInfo>>
}