package com.github.filipebezerra.apps.dailytasks.presentation.ui.topappbar

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.github.filipebezerra.apps.dailytasks.R

@Composable
fun HomeActionButtons(handleSearchButtonClicked: () -> Unit) {
    Row {
        SearchButton(handleSearchButtonClicked)
        DeleteButton()
    }
}

@Composable
fun SearchButton(handleSearchButtonClicked: () -> Unit) {
    IconButton(onClick = { handleSearchButtonClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_button)
        )
    }
}

@Composable
fun DeleteButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete_button)
        )
    }
}

@Composable
fun DoneButton(handleNewTaskSubmitListener: () -> Unit) {
    IconButton(onClick = { handleNewTaskSubmitListener() }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.done_button)
        )
    }
}

@Composable
fun EditButton() {
    IconButton(onClick = { /* Todo */ }) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = stringResource(R.string.edit_button)
        )
    }
}
