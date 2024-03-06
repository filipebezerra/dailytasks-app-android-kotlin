package com.github.filipebezerra.apps.dailytasks

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.filipebezerra.apps.dailytasks.presentation.theme.DailyTasksTheme
import com.github.filipebezerra.apps.dailytasks.presentation.ui.DailyTasksScreen
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.newtask.NewTaskViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.taskdetail.TaskDetailViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.tasks.TasksViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.topappbar.TopAppBarViewModel

class MainActivity : AppCompatActivity() {

    private val topAppBarViewModel: TopAppBarViewModel by viewModels()
    private val tasksViewModel: TasksViewModel by viewModels()
    private val newTaskViewModel: NewTaskViewModel by viewModels()
    private val taskDetailViewModel: TaskDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DailyTasksTheme {
                DailyTasksScreen(
                    topAppBarViewModel,
                    tasksViewModel,
                    newTaskViewModel,
                    taskDetailViewModel
                )
            }
        }
    }
}
