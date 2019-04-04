package com.vathna.saaavy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_walk_through.*

class WalkThroughActivity : AppCompatActivity() {

    private val mAdapter = SectionsPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_through)

        vpWalkThrough.adapter = mAdapter

        vpWalkThrough.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                indicator1.setImageResource(R.drawable.indicator_unselected)
                indicator2.setImageResource(R.drawable.indicator_unselected)
                indicator3.setImageResource(R.drawable.indicator_unselected)
                tvNext.text = "Next"
                when (position) {
                    0 -> indicator1.setImageResource(R.drawable.indicator_selected)
                    1 -> indicator2.setImageResource(R.drawable.indicator_selected)
                    2 -> {
                        indicator3.setImageResource(R.drawable.indicator_selected)
                        tvNext.text = "Ready"
                    }
                }
            }

            override fun onPageSelected(position: Int) {
            }
        })

        tvNext.setOnClickListener {
            it as TextView
            if (it.text == "Next")
                vpWalkThrough.setCurrentItem(vpWalkThrough.currentItem + 1, true)
            else
                tvSkip.performClick()
        }

        tvSkip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}
