package com.example.designsapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoryList = arrayListOf(Cateory(R.drawable.breakfast,"Breakfast"),Cateory(R.drawable.burger,"Burger"),
            Cateory(R.drawable.breakfast,"Asian"),Cateory(R.drawable.burger,"American"),
            Cateory(R.drawable.breakfast,"Asian"),Cateory(R.drawable.burger,"American"))
        val cardList = arrayListOf(Card(R.drawable.food_bg,"Nickel and Dinner", "American, Breakfast"),Card(R.drawable.food_bg,"Nickel and Dinner", "American, Breakfast"),
            Card(R.drawable.food_bg,"Nickel and Dinner", "American, Breakfast"))
        val viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val tabLayout = findViewById<View>(R.id.tabDots) as TabLayout
        val btnSearch = findViewById<ImageButton>(R.id.btn_search)
        val btnExitSearch = findViewById<ImageButton>(R.id.btn_exit_search)
        val searchLayout = findViewById<LinearLayout>(R.id.search_layout)

        btnSearch.setOnClickListener {
            if(searchLayout.visibility != View.VISIBLE){
                searchLayout.visibility = View.VISIBLE
            }
        }
        btnExitSearch.setOnClickListener {
            if(searchLayout.visibility == View.VISIBLE){
                searchLayout.visibility = View.INVISIBLE
            }
        }

        tabLayout.setupWithViewPager(viewPager, true)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        val viewPagerAdapter = CardAdapter(cardList)
        viewPager.adapter = viewPagerAdapter

        val recyclerviewAdapter = CategoryAdapter(categoryList)
        recyclerview.adapter = recyclerviewAdapter
        viewPager.setPadding(10, 0, 10, 0)
        viewPager.pageMargin = 10

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}