package com.github.filipebezerra.apps.dailytasks.domain.repository

import com.github.filipebezerra.apps.dailytasks.data.database.TaskDao
import com.github.filipebezerra.apps.dailytasks.domain.mapper.TaskMapper
import com.github.filipebezerra.apps.dailytasks.domain.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao,
    private val taskMapper: TaskMapper,
) {

    suspend fun saveNewTask(task: Task) = taskDao.saveTask(taskMapper.map(task))
}
