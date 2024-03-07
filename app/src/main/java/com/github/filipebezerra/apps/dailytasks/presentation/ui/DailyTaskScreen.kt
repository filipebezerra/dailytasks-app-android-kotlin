package com.github.filipebezerra.apps.dailytasks.presentation.ui

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.filipebezerra.apps.dailytasks.presentation.DailyTasksFloatingActionButton
import com.github.filipebezerra.apps.dailytasks.presentation.ui.topappbar.DailyTasksTopBar
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.newtask.NewTaskViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.taskdetail.TaskDetailViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.tasks.TasksViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.topappbar.TopAppBarViewModel
import com.github.filipebezerra.apps.dailytasks.utils.NavScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyTasksScreen(
    topAppBarViewModel: TopAppBarViewModel,
    tasksViewModel: TasksViewModel,
    newTaskViewModel: NewTaskViewModel,
    taskDetailViewModel: TaskDetailViewModel,
    navHostController: NavHostController = rememberNavController(),
) {
    val currentBackStack by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    val context = LocalContext.current
    Scaffold(
        topBar = {
             DailyTasksTopBar(
                 topAppBarViewModel = topAppBarViewModel,
                 navHostController = navHostController,
                 handleNewTaskSubmitListener = {
                     newTaskViewModel.handleSaveNewTask()
                 }
             )
        },
        floatingActionButton = {
            if (currentRoute != NavScreens.TaskDetail.route) {
                DailyTasksFloatingActionButton {
                    navHostController.navigate(NavScreens.NewTask.route)
                }
            }
        }
    ) {
        DailyTaskNavHost(
            tasksViewModel = tasksViewModel,
            taskDetailViewModel = taskDetailViewModel,
            newTaskViewModel = newTaskViewModel,
            navController = navHostController,
            modifier = Modifier.padding(paddingValues = it)
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDailyTaskScreen() {

}
