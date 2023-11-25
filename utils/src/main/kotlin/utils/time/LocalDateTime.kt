package utils.time

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun Long.toLocalDatetime(): LocalDateTime {
    return Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault()).toLocalDateTime()
}

fun LocalDateTime.toSendMessagesDto(): Long {
    return this.toEpochSecond(ZoneOffset.of("+03:00:00")) * 1000
}

fun LocalDateTime.toFormattedStringWithFullTime(): String {
    return this.format(
        DateTimeFormatter.ofPattern("dd.MM.yyyy, hh:mm")
    )
}

fun LocalDateTime.toFormattedStringOnlyHoursMinutes(): String {
    return this
        .format(
            DateTimeFormatter.ofPattern(
                "kk:mm",
                Locale("RUS")
            )
        )
}
