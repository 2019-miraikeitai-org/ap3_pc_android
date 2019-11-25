package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tab2.*

class Tab2Fragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Model>()

        for (i in 1 .. 5) {
            list.add(Model(R.drawable.codew1))
            list.add(Model(R.drawable.codew2))
            list.add(Model(R.drawable.codew3))
        }

        val gridView: GridView = view.findViewById(R.id.tab2_gridView)
        gridView.adapter = ListAdapter(this.requireContext(), R.layout.list_item, list)

        gridView.setOnItemClickListener { parent, view, position, id ->
            val fragment = DetailFragment()
            val bundle = Bundle()

            bundle.putInt("selected", position)
            fragment.arguments = bundle

            val transaction = fragmentManager!!.beginTransaction()

            transaction.addToBackStack(null)
            transaction.replace(R.id.pager, fragment)
            transaction.commit()
        }
    }
}
