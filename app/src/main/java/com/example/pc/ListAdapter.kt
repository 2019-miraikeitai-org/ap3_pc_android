package com.example.pc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView

class ListAdapter(var ctx: Context, var resource: Int, var item: List<Model>)
    : ArrayAdapter<Model>(ctx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.home_photo)
        val item: Model = item[position]
        imageView.setImageDrawable(ctx.resources.getDrawable(item.photo))

        return view
    }
}
