package com.example.viewpagerpractices

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        act_viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        act_viewpager.adapter = PagerAdapter(supportFragmentManager, lifecycle)

        act_viewpager.setPageTransformer { page, position ->
            page.apply {
                translationY = Math.abs(position) * 500f
                scaleX = 1f
                scaleY = 1f
            }
        }
    }

    private class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
        val items: List<Int> = listOf(1, 2, 3, 4, 5)

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ViewPagerFragment.newInstance(Color.RED)
                1 -> ViewPagerFragment.newInstance(Color.BLACK)
                2 -> ViewPagerFragment.newInstance(Color.GRAY)
                3 -> ViewPagerFragment.newInstance(Color.GREEN)
                else -> ViewPagerFragment.newInstance(Color.YELLOW)
            }
        }

        override fun getItemCount(): Int = items.size
    }
}
