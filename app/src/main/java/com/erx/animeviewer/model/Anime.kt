package com.erx.animeviewer.model

import java.io.Serializable

data class Anime(
  val title: String,
  val imageUrl: String,
  val type: String,
  val rating: String,
  val totalEpisodes: Int,
  val seasonName: String,
  val seasonYear: Int
): Serializable