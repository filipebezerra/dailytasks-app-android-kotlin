package com.github.filipebezerra.apps.dailytasks.presentation.ui.newtask

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import com.github.filipebezerra.apps.dailytasks.presentation.theme.dailyTaskContentColor
import com.github.filipebezerra.apps.dailytasks.presentation.theme.dailyTaskItemContainerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    content: String,
    handleContentChangeHandler: (String) -> Unit,
    label: String,
    imeAction: ImeAction,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = content,
        onValueChange = { handleContentChangeHandler(it) },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.dailyTaskContentColor
            )
        },
        modifier = modifier,
        textStyle = MaterialTheme.typography.bodyLarge,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.dailyTaskItemContainerColor,
            textColor = MaterialTheme.colorScheme.dailyTaskContentColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = imeAction)
    )
}
