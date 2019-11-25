package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_mypageregist1.*

class Fragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment, container, false)
        val content = "sumple"


        // 生成されたクラスに引数を渡して遷移
        val action =FragmentDirections.actionFragmentToNavigationMypage(content)
        findNavController().navigate(action)

    }





}