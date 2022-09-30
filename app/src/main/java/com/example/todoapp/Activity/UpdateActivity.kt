package com.example.todoapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.example.todoapp.R
import com.example.todoapp.data.TaskEntity
import com.example.todoapp.data.TaskObject
import com.example.todoapp.data.TodoDatabase
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateActivity : AppCompatActivity() {
    private lateinit var db: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        db= Room.databaseBuilder(
            applicationContext,TodoDatabase::class.java,"Todo"
        ).build()
        val pos=intent.getIntExtra("id",-1)
        if(pos!=-1){
            val task=TaskObject.getTaskItem(pos).task
            val priority=TaskObject.getTaskItem(pos).priority
            etUpdateTask.setText(task)
            btnDelete.setOnClickListener{
                TaskObject.deleteTaskItem(pos)
                GlobalScope.launch {
                    db.dao().deleteTask(TaskEntity(pos+1, task,priority))
                }
                goMainScreen()
            }
            btnUpdate.setOnClickListener{
                TaskObject.updateData(pos,etUpdateTask.text.toString(),"low")
                GlobalScope.launch {
                    db.dao().updateTask(TaskEntity(pos+1, etUpdateTask.text.toString(),"low"))
                }
                goMainScreen()
            }
        }


    }
    fun goMainScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}