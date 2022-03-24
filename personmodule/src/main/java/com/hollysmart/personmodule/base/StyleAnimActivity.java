package com.hollysmart.personmodule.base;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.hollysmart.personmodule.R;


/**
 * 实现activity退出是的动画效果
 * intent.putExtra("animType",1);
 * animType 1：上退出 、2：下退出 、3：左退出 、4：右退出 、5：中间缩回退出 、6：左退出 350ms、7：右退出 350ms。
 * @author caipc
 */
public abstract class StyleAnimActivity extends PersonModuleBaseActivity {
	public int animType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			animType = savedInstanceState.getInt("animType");
		}

		animType = getIntent().getIntExtra("animType", 0);
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatus(true);
			SystemBarTintManager tintManager = new SystemBarTintManager(this);
			tintManager.setStatusBarTintEnabled(true);
			tintManager.setStatusBarTintResource(R.color.person_module_colorPrimary);//状态栏所需颜色

		}
	}
	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}


	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		animEnter(intent.getIntExtra("animType", 0));
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		super.startActivityForResult(intent, requestCode);
		animEnter(intent.getIntExtra("animType", 0));
	}

	@Override
	public void finish() {
		super.finish();
		animExit();
	}
	private void animEnter(int animType){

		switch (animType) {
		case 1:
			overridePendingTransition(R.anim.person_module_activity_enter_shang, R.anim.person_module_activity_yuandian);
			break;
		case 2:
			overridePendingTransition(R.anim.person_module_activity_enter_xia, R.anim.person_module_activity_yuandian);
			break;
		case 3:
			overridePendingTransition(R.anim.person_module_activity_enter_left, R.anim.person_module_activity_yuandian);
			break;
		case 4:
			overridePendingTransition(R.anim.person_module_activity_enter_right, R.anim.person_module_activity_yuandian);
			break;
		case 5:
			overridePendingTransition(R.anim.person_module_activity_enter_soufang, R.anim.person_module_activity_yuandian);
			break;
		case 6:
			overridePendingTransition(R.anim.person_module_activity_enter_long_left, R.anim.person_module_activity_yuandian);
			break;
		case 7:
			overridePendingTransition(R.anim.person_module_activity_enter_long_right, R.anim.person_module_activity_yuandian);
			break;
		}
	}

	private void animExit(){
		switch (animType) {
		case 1:
			overridePendingTransition(R.anim.person_module_activity_yuandian, R.anim.person_module_activity_exit_shang);
			break;
		case 2:
			overridePendingTransition(R.anim.person_module_activity_yuandian, R.anim.person_module_activity_exit_xia);
			break;
		case 3:
			overridePendingTransition(R.anim.person_module_activity_yuandian, R.anim.person_module_activity_exit_left);
			break;
		case 4:
			overridePendingTransition(R.anim.person_module_activity_yuandian, R.anim.person_module_activity_exit_right);
			break;
		case 5:
			overridePendingTransition(R.anim.person_module_activity_yuandian, R.anim.person_module_activity_exit_soufang);
			break;
		case 6:
			overridePendingTransition(R.anim.person_module_activity_yuandian, R.anim.person_module_activity_exit_long_left);
			break;
		case 7:
			overridePendingTransition(R.anim.person_module_activity_yuandian, R.anim.person_module_activity_exit_long_right);
			break;
		}
	}



	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		animExit();
	}
}
