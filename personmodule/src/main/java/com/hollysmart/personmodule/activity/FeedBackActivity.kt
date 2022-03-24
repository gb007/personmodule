package com.hollysmart.personmodule.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.hollysmart.personmodule.R
import com.hollysmart.personmodule.adapter.ItemPicAdater
import com.hollysmart.personmodule.base.PersonModuleBaseActivity
import com.hollysmart.personmodule.base.StyleAnimActivity
import com.hollysmart.personmodule.bean.PicBean
import com.hollysmart.personmodule.linearlayoutforlistview.MyLinearLayoutForListView
import com.lwkandroid.imagepicker.ImagePicker
import com.lwkandroid.imagepicker.data.ImageBean
import java.util.ArrayList

class FeedBackActivity : PersonModuleBaseActivity(), View.OnClickListener {

    lateinit var iv_back: ImageView
    lateinit var btn_ques_ui: Button
    lateinit var btn_ques_func: Button
    lateinit var btn_ques_experience: Button
    lateinit var btn_ques_characteristic: Button
    lateinit var btn_ques_other: Button
    lateinit var edt_describe: EditText
    lateinit var edt_contact: EditText
    lateinit var btn_feedback_submit: Button
    lateinit var ll_pic: MyLinearLayoutForListView
    lateinit var pics: MutableList<PicBean>
    lateinit var itemPicAdater: ItemPicAdater
    val REQUEST_CODE_IMAGE: Int = 99

    var questionCode: Int = 0

    override fun layoutResID(): Int {
        return R.layout.persion_module_activity_feed_back
    }

    override fun findView() {

        ll_pic = findViewById(R.id.ll_pic)
        iv_back = findViewById(R.id.iv_back)
        btn_ques_ui = findViewById(R.id.btn_ques_ui)
        btn_ques_func = findViewById(R.id.btn_ques_func)
        btn_ques_experience = findViewById(R.id.btn_ques_experience)
        btn_ques_characteristic = findViewById(R.id.btn_ques_characteristic)
        btn_ques_other = findViewById(R.id.btn_ques_other)
        edt_describe = findViewById(R.id.edt_describe)
        edt_contact = findViewById(R.id.edt_contact)
        btn_feedback_submit = findViewById(R.id.btn_feedback_submit)

        iv_back.setOnClickListener(this)
        btn_ques_ui.setOnClickListener(this)
        btn_ques_func.setOnClickListener(this)
        btn_ques_experience.setOnClickListener(this)
        btn_ques_characteristic.setOnClickListener(this)
        btn_ques_other.setOnClickListener(this)
        btn_feedback_submit.setOnClickListener(this)


    }

    override fun init() {
        pics = arrayListOf<PicBean>()
        itemPicAdater =
            ItemPicAdater(this, pics)
        itemPicAdater.setMaxSize(9)
        ll_pic.setAdapter(itemPicAdater)
    }

    /**
     * 验证反馈问题数据
     */
    private fun checkData() {
        if (questionCode == 0) {
            showToast("请选择一个问题类型")
            return
        }

        if (questionCode == 5 && edt_describe.text.isEmpty()) {
            showToast("请输入详细问题描述")
            return
        }
        uploadQuestion()
    }

    /**
     * 上传问题反馈数据
     *
     */
    private fun uploadQuestion() {

    }


    /**
     * 上传问题反馈文件
     *
     */
    private fun uploadFile() {

    }

    private fun showToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View?) {


        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.btn_ques_ui -> {

                btn_ques_ui.background = getDrawable(R.drawable.person_module_shape_btn_blue)
                btn_ques_func.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_experience.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_characteristic.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_other.background = getDrawable(R.drawable.person_module_shape_btn_gray)

                btn_ques_ui.setTextColor(resources.getColor(R.color.white))
                btn_ques_func.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_experience.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_characteristic.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_other.setTextColor(resources.getColor(R.color.person_module_black_3))
                questionCode = 1
            }
            R.id.btn_ques_func -> {

                btn_ques_ui.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_func.background = getDrawable(R.drawable.person_module_shape_btn_blue)
                btn_ques_experience.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_characteristic.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_other.background = getDrawable(R.drawable.person_module_shape_btn_gray)

                btn_ques_ui.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_func.setTextColor(resources.getColor(R.color.white))
                btn_ques_experience.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_characteristic.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_other.setTextColor(resources.getColor(R.color.person_module_black_3))
                questionCode = 2
            }
            R.id.btn_ques_experience -> {

                btn_ques_ui.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_func.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_experience.background =
                    getDrawable(R.drawable.person_module_shape_btn_blue)
                btn_ques_characteristic.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_other.background = getDrawable(R.drawable.person_module_shape_btn_gray)

                btn_ques_ui.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_func.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_experience.setTextColor(resources.getColor(R.color.white))
                btn_ques_characteristic.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_other.setTextColor(resources.getColor(R.color.person_module_black_3))
                questionCode = 3
            }
            R.id.btn_ques_characteristic -> {

                btn_ques_ui.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_func.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_experience.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_characteristic.background =
                    getDrawable(R.drawable.person_module_shape_btn_blue)
                btn_ques_other.background = getDrawable(R.drawable.person_module_shape_btn_gray)

                btn_ques_ui.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_func.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_experience.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_characteristic.setTextColor(resources.getColor(R.color.white))
                btn_ques_other.setTextColor(resources.getColor(R.color.person_module_black_3))
                questionCode = 4
            }
            R.id.btn_ques_other -> {

                btn_ques_ui.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_func.background = getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_experience.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_characteristic.background =
                    getDrawable(R.drawable.person_module_shape_btn_gray)
                btn_ques_other.background = getDrawable(R.drawable.person_module_shape_btn_blue)

                btn_ques_ui.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_func.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_experience.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_characteristic.setTextColor(resources.getColor(R.color.person_module_black_3))
                btn_ques_other.setTextColor(resources.getColor(R.color.white))
                questionCode = 5
            }
            R.id.btn_feedback_submit -> {
                checkData()
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_IMAGE) {
            val picPaths: List<ImageBean> =
                data?.getParcelableArrayListExtra(ImagePicker.INTENT_RESULT_DATA)!!

            for (element in picPaths) {
                var pic = PicBean()
                pic.filePath = element.imagePath
                pics.add(pic)
            }
            itemPicAdater.notifyDataSetChanged()
        }
    }
}