package com.erx.animeviewer.ui

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erx.animeviewer.AnimeDetailsActivity
import com.erx.animeviewer.adapter.AnimeAdapter
import com.erx.animeviewer.viewmodel.AnimeViewModel

class AnimeListFragment : Fragment() {

  companion object {
    fun newInstance() = AnimeListFragment()
  }

  private lateinit var animeViewModel: AnimeViewModel
  private lateinit var adapter: AnimeAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    animeViewModel = ViewModelProvider(this).get(AnimeViewModel::class.java)
    adapter = AnimeAdapter {
      val intent = Intent(requireActivity(), AnimeDetailsActivity::class.java)
      intent.putExtra("selectedAnime", it)
      startActivity(intent)
    }
    return RecyclerView(requireContext()).apply {
      adapter = this@AnimeListFragment.adapter
      layoutManager = LinearLayoutManager(context)
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(animeViewModel) {
      fetchAnimeList()
      animeList.observe(viewLifecycleOwner, { adapter.setAnimeList(it) })
    }
  }
}