package com.example.tablayout

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity
 * Class: MainActivity
 * Created by 한경동 (Joel) on 2021/05/23.
 * Description: TabLayout, ViewPager 를 보여줄 Main 화면
 */
class MainActivity : AppCompatActivity() {

    var fragmentIndex: Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentIndex = 0
        initViewPager()
    }

    private fun initViewPager() {

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addItems(SampleFragment(getString(R.string.fragment_title_today)), getString(R.string.fragment_title_today))
        adapter.addItems(SampleFragment(getString(R.string.fragment_title_info)),getString(R.string.fragment_title_info))
        // adapter.addItems(SampleFragment(getString(R.string.fragment_title_shinhan)),getString(R.string.fragment_title_shinhan))
        // adapter.addItems(SampleFragment(getString(R.string.fragment_title_assets)),getString(R.string.fragment_title_assets))
        // adapter.addItems(SampleFragment(getString(R.string.fragment_title_discover)),getString(R.string.fragment_title_discover))

        vp_main.adapter = adapter
        vp_main.offscreenPageLimit = adapter.count
        // tl_main.setupWithViewPager(vp_main)

        var tabLay = tl_main.getChildAt(0) as LinearLayout
        var layout = tabLay.getChildAt(0) as LinearLayout
        var tvTab = layout.getChildAt(1) as TextView
        layout.setBackgroundResource(R.drawable.tab_btn_shpae)
        tvTab.setTextColor(Color.parseColor("#ffffff"))
        tl_main.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                fragmentIndex = tab?.position
                vp_main.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        vp_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                Log.d("onPageSelected", "$position")
            }

            override fun onPageScrollStateChanged(state: Int) {
                if(ViewPager.SCROLL_STATE_IDLE == state) {
                    Log.d("onPageState", "$state")
                }
            }
        })

    }

    override fun onBackPressed() {
        when(fragmentIndex) {

        }
        super.onBackPressed()
    }

}