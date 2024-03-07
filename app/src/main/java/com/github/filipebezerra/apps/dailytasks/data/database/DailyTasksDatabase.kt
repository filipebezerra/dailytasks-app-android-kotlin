package com.github.filipebezerra.apps.dailytasks.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.filipebezerra.apps.dailytasks.data.model.TaskData

@Database(
    entities = [TaskData::class],
    version = 1,
    exportSchema = false,
)
abstract class DailyTasksDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}
