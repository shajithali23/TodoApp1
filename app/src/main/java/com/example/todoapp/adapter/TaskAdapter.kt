package com.example.todoapp.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Activity.UpdateActivity
import com.example.todoapp.R
import com.example.todoapp.data.TaskInfo

class TaskAdapter(var task:List<TaskInfo>): RecyclerView.Adapter<TaskAdapter.viewHolder>() {
    class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var task=itemView.findViewById<TextView>(R.id.taskDetail)
        var priority=itemView.findViewById<TextView>(R.id.taskPriority)
        var taskLayout=itemView.findViewById<LinearLayout>(R.id.taskLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView=LayoutInflater.from(parent.context).
                inflate(R.layout.list_task,parent,false);
        return  viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       when(task[position].priority.lowercase()){
           "high"->holder.taskLayout.setBackgroundColor(Color.parseColor("#F05454"))
           "medium"->holder.taskLayout.setBackgroundColor(Color.parseColor("#EDC988"))
           "low"->holder.taskLayout.setBackgroundColor(Color.parseColor("#F05454"))
       }
        holder.task.text=task[position].task
        holder.priority.text=task[position].priority
        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,UpdateActivity::class.java)
            intent.putExtra("id",position)
            intent.putExtra("task",task[position].task)
            intent.putExtra("priority",task[position].priority)
            holder.itemView.context.startActivity(intent)
        }
         }

    override fun getItemCount(): Int {
        return task.size
    }
}