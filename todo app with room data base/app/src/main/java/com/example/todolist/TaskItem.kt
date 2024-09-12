package com.example.todolist

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

@Entity(tableName = "task_table")
data class TaskItem(
    var name: String,
    var desc: String,
    var dueTime: LocalTime?,
    var completedDate: LocalDate?,
    var priority: Int,
    @PrimaryKey var id: UUID = UUID.randomUUID()
) {
    fun isCompleted() = completedDate != null

    fun imageResource(): Int = if (isCompleted()) R.drawable.checked_24 else R.drawable.unchecked_24

    fun imageColor(context: Context): Int = if (isCompleted()) purple(context) else black(context)

    fun nameColor(context: Context): Int = when (priority) {
        1 -> ContextCompat.getColor(context, R.color.green)
        2 -> ContextCompat.getColor(context, R.color.yellow)
        3 -> ContextCompat.getColor(context, R.color.red)
        else -> ContextCompat.getColor(context, R.color.black)
    }

    private fun purple(context: Context) = ContextCompat.getColor(context, R.color.purple)

    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)
}
