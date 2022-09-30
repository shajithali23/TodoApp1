package com.example.todoapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.room.Room
import com.example.todoapp.R
import com.example.todoapp.data.TaskEntity
import com.example.todoapp.data.TaskObject
import com.example.todoapp.data.TodoDatabase
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    private lateinit var db:TodoDatabase
    var priority = arrayOf("High", "Medium", "Low")
    val NEW_SPINNER_ID = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        db= Room.databaseBuilder(
            applicationContext,TodoDatabase::class.java,"Todo"
        ).build()
       btnSave.setOnClickListener{
           if(etTask.text.toString().trim{it<=' '}.isNotEmpty()){
             var task=etTask.getText().toString();
             var priority="high"
             TaskObject.addTask(task,priority)
               GlobalScope.launch {  db.dao().insertTask(TaskEntity(0,task,priority))
               }
               GlobalScope.launch {
                   Log.i("data",db.dao().getTasks().toString())


               }
              val intent=Intent(this,MainActivity::class.java)
               startActivity(intent)
               finish()
           }
       }


    }
}