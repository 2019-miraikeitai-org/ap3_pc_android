package com.example.pc

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.RemoteException
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.fragment_home.*

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result;
import com.github.kittinunf.fuel.Fuel
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson
import org.altbeacon.beacon.*
import org.altbeacon.beacon.MonitorNotifier
import org.altbeacon.beacon.BeaconTransmitter
import org.altbeacon.beacon.BeaconParser
import org.altbeacon.beacon.Beacon
import org.w3c.dom.Comment
import java.net.URL


//data class Ok(val user_id: Int)
//data class json(val user_id: Int, val name:String, val age :Int)
//data class json2(val user_name: String)
//data class Person( val firstName:String, val lastName:String, val address:String, val planet:String)

//data class Js(val users: Array<User>)
//data class User(val user_name: String)

class MainActivity : AppCompatActivity(), BeaconConsumer {


    private val IBEACON_FORMAT = "m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"
    private val UUID = "74A23A96-A479-4330-AEFF-2421B6CF443C"
    private val beaconname = "00000001"

    private var beaconManager: BeaconManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSampleData()


        beaconManager = BeaconManager.getInstanceForApplication(this)
        beaconManager!!.beaconParsers.add(BeaconParser().setBeaconLayout(IBEACON_FORMAT))


        val beacon = Beacon.Builder()
            .setId1(UUID)
            .setId2("12345")
            .setId3("80")
            .setManufacturer(0x004C)
            .build()
        val beaconParser = BeaconParser()
            .setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24")
        val beaconTransmitter = BeaconTransmitter(applicationContext, beaconParser)

        //送信開始
        beaconTransmitter.startAdvertising(beacon)

        beaconTransmitter.isStarted()

        //main()
        get()
       // println(main())
        imageget()




        val navController = findNavController(R.id.nav_host_fragment)

        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.MypageRegistFragment1 || nd.id == R.id.fragment) {
                nav_view.visibility = View.GONE
            } else {
                nav_view.visibility = View.VISIBLE
            }
        }
        setupWithNavController(nav_view, navController)


        //val navController2=findNavController(R.id.my_nav_host_fragment)
    }

    override fun onResume() {
        super.onResume()
        // サービスの開始
        beaconManager!!.bind(this)
    }

    override fun onPause() {
        super.onPause()
        // サービスの停止
        beaconManager!!.unbind(this)
    }

    override fun onBeaconServiceConnect() {
        val uuid = Identifier.parse(UUID)
        val mRegion = Region(beaconname, uuid, null, null)

        try {
            beaconManager!!.startMonitoringBeaconsInRegion(mRegion)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }

        beaconManager!!.addMonitorNotifier(object : MonitorNotifier {
            override fun didEnterRegion(region: Region) {
                // 領域侵入
                //レンジングの開始
                beaconManager!!.startRangingBeaconsInRegion(mRegion)
            }

            override fun didExitRegion(region: Region) {
                // 領域退出
                //レンジングの停止
                beaconManager!!.stopRangingBeaconsInRegion(mRegion)

            }
            override fun didDetermineStateForRegion(i: Int, region: Region) {

            }


        })


        beaconManager!!.addRangeNotifier(object: RangeNotifier {

            // 範囲内のビーコン情報を受け取る
            override fun didRangeBeaconsInRegion(beacons: Collection<Beacon>, region: Region){

                //var uuid:Int
                //var maxMinor: Int?

                // 範囲内の複数のビーコン情報を保持させる変数
                var getMajorList: ArrayList<Int> = ArrayList()


                // 範囲内にビーコンがある時の処理
                if (beacons.isNotEmpty()) {

                    //Log.d(tag,"ビーコン発見")

                    // 範囲内のビーコンの数だけ繰り返す
                    for (beacon in beacons) {
                        // 複数のビーコン情報をArrayListに分割
                        getMajorList.add(beacon.id2.toInt())
                        Log.d("Beacon","UUID:" + beacon.id1 + "user_id:" +beacon.id2)

                        val user_id = beacon.id1
                        val a="http://150.95.156.155/users/${user_id}/all_images".httpGet()
                            .responseString { request, response, result ->
                                when (result) {
                                    is Result.Failure -> {
                                        val ex = result.getException()
                                        println(ex)
                                    }
                                    is Result.Success -> {
                                        val data = result.get()
                                        println(data)


                                        // mapperオブジェクトを作成
                                        val mapper = jacksonObjectMapper()

                                        // jsonをdeserialize
                                        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
                                        val user = mapper.readValue<You>(data)


                                        //ここを最後の写真を表示にする
                                        println(user.image_urls[1].url)


                                        //userの中の
                                        // for (i in 1..3) {
                                        //     val c = user.image_url[i].comment
                                        //println(user.user_information[i].user_id)
                                        //println(user.image_url[i].comment)


                                    }
                                    //println(user.user_id)
                                    //println(user.name)
                                    //println(user.age)

                                    //println(user.user_name)
                                    //println(user.user_name)
                                    //val b = user.image_url[2].comment
                                }
                            }

                    }



                }
            }
        })

    }





}


data class Yo(val user_information: Array<User>)
data class User(val user_id: Int,val name: String, val height: Int, val gender: String)

fun main(){
    val httpAsync = "http://150.95.156.155/users"
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                    }
                    is Result.Success -> {
                        val data = result.get()
                    //    println(data)


                        // パースするJSON
                        // val json = "{ \"user_id\": 10,\"name\": \"Yoshizaki\", \"age\": 1538 }"
                        // val mason = "{ \"user_id\": 5}"
                        // val json2 = "{ \"users\": [{\"user_name\":\"a\"}, {\"user_name\":\"b\"}] }"

                        // mapperオブジェクトを作成
                        val mapper = jacksonObjectMapper()

                        // jsonをdeserialize
                        // 下の場合はjsonがColor型のオブジェクトにマッピングされる
                        val user = mapper.readValue<Yo>(data)



                        //userの中の
                        for (i in 1..3) {
                            val c = user.user_information[i].height
                            //println(user.user_information[i].user_id)
                             println(user.user_information[i].height)


                        }
                        //println(user.user_id)
                        //println(user.name)
                        //println(user.age)

                        //println(user.user_name)
                        //println(user.user_name)
                        val b = user.user_information[2].gender


                    }

                }

            }


    val person = "{ \"name\": \"Taro\", \"height\": 200,\"gender\":\"true\" }"
    Fuel.post("http://150.95.156.155/users").body(person).response { request, response, result ->
        //Which results in a success
        "http://150.95.156.155/users".httpPost(listOf("bbb" to "ccc")).response { request, response, result ->
        }
    }
}

fun get() {
    val user_id = 3
    val a="http://150.95.156.155/users/${user_id}".httpGet().responseString { request, response, result ->
        when (result) {
            // ステータスコード 2xx
            is Result.Success -> {
                val data = result.get()
                println(data)
                val mapper = jacksonObjectMapper()


                // jsonをdeserialize
                // 下の場合はjsonがColor型のオブジェクトにマッピングされる
                val user = mapper.readValue<Yo>(data)

                //println(user.user_information[0].name)

                var count = 7
                var gen = true
                for(id in user.user_information) {
                    if (id.gender == "1") gen = false
                    sample_user_list_all.add(
                        User_sample(count, id.name, id.height, gen,
                            Picture(
                                R.drawable.codem1, "text1",
                                Tag("TEE", "NIKE", "L", 8000),
                                Tag("Jacket", "NIKE", "FREE", 14000),
                                Tag("BOTTOM", "NIKE", "L", 9000),
                                Tag("SHOES", "ADIDAS", "27", 12000)
                            )
                        )
                    )
                    val u = sample_user_list_all[count]
                    if (gen){
                        user_list_men.add(u)
                    } else {
                        user_list_women.add(u)
                    }
                    count++
                }


            }
            // ステータスコード 2xx以外
            is Result.Failure -> {
                // エラー処理
                println("errorerrorerror")
            }
        }
    }
}


var abc: Boolean = false
var interim_position: Int = 0

val sample_user_list_all = mutableListOf<User_sample>()
val user_list_men = mutableListOf<User_sample>()
val user_list_women = mutableListOf<User_sample>()
val user_list_favorite = mutableListOf<User_sample>()
var regist_list_mypage = mutableListOf(Picture_uri(
    Uri.parse("android.resource://com.example.pc/drawable/codew0.JPG"), "text1",
    Tag("TEE", "NIKE", "L", 8000),
    Tag("Jacket","NIKE", "FREE", 14000),
    Tag("BOTTOM", "NIKE", "L", 9000),
    Tag("SHOES", "ADIDAS","27", 12000)))
fun setSampleData() {
    sample_user_list_all.add(User_sample(0,"Neymar", 175, true,
        Picture(R.drawable.codem1, "text1",
            Tag("TEE", "NIKE", "L", 8000),
            Tag("Jacket","NIKE", "FREE", 14000),
            Tag("BOTTOM", "NIKE", "L", 9000),
            Tag("SHOES", "ADIDAS","27", 12000))))
    sample_user_list_all.add(User_sample(1,"Cavani", 185, true,
        Picture(R.drawable.codem2, "text2",
            Tag("TEE", "NIKE", "L", 8000),
            Tag("Jacket","NIKE", "FREE", 14000),
            Tag("BOTTOM", "NIKE", "L", 9000),
            Tag("SHOES", "ADIDAS","27", 12000))))
    sample_user_list_all.add(User_sample(2,"Mbappé", 178, true,
        Picture(R.drawable.codem3, "text3",
            Tag("TEE", "NIKE", "L", 8000),
            Tag("Jacket","NIKE", "FREE", 14000),
            Tag("BOTTOM", "NIKE", "L", 9000),
            Tag("SHOES", "ADIDAS","27", 12000))))
    sample_user_list_all.add(User_sample(3,"Rin", 165, false,
        Picture(R.drawable.codew0, "text4",
            Tag("TEE", "NIKE", "L", 8000),
            Tag("Jacket","NIKE", "FREE", 14000),
            Tag("BOTTOM", "NIKE", "L", 9000),
            Tag("SHOES", "ADIDAS","27", 12000))))
    sample_user_list_all.add(User_sample(4,"Hina", 167, false,
        Picture(R.drawable.codew1, "text5",
            Tag("TEE", "NIKE", "L", 8000),
            Tag("Jacket","NIKE", "FREE", 14000),
            Tag("BOTTOM", "NIKE", "L", 9000),
            Tag("SHOES", "ADIDAS","27", 12000))))
    sample_user_list_all.add(User_sample(5,"Yua", 159, false,
        Picture(R.drawable.codew2, "text6",
            Tag("TEE", "NIKE", "L", 8000),
            Tag("Jacket","NIKE", "FREE", 14000),
            Tag("BOTTOM", "NIKE", "L", 9000),
            Tag("SHOES", "ADIDAS","27", 12000))))
    sample_user_list_all.add(User_sample(6,"An", 154, false,
        Picture(R.drawable.codew3, "text7",
            Tag("TEE", "NIKE", "L", 8000),
            Tag("Jacket","NIKE", "FREE", 14000),
            Tag("BOTTOM", "NIKE", "L", 9000),
            Tag("SHOES", "ADIDAS","27", 12000))))

    for (user in sample_user_list_all){
        if (user.user_gender){
            user_list_men.add(user)
        } else {
            user_list_women.add(user)
        }
    }
}

    //Serialising it to Json using Gson
    //val personJson = Gson().toJson(person)
    //"http://160.16.103.99/users".httpPost().header("Content-Type" to "application/json").body(personJson.toString()).response { req, res, result ->
    //Ought to be a Success!
    //}

data class You(val image_urls: Array<Useru>)
data class Useru(val image_id: Int,val user_id: Int, val url: String, val comment: String, val good_count: Int)



fun imageget() {
    val user_id = 2
    val a="http://150.95.156.155/users/${user_id}/all_images".httpGet()
        .responseString { request, response, result ->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    println(ex)
                }
                is Result.Success -> {
                    val data = result.get()
                    println(data)


                    // mapperオブジェクトを作成
                    val mapper = jacksonObjectMapper()

                    // jsonをdeserialize
                    // 下の場合はjsonがColor型のオブジェクトにマッピングされる
                    val user = mapper.readValue<You>(data)

                    
                    //この写真を飛ばして
                    println(user.image_urls[1].url)


                    //userの中の
                   // for (i in 1..3) {
                   //     val c = user.image_url[i].comment
                        //println(user.user_information[i].user_id)
                        //println(user.image_url[i].comment)


                }
                    //println(user.user_id)
                    //println(user.name)
                    //println(user.age)

                    //println(user.user_name)
                    //println(user.user_name)
                    //val b = user.image_url[2].comment
            }
        }
}