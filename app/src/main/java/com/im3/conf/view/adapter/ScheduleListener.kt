package com.im3.conf.view.adapter

interface ScheduleListener {
    fun onConferenceClicked(conference: com.im3.conf.model.Conference, position: Int)
}