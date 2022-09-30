package com.example.todoapp.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

import com.example.todoapp.R
import com.example.todoapp.data.TaskInfo
import com.example.todoapp.data.TaskObject
import com.example.todoapp.data.TodoDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    private lateinit var db: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        db= Room.databaseBuilder(
            applicationContext,TodoDatabase::class.java,"To_Do"
        ).build()
        GlobalScope.launch {
//            TaskObject.taskList=db.dao().getTasks() as MutableList<TaskInfo>
        }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}