package com.example.todolist

import android.app.AlertDialog
import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    fun bindTaskItem(taskItem: TaskItem) {
        binding.name.text = taskItem.name
        binding.name.setTextColor(taskItem.nameColor(context))

        if (taskItem.isCompleted()) {
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            binding.name.paintFlags = 0
            binding.dueTime.paintFlags = 0
        }

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        if (taskItem.dueTime != null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime)
        else
            binding.dueTime.text = ""

        binding.completeButton.setOnClickListener {
            clickListener.completeTaskItem(taskItem)
        }

        binding.editeButton.setOnClickListener {
            clickListener.editTaskItem(taskItem)
        }

        binding.taskCellContainer.setOnClickListener {
            clickListener.onTaskItemClicked(taskItem)
        }

        binding.deleteButton.setOnClickListener {
            showDeleteConfirmationDialog(taskItem)
        }
    }

    private fun showDeleteConfirmationDialog(taskItem: TaskItem) {
        AlertDialog.Builder(context)
            .setTitle("Delete Task")
            .setMessage("Are you sure you want to delete this task?")
            .setPositiveButton("Yes") { _, _ ->
                clickListener.deleteTaskItem(taskItem)
            }
            .setNegativeButton("No", null)
            .show()
    }
}
