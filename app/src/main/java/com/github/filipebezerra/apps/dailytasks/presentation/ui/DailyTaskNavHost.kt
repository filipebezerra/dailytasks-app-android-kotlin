package com.github.filipebezerra.apps.dailytasks.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.github.filipebezerra.apps.dailytasks.presentation.ui.newtask.NewTaskScreen
import com.github.filipebezerra.apps.dailytasks.presentation.ui.taskdetail.TaskDetailScreen
import com.github.filipebezerra.apps.dailytasks.presentation.ui.tasks.TasksScreen
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.newtask.NewTaskViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.taskdetail.TaskDetailViewModel
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.tasks.TasksViewModel
import com.github.filipebezerra.apps.dailytasks.utils.NavScreens

@Composable
fun DailyTaskNavHost(
    tasksViewModel: TasksViewModel,
    taskDetailViewModel: TaskDetailViewModel,
    newTaskViewModel: NewTaskViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavScreens.Tasks.route,
        modifier = modifier.fillMaxSize(1f)
    ) {
        composable(NavScreens.Tasks.route) {
            TasksScreen(tasksViewModel) { taskId ->
                navController.navigate("${NavScreens.TaskDetail.route}/$taskId")
            }
        }
        composable(
            route = "${NavScreens.TaskDetail.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            TaskDetailScreen(taskDetailViewModel, it.arguments?.getInt("id")) {
                navController.navigate(NavScreens.Tasks.route)
            }
        }
        composable(
            route = NavScreens.NewTask.route,
        ) {
            NewTaskScreen(newTaskViewModel)
        }
    }
}
