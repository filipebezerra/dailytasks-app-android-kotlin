package com.github.filipebezerra.apps.dailytasks.presentation.ui.topappbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.filipebezerra.apps.dailytasks.presentation.theme.scaffoldContainerColor
import com.github.filipebezerra.apps.dailytasks.presentation.theme.scaffoldContentColor
import com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.topappbar.TopAppBarViewModel

@OptIn(ExperimentalMaterial3Api::class)
val appBarColors: TopAppBarColors
    @Composable get() = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.scaffoldContainerColor,
        titleContentColor = MaterialTheme.colorScheme.scaffoldContentColor,
        actionIconContentColor = MaterialTheme.colorScheme.scaffoldContentColor
    )

@Composable
fun DailyTasksTopBar(
    topAppBarViewModel: TopAppBarViewModel,
    navHostController: NavHostController,
    handleNewTaskSubmitListener: () -> Unit,
) {
    val isSearchBarVisible by topAppBarViewModel.isSearchBarVisible.collectAsState()
    val searchedText by topAppBarViewModel.searchedText.collectAsState()
    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    DailyTasksTopAppBar(
        navController = navHostController,
        handleSearchButtonClicked = { topAppBarViewModel.toggleSearchAppBar() },
        handleNewTaskSubmitListener = { handleNewTaskSubmitListener() }
    )
}
