package com.example.carlist.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carlist.models.CarFragment
import com.example.carlist.models.FavoritesFragment

class TabAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->  CarFragment()
            1 ->  FavoritesFragment()
            else -> CarFragment()
        }
    }

}