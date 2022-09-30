package com.example.todoapp.Activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todoapp.R
import com.example.todoapp.adapter.TaskAdapter
import com.example.todoapp.data.TaskInfo
import com.example.todoapp.data.TaskObject
import com.example.todoapp.data.TodoDatabase
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var db: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db= Room.databaseBuilder(
            applicationContext,TodoDatabase::class.java,"Todo"
        ).build()
        var task_view=findViewById<RecyclerView>(R.id.task_view)
        task_view.adapter=TaskAdapter(TaskObject.getAllTask())
        task_view.layoutManager=LinearLayoutManager(this)
        var etSearchText=findViewById<EditText>(R.id.search_editText)
        etSearchText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do Nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                Log.i("Filter",s.toString());
            }

        })



    }
    fun goAddScreen(v: View?){
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

}