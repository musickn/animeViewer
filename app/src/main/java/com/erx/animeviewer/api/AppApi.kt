package com.erx.animeviewer.api

import com.erx.animeviewer.model.responses.AnimeListResponse
import retrofit2.Call
import retrofit2.http.GET

interface AppApi {
  @GET("v3/user/Nekomata1037/animelist/all")
  fun fetchAllAnime(): Call<AnimeListResponse>
}