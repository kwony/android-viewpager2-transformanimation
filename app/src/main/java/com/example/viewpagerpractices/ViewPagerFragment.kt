package com.example.viewpagerpractices

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_viewpager.*

class ViewPagerFragment: Fragment() {
    companion object {
        private const val EXTRA_COLOR_ID = "extra_color_id"

        @JvmStatic
        fun newInstance(colorId: Int): ViewPagerFragment {
            val bundle = Bundle().apply {
                putInt(EXTRA_COLOR_ID, colorId)
            }
            return ViewPagerFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fr_viewpager_container.setBackgroundColor(arguments?.getInt(EXTRA_COLOR_ID)?: Color.BLACK)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_viewpager, container, false)
    }
}