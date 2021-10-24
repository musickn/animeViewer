package com.erx.animeviewer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erx.animeviewer.model.Anime
import com.erx.animeviewer.model.responses.AnimeListResponse
import com.erx.animeviewer.repository.AnimeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeViewModel : ViewModel() {
  private val _animeList = MutableLiveData<List<Anime>>()
  val animeList: LiveData<List<Anime>>
    get() = _animeList
  private val _errorMessage = MutableLiveData<String>()
  val errorMessage: LiveData<String>
    get() = _errorMessage

  fun fetchAnimeList() {
    val response = AnimeRepository.getAnimeList()
    response.enqueue(object : Callback<AnimeListResponse> {
      override fun onResponse(
        call: Call<AnimeListResponse>,
        response: Response<AnimeListResponse>
      ) {
        _animeList.postValue(response.body()?.anime)
      }

      override fun onFailure(call: Call<AnimeListResponse>, t: Throwable) {
        _errorMessage.postValue(t.message)
      }
    })
  }

  fun addAnime(title: String, rating: String) {
    _animeList.postValue(
      listOf(
        Anime(
          title = title,
          imageUrl = String(),
          type = String(),
          rating = rating,
          totalEpisodes = 0,
          seasonName = String(),
          seasonYear = 0
        )
      )
    )
  }
}