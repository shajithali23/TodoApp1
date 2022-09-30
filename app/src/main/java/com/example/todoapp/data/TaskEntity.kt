package com.example.todoapp.data
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "To_Do")
data class TaskEntity (
    @PrimaryKey(autoGenerate=true)


    var id:Int,
    var task:String,
    var priority:String
        )