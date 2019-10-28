package com.example.pc

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_notification.*

class FavoriteFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter = CustomArrayAdapter(this.requireContext(), 0).apply {
            add(ListItem("What's your name?", "Que j'aime à faire apprendre un nombre utile aux sages! Glorieux Archimède, artiste, ingénieur, Toi de qui Syracuse aime encore la gloire, Soit ton nom conservé par de savants grimoires! Jadis, mystérieux, un problème bloquait Tout l'admirable procèdè, l'œuvre grandiose Que Pythagore découvrit aux anciens Grecs. O quadrature! vieux tourment du Philosophe! Insoluble rondeur, trop longtemps vous avez Défié Pythagore et ses imitateurs. Comment intégrer l'espace plan circulaire? Former un triangle auquel il équivaudra? Nouvelle invention: Archimède inscrira Dedans un hexagone; appréciera son aire Fonction du rayon. Pas trop ne s'y tiendra: Dédoublera chaque élément antérieur; Toujours de l'orbe calculée approchera; Définira limite; enfin, l'arc, le limiteur De cet inquiétant cercle, ennemi trop rebelle! Profeeeseur, enseignez son problème avec zèle!"))
        }
        val listView: ListView = view.findViewById(R.id.list_favorite)
        listView.adapter = arrayAdapter

        button.setOnClickListener {
            arrayAdapter.add(ListItem("Apple", "iPhone"))
            listView.adapter = arrayAdapter
        }
    }
}

class ListItem(val name: String){
    var description: String = "No description."
    constructor(name: String, description: String): this(name){
        this.description = description
    }
}

data class ViewHolder(val picture: ImageView, val name: TextView, val description: TextView)

class  CustomArrayAdapter: ArrayAdapter<ListItem>{
    private var inflater: LayoutInflater? = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    constructor(context: Context, resource: Int): super(context, resource)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var viewHolder: ViewHolder
        var view = convertView

        if (view == null){
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
//        viewHolder.picture
        viewHolder.name.text = listItem.name
        viewHolder.description.text = listItem.description

        return view!!
    }

    override fun isEnabled(position: Int): Boolean {
        return false
    }

}