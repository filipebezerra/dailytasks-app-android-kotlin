package com.github.filipebezerra.apps.dailytasks.presentation.ui.topappbar

import android.app.Activity
import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.filipebezerra.apps.dailytasks.utils.NavScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyTasksTopAppBar(
    navController: NavHostController,
    handleSearchButtonClicked: () -> Unit,
    handleNewTaskSubmitListener: () -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current as Activity

    val appBarTitle = TopAppBarHelper.getAppBarTitle(currentRoute)
    TopAppBar(title = { Text(text = appBarTitle) },
        colors = appBarColors,
        navigationIcon = {
            BackNavigationButton {
                if (navController.previousBackStackEntry != null)
                    navController.navigateUp()
                else
                    context.finish()
            }
        },
        actions = {
            when (currentRoute) {
                NavScreens.Tasks.route -> HomeActionButtons(handleSearchButtonClicked)
                NavScreens.NewTask.route -> DoneButton(handleNewTaskSubmitListener)
                "${NavScreens.TaskDetail.route}/{id}" -> EditButton()
            }
        }
    )
}

@Preview(name = "Light Preview")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Preview")
@Composable
fun PreviewDailyTasksTopAppBar() {
    DailyTasksTopAppBar(rememberNavController(), { }, { })
}
