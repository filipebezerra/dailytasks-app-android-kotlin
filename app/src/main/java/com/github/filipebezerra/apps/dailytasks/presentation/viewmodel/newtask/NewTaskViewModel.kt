package com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.newtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.filipebezerra.apps.dailytasks.domain.model.Task
import com.github.filipebezerra.apps.dailytasks.domain.usecase.SaveNewTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewTaskViewModel @Inject constructor(private val saveNewTask: SaveNewTask) : ViewModel() {
    private val _screenState = MutableStateFlow(Task(title = "", description = ""))
    val screenState = _screenState.asStateFlow()

    fun updateTitle(title: String ) {
        _screenState.update {
            it.copy(title = title)
        }
    }

    fun updateDescription(description: String) {
        _screenState.update {
            it.copy(description = description)
        }
    }

    fun handleSaveNewTask() {
        viewModelScope.launch {
            saveNewTask(_screenState.value)
        }
    }
}
