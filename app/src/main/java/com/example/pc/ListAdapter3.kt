package com.example.pc

import android.app.PendingIntent.getActivity
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import org.w3c.dom.Text
import java.io.IOException

class ListAdapter3(private var ctx: Context, var resource: Int, var item: List<Picture_uri>)
    : ArrayAdapter<Picture_uri>(ctx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.my_picture)
        val comment: TextView = view.findViewById(R.id.comment)
        val tag1: TextView = view.findViewById(R.id.tag1)
        val tag2: TextView = view.findViewById(R.id.tag2)
        val tag3: TextView = view.findViewById(R.id.tag3)
        val tag4: TextView = view.findViewById(R.id.tag4)

        val item: Picture_uri = item[position]

        try {
            //val bitmap = BitmapFactory.decodeFile(toString(item.picture_id_uri))
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, item.picture_id_uri)
            imageView.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        //imageView.setImageResource()
        comment.text = item.picture_text2
        tag1.text = item.tag12.type
        tag2.text = item.tag22.type
        tag3.text = item.tag32.type
        tag4.text = item.tag42.type

        return view
    }
}