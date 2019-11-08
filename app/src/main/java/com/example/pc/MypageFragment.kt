package com.example.pc


import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_mypage.*
import android.widget.ImageButton
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore.Images.Media.getBitmap
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_mypage.imageView
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import kotlinx.android.synthetic.main.fragment_mypageregist1.view.*
import kotlinx.android.synthetic.main.fragment_mypageregist2.*
import kotlinx.android.synthetic.main.list_item.*
import java.io.IOException
//import android.R


//import android.R




class MypageFragment : Fragment(), View.OnClickListener{

    private val READ_REQUEST_CODE =42

    //private var position = ""

    private val args: MypageFragmentArgs by navArgs()

    //コピー用の配列を用意
    //var btn = arrayOfNulls<ImageButton>(4)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_mypage)



        // Bundleを取得する
        //val bundle = arguments
        // Bundleがセットされていたら値を受け取る
        //if (bundle != null) {
        //position = bundle.getString("KEY_POSITION")
        //}


    }





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)


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
                //フラグメント移動
                findNavController().navigate(R.id.action_mypage_to_regist1)




                //結果の画像取得
                startActivityForResult(intent, READ_REQUEST_CODE)
                //startActivityForResult 終了後 onActivityResult が呼ばれて、
                //「結果コード、呼び出し時のID、結果」が渡される
                //val comment=view.findViewById(R.id.comment) as TextView
                //comment.setText(position)


                //comment.text = args.content

                //val textView = view.findViewById(R.id.comment) as TextView
                // テキストを設定して表示
                //textView.setText(args.content)







            }
        }
    }






}