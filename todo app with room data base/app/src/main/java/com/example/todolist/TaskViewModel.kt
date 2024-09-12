package com.example.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskDao: TaskDao = AppDatabase.getDatabase(application).taskDao()
    val taskItems: LiveData<List<TaskItem>> = taskDao.getAllTasks()

    fun addTaskItem(newTask: TaskItem) = viewModelScope.launch {
        taskDao.insertTask(newTask)
    }

    fun updateTaskItem(id: UUID, name: String, desc: String, dueTime: LocalTime?, priority: Int) = viewModelScope.launch {
        val task: TaskItem? = taskDao.getTaskById(id)
        task?.let {
            val updatedTask = it.copy(
                name = name,
                desc = desc,
                dueTime = dueTime,
                priority = priority
            )
            taskDao.updateTask(updatedTask)
        }
    }

    fun removeTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        taskDao.deleteTask(taskItem)
    }

    fun removeAllTasks() = viewModelScope.launch {
        taskDao.deleteAllTasks()
    }

    fun setCompleted(taskItem: TaskItem) = viewModelScope.launch {
        val completedTask = taskItem.copy(completedDate = LocalDate.now())
        taskDao.updateTask(completedTask)
    }
}
