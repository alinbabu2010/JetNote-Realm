package com.compose.jetnote.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.compose.jetnote.data.model.Note
import com.compose.jetnote.ui.theme.Grey100
import com.compose.jetnote.utils.Dimens
import com.compose.jetnote.utils.getFormattedDate

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier
            .padding(Dimens.PADDING_4.value)
            .clip(RoundedCornerShape(topEnd = Dimens.CORNER_33.value))
            .fillMaxWidth(),
        color = Grey100, elevation = Dimens.ELEVATION_6.value
    ) {

        Column(
            modifier
                .clickable { onNoteClicked(note) }
                .padding(horizontal = Dimens.PADDING_14.value, vertical = Dimens.PADDING_6.value),
            horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
            Text(text = getFormattedDate(note.entryDate), style = MaterialTheme.typography.body1)
        }

    }
}