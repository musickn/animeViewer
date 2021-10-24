package com.erx.animeviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erx.animeviewer.model.Anime
import com.erx.animeviewer.model.responses.AnimeListResponse
import com.erx.animeviewer.repository.AnimeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeViewModel : ViewModel() {
  val animeList = MutableLiveData<List<Anime>>()
  val errorMessage = MutableLiveData<String>()

  fun fetchAnimeList() {
    val response = AnimeRepository.getAnimeList()
    response.enqueue(object : Callback<AnimeListResponse> {
      override fun onResponse(call: Call<AnimeListResponse>, response: Response<AnimeListResponse>) {
        animeList.postValue(response.body()?.anime)
      }

      override fun onFailure(call: Call<AnimeListResponse>, t: Throwable) {
        errorMessage.postValue(t.message)
      }
    })
  }
}