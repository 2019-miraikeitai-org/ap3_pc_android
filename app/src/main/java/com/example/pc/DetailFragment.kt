package com.example.pc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    private var p : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        p = interim_position

        if(user_list_favorite.contains(sample_user_list_all[p])){
            top_clap.setImageResource(R.drawable.clap1)
            middle_clap.setImageResource(R.drawable.clap1)
        } else {
            top_clap.setImageResource(R.drawable.clap)
            middle_clap.setImageResource(R.drawable.clap)
        }
        text_name.text = sample_user_list_all[p].user_name
        val height: String = sample_user_list_all[p].user_height.toString() + "cm"
        text_height.text = height
        text_gender.text = if (sample_user_list_all[p].user_gender) "MEN" else "WOMEN"
//        detail_picture.setImageResource(sample_user_list_all[p].picture.picture_id)
        Picasso.with(context).load(sample_user_list_all[p].picture.picture_id).into(detail_picture)
        text.text = sample_user_list_all[p].picture.picture_text

//        tag1.text = sample_user_list_all[p].picture.tag1.type
//        tag2.text = sample_user_list_all[p].picture.tag2.type
//        tag3.text = sample_user_list_all[p].picture.tag3.type
//        tag4.text = sample_user_list_all[p].picture.tag4.type

        val spinnerItems1 = arrayListOf(
            sample_user_list_all[p].picture.tag1.type,
            sample_user_list_all[p].picture.tag1.brand,
            sample_user_list_all[p].picture.tag1.size,
            "${sample_user_list_all[p].picture.tag1.price}")
        var adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, spinnerItems1)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag1.adapter = adapter

        val spinnerItems2 = arrayListOf(
            sample_user_list_all[p].picture.tag2.type,
            sample_user_list_all[p].picture.tag2.brand,
            sample_user_list_all[p].picture.tag2.size,
            "${sample_user_list_all[p].picture.tag2.price}")
        adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, spinnerItems2)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag2.adapter = adapter

        val spinnerItems3 = arrayListOf(
            sample_user_list_all[p].picture.tag3.type,
            sample_user_list_all[p].picture.tag3.brand,
            sample_user_list_all[p].picture.tag3.size,
            "${sample_user_list_all[p].picture.tag3.price}")
        adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, spinnerItems3)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag3.adapter = adapter

        val spinnerItems4 = arrayListOf(
            sample_user_list_all[p].picture.tag4.type,
            sample_user_list_all[p].picture.tag4.brand,
            sample_user_list_all[p].picture.tag4.size,
            "${sample_user_list_all[p].picture.tag4.price}")
        adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, spinnerItems4)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag4.adapter = adapter

        top_clap.setOnClickListener {
            if(user_list_favorite.contains(sample_user_list_all[p])){
                user_list_favorite.remove(sample_user_list_all[p])
                top_clap.setImageResource(R.drawable.clap)
                middle_clap.setImageResource(R.drawable.clap)
            } else {
                user_list_favorite.add(sample_user_list_all[p])
                top_clap.setImageResource(R.drawable.clap1)
                middle_clap.setImageResource(R.drawable.clap1)
            }
        }

        middle_clap.setOnClickListener {
            if(user_list_favorite.contains(sample_user_list_all[p])){
                user_list_favorite.remove(sample_user_list_all[p])
                top_clap.setImageResource(R.drawable.clap)
                middle_clap.setImageResource(R.drawable.clap)
            } else {
                user_list_favorite.add(sample_user_list_all[p])
                top_clap.setImageResource(R.drawable.clap1)
                middle_clap.setImageResource(R.drawable.clap1)
            }
        }

        val uri: Uri = Uri.parse("https://www.nike.com/jp/")
        val i = Intent(Intent.ACTION_VIEW, uri)

        tag1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition
                if (item == 1){
                    startActivity(i)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        tag2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition
                if (item == 1){
                    startActivity(i)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        tag3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition
                if (item == 1){
                    startActivity(i)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        tag4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition
                if (item == 1){
                    startActivity(i)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }


/*        tag1.setOnClickListener {
            startActivity(i)
        }
        tag2.setOnClickListener {
            startActivity(i)
        }
        tag3.setOnClickListener {
            startActivity(i)
        }
        tag4.setOnClickListener {
            startActivity(i)
        }*/
    }
}
