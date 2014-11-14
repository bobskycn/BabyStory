package cn.bobsky.babystory.file;

import java.io.File;

import cn.bobsky.babystory.utils.AppConstants;

import android.os.Environment;

public class FileUtils {

	public FileUtils() {

	}
	
	public static void makeAppDirs(){
		File file1 = new File(FileUtils.getAppDir());
		File file2 = new File(FileUtils.getDBDir());
		File file3 = new File(FileUtils.getImageDir());
		File file4 = new File(FileUtils.getMusicDir());
		
		if(!file1.exists()){
			file1.mkdir();
		}
		if(!file2.exists()){
			file2.mkdir();
		}
		if(!file3.exists()){
			file3.mkdir();
		}
		if(!file4.exists()){
			file4.mkdir();
		}
	}

	public static String getSDCardPath() {
		String sdCardPath = Environment.getExternalStorageDirectory()
				.getAbsolutePath()+File.separator;
		return sdCardPath;
	}

	public static String getAppDir() {
		String result = getSDCardPath() + AppConstants.APP_DIR
				+ File.separator;
		return result;
	}

	public static String getDBDir() {
		String result = getAppDir() + AppConstants.APP_DB_DIR + File.separator;
		return result;
	}

	public static String getImageDir() {
		String result = getAppDir() + AppConstants.APP_IMG_DIR + File.separator;
		return result;
	}

	public static String getMusicDir(){
		String result = getAppDir()+AppConstants.APP_MUSIC_DIR+File.separator;
		return result;
	}
}
