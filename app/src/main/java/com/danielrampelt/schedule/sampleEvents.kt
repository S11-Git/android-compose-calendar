package com.danielrampelt.schedule

import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random


var sampleEvents = mutableListOf(
    Event(
        name = "Weekend Getaway",
        color = Color(0xFF009688),
        start = LocalDateTime.parse("2025-02-01T00:00:00"),
        end = LocalDateTime.parse("2025-02-02T23:59:59"),
        description = "Escape for a relaxing weekend trip.",
        isAllDay = true
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
        name = "Family Brunch",
        color = Color(0xFFFFC107),
        start = LocalDateTime.parse("2025-02-02T10:00:00"),
        end = LocalDateTime.parse("2025-02-02T12:00:00"),
        description = "Enjoy a relaxed brunch with family.",
        isAllDay = false
    ),
    Event(
        name = "Book Club Meeting",
        color = Color(0xFF9C27B0),
        start = LocalDateTime.parse("2025-02-02T18:00:00"),
        end = LocalDateTime.parse("2025-02-02T20:00:00"),
        description = "Discuss this month's book selection.",
        isAllDay = false
    ),
    Event(
        name = "Morning Yoga Session",
        color = Color(0xFF4CAF50),
        start = LocalDateTime.parse("2025-02-03T07:00:00"),
        end = LocalDateTime.parse("2025-02-03T08:00:00"),
        description = "Start the week with a refreshing yoga session.",
        isAllDay = false
    ),
    Event(
        name = "Project Team Meeting",
        color = Color(0xFF3F51B5),
        start = LocalDateTime.parse("2025-02-03T10:00:00"),
        end = LocalDateTime.parse("2025-02-03T11:00:00"),
        description = "Discuss project progress and next steps.",
        isAllDay = false
    ),
    Event(
        name = "Grocery Shopping",
        color = Color(0xFFE64A19),
        start = LocalDateTime.parse("2025-02-03T17:00:00"),
        end = LocalDateTime.parse("2025-02-03T18:00:00"),
        description = "Stock up on weekly groceries.",
        isAllDay = false
    ),
    Event(
        name = "Client Presentation Prep",
        color = Color(0xFFFF9800),
        start = LocalDateTime.parse("2025-02-04T09:00:00"),
        end = LocalDateTime.parse("2025-02-04T12:00:00"), // Increased duration to 3 hours
        description = "Finalize slides for the client presentation.",
        isAllDay = false
    ),
    Event(
        name = "Dentist Appointment",
        color = Color(0xFF00BCD4),
        start = LocalDateTime.parse("2025-02-04T14:00:00"),
        end = LocalDateTime.parse("2025-02-04T15:00:00"), // Increased duration to 1 hour
        description = "Regular dental check-up.",
        isAllDay = false
    ),
    Event(
        name = "Evening Run",
        color = Color(0xFF795548),
        start = LocalDateTime.parse("2025-02-04T18:30:00"),
        end = LocalDateTime.parse("2025-02-04T19:30:00"),
        description = "Enjoy a refreshing evening run.",
        isAllDay = false
    ),
    Event(
        name = "Team Lunch",
        color = Color(0xFF607D8B),
        start = LocalDateTime.parse("2025-02-05T12:30:00"),
        end = LocalDateTime.parse("2025-02-05T13:30:00"),
        description = "Lunch with the project team.",
        isAllDay = false
    ),
    Event(
        name = "Workshop: Time Management",
        color = Color(0xFF00796B),
        start = LocalDateTime.parse("2025-02-05T15:00:00"),
        end = LocalDateTime.parse("2025-02-05T17:00:00"),
        description = "Attend a workshop on improving time management skills.",
        isAllDay = false
    ),
    Event(
        name = "Pick up Dry Cleaning",
        color = Color(0xFFCDDC39),
        start = LocalDateTime.parse("2025-02-05T18:00:00"),
        end = LocalDateTime.parse("2025-02-05T19:00:00"), // Increased duration to 1 hour
        description = "Collect dry cleaned clothes.",
        isAllDay = false
    ),
    Event(
        name = "Client Presentation",
        color = Color(0xFF3F51B5),
        start = LocalDateTime.parse("2025-02-06T10:00:00"),
        end = LocalDateTime.parse("2025-02-06T12:00:00"), // Increased duration to 2 hours
        description = "Present project proposal to client.",
        isAllDay = false
    ),
    Event(
        name = "Coffee with Mentor",
        color = Color(0xFFFFAB40),
        start = LocalDateTime.parse("2025-02-06T14:00:00"),
        end = LocalDateTime.parse("2025-02-06T15:00:00"),
        description = "Catch up and discuss career development.",
        isAllDay = false
    ),
    Event(
        name = "Dinner with Friends",
        color = Color(0xFFF44336),
        start = LocalDateTime.parse("2025-02-06T19:00:00"),
        end = LocalDateTime.parse("2025-02-06T21:00:00"),
        description = "Enjoy dinner and conversation with friends.",
        isAllDay = false
    ),
    Event(
        name = "Morning Gym Session",
        color = Color(0xFF8BC34A),
        start = LocalDateTime.parse("2025-02-07T06:30:00"),
        end = LocalDateTime.parse("2025-02-07T07:30:00"),
        description = "Workout at the gym before work.",
        isAllDay = false
    ),
    Event(
        name = "Review Sales Reports",
        color = Color(0xFF03A9F4),
        start = LocalDateTime.parse("2025-02-07T09:30:00"),
        end = LocalDateTime.parse("2025-02-07T11:30:00"), // Increased duration to 2 hours
        description = "Analyze weekly sales performance.",
        isAllDay = false
    ),
    Event(
        name = "Plan Weekend Activities",
        color = Color(0xFFFFEB3B),
        start = LocalDateTime.parse("2025-02-07T16:00:00"),
        end = LocalDateTime.parse("2025-02-07T17:00:00"),
        description = "Decide on activities for the upcoming weekend.",
        isAllDay = false
    ),
    Event(
        name = "Movie Night",
        color = Color(0xFF673AB7),
        start = LocalDateTime.parse("2025-02-07T20:00:00"),
        end = LocalDateTime.parse("2025-02-07T23:00:00"), // Increased duration to 3 hours
        description = "Relax and watch a movie at home.",
        isAllDay = false
    ),
    Event(
        name = "Home Cleaning",
        color = Color(0xFFE0F7FA),
        start = LocalDateTime.parse("2025-02-08T09:00:00"),
        end = LocalDateTime.parse("2025-02-08T12:00:00"),
        description = "Spend the morning cleaning the house.",
        isAllDay = false
    ),
    Event(
        name = "Lunch with Family",
        color = Color(0xFF8D6E63),
        start = LocalDateTime.parse("2025-02-08T13:00:00"),
        end = LocalDateTime.parse("2025-02-08T14:30:00"),
        description = "Casual lunch with family members.",
        isAllDay = false
    ),
    Event(
        name = "Volunteer at Local Shelter",
        color = Color(0xFF4DB6AC),
        start = LocalDateTime.parse("2025-02-08T15:00:00"),
        end = LocalDateTime.parse("2025-02-08T17:00:00"),
        description = "Spend time volunteering at a local animal shelter.",
        isAllDay = false
    ),
    Event(
        name = "Relaxing Spa Day",
        color = Color(0xFFF06292),
        start = LocalDateTime.parse("2025-02-09T11:00:00"),
        end = LocalDateTime.parse("2025-02-09T14:00:00"),
        description = "Enjoy a relaxing spa day.",
        isAllDay = false
    ),
    Event(
        name = "Afternoon Hike",
        color = Color(0xFF7CB342),
        start = LocalDateTime.parse("2025-02-09T15:30:00"),
        end = LocalDateTime.parse("2025-02-09T17:30:00"),
        description = "Go for a refreshing hike in nature.",
        isAllDay = false
    ),
    Event(
        name = "Prepare Weekly Meal Plan",
        color = Color(0xFFFFCA28),
        start = LocalDateTime.parse("2025-02-09T18:00:00"),
        end = LocalDateTime.parse("2025-02-09T19:00:00"),
        description = "Plan meals for the week ahead.",
        isAllDay = false
    ),
    Event(
        name = "Morning Meditation",
        color = Color(0xFFA1887F),
        start = LocalDateTime.parse("2025-02-10T07:00:00"),
        end = LocalDateTime.parse("2025-02-10T07:30:00"),
        description = "Start the day with a peaceful meditation session.",
        isAllDay = false
    ),
    Event(
        name = "Budget Review Meeting",
        color = Color(0xFF9E9D24),
        start = LocalDateTime.parse("2025-02-10T11:00:00"),
        end = LocalDateTime.parse("2025-02-10T12:00:00"),
        description = "Review monthly budget and expenses.",
        isAllDay = false
    ),
    Event(
        name = "Online Course: Web Development",
        color = Color(0xFF00ACC1),
        start = LocalDateTime.parse("2025-02-10T19:00:00"),
        end = LocalDateTime.parse("2025-02-10T21:00:00"),
        description = "Continue learning web development.",
        isAllDay = false
    ),
    Event(
        name = "Doctor's Appointment Follow-up",
        color = Color(0xFFE91E63),
        start = LocalDateTime.parse("2025-02-11T10:30:00"),
        end = LocalDateTime.parse("2025-02-11T11:30:00"), // Increased duration to 1 hour
        description = "Follow-up appointment after check-up.",
        isAllDay = false
    ),
    Event(
        name = "Meeting with Marketing Team",
        color = Color(0xFF7986CB),
        start = LocalDateTime.parse("2025-02-11T14:00:00"),
        end = LocalDateTime.parse("2025-02-11T15:30:00"), // Increased duration to 1.5 hours
        description = "Discuss upcoming marketing campaigns.",
        isAllDay = false
    ),
    Event(
        name = "Cook Dinner at Home",
        color = Color(0xFFEF5350),
        start = LocalDateTime.parse("2025-02-11T18:30:00"),
        end = LocalDateTime.parse("2025-02-11T19:30:00"),
        description = "Prepare a healthy dinner at home.",
        isAllDay = false
    ),
    Event(
        name = "Morning Journaling",
        color = Color(0xFFD4E157),
        start = LocalDateTime.parse("2025-02-12T07:30:00"),
        end = LocalDateTime.parse("2025-02-12T08:30:00"), // Increased duration to 1 hour
        description = "Start the day with reflective journaling.",
        isAllDay = false
    ),
    Event(
        name = "Training Session: Leadership Skills",
        color = Color(0xFF00BCD4),
        start = LocalDateTime.parse("2025-02-12T09:00:00"),
        end = LocalDateTime.parse("2025-02-12T12:00:00"),
        description = "Attend a leadership skills training session.",
        isAllDay = false
    ),
    Event(
        name = "Errands Run",
        color = Color(0xFFF57C00),
        start = LocalDateTime.parse("2025-02-12T16:00:00"),
        end = LocalDateTime.parse("2025-02-12T18:00:00"), // Increased duration to 2 hours
        description = "Post office, bank, and pharmacy errands.",
        isAllDay = false
    ),
    Event(
        name = "Game Night with Friends",
        color = Color(0xFF6D4C41),
        start = LocalDateTime.parse("2025-02-12T20:00:00"),
        end = LocalDateTime.parse("2025-02-12T22:00:00"),
        description = "Enjoy a fun game night with friends.",
        isAllDay = false
    ),
    Event(
        name = "Morning Walk",
        color = Color(0xFF9CCC65),
        start = LocalDateTime.parse("2025-02-13T06:00:00"),
        end = LocalDateTime.parse("2025-02-13T07:00:00"),
        description = "Start the day with a brisk morning walk.",
        isAllDay = false
    ),
    Event(
        name = "Project Deadline - Phase 1",
        color = Color(0xFFE53935),
        start = LocalDateTime.parse("2025-02-13T17:00:00"),
        end = LocalDateTime.parse("2025-02-13T18:00:00"), // Increased duration to 1 hour
        description = "Deadline for Project Phase 1 completion.",
        isAllDay = false
    ),
    Event(
        name = "Celebrate Project Milestone",
        color = Color(0xFF4DD0E1),
        start = LocalDateTime.parse("2025-02-13T19:00:00"),
        end = LocalDateTime.parse("2025-02-13T21:00:00"),
        description = "Team celebration for reaching project milestone.",
        isAllDay = false
    ),
    Event(
        name = "Morning Swimming",
        color = Color(0xFF0097A7),
        start = LocalDateTime.parse("2025-02-14T07:00:00"),
        end = LocalDateTime.parse("2025-02-14T08:00:00"),
        description = "Early morning swim.",
        isAllDay = false
    ),
    Event(
        name = "Valentine's Day!",
        color = Color(0xFFFF4081),
        start = LocalDateTime.parse("2025-02-14T00:00:00"),
        end = LocalDateTime.parse("2025-02-14T23:59:59"),
        description = "Celebrate Valentine's Day!",
        isAllDay = true
    ),
    Event(
        name = "Romantic Dinner",
        color = Color(0xFFFF4081),
        start = LocalDateTime.parse("2025-02-14T19:30:00"),
        end = LocalDateTime.parse("2025-02-14T22:00:00"),
        description = "Special Valentine's Day dinner.",
        isAllDay = false
    ),
    Event(
        name = "Weekend Art Workshop",
        color = Color(0xFF64B5F6),
        start = LocalDateTime.parse("2025-02-15T10:00:00"),
        end = LocalDateTime.parse("2025-02-16T16:00:00"),
        description = "Attend a weekend art workshop.",
        isAllDay = true
    ),
    Event(
        name = "Casual Coffee Date",
        color = Color(0xFFFFD54F),
        start = LocalDateTime.parse("2025-02-15T14:00:00"),
        end = LocalDateTime.parse("2025-02-15T15:00:00"),
        description = "Meet a friend for coffee.",
        isAllDay = false
    ),
    Event(
        name = "Visit Local Farmers Market",
        color = Color(0xFFAED581),
        start = LocalDateTime.parse("2025-02-16T09:00:00"),
        end = LocalDateTime.parse("2025-02-16T11:00:00"),
        description = "Explore the local farmers market.",
        isAllDay = false
    ),
    Event(
        name = "Afternoon Reading Time",
        color = Color(0xFFBCAAA4),
        start = LocalDateTime.parse("2025-02-16T14:00:00"),
        end = LocalDateTime.parse("2025-02-16T16:00:00"),
        description = "Enjoy quiet reading time.",
        isAllDay = false
    ),
    Event(
        name = "Start of Work Week",
        color = Color(0xFFCFD8DC),
        start = LocalDateTime.parse("2025-02-17T00:00:00"),
        end = LocalDateTime.parse("2025-02-17T00:00:01"), //just to mark the start of the work week
        description = "Get ready for a productive work week.",
        isAllDay = true
    ),
    Event(
        name = "Day at the Office",
        color = Color(0xFFEEEEEE),
        start = LocalDateTime.parse("2025-02-17T00:00:00"), //added extra all day event
        end = LocalDateTime.parse("2025-02-17T23:59:59"), //added extra all day event
        description = "Full day of work and meetings at the office.", //added extra all day event
        isAllDay = true //added extra all day event
    ),
    Event(
        name = "Weekly Team Meeting",
        color = Color(0xFF607D8B),
        start = LocalDateTime.parse("2025-02-17T10:00:00"),
        end = LocalDateTime.parse("2025-02-17T11:30:00"), // Increased duration to 1.5 hours
        description = "Weekly team progress update meeting.",
        isAllDay = false
    ),
    Event(
        name = "Networking Event",
        color = Color(0xFF009688),
        start = LocalDateTime.parse("2025-02-17T18:00:00"),
        end = LocalDateTime.parse("2025-02-17T20:00:00"),
        description = "Attend industry networking event.",
        isAllDay = false
    ),
    Event(
        name = "Morning Bike Ride",
        color = Color(0xFFFF5722),
        start = LocalDateTime.parse("2025-02-18T06:30:00"),
        end = LocalDateTime.parse("2025-02-18T07:30:00"),
        description = "Enjoy a bike ride before work.",
        isAllDay = false
    ),
    Event(
        name = "Performance Review Prep",
        color = Color(0xFFFFC107),
        start = LocalDateTime.parse("2025-02-18T14:00:00"),
        end = LocalDateTime.parse("2025-02-18T16:00:00"),
        description = "Prepare for upcoming performance review.",
        isAllDay = false
    ),
    Event(
        name = "Dinner with Family",
        color = Color(0xFFFBC02D),
        start = LocalDateTime.parse("2025-02-18T19:00:00"),
        end = LocalDateTime.parse("2025-02-18T20:30:00"),
        description = "Family dinner night.",
        isAllDay = false
    ),
    Event(
        name = "Morning Plant Watering",
        color = Color(0xFF689F38),
        start = LocalDateTime.parse("2025-02-19T07:00:00"),
        end = LocalDateTime.parse("2025-02-19T08:00:00"), // Increased duration to 1 hour
        description = "Quickly water indoor plants and check on garden.",
        isAllDay = false
    ),
    Event(
        name = "Conference Call with Overseas Team",
        color = Color(0xFF00838F),
        start = LocalDateTime.parse("2025-02-19T11:30:00"),
        end = LocalDateTime.parse("2025-02-19T12:30:00"),
        description = "Discuss project updates with overseas team.",
        isAllDay = false
    ),
    Event(
        name = "Library Visit",
        color = Color(0xFF795548),
        start = LocalDateTime.parse("2025-02-19T16:00:00"),
        end = LocalDateTime.parse("2025-02-19T17:30:00"),
        description = "Borrow new books from the library.",
        isAllDay = false
    ),
    Event(
        name = "Board Game Evening",
        color = Color(0xFF424242),
        start = LocalDateTime.parse("2025-02-19T20:00:00"),
        end = LocalDateTime.parse("2025-02-19T22:00:00"),
        description = "Enjoy a relaxed evening playing board games.",
        isAllDay = false
    ),
    Event(
        name = "Morning Run",
        color = Color(0xFFEF9A9A),
        start = LocalDateTime.parse("2025-02-20T06:00:00"),
        end = LocalDateTime.parse("2025-02-20T07:00:00"),
        description = "Early morning jog.",
        isAllDay = false
    ),
    Event(
        name = "Team Building Activity",
        color = Color(0xFFAB47BC),
        start = LocalDateTime.parse("2025-02-20T14:00:00"),
        end = LocalDateTime.parse("2025-02-20T16:30:00"), // Increased duration to 2.5 hours
        description = "Participate in a team building exercise.",
        isAllDay = false
    ),
    Event(
        name = "Focus Day - Deep Work",
        color = Color(0xFFE8F5E9),
        start = LocalDateTime.parse("2025-02-20T00:00:00"), //added extra all day event
        end = LocalDateTime.parse("2025-02-20T23:59:59"), //added extra all day event
        description = "Dedicated day for deep, focused work on key projects.", //added extra all day event
        isAllDay = true //added extra all day event
    ),
    Event(
        name = "Quick Tailor Visit",
        color = Color(0xFF827717),
        start = LocalDateTime.parse("2025-02-20T18:00:00"),
        end = LocalDateTime.parse("2025-02-20T19:00:00"), // Increased duration to 1 hour
        description = "Drop off and discuss clothes for tailoring.",
        isAllDay = false
    ),
    Event(
        name = "Watch Favorite TV Show",
        color = Color(0xFFFF7043),
        start = LocalDateTime.parse("2025-02-20T21:00:00"),
        end = LocalDateTime.parse("2025-02-20T22:00:00"),
        description = "Relax and watch an episode of favorite TV show.",
        isAllDay = false
    ),
    Event(
        name = "Morning Stretch Session",
        color = Color(0xFFEEDD82),
        start = LocalDateTime.parse("2025-02-21T07:30:00"),
        end = LocalDateTime.parse("2025-02-21T08:30:00"), // Increased duration to 1 hour
        description = "Gentle stretching to start the day.",
        isAllDay = false
    ),
    Event(
        name = "Performance Review Meeting",
        color = Color(0xFF9C27B0),
        start = LocalDateTime.parse("2025-02-21T10:00:00"),
        end = LocalDateTime.parse("2025-02-21T11:00:00"),
        description = "Performance review with manager.",
        isAllDay = false
    ),
    Event(
        name = "Farewell Lunch for Colleague",
        color = Color(0xFF00BFA5),
        start = LocalDateTime.parse("2025-02-21T12:30:00"),
        end = LocalDateTime.parse("2025-02-21T14:00:00"), // Increased duration to 1.5 hour
        description = "Farewell lunch for a departing colleague.",
        isAllDay = false
    ),
    Event(
        name = "Friday Wrap-up & Planning",
        color = Color(0xFF90A4AE),
        start = LocalDateTime.parse("2025-02-21T16:00:00"),
        end = LocalDateTime.parse("2025-02-21T17:00:00"),
        description = "Review week's accomplishments and plan for next week.",
        isAllDay = false
    ),
    Event(
        name = "Live Music Night",
        color = Color(0xFF3F51B5),
        start = LocalDateTime.parse("2025-02-21T20:00:00"),
        end = LocalDateTime.parse("2025-02-21T23:00:00"), // Increased duration to 3 hours
        description = "Enjoy live music at a local venue.",
        isAllDay = false
    ),
    Event(
        name = "Weekend Project - Home Improvement",
        color = Color(0xFF795548),
        start = LocalDateTime.parse("2025-02-22T09:00:00"),
        end = LocalDateTime.parse("2025-02-22T18:00:00"),
        description = "Work on a home improvement project throughout the weekend.",
        isAllDay = true
    ),
    Event(
        name = "Relaxation Weekend",
        color = Color(0xFFF5F5F5),
        start = LocalDateTime.parse("2025-02-22T00:00:00"), //added extra all day event
        end = LocalDateTime.parse("2025-02-22T23:59:59"), //added extra all day event
        description = "Focus on relaxation and unwinding this weekend.", //added extra all day event
        isAllDay = true //added extra all day event
    ),
    Event(
        name = "Brunch with Friends",
        color = Color(0xFFFFE0B2),
        start = LocalDateTime.parse("2025-02-22T11:00:00"),
        end = LocalDateTime.parse("2025-02-22T13:00:00"),
        description = "Casual brunch with friends.",
        isAllDay = false
    ),
    Event(
        name = "Gardening Afternoon",
        color = Color(0xFF81C784),
        start = LocalDateTime.parse("2025-02-23T14:00:00"),
        end = LocalDateTime.parse("2025-02-23T17:00:00"),
        description = "Spend afternoon gardening.",
        isAllDay = false
    ),
    Event(
        name = "Family Board Game Day",
        color = Color(0xFFFFCC80),
        start = LocalDateTime.parse("2025-02-24T10:00:00"), //typo in original request month day order
        end = LocalDateTime.parse("2025-02-24T16:00:00"), //typo in original request month day order
        description = "Spend the day playing board games with family.",
        isAllDay = true
    ),
    Event(
        name = "Team Offsite - Strategy Planning",
        color = Color(0xFFC5CAE9),
        start = LocalDateTime.parse("2025-02-24T00:00:00"), //added extra all day event
        end = LocalDateTime.parse("2025-02-24T23:59:59"), //added extra all day event
        description = "Full day team offsite for strategy planning and workshops.", //added extra all day event
        isAllDay = true //added extra all day event
    ),
    Event(
        name = "Morning Pages Writing",
        color = Color(0xFFBDBDBD),
        start = LocalDateTime.parse("2025-02-24T07:00:00"),
        end = LocalDateTime.parse("2025-02-24T08:00:00"), // Increased duration to 1 hour
        description = "Start the week with morning pages writing exercise.",
        isAllDay = false
    ),
    Event(
        name = "New Project Kick-off Meeting",
        color = Color(0xFF0288D1),
        start = LocalDateTime.parse("2025-02-24T14:00:00"),
        end = LocalDateTime.parse("2025-02-24T15:30:00"), // Increased duration to 1.5 hours
        description = "Initial meeting for new project kick-off.",
        isAllDay = false
    ),
    Event(
        name = "Quick Haircut",
        color = Color(0xFFD84315),
        start = LocalDateTime.parse("2025-02-25T17:30:00"),
        end = LocalDateTime.parse("2025-02-25T18:30:00"),
        description = "Get a quick haircut.",
        isAllDay = false
    ),
    Event(
        name = "Listen to Podcasts",
        color = Color(0xFF5D4037),
        start = LocalDateTime.parse("2025-02-25T20:00:00"),
        end = LocalDateTime.parse("2025-02-25T21:00:00"),
        description = "Relax and listen to favorite podcasts.",
        isAllDay = false
    ),
    Event(
        name = "Morning Desk Yoga",
        color = Color(0xFFA7FFEB),
        start = LocalDateTime.parse("2025-02-26T09:00:00"),
        end = LocalDateTime.parse("2025-02-26T10:00:00"), // Increased duration to 1 hour
        description = "Quick desk yoga session to refresh.",
        isAllDay = false
    ),
    Event(
        name = "Brainstorming Session",
        color = Color(0xFF7E57C2),
        start = LocalDateTime.parse("2025-02-26T11:00:00"),
        end = LocalDateTime.parse("2025-02-26T12:30:00"), // Increased duration to 1.5 hours
        description = "Brainstorming session for new ideas.",
        isAllDay = false
    ),
    Event(
        name = "Cook New Recipe",
        color = Color(0xFFFF8A65),
        start = LocalDateTime.parse("2025-02-26T19:00:00"),
        end = LocalDateTime.parse("2025-02-26T20:00:00"),
        description = "Try cooking a new recipe for dinner.",
        isAllDay = false
    ),
    Event(
        name = "Morning Gratitude List",
        color = Color(0xFFFFD180),
        start = LocalDateTime.parse("2025-02-27T07:15:00"),
        end = LocalDateTime.parse("2025-02-27T08:15:00"), // Increased duration to 1 hour
        description = "Start the day by writing a gratitude list.",
        isAllDay = false
    ),
    Event(
        name = "Check in with Supervisor",
        color = Color(0xFF4FC3F7),
        start = LocalDateTime.parse("2025-02-27T15:00:00"),
        end = LocalDateTime.parse("2025-02-27T16:00:00"), // Increased duration to 1 hour
        description = "Quick check in meeting with supervisor.",
        isAllDay = false
    ),
    Event(
        name = "Practice Photography",
        color = Color(0xFFB3E5FC),
        start = LocalDateTime.parse("2025-02-27T17:00:00"),
        end = LocalDateTime.parse("2025-02-27T18:30:00"),
        description = "Practice photography skills outdoors.",
        isAllDay = false
    ),
    Event(
        name = "Relaxing Bubble Bath",
        color = Color(0xFF80CBC4),
        start = LocalDateTime.parse("2025-02-27T21:00:00"),
        end = LocalDateTime.parse("2025-02-27T22:00:00"), // Increased duration to 1 hour
        description = "Wind down with a relaxing bubble bath.",
        isAllDay = false
    ),
    Event(
        name = "Morning Social Media Check",
        color = Color(0xFFE1BEE7),
        start = LocalDateTime.parse("2025-02-28T08:00:00"),
        end = LocalDateTime.parse("2025-02-28T09:00:00"), // Increased duration to 1 hour
        description = "Quick social media check and updates.",
        isAllDay = false
    ),
    Event(
        name = "Review March Calendar",
        color = Color(0xFFDCE775),
        start = LocalDateTime.parse("2025-02-28T11:00:00"),
        end = LocalDateTime.parse("2025-02-28T12:30:00"), // Increased duration to 1.5 hours
        description = "Plan and review calendar for March.",
        isAllDay = false
    ),
    Event(
        name = "End of February - Month Review",
        color = Color(0xFFB0BEC5),
        start = LocalDateTime.parse("2025-02-28T17:00:00"),
        end = LocalDateTime.parse("2025-02-28T18:00:00"),
        description = "Reflect on February's accomplishments and lessons.",
        isAllDay = false
    ),
    Event(
        name = "Prepare for Weekend",
        color = Color(0xFFC8E6C9),
        start = LocalDateTime.parse("2025-02-28T19:00:00"),
        end = LocalDateTime.parse("2025-02-28T20:00:00"),
        description = "Plan and prepare for the upcoming weekend.",
        isAllDay = false
    ),
    Event(
        name = "February Daily Tasks",
        color = Color(0xFFF0F4C3),
        start = LocalDateTime.parse("2025-02-28T00:00:00"), //added extra all day event on last day of feb
        end = LocalDateTime.parse("2025-02-28T23:59:59"), //added extra all day event on last day of feb
        description = "General daily tasks and routines for the last day of February.", //added extra all day event on last day of feb
        isAllDay = true //added extra all day event on last day of feb
    ),
)

fun generateRandomEvents(startDate: LocalDateTime, endDate: LocalDateTime) {
    val random = Random(System.currentTimeMillis())
    val allDayEventNames = listOf("National Holiday", "Conference", "Yoga Retreat", "All-Day Workshop", "Annual Festival")
    val timedEventNames = listOf("Morning Jog", "Team Meeting", "Lunch Break", "Workout Session", "Evening Walk", "Dinner with Friends", "Networking Event")
    val colors = listOf(
        Color(0xFFFF6F61), Color(0xFF4CAF50), Color(0xFF64B5F6),
        Color(0xFFFFEB3B), Color(0xFF673AB7), Color(0xFF957DAD),
        Color(0xFFA1C349), Color(0xFFFFA07A)
    )

    // Select a random day within the date range
    val daysBetween = ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate()).toInt()
    val randomDayOffset = random.nextInt(daysBetween + 1)
    val randomDay = startDate.plusDays(randomDayOffset.toLong())

    // Generate 1 to 10 all-day events for the random day
    val numberOfAllDayEvents = 1
    for (i in 1..numberOfAllDayEvents) {
        val allDayEvent = Event(
            name = allDayEventNames[random.nextInt(allDayEventNames.size)],
            color = colors[random.nextInt(colors.size)],
            start = randomDay.withHour(0).withMinute(0).withSecond(0),
            end = randomDay.withHour(23).withMinute(59).withSecond(59),
            description = "A full-day event to mark the occasion.",
            isAllDay = true
        )
        var x = sampleEvents
        x.add(allDayEvent)
        sampleEvents = x
    }

    // Generate 1 to 9 additional timed events for the random day
    val numberOfTimedEvents = 1
    for (i in 1..numberOfTimedEvents) {
        val startHour = random.nextInt(2, 22)
        val startMinute = random.nextInt(1, 60)
        val durationHours = random.nextInt(1, 8)
        val durationMinutes = random.nextInt(0, 60)
        val endHour = (startHour + durationHours) % 24
        val endMinute = (startMinute + durationMinutes) % 60

        val startDateTime = randomDay.withHour(startHour).withMinute(startMinute)
        val endDateTime = randomDay.withHour(endHour).withMinute(endMinute)

        val timedEvent = Event(
            name = timedEventNames[random.nextInt(timedEventNames.size)],
            color = colors[random.nextInt(colors.size)],
            start = startDateTime,
            end = if (endDateTime.isAfter(startDateTime)) endDateTime else startDateTime.plusHours(1),
            description = "A scheduled event to stay productive.",
            isAllDay = false
        )
        sampleEvents.add(timedEvent)
    }
}