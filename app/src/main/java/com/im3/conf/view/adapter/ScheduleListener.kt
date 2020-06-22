package com.im3.conf.view.adapter

import android.os.Bundle
import com.im3.conf.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: com.im3.conf.model.Conference, position: Int)
    abstract fun bundleOf(pair: Pair<String, Conference>): Bundle?
}