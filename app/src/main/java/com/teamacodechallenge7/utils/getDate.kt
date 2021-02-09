package com.teamacodechallenge7.utils

import java.text.SimpleDateFormat
import java.util.*
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun String.getStringTimeStampWithDate(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val dateTime = formatter.parse(this)

    val formatTime = SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss", Locale.getDefault())
    formatTime.timeZone= TimeZone.getTimeZone("GMT+14")
    return formatTime.format(dateTime)
}
