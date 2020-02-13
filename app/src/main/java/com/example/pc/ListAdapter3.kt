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
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment.view.*
import org.w3c.dom.Text
import java.io.IOException

class ListAdapter3(private var ctx: Context, var resource: Int, var item: List<Picture_uri>)
    : ArrayAdapter<Picture_uri>(ctx, resource, item){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(resource, null)

        val imageView: ImageView = view.findViewById(R.id.my_picture)
        val comment: TextView = view.findViewById(R.id.comment)
        val tag1: Spinner = view.findViewById(R.id.tag1)
        val tag2: Spinner = view.findViewById(R.id.tag2)
        val tag3: Spinner = view.findViewById(R.id.tag3)
        val tag4: Spinner = view.findViewById(R.id.tag4)

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
        //tag1.text = item.tag12.type
        //tag2.text = item.tag22.type
        //tag3.text = item.tag32.type
        //tag4.text = item.tag42.type


        val spinnerItems1 = arrayListOf(
            item.tag12.type,
            item.tag12.brand,
            item.tag12.size,
            "${item.tag12.price}")
        var adapter = ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, spinnerItems1)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag1.adapter = adapter

        val spinnerItems2 = arrayListOf(
            item.tag22.type,
            item.tag22.brand,
            item.tag22.size,
            "${item.tag22.price}")
        adapter = ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, spinnerItems2)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag2.adapter = adapter

        val spinnerItems3 = arrayListOf(
            item.tag32.type,
            item.tag32.brand,
            item.tag32.size,
            "${item.tag32.price}")
        adapter = ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, spinnerItems3)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag3.adapter = adapter

        val spinnerItems4 = arrayListOf(
            item.tag42.type,
            item.tag42.brand,
            item.tag42.size,
            "${item.tag42.price}")
        adapter = ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, spinnerItems4)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        tag4.adapter = adapter




        tag1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        tag2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        tag3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        tag4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val spinnerParent = p0 as Spinner
                val item = spinnerParent.selectedItemPosition

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }


        return view
    }
}