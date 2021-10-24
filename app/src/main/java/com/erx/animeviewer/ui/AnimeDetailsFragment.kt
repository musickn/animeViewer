package com.erx.animeviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.erx.animeviewer.AnimeDetailsActivity
import com.erx.animeviewer.BR
import com.erx.animeviewer.R
import com.erx.animeviewer.databinding.AnimeDetailsFragmentBinding

class AnimeDetailsFragment : Fragment() {

  companion object {
    fun newInstance() = AnimeDetailsFragment()
  }

  lateinit var binding: AnimeDetailsFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.anime_details_fragment, container, false)
    with(binding) {
      lifecycleOwner = this@AnimeDetailsFragment
      setVariable(BR.anime, (activity as AnimeDetailsActivity).selectedAnime)
    }
    loadImage(binding.image, (activity as AnimeDetailsActivity).selectedAnime.imageUrl)
    return binding.root
  }

  @BindingAdapter("imageUrl")
  fun loadImage(image: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
      Glide.with(this).load(url).into(image)
    }
  }
}