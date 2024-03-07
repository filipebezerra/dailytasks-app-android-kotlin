package com.github.filipebezerra.apps.dailytasks.data.database

import androidx.room.Dao
import androidx.room.Upsert
import com.github.filipebezerra.apps.dailytasks.data.model.TaskData

@Dao
interface TaskDao {

    @Upsert
    suspend fun saveTask(task: TaskData)
}
