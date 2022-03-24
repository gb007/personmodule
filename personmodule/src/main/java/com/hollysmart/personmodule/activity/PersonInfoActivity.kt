package com.hollysmart.personmodule.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.facebook.drawee.view.SimpleDraweeView
import com.hollysmart.personmodule.R
import com.hollysmart.personmodule.utils.ImageUtils
import com.lwkandroid.imagepicker.ImagePicker
import com.lwkandroid.imagepicker.data.ImageBean
import com.lwkandroid.imagepicker.data.ImagePickType
import com.lwkandroid.imagepicker.data.ImagePickerCropParams

/**
 * 个人信息页面
 */
class PersonInfoActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var tv_title: TextView
    lateinit var img_back: ImageView
    lateinit var tv_right: TextView
    lateinit var img_head_view: SimpleDraweeView
    lateinit var edt_username: EditText
    lateinit var edt_dep: EditText

    lateinit var userName: String
    lateinit var department: String
    lateinit var headUrl: String
    var isLocal = false
    lateinit var local_head_view_path: String

    private val REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_module_activity_person_info)
        initView()
        initData()
    }


    private fun initView() {
        tv_title = findViewById(R.id.tv_title)
        img_back = findViewById(R.id.iv_back)
        tv_right = findViewById(R.id.tv_right)
        img_head_view = findViewById(R.id.img_head_view)
        edt_username = findViewById(R.id.edt_username)
        edt_dep = findViewById(R.id.edt_dep)
        img_back.setOnClickListener(this)
        tv_right.setOnClickListener(this)
        img_head_view.setOnClickListener(this)
//        tv_title
//        img_back
//        tv_right
//        img_head_view
//        edt_username
//        edt_dep


    }

    private fun initData() {

        userName = intent.getStringExtra("userName").toString()
        department = intent.getStringExtra("department").toString()
        headUrl = intent.getStringExtra("headUrl").toString()

        if (!userName.isEmpty()) {
            edt_username.setText(userName)
        }

        if (!department.isEmpty()) {
            edt_dep.setText(department)
        }

        if (!headUrl.isEmpty()) {
            ImageUtils.setRoundImage(this, img_head_view, headUrl)
        }

    }

    /**
     * 上传用户信息
     *
     */
    private fun uploadInfo(){

        if(edt_username.text.toString() == userName && edt_dep.text.toString() == department && !isLocal)
            return

        if(edt_username.text.isEmpty()){
            showToast("姓名不能为空")
            return
        }

        if(edt_dep.text.isEmpty()){
            showToast("部门不能为空")
            return
        }

        if (isLocal){
            uploadHeadView()
        }

    }

    /**
     * 刷新页面用户信息
     */
    private fun updateUserInfo(){

    }

    /**
     * 上传用户本地头像（相册或者拍照）
     */
    private fun uploadHeadView(){

    }

    private fun uploadUserInfo(){

    }


    private fun showToast(string: String){
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show()
    }


    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.tv_right -> {

            }
            R.id.img_head_view -> {

                ImagePicker()
                    .pickType(ImagePickType.SINGLE)
                    .maxNum(1)
                    .needCamera(true)
                    .cachePath(getCacheDir().getPath())
                    .doCrop(ImagePickerCropParams())
                    .start(
                        this,
                        REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY
                    )

            }

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY) {
            val picPaths: List<ImageBean> =
                data!!.getParcelableArrayListExtra(ImagePicker.INTENT_RESULT_DATA)!!
            local_head_view_path = picPaths[0].imagePath
            if (!local_head_view_path.isEmpty())
                isLocal = true
            ImageUtils.setRoundImage(this, img_head_view, ImageUtils.getImageStreamFromInternal(local_head_view_path).toString())
        }
    }


}


