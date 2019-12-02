package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_tab1.*

class Tab1Fragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridItem = ArrayList<Int>()
        for (user in user_list_men){
            gridItem.add(user.picture.picture_id)
        }

        val adapter = ListAdapter(this.requireContext(), R.layout.list_item, gridItem)
        val gridView: GridView = view.findViewById(R.id.tab1_gridView)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, view, i, l ->
            interim_position = user_list_men[i].user_id
            findNavController().navigate(R.id.detail)
        }

/*        Picasso.with(context)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSwd0-rYWZSIgQOcSgON9lnAI_IM_CnHEWGhcR6XP9ZgbUC3APp")
            .into(code1)
        Picasso.with(context)
            .load("https://www.soccer-king.jp/wp-content/uploads/2013/06/CAVANI-1.jpg")
            .into(code2)
        Picasso.with(context)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4YSkiLvxwlLIuHgsdE8Fk5agwtUE6Hkdfk7AL33jxN6zWkRon")
            .into(code3)

        //crashする
        code1.setOnClickListener {
            findNavController().navigate(
                Tab1FragmentDirections.actionTab1ToDetail2(
                    content = "hogehoge"
                )
            )
        }

        code2.setOnClickListener {
            Toast.makeText(this.requireContext(), "item clicked.", Toast.LENGTH_SHORT).show()
        }

        code3.setOnClickListener {
            Toast.makeText(this.requireContext(), "item clicked.", Toast.LENGTH_SHORT).show()
        }*/
    }
}

