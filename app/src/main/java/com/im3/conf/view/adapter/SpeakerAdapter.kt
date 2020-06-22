package com.im3.conf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.im3.conf.R
import com.im3.conf.model.Speaker

class SpeakerAdapter(val speakerListener: SpeakerListener) : RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    var listSpeakers = ArrayList<Speaker>()

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false))
//    }
//
//    override fun getItemCount(): Int {
//        return listSpeaker.size
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false))

    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeakers[position]
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerJob.text = speaker.workplace

        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivSpeakerImage)

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClicked(speaker, position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvSpeakerName)
        val tvSpeakerJob = itemView.findViewById<TextView>(R.id.tvSpeakerJob)
        val ivSpeakerImage = itemView.findViewById<ImageView>(R.id.ivSpeakerImage)
    }

    fun updateData(data: List<Speaker>) {
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }
}