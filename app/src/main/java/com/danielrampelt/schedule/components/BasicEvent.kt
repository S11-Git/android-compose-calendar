package com.danielrampelt.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.danielrampelt.schedule.PositionedEvent
import com.danielrampelt.schedule.SplitType
import java.time.format.DateTimeFormatter

private val EventTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

@Composable
fun BasicEvent(
    positionedEvent: PositionedEvent,
    modifier: Modifier = Modifier,
) {
    val event = positionedEvent.event
    val topRadius = if (positionedEvent.splitType == SplitType.Start || positionedEvent.splitType == SplitType.Both) 0.dp else 4.dp
    val bottomRadius = if (positionedEvent.splitType == SplitType.End || positionedEvent.splitType == SplitType.Both) 0.dp else 4.dp
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                end = 2.dp,
                bottom = if (positionedEvent.splitType == SplitType.End) 0.dp else 2.dp
            )
            .clipToBounds()
            .background(
                event.color,
                shape = RoundedCornerShape(
                    topStart = topRadius,
                    topEnd = topRadius,
                    bottomEnd = bottomRadius,
                    bottomStart = bottomRadius,
                )
            )
            .padding(4.dp)
    ) {
        Text(
            text = "${event.start.format(EventTimeFormatter)} - ${event.end.format(EventTimeFormatter)}",
            style = MaterialTheme.typography.caption,
//            maxLines = 1,
            overflow = TextOverflow.Clip,
        )

        Text(
            text = event.name,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
//            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        if (event.description != null) {
            Text(
                text = event.description,
                style = MaterialTheme.typography.body2,
//                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EventPreview(
//    @PreviewParameter(EventsProvider::class) event: Event,
//) {
//    WeekScheduleTheme {
//        BasicEvent(
//            PositionedEvent(event, SplitType.None, event.start.toLocalDate(), event.start.toLocalTime(), event.end.toLocalTime()),
//            modifier = Modifier.sizeIn(maxHeight = 64.dp)
//        )
//    }
//}