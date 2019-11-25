package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<Model2>()
        list.add(Model2("name1", R.drawable.profile))

        val listView: ListView = view.findViewById(R.id.list_notify)
        listView.adapter = ListAdapter2(this.requireContext(), R.layout.list_item2, list)

        //左上ボタンの処理
        button.setOnClickListener {
            list.add(Model2("sample name", R.drawable.profile))
            listView.adapter = ListAdapter2(this.requireContext(), R.layout.list_item2, list)
        }
    }
}
