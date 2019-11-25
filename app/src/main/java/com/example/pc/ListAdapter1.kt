package com.example.pc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter1(var ctx: Context, var resource: Int, var item: List<Model1>)
    : ArrayAdapter<Model1>(ctx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.favorite_photo)
        val textView: TextView = view.findViewById(R.id.favorite_name)
        val textView1: TextView = view.findViewById(R.id.favorite_text)

        val item: Model1 = item[position]

        imageView.setImageDrawable(ctx.resources.getDrawable(item.photo))
        textView.text = item.name
        textView1.text = item.text

        return view
    }
}