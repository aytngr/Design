package com.example.designsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class CardAdapter(private val mList: ArrayList<Card>): PagerAdapter() {


    override fun getCount(): Int {
        return mList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(container.context).inflate(R.layout.card, container, false)

        val image = view.findViewById<LinearLayout>(R.id.linear_layout)
        val title = view.findViewById<TextView>(R.id.title)
        val secondary_title = view.findViewById<TextView>(R.id.secondary_title)

        image.setBackgroundResource(mList.get(position).background_image)
        title.text = mList.get(position).title
        secondary_title.text = mList.get(position).secondary_title

        view.setOnClickListener {

        }
        container.addView(view, 0)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}
