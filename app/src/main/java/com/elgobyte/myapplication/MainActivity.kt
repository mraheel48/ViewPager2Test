package com.elgobyte.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)

        viewPager.adapter = createCardAdapter()
        TabLayoutMediator(tabLayout, viewPager
        ) { tab, position -> tab.text = "Tab " + (position + 1) }.attach()
    }

    private fun createCardAdapter(): ViewPagerAdapter {
        return ViewPagerAdapter(this)
    }
}