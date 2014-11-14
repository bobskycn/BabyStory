package cn.bobsky.babystory.activity;

import java.io.File;

import cn.bobsky.babystory.R;
import cn.bobsky.babystory.R.id;
import cn.bobsky.babystory.R.layout;
import cn.bobsky.babystory.R.menu;
import cn.bobsky.babystory.file.FileService;
import cn.bobsky.babystory.file.FileUtils;
import cn.bobsky.babystory.utils.AppConstants;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class SplashActivity extends ActionBarActivity {

	private boolean isTheFirstTimeUse;
	private FileService fileService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		// 创建sd上面的目录
		FileUtils.makeAppDirs();

		// 拷贝默认数据库到SD中DreamDict目录中
		File file = new File(FileUtils.getAppDir() + AppConstants.DB_FILE_NAME);
		if (!file.exists()) {
			fileService = new FileService(this);
			fileService.copyRawFileToSDcard(AppConstants.DB_FILE_NAME,
					FileUtils.getDBDir(), R.raw.db);
		}

		// 取出key_IsTheFirstTimeUse值判断是否是第一次使用。
		isTheFirstTimeUse = getSharedPreferences(AppConstants.PREF_NAME, 0)
				.getBoolean(AppConstants.PREF_KEY_FIRST_USE, true);

		if (!isTheFirstTimeUse) {
			String birthDayStr = getSharedPreferences(AppConstants.PREF_NAME, 0)
					.getString(AppConstants.PREF_KEY_BIRTH_DAY, "");
			if ("".equalsIgnoreCase(birthDayStr)) {
				goToDateSettingActivity();

			} else {
				goToMainActivity();
			}

		} else {

			// 第一次使用后，设置key_IsTheFirstTimeUse为否。
			SharedPreferences initSetting = getSharedPreferences(
					AppConstants.DB_FILE_NAME, 0);
			SharedPreferences.Editor editor = initSetting.edit();
			editor.putBoolean(AppConstants.PREF_KEY_FIRST_USE, false);
			editor.commit();

			goToDateSettingActivity();
			
			// 页面控件viewPager的一些代码

			// viewPager = (ViewPager) this.findViewById(R.id.viewPages);
			// // pagerTitleStrip = (PagerTitleStrip) this
			// // .findViewById(R.id.pagetitle);
			// viewPager.setAdapter(new SplashAdapter(this));

			// if (savedInstanceState == null) {
			// getSupportFragmentManager().beginTransaction()
			// .add(R.id.container, new PlaceholderFragment())
			// .commit();
			// }
			
		}

	}

	private void goToMainActivity() {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}

		}, 1500);
	}

	private void goToDateSettingActivity() {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this,
						DateSettingActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}

		}, 1500);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_splash,
					container, false);
			return rootView;
		}
	}
}
