package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_tab2.*
import kotlinx.android.synthetic.main.list_item.*

class Tab2Fragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridItem = ArrayList<Int>()
        for (user in user_list_women){
            gridItem.add(user.picture.picture_id)
        }

        val adapter = ListAdapter(this.requireContext(), R.layout.list_item, gridItem)
        val gridView: GridView = view.findViewById(R.id.tab1_gridView)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, view, i, l ->
            interim_position = user_list_women[i].user_id
            findNavController().navigate(R.id.detail)
        }
    }
}
