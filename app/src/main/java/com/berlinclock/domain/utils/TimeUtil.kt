package com.berlinclock.domain.utils

import android.annotation.SuppressLint
import com.berlinclock.constants.TIME_FORMAT
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class TimeUtil {
    @SuppressLint("NewApi")
    fun getFormattedTime(): String = LocalTime.now().format(DateTimeFormatter.ofPattern(TIME_FORMAT))
}