package com.compose.jetnote.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetnote.R
import com.compose.jetnote.data.model.Note
import com.compose.jetnote.data.source.NoteDataSource
import com.compose.jetnote.ui.components.NoteButton
import com.compose.jetnote.ui.components.NoteInputText
import com.compose.jetnote.ui.components.NoteRow
import com.compose.jetnote.ui.theme.Grey200
import com.compose.jetnote.utils.Dimens
import com.compose.jetnote.utils.validateInput

@ExperimentalComposeUiApi
@Composable
fun NotesScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(Dimens.PADDING_6.value)) {
        TopAppBar(title = {
            Text(text = stringResource(R.string.app_name))
        }, actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = stringResource(R.string.icon_description)
            )
        },
            backgroundColor = Grey200
        )

        // Content

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier.padding(
                    top = Dimens.PADDING_9.value,
                    bottom = Dimens.PADDING_8.value
                ),
                text = title,
                label = stringResource(R.string.title),
                onTextChange = {
                    if (validateInput(it)) title = it
                }
            )
            NoteInputText(
                modifier = Modifier.padding(
                    top = Dimens.PADDING_9.value,
                    bottom = Dimens.PADDING_8.value
                ),
                text = description,
                label = stringResource(R.string.description),
                onTextChange = {
                    if (validateInput(it)) description = it
                }
            )
            NoteButton(text = stringResource(R.string.save), onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    onAddNote(Note(title = title, description = description))
                    title = ""
                    description = ""
                    Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                }
            })
        }
        Divider(Modifier.padding(Dimens.PADDING_10.value))
        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note, onNoteClicked = {
                    onRemoveNote(it)
                })
            }
        }

    }
}


@ExperimentalComposeUiApi
@Preview
@Composable
fun NotesScreenPreview() {
    NotesScreen(NoteDataSource().loadNotes(), {}, {})
}