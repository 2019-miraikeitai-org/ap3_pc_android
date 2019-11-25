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

        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT6Cfgvxw9-7mBMam3j-_V-xHh9OMewOey5F4GxC2uZr-1kdVdr").into(codew1);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcREXqzTUZ5R0Fpkhk9QlwC1B1Fy-NsR8w_MM0spEgK2sh7uzb2l").into(codew2);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSwb30diTPd3fWWXB9DKHtGojNvom0wt8VmnHnP4_bG8Qhf5JwP").into(codew3);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRV3K6f75NcgNYCoHJ3iuLlFK5UAG5pbKvP7CaXnFEAnLqy0Yde").into(codew4);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRE2cotUD0qoGMCHZQIGRxzL4M-MQN8-AyLqoR4o93Oqz3J3AwM").into(codew5);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQUEA-OhHHY0AooqJoiaIq2kWyCUsIfJMV_wGzKPwme-wPJJK4M").into(codew6);
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(codew7);
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(codew8);



            val transaction = fragmentManager!!.beginTransaction()

            transaction.addToBackStack(null)
            transaction.replace(R.id.pager, fragment)
            transaction.commit()
        }
    }
}
