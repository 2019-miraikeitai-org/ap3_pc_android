package com.example.pc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ListAdapter2(var ctx: Context, var resource: Int, var item: List<Model2>)
    : ArrayAdapter<Model2>(ctx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.notify_photo)
        val textView: TextView = view.findViewById(R.id.notify_name)
        val textView2: TextView = view.findViewById(R.id.notify_time)

        val item: Model2 = item[position]

        fun getToday(): String{
            val date = Date()
            val format = SimpleDateFormat("yyyy/MM/dd/HH:mm", Locale.getDefault())
            return  format.format(date)
        }

        imageView.setImageDrawable(ctx.resources.getDrawable(item.photo))
        textView.text = item.name
        textView2.text = getToday()

        return view
    }
}