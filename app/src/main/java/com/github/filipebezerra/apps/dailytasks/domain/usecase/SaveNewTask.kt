package com.github.filipebezerra.apps.dailytasks.domain.usecase

import com.github.filipebezerra.apps.dailytasks.domain.model.Task
import com.github.filipebezerra.apps.dailytasks.domain.repository.TaskRepository
import javax.inject.Inject

class SaveNewTask @Inject constructor(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(task: Task): Result<Boolean> {
        return when {
            task.title.isEmpty() || task.description.isEmpty() -> {
                return Result.failure(FillRequiredFieldsException("Please fill all fields"))
            }
            else -> runCatching {
                taskRepository.saveNewTask(task)
                true
            }
        }
    }
}
