package com.dasha.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dasha.databinding.RecyclerViewRowBinding
import com.dasha.model.Music

class MusicAdapter(private val musicList: List<Pair<Music, String?>>,
                   private val onClickAction: (position: Int) -> Unit) :
    RecyclerView.Adapter<MusicAdapter.MusicHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val itemBinding = RecyclerViewRowBinding.inflate(LayoutInflater.from(parent.context))
        return MusicHolder(itemBinding, onClickAction)
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        val track = musicList[position].first
        val imageUrl = musicList[position].second
        holder.bind(track, imageUrl )
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    class MusicHolder(
        private val musicBinding: RecyclerViewRowBinding,
        private val onClickAction: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(musicBinding.root) {
        init {
            itemView.setOnClickListener {
                println("navigation on element")
                onClickAction(adapterPosition)
            }
        }

        fun bind(track: Music, url: String?){
            Glide.with(itemView)
                .load(url)
                .centerCrop()
                .placeholder(musicBinding.iconImage.drawable)
                .into(musicBinding.iconImage)
            musicBinding.musicDescription.setText(track.getName())
        }
    }
}