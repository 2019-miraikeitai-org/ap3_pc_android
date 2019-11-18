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
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.fragment_mypage.imageView
import java.io.IOException


class MypageFragment : Fragment(), View.OnClickListener{

    private val READ_REQUEST_CODE =42

    //private var position = ""

    private val args: MypageFragmentArgs by navArgs()

    //コピー用の配列を用意
    //var btn = arrayOfNulls<ImageButton>(4)

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
                System.out.println(uri)
                try {
                    val bitmap = getBitmap(getActivity()?.getContentResolver(), uri)
                    imageView.setImageBitmap(bitmap)
                    //val clothpicture = bitmap
                    //val action = MypageFragmentDirections.actionMypageToRegist1(clothpicture)
                    //findNavController().navigate(action)
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

            R.id.cloth_before -> {
                val clothb = view.findViewById(R.id.cloth_before)  as ImageButton

                if (trig[0]){
                    clothb.setImageResource(R.drawable.clotha)
                    trig[0] = false
                } else {
                    clothb.setImageResource(R.drawable.clothb)
                    trig[0] = true
                }
            }

            R.id.hair_before -> {
                val hairb = view.findViewById(R.id.hair_before) as ImageButton

                if (trig[1]){
                    hairb.setImageResource(R.drawable.haira)
                    trig[1] = false
                } else {
                    hairb.setImageResource(R.drawable.hairb)
                    trig[1] = true
                }
            }

            R.id.make_before -> {
                val makeb = view.findViewById(R.id.make_before) as ImageButton

                if (trig[2]){
                    makeb.setImageResource(R.drawable.makea)
                    trig[2] = false
                } else {
                    makeb.setImageResource(R.drawable.makeb)
                    trig[2] = true
                }
            }
            R.id.aroma_before -> {
                val aromab = view.findViewById(R.id.aroma_before) as ImageButton

                if (trig[3]){
                    aromab.setImageResource(R.drawable.aromaa)
                    trig[3] = false
                } else {
                    aromab.setImageResource(R.drawable.aromab)
                    trig[3] = true
                }
            }
            R.id.add_button -> {

                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)


                intent.type = "image/*"

                System.out.println("aaaaa")
                System.out.println(intent.getData())



                //フラグメント移動
                findNavController().navigate(R.id.action_mypage_to_regist1)



                //結果の画像取得
                startActivityForResult(intent, READ_REQUEST_CODE)

                //startActivityForResult 終了後 onActivityResult が呼ばれて、
                //「結果コード、呼び出し時のID、結果」が渡される
                //val comment=view.findViewById(R.id.comment) as TextView
                //comment.setText(position)



                //これをコメントアウトすると動く。値渡しはできない。
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