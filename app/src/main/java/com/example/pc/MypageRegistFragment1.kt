package com.example.pc

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
//import androidx.versionedparcelable.VersionedParcel
//import androidx.car.cluster.navigation.Richtext
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import kotlinx.android.synthetic.main.fragment_mypageregist1.*
import kotlinx.android.synthetic.main.fragment_mypageregist1.view.*
import android.widget.NumberPicker






class MypageRegistFragment1 : Fragment(),View.OnClickListener {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypageregist1, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val data = arrayOf("hoge", "fuga", "piyo")
        //val picker = view.findViewById(R.id.numberPicker) as NumberPicker
        //picker.displayedValues = data

        //val comment = activity?.findViewById(R.id.comment) as TextView
        // R.id.reserve_2cはフラグメント1内の書き込みたいセルのid

        //val edit_text = view.findViewById(R.id.edit_text) as EditText

        back2.setOnClickListener(this)
        tag1_before.setOnClickListener(this)
        tag2_before.setOnClickListener(this)
        tag3_before.setOnClickListener(this)
        tag4_before.setOnClickListener(this)
        regist_button.setOnClickListener(this)

    }




    override fun onClick(view: View) {


        when (view.id){
            R.id.back2-> {
                findNavController().navigate(R.id.action_regist1_to_mypage)
            }

            R.id.tag1_before-> {
                val topsb = view.findViewById(R.id.tag1_before)  as ImageButton

                if (trig2[0]){
                    topsb.setImageResource(R.drawable.tag11)
                    trig2[0] = false

                    val tagname = "Tag1"
                    // 生成されたクラスに引数を渡して遷移
                    val ac1 =MypageRegistFragment1Directions.actionMypageRegistFragment1ToMypageRegistFragment2(tagname)
                    findNavController().navigate(ac1)

                    //findNavController().navigate(R.id.action_MypageRegistFragment1_to_MypageRegistFragment2)
                } else {
                    topsb.setImageResource(R.drawable.tag1)
                    trig2[0] = true
                }
            }

            R.id.tag2_before -> {
                val bottomsb = view.findViewById(R.id.tag2_before) as ImageButton

                if (trig2[1]){
                    bottomsb.setImageResource(R.drawable.tag21)
                    trig2[1] = false

                    val tagname = "Tag2"
                    // 生成されたクラスに引数を渡して遷移
                    val ac2 =MypageRegistFragment1Directions.actionMypageRegistFragment1ToMypageRegistFragment2(tagname)
                    findNavController().navigate(ac2)
                } else {
                    bottomsb.setImageResource(R.drawable.tag2)
                    trig2[1] = true
                }
            }

            R.id.tag3_before -> {
                val accb = view.findViewById(R.id.tag3_before) as ImageButton

                if (trig2[2]){
                    accb.setImageResource(R.drawable.tag31)
                    trig2[2] = false

                    val tagname = "Tag3"
                    // 生成されたクラスに引数を渡して遷移
                    val ac3 =MypageRegistFragment1Directions.actionMypageRegistFragment1ToMypageRegistFragment2(tagname)
                    findNavController().navigate(ac3)
                } else {
                    accb.setImageResource(R.drawable.tag3)
                    trig2[2] = true
                }
            }
            R.id.tag4_before -> {
                val moreb = view.findViewById(R.id.tag4_before) as ImageButton

                if (trig2[3]){
                    moreb.setImageResource(R.drawable.tag41)
                    trig2[3] = false

                    val tagname = "Tag4"
                    // 生成されたクラスに引数を渡して遷移
                    val ac4 =MypageRegistFragment1Directions.actionMypageRegistFragment1ToMypageRegistFragment2(tagname)
                    findNavController().navigate(ac4)
                } else {
                    moreb.setImageResource(R.drawable.tag4)
                    trig2[3] = true
                }
            }

            R.id.regist_button -> {

                // EditTextの中身を取り出す
                //val edittext = view.findViewById(R.id.edit_text)  as EditText
                val content = edit_text.text.toString()


                // 生成されたクラスに引数を渡して遷移
                val action =MypageRegistFragment1Directions.actionRegist1ToMypage(content)
                findNavController().navigate(action)




                //comment.text = edit_text.getSelectedItem() as String

                //マイページへ遷移
                //Navigation.findNavController(view).navigate(R.id.action_regist1_to_mypage)

            }
        }
    }

}

val trig2: Array<Boolean> = arrayOf(true, true, true, true)