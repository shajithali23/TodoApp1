package com.example.todoapp.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Todo")
data class TaskEntity (
    @PrimaryKey(autoGenerate=true)
    var id:Int,
    var title:String,
    var priority:String
        )