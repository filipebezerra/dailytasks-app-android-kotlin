package com.github.filipebezerra.apps.dailytasks.domain.mapper

import com.github.filipebezerra.apps.dailytasks.data.model.TaskData
import com.github.filipebezerra.apps.dailytasks.domain.data.Mapper
import com.github.filipebezerra.apps.dailytasks.domain.model.Task

class TaskMapper : Mapper<Task, TaskData> {
    override suspend fun map(from: Task) = TaskData(
        title = from.title,
        description = from.description,
        isDone = from.isDone,
    )
}
