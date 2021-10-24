package com.erx.animeviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erx.animeviewer.model.Anime
import com.erx.animeviewer.ui.AnimeDetailsFragment

class AnimeDetailsActivity : AppCompatActivity() {

  lateinit var selectedAnime: Anime

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.anime_details_activity)
    selectedAnime = intent.getSerializableExtra("selectedAnime") as Anime
    supportFragmentManager.beginTransaction()
      .replace(R.id.container, AnimeDetailsFragment.newInstance())
      .commitNow()
  }
}