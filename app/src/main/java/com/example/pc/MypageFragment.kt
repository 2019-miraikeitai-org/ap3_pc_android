package com.example.pc


import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.ContentResolver
import android.content.Context
import android.media.Image
import android.os.Bundle
//import android.support.annotation.IdRes
//import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_mypage.*
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.provider.MediaStore
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore.Images.Media.getBitmap
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_mypageregist1.view.*
import java.io.IOException


class MypageFragment : Fragment(), View.OnClickListener{

    private val READ_REQUEST_CODE =42



    //コピー用の配列を用意
    //var btn = arrayOfNulls<ImageButton>(4)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_mypage)

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        //view.button.setOnClickListener {
        //    Navigation.findNavController(it).navigate(R.id.action_to_regist1)
        //}
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cloth_before.setOnClickListener(this)
        hair_before.setOnClickListener(this)
        make_before.setOnClickListener(this)
        aroma_before.setOnClickListener(this)
        add_button.setOnClickListener(this)



    }

    //実際の画像(bitmap)の取得
    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val uri: Uri?
            if (resultData != null) {
                uri = resultData.data
                try {
                    val bitmap = getBitmap(getActivity()?.getContentResolver(), uri)
                    imageView.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
    }



//服とかメイクとか選ぶ時のボタン操作
    override fun onClick(view: View) {


        when (view.id){
            R.id.cloth_before-> {
                val clothb = view.findViewById(R.id.cloth_before)  as ImageButton
                clothb.setBackgroundResource(R.drawable.clotha)
            }

            R.id.hair_before -> {
                val hairb = view.findViewById(R.id.hair_before) as ImageButton
                hairb.setImageResource(R.drawable.haira)
            }

            R.id.make_before -> {
                val makeb = view.findViewById(R.id.make_before) as ImageButton
                makeb.setBackgroundResource(R.drawable.makea)
            }
            R.id.aroma_before -> {
                val aromab = view.findViewById(R.id.aroma_before) as ImageButton
                aromab.setImageResource(R.drawable.aromaa)
            }
            R.id.add_button -> {

                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)

                intent.type = "image/*"
                startActivityForResult(intent, READ_REQUEST_CODE)
                Navigation.findNavController(view).navigate(R.id.action_to_regist1)
            }
        }
    }






}