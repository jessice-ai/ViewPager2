package com.example.sun1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * sunviewpager 创建一个适配器
         */
        sunviewpager.adapter = object : FragmentStateAdapter(this){
            //告诉 ViewPager 里面有几个页面
            override fun getItemCount(): Int {
                return 3 //总共三个页面
            }
            //告诉 ViewPager 那个位置对应那个页面
            override fun createFragment(position: Int) : Fragment {
                return when(position){
                    0-> OneFragment()
                    1-> TwoFragment()
                    else->ThreeFragment()
                }
            }
        }

        /**
         * 将 Tablayout 跟 ViewPager 结合起来
         */
        TabLayoutMediator(suntablayout,sunviewpager){tab,position->
            //初始化，设定标题
            when(position){
                0->tab.text = "缩放"
                1->tab.text = "旋转"
                else-> tab.text = "移动"
            }
        }.attach()
    }
}