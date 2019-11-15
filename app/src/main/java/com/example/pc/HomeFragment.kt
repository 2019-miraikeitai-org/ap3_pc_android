package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
//import android.R
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_tab1.*


class HomeFragment : Fragment(){

    lateinit var viewPager: ViewPager

    lateinit var viewPagerAdapter: ViewPagerAdapter

    fun newInstance(): HomeFragment {
        return HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewPager = view.findViewById(R.id.pager)
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        viewPager.adapter = viewPagerAdapter
        return view
    }




    class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        private val NUM_ITEMS = 2



        override fun getCount(): Int {
            return NUM_ITEMS
        }

        override fun getItem(position: Int): Fragment {
            return if (position == 0) {
                Tab1Fragment()
            } else {
                Tab2Fragment()
            }
        }


        override fun getPageTitle(position: Int): CharSequence? {

            return if (position == 0) {
                "MEN"
            } else {
                "WOMEN"
            }
        }

    }

}




class Tab2Fragment: Fragment(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab2,container,false)
    }
}