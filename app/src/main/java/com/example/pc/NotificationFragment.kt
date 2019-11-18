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

        //通知リストの作成
        val arrayAdapter = Custom2ArrayAdapter(this.requireContext(), 0).apply {
            add(ListItem2("Name", "Time"))
        }
        //通知リストとUIを結びつける
        val listView: ListView = view.findViewById(R.id.list_notify)
        //通知リストをUIに表示
        listView.adapter = arrayAdapter

        //左上ボタンの処理
        button.setOnClickListener {
            //ボタンを押したときの日付の取得
            fun getToday(): String{
                val date = Date()
                val format = SimpleDateFormat("yyyy/MM/dd/HH:mm", Locale.getDefault())
                return format.format(date)
            }
            //通知リストへ名前と取得した日付を追加
            arrayAdapter.add(ListItem2("name", getToday()))
            listView.adapter = arrayAdapter
        }
    }
}

//通知リスト用のカスタムリストの構造
class Custom2ArrayAdapter: ArrayAdapter<ListItem2> {
    private var inflater: LayoutInflater? = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    constructor(context: Context, resource: Int): super(context, resource)

    //リスト内の構造
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var viewHolder: ViewHolder
        var view = convertView

        //リストのアイコン/名前/日付とUIを結びつける
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

        //リストのアイコン/名前/日付を追加
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