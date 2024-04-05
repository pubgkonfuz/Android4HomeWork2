package com.example.android4homework2.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android4homework2.ui.fragment.ViewPagerFragment
import com.example.android4homework2.ui.fragment.anime.AnimeFragment
import com.example.android4homework2.ui.fragment.manga.MangaFragment

class ViewPagerAdapter(fragment: ViewPagerFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return if (position == 1) MangaFragment() else AnimeFragment()
    }
}