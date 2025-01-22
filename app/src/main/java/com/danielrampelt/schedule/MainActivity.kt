package com.danielrampelt.schedule

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielrampelt.schedule.ui.theme.WeekScheduleTheme
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.WeekFields
import java.util.Locale
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeekScheduleTheme{
                val deviceWidthDp = LocalConfiguration.current.screenWidthDp.dp
                Box() {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        CalView(deviceWidthDp)
                    }
                }
            }
//            WeekScheduleTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    var date by remember { mutableStateOf(LocalDate.of(2025, 1, 13)) }
//                    var events = sampleEvents.filter { !it.start.toLocalDate().isAfter(date) && !it.end.toLocalDate().isBefore(date) }
//                    Schedule(
//                        events = events,
//                        minTime = LocalTime.of(1, 0),
//                        maxTime = LocalTime.of(22, 0),
//                        daySize = ScheduleSize.Adaptive(
//                            minSize = 0.dp
//                        ),
//                        numDays = 1,
//                        date = date,
//                    )
//
//
//                    DayViewLazyRow()
//                }
//            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalView(deviceWidthDp: Dp) {
    val currentDate = LocalDate.now()

    val initialPage = 90 // the page which will be shown as the current date
    val pageCount = 100 // total amount of pages generated by the pager

    val pagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { pageCount }
    )

    val verticalScrollState = rememberScrollState()

    HorizontalPager(state = pagerState) { page ->
        val date = currentDate.plusDays((page - initialPage).toLong())
        var events = sampleEvents.filter { !it.start.toLocalDate().isAfter(date) && !it.end.toLocalDate().isBefore(date) }
        Schedule(
            events = events,
            minTime = LocalTime.of(1, 0),
            maxTime = LocalTime.of(22, 0),
            daySize = ScheduleSize.Adaptive(
                minSize = 0.dp
            ),
            numDays = 1,
            date = date,
            modifier = Modifier.width(deviceWidthDp),
            verticalScrollState = verticalScrollState,
        )
    }
}

data class Event(
    val name: String,
    val color: Color,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val description: String? = null,
    val isAllDay: Boolean = false // New property
)

inline class SplitType private constructor(val value: Int) {
    companion object {
        val None = SplitType(0)
        val Start = SplitType(1)
        val End = SplitType(2)
        val Both = SplitType(3)
    }
}

data class PositionedEvent(
    val event: Event,
    val splitType: SplitType,
    val date: LocalDate,
    val start: LocalTime,
    val end: LocalTime,
    val col: Int = 0,
    val colSpan: Int = 1,
    val colTotal: Int = 1,
)

@RequiresApi(Build.VERSION_CODES.O)
val EventTimeFormatter = DateTimeFormatter.ofPattern("h:mm a")

@RequiresApi(Build.VERSION_CODES.O)
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
            maxLines = 1,
            overflow = TextOverflow.Clip,
        )

        Text(
            text = event.name,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        if (event.description != null) {
            Text(
                text = event.description,
                style = MaterialTheme.typography.body2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private val sampleEvents = listOf(
    Event(
        name = "Morning Jog",
        color = Color(0xFFE0BBE4),
        start = LocalDateTime.parse("2025-01-13T06:30:00"),
        end = LocalDateTime.parse("2025-01-13T07:30:00"),
        description = "Start the day with a refreshing jog in the park.",
        isAllDay = false
    ),
    Event(
        name = "Team Meeting",
        color = Color(0xFF957DAD),
        start = LocalDateTime.parse("2025-01-13T09:00:00"),
        end = LocalDateTime.parse("2025-01-13T10:00:00"),
        description = "Monthly team meeting to discuss project updates and goals.",
        isAllDay = false
    ),
    Event(
        name = "Lunch with Sarah",
        color = Color(0xFFFEC8D8),
        start = LocalDateTime.parse("2025-01-13T12:00:00"),
        end = LocalDateTime.parse("2025-01-13T13:30:00"),
        description = "Catch up with Sarah over lunch at the new cafe.",
        isAllDay = false
    ),
    Event(
        name = "Project Deadline",
        color = Color(0xFFFFDFD3),
        start = LocalDateTime.parse("2025-01-13T00:00:00"),
        end = LocalDateTime.parse("2025-01-13T23:59:59"),
        description = "Final submission of the project.",
        isAllDay = true
    ),
    Event(
        name = "Evening Yoga",
        color = Color(0xFFBAED91),
        start = LocalDateTime.parse("2025-01-13T18:00:00"),
        end = LocalDateTime.parse("2025-01-13T19:00:00"),
        description = "Relax and unwind with an evening yoga session.",
        isAllDay = false
    )
)

class EventsProvider : PreviewParameterProvider<Event> {
    @RequiresApi(Build.VERSION_CODES.O)
    override val values = sampleEvents.asSequence()
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun EventPreview(
    @PreviewParameter(EventsProvider::class) event: Event,
) {
    WeekScheduleTheme {
        BasicEvent(
            PositionedEvent(event, SplitType.None, event.start.toLocalDate(), event.start.toLocalTime(), event.end.toLocalTime()),
            modifier = Modifier.sizeIn(maxHeight = 64.dp)
        )
    }
}

private class EventDataModifier(
    val positionedEvent: PositionedEvent,
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) = positionedEvent
}

private fun Modifier.eventData(positionedEvent: PositionedEvent) = this.then(EventDataModifier(positionedEvent))



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BasicDayHeader(
    date: LocalDate,
    modifier: Modifier = Modifier,
) {
    val dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
    val dayOfWeek = date.format(dayOfWeekFormatter).uppercase(Locale.ENGLISH)
    Column(
        modifier = modifier.padding(top = 14.dp, bottom = 8.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = dayOfWeek,
            color = Color(255, 130, 0)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Surface(
            shape = CircleShape,
            color = Color(255, 130, 0),
            modifier = Modifier.size(30.dp)
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun BasicDayHeaderPreview(
    date: LocalDate = LocalDate.now(),
) {
    WeekScheduleTheme {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            BasicDayHeader(date = date)
//            BasicDayHeaderOLD(day = LocalDate.now())
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentWeekNumber(
    date: LocalDate,
): Int {
    val currentDate = date
    val weekFields = WeekFields.of(Locale.getDefault())
    return currentDate.get(weekFields.weekOfWeekBasedYear())
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleHeader(
    dayWidth: Dp,
    events: List<Event>,
    modifier: Modifier = Modifier,
    dayHeader: @Composable (date: LocalDate) -> Unit = { BasicDayHeader(date = it) },
    sideBarWidth: Int,
    date: LocalDate,
    ) {

    var enabled by remember { mutableStateOf(false) }

    val allDayEvents by remember(events, date) {
        mutableStateOf(events.filter { it.isAllDay && !it.start.toLocalDate().isAfter(date) && !it.end.toLocalDate().isBefore(date) })
    }

    val expandedHeight = (allDayEvents.size * 29).dp

    val defaultHeight = when (allDayEvents.size) {
        0 -> 0.dp
        1 -> 32.dp
        2 -> 64.dp
        else -> 72.dp
    }
    val animationDuration = 800 // Duration in milliseconds
    val menuHeight: Dp by animateDpAsState(
        targetValue = if (enabled) expandedHeight else defaultHeight,
        animationSpec = tween(durationMillis = animationDuration)
    )
    val rotation: Float by animateFloatAsState(
        targetValue = if (enabled) 180f else 0f,
        animationSpec = tween(durationMillis = animationDuration)
    )

    Column {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .height(IntrinsicSize.Max)
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(start = 8.dp, end = 0.dp).fillMaxHeight()
            ) {
                Text(
                    getCurrentWeekNumber(date = date,).toString(),
                    fontSize = 55.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally).width(65.dp),
                )
                if (allDayEvents.size > 2) {
                    IconButton(onClick = { enabled = !enabled }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Back",
                            modifier = Modifier.rotate(rotation)
                        )
                    }
                }
            }


            Column(modifier = modifier) {
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
                        val currentDate = date.plusDays(i.toLong())
                        val allDayEvents = events.filter { it.isAllDay && it.start.toLocalDate() == date }

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
                                            .clickable { Log.d("Schedule", "Clicked on ${event.name}") }
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
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun ScheduleHeaderPreview() {
//    WeekScheduleTheme {
//        ScheduleHeader(
//            minDate = LocalDate.now(),
//            maxDate = LocalDate.now().plusDays(5),
//            dayWidth = 256.dp,
//        )
//    }
//}

@RequiresApi(Build.VERSION_CODES.O)
private val HourFormatter = DateTimeFormatter.ofPattern("h:mm a")

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BasicSidebarLabel(
    time: LocalTime,
    modifier: Modifier = Modifier,
) {
    Text(
        text = time.format(HourFormatter),
        modifier = modifier
            .fillMaxHeight()
            .padding(4.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun BasicSidebarLabelPreview() {
    WeekScheduleTheme {
        BasicSidebarLabel(time = LocalTime.NOON, Modifier.sizeIn(maxHeight = 64.dp))
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleSidebar(
    hourHeight: Dp,
    modifier: Modifier = Modifier,
    minTime: LocalTime = LocalTime.MIN,
    maxTime: LocalTime = LocalTime.MAX,
    label: @Composable (time: LocalTime) -> Unit = { BasicSidebarLabel(time = it) },
    date: LocalDate,
) {
    val numMinutes = ChronoUnit.MINUTES.between(minTime, maxTime).toInt() + 1
    val numHours = numMinutes / 60
    val firstHour = minTime.truncatedTo(ChronoUnit.HOURS)
    val firstHourOffsetMinutes = if (firstHour == minTime) 0 else ChronoUnit.MINUTES.between(minTime, firstHour.plusHours(1))
    val firstHourOffset = hourHeight * (firstHourOffsetMinutes / 60f)
    val startTime = if (firstHour == minTime) firstHour else firstHour.plusHours(1)
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(firstHourOffset))
        repeat(numHours) { i ->
            Box(modifier = Modifier.height(hourHeight)) {
                label(startTime.plusHours(i.toLong()))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ScheduleSidebarPreview() {
    WeekScheduleTheme {
        ScheduleSidebar(
            hourHeight = 64.dp,
            date = LocalDate.now(),
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun splitEvents(events: List<Event>): List<PositionedEvent> {
    return events
        .map { event ->
            val startDate = event.start.toLocalDate()
            val endDate = event.end.toLocalDate()
            if (startDate == endDate) {
                listOf(PositionedEvent(event, SplitType.None, event.start.toLocalDate(), event.start.toLocalTime(), event.end.toLocalTime()))
            } else {
                val days = ChronoUnit.DAYS.between(startDate, endDate)
                val splitEvents = mutableListOf<PositionedEvent>()
                for (i in 0..days) {
                    val date = startDate.plusDays(i)
                    splitEvents += PositionedEvent(
                        event,
                        splitType = if (date == startDate) SplitType.End else if (date == endDate) SplitType.Start else SplitType.Both,
                        date = date,
                        start = if (date == startDate) event.start.toLocalTime() else LocalTime.MIN,
                        end = if (date == endDate) event.end.toLocalTime() else LocalTime.MAX,
                    )
                }
                splitEvents
            }
        }
        .flatten()
}

@RequiresApi(Build.VERSION_CODES.O)
private fun PositionedEvent.overlapsWith(other: PositionedEvent): Boolean {
    return date == other.date && start < other.end && end > other.start
}

@RequiresApi(Build.VERSION_CODES.O)
private fun List<PositionedEvent>.timesOverlapWith(event: PositionedEvent): Boolean {
    return any { it.overlapsWith(event) }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun arrangeEvents(events: List<PositionedEvent>): List<PositionedEvent> {
    val positionedEvents = mutableListOf<PositionedEvent>()
    val groupEvents: MutableList<MutableList<PositionedEvent>> = mutableListOf()

    fun resetGroup() {
        groupEvents.forEachIndexed { colIndex, col ->
            col.forEach { e ->
                positionedEvents.add(e.copy(col = colIndex, colTotal = groupEvents.size))
            }
        }
        groupEvents.clear()
    }

    events.forEach { event ->
        var firstFreeCol = -1
        var numFreeCol = 0
        for (i in 0 until groupEvents.size) {
            val col = groupEvents[i]
            if (col.timesOverlapWith(event)) {
                if (firstFreeCol < 0) continue else break
            }
            if (firstFreeCol < 0) firstFreeCol = i
            numFreeCol++
        }

        when {
            // Overlaps with all, add a new column
            firstFreeCol < 0 -> {
                groupEvents += mutableListOf(event)
                // Expand anything that spans into the previous column and doesn't overlap with this event
                for (ci in 0 until groupEvents.size - 1) {
                    val col = groupEvents[ci]
                    col.forEachIndexed { ei, e ->
                        if (ci + e.colSpan == groupEvents.size - 1 && !e.overlapsWith(event)) {
                            col[ei] = e.copy(colSpan = e.colSpan + 1)
                        }
                    }
                }
            }
            // No overlap with any, start a new group
            numFreeCol == groupEvents.size -> {
                resetGroup()
                groupEvents += mutableListOf(event)
            }
            // At least one column free, add to first free column and expand to as many as possible
            else -> {
                groupEvents[firstFreeCol] += event.copy(colSpan = numFreeCol)
            }
        }
    }
    resetGroup()
    return positionedEvents
}

sealed class ScheduleSize {
    class FixedSize(val size: Dp) : ScheduleSize()
    class FixedCount(val count: Float) : ScheduleSize() {
        constructor(count: Int) : this(count.toFloat())
    }
    class Adaptive(val minSize: Dp) : ScheduleSize()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Schedule(
    events: List<Event>,
    modifier: Modifier = Modifier,
    eventContent: @Composable (positionedEvent: PositionedEvent) -> Unit = { BasicEvent(positionedEvent = it) },
    dayHeader: @Composable (day: LocalDate) -> Unit = { BasicDayHeader(date = it) },
    timeLabel: @Composable (time: LocalTime) -> Unit = { BasicSidebarLabel(time = it) },
    numDays: Int = 1,
    minTime: LocalTime = LocalTime.MIN,
    maxTime: LocalTime = LocalTime.MAX,
    daySize: ScheduleSize = ScheduleSize.FixedSize(256.dp),
    hourSize: ScheduleSize = ScheduleSize.FixedSize(64.dp),
    date: LocalDate,
    verticalScrollState: ScrollState,
) {
    val minDate = date
    val maxDate = date
    val numMinutes = ChronoUnit.MINUTES.between(minTime, maxTime).toInt() + 1
    val numHours = numMinutes.toFloat() / 60f

//    val horizontalScrollState = rememberScrollState()
    var sidebarWidth by remember { mutableStateOf(0) }
    var headerHeight by remember { mutableStateOf(0) }
    val density = LocalDensity.current

    BoxWithConstraints(
        modifier = modifier
    ) {
        val dayWidth: Dp = when (daySize) {
            is ScheduleSize.FixedSize -> daySize.size
            is ScheduleSize.FixedCount -> with(density) { ((constraints.maxWidth - sidebarWidth) / daySize.count).toDp() }
            is ScheduleSize.Adaptive -> with(density) { maxOf(((constraints.maxWidth - sidebarWidth) / numDays).toDp(), daySize.minSize) }
        }
        val hourHeight: Dp = when (hourSize) {
            is ScheduleSize.FixedSize -> hourSize.size
            is ScheduleSize.FixedCount -> with(density) { ((constraints.maxHeight - headerHeight) / hourSize.count).toDp() }
            is ScheduleSize.Adaptive -> with(density) { maxOf(((constraints.maxHeight - headerHeight) / numHours).toDp(), hourSize.minSize) }
        }

        val nonAllDayEvents = events.filterNot(Event::isAllDay)

//        LaunchedEffect(Unit) {
//            horizontalScrollState.scrollTo(0)
//        }

        Column(modifier = modifier) {
            ScheduleHeader(
                dayWidth = dayWidth,
                events = events,
                dayHeader = dayHeader,
                modifier = Modifier
//                    .horizontalScroll(horizontalScrollState)
                    .onGloballyPositioned { headerHeight = it.size.height },
                sideBarWidth = sidebarWidth,
                date = date,
            )
            Row(modifier = Modifier
                .weight(1f)
                .align(Alignment.Start)) {
                ScheduleSidebar(
                    hourHeight = hourHeight,
                    minTime = minTime,
                    maxTime = maxTime,
                    label = timeLabel,
                    date = date,
                    modifier = Modifier
                        .verticalScroll(verticalScrollState)
                        .onGloballyPositioned { sidebarWidth = it.size.width }
                )
                BasicSchedule(
                    events = nonAllDayEvents,
                    eventContent = eventContent,
                    minTime = minTime,
                    maxTime = maxTime,
                    dayWidth = dayWidth,
                    hourHeight = hourHeight,
                    date = date,
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(verticalScrollState)
//                        .horizontalScroll(horizontalScrollState)
                        .padding(top = 16.dp),
                    verticalScrollState = verticalScrollState,
//                    horizontalScrollState = horizontalScrollState,
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BasicSchedule(
    events: List<Event>,
    modifier: Modifier = Modifier,
    eventContent: @Composable (positionedEvent: PositionedEvent) -> Unit = { BasicEvent(positionedEvent = it) },
    minTime: LocalTime = LocalTime.MIN,
    maxTime: LocalTime = LocalTime.MAX,
    dayWidth: Dp,
    hourHeight: Dp,
    date: LocalDate,
    verticalScrollState: ScrollState,
) {
    val numDays = ChronoUnit.DAYS.between(date, date).toInt() + 1
    val numMinutes = ChronoUnit.MINUTES.between(minTime, maxTime).toInt() + 1
    val numHours = numMinutes / 60
    val dividerColor = if (MaterialTheme.colors.isLight) Color.LightGray else Color.DarkGray
    val positionedEvents = remember(events) { arrangeEvents(splitEvents(events.sortedBy(Event::start))).filter { it.end > minTime && it.start < maxTime } }
    var dummyEvent by remember { mutableStateOf<PositionedEvent?>(null) }
    val density = LocalDensity.current

    // State to trigger recomposition every minute
    var currentTime by remember { mutableStateOf(LocalTime.now()) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(15000) // refresh clock every 15 seconds
            currentTime = LocalTime.now()
        }
    }

    Layout(
        content = {
            positionedEvents.forEach { positionedEvent ->
                Box(modifier = Modifier
                    .eventData(positionedEvent)
                    .clickable {
                        Log.d(
                            "BasicSchedule",
                            "Event clicked: ${positionedEvent.event.name}"
                        )
                    }) {
                    eventContent(positionedEvent)
                }
            }
            dummyEvent?.let {
                Box(modifier = Modifier
                    .clip(shape = RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .eventData(it)
                    .background(Color.Red)
                    .clickable { Log.d("BasicSchedule", "Dummy event clicked: ${it.event.name}") }) {
                    Text("+ new event", color = Color.White, modifier = Modifier.padding(4.dp))
                }
            }
        },
        modifier = modifier
            .drawBehind {
                val firstHour = minTime.truncatedTo(ChronoUnit.HOURS)
                val firstHourOffsetMinutes =
                    if (firstHour == minTime) 0 else ChronoUnit.MINUTES.between(
                        minTime,
                        firstHour.plusHours(1)
                    )
                val firstHourOffset = with(density) { (firstHourOffsetMinutes / 60f) * hourHeight.toPx() }
                repeat(numHours) { // Adjusted to include the last hour
                    drawLine(
                        dividerColor,
                        start = Offset(
                            0f,
                            it * with(density) { hourHeight.toPx() } + firstHourOffset),
                        end = Offset(
                            size.width,
                            it * with(density) { hourHeight.toPx() } + firstHourOffset),
                        strokeWidth = with(density) { 1.dp.toPx() }
                    )
                }
                repeat(numDays) {
                    drawLine(
                        dividerColor,
                        start = Offset((it + 1) * with(density) { dayWidth.toPx() }, 0f),
                        end = Offset((it + 1) * with(density) { dayWidth.toPx() }, size.height),
                        strokeWidth = with(density) { 1.dp.toPx() }
                    )
                }
            }
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val clickedY = offset.y
                    val clickedX = offset.x
                    Log.d("BasicSchedule", "Clicked position: x=$clickedX, y=$clickedY")
                    val clickedTime =
                        minTime.plusMinutes((clickedY / with(density) { hourHeight.toPx() } * 60).toLong())
                    val clickedDate =
                        date.plusDays((clickedX / with(density) { dayWidth.toPx() }).toLong())
                    Log.d("BasicSchedule", "Clicked time: $clickedTime, Clicked date: $clickedDate")
                    val nearestHour = clickedTime.truncatedTo(ChronoUnit.HOURS)
                    dummyEvent = PositionedEvent(
                        event = Event(
                            name = "Create new event",
                            color = Color.Gray,
                            start = LocalDateTime.of(clickedDate, nearestHour),
                            end = LocalDateTime.of(clickedDate, nearestHour.plusHours(1))
                        ),
                        splitType = SplitType.None,
                        date = clickedDate,
                        start = nearestHour,
                        end = nearestHour.plusHours(1)
                    )
                    Log.d("BasicSchedule", "Dummy event created: $dummyEvent")
                }
            }
            .drawWithContent {
                drawContent()
                // Draw current time line
                if (currentTime.isAfter(minTime) && currentTime.isBefore(maxTime)) {
                    val currentTimeOffset = with(density) {
                        ChronoUnit.MINUTES
                            .between(minTime, currentTime)
                            .toFloat() / 60f * hourHeight.toPx()
                    }
                    drawLine(
                        color = Color.Black,
                        start = Offset(0f, currentTimeOffset),
                        end = Offset(size.width, currentTimeOffset),
                        strokeWidth = with(density) { 1.dp.toPx() }
                    )
                    drawCircle(
                        color = Color.Black,
                        radius = with(density) { 4.dp.toPx() },
                        center = Offset(with(density) { 4.dp.toPx() }, currentTimeOffset) // Adjusted offset
                    )
                }
            }
    ) { measureables, constraints ->
        val height = with(density) { (hourHeight.toPx() * (numHours)).roundToInt() - 16.dp.toPx()}  // Adjusted the height to make sure it doesnt go too far
        val width = with(density) { dayWidth.roundToPx() * numDays }
        Log.d("BasicSchedule", "Layout size: width=$width, height=$height")
        val placeablesWithEvents = measureables.map { measurable ->
            val splitEvent = measurable.parentData as PositionedEvent
            val eventDurationMinutes = ChronoUnit.MINUTES.between(splitEvent.start, minOf(splitEvent.end, maxTime))
            val eventHeight = with(density) { ((eventDurationMinutes / 60f) * hourHeight.toPx()).roundToInt() }
            val eventWidth = with(density) { ((splitEvent.colSpan.toFloat() / splitEvent.colTotal.toFloat()) * dayWidth.toPx()).roundToInt() }
            val placeable = measurable.measure(constraints.copy(minWidth = eventWidth, maxWidth = eventWidth, minHeight = eventHeight, maxHeight = eventHeight))
            Log.d("BasicSchedule", "Measured event: ${splitEvent.event.name}, width=$eventWidth, height=$eventHeight")
            Pair(placeable, splitEvent)
        }
        layout(width, height.toInt()) {
            placeablesWithEvents.forEach { (placeable, splitEvent) ->
                val eventOffsetMinutes = if (splitEvent.start > minTime) ChronoUnit.MINUTES.between(minTime, splitEvent.start) else 0
                val eventY = with(density) { ((eventOffsetMinutes / 60f) * hourHeight.toPx()).roundToInt() }
                val eventOffsetDays = ChronoUnit.DAYS.between(date, splitEvent.date).toInt()
                val eventX = with(density) { eventOffsetDays * dayWidth.roundToPx() + (splitEvent.col * (dayWidth.toPx() / splitEvent.colTotal.toFloat())).roundToInt() }
                Log.d("BasicSchedule", "Placing event: ${splitEvent.event.name}, x=$eventX, y=$eventY")
                placeable.place(eventX, eventY)
            }
        }
    }

    LaunchedEffect(dummyEvent) {
        if (dummyEvent != null) {
            delay(5000)
            Log.d("BasicSchedule", "Dummy event cleared")
            dummyEvent = null
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//@Preview(showBackground = true)
//@Composable
//fun SchedulePreview() {
//    WeekScheduleTheme {
//        Schedule(
//            sampleEvents,
//            date = LocalDate.of(2024, 12, 8),
//        )
//    }
//}
