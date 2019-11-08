package com.example.pc

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.ContentResolver
//import androidx.support.design.internal.BottomNavigationMenuView
//import androidx.support.design.widget.BottomNavigationView

import android.widget.TextView
import com.example.pc.R
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination

import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.MypageRegistFragment1) {
                nav_view.visibility = View.GONE
            } else {
                nav_view.visibility = View.VISIBLE
            }
        }
        setupWithNavController(nav_view, navController)

        //val navController2=findNavController(R.id.my_nav_host_fragment)

    }




}



