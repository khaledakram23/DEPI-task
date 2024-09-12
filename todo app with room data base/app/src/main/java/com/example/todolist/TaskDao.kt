package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.UUID

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getAllTasks(): LiveData<List<TaskItem>>

    @Query("SELECT * FROM task_table WHERE id = :id")
    suspend fun getTaskById(id: UUID): TaskItem?

    @Insert
    suspend fun insertTask(taskItem: TaskItem): Long  // returns the row ID of the newly inserted row

    @Update
    suspend fun updateTask(taskItem: TaskItem): Int  // returns the number of rows affected

    @Delete
    suspend fun deleteTask(taskItem: TaskItem): Int  // returns the number of rows deleted

    @Query("DELETE FROM task_table")
    suspend fun deleteAllTasks(): Int  // returns the number of rows deleted
}
