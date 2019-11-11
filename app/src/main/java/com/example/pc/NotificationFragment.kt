package com.example.pc

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_notification.*
import java.text.SimpleDateFormat
import java.util.*


class NotificationFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter = Custom2ArrayAdapter(this.requireContext(), 0).apply {
            add(ListItem2("Name", "Time"))
        }
        val listView: ListView = view.findViewById(R.id.list_notify)
        listView.adapter = arrayAdapter

        button.setOnClickListener {
            fun getToday(): String{
                val date = Date()
                val format = SimpleDateFormat("yyyy/MM/dd/HH:mm", Locale.getDefault())
                return format.format(date)
            }
            arrayAdapter.add(ListItem2("name", getToday()))
            listView.adapter = arrayAdapter
        }
    }
}


class Custom2ArrayAdapter: ArrayAdapter<ListItem2> {
    private var inflater: LayoutInflater? = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    constructor(context: Context, resource: Int): super(context, resource)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var viewHolder: ViewHolder
        var view = convertView

        if (view == null){
            view = inflater!!.inflate(R.layout.list_item, parent, false)
            viewHolder = ViewHolder(
                view.findViewById(R.id.item_my_image),
                view.findViewById(R.id.item_name),
                view.findViewById(R.id.item_time)
            )
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val listItem = getItem(position)
//        viewHolder.picture
        viewHolder.name.text = listItem.name
        viewHolder.description.text = listItem.description

        return view!!
//        return super.getView(position, convertView, parent)
    }

    override fun isEnabled(position: Int): Boolean {
        return false
    }
}