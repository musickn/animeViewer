package com.erx.animeviewer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erx.animeviewer.databinding.AnimeAdapterBinding
import com.erx.animeviewer.model.Anime

class AnimeAdapter(private val listener: (Anime) -> Unit) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

  private var animeList = mutableListOf<Anime>()

  fun setAnimeList(animeList: List<Anime>) {
    this.animeList = animeList.toMutableList()
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
    val inflater = LayoutInflater.from(parent.context)

    val binding = AnimeAdapterBinding.inflate(inflater, parent, false)
    return AnimeViewHolder(binding)
  }

  override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
    val anime = animeList[position]
    holder.binding.title.text = anime.title
    holder.binding.root.setOnClickListener { listener(anime) }
    Glide.with(holder.itemView.context).load(anime.imageUrl).into(holder.binding.image)
  }

  override fun getItemCount(): Int {
    return animeList.size
  }

  class AnimeViewHolder(val binding: AnimeAdapterBinding) : RecyclerView.ViewHolder(binding.root)
}