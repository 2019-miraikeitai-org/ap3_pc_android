package com.example.pc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_favorite.button
import kotlinx.android.synthetic.main.fragment_mypageregist1.*
import kotlinx.android.synthetic.main.list_items.*


class FavoriteFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cloth_after.setOnClickListener(this)
        hair_after.setOnClickListener(this)
        make_after.setOnClickListener(this)
        aroma_after.setOnClickListener(this)
//        item_image.setOnClickListener(this)

        val arrayAdapter = CustomArrayAdapter(this.requireContext(), 0).apply {
            add(ListItem("What's your name?", "What do you want to convey?"))
        }
        val listView: ListView = view.findViewById(R.id.list_favorite)
//        val header = View.inflate(this.requireContext(), R.layout.header, null)
//        listView.addHeaderView(header, null, false)
        listView.adapter = arrayAdapter

        button.setOnClickListener {
            arrayAdapter.add(ListItem("Apple", "iPhone"))
            listView.adapter = arrayAdapter
        }
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.cloth_after -> {
                val clotha = view.findViewById(R.id.cloth_after) as ImageButton
                if (trig[0]){
                    clotha.setImageResource(R.drawable.clothb)
                    trig[0] = false
                } else {
                    clotha.setImageResource(R.drawable.clotha)
                    trig[0] = true
                }
            }
            R.id.hair_after -> {
                val haira = view.findViewById(R.id.hair_after) as ImageButton
                if (trig[1]){
                    haira.setImageResource(R.drawable.hairb)
                    trig[1] = false
                } else {
                    haira.setImageResource(R.drawable.haira)
                    trig[1] = true
                }
            }
            R.id.make_after -> {
                val makea = view.findViewById(R.id.make_after) as ImageButton
                if (trig[2]){
                    makea.setImageResource(R.drawable.makeb)
                    trig[2] = false
                } else {
                    makea.setImageResource(R.drawable.makea)
                    trig[2] = true
                }
            }
            R.id.aroma_after -> {
                val aromaa = view.findViewById(R.id.aroma_after) as ImageButton
                if (trig[3]){
                    aromaa.setImageResource(R.drawable.aromab)
                    trig[3] = false
                } else {
                    aromaa.setImageResource(R.drawable.aromaa)
                    trig[3] = true
                }
            }
            R.id.item_image -> {
                val itemimage = view.findViewById(R.id.item_image) as ImageButton
                val textView: TextView = view.findViewById(R.id.item_description)

                itemimage.setOnClickListener {
                    textView.text = "iPhone XS"
                }

                /*itemimage.setOnClickListener {
                    val intent = Intent(this.requireContext(), DetailFragment::class.java)
                    startActivity(intent)
                }*/
            }
        }
    }
}

val trig: Array<Boolean> = arrayOf(true, true, true, true)

class ListItem(val name: String){
    var description: String = "No description."
    constructor(name: String, description: String): this(name){
        this.description = description
    }
}

class  CustomArrayAdapter: ArrayAdapter<ListItem> {
    private var inflater: LayoutInflater? =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?

    constructor(context: Context, resource: Int) : super(context, resource)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var viewHolder: ViewHolder
        var view = convertView

        if (view == null) {
            view = inflater!!.inflate(R.layout.list_items, parent, false)
            viewHolder = ViewHolder(
                view.findViewById(R.id.item_image),
                view.findViewById(R.id.item_name),
                view.findViewById(R.id.item_description)
            )
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val listItem = getItem(position)
//        viewHolder.picture.setImageResource()
        viewHolder.name.text = listItem.name
        viewHolder.description.text = listItem.description
        viewHolder.picture.setOnClickListener{
//            val fragmentManager = FragmentManager
//            val fragmentTransaction = fragmentManager.T

        }

        return view!!
    }

    override fun isEnabled(position: Int): Boolean {
        return false
    }
}