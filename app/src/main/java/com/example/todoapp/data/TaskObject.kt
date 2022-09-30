package com.example.todoapp.data

object TaskObject {
    var taskList= mutableListOf<TaskInfo>()

    fun addTask(title:String,priority:String){}

    fun getAllTask():List<TaskInfo>{
        return  taskList
    }
    fun getTaskItem(pos:Int):TaskInfo{
        return taskList[pos]
    }
    fun deleteTaskItem(pos:Int){
        taskList.removeAt(pos);

    }

    fun updateData(pos: Int,task :String,priority:String) {
        taskList[pos].task=task
        taskList[pos].priority=priority
    }
}