package com.im3.conf.view.adapter

import android.telecom.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}