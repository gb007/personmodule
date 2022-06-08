package com.hollysmart.personmodule.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.allen.library.SuperTextView
import com.facebook.drawee.view.SimpleDraweeView
import com.hollysmart.personmodule.R
import com.hollysmart.personmodule.activity.*
import com.hollysmart.personmodule.adapter.ItemFuncRecyclerViewAdapter
import com.hollysmart.personmodule.common.PersonConfig
import com.hollysmart.personmodule.utils.ImageUtils
import com.hollysmart.zxingqrcodemodule.GenerateCodeActivity
import com.hollysmart.zxingqrcodemodule.ScanCodeActivity
import pub.devrel.easypermissions.EasyPermissions
import androidx.recyclerview.widget.GridLayoutManager




class PersonInfoFragment : Fragment(), View.OnClickListener {

    lateinit var ll_person: LinearLayout
    lateinit var img_head_view: SimpleDraweeView
    lateinit var tv_username: TextView
    lateinit var tv_department: TextView

    lateinit var recycleview: RecyclerView
    lateinit var stv_one: SuperTextView
    lateinit var stv_two: SuperTextView

    lateinit var stv_person: SuperTextView
    lateinit var stv_password_edit: SuperTextView
    lateinit var stv_favorite: SuperTextView
    lateinit var stv_share: SuperTextView
    lateinit var stv_scan: SuperTextView
    lateinit var stv_setting: SuperTextView
    lateinit var stv_feedback: SuperTextView
    lateinit var stv_about: SuperTextView
    lateinit var stv_clear_cache :SuperTextView
    lateinit var btn_logout: Button
    lateinit var personConfig: PersonConfig
    private lateinit var itemFuncAdapter: ItemFuncRecyclerViewAdapter

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

        ll_person = view.findViewById(R.id.ll_person)
        img_head_view = view.findViewById(R.id.img_head_view)
        tv_username = view.findViewById(R.id.tv_username)
        tv_department = view.findViewById(R.id.tv_department)
        recycleview = view.findViewById(R.id.recycleview)
        stv_one = view.findViewById(R.id.stv_one)
        stv_two = view.findViewById(R.id.stv_two)
        stv_person = view.findViewById(R.id.stv_two)
        stv_password_edit = view.findViewById(R.id.stv_password_edit)
        stv_favorite = view.findViewById(R.id.stv_favorite)
        stv_share = view.findViewById(R.id.stv_share)
        stv_scan = view.findViewById(R.id.stv_scan)
        stv_setting = view.findViewById(R.id.stv_setting)
        stv_feedback = view.findViewById(R.id.stv_feedback)
        stv_about = view.findViewById(R.id.stv_about)
        stv_clear_cache = view.findViewById(R.id.stv_clear_cache)
        btn_logout = view.findViewById(R.id.btn_logout)
        ll_person.setOnClickListener(this)
        stv_one.setOnClickListener(this)
        stv_two.setOnClickListener(this)
        stv_person.setOnClickListener(this)
        stv_password_edit.setOnClickListener(this)
        stv_favorite.setOnClickListener(this)
        stv_share.setOnClickListener(this)
        stv_scan.setOnClickListener(this)
        stv_setting.setOnClickListener(this)
        stv_feedback.setOnClickListener(this)
        stv_about.setOnClickListener(this)
        stv_clear_cache.setOnClickListener(this)
        btn_logout.setOnClickListener(this)

    }

    @SuppressLint("WrongConstant")
    private fun initData() {
        tv_username.text = personConfig.userName
        tv_department.text = personConfig.department
        getContext()?.let { ImageUtils.setRoundImage(it, img_head_view, personConfig.headviewUrl) }

        if (personConfig.personFuncList.size > 2) {
            recycleview.visibility = View.VISIBLE
            stv_one.visibility = View.GONE
            stv_two.visibility = View.GONE

            itemFuncAdapter = ItemFuncRecyclerViewAdapter(personConfig.personFuncList)
            //纵向线性布局
            val layoutManager = GridLayoutManager(context, 4)
            recycleview.layoutManager = layoutManager
            recycleview.adapter = itemFuncAdapter

        } else if (personConfig.personFuncList.size == 1) {
            recycleview.visibility = View.GONE
            stv_one.visibility = View.VISIBLE
            stv_two.visibility = View.GONE
            stv_one.setLeftString(personConfig.personFuncList[0].itemName)
            stv_one.setLeftIcon(personConfig.personFuncList[0].iconResource)
        } else if (personConfig.personFuncList.size == 2) {
            recycleview.visibility = View.GONE
            stv_one.visibility = View.VISIBLE
            stv_two.visibility = View.VISIBLE
            stv_one.setLeftString(personConfig.personFuncList[0].itemName)
            stv_one.setLeftIcon(personConfig.personFuncList[0].iconResource)
            stv_two.setLeftString(personConfig.personFuncList[1].itemName)
            stv_two.setLeftIcon(personConfig.personFuncList[1].iconResource)
        } else {
            recycleview.visibility = View.GONE
            stv_one.visibility = View.GONE
            stv_two.visibility = View.GONE
        }

//        stv_favorite.visibility = personConfig.showFavor
//        stv_share.visibility = personConfig.showShare


        stv_scan.visibility = personConfig.showScan
        stv_setting.visibility = personConfig.showSetting
        stv_feedback.visibility = personConfig.showFeed
        stv_about.visibility = personConfig.showAbout

    }


    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.ll_person -> {
                val intent = Intent(activity, PersonInfoActivity::class.java)
                intent.putExtra("userName", personConfig.userName)
                intent.putExtra("department", personConfig.department)
                intent.putExtra("headUrl", personConfig.headviewUrl)
                startActivity(intent)
            }

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