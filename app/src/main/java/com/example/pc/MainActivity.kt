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
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination

import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.fragment_home.*

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result;
import com.github.kittinunf.fuel.Fuel
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson



data class Ok(val user_id: Int)
data class json(val user_id: Int, val name:String, val age :Int)
data class json2(val user_name: String)
data class Person( val firstName:String, val lastName:String, val address:String, val planet:String)

//data class Js(val users: Array<User>)
//data class User(val user_name: String)

data class Yo(val users: Array<User>)
data class User(val user_id: Int, val name: String, val age: Int, val gender: String, val email: String?)



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()

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


fun main() {

    val httpAsync = "http://160.16.103.99/users"
        .httpGet()
        .responseString { request, response, result ->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    println(ex)
                }
                is Result.Success -> {
                    val data = result.get()
                    println(data)


                    // パースするJSON
                    val json = "{ \"user_id\": 10,\"name\": \"Yoshizaki\", \"age\": 1538 }"
                    val mason = "{ \"user_id\": 5}"
                    val json2 = "{ \"users\": [{\"user_name\":\"a\"}, {\"user_name\":\"b\"}] }"

                    // mapperオブジェクトを作成
                    val mapper = jacksonObjectMapper()

                    // jsonをdeserialize
                    // 下の場合はjsonがColor型のオブジェクトにマッピングされる
                    val user = mapper.readValue<Yo>(data)


                    //userの中の
                    for (i in 0..1) {
                        println(user.users[i].user_id)
                        println(user.users[i].gender)
                    }
                    //println(user.user_id)
                    //println(user.name)
                    //println(user.age)

                    //println(user.user_name)
                    //println(user.user_name)

                }

            }
        }
    val person = "{ \"name\": \"Yoshizaaa\", \"age\": 1538,\"gender\":\"め-す\" }"
    Fuel.post("http://160.16.103.99/users").body(person).response { request, response, result ->
        //Which results in a success
        "http://160.16.103.99/users".httpPost(listOf("bbb" to "ccc")).response { request, response, result ->
        }
    }



    //Serialising it to Json using Gson
    //val personJson = Gson().toJson(person)
    //"http://160.16.103.99/users".httpPost().header("Content-Type" to "application/json").body(personJson.toString()).response { req, res, result ->
    //Ought to be a Success!
    //}

}

class ListItem2(val name: String){
    var description: String = "No description."
    constructor(name: String, description: String): this(name){
        this.description = description
    }
}

data class ViewHolder(val picture: ImageView, val name: TextView, val description: TextView)
