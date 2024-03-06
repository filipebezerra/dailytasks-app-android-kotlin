package com.github.filipebezerra.apps.dailytasks.presentation.ui.newtask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.github.filipebezerra.apps.dailytasks.presentation.theme.dailyTaskContainerColor
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.newtask.NewTaskViewModel

@Composable
fun NewTaskScreen(
    newTaskViewModel: NewTaskViewModel,
    modifier: Modifier = Modifier,
) {
    val screenState by newTaskViewModel.screenState.collectAsState()
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.dailyTaskContainerColor)
            .padding(16.dp)
    ) {
        InputTextField(
            content = screenState.title,
            handleContentChangeHandler = {
                
            },
            label = "Task title",
            imeAction = ImeAction.Next,
            modifier = Modifier.fillMaxWidth(1f)
        )
        InputTextField(
            content = screenState.description,
            handleContentChangeHandler = {

            },
            label = "Description",
            imeAction = ImeAction.Done,
            modifier = Modifier.fillMaxSize()
                .padding(top = 8.dp)
        )
    }
}
