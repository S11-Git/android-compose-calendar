package com.danielrampelt.schedule.components

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielrampelt.schedule.Event
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.WeekFields
import java.util.Locale

@Composable
fun BasicDayHeader(
    date: LocalDate,
    modifier: Modifier = Modifier,
) {
    val dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
    val dayOfWeek = date.format(dayOfWeekFormatter).uppercase(Locale.ENGLISH)
    val dateNow = LocalDate.now()
    val colorBackground = if (dateNow == date) Color(255, 130, 0) else Color.Transparent
    val colorTextDay = if (dateNow == date) Color(255, 130, 0) else Color.DarkGray
    val colorTextDayNumber = if (dateNow == date) Color.White else Color.Black

    Column(
        modifier = modifier
            .padding(top = 14.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = dayOfWeek,
            color = colorTextDay,
        )
        Spacer(modifier = Modifier.height(2.dp))
        Surface(
            shape = CircleShape,
            color = colorBackground,
            modifier = Modifier.size(28.dp)
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorTextDayNumber,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}


@Composable
fun ScheduleHeaderDaySection(
    dayWidth: Dp,
    events: List<Event>,
    modifier: Modifier = Modifier,
    dayHeader: @Composable (date: LocalDate) -> Unit = { BasicDayHeader(date = it) },
    date: LocalDate,
    menuHeight: Dp,
) {

    Column(modifier = modifier.width(dayWidth), verticalArrangement = Arrangement.Top) {
        // Day headers
        Row(modifier = Modifier.fillMaxWidth()) {
            val numDays = ChronoUnit.DAYS.between(date, date).toInt() + 1
            repeat(numDays) { i ->
                Box(modifier = Modifier.width(dayWidth)) {
                    dayHeader(date.plusDays(i.toLong()))
                }
            }
        }
        // All-day events bar
        Row(modifier = Modifier.fillMaxWidth()) {
            val numDays = ChronoUnit.DAYS.between(date, date).toInt() + 1
            repeat(numDays) { i ->
                date.plusDays(i.toLong())
                val allDayEvents = events.filter { it.isAllDay && it.start.toLocalDate() == date }
                val context = LocalContext.current

                Box(modifier = Modifier.width(dayWidth)) {
                    Column(modifier = Modifier.height(menuHeight).padding(bottom = 4.dp)) {
                        allDayEvents.forEach { event ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(2.dp)
                                    .background(
                                        event.color,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                                    .padding(4.dp)
                                    .clickable {
                                        Toast.makeText(
                                            context,
                                            "Clicked on ${event.name}",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                            ) {
                                Text(
                                    text = event.name,
                                    style = MaterialTheme.typography.caption,
                                    color = Color.White,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

fun getCurrentWeekNumber(date: LocalDate): Int {
    val systemLocale = Locale.getDefault(Locale.Category.FORMAT)
    val weekFields = WeekFields.of(systemLocale)
    val weekNumber = date.get(weekFields.weekOfWeekBasedYear())
    return weekNumber
}


@Composable
fun ScheduleHeaderWeekSection(
    date: LocalDate,
    allDayEventsExceedThree: Boolean,
    onClick: () -> Unit,
    menuHeight: Dp,
) {
    var enabled by remember { mutableStateOf(false) }

    val animationDuration = 800 // Duration in milliseconds
    val rotation: Float by animateFloatAsState(
        targetValue = if (enabled) 180f else 0f,
        animationSpec = tween(durationMillis = animationDuration)
    )

    val weekNumberCount = getCurrentWeekNumber(date = date).toString().length
    val FontSize = if (weekNumberCount > 1) 35.sp else 64.sp

    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.width(43.dp).height(72.dp + menuHeight)
    ) {
        Text(
            getCurrentWeekNumber(date = date).toString(),
            fontSize = FontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        if (allDayEventsExceedThree) {
            IconButton(onClick = {
                onClick()
                enabled = !enabled
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Back",
                    modifier = Modifier.rotate(rotation)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BasicDayHeaderPreview(
//    date: LocalDate = LocalDate.now(),
//) {
//    WeekScheduleTheme {
//        BasicDayHeader(date = date)
//            BasicDayHeaderOLD(day = LocalDate.now())
//    }
//}
