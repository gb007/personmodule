package com.hollysmart.personmodule.activity

import android.os.Build

import android.view.View
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.hollysmart.personmodule.R
import com.hollysmart.personmodule.base.PersonModuleBaseActivity
import com.hollysmart.personmodule.base.StyleAnimActivity
import com.hollysmart.personmodule.utils.Utils


class WebActivity : PersonModuleBaseActivity(), View.OnClickListener {
    lateinit var iv_back: ImageView
    lateinit var tv_title: TextView
    lateinit var wv_web: WebView


    override fun layoutResID(): Int {
        return R.layout.person_module_activity_web
    }


    override fun findView() {
        iv_back = findViewById(R.id.iv_back)
        iv_back.setOnClickListener(this)
        tv_title = findViewById(R.id.tv_title)
        wv_web = findViewById(R.id.wv_web)
        wv_web.setVisibility(View.VISIBLE)
        val webSettings = wv_web.getSettings()
        webSettings.savePassword = false
        webSettings.saveFormData = false
        webSettings.defaultTextEncodingName = "UTF-8"
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)
        webSettings.blockNetworkImage = false //解决图片不显示
        webSettings.textZoom = 100 //设置字体占屏幕宽度
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN // 图片大小

        //设置支持DomStorage
        webSettings.domStorageEnabled = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        wv_web.clearCache(true)
        wv_web.setVerticalScrollBarEnabled(false) //垂直不显示
        clearWebViewCache()
    }

    fun clearWebViewCache() {
        // 清除cookie即可彻底清除缓存
        CookieSyncManager.createInstance(this)
        CookieManager.getInstance().removeAllCookie()
    }


    override fun init() {
        var loadUrl = intent.getStringExtra("loadUrl")
        var title = intent.getStringExtra("title")
        tv_title!!.text = title
        getDetail(loadUrl)
    }


    private fun getDetail(url: String?) {
        wv_web!!.loadUrl(url!!)
    }

    override fun onClick(v: View) {
        if (Utils.isFastClick()) return
        if (v.id == R.id.iv_back) {
            finish()
        }
    }


}