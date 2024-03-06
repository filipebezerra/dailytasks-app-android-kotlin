package com.github.filipebezerra.apps.dailytasks.presentation.ui.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.filipebezerra.apps.dailytasks.R
import com.github.filipebezerra.apps.dailytasks.presentation.theme.dailyTaskContainerColor
import com.github.filipebezerra.apps.dailytasks.presentation.theme.dailyTaskContentColor
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.tasks.TasksViewModel

@Composable
fun TasksScreen(
    tasksViewModel: TasksViewModel,
    taskClickListener: (Int) -> Unit,
) {
    TasksEmptyScreen(text = stringResource(id = R.string.click_to_add_new_task))
}

@Composable
fun TasksEmptyScreen(text: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.dailyTaskContainerColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Welcome Image",
            tint = MaterialTheme.colorScheme.dailyTaskContentColor,
            modifier = Modifier
                .size(180.dp)
                .alpha(0.5f),
        )
        Text(
            text = text,
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.dailyTaskContentColor,
            fontSize = 20.sp
        )
    }
}
