package com.im3.conf.view.adapter

import com.im3.conf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(Speaker: Speaker, position: Int)
}