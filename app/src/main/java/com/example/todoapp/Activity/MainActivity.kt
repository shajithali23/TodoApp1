package com.example.todoapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.todoapp.R
import com.example.todoapp.adapter.TaskAdapter
import com.example.todoapp.data.TaskObject
import com.example.todoapp.data.TodoDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var db: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db= Room.databaseBuilder(
            applicationContext,TodoDatabase::class.java,"Todo"
        ).build()
        task_view.adapter=TaskAdapter(TaskObject.getAllTask())
        task_view.layoutManager=LinearLayoutManager(this)

    }
    fun goAddScreen(v: View?){
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }
}