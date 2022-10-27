package com.dacha.taskmanager1.ui.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dacha.taskmanager1.data.Tasks
import com.dacha.taskmanager1.databinding.ItemTaskBinding

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private var task= arrayListOf<Tasks>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    fun addTask(tasks: Tasks){
        task.add(0, tasks)
        notifyItemChanged(0)

    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() =task.size

    inner class TaskViewHolder(private var binding: ItemTaskBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = task[adapterPosition]
            binding.title.text = item.title
            binding.desc.text = item.desc
        }
    }

}