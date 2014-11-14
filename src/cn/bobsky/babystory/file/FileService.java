package cn.bobsky.babystory.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;

public class FileService {
	private Context context;

	public FileService() {
		// TODO 自动生成的构造函数存根
	}

	public FileService(Context context) {
		this.context = context;
	}

	/**
	 * @param fileName
	 *            文件名
	 * @param content
	 *            需要存储的内容
	 * @return
	 */
	public boolean saveStringToSDcard(String fileName, String dir,
			String content) {
		boolean flag = false;
		FileOutputStream fileOutputStream = null;
		// 获得sd所在路径
		File file = new File(FileUtils.getAppDir() + fileName);

		// 判断SD卡是否可用
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			try {

				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(content.getBytes());
				flag = true;
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (!(fileOutputStream == null)) {
					try {
						fileOutputStream.close();

					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}

		return flag;
	}

	/**
	 * @param dir
	 *            文件夹
	 * @param fileName
	 *            文件名
	 * @return 以字符串的形式返回文件内容
	 */
	public String getStringFromSDcardFile(String dir, String fileName) {
		// 文件输入流
		FileInputStream fileInputStream = null;
		// 设置缓冲输出流
		ByteArrayOutputStream byteArrayOutputStream = null;
		File file = new File(dir + fileName);
		int len = 0;
		byte[] buffer = new byte[1024];
		try {
			fileInputStream = new FileInputStream(file);
			byteArrayOutputStream = new ByteArrayOutputStream();
			if ((len = fileInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, len);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}

		return new String(byteArrayOutputStream.toByteArray());

	}

	/**
	 * 从项目raw文件夹下面拷贝文件到手机sd上面
	 * 
	 * @param fileName
	 *            拷贝到sd卡上后的文件名
	 * @param dir
	 *            目录名，必须以反斜杠"/"结束
	 * @param resource
	 *            文件在项目中的id 如R.raw.xxx
	 * @return
	 */
	public boolean copyRawFileToSDcard(String fileName, String sdCarddir,
			int resource) {
		boolean flag = false;
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		// 获得sd所在路径
		File file = new File(sdCarddir, fileName);

		// 判断SD卡是否可用
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			try {
				int len = 0;
				byte[] buffer = new byte[1024];
				inputStream = context.getResources().openRawResource(resource);
				fileOutputStream = new FileOutputStream(file);
				while ((len = inputStream.read(buffer)) != -1) {
					fileOutputStream.write(buffer, 0, len);
				}
				flag = true;
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if (!(fileOutputStream == null)) {
					try {
						fileOutputStream.close();

					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}

		return flag;
	}

}
