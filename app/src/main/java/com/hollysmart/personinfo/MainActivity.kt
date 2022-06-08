package com.hollysmart.personinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.facebook.drawee.backends.pipeline.Fresco
import com.hollysmart.personmodule.bean.PersonFuncItemBean
import com.hollysmart.personmodule.common.PersonConfig
import com.hollysmart.personmodule.fragment.PersonInfoFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this);
        setContentView(R.layout.activity_main)
        //个人信息模块配置
        var personConfig = PersonConfig()
        //用户姓名
        personConfig.userName = "张shanshan"
        //用户部门
        personConfig.department = "信息化技术运营保障中心"

        //用户姓名
        personConfig.phoneNumber = "13223412345"

        //功能按钮List
        var itemList = mutableListOf<PersonFuncItemBean>()
        var collectionItemBean :PersonFuncItemBean = PersonFuncItemBean()
        collectionItemBean.itemName = "收藏"
        collectionItemBean.iconResource = R.mipmap.icon_collection
        var thumbItemBean :PersonFuncItemBean = PersonFuncItemBean()
        thumbItemBean.itemName = "点赞"
        thumbItemBean.iconResource = R.mipmap.icon_thumb
        var commentItemBean :PersonFuncItemBean = PersonFuncItemBean()
        commentItemBean.itemName = "评论"
        commentItemBean.iconResource = R.mipmap.icon_comment
        var shareItemBean :PersonFuncItemBean = PersonFuncItemBean()
        shareItemBean.itemName = "分享"
        shareItemBean.iconResource = R.mipmap.icon_share

        itemList.add(collectionItemBean)
        itemList.add(shareItemBean)
        itemList.add(thumbItemBean)
        itemList.add(commentItemBean)

        personConfig.personFuncList =  itemList

        //用户头像url
        personConfig.headviewUrl =
            "https://img0.baidu.com/it/u=859314309,692804921&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400"
        //是否展示收藏功能
        personConfig.showFavor = View.VISIBLE
        //是否展示分享功能
        personConfig.showShare = View.VISIBLE
        //是否展示扫一扫功能
        personConfig.showScan = View.VISIBLE
        //是否展示设置功能
        personConfig.showSetting = View.VISIBLE
        //是否展示意见反馈功能
        personConfig.showFeed = View.VISIBLE
        //是否展示关于我们功能
        personConfig.showAbout = View.VISIBLE

        //隐私政策名称
        personConfig.privacyTitle = "杨柳飞絮防治隐私政策"
        //服务协议名称
        personConfig.serviceTitle = "杨柳飞絮防治服务"
        //隐私政策内容url
        personConfig.privacyUrl = "https://qnimg.daolan.com.cn/yangliufeixufangzhiyinsizhengce.html"
        //服务协议内容url
        personConfig.serviceUrl = "https://qnimg.daolan.com.cn/yangliufeixufuwuxieyi.html"
        //版权所有
        personConfig.copyright = "北京市机关事务管理局  版权所有"
        //版权号
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