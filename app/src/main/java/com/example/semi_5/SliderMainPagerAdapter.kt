package com.example.semi_5

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class SliderMainPagerAdapter(fm: FragmentManager?, val num_fragment: Int): FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment? {
        var fragment: SliderMainFragment = SliderMainFragment()
        var bundle: Bundle = Bundle(1)
        when(p0) {
            0->bundle.putInt("background_color", Color.RED)
            1->bundle.putInt("background_color", Color.YELLOW)
            2->bundle.putInt("background_color", Color.GREEN)
        }
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return num_fragment
    }
}