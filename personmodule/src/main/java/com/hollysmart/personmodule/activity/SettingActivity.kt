package com.hollysmart.personmodule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.allen.library.SuperTextView
import com.hollysmart.personmodule.R
import com.hollysmart.personmodule.utils.CacheUtil
import com.mylhyl.circledialog.CircleDialog
import com.mylhyl.circledialog.view.listener.OnButtonClickListener

class SettingActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var iv_back: ImageView
    lateinit var stv_access_type: SuperTextView
    lateinit var stv_cache: SuperTextView

    lateinit var stv_logout: SuperTextView
    lateinit var stv_deactvation: SuperTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_module_activity_setting)
        findView()
        initData()
    }

    private fun findView() {
        iv_back = findViewById(R.id.iv_back)
        stv_access_type = findViewById(R.id.stv_access_type)
        stv_cache = findViewById(R.id.stv_cache)

        stv_logout = findViewById(R.id.stv_logout)
        stv_deactvation = findViewById(R.id.stv_deactvation)

        iv_back.setOnClickListener(this)
        stv_access_type.setOnClickListener(this)
        stv_cache.setOnClickListener(this)
        stv_logout.setOnClickListener(this)
        stv_deactvation.setOnClickListener(this)
    }

    private fun initData() {
        stv_cache.setRightString(CacheUtil.getTotalCacheSize(this))
    }


    /**
     * 退出页面弹出alert弹窗
     */
    private fun showBackDialog() {
        CircleDialog.Builder().setTitle("是否退出")
//            .setText("建议您编辑之后保存该条数据") //内容
            .setPositive("确认") {
                finish()
                true
            }
            .setNegative("取消") { true }.show(supportFragmentManager)
    }

    /**
     * 退出页面弹出alert弹窗
     */
    private fun showDeactvationDialog() {
        CircleDialog.Builder().setTitle("注销账户")
            .setText("提交申请，删除所有数据，您的账号将不可使用，是否继续注销") //内容
            .setPositive("确认") {
                finish()
                true
            }
            .setNegative("取消") { true }.show(supportFragmentManager)
    }

    /**
     * 注销账户
     */
    private fun deactvationAccount() {

    }

    /**
     * 退出登录
     */
    private fun logout() {

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.stv_access_type -> {

            }
            R.id.stv_cache -> {
                CacheUtil.clearAllCache(this)
                stv_cache.setRightString(CacheUtil.getTotalCacheSize(this))
            }
            R.id.stv_logout -> {
                showBackDialog()
            }
            R.id.stv_deactvation -> {
                showDeactvationDialog()
            }

        }
    }
}