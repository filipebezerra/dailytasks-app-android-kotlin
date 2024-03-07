package com.github.filipebezerra.apps.dailytasks.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks_table")
data class TaskData(
    var title: String,
    var description: String,
    var isDone: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)
