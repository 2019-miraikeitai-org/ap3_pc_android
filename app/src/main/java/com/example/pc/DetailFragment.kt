package com.example.pc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val args = arguments
        val selected: Int = args!!.getInt("selected")
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)

        val name: TextView = view.findViewById(R.id.detail_name)
        val height: TextView = view.findViewById(R.id.detail_height)
        val photo: ImageView = view.findViewById(R.id.detail_photo)
        val text: TextView = view.findViewById(R.id.detail_text)

        name.text = selected.toString()
        height.text = "160"
        photo.setImageResource(R.drawable.codew0)
        text.text = selected.toString()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
