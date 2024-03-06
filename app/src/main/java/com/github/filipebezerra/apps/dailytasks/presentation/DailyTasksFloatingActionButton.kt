package com.github.filipebezerra.apps.dailytasks.presentation

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.filipebezerra.apps.dailytasks.R
import com.github.filipebezerra.apps.dailytasks.presentation.theme.scaffoldContentColor
import com.github.filipebezerra.apps.dailytasks.presentation.theme.scaffoldContainerColor

@Composable
fun DailyTasksFloatingActionButton(buttonClickListener: () -> Unit) {
    FloatingActionButton(
        onClick = { buttonClickListener() },
        contentColor = MaterialTheme.colorScheme.scaffoldContentColor,
        containerColor = MaterialTheme.colorScheme.scaffoldContainerColor
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = stringResource(R.string.add_new_task),
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewDailyTasksFloatingActionButton() {
    DailyTasksFloatingActionButton {

    }
}
