package com.erx.animeviewer.repository

import com.erx.animeviewer.api.RetrofitManager

object AnimeRepository {
  fun getAnimeList() = RetrofitManager.api.fetchAllAnime()
}