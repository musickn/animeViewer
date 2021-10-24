package com.erx.animeviewer

import InstantExecutorExtension
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.erx.animeviewer.viewmodel.AnimeViewModel
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class AnimeViewModelUnitTest : TestCase() {

  @get:Rule
  var rule = InstantTaskExecutorRule()

  private val viewModel = AnimeViewModel()

  @Test
  fun testGetAnimeList() {
    viewModel.addAnime("hunterxhunter", "PG-20")
    val result = viewModel.animeList.getOrAwaitValue().find {
      it.title == "hunterxhunter" && it.rating == "PG-20"
    }
    assertThat(result != null).isTrue()
  }
}