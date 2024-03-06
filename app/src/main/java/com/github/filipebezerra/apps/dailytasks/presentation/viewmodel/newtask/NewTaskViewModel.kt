package com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.newtask

import androidx.lifecycle.ViewModel
import com.github.filipebezerra.apps.dailytasks.domain.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewTaskViewModel : ViewModel() {
    private val _screenState = MutableStateFlow(Task(title = "", description = ""))
    val screenState = _screenState.asStateFlow()
}
