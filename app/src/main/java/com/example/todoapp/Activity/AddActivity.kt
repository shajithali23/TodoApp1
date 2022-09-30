package com.example.todoapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.todoapp.R
import com.example.todoapp.data.TaskObject
import com.example.todoapp.data.TodoDatabase


class AddActivity : AppCompatActivity() {
    private lateinit var db:TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        db= Room.databaseBuilder(
            applicationContext,TodoDatabase::class.java,"Todo"
        ).build()

        var btnSave=findViewById<Button>(R.id.btnSave)
        var etTask=findViewById<EditText>(R.id.etTask)
       var priorityGroup = findViewById<RadioGroup>(R.id.rgPriority);

        btnSave.setOnClickListener{
           if(etTask.text.toString().trim{it<=' '}.isNotEmpty()){
               val selectedId: Int = priorityGroup.getCheckedRadioButtonId()

               // find the radiobutton by returned id

               // find the radiobutton by returned id
              var radioButton = findViewById<RadioButton>(selectedId)
             var task=etTask.getText().toString();
             var priority=radioButton.getText().toString()
             TaskObject.addTask(task,priority)
//               GlobalScope.launch {  db.dao().insertTask(TaskEntity(0,task,priority))
//               }
//               GlobalScope.launch {
//                   Log.i("data",db.dao().getTasks().toString())
//
//
//               }
              val intent=Intent(this,MainActivity::class.java)
               startActivity(intent)
               finish()
           }
       }


    }
}