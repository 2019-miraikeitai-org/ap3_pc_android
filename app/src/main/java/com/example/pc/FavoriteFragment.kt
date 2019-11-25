package com.example.pc

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //MainActivityの読み込み
//        val maActivity = activity as MainActivity

        //ソートを押下の処理
        cloth_after.setOnClickListener(this)
        hair_after.setOnClickListener(this)
        make_after.setOnClickListener(this)
        aroma_after.setOnClickListener(this)

        val list = mutableListOf<Model1>()
        list.add(Model1("name1", "text1", R.drawable.codew0))
        list.add(Model1("name2", "text2", R.drawable.codew1))

        val listView: ListView = view.findViewById(R.id.list_favorite)
        listView.adapter = ListAdapter1(this.requireContext(), R.layout.list_item1, list)

        listView.setOnItemClickListener { parent, view, position, id ->
            val fragment = DetailFragment()
            val bundle = Bundle()

            bundle.putInt("selected", position)
            fragment.arguments = bundle

            val transaction = fragmentManager!!.beginTransaction()

            transaction.replace(R.id.nav_host_fragment, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

//            if(position == 0){
//                Toast.makeText(this.requireContext(), "item2 clicked.", Toast.LENGTH_SHORT).show()
//            }
        }

        //左上ボタンの処理
        button.setOnClickListener {
            list.add(Model1("sample name", "sample text", R.drawable.codew0))
            listView.adapter = ListAdapter1(this.requireContext(), R.layout.list_item1, list)
        }
    }

    //各ボタンの押下の処理
    override fun onClick(view: View?) {
        when (view?.id){
            R.id.cloth_after -> {
                val cloth = view.findViewById(R.id.cloth_after) as ImageButton
                if (trig[0]){
                    cloth.setImageResource(R.drawable.clothb)
                    trig[0] = false
                } else {
                    cloth.setImageResource(R.drawable.clotha)
                    trig[0] = true
                }
            }
            R.id.hair_after -> {
                val hair = view.findViewById(R.id.hair_after) as ImageButton
                if (trig[1]){
                    hair.setImageResource(R.drawable.hairb)
                    trig[1] = false
                } else {
                    hair.setImageResource(R.drawable.haira)
                    trig[1] = true
                }
            }
            R.id.make_after -> {
                val make = view.findViewById(R.id.make_after) as ImageButton
                if (trig[2]){
                    make.setImageResource(R.drawable.makeb)
                    trig[2] = false
                } else {
                    make.setImageResource(R.drawable.makea)
                    trig[2] = true
                }
            }
            R.id.aroma_after -> {
                val aroma = view.findViewById(R.id.aroma_after) as ImageButton
                if (trig[3]){
                    aroma.setImageResource(R.drawable.aromab)
                    trig[3] = false
                } else {
                    aroma.setImageResource(R.drawable.aromaa)
                    trig[3] = true
                }
            }
        }
    }
}
//ボタンのトリガー
val trig: Array<Boolean> = arrayOf(true, true, true, true)
