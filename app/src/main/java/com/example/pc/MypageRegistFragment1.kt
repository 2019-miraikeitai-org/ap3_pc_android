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

class MypageRegistFragment1 : Fragment(),View.OnClickListener {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mypageregist1, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val comment = activity?.findViewById(R.id.comment) as TextView
        // R.id.reserve_2cはフラグメント1内の書き込みたいセルのid

        //val edit_text = view.findViewById(R.id.edit_text) as EditText

        tops_before.setOnClickListener(this)
        bottoms_before.setOnClickListener(this)
        acc_before.setOnClickListener(this)
        more_before.setOnClickListener(this)
        regist_button.setOnClickListener(this)

    }




    override fun onClick(view: View) {


        when (view.id){
            R.id.tops_before-> {
                val topsb = view.findViewById(R.id.tops_before)  as ImageButton
                topsb.setBackgroundResource(R.drawable.topsa)
                //Navigation.findNavController(view).navigate(R.id.action_regist1_to_regist2)
            }

            R.id.bottoms_before -> {
                val bottomsb = view.findViewById(R.id.bottoms_before) as ImageButton
                bottomsb.setImageResource(R.drawable.bottomsa)
                //Navigation.findNavController(view).navigate(R.id.action_regist1_to_regist2)
            }

            R.id.acc_before -> {
                val accb = view.findViewById(R.id.acc_before) as ImageButton
                accb.setBackgroundResource(R.drawable.acca)
                //Navigation.findNavController(view).navigate(R.id.action_regist1_to_regist2)
            }
            R.id.more_before -> {
                val moreb = view.findViewById(R.id.more_before) as ImageButton
                moreb.setImageResource(R.drawable.morea)
                //Navigation.findNavController(view).navigate(R.id.action_regist1_to_regist2)
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