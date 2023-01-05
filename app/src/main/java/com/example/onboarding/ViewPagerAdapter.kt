package com.example.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.onboarding.Constants.descriptionArray
import com.example.onboarding.Constants.headArray
import com.example.onboarding.Constants.imgArray

class ViewPagerAdapter(private val context: Context) : PagerAdapter() {

    var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
      return headArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider, container, false)

        val img = view.findViewById<ImageView>(R.id.onboarding_img)
        val txtHead = view.findViewById<TextView>(R.id.txt_head)
        val txtDescription = view.findViewById<TextView>(R.id.txt_description)

        img.setImageResource(imgArray[0])
        txtHead.text = headArray[position]
        txtDescription.text = descriptionArray[position]

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}