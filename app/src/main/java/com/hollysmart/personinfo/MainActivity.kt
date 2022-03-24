package com.hollysmart.personinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.facebook.drawee.backends.pipeline.Fresco
import com.hollysmart.personmodule.common.PersonConfig
import com.hollysmart.personmodule.fragment.PersonInfoFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this);
        setContentView(R.layout.activity_main)

        var personConfig = PersonConfig()
        personConfig.userName = "张shanshan"
            personConfig.department = "信息化技术运营保障中心"
            personConfig.headviewUrl = "https://img0.baidu.com/it/u=859314309,692804921&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400"
            personConfig.showFavor = View.VISIBLE
            personConfig.showShare = View.VISIBLE
            personConfig.showScan = View.VISIBLE
            personConfig.showSetting = View.VISIBLE
            personConfig.showFeed = View.VISIBLE
            personConfig.showAbout = View.VISIBLE


        personConfig.privacyTitle = "杨柳飞絮防治隐私政策"
        personConfig.serviceTitle = "杨柳飞絮防治服务"
        personConfig.privacyUrl =  "https://qnimg.daolan.com.cn/yangliufeixufangzhiyinsizhengce.html"
        personConfig.serviceUrl =  "https://qnimg.daolan.com.cn/yangliufeixufuwuxieyi.html"
        personConfig.copyright = "北京市机关事务管理局  版权所有"
        personConfig.coptright_code = "Copyright \\u00a9 2019-2020 All Rights Reserved"


        var personInfoFragment = PersonInfoFragment()
        personInfoFragment.personConfig = personConfig
        supportFragmentManager //
            .beginTransaction()
            .add(
                R.id.fragment_container,
                personInfoFragment
            ) // 此处的R.id.fragment_container是要盛放fragment的父容器
            .commit()
    }
}