package com.jarvis.amlich.common.extension

import java.time.LocalDate
import java.time.ZoneId
import java.util.*

fun Date.startDate(): Long {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    calendar.set(Calendar.HOUR, 0)
    calendar.set(Calendar.SECOND, 0)
    return calendar.timeInMillis
}

fun Date.endDate(): Long {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    calendar.set(Calendar.HOUR, 23)
    calendar.set(Calendar.SECOND, 59)
    return calendar.timeInMillis
}

fun LocalDate.convertDate(): Date {
    return Date.from(this.atStartOfDay(ZoneId.systemDefault()).toInstant())
}

fun Date.endMonth(): Long {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    calendar.set(Calendar.HOUR, 23)
    calendar.set(Calendar.SECOND, 59)
    calendar.add(Calendar.MONTH, 1)
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    calendar.add(Calendar.DATE, -1)
    return calendar.timeInMillis
}

fun Date.isCheckInDay(list: List<Long>): Boolean {
    val calendar = Calendar.getInstance()
    calendar.time = this
    list.mapNotNull {
        if (calendar.timeInMillis.isCheckSameDay(it)) return true
    }
    return false
}

fun Long.isCheckSameDay(time: Long): Boolean {
    val calendar = Calendar.getInstance()
    val calendarTemp = Calendar.getInstance()
    calendar.timeInMillis = this
    calendarTemp.timeInMillis = time
    return (calendar.get(Calendar.DAY_OF_MONTH) == calendarTemp.get(Calendar.DAY_OF_MONTH)
            && calendar.get(Calendar.MONTH) == calendarTemp.get(Calendar.MONTH)
            && calendar.get(Calendar.YEAR) == calendarTemp.get(Calendar.YEAR))
}


fun Date.startMonth(): Long {
    val calendar = Calendar.getInstance()
    calendar.time = this
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    calendar.set(Calendar.HOUR, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    return calendar.timeInMillis
}
