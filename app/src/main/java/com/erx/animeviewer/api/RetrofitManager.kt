package com.erx.animeviewer.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

  val api: AppApi by lazy {
    retrofitConnection().create(AppApi::class.java)
  }

  private fun retrofitConnection(): Retrofit {
    val timeout = 30L
    val client = OkHttpClient.Builder()
      .connectTimeout(timeout, TimeUnit.SECONDS)
      .readTimeout(timeout, TimeUnit.SECONDS)
      .build()
    val gson =
      GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    return Retrofit.Builder()
      .baseUrl("https://api.jikan.moe/")
      .addConverterFactory(ScalarsConverterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(gson))
      .client(client)
      .build()
  }
}