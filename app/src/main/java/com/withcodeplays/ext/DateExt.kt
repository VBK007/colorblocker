package com.withcodeplays.ext

import java.text.SimpleDateFormat
import java.util.*


fun Date?.getFormattedDate(): String {
    if (this == null) return ""
    return (SimpleDateFormat("dd/MM/yyyy", Locale.US) /*as DateFormat*/).format(this) ?: ""
}

fun Date?.getFormattedDateTime(): String {
    if (this == null) return ""
    return (SimpleDateFormat("dd/MM/yyyy HH:mm a", Locale.US) /*as DateFormat*/).format(this) ?: ""
}
fun Date?.getFormattedDateTimes(): String {
    if (this == null) return ""
    return (SimpleDateFormat("dd/MM/yyyy h:mm:ss a", Locale.US) /*as DateFormat*/).format(this) ?: ""
}

fun Date?.getFormattedTime(): String {
    if (this == null) return ""
    return (SimpleDateFormat("HH:mm:ss", Locale.US)/* as DateFormat*/).format(this) ?: ""
}

fun Date?.toISO8601String(): String {
    if (this == null) return ""
    val df =
        (SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)/* as DateFormat*/)
    return df.format(this) ?: ""
}