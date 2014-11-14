package cn.bobsky.babystory.utils;

import android.R.string;

public final class AppConstants {

	// preference
	public static final String PREF_NAME = "MyPreFiles";

	public static final String PREF_KEY_FIRST_USE = "is_the _first";
	public static final String PREF_KEY_BIRTH_DAY = "baby_birth_day";

	// file and dir
	public static final String APP_DIR = "BabyStory";
	public static final String APP_DB_DIR = "DB";
	public static final String APP_MUSIC_DIR = "Music";
	public static final String APP_IMG_DIR = "Images";

	// DB
	public static final String DB_FILE_NAME = "db.db";

	// DB TABLE NAME
	public static final String DB_TABLE_STORY = "story";
	public static final String DB_TABLE_MUSIC = "music";
	public static final String DB_TABLE_MUSIC_MONTH = "music_month";
	public static final String DB_TABLE_FETUS_MUSIC = "fetus_music";
	
	public static final String DB_TABLE_REMIND_DAY = "remind_day";
	public static final String DB_TABLE_REMIND_COLUMN = "remind_column";
	
	// DB COLUMN NAME
	public static final String TABLE_STORY_ID = "id";
	public static final String TABLE_STORY_NAME = "story_name";
	public static final String TABLE_STORY_CONTENT = "story_content";
	public static final String TABLE_STORY_FAVORITE = "is_favorite";
	
	public static final String TABLE_MUSIC_ID = "id";
	public static final String TABLE_MUSIC_NAME = "music_name";
	public static final String TABLE_MUSIC_DESCRIPTION = "music_description";
	public static final String TABLE_MUSIC_URL = "music_url";
	public static final String TABLE_MUSIC_URI = "music_uri";
	public static final String TABLE_MUSIC_FAVORITE = "music_favorite";
	public static final String TABLE_MUSIC_MONTH = "music_month";
	
	public static final String TABLE_MUSIC_MONTH_ID = "id";
	public static final String TABLE_MUSIC_MONTH_DESCRIPTION = "month_description";
	
	public static final String TABLE_FETUS_ID = "id";
	public static final String TABLE_FETUS_NAME = "music_name";
	public static final String TABLE_FETUS_DESCRIPTION = "music_description";
	public static final String TABLE_FETUS_AUTHOR = "music_author";
	public static final String TABLE_FETUS_FILE_NAME = "file_name";
	public static final String TABLE_FETUS_FAVORITE = "is_favorite";
	
	public static final String TABLE_REMIND_COLUMN_ID = "id";
	public static final String TABLE_REMIND_COLUMN_NAME = "column_name";
	
	public static final String TABLE_REMIND_DAY_ID = "id";
	public static final String TABLE_REMIND_DAY_COLUMN_PREFIX = "column_";
	public static final int TABLE_REMIND_DAY_COLUMN_COUNT = 20;
	
	
	
	
	
	
	

}
