package com.example.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(val context: Context) : PagerAdapter() {

    var layoutInflater: LayoutInflater? = null

    val imgArray = arrayOf(
        R.drawable.test_image,
        R.drawable.test_image,
        R.drawable.test_image,
        R.drawable.test_image
    )

    val headArray = arrayOf(
        "Love up the seamless process",
        "H2 test test",
        "H3 test test",
        "H4 test test"
    )

    val descriptionArray = arrayOf(
        "D1 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea ",
        "D2 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea ",
        "D3 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea ",
        "D4 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea "
    )

    override fun getCount(): Int {
      return  headArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider, container, false)

        val img = view.findViewById<ImageView>(R.id.onboarding_img)
        val txt_head = view.findViewById<TextView>(R.id.txt_head)
        val txt_description = view.findViewById<TextView>(R.id.txt_description)

        img.setImageResource(imgArray[0])
        txt_head.text = headArray[position]
        txt_description.text = descriptionArray[position]

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}