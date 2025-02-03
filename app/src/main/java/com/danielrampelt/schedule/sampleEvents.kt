package com.danielrampelt.schedule

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import java.time.LocalDateTime

val sampleEvents = listOf(
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-03T00:00:00"),
        end = LocalDateTime.parse("2025-02-03T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-03T00:00:00"),
        end = LocalDateTime.parse("2025-02-03T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-03T00:00:00"),
        end = LocalDateTime.parse("2025-02-03T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-03T00:00:00"),
        end = LocalDateTime.parse("2025-02-03T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-03T00:00:00"),
        end = LocalDateTime.parse("2025-02-03T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-03T00:00:00"),
        end = LocalDateTime.parse("2025-02-03T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Allday test event",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Morning Meditation",
        color = Color(0xFF6A0572),
        start = LocalDateTime.parse("2025-01-02T07:00:00"),
        end = LocalDateTime.parse("2025-01-02T07:30:00"),
        description = "Begin the day with a calming meditation session.",
        isAllDay = false
    ),
    Event(
        name = "Grocery Shopping",
        color = Color(0xFF9B5094),
        start = LocalDateTime.parse("2025-01-02T17:00:00"),
        end = LocalDateTime.parse("2025-01-02T18:00:00"),
        description = "Stock up on weekly groceries.",
        isAllDay = false
    ),
    Event(
        name = "Workout Session",
        color = Color(0xFFECE3F0),
        start = LocalDateTime.parse("2025-01-03T06:30:00"),
        end = LocalDateTime.parse("2025-01-03T07:30:00"),
        description = "Maintain fitness with a high-energy workout session.",
        isAllDay = false
    ),
    Event(
        name = "Office Presentation",
        color = Color(0xFF4A90E2),
        start = LocalDateTime.parse("2025-01-03T10:00:00"),
        end = LocalDateTime.parse("2025-01-03T12:00:00"),
        description = "Present quarterly progress to the management team.",
        isAllDay = false
    ),
    Event(
        name = "Family Dinner",
        color = Color(0xFFFFA07A),
        start = LocalDateTime.parse("2025-01-03T19:00:00"),
        end = LocalDateTime.parse("2025-01-03T21:00:00"),
        description = "Dinner with the family at home.",
        isAllDay = false
    ),
    Event(
        name = "Weekend Hike",
        color = Color(0xFFA1C349),
        start = LocalDateTime.parse("2025-01-04T08:00:00"),
        end = LocalDateTime.parse("2025-01-04T12:00:00"),
        description = "Explore nature with a refreshing weekend hike.",
        isAllDay = false
    ),
    Event(
        name = "Book Club Meeting",
        color = Color(0xFFFFCC5C),
        start = LocalDateTime.parse("2025-01-05T15:00:00"),
        end = LocalDateTime.parse("2025-01-05T17:00:00"),
        description = "Discuss the monthly book selection with the club.",
        isAllDay = false
    ),
    Event(
        name = "Dentist Appointment",
        color = Color(0xFFDC5C5C),
        start = LocalDateTime.parse("2025-01-06T10:30:00"),
        end = LocalDateTime.parse("2025-01-06T11:00:00"),
        description = "Routine dental checkup and cleaning.",
        isAllDay = false
    ),
    Event(
        name = "Mid-Month Review",
        color = Color(0xFF8AC6D1),
        start = LocalDateTime.parse("2025-01-15T14:00:00"),
        end = LocalDateTime.parse("2025-01-15T16:00:00"),
        description = "Review the progress of monthly goals and tasks.",
        isAllDay = false
    ),
    Event(
        name = "Friend's Birthday Party",
        color = Color(0xFFF4BFBF),
        start = LocalDateTime.parse("2025-01-20T18:00:00"),
        end = LocalDateTime.parse("2025-01-20T21:00:00"),
        description = "Celebrate a friend's birthday at their place.",
        isAllDay = false
    ),
    Event(
        name = "New Year Celebration",
        color = Color(0xFFDF2935),
        start = LocalDateTime.parse("2025-01-01T00:00:00"),
        end = LocalDateTime.parse("2025-01-01T23:59:59"),
        description = "Celebrate the start of the New Year with family and friends.",
        isAllDay = true
    ),
    Event(
        name = "Morning Yoga",
        color = Color(0xFF77AADD),
        start = LocalDateTime.parse("2025-01-01T06:00:00"),
        end = LocalDateTime.parse("2025-01-01T07:00:00"),
        description = "Start the New Year with a relaxing yoga session.",
        isAllDay = false
    ),
    Event(
        name = "Brunch with Family",
        color = Color(0xFFAA6F73),
        start = LocalDateTime.parse("2025-01-01T10:00:00"),
        end = LocalDateTime.parse("2025-01-01T12:00:00"),
        description = "Enjoy a cozy New Year’s brunch with family.",
        isAllDay = false
    ),
    Event(
        name = "Afternoon Hike",
        color = Color(0xFFA1C349),
        start = LocalDateTime.parse("2025-01-01T14:00:00"),
        end = LocalDateTime.parse("2025-01-01T16:30:00"),
        description = "Kick off the year with an invigorating hike.",
        isAllDay = false
    ),
    Event(
        name = "Evening Movie",
        color = Color(0xFF957DAD),
        start = LocalDateTime.parse("2025-01-01T20:00:00"),
        end = LocalDateTime.parse("2025-01-01T22:30:00"),
        description = "Watch a New Year blockbuster movie.",
        isAllDay = false
    ),
    Event(
        name = "Work Deadline",
        color = Color(0xFFFF6F61),
        start = LocalDateTime.parse("2025-01-05T00:00:00"),
        end = LocalDateTime.parse("2025-01-05T23:59:59"),
        description = "Submit the end-of-week report.",
        isAllDay = true
    ),
    Event(
        name = "Coffee Meeting",
        color = Color(0xFF6D4C41),
        start = LocalDateTime.parse("2025-01-05T10:30:00"),
        end = LocalDateTime.parse("2025-01-05T11:30:00"),
        description = "Discuss collaboration opportunities over coffee.",
        isAllDay = false
    ),
    Event(
        name = "Team Lunch",
        color = Color(0xFFFFC107),
        start = LocalDateTime.parse("2025-01-05T12:00:00"),
        end = LocalDateTime.parse("2025-01-05T13:00:00"),
        description = "Enjoy lunch with the team.",
        isAllDay = false
    ),
    Event(
        name = "Presentation Prep",
        color = Color(0xFF64B5F6),
        start = LocalDateTime.parse("2025-01-05T14:00:00"),
        end = LocalDateTime.parse("2025-01-05T16:00:00"),
        description = "Prepare slides for next week's presentation.",
        isAllDay = false
    ),
    Event(
        name = "Workout",
        color = Color(0xFF4CAF50),
        start = LocalDateTime.parse("2025-01-05T15:30:00"),
        end = LocalDateTime.parse("2025-01-05T16:30:00"),
        description = "Hit the gym for a strength-training session.",
        isAllDay = false
    ),
    Event(
        name = "Friend's Wedding",
        color = Color(0xFFE91E63),
        start = LocalDateTime.parse("2025-01-10T14:00:00"),
        end = LocalDateTime.parse("2025-01-10T20:00:00"),
        description = "Celebrate a friend's special day.",
        isAllDay = false
    ),
    Event(
        name = "Photography Workshop",
        color = Color(0xFF9E9E9E),
        start = LocalDateTime.parse("2025-01-10T09:00:00"),
        end = LocalDateTime.parse("2025-01-10T16:00:00"),
        description = "Learn advanced techniques in outdoor photography.",
        isAllDay = false
    ),
    Event(
        name = "Morning Jog",
        color = Color(0xFF2196F3),
        start = LocalDateTime.parse("2025-01-15T06:00:00"),
        end = LocalDateTime.parse("2025-01-15T07:00:00"),
        description = "Stay active with a refreshing morning jog.",
        isAllDay = false
    ),
    Event(
        name = "Parent-Teacher Meeting",
        color = Color(0xFFFF9800),
        start = LocalDateTime.parse("2025-01-15T09:00:00"),
        end = LocalDateTime.parse("2025-01-15T10:30:00"),
        description = "Discuss your child’s progress at school.",
        isAllDay = false
    ),
    Event(
        name = "Conference",
        color = Color(0xFF673AB7),
        start = LocalDateTime.parse("2025-01-20T09:00:00"),
        end = LocalDateTime.parse("2025-01-20T23:59:59"),
        description = "Attend a professional conference for networking and learning.",
        isAllDay = false
    ),
    Event(
        name = "Lunch with Client",
        color = Color(0xFFCDDC39),
        start = LocalDateTime.parse("2025-01-20T12:30:00"),
        end = LocalDateTime.parse("2025-01-20T13:30:00"),
        description = "Discuss business opportunities over lunch.",
        isAllDay = false
    ),
    Event(
        name = "Networking Event",
        color = Color(0xFF03A9F4),
        start = LocalDateTime.parse("2025-01-20T18:00:00"),
        end = LocalDateTime.parse("2025-01-20T20:00:00"),
        description = "Connect with professionals in your industry.",
        isAllDay = false
    ),
    Event(
        name = "Family Game Night",
        color = Color(0xFFFFEB3B),
        start = LocalDateTime.parse("2025-01-25T18:00:00"),
        end = LocalDateTime.parse("2025-01-25T20:00:00"),
        description = "Spend quality time with family over board games.",
        isAllDay = false
    ),
    Event(
        name = "Monthly Planning",
        color = Color(0xFF607D8B),
        start = LocalDateTime.parse("2025-01-31T09:00:00"),
        end = LocalDateTime.parse("2025-01-31T11:00:00"),
        description = "Plan the goals and tasks for February.",
        isAllDay = false
    )

)

class EventsProvider : PreviewParameterProvider<Event> {
    override val values = sampleEvents.asSequence()
}