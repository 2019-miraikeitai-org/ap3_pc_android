package com.example.pc

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sort_tag1.setOnClickListener(this)
        sort_tag2.setOnClickListener(this)
        sort_tag3.setOnClickListener(this)
        sort_tag4.setOnClickListener(this)

        val listItem = ArrayList<User_sample>()
        for (user in user_list_favorite){
            listItem.add(user)
        }
        listItem.reverse()

        val adapter = ListAdapter2(this.requireContext(), R.layout.list_item2, listItem)
        val listView: ListView = view.findViewById(R.id.favorite_listView)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, view, i, _ ->
            val index = user_list_favorite.size - ( i + 1 )
            interim_position = user_list_favorite[index].user_id
            findNavController().navigate(R.id.detail)
        }
    }

    private val trig: Array<Boolean> = arrayOf(true, true, true, true)
    override fun onClick(view: View?) {
        when (view?.id){
            R.id.sort_tag1 -> {
                val tag1 = view.findViewById(R.id.sort_tag1) as ImageButton
                if (trig[0]){
                    tag1.setImageResource(R.drawable.tag1)
                    trig[0] = false
                } else {
                    tag1.setImageResource(R.drawable.tag11)
                    trig[0] = true
                }
            }
            R.id.sort_tag2 -> {
                val tag2 = view.findViewById(R.id.sort_tag2) as ImageButton
                if (trig[1]){
                    tag2.setImageResource(R.drawable.tag2)
                    trig[1] = false
                } else {
                    tag2.setImageResource(R.drawable.tag21)
                    trig[1] = true
                }
            }
            R.id.sort_tag3 -> {
                val tag3 = view.findViewById(R.id.sort_tag3) as ImageButton
                if (trig[2]){
                    tag3.setImageResource(R.drawable.tag3)
                    trig[2] = false
                } else {
                    tag3.setImageResource(R.drawable.tag31)
                    trig[2] = true
                }
            }
            R.id.sort_tag4 -> {
                val tag4 = view.findViewById(R.id.sort_tag4) as ImageButton
                if (trig[3]){
                    tag4.setImageResource(R.drawable.tag4)
                    trig[3] = false
                } else {
                    tag4.setImageResource(R.drawable.tag41)
                    trig[3] = true
                }
            }
        }
    }
}

