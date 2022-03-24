package com.hollysmart.personmodule.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.allen.library.SuperTextView
import com.hollysmart.personmodule.R
import com.hollysmart.personmodule.utils.AppUtils
import com.hollysmart.personmodule.utils.CacheUtil

class AboutActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var iv_back: ImageView
    lateinit var img_icon: ImageView
    lateinit var tv_appname: TextView
    lateinit var tv_version: TextView
    lateinit var stv_new_version: SuperTextView
    lateinit var tv_service: TextView
    lateinit var tv_privacy: TextView
    lateinit var tv_copyright: TextView
    lateinit var tv_copyright_code: TextView

    lateinit var serviceUrl: String
    lateinit var privacyUrl: String
    lateinit var serviceTitle: String
    lateinit var privacyTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_module_activity_about)
        findView()
        initData()
    }


    private fun findView() {
        iv_back = findViewById(R.id.iv_back)
        img_icon = findViewById(R.id.img_icon)
        tv_appname = findViewById(R.id.tv_appname)
        tv_version = findViewById(R.id.tv_version)
        stv_new_version = findViewById(R.id.stv_new_version)
        tv_service = findViewById(R.id.tv_service)
        tv_privacy = findViewById(R.id.tv_privacy)
        tv_copyright = findViewById(R.id.tv_copyright)
        tv_copyright_code = findViewById(R.id.tv_copyright_code)
        iv_back.setOnClickListener(this)
        stv_new_version.setOnClickListener(this)
        tv_service.setOnClickListener(this)
        tv_privacy.setOnClickListener(this)

    }

    private fun initData() {
        var copyright = intent.getStringExtra("copyright").toString()
        var copyrightCode = intent.getStringExtra("copyrightCode").toString()
        serviceUrl = intent.getStringExtra("serviceUrl").toString()
        privacyUrl = intent.getStringExtra("privacyUrl").toString()
        serviceTitle = intent.getStringExtra("serviceTitle").toString()
        privacyTitle = intent.getStringExtra("privacyTitle").toString()
        img_icon.setImageDrawable(AppUtils.getDrawable(this))
        tv_appname.text = AppUtils.getAppName(this)
        tv_version.text = "版本：" + AppUtils.getVersionName(this)
        if (!copyright.isEmpty()) {
            tv_copyright.text = copyright
        }
        if (!copyrightCode.isEmpty()) {
            tv_copyright_code.text = copyrightCode
        }
    }

    /**
     * 检测APP版本
     *
     */
    private fun checkAppVersion(){


    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.stv_new_version -> {
                checkAppVersion()
            }
            R.id.tv_service -> {
                if (!serviceUrl.isEmpty()) {
                    val intent = Intent(this, WebActivity::class.java)
                    intent.putExtra("title", serviceTitle)
                    intent.putExtra("loadUrl", serviceUrl)
                    startActivity(intent)
                }
            }
            R.id.tv_privacy -> {
                if (!privacyUrl.isEmpty()) {
                    val intent = Intent(this, WebActivity::class.java)
                    intent.putExtra("title", privacyTitle)
                    intent.putExtra("loadUrl", privacyUrl)
                    startActivity(intent)
                }
            }
        }
    }

}