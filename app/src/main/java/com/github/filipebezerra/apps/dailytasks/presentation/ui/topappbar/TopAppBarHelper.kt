package com.github.filipebezerra.apps.dailytasks.presentation.ui.topappbar

import com.github.filipebezerra.apps.dailytasks.utils.NavScreens

object TopAppBarHelper {
    fun getAppBarTitle(currentRoute: String?): String {
        return when(currentRoute) {
            NavScreens.Tasks.route -> "Daily Tasks"
            "${NavScreens.TaskDetail.route}/{id}" -> "Todo Details"
            NavScreens.NewTask.route ->  "New Task"
            else -> "Daily Tasks"
        }
    }
}
