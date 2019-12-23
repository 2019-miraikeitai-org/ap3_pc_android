package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment.*


class Fragment: Fragment() , View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start_button.setOnClickListener(this)

    }

    override fun onClick(view: View) {


        when (view.id) {

            R.id.start_button -> {

                // 生成されたクラスに引数を渡して遷移
                val action = FragmentDirections.actionFragmentToNavigationHome()

                findNavController().navigate(action)
            }


        }
    }
}