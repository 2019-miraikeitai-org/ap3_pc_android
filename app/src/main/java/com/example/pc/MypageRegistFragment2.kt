package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_mypageregist2.*

class MypageRegistFragment2: Fragment(), View.OnClickListener  {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypageregist2, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tops.setOnClickListener(this)
    }

    override fun onClick(view: View) {


        when (view.id) {
            R.id.tops -> {
                val topsb = view.findViewById(R.id.tops) as ImageButton

                if (trig1[0]) {
                    topsb.setImageResource(R.drawable.ttopsa)
                    trig1[0] = false
                } else {
                    topsb.setImageResource(R.drawable.ttopsb)
                    trig1[0] = true
                }
            }

        }
    }


}