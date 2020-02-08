package com.example.pc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ListAdapter (private var ctx: Context, var resource: Int, var item: List<Int>)
    : ArrayAdapter<Int>(ctx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.list_item_picture)
        val item: Int = item[position]
//        imageView.setImageResource(item)
        Picasso.with(context).load(item).into(imageView)

        return view
    }
}