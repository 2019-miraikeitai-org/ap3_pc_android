package com.example.pc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ListAdapter2(private var ctx: Context, var resource: Int, var item: List<User_sample>)
    : ArrayAdapter<User_sample>(ctx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.list_item_photo)
        val name: TextView = view.findViewById(R.id.list_item_name)
        val height: TextView = view.findViewById(R.id.list_item_height)
        val text: TextView = view.findViewById(R.id.list_item_text)

        val item: User_sample = item[position]

//        imageView.setImageResource(item.picture.picture_id)
        Picasso.with(context).load(item.picture.picture_id).into(imageView)
        name.text = item.user_name
        val h: String = item.user_height.toString() + "cm"
        height.text = h
        text.text = item.picture.picture_text

        return view
    }
}