package com.berlinclock.domain.utils

import android.annotation.SuppressLint
import com.berlinclock.constants.TIME_FORMAT
import com.berlinclock.domain.model.TimeComponent
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
class TimeUtil {
    fun getFormattedTime(): String = LocalTime.now().format(DateTimeFormatter.ofPattern(TIME_FORMAT))

    fun getTimeComponent(): TimeComponent = with(LocalTime.now()) {
        TimeComponent(
            hour,
            minute,
            second)
    }
}