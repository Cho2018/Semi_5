package com.example.semi_5

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var subjectList = arrayListOf<Subject>(
        Subject("인터렉션디자인", "12:00~15:00", "list_selector"),
        Subject("인터렉션디자인", "12:00~15:00", "list_selector"),
        Subject("인터렉션디자인", "12:00~15:00", "list_selector")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureMainTab()

        val subjectAdapter = MainListAdapter(this, subjectList)
        subject_list.adapter = subjectAdapter
    }

    private fun configureMainTab() {
        vp_main_slider.adapter = SliderMainPagerAdapter(supportFragmentManager, 3)
        vp_main_slider.offscreenPageLimit = 2
        tl_main_indicator.setupWithViewPager(vp_main_slider)
    }
}

class MainListAdapter(val context: Context, val subjectList: ArrayList<Subject>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_row, null)

        val subjectName = view.findViewById<TextView>(R.id.subject_name)
        val subjectTime = view.findViewById<TextView>(R.id.subject_time)
        val subjectCheck = view.findViewById<ImageView>(R.id.subject_check)

        val subject = subjectList[position]
        val resourceId = context.resources.getIdentifier(subject.subject_check, "drawable", context.packageName)
        subjectCheck.setImageResource(resourceId)
        subjectName.text = subject.subject_name
        subjectTime.text = subject.subject_time

        subjectCheck.setOnClickListener{
            subjectCheck.isSelected = !subjectCheck.isSelected

            if (subjectCheck.isSelected) {
                subjectName.setTextColor(Color.DKGRAY)
            } else {
                subjectName.setTextColor(Color.BLUE)
            }
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return subjectList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return subjectList.size
    }
}
