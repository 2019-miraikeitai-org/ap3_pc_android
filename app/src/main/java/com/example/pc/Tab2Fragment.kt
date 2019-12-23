package com.example.pc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_tab2.*
import kotlinx.android.synthetic.main.list_item.*

class Tab2Fragment: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridItem = ArrayList<Int>()
        for (user in user_list_women){
            gridItem.add(user.picture.picture_id)
        }

        val adapter = ListAdapter(this.requireContext(), R.layout.list_item, gridItem)
        val gridView: GridView = view.findViewById(R.id.tab1_gridView)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, view, i, l ->
            interim_position = user_list_women[i].user_id
            findNavController().navigate(R.id.detail)
        }

/*        val list_item3 = ArrayList<Model>()

        for (i in 1 .. 5) {
            list_item3.add(Model(R.drawable.codew1))
            list_item3.add(Model(R.drawable.codew2))
            list_item3.add(Model(R.drawable.codew3))
        }

/*        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT6Cfgvxw9-7mBMam3j-_V-xHh9OMewOey5F4GxC2uZr-1kdVdr").into(home_photo);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcREXqzTUZ5R0Fpkhk9QlwC1B1Fy-NsR8w_MM0spEgK2sh7uzb2l").into(codew2);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSwb30diTPd3fWWXB9DKHtGojNvom0wt8VmnHnP4_bG8Qhf5JwP").into(codew3);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRV3K6f75NcgNYCoHJ3iuLlFK5UAG5pbKvP7CaXnFEAnLqy0Yde").into(codew4);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRE2cotUD0qoGMCHZQIGRxzL4M-MQN8-AyLqoR4o93Oqz3J3AwM").into(codew5);
        Picasso.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQUEA-OhHHY0AooqJoiaIq2kWyCUsIfJMV_wGzKPwme-wPJJK4M").into(codew6);
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(codew7);
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(codew8);

        val list_item3 = ArrayList<String>()
        list_item3.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSwd0-rYWZSIgQOcSgON9lnAI_IM_CnHEWGhcR6XP9ZgbUC3APp")
        list_item3.add("https://www.soccer-king.jp/wp-content/uploads/2013/06/CAVANI-1.jpg")
        list_item3.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4YSkiLvxwlLIuHgsdE8Fk5agwtUE6Hkdfk7AL33jxN6zWkRon")
        */
        val gridView: GridView = view.findViewById(R.id.tab2_gridView)
        gridView.adapter = ArrayAdapter(this.requireContext(), R.layout.list_item, list_item3)

        gridView.setOnItemClickListener { parent, view, position, id ->
            val fragment = DetailFragment()
            val bundle = Bundle()

            bundle.putInt("selected", position)
            fragment.arguments = bundle

            val transaction = fragmentManager!!.beginTransaction()

            transaction.addToBackStack(null)
            transaction.replace(R.id.pager, fragment)
            transaction.commit()
        }*/
    }
}
