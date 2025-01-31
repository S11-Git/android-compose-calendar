package com.danielrampelt.schedule

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import java.time.LocalDateTime
import kotlin.random.Random

val sampleEvents = listOf(
    Event(
        name = "Board Game Night",
        color = Color(0xFF4CAF50),
        start = LocalDateTime.parse("2025-01-26T19:00:00"),
        end = LocalDateTime.parse("2025-01-26T22:00:00"),
        description = "Gather with friends for an evening of fun board games.",
        isAllDay = false
    ),
    Event(
        name = "Weekend Hike",
        color = Color(0xFF00BCD4),
        start = LocalDateTime.parse("2025-01-27T09:00:00"),
        end = LocalDateTime.parse("2025-01-27T15:00:00"),
        description = "Explore the local trails and enjoy the fresh air.",
        isAllDay = false
    ),
    Event(
        name = "Movie Marathon",
        color = Color(0xFFFF9800),
        start = LocalDateTime.parse("2025-01-28T14:00:00"),
        end = LocalDateTime.parse("2025-01-28T20:00:00"),
        description = "Watch a series of your favorite movies back-to-back.",
        isAllDay = false
    ),
    Event(
        name = "Grocery Shopping",
        color = Color(0xFF9C27B0),
        start = LocalDateTime.parse("2025-01-29T10:00:00"),
        end = LocalDateTime.parse("2025-01-29T11:00:00"),
        description = "Stock up on essentials for the week.",
        isAllDay = false
    ),
    Event(
        name = "Work Meeting",
        color = Color(0xFF2196F3),
        start = LocalDateTime.parse("2025-01-30T09:00:00"),
        end = LocalDateTime.parse("2025-01-30T10:00:00"),
        description = "Discuss project updates and upcoming tasks.",
        isAllDay = false
    ),
    Event(
        name = "Doctor's Appointment",
        color = Color(0xFFE91E63),
        start = LocalDateTime.parse("2025-01-31T11:00:00"),
        end = LocalDateTime.parse("2025-01-31T11:30:00"),
        description = "Regular check-up with the doctor.",
        isAllDay = false
    ),
    Event(
        name = "Valentine's Day Shopping",
        color = Color(0xFFFF4081),
        start = LocalDateTime.parse("2025-02-01T15:00:00"),
        end = LocalDateTime.parse("2025-02-01T17:00:00"),
        description = "Find the perfect gifts for loved ones.",
        isAllDay = false
    ),
    Event(
        name = "Weekend Getaway",
        color = Color(0xFF009688),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-02T23:59:59"),
        description = "Escape for a relaxing weekend trip.",
        isAllDay = true
    ),
    Event(
        name = "Birthday Party",
        color = Color(0xFFFFEB3B),
        start = LocalDateTime.parse("2025-02-02T16:00:00"),
        end = LocalDateTime.parse("2025-02-02T20:00:00"),
        description = "Celebrate a friend's birthday with cake and fun.",
        isAllDay = false
    ),
    Event(
        name = "Family Gathering",
        color = Color(0xFF673AB7),
        start = LocalDateTime.parse("2025-01-28T00:00:00"),
        end = LocalDateTime.parse("2025-01-28T23:59:59"),
        description = "Spend quality time with family.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Cleaning Day",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-01-29T00:00:00"),
        end = LocalDateTime.parse("2025-01-29T23:59:59"),
        description = "Tidy up the house and get things organized.",
        isAllDay = true
    ),
    Event(
        name = "Reading Time",
        color = Color(0xFF3F51B5),
        start = LocalDateTime.parse("2025-01-30T18:00:00"),
        end = LocalDateTime.parse("2025-01-30T19:00:00"),
        description = "Relax and enjoy a good book.",
        isAllDay = false
    ),
    Event(
        name = "Reading Time",
        color = Color(0xFF3F51B5),
        start = LocalDateTime.parse("2025-02-06T18:00:00"),
        end = LocalDateTime.parse("2025-02-06T19:00:00"),
        description = "Relax and enjoy a good book.",
        isAllDay = false
    ),
    Event(
        name = "Gym Workout",
        color = Color(0xFFF44336),
        start = LocalDateTime.parse("2025-01-31T07:00:00"),
        end = LocalDateTime.parse("2025-01-31T08:00:00"),
        description = "Stay active and maintain a healthy lifestyle.",
        isAllDay = false
    ),
    Event(
        name = "Coffee with Friends",
        color = Color(0xFF795548),
        start = LocalDateTime.parse("2025-02-02T11:00:00"),
        end = LocalDateTime.parse("2025-02-02T12:00:00"),
        description = "Catch up with friends over a cup of coffee.",
        isAllDay = false
    )
)

// Function to generate random events
fun generateRandomEvents(startDate: LocalDateTime, endDate: LocalDateTime): List<Event> {
    val events = mutableListOf<Event>()
    val random = Random(System.currentTimeMillis())
    val allDayEventNames = listOf("National Holiday", "Conference", "Yoga Retreat", "All-Day Workshop", "Annual Festival")
    val timedEventNames = listOf("Morning Jog", "Team Meeting", "Lunch Break", "Workout Session", "Evening Walk", "Dinner with Friends", "Networking Event")
    val colors = listOf(
        Color(0xFFFF6F61), Color(0xFF4CAF50), Color(0xFF64B5F6),
        Color(0xFFFFEB3B), Color(0xFF673AB7), Color(0xFF957DAD),
        Color(0xFFA1C349), Color(0xFFFFA07A)
    )

    var currentDate = startDate
    while (!currentDate.isAfter(endDate)) {
        // Generate 1 to 10 all-day events per day
        val numberOfAllDayEvents = random.nextInt(1, 11)
        for (i in 1..numberOfAllDayEvents) {
            val allDayEvent = Event(
                name = allDayEventNames[random.nextInt(allDayEventNames.size)],
                color = colors[random.nextInt(colors.size)],
                start = currentDate.withHour(0).withMinute(0).withSecond(0),
                end = currentDate.withHour(23).withMinute(59).withSecond(59),
                description = "A full-day event to mark the occasion.",
                isAllDay = true
            )
            events.add(allDayEvent)
        }

        // Generate 1 to 9 additional timed events for the day
        val numberOfTimedEvents = random.nextInt(1, 10)
        for (i in 1..numberOfTimedEvents) {
            val startHour = random.nextInt(0, 23)
            val startMinute = random.nextInt(0, 60)
            val durationHours = random.nextInt(1, 4)
            val durationMinutes = random.nextInt(0, 60)
            val endHour = (startHour + durationHours) % 24
            val endMinute = (startMinute + durationMinutes) % 60

            val startDateTime = currentDate.withHour(startHour).withMinute(startMinute)
            val endDateTime = currentDate.withHour(endHour).withMinute(endMinute)

            val timedEvent = Event(
                name = timedEventNames[random.nextInt(timedEventNames.size)],
                color = colors[random.nextInt(colors.size)],
                start = startDateTime,
                end = if (endDateTime.isAfter(startDateTime)) endDateTime else startDateTime.plusHours(1),
                description = "A scheduled event to stay productive.",
                isAllDay = false
            )
            events.add(timedEvent)
        }

        currentDate = currentDate.plusDays(1)
    }

    return events
}

class EventsProvider : PreviewParameterProvider<Event> {
    override val values = sampleEvents.asSequence()
}