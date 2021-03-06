package com.example.pc


import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_mypage.*
import android.widget.ImageButton
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore.Images.Media.getBitmap
import android.widget.ListView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item3.*
import kotlinx.android.synthetic.main.list_item3.view.*
import java.io.IOException


class MypageFragment : Fragment(), View.OnClickListener{
    //Intent intent =new Intent(this,MainActivity);
    //startActivityForResult(intent,);

    private val READ_REQUEST_CODE =42

    //private var position = ""

    private val args: MypageFragmentArgs by navArgs()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)


        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        set_button.setOnClickListener(this)
        cloth_after1.setOnClickListener(this)
        hair_before.setOnClickListener(this)
        make_before.setOnClickListener(this)
        aroma_before.setOnClickListener(this)
        add_button.setOnClickListener(this)

        val listItem = ArrayList<Picture_uri>()
        for (user in regist_list_mypage){
            listItem.add(user)
        }
        listItem.reverse()


        val adapter = ListAdapter3(this.requireContext(), R.layout.list_item3, listItem)
        val listView: ListView = view.findViewById(R.id.mypage_listView)
        listView.adapter = adapter

        //if(regist_list_mypage.isNotEmpty()){
        //    my_picture.setImageResource(regist_list_mypage.picture_id)
        //}

        //if(args.content!=null){
         //   comment.text = args.content
        //}

            Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(profile);

    }

    //実際の画像(bitmap)の取得
    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val uri: Uri?
            if (resultData != null) {
                uri = resultData.data
                regist_list_mypage[0].picture_id_uri=uri
                System.out.println(uri)
                try {
                    val bitmap = getBitmap(activity?.getContentResolver(), uri)
                    //                    //listView.imageView.setImageBitmap(bitmap)
                    //                    //mypage_listView.my_picture.setImageBitmap(bitmap)
                    val pic = bitmap
                    val action = MypageFragmentDirections.actionMypageToRegist1(PicData(pic))
                    findNavController().navigate(action)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
    }






//服とかメイクとか選ぶ時のボタン操作

    override fun onClick(view: View) {


        when (view.id){

            R.id.set_button -> {
                findNavController().navigate(R.id.action_navigation_mypage_to_navigation_notification)
            }

            R.id.cloth_after1 -> {
                val clotha = view.findViewById(R.id.cloth_after1)  as ImageButton

                if (trig1[0]){
                    clotha.setImageResource(R.drawable.clothb)
                    trig1[0] = false
                } else {
                    clotha.setImageResource(R.drawable.clotha)
                    trig1[0] = true
                }
            }

            R.id.hair_before -> {
                val hairb = view.findViewById(R.id.hair_before) as ImageButton

                if (trig1[1]){
                    hairb.setImageResource(R.drawable.haira)
                    trig1[1] = false
                } else {
                    hairb.setImageResource(R.drawable.hairb)
                    trig1[1] = true
                }
            }

            R.id.make_before -> {
                val makeb = view.findViewById(R.id.make_before) as ImageButton

                if (trig1[2]){
                    makeb.setImageResource(R.drawable.makea)
                    trig1[2] = false
                } else {
                    makeb.setImageResource(R.drawable.makeb)
                    trig1[2] = true
                }
            }
            R.id.aroma_before -> {
                val aromab = view.findViewById(R.id.aroma_before) as ImageButton

                if (trig1[3]){
                    aromab.setImageResource(R.drawable.aromaa)
                    trig1[3] = false
                } else {
                    aromab.setImageResource(R.drawable.aromab)
                    trig1[3] = true
                }
            }
            R.id.add_button -> {

                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)


                intent.type = "image/*"

                //System.out.println("aaaaa")
                //System.out.println(intent.getData())



                //フラグメント移動
                //findNavController().navigate(R.id.action_mypage_to_regist1)





                //結果の画像取得
                startActivityForResult(intent, READ_REQUEST_CODE)

                //startActivityForResult 終了後 onActivityResult が呼ばれて、
                //「結果コード、呼び出し時のID、結果」が渡される
                //val comment=view.findViewById(R.id.comment) as TextView
                //comment.setText(position)



                //これをコメントアウトすると動く。値渡しはできない。
                //args.contentがこの時点ではnullのため

                //comment.text = args.content

                //val textView = view.findViewById(R.id.comment) as TextView
                // テキストを設定して表示
                //textView.text = args.content
                //val comment = MypageFragmentArgs.fromBundle(arguments ?: return).content
                //val commentv = TextView(this)
                //commentv.text=comment
                //if (!text.equals(""))
                //    textView.setText(text)
                //}




            }
        }
    }

}

val trig1: Array<Boolean> = arrayOf(true, true, true, true)

