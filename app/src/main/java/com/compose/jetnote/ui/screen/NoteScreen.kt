package com.compose.jetnote.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.jetnote.R
import com.compose.jetnote.ui.components.NoteButton
import com.compose.jetnote.ui.components.NoteInputText
import com.compose.jetnote.utils.validateInput

@ExperimentalComposeUiApi
@Composable
fun NotesScreen() {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(R.string.app_name))
        }, actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = stringResource(R.string.icon_description)
            )
        },
            backgroundColor = Color(0xFFDADFE3)
        )

        // Content

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = title,
                label = stringResource(R.string.title),
                onTextChange = {
                    if (validateInput(it)) title = it
                }
            )
            NoteInputText(
                modifier = Modifier.padding(
                    top = 9.dp,
                    bottom = 8.dp
                ),
                text = description,
                label = stringResource(R.string.description),
                onTextChange = {
                    if (validateInput(it)) description = it
                }
            )
            NoteButton(text = stringResource(R.string.save), onClick = { })
        }
    }
}


@ExperimentalComposeUiApi
@Preview()
@Composable
fun NotesScreenPreview() {
    NotesScreen()
}