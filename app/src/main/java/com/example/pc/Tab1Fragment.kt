package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_tab1.*

class Tab1Fragment: Fragment(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab1,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        codem1.setOnClickListener(this)


    }


    override fun onClick(view: View) {
        when (view.id) {

            R.id.codem1 -> {

                //val action =Tab1FragmentDirections.actionTab1ToHomeDetails()
                //findNavController().navigate(action)

                //findNavController().navigate(R.id.action_tab1_to_home_details)
            }
        }
    }
}