package com.github.filipebezerra.apps.dailytasks.utils

sealed class NavScreens(val route: String) {

    object Tasks : NavScreens("Tasks")
    object NewTask : NavScreens("NewTask")
    object TaskDetail : NavScreens("TaskDetail")
}
