package com.hollysmart.personmodule.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.allen.library.SuperTextView
import com.facebook.drawee.view.SimpleDraweeView
import com.hollysmart.personmodule.R
import com.hollysmart.personmodule.activity.*
import com.hollysmart.personmodule.common.PersonConfig
import com.hollysmart.personmodule.utils.ImageUtils
import com.hollysmart.zxingqrcodemodule.GenerateCodeActivity
import com.hollysmart.zxingqrcodemodule.ScanCodeActivity
import pub.devrel.easypermissions.EasyPermissions

class PersonInfoFragment : Fragment(), View.OnClickListener {

    lateinit var img_head_view: SimpleDraweeView
    lateinit var tv_username: TextView
    lateinit var tv_department: TextView
    lateinit var stv_person: SuperTextView
    lateinit var stv_password_edit: SuperTextView
    lateinit var stv_favorite: SuperTextView
    lateinit var stv_share: SuperTextView
    lateinit var stv_scan: SuperTextView
    lateinit var stv_setting: SuperTextView
    lateinit var stv_feedback: SuperTextView
    lateinit var stv_about: SuperTextView
    lateinit var btn_logout: Button
    lateinit var personConfig: PersonConfig

    var REQUEST_CODE_SACN_QRCODE: Int = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.person_module_fragment_me, container, false)
        initeView(view)
        initData()
        return view
    }


    private fun initeView(view: View) {

        img_head_view = view.findViewById(R.id.img_head_view)
        tv_username = view.findViewById(R.id.tv_username)
        tv_department = view.findViewById(R.id.tv_department)
        stv_person = view.findViewById(R.id.stv_person)
        stv_password_edit = view.findViewById(R.id.stv_password_edit)
        stv_favorite = view.findViewById(R.id.stv_favorite)
        stv_share = view.findViewById(R.id.stv_share)
        stv_scan = view.findViewById(R.id.stv_scan)
        stv_setting = view.findViewById(R.id.stv_setting)
        stv_feedback = view.findViewById(R.id.stv_feedback)
        stv_about = view.findViewById(R.id.stv_about)
        btn_logout = view.findViewById(R.id.btn_logout)
        stv_person.setOnClickListener(this)
        stv_password_edit.setOnClickListener(this)
        stv_favorite.setOnClickListener(this)
        stv_share.setOnClickListener(this)
        stv_scan.setOnClickListener(this)
        stv_setting.setOnClickListener(this)
        stv_feedback.setOnClickListener(this)
        stv_about.setOnClickListener(this)
        btn_logout.setOnClickListener(this)

    }

    @SuppressLint("WrongConstant")
    private fun initData() {
        tv_username.text = personConfig.userName
        tv_department.text = personConfig.department
        getContext()?.let { ImageUtils.setRoundImage(it, img_head_view, personConfig.headviewUrl) }

        stv_favorite.visibility = personConfig.showFavor
        stv_share.visibility = personConfig.showShare
        stv_scan.visibility = personConfig.showScan
        stv_setting.visibility = personConfig.showSetting
        stv_feedback.visibility = personConfig.showFeed
        stv_about.visibility = personConfig.showAbout

    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.stv_person -> {
                val intent = Intent(activity, PersonInfoActivity::class.java)
                intent.putExtra("userName", personConfig.userName)
                intent.putExtra("department", personConfig.department)
                intent.putExtra("headUrl", personConfig.headviewUrl)
                startActivity(intent)
            }
            R.id.stv_password_edit -> {
                val intent = Intent(activity, EditPasswordActivity::class.java)
                startActivity(intent)
            }
            R.id.stv_favorite -> {

            }
            R.id.stv_share -> {

            }
            R.id.stv_scan -> {
                //跳转扫码识别二维码（条形码）页面
                requestCodeQRCodePermissions()

//                startActivityForResult(
//                    Intent(activity, ScanCodeActivity::class.java),
//                    REQUEST_CODE_SACN_QRCODE
//                )

            }
            R.id.stv_setting -> {
                val intent = Intent(activity, SettingActivity::class.java)
                startActivity(intent)
            }
            R.id.stv_feedback -> {
                val intent = Intent(activity, FeedBackActivity::class.java)
                startActivity(intent)
            }
            R.id.stv_about -> {
                val intent = Intent(activity, AboutActivity::class.java)
                intent.putExtra("copyright", personConfig.copyright)
                intent.putExtra("copyrightCode", personConfig.coptright_code)
                intent.putExtra("serviceUrl", personConfig.serviceUrl)
                intent.putExtra("privacyUrl", personConfig.privacyUrl)
                intent.putExtra("serviceTitle", personConfig.serviceTitle)
                intent.putExtra("privacyTitle", personConfig.privacyTitle)
                startActivity(intent)
            }
        }
    }


    private fun getPersionConfig(): PersonConfig? {
        return personConfig
    }

    private fun setPersionConfig(config: PersonConfig) {
        personConfig = config
    }

    //接收二维码（条形码）扫描结果
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SACN_QRCODE) {
            var result = data?.getStringExtra("scanResult")
            Toast.makeText(activity, result, Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestCodeQRCodePermissions() {
        val perms = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (!EasyPermissions.hasPermissions(activity, *perms)) {
            EasyPermissions.requestPermissions(
                this,
                "扫描二维码需要打开相机和散光灯的权限",
                1,
                *perms
            )
        } else {
            startActivityForResult(
                Intent(activity, ScanCodeActivity::class.java),
                REQUEST_CODE_SACN_QRCODE
            )

        }
    }



}