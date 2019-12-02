package com.example.pc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
        detail_picture.setImageResource(sample_user_list_all[p].picture.picture_id)
        text.text = sample_user_list_all[p].picture.picture_text
        tag1.text = sample_user_list_all[p].picture.tag1.type
        tag2.text = sample_user_list_all[p].picture.tag2.type
        tag3.text = sample_user_list_all[p].picture.tag3.type
        tag4.text = sample_user_list_all[p].picture.tag4.type

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
        tag1.setOnClickListener {
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
        }
    }
}
