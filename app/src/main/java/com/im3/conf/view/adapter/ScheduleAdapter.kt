package com.im3.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.im3.conf.model.Conference
import com.im3.conf.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConference = ArrayList<Conference>()

    //override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder {
    //  return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))
    //}

    //override fun getItemCount(): Int {
    //  return listConference.size
    //}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))

    override fun getItemCount() = listConference.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference
        holder.tvConferenceName.text = conference.title
        holder.tvConferenceNameSpeaker.text = conference.speaker
        holder.tvConferenceNameTag.text = conference.tag

        val simpleDateFormatAMPM = SimpleDateFormat("a")
        val calendar = Calendar.getInstance()
        calendar.time = conference.datetime

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val hourFormat = simpleDateFormat.format(conference.datetime)

        holder.tvConferenceHour.text = hourFormat
        holder.tvConferenceAMPM.text = simpleDateFormatAMPM.format(conference.datetime).toUpperCase()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceNameSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceNameSpeaker)
        val tvConferenceNameTag = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceNameTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        var tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
    }

    fun updateDate(data: List<Conference>) {
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }
}