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
//import android.R
import android.widget.NumberPicker
//import android.R





class MypageRegistFragment2: Fragment(), View.OnClickListener  {

    private val args2: MypageRegistFragment2Args by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypageregist2, container, false)


        var start = 1000
        val numbers = arrayOfNulls<String>(20)
        for (i in 0..19) {
            numbers[i] = start.toString() + ""
            start = start + 1000
        }

        val numberPicker = view.findViewById(R.id.numberPicker) as NumberPicker
        numberPicker.maxValue = 20
        numberPicker.minValue = 1
        numberPicker.displayedValues = numbers


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
        brand1.setOnClickListener(this)
        brand2.setOnClickListener(this)
        brand3.setOnClickListener(this)
        tagrg.setOnClickListener(this)
        back.setOnClickListener(this)
    }

    override fun onClick(view: View) {


        when (view.id) {
            R.id.tops -> {
                val topsb = view.findViewById(R.id.tops) as ImageButton

                if (trig3[0]) {
                    topsb.setImageResource(R.drawable.ttopsa)
                    trig3[0] = false
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.type="Tops"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.type="Tops"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.type="Tops"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.type="Tops"
                    }

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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.type="Bottoms"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.type="Bottoms"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.type="Bottoms"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.type="Bottoms"
                    }

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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.type="Shoes"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.type="Shoes"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.type="Shoes"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.type="Shoes"
                    }
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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.type="Outer"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.type="Outer"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.type="Outer"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.type="Outer"
                    }

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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.type="Bag"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.type="Bag"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.type="Bag"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.type="Bag"
                    }
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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.type="Accessory"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.type="Accessory"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.type="Accessory"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.type="Accessory"
                    }
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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.size="F"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.size="F"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.size="F"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.size="F"
                    }
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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.size="S"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.size="S"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.size="S"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.size="S"
                    }
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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.size="M"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.size="M"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.size="M"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.size="M"
                    }
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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.size="L"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.size="L"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.size="L"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.size="L"
                    }
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
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.size="XL"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.size="XL"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.size="XL"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.size="XL"
                    }
                } else {
                    xlb.setImageResource(R.drawable.xlb)
                    trig3[10] = true
                }

            }

            R.id.brand1 -> {
            val brand1b = view.findViewById(R.id.brand1) as ImageButton
                if (trig3[11]) {
                    brand1b.setImageResource(R.drawable.brand1a)
                    trig3[11] = false
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.brand="Brand1"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.brand="Brand1"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.brand="Brand1"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.brand="Brand1"
                    }
                } else {
                    brand1b.setImageResource(R.drawable.brand1b)
                    trig3[11] = true
                }
            }


            R.id.brand2 -> {
                val brand2b = view.findViewById(R.id.brand2) as ImageButton
                if (trig3[12]) {
                    brand2b.setImageResource(R.drawable.brand2a)
                    trig3[12] = false
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.brand="Brand2"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.brand="Brand2"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.brand="Brand2"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.brand="Brand2"
                    }
                } else {
                    brand2b.setImageResource(R.drawable.brand2b)
                    trig3[12] = true
                }
            }

            R.id.brand3 -> {
                val brand3b = view.findViewById(R.id.brand3) as ImageButton
                if (trig3[13]) {
                    brand3b.setImageResource(R.drawable.brand3a)
                    trig3[13] = false
                    if(args2.tagname=="Tag1"){
                        regist_list_mypage[k].tag12.brand="Brand3"
                    }else if(args2.tagname=="Tag2"){
                        regist_list_mypage[k].tag22.brand="Brand3"
                    }else if(args2.tagname=="Tag3"){
                        regist_list_mypage[k].tag32.brand="Brand3"
                    }else if(args2.tagname=="Tag4"){
                        regist_list_mypage[k].tag42.brand="Brand3"
                    }
                } else {
                    brand3b.setImageResource(R.drawable.brand3b)
                    trig3[13] = true
                }
            }


            R.id.back -> {
                val pic=args2.pic
                val action = MypageRegistFragment2Directions.actionMypageRegistFragment2ToMypageRegistFragment1(pic)
                findNavController().navigate(action)

            }


            R.id.tagrg -> {
                val filterb = view.findViewById(R.id.tagrg) as ImageButton
                filterb.setImageResource(R.drawable.filtera)

                if(args2.tagname=="Tag1"){
                    regist_list_mypage[k].tag12.price=numberPicker.getValue()*1000
                }else if(args2.tagname=="Tag2"){
                    regist_list_mypage[k].tag22.price=numberPicker.getValue()*1000
                }else if(args2.tagname=="Tag3"){
                    regist_list_mypage[k].tag32.price=numberPicker.getValue()*1000
                }else if(args2.tagname=="Tag4"){
                    regist_list_mypage[k].tag42.price=numberPicker.getValue()*1000
                }
                val pic=args2.pic
                val action = MypageRegistFragment2Directions.actionMypageRegistFragment2ToMypageRegistFragment1(pic)
                findNavController().navigate(action)

            }

        }
    }


}

val trig3: Array<Boolean> = arrayOf(true, true, true, true, true, true, true, true, true, true, true, true, true, true)