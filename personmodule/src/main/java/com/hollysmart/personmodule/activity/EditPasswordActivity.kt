package com.hollysmart.personmodule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.hollysmart.personmodule.R

/**
 * 修改密码页面
 */
class EditPasswordActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var iv_back: ImageView
    lateinit var edt_old_passw: EditText
    lateinit var edt_new_passw: EditText
    lateinit var edt_new_passw_confirm: EditText
    lateinit var btn_repassw_submit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_module_activity_edit_password)
        findView()
    }

    private fun findView() {
        iv_back = findViewById(R.id.iv_back)
        edt_old_passw = findViewById(R.id.edt_old_passw)
        edt_new_passw = findViewById(R.id.edt_new_passw)
        edt_new_passw_confirm = findViewById(R.id.edt_new_passw_confirm)
        btn_repassw_submit = findViewById(R.id.btn_repassw_submit)
        iv_back.setOnClickListener(this)
        btn_repassw_submit.setOnClickListener(this)
    }

    /**
     * 验证密码输入是否符合规则
     */
    private fun checkInputField(): Boolean {
        if (TextUtils.isEmpty(edt_old_passw.getText())) {
            showToast(getString(R.string.person_module_input_old_password))
            return false
        }
        if (TextUtils.isEmpty(edt_new_passw.getText())) {
            showToast(getString(R.string.person_module_input_new_password))
            return false
        }

        //新密码为：6-10位字母加数字组合密码
        if (!edt_new_passw.getText().toString()
                .matches(Regex("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$"))
        ) {
            showToast(getString(R.string.person_module_password_regex))
            return false
        }
        if (TextUtils.isEmpty(edt_new_passw_confirm.getText())) {
            showToast(getString(R.string.person_module_input_confirm_new_password))

            return false
        }

        //确认密码为：6-10位字母加数字组合密码
        if (!edt_new_passw_confirm.getText().toString()
                .matches(Regex("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$"))
        ) {
            showToast(getString(R.string.person_module_confirm_password_regex))

            return false
        }
        if (edt_new_passw.getText().toString() != edt_new_passw_confirm.getText().toString()) {
            showToast(getString(R.string.person_module_confirm_password_error))

            return false
        }
        if (edt_old_passw.getText().toString() == edt_new_passw.getText().toString()) {
            showToast(
                getString(R.string.person_module_new_password_is_equal_old_password),
            )
            return false
        }
        return true
    }


    /**
     * 提交
     */
    private fun submit() {
        if (!checkInputField()) {
            return
        }

    }

    private fun showToast(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.btn_repassw_submit -> {
                submit()
            }
        }
    }
}