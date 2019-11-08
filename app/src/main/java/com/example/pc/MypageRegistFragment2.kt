package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_mypageregist1.view.*
import kotlinx.android.synthetic.main.fragment_mypageregist2.view.*

class MypageRegistFragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypageregist2, container, false)
        /*

        view.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_regist2_to_regist1)
        }
        */
        return view
    }

}