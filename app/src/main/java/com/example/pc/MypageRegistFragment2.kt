package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pc.MypageRegistFragment2Directions.Companion.actionMypageRegistFragment2ToMypageRegistFragment1
import kotlinx.android.synthetic.main.fragment_mypageregist2.*

class MypageRegistFragment2: Fragment(), View.OnClickListener  {

    private val args2: MypageRegistFragment2Args by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypageregist2, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tagname.text = args2.tagname

        tops.setOnClickListener(this)
        bottoms.setOnClickListener(this)
        shoes.setOnClickListener(this)
        outer.setOnClickListener(this)
        bag.setOnClickListener(this)
        accessory.setOnClickListener(this)
        f.setOnClickListener(this)
        s.setOnClickListener(this)
        m.setOnClickListener(this)
        l.setOnClickListener(this)
        xl.setOnClickListener(this)
        back.setOnClickListener(this)
    }

    override fun onClick(view: View) {


        when (view.id) {
            R.id.tops -> {
                val topsb = view.findViewById(R.id.tops) as ImageButton

                if (trig3[0]) {
                    topsb.setImageResource(R.drawable.ttopsa)
                    trig3[0] = false
                } else {
                    topsb.setImageResource(R.drawable.ttopsb)
                    trig3[0] = true
                }
            }

            R.id.bottoms -> {
                val bottomb = view.findViewById(R.id.bottoms) as ImageButton

                if (trig3[1]) {
                    bottomb.setImageResource(R.drawable.bottoma)
                    trig3[1] = false
                } else {
                    bottomb.setImageResource(R.drawable.bottomb)
                    trig3[1] = true
                }
            }
            R.id.shoes -> {
                val shoesb = view.findViewById(R.id.shoes) as ImageButton

                if (trig3[2]) {
                    shoesb.setImageResource(R.drawable.shoesa)
                    trig3[2] = false
                } else {
                    shoesb.setImageResource(R.drawable.shoesb)
                    trig3[2] = true
                }
            }

            R.id.outer -> {
                val outerb = view.findViewById(R.id.outer) as ImageButton

                if (trig3[3]) {
                    outerb.setImageResource(R.drawable.outera)
                    trig3[3] = false
                } else {
                    outerb.setImageResource(R.drawable.outerb)
                    trig3[3] = true
                }
            }

            R.id.bag -> {
                val bagb = view.findViewById(R.id.bag) as ImageButton

                if (trig3[4]) {
                    bagb.setImageResource(R.drawable.baga)
                    trig3[4] = false
                } else {
                    bagb.setImageResource(R.drawable.bagb)
                    trig3[4] = true
                }
            }

            R.id.accessory -> {
                val accessoryb = view.findViewById(R.id.accessory) as ImageButton

                if (trig3[5]) {
                    accessoryb.setImageResource(R.drawable.accessorya)
                    trig3[5] = false
                } else {
                    accessoryb.setImageResource(R.drawable.accessoryb)
                    trig3[5] = true
                }
            }

            R.id.f -> {
                val fb = view.findViewById(R.id.f) as ImageButton

                if (trig3[6]) {
                    fb.setImageResource(R.drawable.fa)
                    trig3[6] = false
                } else {
                    fb.setImageResource(R.drawable.fb)
                    trig3[6] = true
                }
            }

            R.id.s -> {
                val sb = view.findViewById(R.id.s) as ImageButton

                if (trig3[7]) {
                    sb.setImageResource(R.drawable.sa)
                    trig3[7] = false
                } else {
                    sb.setImageResource(R.drawable.sb)
                    trig3[7] = true
                }
            }

            R.id.m -> {
                val mb = view.findViewById(R.id.m) as ImageButton

                if (trig3[8]) {
                    mb.setImageResource(R.drawable.ma)
                    trig3[8] = false
                } else {
                    mb.setImageResource(R.drawable.mb)
                    trig3[8] = true
                }
            }

            R.id.l -> {
                val lb = view.findViewById(R.id.l) as ImageButton

                if (trig3[9]) {
                    lb.setImageResource(R.drawable.la)
                    trig3[9] = false
                } else {
                    lb.setImageResource(R.drawable.lb)
                    trig3[9] = true
                }
            }
            R.id.xl -> {
                val xlb = view.findViewById(R.id.xl) as ImageButton

                if (trig3[10]) {
                    xlb.setImageResource(R.drawable.xla)
                    trig3[10] = false
                } else {
                    xlb.setImageResource(R.drawable.xlb)
                    trig3[10] = true
                }
            }






            R.id.back -> {
                findNavController().navigate(R.id.action_MypageRegistFragment2_to_MypageRegistFragment1)

            }

        }
    }


}

val trig3: Array<Boolean> = arrayOf(true, true, true, true, true, true, true, true, true, true, true)